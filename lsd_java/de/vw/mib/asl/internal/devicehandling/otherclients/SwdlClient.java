/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling.otherclients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public class SwdlClient
implements MediaListObserver {
    private int checkSwdl(Device device, int n) {
        if (device != null) {
            for (int i2 = 0; i2 < device.getMediumCount(); ++i2) {
                if (device.getMedium(i2).getCurrentInfo().getMediaType() != 17) continue;
                return 1 << n - 1;
            }
        }
        return 0;
    }

    @Override
    public void onUpdate(Devices devices) {
        int n = this.checkSwdl(devices.getInternalOptical(), 2) | this.checkSwdl(devices.getByDeviceType(1, 0), 4) | this.checkSwdl(devices.getByDeviceType(1, 1), 5) | this.checkSwdl(devices.getByDeviceType(2, 0), 3) | this.checkSwdl(devices.getByDeviceType(2, 1), 3);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-943313664, eventGeneric);
    }
}

