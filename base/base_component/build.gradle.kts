plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "id.syarief.base.base_component"
    compileSdk = Config.compiledSDK

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.5.0")
    val composeBom = platform(Dependency.ComposeLibrary.COMPOSE_BOM)
    api(composeBom)
    androidTestImplementation(composeBom)

    // Choose one of the following:
    // Material Design 3
    api(Dependency.ComposeLibrary.COMPOSE_MATERIAL_3)
    // or Material Design 2
    api(Dependency.ComposeLibrary.COMPOSE_MATERIAL_2)
    // or skip Material Design and build directly on top of foundational components
    api(Dependency.ComposeLibrary.COMPOSE_FOUNDATION)
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    api(Dependency.ComposeLibrary.COMPOSE_UI)

    // Android Studio Preview support
    api("androidx.compose.ui:ui-tooling-preview")
    debugApi("androidx.compose.ui:ui-tooling")

    // UI Tests
    androidTestApi("androidx.compose.ui:ui-test-junit4")
    debugApi("androidx.compose.ui:ui-test-manifest")

    // Optional - Included automatically by material, only add when you need
    // the icons but not the material library (e.g. when using Material3 or a
    // custom design system based on Foundation)
    api("androidx.compose.material:material-icons-core")
    // Optional - Add full set of material icons
    api("androidx.compose.material:material-icons-extended")
    // Optional - Add window size utils
    api("androidx.compose.material3:material3-window-size-class")

    // Optional - Integration with activities
    api("androidx.activity:activity-compose:1.6.1")
    // Optional - Integration with ViewModels
    api("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    // Optional - Integration with LiveData
    api("androidx.compose.runtime:runtime-livedata")
    // Optional - Integration with RxJava
    api("androidx.compose.runtime:runtime-rxjava2")

    debugApi("androidx.compose.ui:ui-tooling:1.4.2")
    api("androidx.compose.ui:ui-tooling-preview:1.4.2")
}