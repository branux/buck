/*
 * Copyright 2013-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.cxx;

import com.facebook.buck.python.PythonPackageComponents;
import com.facebook.buck.rules.BuildRule;
import com.facebook.buck.rules.BuildRuleParams;
import com.facebook.buck.rules.BuildRuleResolver;
import com.facebook.buck.rules.BuildTargetSourcePath;
import com.facebook.buck.rules.SourcePath;
import com.facebook.buck.rules.SourcePathResolver;
import com.facebook.buck.rules.SymlinkTree;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * An action graph representation of a C/C++ library from the target graph, providing the
 * various interfaces to make it consumable by C/C++ preprocessing and native linkable rules.
 */
public class CxxLibrary extends AbstractCxxLibrary {

  private final BuildRuleParams params;
  private final BuildRuleResolver ruleResolver;
  private final ImmutableMultimap<CxxSource.Type, String> exportedPreprocessorFlags;
  private final ImmutableMap<Path, SourcePath> headers;
  private final boolean linkWhole;
  private final Optional<String> soname;

  public CxxLibrary(
      BuildRuleParams params,
      BuildRuleResolver ruleResolver,
      SourcePathResolver pathResolver,
      ImmutableMultimap<CxxSource.Type, String> exportedPreprocessorFlags,
      ImmutableMap<Path, SourcePath> headers,
      boolean linkWhole,
      Optional<String> soname) {
    super(params, pathResolver);
    this.params = Preconditions.checkNotNull(params);
    this.ruleResolver = Preconditions.checkNotNull(ruleResolver);
    this.exportedPreprocessorFlags = Preconditions.checkNotNull(exportedPreprocessorFlags);
    this.headers = Preconditions.checkNotNull(headers);
    this.linkWhole = linkWhole;
    this.soname = Preconditions.checkNotNull(soname);
  }

  @Override
  public CxxPreprocessorInput getCxxPreprocessorInput() {
    BuildRule rule = CxxDescriptionEnhancer.requireBuildRule(
        params,
        ruleResolver,
        CxxDescriptionEnhancer.HEADER_SYMLINK_TREE_FLAVOR);
    Preconditions.checkState(rule instanceof SymlinkTree);
    SymlinkTree symlinkTree = (SymlinkTree) rule;
    return CxxPreprocessorInput.builder()
        .setRules(ImmutableSet.of(symlinkTree.getBuildTarget()))
        .setPreprocessorFlags(exportedPreprocessorFlags)
        .setIncludes(headers)
        .setIncludeRoots(ImmutableList.of(symlinkTree.getRoot()))
        .build();
  }

  @Override
  public NativeLinkableInput getNativeLinkableInput(
      Linker linker,
      Type type) {

    // Build up the arguments used to link this library.  If we're linking the
    // whole archive, wrap the library argument in the necessary "ld" flags.
    final BuildRule libraryRule;
    ImmutableList.Builder<String> linkerArgsBuilder = ImmutableList.builder();
    if (type == Type.SHARED) {
      Path sharedLibraryPath = CxxDescriptionEnhancer.getSharedLibraryPath(getBuildTarget());
      libraryRule = CxxDescriptionEnhancer.requireBuildRule(
          params,
          ruleResolver,
          CxxDescriptionEnhancer.SHARED_FLAVOR);
      linkerArgsBuilder.add(sharedLibraryPath.toString());
    } else {
      libraryRule = CxxDescriptionEnhancer.requireBuildRule(
          params,
          ruleResolver,
          CxxDescriptionEnhancer.STATIC_FLAVOR);
      Path staticLibraryPath = CxxDescriptionEnhancer.getStaticLibraryPath(getBuildTarget());
      if (linkWhole) {
        linkerArgsBuilder.addAll(linker.linkWhole(staticLibraryPath.toString()));
      } else {
        linkerArgsBuilder.add(staticLibraryPath.toString());
      }
    }
    final ImmutableList<String> linkerArgs = linkerArgsBuilder.build();

    return new NativeLinkableInput(
        ImmutableList.<SourcePath>of(new BuildTargetSourcePath(libraryRule.getBuildTarget())),
        linkerArgs);
  }

  @Override
  public PythonPackageComponents getPythonPackageComponents() {
    String sharedLibrarySoname =
        soname.or(CxxDescriptionEnhancer.getSharedLibrarySoname(getBuildTarget()));
    BuildRule sharedLibraryBuildRule = CxxDescriptionEnhancer.requireBuildRule(
        params,
        ruleResolver,
        CxxDescriptionEnhancer.SHARED_FLAVOR);
    return new PythonPackageComponents(
        /* modules */ ImmutableMap.<Path, SourcePath>of(),
        /* resources */ ImmutableMap.<Path, SourcePath>of(),
        /* nativeLibraries */ ImmutableMap.<Path, SourcePath>of(
            Paths.get(sharedLibrarySoname),
            new BuildTargetSourcePath(sharedLibraryBuildRule.getBuildTarget())));
  }

}
