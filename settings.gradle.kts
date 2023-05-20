@file:Suppress("UnstableApiUsage")

rootProject.name = "ComposeElementsKit"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        includeBuild("shared-build-logic")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

val modulesApp = arrayOf<String>(
    ":catalog",
)
val modulesLibraries = arrayOf<String>(
    ":lib",
)
include(
    *modulesApp,
    *modulesLibraries,
    ":shared:testing",
)
