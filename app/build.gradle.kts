plugins {
	kotlin("kapt")
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.hilt)
	alias(libs.plugins.serialization)
	id("com.google.devtools.ksp")
}

android {
	namespace = "com.bellogatecaliphate.pagination"
	compileSdk = 35
	
	defaultConfig {
		applicationId = "com.bellogatecaliphate.pagination"
		minSdk = 28
		targetSdk = 34
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
		kotlinCompilerExtensionVersion = "1.5.1"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	implementation(libs.androidx.uiautomator.v18)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
	
	// hilt
	implementation(libs.hilt)
	kapt(libs.hilt.compiler)
	// navigation graph
	implementation(libs.navigation.graph)
	// bottom navigation compose
	implementation(libs.bottom.navigation)
	// serialization
	implementation(libs.kotlinx.serialization.json)
	
	// coil
	implementation("io.coil-kt:coil-compose:2.2.2")
	// Retrofit:
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("com.squareup.okhttp3:okhttp:4.12.0")
	// GSON
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	
	// constraintlayout-compose
	implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0")
	
	// paging
	val paging_version = "3.3.5"
	implementation("androidx.paging:paging-runtime-ktx:3.3.5")
	implementation("androidx.paging:paging-compose:3.3.5")
	
	val room_version = "2.5.0"
	implementation("androidx.room:room-runtime:$room_version")
	implementation("androidx.room:room-paging:$room_version")
	implementation("androidx.room:room-ktx:$room_version")
	kapt(libs.room.compiler)
}

kapt {
	correctErrorTypes = true
}