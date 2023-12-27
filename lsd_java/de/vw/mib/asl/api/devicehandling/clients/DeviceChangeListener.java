/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;

public abstract class DeviceChangeListener
implements MediaListObserver {
    private final DeviceFilter deviceFilter;

    public DeviceChangeListener(DeviceFilter deviceFilter) {
        this.deviceFilter = deviceFilter;
        if (deviceFilter == null) {
            throw new IllegalArgumentException("deviceFilter must not be null!");
        }
    }

    protected abstract void onChange(Device device) {
    }

    @Override
    public void onUpdate(Devices devices) {
        for (int i2 = 0; i2 < devices.count(); ++i2) {
            if (!this.deviceFilter.passes(devices.get(i2))) continue;
            this.onChange(devices.get(i2));
        }
    }
}

