package com.google.android.engage.js.converter.dto.common

import com.google.android.engage.common.datamodel.ContentAvailability as EngageContentAvailability
import kotlinx.serialization.Serializable

@Serializable
enum class ContentAvailability {
    UNKNOWN,
    AVAILABLE,
    FREE_WITH_SUBSCRIPTION,
    PAID_CONTENT;

    fun toEngageContentAvailability(): Int {
        return when (this) {
            ContentAvailability.UNKNOWN -> EngageContentAvailability.AVAILABILITY_UNKNOWN
            ContentAvailability.AVAILABLE -> EngageContentAvailability.AVAILABILITY_AVAILABLE
            ContentAvailability.FREE_WITH_SUBSCRIPTION -> EngageContentAvailability.AVAILABILITY_FREE_WITH_SUBSCRIPTION
            ContentAvailability.PAID_CONTENT -> EngageContentAvailability.AVAILABILITY_PAID_CONTENT
        }
    }
}
