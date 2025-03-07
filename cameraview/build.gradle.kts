import io.deepmedia.tools.publisher.common.GithubScm
import io.deepmedia.tools.publisher.common.License
import io.deepmedia.tools.publisher.common.Release

plugins {
    id("com.android.library")
    id("kotlin-android")
    id(libs.plugins.gradle.mavenpublish.get().pluginId)
//    id("io.deepmedia.tools.publisher")
}

version = "2.7.0"

android {
    namespace = "com.otaliastudios.cameraview"
    compileSdk = 35

    defaultConfig {
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-inline:2.28.2")

    androidTestImplementation("androidx.test:runner:1.7.0-alpha01")
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

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.otaliastudios"
            artifactId = "cameraview"
            version = "2.8.0"
            afterEvaluate {
                from(components["release"])
            }
        }
    }
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