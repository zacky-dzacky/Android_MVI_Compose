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
    api(baseHelper)
    api(baseComponent)
    implementation(baseApi)
    implementation(serviceList)
    implementation(serviceProfile)
    implementation(Dependency.CoreLibrary.KTX)
    implementation(Dependency.CoreLibrary.SPLASH_SCREEN)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(Dependency.KoinLibrary.koinAndroid)
    implementation(Dependency.KoinLibrary.koinAndroidxCompose)
}