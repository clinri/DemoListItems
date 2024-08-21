pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "DemoItemsFromBd"
include(":app")
include(":core:common")
include(":core:ui")
include(":domain:models")
include(":domain:api")
include(":domain:impl")
include(":data:api")
include(":data:impl")
include(":feature:list_items")
