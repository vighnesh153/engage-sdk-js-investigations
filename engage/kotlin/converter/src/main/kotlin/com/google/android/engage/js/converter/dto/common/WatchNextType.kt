package com.google.android.engage.js.converter.dto.common

import kotlinx.serialization.Serializable

@Serializable
enum class WatchNextType {
    UNKNOWN,
    CONTINUE,
    NEXT,
    NEW,
    WATCHLIST,
}