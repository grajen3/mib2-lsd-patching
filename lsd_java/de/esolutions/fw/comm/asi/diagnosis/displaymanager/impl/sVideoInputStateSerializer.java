/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.displaymanager.impl;

import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sVideoInputState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sVideoInputStateSerializer {
    public static void putOptionalsVideoInputState(ISerializer iSerializer, sVideoInputState sVideoInputState2) {
        boolean bl = sVideoInputState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sVideoInputState2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sVideoInputState2.getActiveSource();
            iSerializer.putEnum(n);
            int n2 = sVideoInputState2.getSourceState();
            iSerializer.putEnum(n2);
        }
    }

    public static void putOptionalsVideoInputStateVarArray(ISerializer iSerializer, sVideoInputState[] sVideoInputStateArray) {
        boolean bl = sVideoInputStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sVideoInputStateArray.length);
            for (int i2 = 0; i2 < sVideoInputStateArray.length; ++i2) {
                sVideoInputStateSerializer.putOptionalsVideoInputState(iSerializer, sVideoInputStateArray[i2]);
            }
        }
    }

    public static sVideoInputState getOptionalsVideoInputState(IDeserializer iDeserializer) {
        sVideoInputState sVideoInputState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            long l;
            sVideoInputState2 = new sVideoInputState();
            sVideoInputState2.msg_id = l = iDeserializer.getUInt32();
            sVideoInputState2.activeSource = n2 = iDeserializer.getEnum();
            sVideoInputState2.sourceState = n = iDeserializer.getEnum();
        }
        return sVideoInputState2;
    }

    public static sVideoInputState[] getOptionalsVideoInputStateVarArray(IDeserializer iDeserializer) {
        sVideoInputState[] sVideoInputStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sVideoInputStateArray = new sVideoInputState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sVideoInputStateArray[i2] = sVideoInputStateSerializer.getOptionalsVideoInputState(iDeserializer);
            }
        }
        return sVideoInputStateArray;
    }
}

