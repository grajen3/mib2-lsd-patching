/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.registry.impl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLDevice;
import de.vw.mib.asl.internal.registry.ASLDeviceAction;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceRegistryImpl$1;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public final class ASLDeviceRegistryImpl
implements ASLDeviceRegistry {
    private static final String PROPERTY_PREFIX;
    private static final int DEVICES_COUNT_DEFAULT;
    private static final int LISTS_COUNT_DEFAULT;
    private static final int DEVICES_COUNT;
    private static final int LISTS_COUNT;
    private final IntObjectMap devicesByTargetId = ASLDeviceRegistryImpl.createMap(DEVICES_COUNT).synchronize();
    final IntObjectMap devicesByListId = ASLDeviceRegistryImpl.createMap(LISTS_COUNT);
    final IntObjectMap listsByListId = ASLDeviceRegistryImpl.createMap(LISTS_COUNT);
    ASLListFactory listFactory;
    private final ASLListRegistry listRegistry = new ASLDeviceRegistryImpl$1(this);

    public ASLDeviceRegistryImpl(ASLListFactory aSLListFactory) {
        this.listFactory = aSLListFactory;
    }

    public void setListFactory(ASLListFactory aSLListFactory) {
        this.listFactory = aSLListFactory;
    }

    @Override
    public ASLDevice getASLDevice(int n) {
        ASLDevice aSLDevice = (ASLDevice)this.devicesByTargetId.get(n);
        if (null == aSLDevice) {
            throw new IllegalArgumentException(new StringBuffer().append("No device registered for target id: ").append(n).toString());
        }
        return aSLDevice;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ASLList getASLList(int n) {
        ASLList aSLList;
        IntObjectMap intObjectMap = this.listsByListId;
        synchronized (intObjectMap) {
            aSLList = (ASLList)this.listsByListId.get(n);
            if (null == aSLList) {
                ASLDevice aSLDevice = this.getASLDeviceForASLList(n);
                aSLList = aSLDevice.createASLList(this.listFactory, n);
                this.listsByListId.put(n, aSLList);
            }
        }
        return aSLList;
    }

    @Override
    public int[] getASLListColumns(int n) {
        return this.getASLDeviceForASLList(n).getASLListColumns(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isASLListRegistered(int n) {
        IntObjectMap intObjectMap = this.devicesByListId;
        synchronized (intObjectMap) {
            return this.devicesByListId.containsKey(n);
        }
    }

    @Override
    public boolean isASLDeviceRegistered(int n) {
        return this.devicesByTargetId.containsKey(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerASLDevice(ASLDevice aSLDevice) {
        this.devicesByTargetId.put(aSLDevice.getTargetId(), aSLDevice);
        IntObjectMap intObjectMap = this.devicesByListId;
        synchronized (intObjectMap) {
            aSLDevice.registerASLLists(this.listRegistry);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void executeForEachASLDevice(ASLDeviceAction aSLDeviceAction) {
        ASLDevice[] aSLDeviceArray;
        IntObjectMap intObjectMap = this.devicesByTargetId;
        synchronized (intObjectMap) {
            aSLDeviceArray = (ASLDevice[])this.devicesByTargetId.valuesToArray(new ASLDevice[this.devicesByTargetId.size()]);
        }
        for (int i2 = 0; i2 < aSLDeviceArray.length; ++i2) {
            aSLDeviceAction.execute(aSLDeviceArray[i2]);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ASLDevice getASLDeviceForASLList(int n) {
        ASLDevice aSLDevice;
        IntObjectMap intObjectMap = this.devicesByListId;
        synchronized (intObjectMap) {
            aSLDevice = (ASLDevice)this.devicesByListId.get(n);
        }
        if (null == aSLDevice) {
            throw new IllegalArgumentException(new StringBuffer().append("No device registered for list id: ").append(n).toString());
        }
        return aSLDevice;
    }

    private static IntObjectMap createMap(int n) {
        return IntObjectOptHashMap.createSlowlyGrowingHashmap(n, 63, 63);
    }

    static {
        DEVICES_COUNT = Integer.getInteger("de.vw.mib.asl.internal.registry.devicesCount", 150);
        LISTS_COUNT = Integer.getInteger("de.vw.mib.asl.internal.registry.listsCount", 707);
    }
}

