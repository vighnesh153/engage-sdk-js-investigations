package com.google.android.engage.js.converter.dto.common

import com.google.android.engage.common.datamodel.DisplayTimeWindow as EngageDisplayTimeWindow
import kotlinx.serialization.Serializable

@Serializable
data class DisplayTimeWindow(
    val startTimeMillis: Long,
    val endTimeMillis: Long,
) {
    fun toEngageAvailabilityTimeWindow(): EngageDisplayTimeWindow {
        return EngageDisplayTimeWindow
            .Builder()
            .setStartTimestampMillis(startTimeMillis)
            .setEndTimestampMillis(endTimeMillis)
            .build()
    }
}
