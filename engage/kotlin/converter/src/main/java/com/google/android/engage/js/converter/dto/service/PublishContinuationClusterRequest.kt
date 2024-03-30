package com.google.android.engage.js.converter.dto.service

import com.google.android.engage.js.converter.dto.cluster.ContinuationCluster
import kotlinx.serialization.Serializable
import com.google.android.engage.service.PublishContinuationClusterRequest as EngagePublishContinuationClusterRequest

@Serializable
data class PublishContinuationClusterRequest(
    val continuationClusters: List<ContinuationCluster>,
) {
    fun toEngagePublishContinuationClusterRequest(): EngagePublishContinuationClusterRequest {
        return EngagePublishContinuationClusterRequest
            .Builder()
            .setContinuationCluster(continuationClusters.first().toEngageContinuationCluster())
            .build()
    }
}
