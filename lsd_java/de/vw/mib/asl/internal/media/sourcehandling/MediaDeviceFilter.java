/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import org.dsi.ifc.media.DeviceInfo;

public class MediaDeviceFilter
implements DeviceFilter {
    private boolean auxPasses = true;

    @Override
    public boolean passes(Device device) {
        DeviceInfo deviceInfo = device.getCurrentInfo();
        if (deviceInfo == null || !this.isValid(deviceInfo.getDeviceType())) {
            return false;
        }
        if (!this.auxPasses && deviceInfo.getDeviceType() == 8) {
            return false;
        }
        return device.getMediumCount() != 0;
    }

    private boolean isValid(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: 
            case 13: {
                return true;
            }
        }
        return false;
    }

    public void setAuxPasses(boolean bl) {
        this.auxPasses = bl;
    }
}

