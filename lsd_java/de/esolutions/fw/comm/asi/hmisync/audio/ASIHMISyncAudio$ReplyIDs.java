/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

public class ASIHMISyncAudio$ReplyIDs {
    public static final short responseEnableA2LS;
    public static final short updateASIVersion;
    public static final short updateRequestIDs;
    public static final short updateReplyIDs;
    public static final short updateAudioContext;
    public static final short updateFrontAudioContext;
    public static final short updateVolumeLockState;
    public static final short updateA2LSState;
    public static final short updateVolumeRange;
    public static final short updateVolume;
    public static final short updateAudibleState;

    public static short[] getIDs() {
        return new short[]{7, 13, 20, 19, 14, 15, 25, 23, 18, 17, 24};
    }
}

