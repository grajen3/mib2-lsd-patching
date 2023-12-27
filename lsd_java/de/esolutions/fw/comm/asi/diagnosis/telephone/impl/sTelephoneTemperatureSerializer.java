/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone.impl;

import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneTemperature;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sTelephoneTemperatureSerializer {
    public static void putOptionalsTelephoneTemperature(ISerializer iSerializer, sTelephoneTemperature sTelephoneTemperature2) {
        boolean bl = sTelephoneTemperature2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sTelephoneTemperature2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sTelephoneTemperature2.getCurrent();
            iSerializer.putInt16(s);
            short s2 = sTelephoneTemperature2.getMin();
            iSerializer.putInt16(s2);
            short s3 = sTelephoneTemperature2.getMax();
            iSerializer.putInt16(s3);
        }
    }

    public static void putOptionalsTelephoneTemperatureVarArray(ISerializer iSerializer, sTelephoneTemperature[] sTelephoneTemperatureArray) {
        boolean bl = sTelephoneTemperatureArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sTelephoneTemperatureArray.length);
            for (int i2 = 0; i2 < sTelephoneTemperatureArray.length; ++i2) {
                sTelephoneTemperatureSerializer.putOptionalsTelephoneTemperature(iSerializer, sTelephoneTemperatureArray[i2]);
            }
        }
    }

    public static sTelephoneTemperature getOptionalsTelephoneTemperature(IDeserializer iDeserializer) {
        sTelephoneTemperature sTelephoneTemperature2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            long l;
            sTelephoneTemperature2 = new sTelephoneTemperature();
            sTelephoneTemperature2.msg_id = l = iDeserializer.getUInt32();
            sTelephoneTemperature2.current = s3 = iDeserializer.getInt16();
            sTelephoneTemperature2.min = s2 = iDeserializer.getInt16();
            sTelephoneTemperature2.max = s = iDeserializer.getInt16();
        }
        return sTelephoneTemperature2;
    }

    public static sTelephoneTemperature[] getOptionalsTelephoneTemperatureVarArray(IDeserializer iDeserializer) {
        sTelephoneTemperature[] sTelephoneTemperatureArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sTelephoneTemperatureArray = new sTelephoneTemperature[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sTelephoneTemperatureArray[i2] = sTelephoneTemperatureSerializer.getOptionalsTelephoneTemperature(iDeserializer);
            }
        }
        return sTelephoneTemperatureArray;
    }
}

