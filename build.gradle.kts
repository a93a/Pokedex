buildscript {
    val compose_version by extra("1.1.1")

    repositories {
        google()
        mavenCentral()
    }
    
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}