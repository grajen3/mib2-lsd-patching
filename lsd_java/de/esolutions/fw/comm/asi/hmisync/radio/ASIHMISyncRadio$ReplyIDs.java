/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

public class ASIHMISyncRadio$ReplyIDs {
    public static final short stationDetailsUpdated;
    public static final short updateASIVersion;
    public static final short updateRequestIDs;
    public static final short updateReplyIDs;
    public static final short updateBandList;
    public static final short updateActiveBand;
    public static final short updateRadioStationList;
    public static final short updateActiveStation;
    public static final short updateSeekStatus;
    public static final short updateWavebands;

    public static short[] getIDs() {
        return new short[]{20, 11, 18, 17, 14, 12, 22, 21, 16, 19};
    }
}

