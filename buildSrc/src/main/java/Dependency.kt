class Dependency {

    object Proguard {
        const val ANDROID_OPTIMIZED = "proguard-android-optimize.txt"
        const val PROGUARD_RULES = "proguard-rules.pro"
        const val CONSUMER_RULES = "consumer-rules.pro"
    }
    object CoreLibrary {
        const val KTX = "androidx.core:core-ktx:1.8.0"
        const val SPLASH_SCREEN = "androidx.core:core-splashscreen:1.0.0"
    }
    object ComposeLibrary {
        const val COMPOSE_BOM = "androidx.compose:compose-bom:2023.04.01"
        const val COMPOSE_MATERIAL_3 = "androidx.compose.material3:material3:1.0.1"
        const val COMPOSE_MATERIAL_2 = "androidx.compose.material:material"
        const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation"
        const val COMPOSE_UI = "androidx.compose.ui:ui"
    }

    object TestLibrary {
        const val JUNIT = "junit:junit:4.13.2"
        const val EXT_JUNIT = "androidx.test.ext:junit:1.1.5"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.5.1"
        const val ANNOTATION = "androidx.annotation:annotation:1.3.0"
    }
}