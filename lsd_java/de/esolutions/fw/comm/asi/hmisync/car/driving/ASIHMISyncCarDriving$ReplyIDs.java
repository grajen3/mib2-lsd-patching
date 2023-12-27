/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving;

public class ASIHMISyncCarDriving$ReplyIDs {
    public static final short updateASIVersion;
    public static final short updateRequestIDs;
    public static final short updateReplyIDs;
    public static final short updateTADVehicleInfo;
    public static final short updateTADConfiguration;
    public static final short updateTADCurrentRollAngle;
    public static final short updateTADPosMaxRollAngle;
    public static final short updateTADNegMaxRollAngle;
    public static final short updateTADCurrentPitchAngle;
    public static final short updateTADPosMaxPitch;
    public static final short updateTADNegMaxPitch;
    public static final short updateTADVisibilityState;
    public static final short updateSuspensionControlCurrentLevel;
    public static final short updateSuspensionControlTargetLevel;
    public static final short updateSuspensionVisibilityState;
    public static final short updateDriveSelectActiveProfile;
    public static final short updateDriveSelectActiveProfileVisibilityState;

    public static short[] getIDs() {
        return new short[]{6, 10, 9, 20, 22, 15, 19, 17, 14, 18, 16, 21, 11, 12, 13, 7, 8};
    }
}

