plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.klekchyan.harrypottermultiplatform.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.klekchyan.harrypottermultiplatform.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compilerVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.toolingUi)
    implementation(Dependencies.Compose.toolingPreview)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.activity)

    implementation(Dependencies.Kotlin.coroutinesAndroid)

    implementation(Dependencies.Kodein.frameworkAndroid)
    implementation(Dependencies.Kodein.frameworkCompose)
    implementation(Dependencies.Kodein.di)
}