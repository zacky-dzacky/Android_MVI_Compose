plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "${Config.namespace}.service_profile"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {
    implementation(Dependency.KoinLibrary.koinAndroid)
    implementation(Dependency.KoinLibrary.koinAndroidxCompose)
    importBaseAPI()
    importUnitTest()
    importAndroidTest()
}