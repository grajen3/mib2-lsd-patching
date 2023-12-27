/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone.impl;

import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneNetworkState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sTelephoneNetworkStateSerializer {
    public static void putOptionalsTelephoneNetworkState(ISerializer iSerializer, sTelephoneNetworkState sTelephoneNetworkState2) {
        boolean bl = sTelephoneNetworkState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sTelephoneNetworkState2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sTelephoneNetworkState2.getLockstate();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalsTelephoneNetworkStateVarArray(ISerializer iSerializer, sTelephoneNetworkState[] sTelephoneNetworkStateArray) {
        boolean bl = sTelephoneNetworkStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sTelephoneNetworkStateArray.length);
            for (int i2 = 0; i2 < sTelephoneNetworkStateArray.length; ++i2) {
                sTelephoneNetworkStateSerializer.putOptionalsTelephoneNetworkState(iSerializer, sTelephoneNetworkStateArray[i2]);
            }
        }
    }

    public static sTelephoneNetworkState getOptionalsTelephoneNetworkState(IDeserializer iDeserializer) {
        sTelephoneNetworkState sTelephoneNetworkState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            sTelephoneNetworkState2 = new sTelephoneNetworkState();
            sTelephoneNetworkState2.msg_id = l = iDeserializer.getUInt32();
            sTelephoneNetworkState2.lockstate = n = iDeserializer.getEnum();
        }
        return sTelephoneNetworkState2;
    }

    public static sTelephoneNetworkState[] getOptionalsTelephoneNetworkStateVarArray(IDeserializer iDeserializer) {
        sTelephoneNetworkState[] sTelephoneNetworkStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sTelephoneNetworkStateArray = new sTelephoneNetworkState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sTelephoneNetworkStateArray[i2] = sTelephoneNetworkStateSerializer.getOptionalsTelephoneNetworkState(iDeserializer);
            }
        }
        return sTelephoneNetworkStateArray;
    }
}

