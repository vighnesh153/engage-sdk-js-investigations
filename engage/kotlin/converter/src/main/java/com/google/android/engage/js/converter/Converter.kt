package com.google.android.engage.js.converter

import com.google.android.engage.js.converter.dto.service.PublishContinuationClusterRequest
import kotlinx.serialization.json.Json
import com.google.android.engage.service.PublishContinuationClusterRequest as EngagePublishContinuationClusterRequest

fun convertJsonToEngagePublishContinuationClusterRequest(json: String): EngagePublishContinuationClusterRequest {
    return Json
        .decodeFromString<PublishContinuationClusterRequest>(json)
        .toEngagePublishContinuationClusterRequest()
}
