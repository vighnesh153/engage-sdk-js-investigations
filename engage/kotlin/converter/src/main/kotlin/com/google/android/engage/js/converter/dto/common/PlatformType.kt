package com.google.android.engage.js.converter.dto.common

import kotlinx.serialization.Serializable

@Serializable
enum class PlatformType {
    UNSPECIFIED,
    ANDROID_MOBILE,
    ANDROID_TV,
    IOS,
}
