plugins {
    `kotlin-dsl`
    id("com.gevamu.build.gradle-plugin-conventions")
}

repositories {
    // Corda plugins v5.1.0 aren't published to the Gradle Plugin Portal :-(
    maven("https://software.r3.com/artifactory/corda")
}

dependencies {
    // Corda plugins
    implementation(gradlePlugin("net.corda.plugins.quasar-utils", "5.1.0"))
    implementation(gradlePlugin("net.corda.plugins.cordapp", "5.1.0"))
    implementation(gradlePlugin("net.corda.plugins.cordformation", "5.1.0"))
}

gradlePlugin {
    plugins {
        named("${project.group}.${project.name}") {
            displayName = "Gavamu Cordformation conventions plugin"
            description = "Gradle plugin defining rules for Cordformation used in Gevamu builds"
        }
    }
}

fun gradlePlugin(id: String, version: String) = "$id:$id.gradle.plugin:$version"
