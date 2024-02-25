pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Android MVI Compose"
include(":app", ":module")
include(":base_component", ":base_api", ":base_mvi", ":base_helper")
include(":api_profile", ":api_list")
include(
    ":module:module_contact",
    ":module:module_home",
    ":module:module_detail",
    ":module:module_login"
)
