import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

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

    object APILibrary {
        const val KTOR_CORE = "io.ktor:ktor-client-core:2.1.3"
        const val KTOR_ANDROID = "io.ktor:ktor-client-android:2.1.3"
        const val KTOR_SERIALIZATION = "io.ktor:ktor-serialization-gson:2.1.3"
        const val KTOR_LOGGING = "io.ktor:ktor-client-logging:2.1.3"
        const val KTOR_CONTENTNEGOTIATION = "io.ktor:ktor-client-content-negotiation:2.1.3"
    }
}
fun DependencyHandler.importUnitTest(testImplementation: Boolean = true) {
    val configName = if (testImplementation) "testImplementation" else "implementation"

    add(configName, Dependency.TestLibrary.JUNIT)
}

fun DependencyHandler.importAndroidTest(androidTestImplementation: Boolean = true) {
    val configName = "androidTestImplementation"

    add(configName, Dependency.TestLibrary.EXT_JUNIT)
    add(configName, Dependency.TestLibrary.ESPRESSO_CORE)
    add(configName, Dependency.TestLibrary.ANNOTATION)
}

fun DependencyHandler.importBaseAPI() {
    val configName = "implementation"
    add(configName, Dependency.APILibrary.KTOR_ANDROID)
    add(configName, Dependency.APILibrary.KTOR_CONTENTNEGOTIATION)
    add(configName, Dependency.APILibrary.KTOR_CORE)
    add(configName, Dependency.APILibrary.KTOR_SERIALIZATION)
    add(configName, Dependency.APILibrary.KTOR_LOGGING)
}

inline val DependencyHandler.apiProfile get() = project(":api_profile")
inline val DependencyHandler.apiList get() = project(":api_list")
inline val DependencyHandler.baseApi get() = project(":base_api")
inline val DependencyHandler.baseComponent get() = project(":base_component")
inline val DependencyHandler.baseHelper get() = project(":base_helper")
inline val DependencyHandler.baseMvi get() = project(":base_mvi")
inline val DependencyHandler.moduleContact get() = project(":module:module_contact")
inline val DependencyHandler.moduleHome get() = project(":module:module_home")
inline val DependencyHandler.moduleDetail get() = project(":module:module_datail")
inline val DependencyHandler.moduleLogin get() = project(":module:module_login")
inline val DependencyHandler.app get() = project(":app")