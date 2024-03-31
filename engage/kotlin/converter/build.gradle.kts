plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

    kotlin("plugin.serialization") version libs.versions.kotlin
}

android {
    namespace = "com.google.android.engage.js.converter"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

dependencies {
    implementation("androidx.work:work-runtime:2.9.0")
    implementation("com.google.android.engage:engage-core:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
