/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightMembersMultiColor;

public class IntLightMembersMultiColorSerializer {
    public static void putOptionalIntLightMembersMultiColor(ISerializer iSerializer, IntLightMembersMultiColor intLightMembersMultiColor) {
        boolean bl = intLightMembersMultiColor == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = intLightMembersMultiColor.isFrontRoofLighting();
            iSerializer.putBool(bl2);
            boolean bl3 = intLightMembersMultiColor.isRearRoofLighting();
            iSerializer.putBool(bl3);
            boolean bl4 = intLightMembersMultiColor.isFrontFootwellLighting();
            iSerializer.putBool(bl4);
            boolean bl5 = intLightMembersMultiColor.isRearFootwellLighting();
            iSerializer.putBool(bl5);
            boolean bl6 = intLightMembersMultiColor.isFrontDoorsLighting();
            iSerializer.putBool(bl6);
            boolean bl7 = intLightMembersMultiColor.isRearDoorsLighting();
            iSerializer.putBool(bl7);
            boolean bl8 = intLightMembersMultiColor.isFrontDoorsWarningLighting();
            iSerializer.putBool(bl8);
            boolean bl9 = intLightMembersMultiColor.isRearDoorsWarningLighting();
            iSerializer.putBool(bl9);
            boolean bl10 = intLightMembersMultiColor.isFrontDoorsEntranceLighting();
            iSerializer.putBool(bl10);
            boolean bl11 = intLightMembersMultiColor.isRearDoorsEntranceLighting();
            iSerializer.putBool(bl11);
            boolean bl12 = intLightMembersMultiColor.isFrontDoorsStripLighting();
            iSerializer.putBool(bl12);
            boolean bl13 = intLightMembersMultiColor.isRearDoorsStripLighting();
            iSerializer.putBool(bl13);
            boolean bl14 = intLightMembersMultiColor.isCockpitStripLighting();
            iSerializer.putBool(bl14);
            boolean bl15 = intLightMembersMultiColor.isCupholderStripLighting();
            iSerializer.putBool(bl15);
            boolean bl16 = intLightMembersMultiColor.isPremiumSoundLighting();
            iSerializer.putBool(bl16);
            boolean bl17 = intLightMembersMultiColor.isSunRoofStripLighting();
            iSerializer.putBool(bl17);
            boolean bl18 = intLightMembersMultiColor.isFrontSliderLighting();
            iSerializer.putBool(bl18);
            boolean bl19 = intLightMembersMultiColor.isNavigationDeviceStripLighting();
            iSerializer.putBool(bl19);
            boolean bl20 = intLightMembersMultiColor.isFrontClimateControlStripLighting();
            iSerializer.putBool(bl20);
            boolean bl21 = intLightMembersMultiColor.isGearShiftLighting();
            iSerializer.putBool(bl21);
            boolean bl22 = intLightMembersMultiColor.isCenterControlLighting();
            iSerializer.putBool(bl22);
            boolean bl23 = intLightMembersMultiColor.isFrontDoorPocketLighting();
            iSerializer.putBool(bl23);
            boolean bl24 = intLightMembersMultiColor.isRearDoorPocketLighting();
            iSerializer.putBool(bl24);
        }
    }

    public static void putOptionalIntLightMembersMultiColorVarArray(ISerializer iSerializer, IntLightMembersMultiColor[] intLightMembersMultiColorArray) {
        boolean bl = intLightMembersMultiColorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightMembersMultiColorArray.length);
            for (int i2 = 0; i2 < intLightMembersMultiColorArray.length; ++i2) {
                IntLightMembersMultiColorSerializer.putOptionalIntLightMembersMultiColor(iSerializer, intLightMembersMultiColorArray[i2]);
            }
        }
    }

    public static IntLightMembersMultiColor getOptionalIntLightMembersMultiColor(IDeserializer iDeserializer) {
        IntLightMembersMultiColor intLightMembersMultiColor = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            boolean bl14;
            boolean bl15;
            boolean bl16;
            boolean bl17;
            boolean bl18;
            boolean bl19;
            boolean bl20;
            boolean bl21;
            boolean bl22;
            boolean bl23;
            boolean bl24;
            intLightMembersMultiColor = new IntLightMembersMultiColor();
            intLightMembersMultiColor.frontRoofLighting = bl24 = iDeserializer.getBool();
            intLightMembersMultiColor.rearRoofLighting = bl23 = iDeserializer.getBool();
            intLightMembersMultiColor.frontFootwellLighting = bl22 = iDeserializer.getBool();
            intLightMembersMultiColor.rearFootwellLighting = bl21 = iDeserializer.getBool();
            intLightMembersMultiColor.frontDoorsLighting = bl20 = iDeserializer.getBool();
            intLightMembersMultiColor.rearDoorsLighting = bl19 = iDeserializer.getBool();
            intLightMembersMultiColor.frontDoorsWarningLighting = bl18 = iDeserializer.getBool();
            intLightMembersMultiColor.rearDoorsWarningLighting = bl17 = iDeserializer.getBool();
            intLightMembersMultiColor.frontDoorsEntranceLighting = bl16 = iDeserializer.getBool();
            intLightMembersMultiColor.rearDoorsEntranceLighting = bl15 = iDeserializer.getBool();
            intLightMembersMultiColor.frontDoorsStripLighting = bl14 = iDeserializer.getBool();
            intLightMembersMultiColor.rearDoorsStripLighting = bl13 = iDeserializer.getBool();
            intLightMembersMultiColor.cockpitStripLighting = bl12 = iDeserializer.getBool();
            intLightMembersMultiColor.cupholderStripLighting = bl11 = iDeserializer.getBool();
            intLightMembersMultiColor.premiumSoundLighting = bl10 = iDeserializer.getBool();
            intLightMembersMultiColor.sunRoofStripLighting = bl9 = iDeserializer.getBool();
            intLightMembersMultiColor.frontSliderLighting = bl8 = iDeserializer.getBool();
            intLightMembersMultiColor.navigationDeviceStripLighting = bl7 = iDeserializer.getBool();
            intLightMembersMultiColor.frontClimateControlStripLighting = bl6 = iDeserializer.getBool();
            intLightMembersMultiColor.gearShiftLighting = bl5 = iDeserializer.getBool();
            intLightMembersMultiColor.centerControlLighting = bl4 = iDeserializer.getBool();
            intLightMembersMultiColor.frontDoorPocketLighting = bl3 = iDeserializer.getBool();
            intLightMembersMultiColor.rearDoorPocketLighting = bl2 = iDeserializer.getBool();
        }
        return intLightMembersMultiColor;
    }

    public static IntLightMembersMultiColor[] getOptionalIntLightMembersMultiColorVarArray(IDeserializer iDeserializer) {
        IntLightMembersMultiColor[] intLightMembersMultiColorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightMembersMultiColorArray = new IntLightMembersMultiColor[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightMembersMultiColorArray[i2] = IntLightMembersMultiColorSerializer.getOptionalIntLightMembersMultiColor(iDeserializer);
            }
        }
        return intLightMembersMultiColorArray;
    }
}

