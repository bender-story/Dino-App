buildscript {
    val kotlin_version by extra( "1.4.32")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.GRADLE)
        classpath(Dependencies.KOTLIN_GRADLE_PLUGIN)
        classpath(Dependencies.GOOGLE_SERVICES)
        classpath(Dependencies.NAV_SAFE_ARGS)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}