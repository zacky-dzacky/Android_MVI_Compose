plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = Config.namespace
    compileSdk = Config.compiledSDK

    defaultConfig {
        minSdk = Config.minSdk
        testInstrumentationRunner = Config.testInstrumentationRunner
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
    implementation(project(Module.APP))
    implementation(Dependency.CoreLibrary.KTX)
    testImplementation(Dependency.TestLibrary.JUNIT)
    androidTestImplementation(Dependency.TestLibrary.EXT_JUNIT)
    androidTestImplementation(Dependency.TestLibrary.ESPRESSO_CORE)
    androidTestImplementation(Dependency.TestLibrary.ANNOTATION)
}