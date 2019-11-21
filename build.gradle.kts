import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    kotlin("plugin.serialization") version "1.3.50"
    `maven-publish`
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
        group = "com.squareup.okio",
        name = "okio",
        version = "2.4.0"
    )
    implementation(
        group = "com.squareup.okhttp3",
        name = "okhttp",
        version = "4.2.2"
    )
    implementation(
        group = "ru.gildor.coroutines",
        name = "kotlin-coroutines-okhttp",
        version = "1.0"
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
    testImplementation(
        group = "org.assertj",
        name = "assertj-core",
        version = "3.12.2"
    )
    testImplementation(
        group = "org.junit.jupiter",
        name = "junit-jupiter-api",
        version = "5.4.2"
    )
    testRuntime(
        group = "org.junit.jupiter",
        name = "junit-jupiter-engine",
        version = "5.4.2"
    )
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
