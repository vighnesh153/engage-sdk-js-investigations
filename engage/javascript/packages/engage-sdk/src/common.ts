export interface AccountProfile {
  accountId: string;
  profileId: string;
}

export interface DisplayTimeWindow {
  startTimeMillis: number;
  endTimeMillis: number;
}

export enum ContentAvailability {
  Unknown = "UNKNOWN",
  Available = "AVAILABLE",
  FreeWithSubscription = "FREE_WITH_SUBSCRIPTION",
  PaidContent = "PAID_CONTENT",
}

export enum ImageTheme {
  Unspecified = "UNSPECIFIED",
  Light = "LIGHT",
  Dark = "DARK",
}

export interface Image {
  imageUri: string;
  imageWidthInPixel: number;
  imageHeightInPixel: number;
  accessibilityText: string;
  imageTheme: ImageTheme;
}

export enum PlatformType {
  Unspecified = "UNSPECIFIED",
  AndroidMobile = "ANDROID_MOBILE",
  AndroidTv = "ANDROID_TV",
  Ios = "IOS",
}

export interface PlatformSpecificUri {
  actionUri: string;
  platformType: PlatformType;
}

export interface RatingSystem {
  agencyName: string;
  ratingValue: string;
}

export enum WatchNextType {
  Unknown = "UNKNOWN",
  Continue = "CONTINUE",
  Next = "NEXT",
  New = "NEW",
  WatchList = "WATCHLIST",
}
