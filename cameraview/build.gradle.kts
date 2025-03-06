import io.deepmedia.tools.publisher.common.GithubScm
import io.deepmedia.tools.publisher.common.License
import io.deepmedia.tools.publisher.common.Release

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("io.deepmedia.tools.publisher")
}

version = "2.7.0"

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

//publisher {
//    project.description = "A well documented, high-level Android interface that makes capturing " +
//            "pictures and videos easy, addressing all of the common issues and needs. " +
//            "Real-time filters, gestures, watermarks, frame processing, RAW, output of any size."
//    project.artifact = "cameraview"
//    project.group = "com.otaliastudios"
//    project.url = "https://github.com/natario1/CameraView"
//    project.scm = GithubScm("fromitt", "CameraView")
//    project.addLicense(License.APACHE_2_0)
//    project.addDeveloper("fromitt", "fromitt@gmail.com")
//    release.sources = Release.SOURCES_AUTO
//    release.docs = Release.DOCS_AUTO
//    release.version = "2.8.0"
//
//    directory()
//
//    sonatype {
//        auth.user = "SONATYPE_USER"
//        auth.password = "SONATYPE_PASSWORD"
//        signing.key = "SIGNING_KEY"
//        signing.password = "SIGNING_PASSWORD"
//    }
//
//    sonatype("snapshot") {
//        repository = io.deepmedia.tools.publisher.sonatype.Sonatype.OSSRH_SNAPSHOT_1
//        release.version = "latest-SNAPSHOT"
//        auth.user = "SONATYPE_USER"
//        auth.password = "SONATYPE_PASSWORD"
//        signing.key = "SIGNING_KEY"
//        signing.password = "SIGNING_PASSWORD"
//    }
//}