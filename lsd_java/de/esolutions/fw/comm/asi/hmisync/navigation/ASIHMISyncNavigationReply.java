/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;

public interface ASIHMISyncNavigationReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void startGuidanceToDestinationsResult(int n) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateRouteGuidanceActive(boolean bl, boolean bl2) {
    }

    default public void updateCarPosition(CarPosition carPosition, boolean bl) {
    }

    default public void updateDestinationInfo(DestinationInfo[] destinationInfoArray, boolean bl) {
    }

    default public void updateDestinationsForGuidance(DestinationInfo[] destinationInfoArray, boolean bl) {
    }

    default public void updateNextDestinationInfo(NextDestinationInfo nextDestinationInfo, boolean bl) {
    }

    default public void updateNightDesignRequested(boolean bl, boolean bl2) {
    }
}

