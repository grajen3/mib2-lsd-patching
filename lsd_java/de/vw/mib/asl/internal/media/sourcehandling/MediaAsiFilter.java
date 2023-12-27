/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;

public class MediaAsiFilter
implements DeviceFilter {
    @Override
    public boolean passes(Device device) {
        if (!DeviceFilter.IS_LISTED.passes(device)) {
            return false;
        }
        switch (device.getCurrentInfo().getDeviceType()) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return device.getCurrentState().isAvailable();
            }
        }
        return false;
    }
}

