/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.sourcehandling;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;

final class TargetSourceHandling$1
implements DeviceFilter {
    TargetSourceHandling$1() {
    }

    @Override
    public boolean passes(Device device) {
        return DeviceFilter.REMOVABLE.passes(device) && device.getMainMedium().getCurrentState().isPictureViewerAvailable();
    }
}

