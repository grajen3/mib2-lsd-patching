/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.sources;

public class SourceId {
    private final int deviceType;
    private final int slot;
    public static final int DEVICETYPE_JUKEBOX;
    public static final int DEVICETYPE_SD;
    public static final int DEVICETYPE_USB;
    public static final int DEVICETYPE_DVDINT;
    public static final int DEVICETYPE_CDINT;
    public static final int DEVICETYPE_CDC;
    public static final int DEVICETYPE_DVDC;
    public static final int DEVICETYPE_AUX;
    public static final int DEVICETYPE_WLAN;
    public static final int DEVICETYPE_BT;
    public static final int DEVICETYPE_FILEPLAYER;
    public static final int DEVICETYPE_BDINT;

    public SourceId(int n, int n2) {
        this.deviceType = n;
        this.slot = n2;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getSlot() {
        return this.slot;
    }

    public String toString() {
        return new StringBuffer().append("SourceId [deviceType=").append(this.deviceType).append(", slot=").append(this.slot).append("]").toString();
    }

    public static boolean isEqual(SourceId sourceId, SourceId sourceId2) {
        if (sourceId == sourceId2) {
            return true;
        }
        if (sourceId == null || sourceId2 == null) {
            return false;
        }
        return sourceId.getDeviceType() == sourceId2.getDeviceType() && sourceId.getSlot() == sourceId2.getSlot();
    }
}

