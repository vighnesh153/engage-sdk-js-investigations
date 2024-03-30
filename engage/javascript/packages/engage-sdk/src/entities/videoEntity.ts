import { Image, WatchNextType, DisplayTimeWindow } from "../common";
import { Entity } from "./entity";

export interface VideoEntity extends Entity {
  posterImages: Image[];
  entityId: string;
  name: string;
  lastEngagementTimeMillis: number;
  watchNextType: WatchNextType;
  lastPlaybackPositionTimeMillis: number;
  availabilityTimeWindows: DisplayTimeWindow[];
}
