/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;

public class DoorLockingUserProfileOnOffSerializer {
    public static void putOptionalDoorLockingUserProfileOnOff(ISerializer iSerializer, DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) {
        boolean bl = doorLockingUserProfileOnOff == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = doorLockingUserProfileOnOff.isHandling();
            iSerializer.putBool(bl2);
            boolean bl3 = doorLockingUserProfileOnOff.isAutoKeyAssignment();
            iSerializer.putBool(bl3);
            boolean bl4 = doorLockingUserProfileOnOff.isTemporaryKeyAssignment();
            iSerializer.putBool(bl4);
            boolean bl5 = doorLockingUserProfileOnOff.isAtneInMotion();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalDoorLockingUserProfileOnOffVarArray(ISerializer iSerializer, DoorLockingUserProfileOnOff[] doorLockingUserProfileOnOffArray) {
        boolean bl = doorLockingUserProfileOnOffArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingUserProfileOnOffArray.length);
            for (int i2 = 0; i2 < doorLockingUserProfileOnOffArray.length; ++i2) {
                DoorLockingUserProfileOnOffSerializer.putOptionalDoorLockingUserProfileOnOff(iSerializer, doorLockingUserProfileOnOffArray[i2]);
            }
        }
    }

    public static DoorLockingUserProfileOnOff getOptionalDoorLockingUserProfileOnOff(IDeserializer iDeserializer) {
        DoorLockingUserProfileOnOff doorLockingUserProfileOnOff = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            doorLockingUserProfileOnOff = new DoorLockingUserProfileOnOff();
            doorLockingUserProfileOnOff.handling = bl5 = iDeserializer.getBool();
            doorLockingUserProfileOnOff.autoKeyAssignment = bl4 = iDeserializer.getBool();
            doorLockingUserProfileOnOff.temporaryKeyAssignment = bl3 = iDeserializer.getBool();
            doorLockingUserProfileOnOff.atneInMotion = bl2 = iDeserializer.getBool();
        }
        return doorLockingUserProfileOnOff;
    }

    public static DoorLockingUserProfileOnOff[] getOptionalDoorLockingUserProfileOnOffVarArray(IDeserializer iDeserializer) {
        DoorLockingUserProfileOnOff[] doorLockingUserProfileOnOffArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingUserProfileOnOffArray = new DoorLockingUserProfileOnOff[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingUserProfileOnOffArray[i2] = DoorLockingUserProfileOnOffSerializer.getOptionalDoorLockingUserProfileOnOff(iDeserializer);
            }
        }
        return doorLockingUserProfileOnOffArray;
    }
}

