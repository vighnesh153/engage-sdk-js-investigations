import {
  ContentAvailability,
  PlatformSpecificUri,
  RatingSystem,
} from "../common";
import { InternalEntity } from "./entity";
import { VideoEntity } from "./videoEntity";

export interface TvEpisodeEntity extends VideoEntity {
  playbackUri: string;
  infoPageUri: string;
  airDateEpochMillis: number;
  contentAvailability: ContentAvailability;
  genres: string[];
  durationMillis: number;
  seasonNumber: string;
  seasonTitle: string;
  isDownloadedOnDevice: boolean;
  episodeDisplayNumber: string;
  showTitle: string;
  contentRatings: RatingSystem[];
  isNextEpisodeAvailable: boolean;
  platformSpecificPlaybackUris: PlatformSpecificUri[];
}

interface InternalTvEpisodeEntity extends TvEpisodeEntity, InternalEntity {
  entityType: "com.google.android.engage.js.converter.dto.entities.TvEpisodeEntity";
}

export function buildTvEpisodeEntity(
  tvEpisodeEntity: TvEpisodeEntity
): InternalTvEpisodeEntity {
  return {
    ...tvEpisodeEntity,
    entityType:
      "com.google.android.engage.js.converter.dto.entities.TvEpisodeEntity",
  };
}
