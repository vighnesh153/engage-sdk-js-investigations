plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)

    kotlin("plugin.serialization") version libs.versions.kotlin
}

android {
    namespace = "com.google.android.engage.js.testapp"
    compileSdk = 34

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }

    defaultConfig {
        minSdk = 21
        targetSdk = 34
        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

dependencies {
    implementation("androidx.work:work-runtime:2.9.0")
    implementation("com.google.android.engage:engage-core:1.4.0")

    implementation("androidx.profileinstaller:profileinstaller:1.3.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    implementation(project(":converter"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    val composeVersion = "1.6.4"
    implementation("androidx.compose.animation:animation:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.ui:ui-util:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-graphics:$composeVersion")
    implementation("androidx.compose.ui:ui-text:$composeVersion")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
