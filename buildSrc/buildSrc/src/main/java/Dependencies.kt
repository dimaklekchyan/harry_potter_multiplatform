object Dependencies {

    object Kotlin {
        const val version = "1.8.20"
        private const val coroutinesVersion = "1.6.4"
        private const val serializationVersion = "1.4.1"

        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val serializationGradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:$version"

        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.4.2"
    }

    object Compose {
        const val uiVersion = "1.4.0"
        const val runtimeVersion = "1.4.0"
        const val foundationVersion = "1.4.0"
        const val materialVersion = "1.4.0"
        const val compilerVersion = "1.4.5"
        private const val constraintLayoutVersion = "1.0.1"
        private const val activityVersion = "1.4.0"

        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:1.4.0"

        const val ui = "androidx.compose.ui:ui:$uiVersion"
        const val foundation = "androidx.compose.foundation:foundation:$foundationVersion"
        const val material = "androidx.compose.material:material:$materialVersion"
        const val icons =  "androidx.compose.material:material-icons-extended:$materialVersion"
        const val toolingPreview =  "androidx.compose.ui:ui-tooling-preview:$uiVersion"
        const val toolingUi =  "androidx.compose.ui:ui-tooling:$uiVersion"
        const val uiTest =  "androidx.compose.ui:ui-test-junit4:$uiVersion"
        const val activity =  "androidx.activity:activity-compose:$activityVersion"
        const val runtime =  "androidx.compose.runtime:runtime:$runtimeVersion"
        const val constraintLayout =  "androidx.constraintlayout:constraintlayout-compose:$constraintLayoutVersion"
    }

    object Kodein {
        const val version = "7.18.0"

        const val di = "org.kodein.di:kodein-di:$version"
        const val frameworkCompose = "org.kodein.di:kodein-di-framework-compose:$version"
    }

    object Ktor {
        private const val version = "2.2.2"

        const val core = "io.ktor:ktor-client-core:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val darwin = "io.ktor:ktor-client-darwin:$version"

        const val negotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val kotlinxSerialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
    }

    object SQLDelight {
        private const val version = "1.5.5"

        const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$version"

        const val runtime = "com.squareup.sqldelight:runtime:$version"
        const val androidDriver = "com.squareup.sqldelight:android-driver:$version"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:$version"
        const val coroutinesExtension = "com.squareup.sqldelight:coroutines-extensions-jvm:$version"
    }

    object Voyager {
        private const val version = "1.0.0-rc05"

        const val navigator = "cafe.adriel.voyager:voyager-navigator:$version"
        const val bottomSheetNavigator = "cafe.adriel.voyager:voyager-bottom-sheet-navigator:$version"
        const val tabNavigator = "cafe.adriel.voyager:voyager-tab-navigator:$version"
        const val transitions = "cafe.adriel.voyager:voyager-transitions:$version"
        const val kodein = "cafe.adriel.voyager:voyager-kodein:$version"
    }

    object Tests {
        private const val junitVersion = "4.13.2"
        private const val extVersion = "1.1.3"
        private const val espressoVersion = "3.4.0"

        const val junit = "junit:junit:$junitVersion"
        const val extJunit = "androidx.test.ext:junit:$extVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    }

    object Other {
        private const val coreVersion = "1.8.1"
        private const val appcompatVersion = "1.5.1"
        private const val materialVersion = "1.6.0"

        const val coreKtx = "androidx.core:core-ktx:$coreVersion"
        const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
        const val material = "com.google.android.material:material:$materialVersion"
    }

}