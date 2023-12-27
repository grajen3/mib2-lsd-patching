/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;

final class DeviceFilter$1
implements DeviceFilter {
    DeviceFilter$1() {
    }

    @Override
    public boolean passes(Device device) {
        return device.getCurrentState().isListed();
    }
}

