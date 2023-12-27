/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import generated.de.vw.mib.asl.internal.ListManager;

public class DiskChangerSlotList
implements MediaListObserver {
    private static final GenericASLList SLOT_LIST = ListManager.getGenericASLList(1096551424);

    @Override
    public void onUpdate(Devices devices) {
        Object[] objectArray;
        Device device = devices.getByDeviceType(6, 0);
        if (device != null && device.getCurrentState().isListed() && (objectArray = DeviceCollector.get(device).getPartitions()) != null) {
            SLOT_LIST.updateList(objectArray);
        }
    }
}

