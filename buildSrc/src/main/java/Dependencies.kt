
object Dependencies{


    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT_VERSION}"
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.ANDROID_MATERIAL_VERSION}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    const val JUNIT = "junit:junit:${Versions.JUNIT_VERSION}"
    const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.EXT_JUNIT_VERSION}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_VERSION}"
    const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:${Versions.ESPRESSO_VERSION}"

    // Optional -- Robolectric environment
    const val ANDROIDX_TEST_CORE = "androidx.test:core:${Versions.ANDROIDX_TEST_CORE_VERSION}"
    // Optional -- Mockito framework
    const val MOCKITO = "org.mockito:mockito-core:${Versions.MOCKITO_VERSION}"
    const val ROBOELECTRIC = "org.robolectric:robolectric:${Versions.ROBOELECTRIC_VERSION}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_GSON_VERSION}"
    const val RETROFIT_MOCK = "com.squareup.retrofit2:retrofit-mock:${Versions.RETROFIT_MOCK_VERSION}"
    const val RETROFIT_SCALARS = "com.squareup.retrofit2:converter-scalars:${Versions.RETROFIT_SCALARS_VERSION}"

    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP_VERSION}"
    const val OK_HTTP_URL_CONNECTION = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.OK_HTTP_VERSION}"
    const val OK_HTTP_LOGGING_INTERSEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP_VERSION}"

    const val RXJAVA = "io.reactivex.rxjava2:rxkotlin:${Versions.RXKOTLIN_VERSION}"

    const val RETROFIT_RXJAVA = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT_VERSION}"
    const val RX_ANDROID = "io.reactivex.rxjava2:rxandroid:${Versions.RX_ANDROID_VERSION}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW_VERSION}"
    const val MULTIDEX = "androidx.multidex:multidex:${Versions.MULTIDEX_VERSION}"
    const val GLIDER = "com.github.bumptech.glide:glide:${Versions.GLIDER_VERSION}"
    const val CARD_VIEW = "androidx.cardview:cardview:${Versions.CARD_VIEW_VERSION}"
    const val LEGACY_SUPPORT_V4 = "androidx.legacy:legacy-support-v4:${Versions.LEGACY_SUPPORT_V4_VERSION}"

    const val TEST_RULES = "androidx.test:rules:${Versions.TEST_RULES_VERSION}"

    // Koin for Android
    const val ANDROID_KOIN = "org.koin:koin-android:${Versions.ANDROID_KOIN_VERSION}"
    // Koin AndroidX Scope feature
    const val ANDROIDX_KOIN_SCOPE = "org.koin:koin-androidx-scope:${Versions.ANDROID_KOIN_VERSION}"
    // Koin AndroidX ViewModel feature
    const val ANDROIDX_KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${Versions.ANDROID_KOIN_VERSION}"

    // Koin testing tools
    const val ANDROIDX_KOIN_TEST = "org.koin:koin-test:${Versions.ANDROID_KOIN_VERSION}"
    const val ANDROIDX_KOIN_LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ANDROIDX_KOIN_LIFECYCLE_RUNTIME_VERSION}"
    const val ANDROIDX_KOIN_LIFECYCLE_EXT = "androidx.lifecycle:lifecycle-extensions:${Versions.ANDROIDX_KOIN_LIFECYCLE_EXT_VERSION}"
    const val ANDROIDX_KOIN_LIFECYCLE_REACTIVE = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.ANDROIDX_KOIN_LIFECYCLE_REACTIVE_VERSION}"
    const val ANDROIDX_FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.ANDROIDX_FRAGMENT_KTX_VERSION}"

    // Kotlin
    const val ANDROIDX_NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}"
    const val ANDROIDX_NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}"
    const val ANDROIDX_NAVIGATION_RUNTIME = "androidx.navigation:navigation-runtime-ktx:${Versions.NAVIGATION_VERSION}"

    // Testing Navigation
    const val ANDROIDX_NAVIGATION_TEST = "androidx.navigation:navigation-testing:${Versions.NAVIGATION_VERSION}"

    const val GROUPIE = "com.xwray:groupie:${Versions.GROUPIE_VERSION}"
    const val GROUPIE_VIEWBINDING = "com.xwray:groupie-viewbinding:${Versions.GROUPIE_VERSION}"

    const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE_VERSION}"
    const val KOTLIN_GRADLE_PLUGIN =  "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERSION}"
    const val GOOGLE_SERVICES =  "com.google.gms:google-services:${Versions.GMS_VERSION}"
    const val NAV_SAFE_ARGS =  "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION_VERSION}"
}

object Versions{
const val KOTLIN_VERSION = "1.4.32"
    const val GMS_VERSION = "4.3.5"
    const val GRADLE_VERSION = "4.1.3"

    const val CORE_KTX_VERSION = "1.3.2"
    const val APPCOMPAT_VERSION = "1.2.0"
    const val ANDROID_MATERIAL_VERSION = "1.3.0"
    const val CONSTRAINT_LAYOUT_VERSION = "2.0.4"
    const val JUNIT_VERSION = "4.13.2"
    const val EXT_JUNIT_VERSION = "1.1.2"
    const val ESPRESSO_VERSION = "3.3.0"

    // Optional -- Robolectric environment
    const val ANDROIDX_TEST_CORE_VERSION = "1.3.0"
    // Optional -- Mockito framework
    const val MOCKITO_VERSION = "2.21.0"
    const val ROBOELECTRIC_VERSION= "4.0.2"

    const val RETROFIT_VERSION = "2.4.0"
    const val RETROFIT_GSON_VERSION = "2.4.0"
    const val RETROFIT_MOCK_VERSION = "2.3.0"
    const val RETROFIT_SCALARS_VERSION= "2.1.0"

    const val OK_HTTP_VERSION = "3.10.0"

    const val RXKOTLIN_VERSION = "2.1.0"

    const val RX_ANDROID_VERSION = "2.0.1"
    const val RECYCLER_VIEW_VERSION = "1.2.0"
    const val MULTIDEX_VERSION = "2.0.1"
    const val GLIDER_VERSION = "4.8.0"
    const val CARD_VIEW_VERSION = "1.0.0"
    const val LEGACY_SUPPORT_V4_VERSION = "1.0.0"

    const val TEST_RULES_VERSION = "1.4.0-alpha05"

    // Koin for Android
    const val ANDROID_KOIN_VERSION = "2.0.1"

    const val ANDROIDX_KOIN_LIFECYCLE_RUNTIME_VERSION = "2.3.1"
    const val ANDROIDX_KOIN_LIFECYCLE_EXT_VERSION = "2.2.0"
    const val ANDROIDX_KOIN_LIFECYCLE_REACTIVE_VERSION = "2.3.1"
    const val ANDROIDX_FRAGMENT_KTX_VERSION = "1.3.2"

    const val NAVIGATION_VERSION = "2.3.5"
    const val GROUPIE_VERSION = "2.9.0"
}