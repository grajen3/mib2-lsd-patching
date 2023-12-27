/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SFecStateSerializer {
    public static void putOptionalSFecState(ISerializer iSerializer, SFecState sFecState) {
        boolean bl = sFecState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sFecState.getFsid();
            iSerializer.putUInt32(l);
            long l2 = sFecState.getIndex();
            iSerializer.putUInt32(l2);
            int n = sFecState.getFecState();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalSFecStateVarArray(ISerializer iSerializer, SFecState[] sFecStateArray) {
        boolean bl = sFecStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sFecStateArray.length);
            for (int i2 = 0; i2 < sFecStateArray.length; ++i2) {
                SFecStateSerializer.putOptionalSFecState(iSerializer, sFecStateArray[i2]);
            }
        }
    }

    public static SFecState getOptionalSFecState(IDeserializer iDeserializer) {
        SFecState sFecState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            long l2;
            sFecState = new SFecState();
            sFecState.fsid = l2 = iDeserializer.getUInt32();
            sFecState.index = l = iDeserializer.getUInt32();
            sFecState.fecState = n = iDeserializer.getEnum();
        }
        return sFecState;
    }

    public static SFecState[] getOptionalSFecStateVarArray(IDeserializer iDeserializer) {
        SFecState[] sFecStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sFecStateArray = new SFecState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sFecStateArray[i2] = SFecStateSerializer.getOptionalSFecState(iDeserializer);
            }
        }
        return sFecStateArray;
    }
}

