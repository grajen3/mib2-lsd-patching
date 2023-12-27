/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingLockStatus;

public class DoorLockingLockStatusSerializer {
    public static void putOptionalDoorLockingLockStatus(ISerializer iSerializer, DoorLockingLockStatus doorLockingLockStatus) {
        boolean bl = doorLockingLockStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = doorLockingLockStatus.getVehicleLockState();
            iSerializer.putInt32(n);
            int n2 = doorLockingLockStatus.getDriverDoor();
            iSerializer.putInt32(n2);
            int n3 = doorLockingLockStatus.getCodriverDoor();
            iSerializer.putInt32(n3);
            int n4 = doorLockingLockStatus.getFondDoorRight();
            iSerializer.putInt32(n4);
            int n5 = doorLockingLockStatus.getFondDoorLeft();
            iSerializer.putInt32(n5);
            int n6 = doorLockingLockStatus.getHood();
            iSerializer.putInt32(n6);
            int n7 = doorLockingLockStatus.getBootlid();
            iSerializer.putInt32(n7);
            int n8 = doorLockingLockStatus.getFlap();
            iSerializer.putInt32(n8);
            boolean bl2 = doorLockingLockStatus.isVehicleSafe();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalDoorLockingLockStatusVarArray(ISerializer iSerializer, DoorLockingLockStatus[] doorLockingLockStatusArray) {
        boolean bl = doorLockingLockStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingLockStatusArray.length);
            for (int i2 = 0; i2 < doorLockingLockStatusArray.length; ++i2) {
                DoorLockingLockStatusSerializer.putOptionalDoorLockingLockStatus(iSerializer, doorLockingLockStatusArray[i2]);
            }
        }
    }

    public static DoorLockingLockStatus getOptionalDoorLockingLockStatus(IDeserializer iDeserializer) {
        DoorLockingLockStatus doorLockingLockStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            doorLockingLockStatus = new DoorLockingLockStatus();
            doorLockingLockStatus.vehicleLockState = n8 = iDeserializer.getInt32();
            doorLockingLockStatus.driverDoor = n7 = iDeserializer.getInt32();
            doorLockingLockStatus.codriverDoor = n6 = iDeserializer.getInt32();
            doorLockingLockStatus.fondDoorRight = n5 = iDeserializer.getInt32();
            doorLockingLockStatus.fondDoorLeft = n4 = iDeserializer.getInt32();
            doorLockingLockStatus.hood = n3 = iDeserializer.getInt32();
            doorLockingLockStatus.bootlid = n2 = iDeserializer.getInt32();
            doorLockingLockStatus.flap = n = iDeserializer.getInt32();
            doorLockingLockStatus.vehicleSafe = bl2 = iDeserializer.getBool();
        }
        return doorLockingLockStatus;
    }

    public static DoorLockingLockStatus[] getOptionalDoorLockingLockStatusVarArray(IDeserializer iDeserializer) {
        DoorLockingLockStatus[] doorLockingLockStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingLockStatusArray = new DoorLockingLockStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingLockStatusArray[i2] = DoorLockingLockStatusSerializer.getOptionalDoorLockingLockStatus(iDeserializer);
            }
        }
        return doorLockingLockStatusArray;
    }
}

