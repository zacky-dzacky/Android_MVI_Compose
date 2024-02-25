plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "${Config.namespace}.base_component"
    compileSdk = Config.compiledSDK

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Dependency.Proguard.CONSUMER_RULES)
    }

    buildTypes {
        release {
            isMinifyEnabled = Config.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(Dependency.Proguard.ANDROID_OPTIMIZED),
                Dependency.Proguard.PROGUARD_RULES
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    val composeBom = platform(Dependency.ComposeLibrary.COMPOSE_BOM)

    api(Dependency.ComposeLibrary.COMPOSE_MATERIAL_3)
    api(Dependency.ComposeLibrary.COMPOSE_ACTIVITY)
    api(composeBom)
    api(Dependency.ComposeLibrary.COMPOSE_UI)
    api(Dependency.ComposeLibrary.COMPOSE_UI_GRAPHIC)
    api(Dependency.ComposeLibrary.COMPOSE_UI_TOOLING_PREVIEW)
    api(Dependency.ComposeLibrary.COMPOSE_MATERIAL_ICON_EXTENDED)
    androidTestApi(composeBom)
    debugImplementation(Dependency.ComposeLibrary.COMPOSE_UI_TOOLING)
    androidTestApi(Dependency.ComposeLibrary.COMPOSE_UI_TEST_JUNIT)
    debugApi(Dependency.ComposeLibrary.COMPOSE_UI_TEST_MANIFEST)
}