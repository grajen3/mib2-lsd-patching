/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightMembersIlluminationSet;

public class IntLightMembersIlluminationSetSerializer {
    public static void putOptionalIntLightMembersIlluminationSet(ISerializer iSerializer, IntLightMembersIlluminationSet intLightMembersIlluminationSet) {
        boolean bl = intLightMembersIlluminationSet == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = intLightMembersIlluminationSet.isFrontRoofLighting();
            iSerializer.putBool(bl2);
            boolean bl3 = intLightMembersIlluminationSet.isRearRoofLighting();
            iSerializer.putBool(bl3);
            boolean bl4 = intLightMembersIlluminationSet.isFrontFootwellLighting();
            iSerializer.putBool(bl4);
            boolean bl5 = intLightMembersIlluminationSet.isRearFootwellLighting();
            iSerializer.putBool(bl5);
            boolean bl6 = intLightMembersIlluminationSet.isFrontDoorsLighting();
            iSerializer.putBool(bl6);
            boolean bl7 = intLightMembersIlluminationSet.isRearDoorsLighting();
            iSerializer.putBool(bl7);
            boolean bl8 = intLightMembersIlluminationSet.isFrontDoorsWarningLighting();
            iSerializer.putBool(bl8);
            boolean bl9 = intLightMembersIlluminationSet.isRearDoorsWarningLighting();
            iSerializer.putBool(bl9);
            boolean bl10 = intLightMembersIlluminationSet.isFrontDoorsEntranceLighting();
            iSerializer.putBool(bl10);
            boolean bl11 = intLightMembersIlluminationSet.isRearDoorsEntranceLighting();
            iSerializer.putBool(bl11);
            boolean bl12 = intLightMembersIlluminationSet.isFrontDoorsStripLighting();
            iSerializer.putBool(bl12);
            boolean bl13 = intLightMembersIlluminationSet.isRearDoorsStripLighting();
            iSerializer.putBool(bl13);
            boolean bl14 = intLightMembersIlluminationSet.isCockpitStripLighting();
            iSerializer.putBool(bl14);
            boolean bl15 = intLightMembersIlluminationSet.isCupholderStripLighting();
            iSerializer.putBool(bl15);
            boolean bl16 = intLightMembersIlluminationSet.isPremiumSoundLighting();
            iSerializer.putBool(bl16);
            boolean bl17 = intLightMembersIlluminationSet.isSunRoofStripLighting();
            iSerializer.putBool(bl17);
            boolean bl18 = intLightMembersIlluminationSet.isFrontSliderLighting();
            iSerializer.putBool(bl18);
            boolean bl19 = intLightMembersIlluminationSet.isNavigationDeviceStripLighting();
            iSerializer.putBool(bl19);
            boolean bl20 = intLightMembersIlluminationSet.isFrontClimateControlStripLighting();
            iSerializer.putBool(bl20);
            boolean bl21 = intLightMembersIlluminationSet.isGearShiftLighting();
            iSerializer.putBool(bl21);
            boolean bl22 = intLightMembersIlluminationSet.isCenterControlLighting();
            iSerializer.putBool(bl22);
            boolean bl23 = intLightMembersIlluminationSet.isFrontDoorPocketLighting();
            iSerializer.putBool(bl23);
            boolean bl24 = intLightMembersIlluminationSet.isRearDoorPocketLighting();
            iSerializer.putBool(bl24);
        }
    }

    public static void putOptionalIntLightMembersIlluminationSetVarArray(ISerializer iSerializer, IntLightMembersIlluminationSet[] intLightMembersIlluminationSetArray) {
        boolean bl = intLightMembersIlluminationSetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightMembersIlluminationSetArray.length);
            for (int i2 = 0; i2 < intLightMembersIlluminationSetArray.length; ++i2) {
                IntLightMembersIlluminationSetSerializer.putOptionalIntLightMembersIlluminationSet(iSerializer, intLightMembersIlluminationSetArray[i2]);
            }
        }
    }

    public static IntLightMembersIlluminationSet getOptionalIntLightMembersIlluminationSet(IDeserializer iDeserializer) {
        IntLightMembersIlluminationSet intLightMembersIlluminationSet = null;
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
            intLightMembersIlluminationSet = new IntLightMembersIlluminationSet();
            intLightMembersIlluminationSet.frontRoofLighting = bl24 = iDeserializer.getBool();
            intLightMembersIlluminationSet.rearRoofLighting = bl23 = iDeserializer.getBool();
            intLightMembersIlluminationSet.frontFootwellLighting = bl22 = iDeserializer.getBool();
            intLightMembersIlluminationSet.rearFootwellLighting = bl21 = iDeserializer.getBool();
            intLightMembersIlluminationSet.frontDoorsLighting = bl20 = iDeserializer.getBool();
            intLightMembersIlluminationSet.rearDoorsLighting = bl19 = iDeserializer.getBool();
            intLightMembersIlluminationSet.frontDoorsWarningLighting = bl18 = iDeserializer.getBool();
            intLightMembersIlluminationSet.rearDoorsWarningLighting = bl17 = iDeserializer.getBool();
            intLightMembersIlluminationSet.frontDoorsEntranceLighting = bl16 = iDeserializer.getBool();
            intLightMembersIlluminationSet.rearDoorsEntranceLighting = bl15 = iDeserializer.getBool();
            intLightMembersIlluminationSet.frontDoorsStripLighting = bl14 = iDeserializer.getBool();
            intLightMembersIlluminationSet.rearDoorsStripLighting = bl13 = iDeserializer.getBool();
            intLightMembersIlluminationSet.cockpitStripLighting = bl12 = iDeserializer.getBool();
            intLightMembersIlluminationSet.cupholderStripLighting = bl11 = iDeserializer.getBool();
            intLightMembersIlluminationSet.premiumSoundLighting = bl10 = iDeserializer.getBool();
            intLightMembersIlluminationSet.sunRoofStripLighting = bl9 = iDeserializer.getBool();
            intLightMembersIlluminationSet.frontSliderLighting = bl8 = iDeserializer.getBool();
            intLightMembersIlluminationSet.navigationDeviceStripLighting = bl7 = iDeserializer.getBool();
            intLightMembersIlluminationSet.frontClimateControlStripLighting = bl6 = iDeserializer.getBool();
            intLightMembersIlluminationSet.gearShiftLighting = bl5 = iDeserializer.getBool();
            intLightMembersIlluminationSet.centerControlLighting = bl4 = iDeserializer.getBool();
            intLightMembersIlluminationSet.frontDoorPocketLighting = bl3 = iDeserializer.getBool();
            intLightMembersIlluminationSet.rearDoorPocketLighting = bl2 = iDeserializer.getBool();
        }
        return intLightMembersIlluminationSet;
    }

    public static IntLightMembersIlluminationSet[] getOptionalIntLightMembersIlluminationSetVarArray(IDeserializer iDeserializer) {
        IntLightMembersIlluminationSet[] intLightMembersIlluminationSetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightMembersIlluminationSetArray = new IntLightMembersIlluminationSet[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightMembersIlluminationSetArray[i2] = IntLightMembersIlluminationSetSerializer.getOptionalIntLightMembersIlluminationSet(iDeserializer);
            }
        }
        return intLightMembersIlluminationSetArray;
    }
}

