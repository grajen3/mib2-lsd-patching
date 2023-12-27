/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;

public class DoorLockingRearBlindSerializer {
    public static void putOptionalDoorLockingRearBlind(ISerializer iSerializer, DoorLockingRearBlind doorLockingRearBlind) {
        boolean bl = doorLockingRearBlind == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = doorLockingRearBlind.isRearBlindButton();
            iSerializer.putBool(bl2);
            boolean bl3 = doorLockingRearBlind.isRearBlindSunProtection();
            iSerializer.putBool(bl3);
            boolean bl4 = doorLockingRearBlind.isRearBlindReverseGear();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalDoorLockingRearBlindVarArray(ISerializer iSerializer, DoorLockingRearBlind[] doorLockingRearBlindArray) {
        boolean bl = doorLockingRearBlindArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingRearBlindArray.length);
            for (int i2 = 0; i2 < doorLockingRearBlindArray.length; ++i2) {
                DoorLockingRearBlindSerializer.putOptionalDoorLockingRearBlind(iSerializer, doorLockingRearBlindArray[i2]);
            }
        }
    }

    public static DoorLockingRearBlind getOptionalDoorLockingRearBlind(IDeserializer iDeserializer) {
        DoorLockingRearBlind doorLockingRearBlind = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            doorLockingRearBlind = new DoorLockingRearBlind();
            doorLockingRearBlind.rearBlindButton = bl4 = iDeserializer.getBool();
            doorLockingRearBlind.rearBlindSunProtection = bl3 = iDeserializer.getBool();
            doorLockingRearBlind.rearBlindReverseGear = bl2 = iDeserializer.getBool();
        }
        return doorLockingRearBlind;
    }

    public static DoorLockingRearBlind[] getOptionalDoorLockingRearBlindVarArray(IDeserializer iDeserializer) {
        DoorLockingRearBlind[] doorLockingRearBlindArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingRearBlindArray = new DoorLockingRearBlind[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingRearBlindArray[i2] = DoorLockingRearBlindSerializer.getOptionalDoorLockingRearBlind(iDeserializer);
            }
        }
        return doorLockingRearBlindArray;
    }
}

