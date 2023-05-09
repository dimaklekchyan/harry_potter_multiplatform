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
                implementation(compose.materialIconsExtended)

                implementation(Dependencies.Kodein.di)
                implementation(Dependencies.Kodein.frameworkCompose)

                implementation(Dependencies.Kotlin.coroutinesCore)

                implementation(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Ktor.kotlinxSerialization)

                implementation(Dependencies.SQLDelight.runtime)

                implementation(Dependencies.Voyager.navigator)
                implementation(Dependencies.Voyager.tabNavigator)
                implementation(Dependencies.Voyager.transitions)
                implementation(Dependencies.Voyager.bottomSheetNavigator)
                implementation(Dependencies.Voyager.kodein)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.Ktor.android)

                implementation(Dependencies.Kodein.di)
                implementation(Dependencies.Kodein.frameworkCompose)

                implementation(Dependencies.SQLDelight.androidDriver)

                implementation(Dependencies.Compose.activity)
                implementation(Dependencies.Accompanist.systemUiController)

                implementation(Dependencies.Voyager.navigator)
                implementation(Dependencies.Voyager.kodein)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Dependencies.Ktor.darwin)

                implementation(Dependencies.Kodein.di)
                implementation(Dependencies.Kodein.frameworkCompose)

                implementation(Dependencies.SQLDelight.nativeDriver)

                implementation(Dependencies.Voyager.navigator)
                implementation(Dependencies.Voyager.kodein)
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