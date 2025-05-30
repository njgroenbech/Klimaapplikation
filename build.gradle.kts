// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // your existing version-catalog aliases for the Android+Kotlin plugins
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android)    apply false
    alias(libs.plugins.kotlin.compose)    apply false

    id("com.google.gms.google-services") version "4.3.15" apply false
}