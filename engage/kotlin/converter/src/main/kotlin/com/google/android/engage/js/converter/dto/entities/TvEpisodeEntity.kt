package com.google.android.engage.js.converter.dto.entities

import com.google.android.engage.js.converter.dto.common.AvailabilityTimeWindow
import com.google.android.engage.js.converter.dto.common.ContentAvailability
import com.google.android.engage.js.converter.dto.common.Image
import com.google.android.engage.js.converter.dto.common.PlatformSpecificUri
import com.google.android.engage.js.converter.dto.common.RatingSystem
import com.google.android.engage.js.converter.dto.common.WatchNextType
import kotlinx.serialization.Serializable

@Serializable
data class TvEpisodeEntity(
    val posterImages: List<Image>,
    val entityId: String,
    val name: String,
    val lastEngagementTimeMillis: Long,
    val watchNextType: WatchNextType,
    val lastPlaybackPositionTimeMillis: Long,
    val availabilityTimeWindows: List<AvailabilityTimeWindow>,

    val playbackUri: String,
    val infoPageUri: String,
    val airDateEpochMillis: Long,
    val contentAvailability: ContentAvailability,
    val genres: List<String>,
    val contentRatingsLegacy: List<String>,
    val durationMillis: Long,
    val seasonNumber: String,
    val seasonTitle: String,
    val isDownloadedOnDevice: Boolean,
    val episodeDisplayNumber: String,
    val showTitle: String,
    val contentRatings: List<RatingSystem>,
    val isNextEpisodeAvailable: Boolean,
    val platformSpecificPlaybackUris: List<PlatformSpecificUri>,
) : Entity()
