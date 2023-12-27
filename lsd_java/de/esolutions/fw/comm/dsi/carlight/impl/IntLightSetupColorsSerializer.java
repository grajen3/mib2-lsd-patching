/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightSetupColors;

public class IntLightSetupColorsSerializer {
    public static void putOptionalIntLightSetupColors(ISerializer iSerializer, IntLightSetupColors intLightSetupColors) {
        boolean bl = intLightSetupColors == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = intLightSetupColors.isWarmWhite();
            iSerializer.putBool(bl2);
            boolean bl3 = intLightSetupColors.isColdWhite();
            iSerializer.putBool(bl3);
            boolean bl4 = intLightSetupColors.isRedWhite();
            iSerializer.putBool(bl4);
            boolean bl5 = intLightSetupColors.isOrange();
            iSerializer.putBool(bl5);
            boolean bl6 = intLightSetupColors.isBlue();
            iSerializer.putBool(bl6);
            boolean bl7 = intLightSetupColors.isCyan();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalIntLightSetupColorsVarArray(ISerializer iSerializer, IntLightSetupColors[] intLightSetupColorsArray) {
        boolean bl = intLightSetupColorsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightSetupColorsArray.length);
            for (int i2 = 0; i2 < intLightSetupColorsArray.length; ++i2) {
                IntLightSetupColorsSerializer.putOptionalIntLightSetupColors(iSerializer, intLightSetupColorsArray[i2]);
            }
        }
    }

    public static IntLightSetupColors getOptionalIntLightSetupColors(IDeserializer iDeserializer) {
        IntLightSetupColors intLightSetupColors = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            intLightSetupColors = new IntLightSetupColors();
            intLightSetupColors.warmWhite = bl7 = iDeserializer.getBool();
            intLightSetupColors.coldWhite = bl6 = iDeserializer.getBool();
            intLightSetupColors.redWhite = bl5 = iDeserializer.getBool();
            intLightSetupColors.orange = bl4 = iDeserializer.getBool();
            intLightSetupColors.blue = bl3 = iDeserializer.getBool();
            intLightSetupColors.cyan = bl2 = iDeserializer.getBool();
        }
        return intLightSetupColors;
    }

    public static IntLightSetupColors[] getOptionalIntLightSetupColorsVarArray(IDeserializer iDeserializer) {
        IntLightSetupColors[] intLightSetupColorsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightSetupColorsArray = new IntLightSetupColors[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightSetupColorsArray[i2] = IntLightSetupColorsSerializer.getOptionalIntLightSetupColors(iDeserializer);
            }
        }
        return intLightSetupColorsArray;
    }
}

