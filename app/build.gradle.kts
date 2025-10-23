plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
}

android {
    namespace = "com.taurunium.smarttasks"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.taurunium.smarttasks"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    // Core UI
    implementation(libs.bundles.androidx.core.ui)

    // Lifecycle (ViewModel, LiveData, SavedState)
    implementation(libs.bundles.lifecycle)
    kapt(libs.androidx.lifecycle.compiler)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Dagger (DI)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    // Networking
    implementation(libs.bundles.network)

    // Images
    implementation(libs.glide)
    kapt(libs.glide.compiler)

    // Tests
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.espresso.core)

    // Room
    implementation(libs.bundles.room)
    kapt(libs.androidx.room.compiler)

}