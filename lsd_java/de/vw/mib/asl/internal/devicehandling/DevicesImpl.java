/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.devicehandling.DeviceCoding;
import de.vw.mib.asl.internal.devicehandling.api.impl.ASLDeviceHandlingAPIImpl;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongObjectMultimap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public final class DevicesImpl
implements Devices {
    private final IntObjectOptHashMap deviceTypes = new IntObjectOptHashMap();
    private Device[] devices = new Device[0];
    private final LongObjectOptHashMap devicesByID = new LongObjectOptHashMap(14);
    private final DeviceCoding coding;
    private boolean devicesHaveMedia = false;
    DeviceInfo[] deviceList = null;
    private Device internalOptical = null;
    private final LongObjectMultimap mediaByDevices = new LongObjectMultimap();
    private boolean updateDeviceList;

    public DevicesImpl(DeviceCoding deviceCoding) {
        this.coding = deviceCoding;
    }

    @Override
    public int count() {
        return this.devices.length;
    }

    @Override
    public Device get(int n) {
        return this.devices[n];
    }

    @Override
    public int countPassing(DeviceFilter deviceFilter) {
        int n = 0;
        for (int i2 = 0; i2 < this.count(); ++i2) {
            if (!deviceFilter.passes(this.get(i2))) continue;
            ++n;
        }
        return n;
    }

    void updateDeviceList(DeviceInfo[] deviceInfoArray) {
        this.deviceList = deviceInfoArray;
        this.updateDeviceList();
    }

    void updateDeviceList() {
        int n;
        if (this.deviceList == null) {
            if (ServiceManager.logger2.isTraceEnabled(1)) {
                ServiceManager.logger2.trace(1).append("DevicesImpl.updateDeviceList(): no device list from DSI yet!").log();
            }
            return;
        }
        this.internalOptical = null;
        this.updateDeviceList = true;
        IntIntOptHashMap intIntOptHashMap = this.countDevicesPerType(this.deviceList);
        for (n = 0; n < this.deviceList.length; ++n) {
            this.devicesByID.remove(this.deviceList[n].getDeviceID());
        }
        n = this.processDevicesToList(intIntOptHashMap);
        if (this.devices.length != (n += this.removeStaleDevicesFromHashMap())) {
            this.devices = new Device[n];
        }
        int n2 = this.reAddUnlisted();
        if ((n2 = this.addDevicesToTheList(this.deviceList, intIntOptHashMap, n2)) != n) {
            throw new RuntimeException(new StringBuffer().append("DevicesImpl.updateDeviceList(): insertedDevices=").append(n2).append(" != totalListedDevices").append(n).toString());
        }
        if (ServiceManager.logger2.isTraceEnabled(1)) {
            ServiceManager.logger2.trace(1).append("DevicesImpl.updateDeviceList(): processed a valid device list.").log();
        }
    }

    private IntIntOptHashMap countDevicesPerType(DeviceInfo[] deviceInfoArray) {
        IntIntOptHashMap intIntOptHashMap = new IntIntOptHashMap(deviceInfoArray.length);
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            int n = deviceInfoArray[i2].getDeviceType();
            intIntOptHashMap.put(n, intIntOptHashMap.get(n) + 1);
        }
        return intIntOptHashMap;
    }

    private int processDevicesToList(IntIntOptHashMap intIntOptHashMap) {
        int n = 0;
        IntIntOptHashMap intIntOptHashMap2 = new IntIntOptHashMap(intIntOptHashMap.size());
        IntIterator intIterator = intIntOptHashMap.keyIterator();
        while (intIterator.hasNext()) {
            int n2 = intIterator.next();
            int n3 = Math.min(intIntOptHashMap.get(n2), this.coding.getSlotsAvailable(n2));
            intIntOptHashMap2.put(n2, n3);
            n += n3;
            if (this.deviceTypes.containsKey(n2)) continue;
            this.deviceTypes.put(n2, new ArrayList(n3));
        }
        ASLDeviceHandlingAPIImpl.getInstance().setDeviceCount(intIntOptHashMap2);
        return n;
    }

    private int removeStaleDevicesFromHashMap() {
        Object object;
        boolean bl = false;
        Iterator iterator = this.devicesByID.valueIterator();
        while (iterator.hasNext()) {
            object = (Device)iterator.next();
            if (!((Device)object).isStale()) continue;
            iterator.remove();
            bl = true;
        }
        if (bl) {
            iterator = this.deviceTypes.valueIterator();
            while (iterator.hasNext()) {
                object = (ArrayList)iterator.next();
                Iterator iterator2 = ((AbstractList)object).iterator();
                while (iterator2.hasNext()) {
                    Device device = (Device)iterator2.next();
                    if (!device.isStale()) continue;
                    iterator2.remove();
                }
                if (!((ArrayList)object).isEmpty()) continue;
                iterator.remove();
            }
        }
        return this.devicesByID.size();
    }

    private int reAddUnlisted() {
        int n = 0;
        Iterator iterator = this.devicesByID.valueIterator();
        while (iterator.hasNext()) {
            Device device = (Device)iterator.next();
            device.markNotListed();
            this.devices[n++] = device;
        }
        return n;
    }

    private int addDevicesToTheList(DeviceInfo[] deviceInfoArray, IntIntOptHashMap intIntOptHashMap, int n) {
        IntIntOptHashMap intIntOptHashMap2 = new IntIntOptHashMap(intIntOptHashMap.size());
        IntIntOptHashMap intIntOptHashMap3 = new IntIntOptHashMap(intIntOptHashMap.size());
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            int n2;
            DeviceInfo deviceInfo = deviceInfoArray[i2];
            int n3 = deviceInfo.getDeviceType();
            if (this.coding.isAvailable(n3, n2 = intIntOptHashMap3.get(n3))) {
                int n4 = intIntOptHashMap2.get(n3);
                intIntOptHashMap2.put(n3, n4 + 1);
                ArrayList arrayList = (ArrayList)this.deviceTypes.get(n3);
                if (arrayList.size() <= n4) {
                    arrayList.add(new Device(n4));
                    this.devicesHaveMedia = false;
                }
                Device device = (Device)arrayList.get(n4);
                this.devices[n++] = device;
                device.updateDeviceInfo(deviceInfo);
                this.devicesByID.put(deviceInfo.getDeviceID(), device);
                if (device.isInternalOptical()) {
                    this.internalOptical = device;
                }
            }
            intIntOptHashMap3.put(n3, n2 + 1);
        }
        return n;
    }

    @Override
    public Device getInternalOptical() {
        return this.internalOptical;
    }

    void updateMediaList(MediaInfo[] mediaInfoArray) {
        this.updateDeviceList = false;
        this.mediaByDevices.clear();
        this.swapStates(false, true);
        this.removeStaleDevices();
        for (int i2 = 0; i2 < mediaInfoArray.length; ++i2) {
            MediaInfo mediaInfo = mediaInfoArray[i2];
            this.mediaByDevices.put(mediaInfo.deviceID, mediaInfo);
        }
        if (!this.devicesByID.isEmpty()) {
            this.updateAllPartitions();
        }
    }

    private void updateAllPartitions() {
        LongIterator longIterator = this.mediaByDevices.keySet().iterator();
        while (longIterator.hasNext()) {
            long l = longIterator.next();
            Device device = this.getByDeviceId(l);
            if (device == null) {
                if (!ServiceManager.logger2.isTraceEnabled(1)) continue;
                ServiceManager.logger2.trace(1).append("DevicesImpl.updateMediaList(): deviceId ").append(l).append(" missing or device disabled by coding.").log();
                continue;
            }
            ObjectCollection objectCollection = this.mediaByDevices.getAll(l);
            MediaInfo[] mediaInfoArray = (MediaInfo[])objectCollection.toArray(new MediaInfo[objectCollection.size()]);
            device.updatePartitions(mediaInfoArray);
        }
        this.devicesHaveMedia = true;
    }

    private void removeStaleDevices() {
        int n = this.removeStaleDevicesFromHashMap();
        if (this.devices.length != n) {
            this.devices = new Device[n];
            int n2 = this.reAddUnlisted();
            if (n2 != n) {
                throw new RuntimeException(new StringBuffer().append("DevicesImpl.removeStaleDevices(): insertedDevices=").append(n2).append(" != totalListedDevices").append(n).toString());
            }
        }
    }

    private void swapStates(boolean bl, boolean bl2) {
        for (int i2 = 0; i2 < this.count(); ++i2) {
            this.get(i2).swapStates(bl, bl2);
        }
    }

    @Override
    public Device getByDeviceId(long l) {
        return (Device)this.devicesByID.get(l);
    }

    @Override
    public int getDeviceTypeCount(int n) {
        ArrayList arrayList = (ArrayList)this.deviceTypes.get(n);
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public Device getByDeviceType(int n, int n2) {
        ArrayList arrayList = (ArrayList)this.deviceTypes.get(n);
        if (arrayList == null || arrayList.size() <= n2) {
            return null;
        }
        return (Device)arrayList.get(n2);
    }

    @Override
    public Device getBySourceId(SourceId sourceId) {
        return this.getByDeviceType(sourceId.getDeviceType(), sourceId.getSlot());
    }

    @Override
    public boolean isUpdateDeviceList() {
        return this.updateDeviceList;
    }

    @Override
    public boolean isInitialized() {
        return this.devicesHaveMedia && this.coding.isInitialized();
    }

    void deInitialize() {
        this.devicesHaveMedia = false;
    }
}

