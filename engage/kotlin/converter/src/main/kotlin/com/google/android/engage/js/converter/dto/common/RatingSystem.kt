package com.google.android.engage.js.converter.dto.common

import kotlinx.serialization.Serializable

@Serializable
data class RatingSystem(
    val agencyName: String,
    val ratingValue: String,
)
