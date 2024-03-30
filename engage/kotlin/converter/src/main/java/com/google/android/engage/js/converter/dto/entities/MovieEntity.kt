package com.google.android.engage.js.converter.dto.entities

import android.net.Uri
import com.google.android.engage.common.datamodel.Entity as EngageEntity
import com.google.android.engage.js.converter.dto.common.ContentAvailability
import com.google.android.engage.js.converter.dto.common.DisplayTimeWindow
import com.google.android.engage.js.converter.dto.common.Image
import com.google.android.engage.js.converter.dto.common.PlatformSpecificUri
import com.google.android.engage.js.converter.dto.common.RatingSystem
import com.google.android.engage.js.converter.dto.common.WatchNextType
import com.google.android.engage.video.datamodel.MovieEntity as EngageMovieEntity
import kotlinx.serialization.Serializable

@Serializable
data class MovieEntity(
    val posterImages: List<Image>,
    val entityId: String,
    val name: String,
    val lastEngagementTimeMillis: Long,
    val watchNextType: WatchNextType,
    val lastPlaybackPositionTimeMillis: Long,
    val availabilityTimeWindows: List<DisplayTimeWindow>,

    val playbackUri: String,
    val infoPageUri: String,
    val releaseDateEpochMillis: Long,
    val contentAvailability: ContentAvailability,
    val durationMillis: Long,
    val genres: List<String>,
    val isDownloadedOnDevice: Boolean,
    val contentRatings: List<RatingSystem>,
    val platformSpecificPlaybackUris: List<PlatformSpecificUri>,
) : Entity() {
    override fun toEngageEntity(): EngageEntity {
        return EngageMovieEntity
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
            .setReleaseDateEpochMillis(releaseDateEpochMillis)
            .setAvailability(contentAvailability.toEngageContentAvailability())
            .setDurationMillis(durationMillis)
            .addGenres(genres)
            .setDownloadedOnDevice(isDownloadedOnDevice)
            .addContentRatings(contentRatings.map { it.toEngageRatingSystem() })
            .addPlatformSpecificPlaybackUris(platformSpecificPlaybackUris.map { it.toEngagePlatformSpecificUri() })
            .build()
    }
}
