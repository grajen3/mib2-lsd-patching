/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.internal.media.clients.asi.ASIClient;
import de.vw.mib.asl.internal.media.sourcehandling.MediaAsiFilter;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.collections.SortedList;
import java.util.Comparator;

public class DeviceAsiList
implements MediaListObserver,
Comparator {
    private final MediaAsiFilter asiFilter;
    private Devices devices;

    public DeviceAsiList(MediaAsiFilter mediaAsiFilter) {
        this.asiFilter = mediaAsiFilter;
    }

    @Override
    public void onUpdate(Devices devices) {
        this.devices = devices;
        this.updateAvailableMediaSources(devices);
    }

    private void updateAvailableMediaSources(Devices devices) {
        if (devices == null) {
            return;
        }
        SortedList sortedList = new SortedList(this);
        MediaSourceSlot mediaSourceSlot = null;
        DeviceCollector deviceCollector = null;
        for (int i2 = 0; i2 < devices.count(); ++i2) {
            Device device = devices.get(i2);
            if (!this.asiFilter.passes(device)) continue;
            DeviceCollector deviceCollector2 = DeviceCollector.get(device);
            MediaSourceSlot mediaSourceSlot2 = this.getMediaSourceSlot(i2, deviceCollector2);
            sortedList.add(mediaSourceSlot2);
            if (!deviceCollector2.getMainPartition().isFlagSet(512)) continue;
            mediaSourceSlot = mediaSourceSlot2;
            deviceCollector = deviceCollector2;
        }
        ASIClient.updateSourceList((MediaSourceSlot[])sortedList.toArray(new MediaSourceSlot[sortedList.size()]));
        ASIClient.updateActiveMedia(mediaSourceSlot, this.getActiveSlotState(deviceCollector));
    }

    private MediaSourceSlot getMediaSourceSlot(int n, DeviceCollector deviceCollector) {
        return new MediaSourceSlot(this.getSourceId(deviceCollector), deviceCollector.getMainPartition().getSlotNumber(), this.getMediaType(deviceCollector), n, this.getSourceState(deviceCollector), this.getSourceFlags(deviceCollector), deviceCollector.getMainPartition().getName());
    }

    private int getActiveSlotState(DeviceCollector deviceCollector) {
        return 1;
    }

    private int getSourceFlags(DeviceCollector deviceCollector) {
        return 1;
    }

    private int getMediaType(DeviceCollector deviceCollector) {
        if (deviceCollector.getMainPartition().isCDDA()) {
            return 2;
        }
        if (deviceCollector.getMainPartition().isDVDVideoAudio()) {
            return 3;
        }
        if (deviceCollector.getMainPartition().isIPod()) {
            return 4;
        }
        if (deviceCollector.isUserAvailable()) {
            return 1;
        }
        return 0;
    }

    private int getSourceId(DeviceCollector deviceCollector) {
        switch (deviceCollector.getAslDeviceID()) {
            case 1: {
                return 1;
            }
            case 2: 
            case 10: 
            case 15: 
            case 16: {
                return 2;
            }
            case 4: {
                return 5;
            }
            case 5: {
                return 3;
            }
            case 7: 
            case 8: 
            case 13: 
            case 14: 
            case 17: 
            case 18: {
                return 4;
            }
        }
        return 0;
    }

    private int getSourceState(DeviceCollector deviceCollector) {
        if (deviceCollector.isDeviceActive()) {
            return 3;
        }
        if (deviceCollector.getMainPartition().isFlagSet(32)) {
            return 6;
        }
        if (deviceCollector.getMainPartition().isFlagSet(1)) {
            if (deviceCollector.getMainPartition().isHDD()) {
                return 9;
            }
            return 8;
        }
        if (deviceCollector.getMainPartition().getMediaType() == 12) {
            return 2;
        }
        if (deviceCollector.getMainPartition().getMediaType() == 10) {
            return 1;
        }
        if (deviceCollector.getMainPartition().getMediaType() == 11) {
            return 4;
        }
        if (deviceCollector.getMainPartition().getMediaType() == 15) {
            return 5;
        }
        if (!deviceCollector.isDevicePlayable() || !deviceCollector.isDeviceInValidState()) {
            return 10;
        }
        if (deviceCollector.isUserAvailable()) {
            return 3;
        }
        return 0;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (object == object2) {
            return 0;
        }
        MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)object;
        MediaSourceSlot mediaSourceSlot2 = (MediaSourceSlot)object2;
        return mediaSourceSlot.getDeviceIdx() - mediaSourceSlot2.getDeviceIdx();
    }

    public void updateList() {
        this.updateAvailableMediaSources(this.devices);
    }
}

