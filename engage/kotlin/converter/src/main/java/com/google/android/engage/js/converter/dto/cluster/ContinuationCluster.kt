package com.google.android.engage.js.converter.dto.cluster

import com.google.android.engage.common.datamodel.ContinuationCluster as EngageContinuationCluster
import com.google.android.engage.js.converter.dto.common.AccountProfile
import com.google.android.engage.js.converter.dto.entities.Entity
import kotlinx.serialization.Serializable

@Serializable
data class ContinuationCluster(
    val entities: List<Entity>,
    val syncAcrossDevices: Boolean,
    val accountProfile: AccountProfile,
) {
    fun toEngageContinuationCluster(): EngageContinuationCluster {
        return EngageContinuationCluster
            .Builder()
            .apply {
                entities.forEach {
                    addEntity(it.toEngageEntity())
                }
            }
            .setUserConsentToSyncAcrossDevices(syncAcrossDevices)
            .setAccountProfile(accountProfile.toEngageAccountProfile())
            .build()
    }
}
