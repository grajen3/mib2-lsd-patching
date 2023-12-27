/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.dsi.carlight.impl.IntLightRGBValuesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBValues;

public class IntLightRGBColorListRA0Serializer {
    public static void putOptionalIntLightRGBColorListRA0(ISerializer iSerializer, IntLightRGBColorListRA0 intLightRGBColorListRA0) {
        boolean bl = intLightRGBColorListRA0 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = intLightRGBColorListRA0.getPos();
            iSerializer.putInt32(n);
            IntLightRGBValues intLightRGBValues = intLightRGBColorListRA0.getValues();
            IntLightRGBValuesSerializer.putOptionalIntLightRGBValues(iSerializer, intLightRGBValues);
        }
    }

    public static void putOptionalIntLightRGBColorListRA0VarArray(ISerializer iSerializer, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        boolean bl = intLightRGBColorListRA0Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightRGBColorListRA0Array.length);
            for (int i2 = 0; i2 < intLightRGBColorListRA0Array.length; ++i2) {
                IntLightRGBColorListRA0Serializer.putOptionalIntLightRGBColorListRA0(iSerializer, intLightRGBColorListRA0Array[i2]);
            }
        }
    }

    public static IntLightRGBColorListRA0 getOptionalIntLightRGBColorListRA0(IDeserializer iDeserializer) {
        IntLightRGBColorListRA0 intLightRGBColorListRA0 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            IntLightRGBValues intLightRGBValues;
            int n;
            intLightRGBColorListRA0 = new IntLightRGBColorListRA0();
            intLightRGBColorListRA0.pos = n = iDeserializer.getInt32();
            intLightRGBColorListRA0.values = intLightRGBValues = IntLightRGBValuesSerializer.getOptionalIntLightRGBValues(iDeserializer);
        }
        return intLightRGBColorListRA0;
    }

    public static IntLightRGBColorListRA0[] getOptionalIntLightRGBColorListRA0VarArray(IDeserializer iDeserializer) {
        IntLightRGBColorListRA0[] intLightRGBColorListRA0Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightRGBColorListRA0Array = new IntLightRGBColorListRA0[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightRGBColorListRA0Array[i2] = IntLightRGBColorListRA0Serializer.getOptionalIntLightRGBColorListRA0(iDeserializer);
            }
        }
        return intLightRGBColorListRA0Array;
    }
}

