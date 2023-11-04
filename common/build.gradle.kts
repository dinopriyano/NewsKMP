@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose.multiplatform)
  alias(libs.plugins.kotlin.native.cocoapods)
}

kotlin {
  // Targets
  android {
    compilations.all {
      kotlinOptions {
        jvmTarget = "1.8"
      }
    }
  }
  jvm("desktop") {
    jvmToolchain(17)
  }
  iosX64()
  iosArm64()
  iosSimulatorArm64()

  cocoapods {
    summary = "Common"
    homepage = "https://github.com/dinopriyano/NewsKMP"
    version = "1.0"
    ios.deploymentTarget = "14.1"
    podfile = project.file("../ios/Podfile")
    framework {
      baseName = "Common"
      isStatic = true
    }
  }

  // Platform-specific dependencies
  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(compose.material)
        implementation(compose.material3)
      }
    }

    val androidMain by getting {
      dependencies {
        // Android specific dependencies
      }
    }

    val desktopMain by getting {
      dependencies {
        // Desktop specific dependencies
      }
    }

    val iosX64Main by getting
    val iosArm64Main by getting
    val iosSimulatorArm64Main by getting
    val iosMain by creating {
      dependsOn(commonMain)
      iosX64Main.dependsOn(this)
      iosArm64Main.dependsOn(this)
      iosSimulatorArm64Main.dependsOn(this)
      dependencies {
        // iOS specific dependencies
      }
    }
  }
}

android {
  namespace = "com.dino.newskmp.app.common"
  compileSdk = 34

  defaultConfig {
    minSdk = 24

    compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
    }
  }
}