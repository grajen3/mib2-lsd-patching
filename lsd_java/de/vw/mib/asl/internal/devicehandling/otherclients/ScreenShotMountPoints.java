/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling.otherclients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.DeviceState;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public class ScreenShotMountPoints
implements MediaListObserver {
    private final String[] mountPoints = new String[4];
    private static final int MSS_INDEX_SD1;
    private static final int MSS_INDEX_SD2;
    private static final int MSS_INDEX_USB1;
    private static final int MSS_INDEX_USB2;

    private String mountPointFromDevice(Device device) {
        if (device != null && device.getCurrentState() != null && device.getCurrentInfo() != null && device.getCurrentInfo() != DeviceState.EMPTY_DEVICEINFO && device.getMainMedium().getCurrentState().isMediaInSlot() && device.getMainMedium().getCurrentState().getInfo().getMountPoint() != null) {
            return device.getMainMedium().getCurrentState().getInfo().getMountPoint();
        }
        return "";
    }

    @Override
    public void onUpdate(Devices devices) {
        this.mountPoints[0] = this.mountPointFromDevice(devices.getByDeviceType(1, 0));
        this.mountPoints[1] = this.mountPointFromDevice(devices.getByDeviceType(1, 1));
        this.mountPoints[2] = this.mountPointFromDevice(devices.getByDeviceType(2, 0));
        this.mountPoints[3] = this.mountPointFromDevice(devices.getByDeviceType(2, 1));
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, this.mountPoints);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-960090880, eventGeneric);
    }
}

