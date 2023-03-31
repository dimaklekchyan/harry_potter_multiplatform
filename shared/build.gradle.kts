plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
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
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
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
                implementation(Dependencies.Odyssey.core)
                implementation(Dependencies.Odyssey.compose)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
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
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Dependencies.Ktor.darwin)
                implementation(Dependencies.SQLDelight.nativeDriver)

                implementation(Dependencies.KViewModel.core)
                implementation(Dependencies.Odyssey.core)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
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