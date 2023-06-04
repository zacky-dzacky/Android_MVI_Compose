plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Config.namespace
    compileSdk = Config.compiledSDK

    defaultConfig {
        applicationId = Config.applicationID
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = Config.isMinifyEnabled
            proguardFiles(getDefaultProguardFile(Dependency.Proguard.ANDROID_OPTIMIZED), Dependency.Proguard.PROGUARD_RULES)
        }
        debug {
            isMinifyEnabled = Config.isMinifyEnabled
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility =  JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget

    }
    dynamicFeatures += setOf(
        Module.MODULE_CONTACT,
        Module.MODULE_HOME,
        Module.MODULE_DETAIL,
        Module.MODULE_LOGIN
    )
}

dependencies {
    implementation(Dependency.CoreLibrary.KTX)
    implementation(Dependency.CoreLibrary.SPLASH_SCREEN)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//    implementation(project(":base:base_component"))

    val composeBom = platform(Dependency.ComposeLibrary.COMPOSE_BOM)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Choose one of the following:
    // Material Design 3
    implementation(Dependency.ComposeLibrary.COMPOSE_MATERIAL_3)
    // or Material Design 2
    implementation(Dependency.ComposeLibrary.COMPOSE_MATERIAL_2)
    // or skip Material Design and build directly on top of foundational components
    implementation(Dependency.ComposeLibrary.COMPOSE_FOUNDATION)
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation(Dependency.ComposeLibrary.COMPOSE_UI)

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Optional - Included automatically by material, only add when you need
    // the icons but not the material library (e.g. when using Material3 or a
    // custom design system based on Foundation)
    implementation("androidx.compose.material:material-icons-core")
    // Optional - Add full set of material icons
    implementation("androidx.compose.material:material-icons-extended")
    // Optional - Add window size utils
    implementation("androidx.compose.material3:material3-window-size-class")

    // Optional - Integration with activities
    implementation("androidx.activity:activity-compose:1.6.1")
    // Optional - Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    // Optional - Integration with LiveData
    implementation("androidx.compose.runtime:runtime-livedata")
    // Optional - Integration with RxJava
    implementation("androidx.compose.runtime:runtime-rxjava2")

    debugImplementation("androidx.compose.ui:ui-tooling:1.4.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.2")
}