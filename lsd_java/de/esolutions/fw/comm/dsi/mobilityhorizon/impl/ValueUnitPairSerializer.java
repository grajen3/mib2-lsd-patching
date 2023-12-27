/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mobilityhorizon.ValueUnitPair;

public class ValueUnitPairSerializer {
    public static void putOptionalValueUnitPair(ISerializer iSerializer, ValueUnitPair valueUnitPair) {
        boolean bl = valueUnitPair == null;
        iSerializer.putBool(bl);
        if (!bl) {
            float f2 = valueUnitPair.getValue();
            iSerializer.putFloat(f2);
            int n = valueUnitPair.getUnit();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalValueUnitPairVarArray(ISerializer iSerializer, ValueUnitPair[] valueUnitPairArray) {
        boolean bl = valueUnitPairArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(valueUnitPairArray.length);
            for (int i2 = 0; i2 < valueUnitPairArray.length; ++i2) {
                ValueUnitPairSerializer.putOptionalValueUnitPair(iSerializer, valueUnitPairArray[i2]);
            }
        }
    }

    public static ValueUnitPair getOptionalValueUnitPair(IDeserializer iDeserializer) {
        ValueUnitPair valueUnitPair = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            float f2;
            valueUnitPair = new ValueUnitPair();
            valueUnitPair.value = f2 = iDeserializer.getFloat();
            valueUnitPair.unit = n = iDeserializer.getInt32();
        }
        return valueUnitPair;
    }

    public static ValueUnitPair[] getOptionalValueUnitPairVarArray(IDeserializer iDeserializer) {
        ValueUnitPair[] valueUnitPairArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            valueUnitPairArray = new ValueUnitPair[n];
            for (int i2 = 0; i2 < n; ++i2) {
                valueUnitPairArray[i2] = ValueUnitPairSerializer.getOptionalValueUnitPair(iDeserializer);
            }
        }
        return valueUnitPairArray;
    }
}

