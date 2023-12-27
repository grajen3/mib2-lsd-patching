/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone.impl;

import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneAntennaState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sTelephoneAntennaStateSerializer {
    public static void putOptionalsTelephoneAntennaState(ISerializer iSerializer, sTelephoneAntennaState sTelephoneAntennaState2) {
        boolean bl = sTelephoneAntennaState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sTelephoneAntennaState2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sTelephoneAntennaState2.getAntenna();
            iSerializer.putEnum(n);
            int n2 = sTelephoneAntennaState2.getConnectionState();
            iSerializer.putEnum(n2);
            short s = sTelephoneAntennaState2.getAntennaCurrent();
            iSerializer.putUInt8(s);
            byte by = sTelephoneAntennaState2.getReceptionLevel();
            iSerializer.putInt8(by);
        }
    }

    public static void putOptionalsTelephoneAntennaStateVarArray(ISerializer iSerializer, sTelephoneAntennaState[] sTelephoneAntennaStateArray) {
        boolean bl = sTelephoneAntennaStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sTelephoneAntennaStateArray.length);
            for (int i2 = 0; i2 < sTelephoneAntennaStateArray.length; ++i2) {
                sTelephoneAntennaStateSerializer.putOptionalsTelephoneAntennaState(iSerializer, sTelephoneAntennaStateArray[i2]);
            }
        }
    }

    public static sTelephoneAntennaState getOptionalsTelephoneAntennaState(IDeserializer iDeserializer) {
        sTelephoneAntennaState sTelephoneAntennaState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            short s;
            int n;
            int n2;
            long l;
            sTelephoneAntennaState2 = new sTelephoneAntennaState();
            sTelephoneAntennaState2.msg_id = l = iDeserializer.getUInt32();
            sTelephoneAntennaState2.antenna = n2 = iDeserializer.getEnum();
            sTelephoneAntennaState2.connectionState = n = iDeserializer.getEnum();
            sTelephoneAntennaState2.antennaCurrent = s = iDeserializer.getUInt8();
            sTelephoneAntennaState2.receptionLevel = by = iDeserializer.getInt8();
        }
        return sTelephoneAntennaState2;
    }

    public static sTelephoneAntennaState[] getOptionalsTelephoneAntennaStateVarArray(IDeserializer iDeserializer) {
        sTelephoneAntennaState[] sTelephoneAntennaStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sTelephoneAntennaStateArray = new sTelephoneAntennaState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sTelephoneAntennaStateArray[i2] = sTelephoneAntennaStateSerializer.getOptionalsTelephoneAntennaState(iDeserializer);
            }
        }
        return sTelephoneAntennaStateArray;
    }
}

