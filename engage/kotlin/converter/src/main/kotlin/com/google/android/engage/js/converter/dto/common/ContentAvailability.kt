package com.google.android.engage.js.converter.dto.common

import kotlinx.serialization.Serializable

@Serializable
enum class ContentAvailability {
    UNKNOWN,
    AVAILABLE,
    FREE_WITH_SUBSCRIPTION,
    PAID_CONTENT,
}
