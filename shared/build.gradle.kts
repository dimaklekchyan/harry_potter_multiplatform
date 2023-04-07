plugins {
    kotlin("native.cocoapods")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    ios()
    iosSimulatorArm64()

    cocoapods {
        summary = "HarryPotter SDK"
        homepage = "https://github.com/dimaklekchyan/harry_potter_multiplatform"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            transitiveExport = false
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.Kodein.di)
                implementation(Dependencies.Kotlin.coroutinesCore)
                implementation(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Ktor.kotlinxSerialization)
                implementation(Dependencies.SQLDelight.runtime)
                implementation(Dependencies.KViewModel.core)
                implementation(Dependencies.KViewModel.compose)
//                implementation(Dependencies.Odyssey.core)
//                implementation(Dependencies.Odyssey.compose)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.Ktor.android)
                implementation(Dependencies.SQLDelight.androidDriver)

                implementation(Dependencies.KViewModel.core)
                implementation(Dependencies.KViewModel.compose)
                implementation(Dependencies.KViewModel.odyssey)
                implementation(Dependencies.Odyssey.core)
                implementation(Dependencies.Odyssey.compose)

                implementation(Dependencies.Compose.ui)
                implementation(Dependencies.Compose.toolingUi)
                implementation(Dependencies.Compose.toolingPreview)
                implementation(Dependencies.Compose.foundation)
                implementation(Dependencies.Compose.material)
                implementation(Dependencies.Compose.activity)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Dependencies.Ktor.darwin)
                implementation(Dependencies.SQLDelight.nativeDriver)

                implementation(Dependencies.KViewModel.core)
//                implementation(Dependencies.Odyssey.core)
            }
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}

android {
    namespace = "com.klekchyan.harrypottermultiplatform"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compilerVersion
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.klekchyan.harrypottermultiplatform.shared.cache"
    }
}