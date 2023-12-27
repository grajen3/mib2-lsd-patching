/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.LockStateStruct;

public class LockStateStructSerializer {
    public static void putOptionalLockStateStruct(ISerializer iSerializer, LockStateStruct lockStateStruct) {
        boolean bl = lockStateStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = lockStateStruct.getTelLockState();
            iSerializer.putInt32(n);
            int n2 = lockStateStruct.getTelRetryCounter();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalLockStateStructVarArray(ISerializer iSerializer, LockStateStruct[] lockStateStructArray) {
        boolean bl = lockStateStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lockStateStructArray.length);
            for (int i2 = 0; i2 < lockStateStructArray.length; ++i2) {
                LockStateStructSerializer.putOptionalLockStateStruct(iSerializer, lockStateStructArray[i2]);
            }
        }
    }

    public static LockStateStruct getOptionalLockStateStruct(IDeserializer iDeserializer) {
        LockStateStruct lockStateStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            lockStateStruct = new LockStateStruct();
            lockStateStruct.telLockState = n2 = iDeserializer.getInt32();
            lockStateStruct.telRetryCounter = n = iDeserializer.getInt32();
        }
        return lockStateStruct;
    }

    public static LockStateStruct[] getOptionalLockStateStructVarArray(IDeserializer iDeserializer) {
        LockStateStruct[] lockStateStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lockStateStructArray = new LockStateStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lockStateStructArray[i2] = LockStateStructSerializer.getOptionalLockStateStruct(iDeserializer);
            }
        }
        return lockStateStructArray;
    }
}

