/*
 * Copyright 2015-present Facebook, Inc.
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

import com.facebook.buck.android.aapt.MergeAndroidResourceSources;
import com.facebook.buck.android.apkmodule.APKModule;
import com.facebook.buck.android.apkmodule.APKModuleGraph;
import com.facebook.buck.android.exopackage.ExopackageMode;
import com.facebook.buck.android.packageable.AndroidPackageableCollection;
import com.facebook.buck.android.packageable.AndroidPackageableCollector;
import com.facebook.buck.android.toolchain.NdkCxxPlatformsProvider;
import com.facebook.buck.cxx.toolchain.CxxBuckConfig;
import com.facebook.buck.io.filesystem.ProjectFilesystem;
import com.facebook.buck.jvm.core.JavaLibrary;
import com.facebook.buck.jvm.java.JavaBuckConfig;
import com.facebook.buck.jvm.java.JavacFactory;
import com.facebook.buck.jvm.java.JavacOptions;
import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.model.Flavor;
import com.facebook.buck.model.InternalFlavor;
import com.facebook.buck.rules.BuildRule;
import com.facebook.buck.rules.BuildRuleParams;
import com.facebook.buck.rules.BuildRuleResolver;
import com.facebook.buck.rules.BuildRules;
import com.facebook.buck.rules.CellPathResolver;
import com.facebook.buck.rules.Description;
import com.facebook.buck.rules.SourcePath;
import com.facebook.buck.rules.SourcePathRuleFinder;
import com.facebook.buck.rules.TargetGraph;
import com.facebook.buck.rules.coercer.BuildConfigFields;
import com.facebook.buck.toolchain.ToolchainProvider;
import com.facebook.buck.util.HumanReadableException;
import com.facebook.buck.util.immutables.BuckStyleImmutable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import java.util.EnumSet;
import java.util.Optional;
import java.util.stream.Collectors;
import org.immutables.value.Value;

/**
 * Description for a {@link BuildRule} that generates an {@code .aar} file.
 *
 * <p>This represents an Android Library Project packaged as an {@code .aar} bundle as specified by:
 * <a> http://tools.android.com/tech-docs/new-build-system/aar-format</a>.
 *
 * <p>Note that the {@code aar} may be specified as a {@link SourcePath}, so it could be either a
 * binary {@code .aar} file checked into version control, or a zip file that conforms to the {@code
 * .aar} specification that is generated by another build rule.
 */
public class AndroidAarDescription implements Description<AndroidAarDescriptionArg> {

  private static final Flavor AAR_ANDROID_MANIFEST_FLAVOR =
      InternalFlavor.of("aar_android_manifest");
  private static final Flavor AAR_ASSEMBLE_RESOURCE_FLAVOR =
      InternalFlavor.of("aar_assemble_resource");
  private static final Flavor AAR_ASSEMBLE_ASSETS_FLAVOR = InternalFlavor.of("aar_assemble_assets");
  private static final Flavor AAR_ANDROID_RESOURCE_FLAVOR =
      InternalFlavor.of("aar_android_resource");

  private final ToolchainProvider toolchainProvider;
  private final AndroidManifestDescription androidManifestDescription;
  private final CxxBuckConfig cxxBuckConfig;
  private final JavaBuckConfig javaBuckConfig;
  private final JavacOptions javacOptions;

  public AndroidAarDescription(
      ToolchainProvider toolchainProvider,
      AndroidManifestDescription androidManifestDescription,
      CxxBuckConfig cxxBuckConfig,
      JavaBuckConfig javaBuckConfig,
      JavacOptions javacOptions) {
    this.toolchainProvider = toolchainProvider;
    this.androidManifestDescription = androidManifestDescription;
    this.cxxBuckConfig = cxxBuckConfig;
    this.javaBuckConfig = javaBuckConfig;
    this.javacOptions = javacOptions;
  }

  @Override
  public Class<AndroidAarDescriptionArg> getConstructorArgType() {
    return AndroidAarDescriptionArg.class;
  }

  @Override
  public BuildRule createBuildRule(
      TargetGraph targetGraph,
      BuildTarget buildTarget,
      ProjectFilesystem projectFilesystem,
      BuildRuleParams originalBuildRuleParams,
      BuildRuleResolver resolver,
      CellPathResolver cellRoots,
      AndroidAarDescriptionArg args) {

    buildTarget.checkUnflavored();
    SourcePathRuleFinder ruleFinder = new SourcePathRuleFinder(resolver);
    ImmutableSortedSet.Builder<BuildRule> aarExtraDepsBuilder =
        new ImmutableSortedSet.Builder<BuildRule>(Ordering.natural())
            .addAll(originalBuildRuleParams.getExtraDeps().get());

    /* android_manifest */
    BuildTarget androidManifestTarget =
        buildTarget.withAppendedFlavors(AAR_ANDROID_MANIFEST_FLAVOR);

    AndroidManifestDescriptionArg androidManifestArgs =
        AndroidManifestDescriptionArg.builder()
            .setName(androidManifestTarget.getShortName())
            .setSkeleton(args.getManifestSkeleton())
            .setDeps(args.getDeps())
            .build();

    AndroidManifest manifest =
        androidManifestDescription.createBuildRule(
            targetGraph,
            androidManifestTarget,
            projectFilesystem,
            originalBuildRuleParams,
            resolver,
            cellRoots,
            androidManifestArgs);
    aarExtraDepsBuilder.add(resolver.addToIndex(manifest));

    final APKModuleGraph apkModuleGraph =
        new APKModuleGraph(targetGraph, buildTarget, Optional.empty());

    /* assemble dirs */
    AndroidPackageableCollector collector =
        new AndroidPackageableCollector(
            buildTarget,
            /* buildTargetsToExcludeFromDex */ ImmutableSet.of(),
            /* resourcesToExclude */ ImmutableSet.of(),
            apkModuleGraph);
    collector.addPackageables(
        AndroidPackageableCollector.getPackageableRules(originalBuildRuleParams.getBuildDeps()));
    AndroidPackageableCollection packageableCollection = collector.build();

    ImmutableCollection<SourcePath> assetsDirectories =
        packageableCollection.getAssetsDirectories();
    AssembleDirectories assembleAssetsDirectories =
        new AssembleDirectories(
            buildTarget.withAppendedFlavors(AAR_ASSEMBLE_ASSETS_FLAVOR),
            projectFilesystem,
            ruleFinder,
            assetsDirectories);
    aarExtraDepsBuilder.add(resolver.addToIndex(assembleAssetsDirectories));

    ImmutableCollection<SourcePath> resDirectories =
        packageableCollection.getResourceDetails().getResourceDirectories();
    MergeAndroidResourceSources assembleResourceDirectories =
        new MergeAndroidResourceSources(
            buildTarget.withAppendedFlavors(AAR_ASSEMBLE_RESOURCE_FLAVOR),
            projectFilesystem,
            ruleFinder,
            resDirectories);
    aarExtraDepsBuilder.add(resolver.addToIndex(assembleResourceDirectories));

    /* android_resource */
    BuildRuleParams androidResourceParams =
        originalBuildRuleParams
            .withDeclaredDeps(
                ImmutableSortedSet.of(
                    manifest, assembleAssetsDirectories, assembleResourceDirectories))
            .withoutExtraDeps();

    AndroidResource androidResource =
        new AndroidResource(
            buildTarget.withAppendedFlavors(AAR_ANDROID_RESOURCE_FLAVOR),
            projectFilesystem,
            androidResourceParams,
            ruleFinder,
            /* deps */ ImmutableSortedSet.<BuildRule>naturalOrder()
                .add(assembleAssetsDirectories)
                .add(assembleResourceDirectories)
                .addAll(originalBuildRuleParams.getDeclaredDeps().get())
                .build(),
            assembleResourceDirectories.getSourcePathToOutput(),
            /* resSrcs */ ImmutableSortedMap.of(),
            /* rDotJavaPackage */ null,
            assembleAssetsDirectories.getSourcePathToOutput(),
            /* assetsSrcs */ ImmutableSortedMap.of(),
            manifest.getSourcePathToOutput(),
            /* hasWhitelistedStrings */ false);
    aarExtraDepsBuilder.add(resolver.addToIndex(androidResource));

    ImmutableSortedSet.Builder<SourcePath> classpathToIncludeInAar =
        ImmutableSortedSet.naturalOrder();
    classpathToIncludeInAar.addAll(packageableCollection.getClasspathEntriesToDex());
    aarExtraDepsBuilder.addAll(
        BuildRules.toBuildRulesFor(
            buildTarget, resolver, packageableCollection.getJavaLibrariesToDex()));

    if (!args.getBuildConfigValues().getNameToField().isEmpty()
        && !args.getIncludeBuildConfigClass()) {
      throw new HumanReadableException(
          "Rule %s has build_config_values set but does not set "
              + "include_build_config_class to True. Either indicate you want to include the "
              + "BuildConfig class in the final .aar or do not specify build config values.",
          buildTarget);
    }
    if (args.getIncludeBuildConfigClass()) {
      ImmutableSortedSet<JavaLibrary> buildConfigRules =
          AndroidBinaryGraphEnhancer.addBuildConfigDeps(
              buildTarget,
              projectFilesystem,
              AndroidBinary.PackageType.RELEASE,
              EnumSet.noneOf(ExopackageMode.class),
              args.getBuildConfigValues(),
              Optional.empty(),
              resolver,
              JavacFactory.create(ruleFinder, javaBuckConfig, args),
              javacOptions,
              packageableCollection);
      buildConfigRules.forEach(resolver::addToIndex);
      aarExtraDepsBuilder.addAll(buildConfigRules);
      classpathToIncludeInAar.addAll(
          buildConfigRules
              .stream()
              .map(BuildRule::getSourcePathToOutput)
              .collect(Collectors.toList()));
    }

    NdkCxxPlatformsProvider ndkCxxPlatformsProvider =
        toolchainProvider.getByName(
            NdkCxxPlatformsProvider.DEFAULT_NAME, NdkCxxPlatformsProvider.class);

    /* native_libraries */
    AndroidNativeLibsPackageableGraphEnhancer packageableGraphEnhancer =
        new AndroidNativeLibsPackageableGraphEnhancer(
            resolver,
            buildTarget,
            projectFilesystem,
            originalBuildRuleParams,
            ndkCxxPlatformsProvider.getNdkCxxPlatforms(),
            ImmutableSet.of(),
            cxxBuckConfig,
            /* nativeLibraryMergeMap */ Optional.empty(),
            /* nativeLibraryMergeGlue */ Optional.empty(),
            Optional.empty(),
            AndroidBinary.RelinkerMode.DISABLED,
            ImmutableList.of(),
            apkModuleGraph);
    Optional<ImmutableMap<APKModule, CopyNativeLibraries>> nativeLibrariesOptional =
        packageableGraphEnhancer.enhance(packageableCollection).getCopyNativeLibraries();
    Optional<CopyNativeLibraries> rootModuleCopyNativeLibraries =
        nativeLibrariesOptional.map(
            input -> {
              // there will be only one value for the root module
              CopyNativeLibraries copyNativeLibraries =
                  input.get(apkModuleGraph.getRootAPKModule());
              if (copyNativeLibraries == null) {
                throw new HumanReadableException(
                    "Native libraries are present but not in the root application module.");
              }
              aarExtraDepsBuilder.add(copyNativeLibraries);
              return copyNativeLibraries;
            });
    Optional<SourcePath> assembledNativeLibsDir =
        rootModuleCopyNativeLibraries.map(cnl -> cnl.getSourcePathToNativeLibsDir());
    Optional<SourcePath> assembledNativeLibsAssetsDir =
        rootModuleCopyNativeLibraries.map(cnl -> cnl.getSourcePathToNativeLibsAssetsDir());
    BuildRuleParams androidAarParams =
        originalBuildRuleParams.withExtraDeps(aarExtraDepsBuilder.build());
    return new AndroidAar(
        buildTarget,
        projectFilesystem,
        androidAarParams,
        manifest,
        androidResource,
        assembleResourceDirectories.getSourcePathToOutput(),
        assembleAssetsDirectories.getSourcePathToOutput(),
        assembledNativeLibsDir,
        assembledNativeLibsAssetsDir,
        classpathToIncludeInAar.build());
  }

  @BuckStyleImmutable
  @Value.Immutable(copy = true)
  interface AbstractAndroidAarDescriptionArg extends AndroidLibraryDescription.CoreArg {
    SourcePath getManifestSkeleton();

    @Value.Default
    default BuildConfigFields getBuildConfigValues() {
      return BuildConfigFields.empty();
    }

    @Value.Default
    default Boolean getIncludeBuildConfigClass() {
      return false;
    }
  }
}
