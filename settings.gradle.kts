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
        maven("https://devrepo.kakao.com/nexus/content/groups/public/")
        //https://developers.kakao.com/docs/latest/ko/android/getting-started#apply-sdk-select-module에서 복붙
    }
}

rootProject.name = "kakao_login"
include(":app")
 