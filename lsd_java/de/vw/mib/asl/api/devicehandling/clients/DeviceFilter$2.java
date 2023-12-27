/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;

final class DeviceFilter$2
implements DeviceFilter {
    DeviceFilter$2() {
    }

    @Override
    public boolean passes(Device device) {
        return device.isOptical() || device.getCurrentInfo().getDeviceType() == 1 || device.getCurrentInfo().getDeviceType() == 2;
    }
}

