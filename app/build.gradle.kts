plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "me.guaidaodl.bodycarelog"
    compileSdk = 33

    defaultConfig {
        applicationId = "me.guaidaodl.bodycarelog"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.bundles.android.base)
    implementation(libs.bundles.android.compose)

    testImplementation(libs.bundles.common.test)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.bundles.android.test)

    // compose 的 ui 测试
    debugImplementation(libs.androidx.compose.ui.manifest)
    androidTestImplementation(libs.bundles.android.compose.test)

    // compose 的预览
    implementation(libs.androidx.compose.ui.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
}