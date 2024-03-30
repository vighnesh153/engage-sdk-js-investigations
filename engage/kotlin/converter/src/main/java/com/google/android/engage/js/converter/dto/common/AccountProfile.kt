package com.google.android.engage.js.converter.dto.common

import kotlinx.serialization.Serializable
import com.google.android.engage.common.datamodel.AccountProfile as EngageAccountProfile

@Serializable
data class AccountProfile(
    val accountId: String,
    val profileId: String?,
) {
    fun toEngageAccountProfile(): EngageAccountProfile {
        return EngageAccountProfile
            .Builder()
            .setAccountId(accountId)
            .apply { profileId?.let { setProfileId(it) } }
            .build()
    }
}
