/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.DoubleBaseType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class DoubleBaseTypeSerializer {
    public static void putOptionalDoubleBaseType(ISerializer iSerializer, DoubleBaseType doubleBaseType) {
        boolean bl = doubleBaseType == null;
        iSerializer.putBool(bl);
        if (!bl) {
            double d2 = doubleBaseType.getValue();
            iSerializer.putDouble(d2);
            int n = doubleBaseType.getUnit();
            iSerializer.putInt32(n);
            int n2 = doubleBaseType.getStatus();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDoubleBaseTypeVarArray(ISerializer iSerializer, DoubleBaseType[] doubleBaseTypeArray) {
        boolean bl = doubleBaseTypeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doubleBaseTypeArray.length);
            for (int i2 = 0; i2 < doubleBaseTypeArray.length; ++i2) {
                DoubleBaseTypeSerializer.putOptionalDoubleBaseType(iSerializer, doubleBaseTypeArray[i2]);
            }
        }
    }

    public static DoubleBaseType getOptionalDoubleBaseType(IDeserializer iDeserializer) {
        DoubleBaseType doubleBaseType = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            double d2;
            doubleBaseType = new DoubleBaseType();
            doubleBaseType.value = d2 = iDeserializer.getDouble();
            doubleBaseType.unit = n2 = iDeserializer.getInt32();
            doubleBaseType.status = n = iDeserializer.getInt32();
        }
        return doubleBaseType;
    }

    public static DoubleBaseType[] getOptionalDoubleBaseTypeVarArray(IDeserializer iDeserializer) {
        DoubleBaseType[] doubleBaseTypeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doubleBaseTypeArray = new DoubleBaseType[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doubleBaseTypeArray[i2] = DoubleBaseTypeSerializer.getOptionalDoubleBaseType(iDeserializer);
            }
        }
        return doubleBaseTypeArray;
    }
}

