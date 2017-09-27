/*
 * Copyright 2012-present Facebook, Inc.
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

package com.facebook.buck.android;

import com.facebook.buck.android.apkmodule.APKModule;
import com.facebook.buck.io.BuildCellRelativePath;
import com.facebook.buck.io.filesystem.ProjectFilesystem;
import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.model.BuildTargets;
import com.facebook.buck.rules.AbstractBuildRuleWithDeclaredAndExtraDeps;
import com.facebook.buck.rules.BuildContext;
import com.facebook.buck.rules.BuildRuleParams;
import com.facebook.buck.rules.BuildableContext;
import com.facebook.buck.rules.ExplicitBuildTargetSourcePath;
import com.facebook.buck.rules.SourcePath;
import com.facebook.buck.step.Step;
import com.facebook.buck.step.fs.MkdirStep;
import com.facebook.buck.util.MoreCollectors;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.Optional;

public class AndroidAppModularity extends AbstractBuildRuleWithDeclaredAndExtraDeps {

  protected final AndroidAppModularityGraphEnhancementResult result;

  AndroidAppModularity(
      BuildTarget buildTarget,
      ProjectFilesystem projectFilesystem,
      BuildRuleParams params,
      AndroidAppModularityGraphEnhancementResult result) {
    super(buildTarget, projectFilesystem, params);
    this.result = result;
  }

  @Override
  public ImmutableList<Step> getBuildSteps(
      BuildContext buildContext, BuildableContext buildableContext) {
    ImmutableList.Builder<Step> steps = ImmutableList.builder();

    Path metadataFile =
        buildContext.getSourcePathResolver().getRelativePath(getSourcePathToOutput());

    steps.add(
        MkdirStep.of(
            BuildCellRelativePath.fromCellRelativePath(
                buildContext.getBuildCellRootPath(),
                getProjectFilesystem(),
                metadataFile.getParent())));

    ImmutableMultimap.Builder<APKModule, Path> additionalDexStoreToJarPathMapBuilder =
        ImmutableMultimap.builder();
    additionalDexStoreToJarPathMapBuilder.putAll(
        result
            .getPackageableCollection()
            .getModuleMappedClasspathEntriesToDex()
            .entries()
            .stream()
            .map(
                input ->
                    new AbstractMap.SimpleEntry<>(
                        input.getKey(),
                        getProjectFilesystem()
                            .relativize(
                                buildContext
                                    .getSourcePathResolver()
                                    .getAbsolutePath(input.getValue()))))
            .collect(MoreCollectors.toImmutableSet()));
    ImmutableMultimap<APKModule, Path> additionalDexStoreToJarPathMap =
        additionalDexStoreToJarPathMapBuilder.build();

    steps.add(
        WriteAppModuleMetadataStep.writeModuleMetadata(
            metadataFile,
            additionalDexStoreToJarPathMap,
            getProjectFilesystem(),
            Optional.empty(),
            Optional.empty(),
            /*skipProguard*/ true));

    buildableContext.recordArtifact(metadataFile);

    return steps.build();
  }

  @Override
  public SourcePath getSourcePathToOutput() {
    return new ExplicitBuildTargetSourcePath(
        getBuildTarget(),
        BuildTargets.getGenPath(getProjectFilesystem(), getBuildTarget(), "%s/modulemetadata.txt"));
  }
}
