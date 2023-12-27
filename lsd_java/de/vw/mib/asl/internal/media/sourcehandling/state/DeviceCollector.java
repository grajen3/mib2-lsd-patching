/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.state;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.DeviceState;
import de.vw.mib.asl.api.devicehandling.MediumState;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.clients.AslDeviceIdDeterminator;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import org.dsi.ifc.media.DeviceInfo;

public final class DeviceCollector {
    public static final DeviceCollector EMPTY = new DeviceCollector();
    private static final GenericASLList PARTITION_LIST = ListManager.getGenericASLList(3626);
    private int mASLDeviceID;
    private int mModelDeviceId;
    private MediaCollector[] mMediaPartitions = null;
    private MediaCollector mMainPartition = MediaCollector.EMPTY;
    private final Device mhDevice;
    public DeviceCollector nextAvailable = null;

    public static DeviceCollector get(Device device) {
        return (DeviceCollector)device.tags().get(313463552);
    }

    public Device getDevice() {
        return this.mhDevice;
    }

    public int getDeviceType() {
        return this.mhDevice.getCurrentInfo().getDeviceType();
    }

    void usePartition(MediaCollector mediaCollector) {
        this.mMediaPartitions = new MediaCollector[]{mediaCollector};
        this.mMainPartition = mediaCollector;
    }

    private DeviceCollector() {
        this.mhDevice = new Device(0);
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.deviceType = -1;
        deviceInfo.numSlots = 1;
        deviceInfo.deviceID = -1L;
        this.mhDevice.updateDeviceInfo(deviceInfo);
        this.mhDevice.updateDeviceInfo(deviceInfo);
        this.mhDevice.tags().put(313463552, this);
        this.mASLDeviceID = 0;
    }

    public DeviceCollector(Device device) {
        this.mhDevice = device;
    }

    public boolean isUserAvailable() {
        if (this.mhDevice.isBluetooth()) {
            return true;
        }
        if (!Util.isNullOrEmpty(this.mMediaPartitions)) {
            for (int i2 = 0; i2 < this.mMediaPartitions.length; ++i2) {
                if (!this.mMediaPartitions[i2].isUserAvailable()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isDeviceActive() {
        if (!Util.isNullOrEmpty(this.mMediaPartitions)) {
            for (int i2 = 0; i2 < this.mMediaPartitions.length; ++i2) {
                if (this.mMediaPartitions[i2] == null || !this.mMediaPartitions[i2].isMediaActive()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isDevicePlayable() {
        if (!Util.isNullOrEmpty(this.mMediaPartitions)) {
            for (int i2 = 0; i2 < this.mMediaPartitions.length; ++i2) {
                if (!this.mMediaPartitions[i2].isMediaPlayable()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isImportRunning() {
        if (!Util.isNullOrEmpty(this.mMediaPartitions)) {
            for (int i2 = 0; i2 < this.mMediaPartitions.length; ++i2) {
                if (!this.mMediaPartitions[i2].isImportRunning()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isDeviceInValidState() {
        if (this == EMPTY) {
            return true;
        }
        return this.mhDevice.getCurrentState().isOperable();
    }

    public int getAslDeviceID() {
        return this.mASLDeviceID;
    }

    public int getModelDeviceId() {
        return this.mModelDeviceId;
    }

    public int getObjectId() {
        return this.getAslDeviceID();
    }

    public int getAudioSourceObjectId() {
        if (!this.isSeveralAvailablePartitionsAvailable()) {
            return this.getAslDeviceID();
        }
        if (this.isDeviceActive()) {
            return this.getAslDeviceID();
        }
        return this.getMainPartition().getObjectId();
    }

    public MediaCollector[] getPartitions() {
        if (Util.isNullOrEmpty(this.mMediaPartitions)) {
            throw new IllegalStateException();
        }
        return this.mMediaPartitions;
    }

    public MediaCollector getMainPartition() {
        return this.mMainPartition;
    }

    void setMainPartition(MediaCollector mediaCollector) {
        this.mMainPartition = mediaCollector;
    }

    public MediaCollector firstPlayable() {
        for (int i2 = 0; i2 < this.mMediaPartitions.length; ++i2) {
            MediaCollector mediaCollector = this.mMediaPartitions[i2];
            if (!mediaCollector.isMediaPlayable()) continue;
            return mediaCollector;
        }
        return null;
    }

    private void setMainPartition() {
        if (Util.isNullOrEmpty(this.mMediaPartitions)) {
            throw new IllegalStateException();
        }
        if (this.mMediaPartitions.length == 1) {
            this.mMainPartition = this.mMediaPartitions[0];
            return;
        }
        AslDeviceIdDeterminator.updateDevice(this.mhDevice);
        int n = SourceHandlingPersistence.getInstance().getPartitionLSM(this.getAslDeviceID());
        if (n != -1 && n < this.mMediaPartitions.length) {
            this.mMainPartition = this.mMediaPartitions[n];
            return;
        }
        MediaCollector mediaCollector = this.firstPlayable();
        this.mMainPartition = mediaCollector != null ? mediaCollector : this.mMediaPartitions[0];
    }

    public void reset() {
        this.resetPartitionLsmAfterFailure();
        for (int i2 = 0; i2 < this.mMediaPartitions.length; ++i2) {
            this.mMediaPartitions[i2].setDatabaseFullReported(false);
        }
    }

    private void resetPartitionLsmAfterFailure() {
        if (!this.getMainPartition().isMediaPlayable()) {
            SourceHandlingPersistence.getInstance().resetPartitionLSM(this.getAslDeviceID());
            this.setMainPartition();
        }
    }

    public void adoptPartitions() {
        if (this == EMPTY) {
            throw new UnsupportedOperationException("Instance is marked immutable!");
        }
        int n = 0;
        for (int i2 = 0; i2 < this.mhDevice.getMediumCount(); ++i2) {
            MediaCollector mediaCollector;
            if (this.mMediaPartitions == null || n >= this.mMediaPartitions.length) {
                this.adaptPartitionArray();
            }
            if ((mediaCollector = this.mMediaPartitions[n]) == null || mediaCollector == MediaCollector.EMPTY) {
                this.mMediaPartitions[n] = mediaCollector = new MediaCollector(this.mhDevice.getMedium(i2), this);
            }
            ++n;
        }
        if (this.mhDevice.getMediumCount() != this.mhDevice.getCurrentInfo().getNumSlots()) {
            ServiceManager.logger.error(128).append("Number of partitions in media list (").append(n).append(") does not match getNumSlots() (").append(this.mhDevice.getCurrentInfo().getNumSlots()).append(") for device ").append(this.mhDevice.getCurrentInfo().getDeviceID()).log();
        }
        this.setMainPartition();
    }

    private void adaptPartitionArray() {
        int n = this.mhDevice.getCurrentInfo().getNumSlots();
        if (this.mMediaPartitions == null || n != this.mMediaPartitions.length) {
            MediaCollector[] mediaCollectorArray = new MediaCollector[n];
            if (this.mMediaPartitions != null) {
                System.arraycopy((Object)this.mMediaPartitions, 0, (Object)mediaCollectorArray, 0, Math.min(mediaCollectorArray.length, this.mMediaPartitions.length));
            }
            this.mMediaPartitions = mediaCollectorArray;
        }
    }

    public void setAslDeviceID(int n) {
        if (this == EMPTY) {
            throw new UnsupportedOperationException("Instance is marked immutable!");
        }
        this.mASLDeviceID = n;
        this.mModelDeviceId = n;
    }

    public void setModelDeviceId(int n) {
        this.mModelDeviceId = n;
    }

    public boolean isSeveralAvailablePartitionsAvailable() {
        return this.mhDevice.getCurrentState().isMultiPartition() && !this.mhDevice.isExternalOptical();
    }

    public void fillPartitionModelList() {
        if (!Util.isNullOrEmpty(this.mMediaPartitions)) {
            ArrayList arrayList = new ArrayList(this.mMediaPartitions.length);
            for (int i2 = 0; i2 < this.mMediaPartitions.length; ++i2) {
                if (!this.mMediaPartitions[i2].isUserAvailable()) continue;
                arrayList.add(this.mMediaPartitions[i2]);
            }
            Object[] objectArray = (MediaCollector[])arrayList.toArray(new MediaCollector[arrayList.size()]);
            PARTITION_LIST.updateList(objectArray);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("Filling partition model list, ASL id ").append(this.getAslDeviceID()).append(", deviceID: ").append(this.mhDevice.getCurrentInfo().getDeviceID()).append(", number of partitions: ").append(objectArray.length).log();
            }
        }
    }

    public static String getASLDeviceIDStr(int n) {
        String string = "UNKNOWN";
        switch (n) {
            case 1: {
                string = "CD/DVD";
                break;
            }
            case 2: {
                string = "SD";
                break;
            }
            case 3: {
                string = "AUX";
                break;
            }
            case 4: {
                string = "DVD_CHANGER";
                break;
            }
            case 5: {
                string = "HDD";
                break;
            }
            case 6: {
                string = "BT";
                break;
            }
            case 8: {
                string = "USB";
                break;
            }
            case 9: {
                string = "AUX_AV";
                break;
            }
            case 10: {
                string = "SD2";
                break;
            }
            case 11: {
                string = "WLAN";
                break;
            }
            case 12: {
                string = "MITSUMI";
                break;
            }
            case 13: {
                string = "USB2";
                break;
            }
            case 15: {
                string = "SD1-NAV DB";
                break;
            }
            case 16: {
                string = "SD2-NAV DB";
                break;
            }
            default: {
                string = new StringBuffer().append("UNKNOWN(").append(n).append(")").toString();
            }
        }
        return string;
    }

    public String toString() {
        if (this != EMPTY) {
            String string = Device.getDeviceTypeStr(this.getDeviceType());
            String string2 = DeviceCollector.getASLDeviceIDStr(this.mASLDeviceID);
            String string3 = DeviceState.getDeviceFlagsStr(this.mhDevice.getCurrentInfo().getFlags());
            String string4 = "";
            if (this.mMediaPartitions != null) {
                for (int i2 = 0; i2 < this.mMediaPartitions.length; ++i2) {
                    String string5 = this.mMediaPartitions[i2].isMediaActive() ? "*" : "";
                    string4 = new StringBuffer().append(string4).append("|").append(MediumState.getMediaTypeStr(this.mMediaPartitions[i2].getMediaType())).append("/").append(MediumState.getCriticalMediaFlagsStr(this.mMediaPartitions[i2].getFlags())).append(string5).toString();
                }
                string4 = string4.length() > 2 ? string4.substring(1) : "arr_empty";
            } else {
                string4 = "arr_null";
            }
            return new StringBuffer().append(string).append(":{").append(string4).append("} (").append(this.mhDevice.getCurrentInfo().getNumSlots()).append(" slots / dID: ").append(this.mhDevice.getCurrentInfo().deviceID).append(" / aslID: ").append(string2).append(") - [").append(string3).append("]").toString();
        }
        return "EMPTY DEVICE";
    }
}

