plugins {
    id("com.mobilez.kotlin-lib")
}
dependencies {
    api(libs.junit4)
    api(libs.mockito.kotlin)
    api(libs.mockito.inline)
    api(libs.truth)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)
    api(libs.google.testParameterInjector)
}
