/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.collections.ObjectOptHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.Arrays;
import java.util.Iterator;

public final class DeviceNameProvider
implements MediaListObserver {
    private final ObjectOptHashSet ipods = new ObjectOptHashSet(2);
    private final String[] usbNames = new String[2];
    private String avrcpName = "";

    private void clear() {
        this.ipods.clear();
        Arrays.fill(this.usbNames, "");
    }

    private void report() {
        this.provideIpodNames();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, this.avrcpName);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-993645312, eventGeneric);
        ServiceManager.aslPropertyManager.valueChangedString(3884, this.usbNames[0]);
        ServiceManager.aslPropertyManager.valueChangedString(3885, this.usbNames[1]);
    }

    private void provideIpodNames() {
        Object object;
        LogMessage logMessage = null;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            logMessage = ServiceManager.logger.trace(128).append("iPod names: {");
        }
        String[] stringArray = new String[this.ipods.size()];
        Iterator iterator = this.ipods.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            object = (Device)iterator.next();
            String string = ((Device)object).getMainMedium().getCurrentInfo().getName();
            if (logMessage != null) {
                logMessage.append(string);
                if (iterator.hasNext()) {
                    logMessage.append(", ");
                }
            }
            stringArray[n++] = string;
        }
        if (logMessage != null) {
            logMessage.append('}').log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent();
        ((EventGeneric)object).setObject(0, stringArray);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-1010422528, (EventGeneric)object);
    }

    private void extractNames(Devices devices) {
        Device device = devices.getByDeviceType(10, 0);
        if (device != null) {
            String string;
            this.avrcpName = string = device.getMainMedium().getCurrentInfo().getName();
        }
        for (int i2 = 0; i2 < devices.getDeviceTypeCount(2); ++i2) {
            String string;
            Device device2 = devices.getByDeviceType(2, i2);
            if (device2.getMainMedium().getCurrentInfo().getMediaType() == 20) {
                this.ipods.add(device2);
                continue;
            }
            if (i2 >= this.usbNames.length) continue;
            this.usbNames[i2] = string = device2.getMainMedium().getCurrentInfo().getName();
        }
    }

    @Override
    public void onUpdate(Devices devices) {
        this.clear();
        this.extractNames(devices);
        Device device = devices.getInternalOptical();
        if (device != null && device.getMainMedium().getCurrentState().isDVDVideoAudio()) {
            ServiceManager.aslPropertyManager.valueChangedString(576457728, device.getMainMedium().getCurrentInfo().getName());
            if (Util.isBitSet(64, device.getMainMedium().getCurrentState().getInfo().getFlags())) {
                ServiceManager.aslPropertyManager.valueChangedInteger(308022272, 1);
            } else if (Util.isBitSet(128, device.getMainMedium().getCurrentState().getInfo().getFlags())) {
                ServiceManager.aslPropertyManager.valueChangedInteger(308022272, 2);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(308022272, 0);
            }
        }
        this.report();
        ServiceManager.aslPropertyManager.valueChangedBoolean(1012665344, this.hasEjectables(devices));
    }

    private boolean hasEjectables(Devices devices) {
        for (int i2 = 0; i2 < devices.count(); ++i2) {
            Device device = devices.get(i2);
            if (device.getCurrentInfo().getDeviceType() != 1 && device.getCurrentInfo().getDeviceType() != 2 || !device.getCurrentState().isMediaInSlot()) continue;
            return true;
        }
        return false;
    }
}

