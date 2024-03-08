plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "${Config.namespace}.module_home"
    compileSdk = Config.compiledSDK

    defaultConfig {
        minSdk = Config.minSdk
        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility =  JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
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
}

dependencies {
    implementation(app)
    implementation(baseComponent)
    implementation(baseMvi)
    implementation(serviceProfile)
    implementation(serviceList)
    implementation(Dependency.KoinLibrary.koinAndroid)
    implementation(Dependency.KoinLibrary.koinAndroidxCompose)
    implementation(Dependency.ComposeLibrary.COMPOSE_VIEW_MODEL)
    implementation(Dependency.CoreLibrary.KTX)
    implementation(Dependency.Android.activityCompose)
    implementation(Dependency.Android.navigationCompose)
    importUnitTest()
}