plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "${Config.namespace}.base_api"
    compileSdk = Config.compiledSDK

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

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

    api(Dependency.CoreLibrary.KTX)
    api(Dependency.APILibrary.KTOR_CORE)
    api(Dependency.APILibrary.KTOR_ANDROID)
    api(Dependency.APILibrary.KTOR_SERIALIZATION)
    api(Dependency.APILibrary.KTOR_LOGGING)
    api("io.ktor:ktor-client-content-negotiation:2.1.3")
    api("com.google.code.gson:gson:2.8.9")
    api("io.insert-koin:koin-ktor:3.1.5")

    api("com.google.code.gson:gson:2.8.9")
    testImplementation(Dependency.TestLibrary.JUNIT)
    androidTestImplementation(Dependency.TestLibrary.EXT_JUNIT)
    androidTestImplementation(Dependency.TestLibrary.ESPRESSO_CORE)
}