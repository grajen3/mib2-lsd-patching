/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightRGBValues;

public class IntLightRGBValuesSerializer {
    public static void putOptionalIntLightRGBValues(ISerializer iSerializer, IntLightRGBValues intLightRGBValues) {
        boolean bl = intLightRGBValues == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = intLightRGBValues.getBaseColorRed();
            iSerializer.putInt32(n);
            int n2 = intLightRGBValues.getBaseColorGreen();
            iSerializer.putInt32(n2);
            int n3 = intLightRGBValues.getBaseColorBlue();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalIntLightRGBValuesVarArray(ISerializer iSerializer, IntLightRGBValues[] intLightRGBValuesArray) {
        boolean bl = intLightRGBValuesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightRGBValuesArray.length);
            for (int i2 = 0; i2 < intLightRGBValuesArray.length; ++i2) {
                IntLightRGBValuesSerializer.putOptionalIntLightRGBValues(iSerializer, intLightRGBValuesArray[i2]);
            }
        }
    }

    public static IntLightRGBValues getOptionalIntLightRGBValues(IDeserializer iDeserializer) {
        IntLightRGBValues intLightRGBValues = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            intLightRGBValues = new IntLightRGBValues();
            intLightRGBValues.baseColorRed = n3 = iDeserializer.getInt32();
            intLightRGBValues.baseColorGreen = n2 = iDeserializer.getInt32();
            intLightRGBValues.baseColorBlue = n = iDeserializer.getInt32();
        }
        return intLightRGBValues;
    }

    public static IntLightRGBValues[] getOptionalIntLightRGBValuesVarArray(IDeserializer iDeserializer) {
        IntLightRGBValues[] intLightRGBValuesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightRGBValuesArray = new IntLightRGBValues[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightRGBValuesArray[i2] = IntLightRGBValuesSerializer.getOptionalIntLightRGBValues(iDeserializer);
            }
        }
        return intLightRGBValuesArray;
    }
}

