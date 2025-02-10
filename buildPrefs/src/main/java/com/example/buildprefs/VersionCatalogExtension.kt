package com.example.buildprefs

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal val DependencyHandlerScope.ksp get() = "ksp"

internal fun VersionCatalog.plugHiltAndroid() = findPluginOrThrow("hilt-android")
internal fun VersionCatalog.libHiltAndroid() = findLibraryOrThrow("hilt-android")
internal fun VersionCatalog.libHiltCompiler() = findLibraryOrThrow("hilt-compiler")
internal fun VersionCatalog.plugKsp() = findPluginOrThrow("ksp")

private fun VersionCatalog.findPluginOrThrow(name: String) = findPlugin(name).orElseThrow {
    NoSuchElementException("Plugin $name not found in version catalog")
}.get().pluginId

private fun VersionCatalog.findLibraryOrThrow(name: String) = findLibrary(name).orElseThrow {
    NoSuchElementException("Library $name not found in version catalog")
}.get()