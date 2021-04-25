plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(AppConfigs.COMPILE_SDK_VERSION)
    buildToolsVersion = AppConfigs.BUILD_TOOL_VERSION

    defaultConfig {
        minSdkVersion(AppConfigs.MIN_SDK_VERSION)
        targetSdkVersion(AppConfigs.TARGET_SDK_VERSION)
        versionCode = AppConfigs.VERSION_CODE
        versionName = AppConfigs.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.KOTLIN_STD_LIB)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.ANDROID_MATERIAL)
    implementation(Dependencies.CONSTRAINT_LAYOUT)

    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.EXT_JUNIT)
    androidTestImplementation(Dependencies.ESPRESSO)

    // Optional -- Robolectric environment
    testImplementation(Dependencies.ANDROIDX_TEST_CORE)
    // Optional -- Mockito framework
    testImplementation(Dependencies.MOCKITO)
    testImplementation(Dependencies.ROBOELECTRIC)

    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_GSON)
    implementation(Dependencies.OK_HTTP_LOGGING_INTERSEPTOR)
    implementation(Dependencies.RETROFIT_MOCK)
    implementation(Dependencies.RETROFIT_SCALARS)

    implementation(Dependencies.OK_HTTP)
    implementation(Dependencies.OK_HTTP_URL_CONNECTION)
    implementation(Dependencies.OK_HTTP_LOGGING_INTERSEPTOR)

    implementation(Dependencies.RXJAVA)

    implementation(Dependencies.RETROFIT_RXJAVA)
    implementation(Dependencies.RX_ANDROID)
    implementation(Dependencies.RECYCLER_VIEW)
    implementation(Dependencies.MULTIDEX)
    implementation(Dependencies.GLIDER)
    implementation(Dependencies.CARD_VIEW)
    implementation(Dependencies.LEGACY_SUPPORT_V4)

    androidTestImplementation(Dependencies.TEST_RULES)

    // Koin for Android
    implementation(Dependencies.ANDROID_KOIN)
    // Koin AndroidX Scope feature
    implementation(Dependencies.ANDROIDX_KOIN_SCOPE)
    // Koin AndroidX ViewModel feature
    implementation(Dependencies.ANDROIDX_KOIN_VIEWMODEL)

    // Koin testing tools
    testImplementation(Dependencies.ANDROIDX_KOIN_TEST)
    implementation(Dependencies.ANDROIDX_KOIN_LIFECYCLE_RUNTIME)
    implementation(Dependencies.ANDROIDX_KOIN_LIFECYCLE_EXT)
    implementation(Dependencies.ANDROIDX_KOIN_LIFECYCLE_REACTIVE)
    implementation(Dependencies.ANDROIDX_FRAGMENT_KTX)

    // Kotlin
    implementation(Dependencies.ANDROIDX_NAVIGATION_FRAGMENT)
    implementation(Dependencies.ANDROIDX_NAVIGATION_UI)
    implementation(Dependencies.ANDROIDX_NAVIGATION_RUNTIME)

    // Testing Navigation
    androidTestImplementation(Dependencies.ANDROIDX_NAVIGATION_TEST)
    debugImplementation(Dependencies.ANDROIDX_FRAGMENT_TESTING)

    implementation(Dependencies.GROUPIE)
    implementation(Dependencies.GROUPIE_VIEWBINDING)

    implementation(project( ":core"))
    implementation(project( ":navigation"))
    implementation(project( ":resource"))
}