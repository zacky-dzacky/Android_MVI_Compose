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
include(":app", ":base", ":module")
include(":base:base_component", "base:base_api", ":base:base_mvi", ":base:base_helper")
include(":api:api_profile", ":api:api_list")
include(":module:module_contact", ":module:module_home", ":module:module_detail", ":module:module_login")
