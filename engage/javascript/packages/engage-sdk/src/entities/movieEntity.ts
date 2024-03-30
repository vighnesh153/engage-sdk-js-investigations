import {
  ContentAvailability,
  PlatformSpecificUri,
  RatingSystem,
} from "../common";
import { InternalEntity } from "./entity";
import { VideoEntity } from "./videoEntity";

export interface MovieEntity extends VideoEntity {
  playbackUri: string;
  infoPageUri: string;
  releaseDateEpochMillis: number;
  contentAvailability: ContentAvailability;
  durationMillis: number;
  genres: string[];
  isDownloadedOnDevice: boolean;
  contentRatings: RatingSystem[];
  platformSpecificPlaybackUris: PlatformSpecificUri[];
}

interface InternalMovieEntity extends MovieEntity, InternalEntity {
  entityType: "com.google.android.engage.js.converter.dto.entities.MovieEntity";
}

export function buildMovieEntity(
  movieEntity: MovieEntity
): InternalMovieEntity {
  return {
    ...movieEntity,
    entityType:
      "com.google.android.engage.js.converter.dto.entities.MovieEntity",
  };
}
