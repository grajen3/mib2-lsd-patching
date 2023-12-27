/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.control;

import de.vw.mib.asl.api.trafficminimap.ASLTrafficMiniMapServices;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapManager;

public class ASLTraffiMiniMapServicesImpl
implements ASLTrafficMiniMapServices {
    @Override
    public boolean isHotSpotActiveInSetup() {
        return TrafficMiniMapManager.getPersistence().isHotSpotMiniMapSetupStatusActive();
    }
}

