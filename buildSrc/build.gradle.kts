import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    //TODO create buildSrc in buildSrc. Move Dependencies to new module to use here
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    implementation(enforcedPlatform("org.jetbrains.kotlin:kotlin-stdlib:1.7.10"))
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.8.10")
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.4.0-alpha01-dev980")
    implementation("com.squareup.sqldelight:gradle-plugin:1.5.5")
}