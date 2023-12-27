/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;

public class DynamicVehicleInfoMidFrequentSerializer {
    public static void putOptionalDynamicVehicleInfoMidFrequent(ISerializer iSerializer, DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent) {
        boolean bl = dynamicVehicleInfoMidFrequent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = dynamicVehicleInfoMidFrequent.isCoastingIsActive();
            iSerializer.putBool(bl2);
            int n = dynamicVehicleInfoMidFrequent.getGearboxOilTemperature();
            iSerializer.putInt32(n);
            int n2 = dynamicVehicleInfoMidFrequent.getBlinkingState();
            iSerializer.putInt32(n2);
            int n3 = dynamicVehicleInfoMidFrequent.getCurrentGear();
            iSerializer.putInt32(n3);
            int n4 = dynamicVehicleInfoMidFrequent.getRecommendedGear();
            iSerializer.putInt32(n4);
            int n5 = dynamicVehicleInfoMidFrequent.getClutch();
            iSerializer.putInt32(n5);
            boolean bl3 = dynamicVehicleInfoMidFrequent.isAcceleratorKickDown();
            iSerializer.putBool(bl3);
            boolean bl4 = dynamicVehicleInfoMidFrequent.isDriverIsBraking();
            iSerializer.putBool(bl4);
            boolean bl5 = dynamicVehicleInfoMidFrequent.isACCIsActive();
            iSerializer.putBool(bl5);
            int n6 = dynamicVehicleInfoMidFrequent.getAutomaticGearShiftTransMode();
            iSerializer.putInt32(n6);
            int n7 = dynamicVehicleInfoMidFrequent.getRecuperationLevel();
            iSerializer.putInt32(n7);
            int n8 = dynamicVehicleInfoMidFrequent.getHdcColor();
            iSerializer.putInt32(n8);
            float f2 = dynamicVehicleInfoMidFrequent.getHdcSpeed();
            iSerializer.putFloat(f2);
            int n9 = dynamicVehicleInfoMidFrequent.getEdsDisplay();
            iSerializer.putInt32(n9);
            boolean bl6 = dynamicVehicleInfoMidFrequent.isValetParkingState();
            iSerializer.putBool(bl6);
            boolean bl7 = dynamicVehicleInfoMidFrequent.isHighwayBlinkingState();
            iSerializer.putBool(bl7);
            float f3 = dynamicVehicleInfoMidFrequent.getBatteryVoltage();
            iSerializer.putFloat(f3);
            boolean bl8 = dynamicVehicleInfoMidFrequent.isLowBeamHeadlightIsActive();
            iSerializer.putBool(bl8);
            boolean bl9 = dynamicVehicleInfoMidFrequent.isHighBeamHeadlightIsActive();
            iSerializer.putBool(bl9);
            boolean bl10 = dynamicVehicleInfoMidFrequent.isFogLightFrontIsActive();
            iSerializer.putBool(bl10);
            boolean bl11 = dynamicVehicleInfoMidFrequent.isFogLightRearIsActive();
            iSerializer.putBool(bl11);
            boolean bl12 = dynamicVehicleInfoMidFrequent.isDaytimeRunningLightIsActive();
            iSerializer.putBool(bl12);
            boolean bl13 = dynamicVehicleInfoMidFrequent.isEspLight();
            iSerializer.putBool(bl13);
            boolean bl14 = dynamicVehicleInfoMidFrequent.isEspPassiveSensing();
            iSerializer.putBool(bl14);
            float f4 = dynamicVehicleInfoMidFrequent.getTirePressureFrontLeft();
            iSerializer.putFloat(f4);
            float f5 = dynamicVehicleInfoMidFrequent.getTirePressureFrontRight();
            iSerializer.putFloat(f5);
            float f6 = dynamicVehicleInfoMidFrequent.getTirePressureRearLeft();
            iSerializer.putFloat(f6);
            float f7 = dynamicVehicleInfoMidFrequent.getTirePressureRearRight();
            iSerializer.putFloat(f7);
        }
    }

    public static void putOptionalDynamicVehicleInfoMidFrequentVarArray(ISerializer iSerializer, DynamicVehicleInfoMidFrequent[] dynamicVehicleInfoMidFrequentArray) {
        boolean bl = dynamicVehicleInfoMidFrequentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dynamicVehicleInfoMidFrequentArray.length);
            for (int i2 = 0; i2 < dynamicVehicleInfoMidFrequentArray.length; ++i2) {
                DynamicVehicleInfoMidFrequentSerializer.putOptionalDynamicVehicleInfoMidFrequent(iSerializer, dynamicVehicleInfoMidFrequentArray[i2]);
            }
        }
    }

    public static DynamicVehicleInfoMidFrequent getOptionalDynamicVehicleInfoMidFrequent(IDeserializer iDeserializer) {
        DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            float f3;
            float f4;
            float f5;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            float f6;
            boolean bl9;
            boolean bl10;
            int n;
            float f7;
            int n2;
            int n3;
            int n4;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            boolean bl14;
            dynamicVehicleInfoMidFrequent = new DynamicVehicleInfoMidFrequent();
            dynamicVehicleInfoMidFrequent.coastingIsActive = bl14 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.gearboxOilTemperature = n9 = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequent.blinkingState = n8 = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequent.currentGear = n7 = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequent.recommendedGear = n6 = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequent.clutch = n5 = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequent.acceleratorKickDown = bl13 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.driverIsBraking = bl12 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.aCCIsActive = bl11 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode = n4 = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequent.recuperationLevel = n3 = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequent.hdcColor = n2 = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequent.hdcSpeed = f7 = iDeserializer.getFloat();
            dynamicVehicleInfoMidFrequent.edsDisplay = n = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequent.valetParkingState = bl10 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.highwayBlinkingState = bl9 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.batteryVoltage = f6 = iDeserializer.getFloat();
            dynamicVehicleInfoMidFrequent.lowBeamHeadlightIsActive = bl8 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.highBeamHeadlightIsActive = bl7 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.fogLightFrontIsActive = bl6 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.fogLightRearIsActive = bl5 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.daytimeRunningLightIsActive = bl4 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.espLight = bl3 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.espPassiveSensing = bl2 = iDeserializer.getBool();
            dynamicVehicleInfoMidFrequent.tirePressureFrontLeft = f5 = iDeserializer.getFloat();
            dynamicVehicleInfoMidFrequent.tirePressureFrontRight = f4 = iDeserializer.getFloat();
            dynamicVehicleInfoMidFrequent.tirePressureRearLeft = f3 = iDeserializer.getFloat();
            dynamicVehicleInfoMidFrequent.tirePressureRearRight = f2 = iDeserializer.getFloat();
        }
        return dynamicVehicleInfoMidFrequent;
    }

    public static DynamicVehicleInfoMidFrequent[] getOptionalDynamicVehicleInfoMidFrequentVarArray(IDeserializer iDeserializer) {
        DynamicVehicleInfoMidFrequent[] dynamicVehicleInfoMidFrequentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequentArray = new DynamicVehicleInfoMidFrequent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dynamicVehicleInfoMidFrequentArray[i2] = DynamicVehicleInfoMidFrequentSerializer.getOptionalDynamicVehicleInfoMidFrequent(iDeserializer);
            }
        }
        return dynamicVehicleInfoMidFrequentArray;
    }
}

