/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingWindowStatus;

public class DoorLockingWindowStatusSerializer {
    public static void putOptionalDoorLockingWindowStatus(ISerializer iSerializer, DoorLockingWindowStatus doorLockingWindowStatus) {
        boolean bl = doorLockingWindowStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = doorLockingWindowStatus.getWindowDriver();
            iSerializer.putInt32(n);
            int n2 = doorLockingWindowStatus.getWindowCodriver();
            iSerializer.putInt32(n2);
            int n3 = doorLockingWindowStatus.getWindowFondRight();
            iSerializer.putInt32(n3);
            int n4 = doorLockingWindowStatus.getWindowFondLeft();
            iSerializer.putInt32(n4);
            int n5 = doorLockingWindowStatus.getSunRoof();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalDoorLockingWindowStatusVarArray(ISerializer iSerializer, DoorLockingWindowStatus[] doorLockingWindowStatusArray) {
        boolean bl = doorLockingWindowStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingWindowStatusArray.length);
            for (int i2 = 0; i2 < doorLockingWindowStatusArray.length; ++i2) {
                DoorLockingWindowStatusSerializer.putOptionalDoorLockingWindowStatus(iSerializer, doorLockingWindowStatusArray[i2]);
            }
        }
    }

    public static DoorLockingWindowStatus getOptionalDoorLockingWindowStatus(IDeserializer iDeserializer) {
        DoorLockingWindowStatus doorLockingWindowStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            doorLockingWindowStatus = new DoorLockingWindowStatus();
            doorLockingWindowStatus.windowDriver = n5 = iDeserializer.getInt32();
            doorLockingWindowStatus.windowCodriver = n4 = iDeserializer.getInt32();
            doorLockingWindowStatus.windowFondRight = n3 = iDeserializer.getInt32();
            doorLockingWindowStatus.windowFondLeft = n2 = iDeserializer.getInt32();
            doorLockingWindowStatus.sunRoof = n = iDeserializer.getInt32();
        }
        return doorLockingWindowStatus;
    }

    public static DoorLockingWindowStatus[] getOptionalDoorLockingWindowStatusVarArray(IDeserializer iDeserializer) {
        DoorLockingWindowStatus[] doorLockingWindowStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingWindowStatusArray = new DoorLockingWindowStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingWindowStatusArray[i2] = DoorLockingWindowStatusSerializer.getOptionalDoorLockingWindowStatus(iDeserializer);
            }
        }
        return doorLockingWindowStatusArray;
    }
}

