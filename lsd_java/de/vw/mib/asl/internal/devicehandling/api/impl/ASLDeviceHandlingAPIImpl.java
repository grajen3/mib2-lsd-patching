/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling.api.impl;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingAPI;
import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.devicehandling.DeviceHandlingTarget;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ASLDeviceHandlingAPIImpl
implements ASLDeviceHandlingAPI {
    private Devices devices = null;
    public final Collection pendingClients = new ArrayList();
    private IntIntOptHashMap deviceCount = new IntIntOptHashMap();

    @Override
    public void register(MediaListObserver mediaListObserver) {
        if (mediaListObserver == null) {
            throw new IllegalArgumentException("MediaListObserver parameter must not be null!");
        }
        this.pendingClients.add(mediaListObserver);
        if (ServiceManager.eventMain.getEventDispatcher().isTargetRegistered(1957630720)) {
            ServiceManager.eventMain.getEventDispatcher().sendSafe(ServiceManager.eventMain.getEventFactory().newEvent(1582116608));
        } else {
            ServiceManager.logger2.trace(1, "ASLDeviceHandlingAPIImpl.register() MAIN target not registered yet, pendingclients will be added on PowerOn event.");
        }
    }

    @Override
    public void registerArray(MediaListObserver[] mediaListObserverArray) {
        this.registerAll(Arrays.asList(mediaListObserverArray));
    }

    @Override
    public void registerAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            MediaListObserver mediaListObserver = (MediaListObserver)iterator.next();
            if (mediaListObserver != null) continue;
            throw new IllegalArgumentException("No MediaListObserver of array / Collection must be null!");
        }
        this.pendingClients.addAll(collection);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(ServiceManager.eventMain.getEventFactory().newEvent(1582116608));
    }

    @Override
    public boolean deregister(MediaListObserver mediaListObserver) {
        return DeviceHandlingTarget.deregister(mediaListObserver) || this.pendingClients.remove(mediaListObserver);
    }

    @Override
    public Devices getDevices() {
        return this.devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    public static ASLDeviceHandlingAPIImpl getInstance() {
        return (ASLDeviceHandlingAPIImpl)ASLDeviceHandlingFactory.getDeviceHandlingApi();
    }

    public void setDeviceCount(IntIntOptHashMap intIntOptHashMap) {
        this.deviceCount = intIntOptHashMap;
    }

    @Override
    public boolean is2ndUsbAvailable() {
        return this.getDeviceCount(2) >= 2;
    }

    @Override
    public boolean is2ndSdAvailable() {
        return this.getDeviceCount(1) >= 2;
    }

    @Override
    public int getDeviceCount(int n) {
        return this.deviceCount.get(n);
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(1, 1957630720, 1582116608, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, 1974407936, 1565339392, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, 1957630720, 2077371648);
        PreRegisteredIds.addServiceOrObserverToArray(1, 1957630720, 2094148864);
        PreRegisteredIds.addServiceOrObserverToArray(1, 1957630720, 2110926080);
    }
}

