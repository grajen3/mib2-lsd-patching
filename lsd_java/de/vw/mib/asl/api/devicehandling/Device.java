/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling;

import de.vw.mib.asl.api.devicehandling.DeviceState;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public final class Device {
    private final DeviceState previousState;
    private final DeviceState currentState;
    private final IntObjectOptHashMap tags = new IntObjectOptHashMap();
    private final int slot;
    private SourceId sourceId;
    private final ArrayList media;

    public DeviceState getPreviousState() {
        return this.previousState;
    }

    public DeviceState getCurrentState() {
        return this.currentState;
    }

    public DeviceInfo getPreviousInfo() {
        return this.previousState.getInfo();
    }

    public DeviceInfo getCurrentInfo() {
        return this.currentState.getInfo();
    }

    public IntObjectOptHashMap tags() {
        return this.tags;
    }

    public Device(int n) {
        this.slot = n;
        this.previousState = new DeviceState();
        this.currentState = new DeviceState();
        this.previousState.ensureCapacity(1);
        this.currentState.ensureCapacity(1);
        this.media = new ArrayList(1);
        this.media.add(new Medium(this, 0));
    }

    public SourceId getSourceId() {
        if (this.sourceId == null) {
            this.sourceId = new SourceId(this.getCurrentInfo().deviceType, this.slot);
        }
        return this.sourceId;
    }

    public boolean isStale() {
        return !this.previousState.isListed() && !this.currentState.isListed();
    }

    public void markNotListed() {
        this.updateDeviceInfo(DeviceState.EMPTY_DEVICEINFO);
    }

    public void updatePartitions(MediaInfo[] mediaInfoArray) {
        this.currentState.setInfo(this.previousState.getInfo());
        this.currentState.ensureCapacity(mediaInfoArray.length);
        while (this.getMediumCount() < mediaInfoArray.length) {
            this.media.add(new Medium(this, this.getMediumCount()));
        }
        for (int i2 = 0; i2 < mediaInfoArray.length; ++i2) {
            Medium medium = this.getMedium(i2);
            if (medium == null) {
                medium = new Medium(this, i2);
                this.media.add(i2, medium);
            }
            medium.getCurrentState().setInfo(mediaInfoArray[i2]);
            this.currentState.partitions[i2].deviceState = this.currentState;
        }
    }

    public void updateDeviceInfo(DeviceInfo deviceInfo) {
        this.swapStates(false, false);
        this.currentState.setInfo(deviceInfo);
    }

    public void swapStates(boolean bl, boolean bl2) {
        this.previousState.setInfo(this.getCurrentInfo());
        if (bl) {
            this.currentState.setInfo(DeviceState.EMPTY_DEVICEINFO);
        }
        for (int i2 = 0; i2 < this.getMediumCount(); ++i2) {
            this.getMedium(i2).swapStates(bl2);
        }
    }

    public int getSlot() {
        return this.slot;
    }

    public int getMediumCount() {
        return this.media.size();
    }

    public Medium getMedium(int n) {
        return (Medium)this.media.get(n);
    }

    public Medium getMainMedium() {
        for (int i2 = 0; i2 < this.getMediumCount(); ++i2) {
            if (!this.getMedium(i2).getCurrentState().isPlayable()) continue;
            return this.getMedium(i2);
        }
        return this.getMedium(0);
    }

    public Medium getMediumById(long l) {
        for (int i2 = 0; i2 < this.getMediumCount(); ++i2) {
            Medium medium = this.getMedium(i2);
            if (medium.getCurrentInfo().mediaID != l && medium.getCurrentInfo().getMediaType() != 8) continue;
            return medium;
        }
        return null;
    }

    public boolean isOptical() {
        return this.isInternalOptical() || this.isExternalOptical();
    }

    public boolean isInternalOptical() {
        switch (this.getCurrentInfo().getDeviceType()) {
            case 3: 
            case 4: 
            case 13: {
                return true;
            }
        }
        return false;
    }

    public boolean isChanger() {
        switch (this.getCurrentInfo().getDeviceType()) {
            case 5: 
            case 6: {
                return true;
            }
        }
        return false;
    }

    public boolean isExternalOptical() {
        switch (this.getCurrentInfo().getDeviceType()) {
            case 5: 
            case 6: {
                return true;
            }
        }
        return false;
    }

    public boolean isBluetooth() {
        return this.currentState.getInfo().getDeviceType() == 10;
    }

    public boolean isDisconnectable() {
        return this.currentState.isDisconnectable();
    }

    public static String getDeviceTypeStr(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "HDD";
                break;
            }
            case 1: {
                string = "SD";
                break;
            }
            case 2: {
                string = "USB";
                break;
            }
            case 3: {
                string = "DVD";
                break;
            }
            case 4: {
                string = "CD";
                break;
            }
            case 5: {
                string = "CD_CHANGER";
                break;
            }
            case 6: {
                string = "DVD_CHANGER";
                break;
            }
            case 8: {
                string = "AUX";
                break;
            }
            case 9: {
                string = "WLAN";
                break;
            }
            case 10: {
                string = "BT";
                break;
            }
            case 12: {
                string = "FILEPLAYER";
                break;
            }
            case 13: {
                string = "BLU-RAY";
                break;
            }
            default: {
                string = new StringBuffer().append("UNKNOWN(").append(n).append(")").toString();
            }
        }
        return string;
    }

    public String toString() {
        if (this.currentState.getInfo() == DeviceState.EMPTY_DEVICEINFO) {
            return "Device(no deviceInfo)";
        }
        return new StringBuffer().append("Device(").append(Device.getDeviceTypeStr(this.getCurrentInfo().getDeviceType())).append("/").append(this.getSlot()).append(")").toString();
    }
}

