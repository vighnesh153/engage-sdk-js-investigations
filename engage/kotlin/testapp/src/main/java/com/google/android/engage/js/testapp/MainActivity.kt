package com.google.android.engage.js.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.android.engage.js.converter.dto.cluster.ContinuationCluster
import com.google.android.engage.js.converter.dto.common.AccountProfile
import com.google.android.engage.js.converter.dto.common.ContentAvailability
import com.google.android.engage.js.converter.dto.common.Image
import com.google.android.engage.js.converter.dto.common.ImageTheme
import com.google.android.engage.js.converter.dto.common.PlatformSpecificUri
import com.google.android.engage.js.converter.dto.common.PlatformType
import com.google.android.engage.js.converter.dto.common.RatingSystem
import com.google.android.engage.js.converter.dto.common.WatchNextType
import com.google.android.engage.js.converter.dto.entities.MovieEntity
import com.google.android.engage.js.converter.dto.service.PublishContinuationClusterRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Yellow)
            ) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .background(Color.Red)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun App() {
    LaunchedEffect(Unit) {
        val movieEntity = MovieEntity(
            posterImages = listOf(
                Image(
                    imageHeightInPixel = 100,
                    imageWidthInPixel = 200,
                    imageUri = "http://www.x.com/image",
                    imageTheme = ImageTheme.DARK,
                    accessibilityText = "no accessibility text provided"
                )
            ),
            entityId = "1",
            name = "Pikachu",
            lastEngagementTimeMillis = 100,
            watchNextType = WatchNextType.CONTINUE,
            lastPlaybackPositionTimeMillis = 200,
            availabilityTimeWindows = listOf(),
            playbackUri = "http://www.x.com/playback",
            infoPageUri = "http://www.x.com/infopage",
            releaseDateEpochMillis = 300,
            contentAvailability = ContentAvailability.AVAILABLE,
            durationMillis = 400,
            genres = listOf(),
            isDownloadedOnDevice = true,
            contentRatings = listOf(
                RatingSystem(
                    agencyName = "my-agency",
                    ratingValue = "US/TV/1",
                ),
            ),
            platformSpecificPlaybackUris = listOf(
                PlatformSpecificUri(
                    platformType = PlatformType.ANDROID_TV,
                    actionUri = "http://www.x.com/action",
                )
            )
        )
        val continuationClusterRequest = PublishContinuationClusterRequest(
            continuationClusters = listOf(
                ContinuationCluster(
                    entities = listOf(movieEntity),
                    syncAcrossDevices = true,
                    accountProfile = AccountProfile(
                        accountId = "account-123",
                        profileId = "profile-123",
                    )
                )
            )
        )

        val engagePublishContinuationClusterRequest = continuationClusterRequest
            .toEngagePublishContinuationClusterRequest()
    }
}

const val TAG = "Pikachu"