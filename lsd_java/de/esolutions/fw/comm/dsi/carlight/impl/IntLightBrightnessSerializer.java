/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightBrightness;

public class IntLightBrightnessSerializer {
    public static void putOptionalIntLightBrightness(ISerializer iSerializer, IntLightBrightness intLightBrightness) {
        boolean bl = intLightBrightness == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = intLightBrightness.getBrightness();
            iSerializer.putInt16(s);
            boolean bl2 = intLightBrightness.isState();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalIntLightBrightnessVarArray(ISerializer iSerializer, IntLightBrightness[] intLightBrightnessArray) {
        boolean bl = intLightBrightnessArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightBrightnessArray.length);
            for (int i2 = 0; i2 < intLightBrightnessArray.length; ++i2) {
                IntLightBrightnessSerializer.putOptionalIntLightBrightness(iSerializer, intLightBrightnessArray[i2]);
            }
        }
    }

    public static IntLightBrightness getOptionalIntLightBrightness(IDeserializer iDeserializer) {
        IntLightBrightness intLightBrightness = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            short s;
            intLightBrightness = new IntLightBrightness();
            intLightBrightness.brightness = s = iDeserializer.getInt16();
            intLightBrightness.state = bl2 = iDeserializer.getBool();
        }
        return intLightBrightness;
    }

    public static IntLightBrightness[] getOptionalIntLightBrightnessVarArray(IDeserializer iDeserializer) {
        IntLightBrightness[] intLightBrightnessArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightBrightnessArray = new IntLightBrightness[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightBrightnessArray[i2] = IntLightBrightnessSerializer.getOptionalIntLightBrightness(iDeserializer);
            }
        }
        return intLightBrightnessArray;
    }
}

