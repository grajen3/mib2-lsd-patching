/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class DynamicVehicleInfoMidFrequentViewOptionsSerializer {
    public static void putOptionalDynamicVehicleInfoMidFrequentViewOptions(ISerializer iSerializer, DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions) {
        boolean bl = dynamicVehicleInfoMidFrequentViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = dynamicVehicleInfoMidFrequentViewOptions.getCurrentGear();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = dynamicVehicleInfoMidFrequentViewOptions.getRecommendedGear();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = dynamicVehicleInfoMidFrequentViewOptions.getClutch();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = dynamicVehicleInfoMidFrequentViewOptions.getAcceleratorKickDown();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = dynamicVehicleInfoMidFrequentViewOptions.getDriverIsBraking();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = dynamicVehicleInfoMidFrequentViewOptions.getCoastingIsActive();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = dynamicVehicleInfoMidFrequentViewOptions.getGearboxOilTemperature();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = dynamicVehicleInfoMidFrequentViewOptions.getBlinkingState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = dynamicVehicleInfoMidFrequentViewOptions.getACCIsActive();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = dynamicVehicleInfoMidFrequentViewOptions.getAutomaticGearShiftTransMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = dynamicVehicleInfoMidFrequentViewOptions.getRecuperationLevel();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = dynamicVehicleInfoMidFrequentViewOptions.getHdcColor();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = dynamicVehicleInfoMidFrequentViewOptions.getHdcSpeed();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = dynamicVehicleInfoMidFrequentViewOptions.getEdsDisplay();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = dynamicVehicleInfoMidFrequentViewOptions.getValetParkingState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = dynamicVehicleInfoMidFrequentViewOptions.getBatteryVoltage();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = dynamicVehicleInfoMidFrequentViewOptions.getLowBeamHeadlightIsActive();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = dynamicVehicleInfoMidFrequentViewOptions.getHighBeamHeadlightIsActive();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = dynamicVehicleInfoMidFrequentViewOptions.getFogLightFrontIsActive();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = dynamicVehicleInfoMidFrequentViewOptions.getFogLightRearIsActive();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            CarViewOption carViewOption21 = dynamicVehicleInfoMidFrequentViewOptions.getDaytimeRunningLightIsActive();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption21);
            CarViewOption carViewOption22 = dynamicVehicleInfoMidFrequentViewOptions.getEspLight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption22);
            CarViewOption carViewOption23 = dynamicVehicleInfoMidFrequentViewOptions.getEspPassiveSensing();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption23);
            CarViewOption carViewOption24 = dynamicVehicleInfoMidFrequentViewOptions.getTirePressureFrontLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption24);
            CarViewOption carViewOption25 = dynamicVehicleInfoMidFrequentViewOptions.getTirePressureFrontRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption25);
            CarViewOption carViewOption26 = dynamicVehicleInfoMidFrequentViewOptions.getTirePressureRearLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption26);
            CarViewOption carViewOption27 = dynamicVehicleInfoMidFrequentViewOptions.getTirePressureRearRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption27);
        }
    }

    public static void putOptionalDynamicVehicleInfoMidFrequentViewOptionsVarArray(ISerializer iSerializer, DynamicVehicleInfoMidFrequentViewOptions[] dynamicVehicleInfoMidFrequentViewOptionsArray) {
        boolean bl = dynamicVehicleInfoMidFrequentViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dynamicVehicleInfoMidFrequentViewOptionsArray.length);
            for (int i2 = 0; i2 < dynamicVehicleInfoMidFrequentViewOptionsArray.length; ++i2) {
                DynamicVehicleInfoMidFrequentViewOptionsSerializer.putOptionalDynamicVehicleInfoMidFrequentViewOptions(iSerializer, dynamicVehicleInfoMidFrequentViewOptionsArray[i2]);
            }
        }
    }

    public static DynamicVehicleInfoMidFrequentViewOptions getOptionalDynamicVehicleInfoMidFrequentViewOptions(IDeserializer iDeserializer) {
        DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            CarViewOption carViewOption17;
            CarViewOption carViewOption18;
            CarViewOption carViewOption19;
            CarViewOption carViewOption20;
            CarViewOption carViewOption21;
            CarViewOption carViewOption22;
            CarViewOption carViewOption23;
            CarViewOption carViewOption24;
            CarViewOption carViewOption25;
            CarViewOption carViewOption26;
            CarViewOption carViewOption27;
            dynamicVehicleInfoMidFrequentViewOptions = new DynamicVehicleInfoMidFrequentViewOptions();
            dynamicVehicleInfoMidFrequentViewOptions.currentGear = carViewOption27 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.recommendedGear = carViewOption26 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.clutch = carViewOption25 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.acceleratorKickDown = carViewOption24 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.driverIsBraking = carViewOption23 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.coastingIsActive = carViewOption22 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.gearboxOilTemperature = carViewOption21 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.blinkingState = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.aCCIsActive = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.automaticGearShiftTransMode = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.recuperationLevel = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.hdcColor = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.hdcSpeed = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.edsDisplay = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.valetParkingState = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.batteryVoltage = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.lowBeamHeadlightIsActive = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.highBeamHeadlightIsActive = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.fogLightFrontIsActive = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.fogLightRearIsActive = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.daytimeRunningLightIsActive = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.espLight = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.espPassiveSensing = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.tirePressureFrontLeft = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.tirePressureFrontRight = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.tirePressureRearLeft = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoMidFrequentViewOptions.tirePressureRearRight = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return dynamicVehicleInfoMidFrequentViewOptions;
    }

    public static DynamicVehicleInfoMidFrequentViewOptions[] getOptionalDynamicVehicleInfoMidFrequentViewOptionsVarArray(IDeserializer iDeserializer) {
        DynamicVehicleInfoMidFrequentViewOptions[] dynamicVehicleInfoMidFrequentViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dynamicVehicleInfoMidFrequentViewOptionsArray = new DynamicVehicleInfoMidFrequentViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dynamicVehicleInfoMidFrequentViewOptionsArray[i2] = DynamicVehicleInfoMidFrequentViewOptionsSerializer.getOptionalDynamicVehicleInfoMidFrequentViewOptions(iDeserializer);
            }
        }
        return dynamicVehicleInfoMidFrequentViewOptionsArray;
    }
}

