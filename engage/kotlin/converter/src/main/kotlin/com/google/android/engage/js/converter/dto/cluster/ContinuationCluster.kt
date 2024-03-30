package com.google.android.engage.js.converter.dto.cluster

import com.google.android.engage.js.converter.dto.common.AccountProfile
import com.google.android.engage.js.converter.dto.entities.Entity

data class ContinuationCluster(
    val entities: List<Entity>,
    val syncAcrossDevices: Boolean,
    val accountProfile: AccountProfile,
)
