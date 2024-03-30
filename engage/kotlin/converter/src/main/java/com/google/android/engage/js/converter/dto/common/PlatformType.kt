package com.google.android.engage.js.converter.dto.common

import com.google.android.engage.common.datamodel.PlatformType as EngagePlatformType
import kotlinx.serialization.Serializable

@Serializable
enum class PlatformType {
    UNSPECIFIED,
    ANDROID_MOBILE,
    ANDROID_TV,
    IOS;

    fun toEngagePlatformType(): Int {
        return when (this) {
            PlatformType.UNSPECIFIED -> EngagePlatformType.TYPE_UNSPECIFIED
            PlatformType.ANDROID_MOBILE -> EngagePlatformType.TYPE_ANDROID_MOBILE
            PlatformType.ANDROID_TV -> EngagePlatformType.TYPE_ANDROID_TV
            PlatformType.IOS -> EngagePlatformType.TYPE_IOS
        }
    }
}
