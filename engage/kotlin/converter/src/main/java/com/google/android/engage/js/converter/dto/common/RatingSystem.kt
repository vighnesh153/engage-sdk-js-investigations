package com.google.android.engage.js.converter.dto.common

import com.google.android.engage.video.datamodel.RatingSystem as EngageRatingSystem
import kotlinx.serialization.Serializable

@Serializable
data class RatingSystem(
    val agencyName: String,
    val ratingValue: String,
) {
    fun toEngageRatingSystem(): EngageRatingSystem {
        return EngageRatingSystem
            .Builder()
            .setAgencyName(agencyName)
            .setRating(ratingValue)
            .build()
    }
}
