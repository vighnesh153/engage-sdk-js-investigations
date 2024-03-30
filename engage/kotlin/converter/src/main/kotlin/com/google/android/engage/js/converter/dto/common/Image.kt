package com.google.android.engage.js.converter.dto.common

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val imageUri: String,
    val imageWidthInPixel: Int,
    val imageHeightInPixel: Int,
    val accessibilityText: String,
    val imageTheme: ImageTheme,
)

@Serializable
enum class ImageTheme {
    UNSPECIFIED,
    LIGHT,
    DARK
}
