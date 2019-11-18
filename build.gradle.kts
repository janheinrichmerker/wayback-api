import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    kotlin("plugin.serialization") version "1.3.50"
}

group = "dev.reimer"
version = "0.1.0"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-coroutines-core",
        version = "1.0.1"
    )
    implementation(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-serialization-runtime",
        version = "0.13.0"
    )
    implementation(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-serialization-runtime-common",
        version = "0.13.0"
    )
    implementation(
        group = "com.squareup.retrofit2",
        name = "retrofit",
        version = "2.6.2"
    )
    implementation(
        group = "com.jakewharton.retrofit",
        name = "retrofit2-kotlinx-serialization-converter",
        version = "0.4.0"
    )
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}