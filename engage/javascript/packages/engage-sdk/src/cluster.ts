import { AccountProfile } from "./common";
import { InternalEntity } from "./entities";

export interface ContinuationCluster {
  entities: InternalEntity[];
  syncAcrossDevices: boolean;
  accountProfile: AccountProfile;
}
