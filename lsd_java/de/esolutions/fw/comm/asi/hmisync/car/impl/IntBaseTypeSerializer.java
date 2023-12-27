/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class IntBaseTypeSerializer {
    public static void putOptionalIntBaseType(ISerializer iSerializer, IntBaseType intBaseType) {
        boolean bl = intBaseType == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = intBaseType.getValue();
            iSerializer.putInt32(n);
            int n2 = intBaseType.getUnit();
            iSerializer.putInt32(n2);
            int n3 = intBaseType.getStatus();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalIntBaseTypeVarArray(ISerializer iSerializer, IntBaseType[] intBaseTypeArray) {
        boolean bl = intBaseTypeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intBaseTypeArray.length);
            for (int i2 = 0; i2 < intBaseTypeArray.length; ++i2) {
                IntBaseTypeSerializer.putOptionalIntBaseType(iSerializer, intBaseTypeArray[i2]);
            }
        }
    }

    public static IntBaseType getOptionalIntBaseType(IDeserializer iDeserializer) {
        IntBaseType intBaseType = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            intBaseType = new IntBaseType();
            intBaseType.value = n3 = iDeserializer.getInt32();
            intBaseType.unit = n2 = iDeserializer.getInt32();
            intBaseType.status = n = iDeserializer.getInt32();
        }
        return intBaseType;
    }

    public static IntBaseType[] getOptionalIntBaseTypeVarArray(IDeserializer iDeserializer) {
        IntBaseType[] intBaseTypeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intBaseTypeArray = new IntBaseType[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intBaseTypeArray[i2] = IntBaseTypeSerializer.getOptionalIntBaseType(iDeserializer);
            }
        }
        return intBaseTypeArray;
    }
}

