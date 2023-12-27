/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.filebrowser.sourcehandling;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.util.Util;
import java.util.Arrays;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public class FileBrowserSourceInfo {
    private final Device device;
    private DeviceInfo deviceInfo;
    private MediaInfo[] mediaInfos;
    private final int sourceId;
    private int activeMediumIndex = -1;
    static final int SOURCEID_IGNORE;
    public static final int SOURCEID_INVALID;
    public static final int SOURCEID_CD_DVD;
    public static final int SOURCEID_SD1;
    public static final int SOURCEID_SD2;
    public static final int SOURCEID_USB_FS;
    public static final int SOURCEID_USB2FS;
    public static final int SOURCEID_USB3FS;
    public static final int SOURCEID_USB4FS;
    public static final int SOURCEID_COUNT;

    public static FileBrowserSourceInfo get(Device device) {
        return (FileBrowserSourceInfo)device.tags().get(-1041559040);
    }

    public FileBrowserSourceInfo(Device device) {
        this.device = device;
        device.tags().put(-1041559040, this);
        this.sync();
        this.sourceId = this.calcSourceId();
    }

    public void sync() {
        this.deviceInfo = this.device.getCurrentInfo();
        if (this.mediaInfos == null || this.mediaInfos.length != this.device.getMediumCount()) {
            this.mediaInfos = new MediaInfo[this.device.getMediumCount()];
        }
        for (int i2 = 0; i2 < this.device.getMediumCount(); ++i2) {
            this.mediaInfos[i2] = this.device.getMedium(i2).getCurrentInfo();
        }
    }

    private int calcSourceId() {
        if (this.device.isInternalOptical()) {
            return 0;
        }
        switch (this.device.getCurrentInfo().getDeviceType()) {
            case 1: {
                if (this.device.getSlot() == 0) {
                    return 1;
                }
                return 2;
            }
            case 2: {
                switch (this.device.getSlot()) {
                    case 0: {
                        return 3;
                    }
                    case 1: {
                        return 4;
                    }
                    case 2: {
                        return 5;
                    }
                    case 3: {
                        return 6;
                    }
                }
                return -2;
            }
        }
        return -2;
    }

    public boolean isAvailable() {
        return !Util.isNullOrEmpty(this.mediaInfos) && !Util.isBitSet(8, this.deviceInfo.flags) && !this.isDeviceInErrorState();
    }

    public boolean hasMedium(long l) {
        for (int i2 = 0; i2 < this.mediaInfos.length; ++i2) {
            if (this.mediaInfos[i2].mediaID != l) continue;
            return true;
        }
        return false;
    }

    public int getMediumIndex(long l) {
        for (int i2 = 0; i2 < this.mediaInfos.length; ++i2) {
            if (this.mediaInfos[i2].mediaID != l) continue;
            return i2;
        }
        return -1;
    }

    public MediaInfo getMediumAtIndex(int n) {
        return this.mediaInfos[n];
    }

    public int getPartitionByUniqueMediaID(String string) {
        for (int i2 = 0; i2 < this.mediaInfos.length; ++i2) {
            if (this.mediaInfos[i2].getUniqueMediaID().compareTo(string) != 0) continue;
            return i2;
        }
        return -1;
    }

    public void setActiveMedium(long l) {
        for (int i2 = 0; i2 < this.mediaInfos.length; ++i2) {
            if (this.mediaInfos[i2].mediaID != l) continue;
            this.activeMediumIndex = i2;
            return;
        }
        this.activeMediumIndex = -1;
    }

    public void setActiveMedium(int n) {
        this.activeMediumIndex = 0 <= n && n < this.mediaInfos.length ? n : -1;
    }

    public MediaInfo getActiveMedium() {
        if (0 <= this.activeMediumIndex && this.activeMediumIndex < this.mediaInfos.length) {
            return this.mediaInfos[this.activeMediumIndex];
        }
        return null;
    }

    public int getActiveMediumIndex() {
        return this.activeMediumIndex;
    }

    private boolean isDeviceInErrorState() {
        return 0 != (this.deviceInfo.flags & 0x74);
    }

    public String toString() {
        return new StringBuffer().append("FileBrowserSourceInfo [deviceInfo=").append(this.deviceInfo).append(", mediaInfos=").append(this.mediaInfos != null ? Arrays.asList(this.mediaInfos) : null).append(", sourceId=").append(this.sourceId).append(", activeMediumIndex=").append(this.activeMediumIndex).append("]").toString();
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public MediaInfo[] getMediaInfos() {
        return this.mediaInfos;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public Device getDevice() {
        return this.device;
    }
}

