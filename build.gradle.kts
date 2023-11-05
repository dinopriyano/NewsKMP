// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.compose.multiplatform) apply false
  alias(libs.plugins.kotlin.native.cocoapods) apply false
  alias(libs.plugins.moko.resources) apply false
}

buildscript {
  dependencies {
    classpath(libs.moko.resources.generator)
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
true // Needed to make the Suppress annotation work for the plugins block