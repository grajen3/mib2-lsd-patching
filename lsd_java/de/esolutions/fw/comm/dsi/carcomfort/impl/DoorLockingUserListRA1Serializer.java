/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;

public class DoorLockingUserListRA1Serializer {
    public static void putOptionalDoorLockingUserListRA1(ISerializer iSerializer, DoorLockingUserListRA1 doorLockingUserListRA1) {
        boolean bl = doorLockingUserListRA1 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = doorLockingUserListRA1.getPos();
            iSerializer.putInt32(n);
            int n2 = doorLockingUserListRA1.getType();
            iSerializer.putInt32(n2);
            String string = doorLockingUserListRA1.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalDoorLockingUserListRA1VarArray(ISerializer iSerializer, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        boolean bl = doorLockingUserListRA1Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingUserListRA1Array.length);
            for (int i2 = 0; i2 < doorLockingUserListRA1Array.length; ++i2) {
                DoorLockingUserListRA1Serializer.putOptionalDoorLockingUserListRA1(iSerializer, doorLockingUserListRA1Array[i2]);
            }
        }
    }

    public static DoorLockingUserListRA1 getOptionalDoorLockingUserListRA1(IDeserializer iDeserializer) {
        DoorLockingUserListRA1 doorLockingUserListRA1 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            doorLockingUserListRA1 = new DoorLockingUserListRA1();
            doorLockingUserListRA1.pos = n2 = iDeserializer.getInt32();
            doorLockingUserListRA1.type = n = iDeserializer.getInt32();
            doorLockingUserListRA1.name = string = iDeserializer.getOptionalString();
        }
        return doorLockingUserListRA1;
    }

    public static DoorLockingUserListRA1[] getOptionalDoorLockingUserListRA1VarArray(IDeserializer iDeserializer) {
        DoorLockingUserListRA1[] doorLockingUserListRA1Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingUserListRA1Array = new DoorLockingUserListRA1[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingUserListRA1Array[i2] = DoorLockingUserListRA1Serializer.getOptionalDoorLockingUserListRA1(iDeserializer);
            }
        }
        return doorLockingUserListRA1Array;
    }
}

