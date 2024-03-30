package com.google.android.engage.js.converter.dto.common

import android.net.Uri
import com.google.android.engage.common.datamodel.PlatformSpecificUri as EngagePlatformSpecificUri
import kotlinx.serialization.Serializable

@Serializable
data class PlatformSpecificUri(
    val actionUri: String,
    val platformType: PlatformType,
) {
    fun toEngagePlatformSpecificUri(): EngagePlatformSpecificUri {
        return EngagePlatformSpecificUri
            .Builder()
            .setActionUri(Uri.parse(actionUri))
            .setPlatformType(platformType.toEngagePlatformType())
            .build()
    }
}
