plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.math"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.math"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Sử dụng Maven Central
    implementation("net.objecthunter:exp4j:0.4.8") // Giữ dòng này

    // Loại bỏ dòng này nếu sử dụng Maven Central
    // implementation(files("libs/exp4j-0.4.8.jar"))
}





