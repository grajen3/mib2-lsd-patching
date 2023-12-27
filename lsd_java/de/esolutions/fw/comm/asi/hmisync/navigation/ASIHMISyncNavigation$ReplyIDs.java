/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

public class ASIHMISyncNavigation$ReplyIDs {
    public static final short startGuidanceToDestinationsResult;
    public static final short updateASIVersion;
    public static final short updateRequestIDs;
    public static final short updateReplyIDs;
    public static final short updateRouteGuidanceActive;
    public static final short updateCarPosition;
    public static final short updateDestinationInfo;
    public static final short updateDestinationsForGuidance;
    public static final short updateNextDestinationInfo;
    public static final short updateNightDesignRequested;

    public static short[] getIDs() {
        return new short[]{9, 10, 19, 18, 16, 11, 12, 13, 15, 17};
    }
}

