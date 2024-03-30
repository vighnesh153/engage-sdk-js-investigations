package com.google.android.engage.js.converter.dto.common

import kotlinx.serialization.Serializable

@Serializable
data class PlatformSpecificUri(
    val actionUri: String,
    val platformType: PlatformType,
)
