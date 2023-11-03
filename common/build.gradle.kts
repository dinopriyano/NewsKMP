@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose.multiplatform)
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
//  iosX64()
//  iosArm64()
//  iosSimulatorArm64()

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