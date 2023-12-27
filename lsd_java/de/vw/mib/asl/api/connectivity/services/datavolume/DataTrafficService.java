/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.connectivity.services.datavolume;

import de.vw.mib.asl.api.connectivity.services.datavolume.DataTraffic;
import de.vw.mib.asl.api.connectivity.services.datavolume.DataTrafficResponse;

public interface DataTrafficService {
    default public void requestDataVolume(DataTrafficResponse dataTrafficResponse) {
    }

    default public DataTraffic[] getLastDataTraffic() {
    }

    default public void resetDataVolume() {
    }

    default public void resetDataVolume(int n) {
    }
}

