import org.jetbrains.exposed.gradle.Versions

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    gradleApi()
    implementation("org.jetbrains.kotlin.jvm", "org.jetbrains.kotlin.jvm.gradle.plugin", "1.7.20")
    implementation("com.avast.gradle", "gradle-docker-compose-plugin", "0.14.9")
    implementation("io.github.gradle-nexus", "publish-plugin", "1.0.0")
    implementation("io.gitlab.arturbosch.detekt", "detekt-gradle-plugin", Versions.detekt)
}

plugins {
    `kotlin-dsl` apply true
}

gradlePlugin {
    plugins {
        create("testWithDBs") {
            id = "testWithDBs"
            implementationClass = "org.jetbrains.exposed.gradle.DBTestingPlugin"
        }
    }
}
