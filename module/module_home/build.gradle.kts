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
    implementation(Dependency.ImageLibrary.GLIDE)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta07")
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")
    importUnitTest()
}