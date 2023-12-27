/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.DeviceChangeListener;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;

public abstract class MediumChangeListener
extends DeviceChangeListener {
    public MediumChangeListener() {
        this(DeviceFilter.IS_LISTED);
    }

    public MediumChangeListener(DeviceFilter deviceFilter) {
        super(deviceFilter);
    }

    protected abstract void onChange(Medium medium) {
    }

    @Override
    public final void onChange(Device device) {
        for (int i2 = 0; i2 < device.getMediumCount(); ++i2) {
            this.onChange(device.getMedium(i2));
        }
    }
}

