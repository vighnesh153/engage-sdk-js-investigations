package com.google.android.engage.js.converter.dto.common

import com.google.android.engage.video.datamodel.WatchNextType as EngageWatchNextType
import kotlinx.serialization.Serializable

@Serializable
enum class WatchNextType {
    UNKNOWN,
    CONTINUE,
    NEXT,
    NEW,
    WATCHLIST;

    fun toEngageWatchNextType(): Int {
        return when (this) {
            UNKNOWN -> EngageWatchNextType.TYPE_UNKNOWN
            CONTINUE -> EngageWatchNextType.TYPE_CONTINUE
            NEXT -> EngageWatchNextType.TYPE_NEXT
            NEW -> EngageWatchNextType.TYPE_NEW
            WATCHLIST -> EngageWatchNextType.TYPE_WATCHLIST
        }
    }
}
