import {NativeModules} from 'react-native';
import {
  buildTvEpisodeEntity,
  buildMovieEntity,
  ContentAvailability,
  PlatformType,
  WatchNextType,
  type PublishContinuationClusterRequest,
  ImageTheme,
} from '@android/engage-sdk';

const {EngageNativeModule} = NativeModules;

export const EngageModule = {
  publishContinuationCluster: (
    publishContinuationClusterRequest: PublishContinuationClusterRequest,
  ) => {
    EngageNativeModule.publishContinuationCluster(
      JSON.stringify(publishContinuationClusterRequest),
    );
  },
};

export const samplePublishContinuationClusterRequest: PublishContinuationClusterRequest =
  {
    continuationClusters: [
      {
        accountProfile: {
          accountId: 'account-pokemon',
          profileId: 'profile-pikachu',
        },
        syncAcrossDevices: true,
        entities: [
          buildMovieEntity({
            availabilityTimeWindows: [
              {
                startTimeMillis: 11111,
                endTimeMillis: 22222,
              },
            ],
            contentAvailability: ContentAvailability.Available,
            contentRatings: [
              {
                agencyName: 'IMDb',
                ratingValue: 'US/PS/10',
              },
            ],
            durationMillis: 100000,
            entityId: 'avengers-endgame-movie',
            genres: ['thriller', 'sci-fi'],
            infoPageUri: 'https://www.marvel.com/movies/avengers-endgame/',
            isDownloadedOnDevice: false,
            lastEngagementTimeMillis: 2000,
            lastPlaybackPositionTimeMillis: 3000,
            name: 'Avengers Endgame',
            platformSpecificPlaybackUris: [
              {
                actionUri: 'https://playback.com/uri',
                platformType: PlatformType.AndroidTv,
              },
            ],
            playbackUri: 'https://playback.com/uri',
            posterImages: [
              {
                imageWidthInPixel: 100,
                imageHeightInPixel: 200,
                accessibilityText: 'avengers endgame poster',
                imageTheme: ImageTheme.Dark,
                imageUri: 'https://image.com/uri',
              },
            ],
            releaseDateEpochMillis: 400000,
            watchNextType: WatchNextType.New,
          }),
          buildTvEpisodeEntity({
            airDateEpochMillis: 100000,
            availabilityTimeWindows: [
              {
                startTimeMillis: 11111,
                endTimeMillis: 22222,
              },
            ],
            contentAvailability: ContentAvailability.Available,
            contentRatings: [
              {
                agencyName: 'IMDb',
                ratingValue: 'US/PS/10',
              },
            ],
            durationMillis: 100000,
            entityId: 'friends-episode-002',
            genres: ['comedy'],
            infoPageUri: 'https://friends.com/info',
            isDownloadedOnDevice: false,
            lastEngagementTimeMillis: 2000,
            lastPlaybackPositionTimeMillis: 3000,
            name: 'Avengers Endgame',
            platformSpecificPlaybackUris: [
              {
                actionUri: 'https://playback.com/uri',
                platformType: PlatformType.AndroidTv,
              },
            ],
            playbackUri: 'https://playback.com/uri',
            posterImages: [
              {
                imageWidthInPixel: 100,
                imageHeightInPixel: 200,
                accessibilityText: 'friends poster',
                imageTheme: ImageTheme.Dark,
                imageUri: 'https://image.com/uri',
              },
            ],
            watchNextType: WatchNextType.New,
            episodeDisplayNumber: '002',
            isNextEpisodeAvailable: true,
            seasonNumber: '001',
            seasonTitle: 'Season 1',
            showTitle: 'Friends',
          }),
        ],
      },
    ],
  };
