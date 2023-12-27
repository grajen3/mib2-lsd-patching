/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingBootBlindState;

public class DoorLockingBootBlindStateSerializer {
    public static void putOptionalDoorLockingBootBlindState(ISerializer iSerializer, DoorLockingBootBlindState doorLockingBootBlindState) {
        boolean bl = doorLockingBootBlindState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = doorLockingBootBlindState.getControl();
            iSerializer.putInt32(n);
            int n2 = doorLockingBootBlindState.getMotionState();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDoorLockingBootBlindStateVarArray(ISerializer iSerializer, DoorLockingBootBlindState[] doorLockingBootBlindStateArray) {
        boolean bl = doorLockingBootBlindStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingBootBlindStateArray.length);
            for (int i2 = 0; i2 < doorLockingBootBlindStateArray.length; ++i2) {
                DoorLockingBootBlindStateSerializer.putOptionalDoorLockingBootBlindState(iSerializer, doorLockingBootBlindStateArray[i2]);
            }
        }
    }

    public static DoorLockingBootBlindState getOptionalDoorLockingBootBlindState(IDeserializer iDeserializer) {
        DoorLockingBootBlindState doorLockingBootBlindState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            doorLockingBootBlindState = new DoorLockingBootBlindState();
            doorLockingBootBlindState.control = n2 = iDeserializer.getInt32();
            doorLockingBootBlindState.motionState = n = iDeserializer.getInt32();
        }
        return doorLockingBootBlindState;
    }

    public static DoorLockingBootBlindState[] getOptionalDoorLockingBootBlindStateVarArray(IDeserializer iDeserializer) {
        DoorLockingBootBlindState[] doorLockingBootBlindStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingBootBlindStateArray = new DoorLockingBootBlindState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingBootBlindStateArray[i2] = DoorLockingBootBlindStateSerializer.getOptionalDoorLockingBootBlindState(iDeserializer);
            }
        }
        return doorLockingBootBlindStateArray;
    }
}

