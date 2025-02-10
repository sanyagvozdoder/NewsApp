import com.android.build.gradle.BaseExtension
import com.example.buildprefs.libs
import com.example.buildprefs.plugHiltAndroid
import com.example.buildprefs.plugKsp
import com.example.buildprefs.libHiltAndroid
import com.example.buildprefs.libHiltCompiler

plugins {
    id("com.android.library")
    kotlin("android")
}


configure<BaseExtension> {
    val libs = libs

    plugins{
        id(libs.plugHiltAndroid())
        id(libs.plugKsp())
    }
    dependencies {
        implementation(libs.libHiltAndroid())
    }
}