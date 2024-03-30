package com.google.android.engage.js.converter.dto.service

import com.google.android.engage.js.converter.dto.cluster.ContinuationCluster

data class PublishContinuationClusterRequest(
    val continuationClusters: List<ContinuationCluster>,
)
