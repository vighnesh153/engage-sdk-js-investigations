package com.google.android.engage.js.converter.dto.common

import android.net.Uri
import com.google.android.engage.common.datamodel.Image as EngageImage
import com.google.android.engage.common.datamodel.ImageTheme as EngageImageTheme
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val imageUri: String,
    val imageWidthInPixel: Int,
    val imageHeightInPixel: Int,
    val accessibilityText: String,
    val imageTheme: ImageTheme,
) {
    fun toEngageImage(): EngageImage {
        return EngageImage
            .Builder()
            .setImageUri(Uri.parse(imageUri))
            .setImageWidthInPixel(imageWidthInPixel)
            .setImageHeightInPixel(imageHeightInPixel)
            .setAccessibilityText(accessibilityText)
            .setImageTheme(imageTheme.toEngageImageTheme())
            .build()
    }
}

@Serializable
enum class ImageTheme {
    UNSPECIFIED,
    LIGHT,
    DARK;

    fun toEngageImageTheme(): Int {
        return when (this) {
            ImageTheme.UNSPECIFIED -> EngageImageTheme.IMAGE_THEME_UNSPECIFIED
            ImageTheme.LIGHT -> EngageImageTheme.IMAGE_THEME_DARK
            ImageTheme.DARK -> EngageImageTheme.IMAGE_THEME_LIGHT
        }
    }
}
