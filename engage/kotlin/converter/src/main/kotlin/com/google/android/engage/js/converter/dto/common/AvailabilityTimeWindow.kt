package com.google.android.engage.js.converter.dto.common

import kotlinx.serialization.Serializable

@Serializable
data class AvailabilityTimeWindow(
    val startTimeMillis: Long,
    val endTimeMillis: Long,
)
