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
include(":app")
include(":base")
include(":module")
include(":base:base_component")
include(":base:base_api")
include(":module:module_contact")
include(":module:module_home")
include(":module:module_detail")
include(":base:base_helper")
include(":module:module_login")
