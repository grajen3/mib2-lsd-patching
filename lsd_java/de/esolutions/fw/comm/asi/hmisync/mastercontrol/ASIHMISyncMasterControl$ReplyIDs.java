/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol;

public class ASIHMISyncMasterControl$ReplyIDs {
    public static final short factoryReset;
    public static final short enterAppContext;
    public static final short updateASIVersion;
    public static final short updateRequestIDs;
    public static final short updateReplyIDs;
    public static final short updateHUVersion;
    public static final short updateVIN;
    public static final short updateLockState;
    public static final short updateBlockState;

    public static short[] getIDs() {
        return new short[]{4, 3, 8, 14, 13, 10, 12, 11, 9};
    }
}

