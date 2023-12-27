/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceChangeListener;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.media.ASLMediaFactory;
import de.vw.mib.asl.internal.media.api.impl.ASLMediaAPIImpl;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import java.util.ArrayList;

public final class MediaDevices
extends DeviceChangeListener {
    private final DeviceFilter deviceFilter;
    private final ArrayList mDeviceCollectors = new ArrayList(9);

    MediaDevices(DeviceFilter deviceFilter) {
        super(deviceFilter);
        this.deviceFilter = deviceFilter;
        SourceIconController.getInstance().setMediaDevices(this);
        ((ASLMediaAPIImpl)ASLMediaFactory.getMediaApi()).setMediaDevices(this);
    }

    @Override
    public void onChange(Device device) {
        DeviceCollector deviceCollector = DeviceCollector.get(device);
        if (!device.getCurrentState().isListed()) {
            this.remove(deviceCollector);
            device.tags().remove(313463552);
        } else if (deviceCollector == null || deviceCollector == DeviceCollector.EMPTY) {
            deviceCollector = new DeviceCollector(device);
            this.mDeviceCollectors.add(deviceCollector);
            device.tags().put(313463552, deviceCollector);
            deviceCollector.adoptPartitions();
        }
    }

    public int getPlayableSourceCount() {
        int n = 0;
        for (int i2 = 0; i2 < this.mDeviceCollectors.size(); ++i2) {
            DeviceCollector deviceCollector = (DeviceCollector)this.mDeviceCollectors.get(i2);
            if (!deviceCollector.isDevicePlayable() || !deviceCollector.isDeviceInValidState() || !this.deviceFilter.passes(deviceCollector.getDevice())) continue;
            ++n;
        }
        return n;
    }

    private void remove(DeviceCollector deviceCollector) {
        this.mDeviceCollectors.remove(deviceCollector);
    }

    public DeviceCollector getByAslDeviceId(int n) {
        n &= 0xFFFF0000;
        for (int i2 = 0; i2 < this.mDeviceCollectors.size(); ++i2) {
            DeviceCollector deviceCollector = (DeviceCollector)this.mDeviceCollectors.get(i2);
            if (deviceCollector.getAslDeviceID() != n) continue;
            return deviceCollector;
        }
        return DeviceCollector.EMPTY;
    }

    public MediaCollector mediaCollectorFromObjectId(int n) {
        int n2 = n >> 16;
        int n3 = n & 0xFFFF0000;
        if (n3 == 0) {
            return MediaCollector.EMPTY;
        }
        DeviceCollector deviceCollector = this.getByAslDeviceId(n3);
        if (n2 == 0) {
            return deviceCollector.getMainPartition();
        }
        return deviceCollector.getPartitions()[n2 - 1];
    }

    public boolean isPartitionChoice(int n) {
        int n2 = n >> 16;
        int n3 = n & 0xFFFF0000;
        if (n3 == 0) {
            return false;
        }
        DeviceCollector deviceCollector = this.getByAslDeviceId(n3);
        return n2 == 0 && deviceCollector.isSeveralAvailablePartitionsAvailable();
    }
}

