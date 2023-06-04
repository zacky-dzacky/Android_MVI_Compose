plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.samrez.module_login"
    compileSdk = Config.compiledSDK

    defaultConfig {
        minSdk = Config.minSdk
        testInstrumentationRunner = Config.testInstrumentationRunner
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(Module.APP))
    implementation(project(Module.BASE_COMPONENT))

    implementation(Dependency.CoreLibrary.KTX)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.material3:material3:1.0.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation(Dependency.TestLibrary.JUNIT)
    androidTestImplementation(Dependency.TestLibrary.EXT_JUNIT)
    androidTestImplementation(Dependency.TestLibrary.ESPRESSO_CORE)
}
