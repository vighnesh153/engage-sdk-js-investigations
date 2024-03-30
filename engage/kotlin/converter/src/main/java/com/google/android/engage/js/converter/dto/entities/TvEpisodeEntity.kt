package com.google.android.engage.js.converter.dto.entities

import android.net.Uri
import com.google.android.engage.common.datamodel.Entity as EngageEntity
import com.google.android.engage.video.datamodel.TvEpisodeEntity as EngageTvEpisodeEntity
import com.google.android.engage.js.converter.dto.common.ContentAvailability
import com.google.android.engage.js.converter.dto.common.DisplayTimeWindow
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
    val availabilityTimeWindows: List<DisplayTimeWindow>,

    val playbackUri: String,
    val infoPageUri: String,
    val airDateEpochMillis: Long,
    val contentAvailability: ContentAvailability,
    val genres: List<String>,
    val durationMillis: Long,
    val seasonNumber: String,
    val seasonTitle: String,
    val isDownloadedOnDevice: Boolean,
    val episodeDisplayNumber: String,
    val showTitle: String,
    val contentRatings: List<RatingSystem>,
    val isNextEpisodeAvailable: Boolean,
    val platformSpecificPlaybackUris: List<PlatformSpecificUri>,
) : Entity() {
    override fun toEngageEntity(): EngageEntity {
        return EngageTvEpisodeEntity
            .Builder()
            .addPosterImages(posterImages.map { it.toEngageImage() })
            .setEntityId(entityId)
            .setName(name)
            .setLastEngagementTimeMillis(lastEngagementTimeMillis)
            .setWatchNextType(watchNextType.toEngageWatchNextType())
            .setLastPlayBackPositionTimeMillis(lastPlaybackPositionTimeMillis)
            .addAllAvailabilityTimeWindows(availabilityTimeWindows.map { it.toEngageAvailabilityTimeWindow() })
            .setPlayBackUri(Uri.parse(playbackUri))
            .setInfoPageUri(Uri.parse(infoPageUri))
            .setAirDateEpochMillis(airDateEpochMillis)
            .setAvailability(contentAvailability.toEngageContentAvailability())
            .addGenres(genres)
            .setDurationMillis(durationMillis)
            .setSeasonNumber(seasonNumber)
            .setSeasonTitle(seasonTitle)
            .setDownloadedOnDevice(isDownloadedOnDevice)
            .setEpisodeDisplayNumber(episodeDisplayNumber)
            .setShowTitle(showTitle)
            .addContentRatings(contentRatings.map { it.toEngageRatingSystem() })
            .setIsNextEpisodeAvailable(isNextEpisodeAvailable)
            .addPlatformSpecificPlaybackUris(platformSpecificPlaybackUris.map { it.toEngagePlatformSpecificUri() })
            .build()
    }
}
