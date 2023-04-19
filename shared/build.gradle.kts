plugins {
    kotlin("native.cocoapods")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
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
            isStatic = true
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)

                implementation(Dependencies.Kodein.di)

                implementation(Dependencies.Kotlin.coroutinesCore)

                implementation(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Ktor.kotlinxSerialization)

                implementation(Dependencies.SQLDelight.runtime)

                implementation(Dependencies.KViewModel.core)
                implementation(Dependencies.KViewModel.odyssey)

                implementation(Dependencies.Odyssey.core)
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

                implementation(Dependencies.Odyssey.core)
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.klekchyan.harrypottermultiplatform.shared.cache"
    }
    linkSqlite = true
}