plugins {
    id("com.mobilez.android-app")
}

android {
    namespace = "com.mobilez.catalog"
    defaultConfig {
        applicationId = "com.mobilez.catalog"
    }
}
dependencies {
    implementation(project(":lib"))

    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.compose.material3)

    implementation(libs.androidx.hilt.navigation.compose)

    androidTestImplementation(project(":testing"))
    debugImplementation (libs.androidx.compose.ui.testManifest)

    androidTestImplementation (libs.androidx.test.junit)
    androidTestImplementation (libs.androidx.test.espresso)
    androidTestImplementation (libs.androidx.compose.ui.test)

    testImplementation(project(":testing"))
}
