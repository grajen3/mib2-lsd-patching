/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.dsi.carlight.impl.IntLightMembersIlluminationSetSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightMembersMultiColorSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightSetupColorsSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightConfig;
import org.dsi.ifc.carlight.IntLightMembersIlluminationSet;
import org.dsi.ifc.carlight.IntLightMembersMultiColor;
import org.dsi.ifc.carlight.IntLightSetupColors;
import org.dsi.ifc.carlight.IntLightTransmittableElements;

public class IntLightConfigSerializer {
    public static void putOptionalIntLightConfig(ISerializer iSerializer, IntLightConfig intLightConfig) {
        boolean bl = intLightConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = intLightConfig.isAmbienceStateAutoAvailable();
            iSerializer.putBool(bl2);
            boolean bl3 = intLightConfig.isAmbienceStatePrivacyAvailable();
            iSerializer.putBool(bl3);
            int n = intLightConfig.getSetupIlluminationSet1();
            iSerializer.putInt32(n);
            int n2 = intLightConfig.getSetupIlluminationSet2();
            iSerializer.putInt32(n2);
            int n3 = intLightConfig.getSetupIlluminationSet3();
            iSerializer.putInt32(n3);
            int n4 = intLightConfig.getSetupIlluminationSet4();
            iSerializer.putInt32(n4);
            int n5 = intLightConfig.getSetupIlluminationSet5();
            iSerializer.putInt32(n5);
            int n6 = intLightConfig.getSetupIlluminationSet6();
            iSerializer.putInt32(n6);
            int n7 = intLightConfig.getSetupIlluminationSet7();
            iSerializer.putInt32(n7);
            int n8 = intLightConfig.getSetupIlluminationSet8();
            iSerializer.putInt32(n8);
            IntLightMembersIlluminationSet intLightMembersIlluminationSet = intLightConfig.getMembersIlluminationSet1();
            IntLightMembersIlluminationSetSerializer.putOptionalIntLightMembersIlluminationSet(iSerializer, intLightMembersIlluminationSet);
            IntLightMembersIlluminationSet intLightMembersIlluminationSet2 = intLightConfig.getMembersIlluminationSet2();
            IntLightMembersIlluminationSetSerializer.putOptionalIntLightMembersIlluminationSet(iSerializer, intLightMembersIlluminationSet2);
            IntLightMembersIlluminationSet intLightMembersIlluminationSet3 = intLightConfig.getMembersIlluminationSet3();
            IntLightMembersIlluminationSetSerializer.putOptionalIntLightMembersIlluminationSet(iSerializer, intLightMembersIlluminationSet3);
            IntLightMembersIlluminationSet intLightMembersIlluminationSet4 = intLightConfig.getMembersIlluminationSet4();
            IntLightMembersIlluminationSetSerializer.putOptionalIntLightMembersIlluminationSet(iSerializer, intLightMembersIlluminationSet4);
            IntLightMembersIlluminationSet intLightMembersIlluminationSet5 = intLightConfig.getMembersIlluminationSet5();
            IntLightMembersIlluminationSetSerializer.putOptionalIntLightMembersIlluminationSet(iSerializer, intLightMembersIlluminationSet5);
            IntLightMembersIlluminationSet intLightMembersIlluminationSet6 = intLightConfig.getMembersIlluminationSet6();
            IntLightMembersIlluminationSetSerializer.putOptionalIntLightMembersIlluminationSet(iSerializer, intLightMembersIlluminationSet6);
            IntLightMembersIlluminationSet intLightMembersIlluminationSet7 = intLightConfig.getMembersIlluminationSet7();
            IntLightMembersIlluminationSetSerializer.putOptionalIntLightMembersIlluminationSet(iSerializer, intLightMembersIlluminationSet7);
            IntLightMembersIlluminationSet intLightMembersIlluminationSet8 = intLightConfig.getMembersIlluminationSet8();
            IntLightMembersIlluminationSetSerializer.putOptionalIntLightMembersIlluminationSet(iSerializer, intLightMembersIlluminationSet8);
            int n9 = intLightConfig.getSetupIlluminationProfile1();
            iSerializer.putInt32(n9);
            int n10 = intLightConfig.getSetupIlluminationProfile2();
            iSerializer.putInt32(n10);
            int n11 = intLightConfig.getSetupIlluminationProfile3();
            iSerializer.putInt32(n11);
            int n12 = intLightConfig.getSetupIlluminationProfile4();
            iSerializer.putInt32(n12);
            int n13 = intLightConfig.getSetupIlluminationProfile5();
            iSerializer.putInt32(n13);
            int n14 = intLightConfig.getSetupIlluminationProfile6();
            iSerializer.putInt32(n14);
            int n15 = intLightConfig.getSetupIlluminationProfile7();
            iSerializer.putInt32(n15);
            int n16 = intLightConfig.getSetupIlluminationProfile8();
            iSerializer.putInt32(n16);
            IntLightTransmittableElements intLightTransmittableElements = intLightConfig.getRgbColorListTransmittableElements();
            IntLightTransmittableElementsSerializer.putOptionalIntLightTransmittableElements(iSerializer, intLightTransmittableElements);
            IntLightMembersMultiColor intLightMembersMultiColor = intLightConfig.getMembersMultiColor();
            IntLightMembersMultiColorSerializer.putOptionalIntLightMembersMultiColor(iSerializer, intLightMembersMultiColor);
            IntLightSetupColors intLightSetupColors = intLightConfig.getSetupColors();
            IntLightSetupColorsSerializer.putOptionalIntLightSetupColors(iSerializer, intLightSetupColors);
        }
    }

    public static void putOptionalIntLightConfigVarArray(ISerializer iSerializer, IntLightConfig[] intLightConfigArray) {
        boolean bl = intLightConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightConfigArray.length);
            for (int i2 = 0; i2 < intLightConfigArray.length; ++i2) {
                IntLightConfigSerializer.putOptionalIntLightConfig(iSerializer, intLightConfigArray[i2]);
            }
        }
    }

    public static IntLightConfig getOptionalIntLightConfig(IDeserializer iDeserializer) {
        IntLightConfig intLightConfig = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            IntLightSetupColors intLightSetupColors;
            IntLightMembersMultiColor intLightMembersMultiColor;
            IntLightTransmittableElements intLightTransmittableElements;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            IntLightMembersIlluminationSet intLightMembersIlluminationSet;
            IntLightMembersIlluminationSet intLightMembersIlluminationSet2;
            IntLightMembersIlluminationSet intLightMembersIlluminationSet3;
            IntLightMembersIlluminationSet intLightMembersIlluminationSet4;
            IntLightMembersIlluminationSet intLightMembersIlluminationSet5;
            IntLightMembersIlluminationSet intLightMembersIlluminationSet6;
            IntLightMembersIlluminationSet intLightMembersIlluminationSet7;
            IntLightMembersIlluminationSet intLightMembersIlluminationSet8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            boolean bl2;
            boolean bl3;
            intLightConfig = new IntLightConfig();
            intLightConfig.ambienceStateAutoAvailable = bl3 = iDeserializer.getBool();
            intLightConfig.ambienceStatePrivacyAvailable = bl2 = iDeserializer.getBool();
            intLightConfig.setupIlluminationSet1 = n16 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationSet2 = n15 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationSet3 = n14 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationSet4 = n13 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationSet5 = n12 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationSet6 = n11 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationSet7 = n10 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationSet8 = n9 = iDeserializer.getInt32();
            intLightConfig.membersIlluminationSet1 = intLightMembersIlluminationSet8 = IntLightMembersIlluminationSetSerializer.getOptionalIntLightMembersIlluminationSet(iDeserializer);
            intLightConfig.membersIlluminationSet2 = intLightMembersIlluminationSet7 = IntLightMembersIlluminationSetSerializer.getOptionalIntLightMembersIlluminationSet(iDeserializer);
            intLightConfig.membersIlluminationSet3 = intLightMembersIlluminationSet6 = IntLightMembersIlluminationSetSerializer.getOptionalIntLightMembersIlluminationSet(iDeserializer);
            intLightConfig.membersIlluminationSet4 = intLightMembersIlluminationSet5 = IntLightMembersIlluminationSetSerializer.getOptionalIntLightMembersIlluminationSet(iDeserializer);
            intLightConfig.membersIlluminationSet5 = intLightMembersIlluminationSet4 = IntLightMembersIlluminationSetSerializer.getOptionalIntLightMembersIlluminationSet(iDeserializer);
            intLightConfig.membersIlluminationSet6 = intLightMembersIlluminationSet3 = IntLightMembersIlluminationSetSerializer.getOptionalIntLightMembersIlluminationSet(iDeserializer);
            intLightConfig.membersIlluminationSet7 = intLightMembersIlluminationSet2 = IntLightMembersIlluminationSetSerializer.getOptionalIntLightMembersIlluminationSet(iDeserializer);
            intLightConfig.membersIlluminationSet8 = intLightMembersIlluminationSet = IntLightMembersIlluminationSetSerializer.getOptionalIntLightMembersIlluminationSet(iDeserializer);
            intLightConfig.setupIlluminationProfile1 = n8 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationProfile2 = n7 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationProfile3 = n6 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationProfile4 = n5 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationProfile5 = n4 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationProfile6 = n3 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationProfile7 = n2 = iDeserializer.getInt32();
            intLightConfig.setupIlluminationProfile8 = n = iDeserializer.getInt32();
            intLightConfig.rgbColorListTransmittableElements = intLightTransmittableElements = IntLightTransmittableElementsSerializer.getOptionalIntLightTransmittableElements(iDeserializer);
            intLightConfig.membersMultiColor = intLightMembersMultiColor = IntLightMembersMultiColorSerializer.getOptionalIntLightMembersMultiColor(iDeserializer);
            intLightConfig.setupColors = intLightSetupColors = IntLightSetupColorsSerializer.getOptionalIntLightSetupColors(iDeserializer);
        }
        return intLightConfig;
    }

    public static IntLightConfig[] getOptionalIntLightConfigVarArray(IDeserializer iDeserializer) {
        IntLightConfig[] intLightConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightConfigArray = new IntLightConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightConfigArray[i2] = IntLightConfigSerializer.getOptionalIntLightConfig(iDeserializer);
            }
        }
        return intLightConfigArray;
    }
}

