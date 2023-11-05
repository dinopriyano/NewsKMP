@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose.multiplatform)
}

kotlin {
  jvm {
    jvmToolchain(17)
    withJava()
  }

  sourceSets {
    val jvmMain by getting {
      dependencies {
        implementation(project(":common"))
        implementation(compose.desktop.common)
        implementation(compose.desktop.currentOs)
        implementation(libs.koin.compose)
      }
      configurations.all {
        // some dependencies contains it, this causes an exception to initialize the Main dispatcher in desktop for image loader
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-android")
      }
    }

    val jvmTest by getting
  }
}

compose.desktop {
  application {
    mainClass = "MainKt"
    nativeDistributions {
      targetFormats(
        org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
        org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
        org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
      )
      packageName = "NewsKMP"
      packageVersion = "1.0.0"
    }
  }
}