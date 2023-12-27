/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling;

import de.vw.mib.asl.api.devicehandling.MediumState;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.DeviceInfo;

public final class DeviceState {
    public static final DeviceInfo EMPTY_DEVICEINFO = new DeviceInfo();
    private static final MediumState[] EMPTY_MEDIUMSTATE_ARRAY;
    private DeviceInfo info = EMPTY_DEVICEINFO;
    MediumState[] partitions = EMPTY_MEDIUMSTATE_ARRAY;

    public boolean isOperable() {
        return this.getInfo() != null && !Util.isAnyBitSet(124, this.getInfo().getFlags());
    }

    public DeviceInfo getInfo() {
        return this.info;
    }

    public void setInfo(DeviceInfo deviceInfo) {
        this.info = deviceInfo;
    }

    public boolean isAllMediaKnown() {
        for (int i2 = 0; i2 < this.partitions.length; ++i2) {
            if (this.partitions[i2].getInfo().getMediaType() != 0) continue;
            return false;
        }
        return true;
    }

    public MediumState getMainMedium() {
        return this.partitions[0];
    }

    public boolean isListed() {
        return this.info != EMPTY_DEVICEINFO;
    }

    void ensureCapacity(int n) {
        int n2;
        MediumState[] mediumStateArray = this.partitions;
        int n3 = n2 = mediumStateArray == null ? 0 : this.partitions.length;
        if (this.partitions == null || this.partitions.length != n) {
            this.partitions = new MediumState[n];
            if (mediumStateArray != null) {
                System.arraycopy((Object)mediumStateArray, 0, (Object)this.partitions, 0, Math.min(mediumStateArray.length, this.partitions.length));
            }
            for (int i2 = n2; i2 < this.partitions.length; ++i2) {
                this.partitions[i2] = new MediumState(this);
            }
        }
    }

    public boolean isAvailable() {
        for (int i2 = 0; i2 < this.partitions.length; ++i2) {
            if (!this.partitions[i2].isAvailable()) continue;
            return true;
        }
        return false;
    }

    public boolean isPlayable() {
        for (int i2 = 0; i2 < this.partitions.length; ++i2) {
            if (!this.partitions[i2].isPlayable()) continue;
            return true;
        }
        return false;
    }

    public boolean isMediaInSlot() {
        for (int i2 = 0; i2 < this.partitions.length; ++i2) {
            if (!this.partitions[i2].isMediaInSlot()) continue;
            return true;
        }
        return false;
    }

    public boolean isMultiPartition() {
        boolean bl = false;
        for (int i2 = 0; i2 < this.partitions.length; ++i2) {
            if (!this.partitions[i2].isMediaInSlot()) continue;
            if (bl) {
                return true;
            }
            bl = true;
        }
        return false;
    }

    public boolean isAnyLoading() {
        for (int i2 = 0; i2 < this.partitions.length; ++i2) {
            if (this.partitions[i2].getInfo().getMediaType() != 12) continue;
            return true;
        }
        return false;
    }

    public int countPictureViewerAvailable() {
        int n = 0;
        for (int i2 = 0; i2 < this.partitions.length; ++i2) {
            if (!this.partitions[i2].isPictureViewerAvailable()) continue;
            ++n;
        }
        return n;
    }

    public boolean isDisconnectable() {
        int n = this.info.getDeviceType();
        return n == 10 || n == 9;
    }

    public boolean isVersatile() {
        int n = this.info.getDeviceType();
        return n == 3 || n == 6 || n == 13;
    }

    public static String getDeviceFlagsStr(int n) {
        String string = "";
        if (Util.isBitSet(1, n)) {
            string = new StringBuffer().append(string).append("|COOPERATIVE").toString();
        }
        if (Util.isBitSet(2, n)) {
            string = new StringBuffer().append(string).append("|EXCLUSIVE").toString();
        }
        if (Util.isBitSet(4, n)) {
            string = new StringBuffer().append(string).append("|ERROR").toString();
        }
        if (Util.isBitSet(8, n)) {
            string = new StringBuffer().append(string).append("|UNAVAILABLE").toString();
        }
        if (Util.isBitSet(16, n)) {
            string = new StringBuffer().append(string).append("|OVERTEMP").toString();
        }
        if (Util.isBitSet(32, n)) {
            string = new StringBuffer().append(string).append("|UNDERTEMP").toString();
        }
        if (Util.isBitSet(64, n)) {
            string = new StringBuffer().append(string).append("|OVERCURRENT").toString();
        }
        if (string.length() == 0) {
            return "no flags";
        }
        return string.substring(1);
    }

    static {
        DeviceState.EMPTY_DEVICEINFO.deviceType = -1;
        EMPTY_MEDIUMSTATE_ARRAY = new MediumState[0];
    }
}

