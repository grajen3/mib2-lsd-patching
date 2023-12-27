/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public abstract class AbstractDeviceList
implements MediaListObserver,
Comparator {
    private final DeviceFilter deviceFilter;
    private final Comparator comparator;
    private Devices devices = null;

    public AbstractDeviceList(DeviceFilter deviceFilter) {
        this.deviceFilter = deviceFilter;
        this.comparator = this;
    }

    @Override
    public void onUpdate(Devices devices) {
        this.devices = devices;
        this.updateList(false);
    }

    protected Device[] sort(Device[] deviceArray) {
        Arrays.sort(deviceArray, this.comparator);
        return deviceArray;
    }

    private int mapDeviceTypeToPos(int n) {
        switch (n) {
            case 0: {
                return 10;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 13: {
                return 20;
            }
            case 1: {
                return 30;
            }
            case 2: {
                return 40;
            }
            case 10: {
                return 50;
            }
            case 12: {
                return 50;
            }
            case 8: {
                return 60;
            }
            case 9: {
                return 70;
            }
        }
        return 999;
    }

    @Override
    public int compare(Object object, Object object2) {
        int n;
        if (object == object2) {
            return 0;
        }
        Device device = (Device)object;
        Device device2 = (Device)object2;
        int n2 = this.mapDeviceTypeToPos(device.getCurrentInfo().getDeviceType());
        if (n2 != (n = this.mapDeviceTypeToPos(device2.getCurrentInfo().getDeviceType()))) {
            return n2 - n;
        }
        return device.getSlot() - device2.getSlot();
    }

    public void updateList(boolean bl) {
        if (this.devices == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.devices.count());
        for (int i2 = 0; i2 < this.devices.count(); ++i2) {
            Device device = this.devices.get(i2);
            if (!this.deviceFilter.passes(device)) continue;
            arrayList.add(device);
        }
        this.updateList(this.sort((Device[])arrayList.toArray(new Device[arrayList.size()])), bl);
    }

    protected abstract void updateList(Device[] deviceArray, boolean bl) {
    }
}

