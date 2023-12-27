/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

public class ASIHMISyncTV$ReplyIDs {
    public static final short updateASIVersion;
    public static final short updateRequestIDs;
    public static final short updateReplyIDs;
    public static final short updateStationInfo;
    public static final short updateActiveStationInfo;
    public static final short updateActiveTVStationState;
    public static final short updateTunerConfig;
    public static final short updatePanelKeySet;
    public static final short updateSeekStatus;
    public static final short updateTerminalMode;
    public static final short updateParentalSettings;

    public static short[] getIDs() {
        return new short[]{12, 20, 19, 23, 21, 22, 24, 14, 16, 18, 15};
    }
}

