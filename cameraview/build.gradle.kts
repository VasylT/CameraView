plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = 35
    namespace = "com.otaliastudios.cameraview"
    defaultConfig {
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["filter"] = "" +
                "com.otaliastudios.cameraview.tools.SdkExcludeFilter," +
                "com.otaliastudios.cameraview.tools.SdkIncludeFilter"
    }
    buildTypes["debug"].isTestCoverageEnabled = true
    buildTypes["release"].isMinifyEnabled = false
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-inline:2.28.2")

    androidTestImplementation("androidx.test:runner:1.6.2")
    androidTestImplementation("androidx.test:rules:1.6.1")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("org.mockito:mockito-android:2.28.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    api("androidx.exifinterface:exifinterface:1.4.0")
    api("androidx.lifecycle:lifecycle-common:2.8.7")
    api("com.google.android.gms:play-services-tasks:18.2.0")
    implementation("androidx.annotation:annotation:1.9.1")
    implementation("com.otaliastudios.opengl:egloo:0.6.1")
}