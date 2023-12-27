/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class DynamicVehicleInfoHighFrequentViewOptionsSerializer {
    public static void putOptionalDynamicVehicleInfoHighFrequentViewOptions(ISerializer iSerializer, DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions) {
        boolean bl = dynamicVehicleInfoHighFrequentViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = dynamicVehicleInfoHighFrequentViewOptions.getLongitudinalAcceleration();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = dynamicVehicleInfoHighFrequentViewOptions.getEngineSpeed();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = dynamicVehicleInfoHighFrequentViewOptions.getPowermeter();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = dynamicVehicleInfoHighFrequentViewOptions.getLateralAcceleration();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = dynamicVehicleInfoHighFrequentViewOptions.getRelChargingAirPressure();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = dynamicVehicleInfoHighFrequentViewOptions.getAbsChargingAirPressure();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = dynamicVehicleInfoHighFrequentViewOptions.getCurrentOutputPower();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = dynamicVehicleInfoHighFrequentViewOptions.getCurrentTorque();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = dynamicVehicleInfoHighFrequentViewOptions.getYawRate();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = dynamicVehicleInfoHighFrequentViewOptions.getBrakePressure();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = dynamicVehicleInfoHighFrequentViewOptions.getWheelAngle();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = dynamicVehicleInfoHighFrequentViewOptions.getAcceleratorPosition();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = dynamicVehicleInfoHighFrequentViewOptions.getVehicleSpeed();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = dynamicVehicleInfoHighFrequentViewOptions.getSystemCycleDistance();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = dynamicVehicleInfoHighFrequentViewOptions.getTorqueDistributionFrontLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = dynamicVehicleInfoHighFrequentViewOptions.getTorqueDistributionFrontRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = dynamicVehicleInfoHighFrequentViewOptions.getTorqueDistributionRearLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = dynamicVehicleInfoHighFrequentViewOptions.getTorqueDistributionRearRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = dynamicVehicleInfoHighFrequentViewOptions.getRealVehicleSpeed();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = dynamicVehicleInfoHighFrequentViewOptions.getShiftLight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            CarViewOption carViewOption21 = dynamicVehicleInfoHighFrequentViewOptions.getAllWheelDriveTorque();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption21);
            CarViewOption carViewOption22 = dynamicVehicleInfoHighFrequentViewOptions.getEspOversteering();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption22);
            CarViewOption carViewOption23 = dynamicVehicleInfoHighFrequentViewOptions.getEspUndersteering();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption23);
            CarViewOption carViewOption24 = dynamicVehicleInfoHighFrequentViewOptions.getEspWheelVelocityFrontLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption24);
            CarViewOption carViewOption25 = dynamicVehicleInfoHighFrequentViewOptions.getEspWheelVelocityFrontRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption25);
            CarViewOption carViewOption26 = dynamicVehicleInfoHighFrequentViewOptions.getEspWheelVelocityRearLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption26);
            CarViewOption carViewOption27 = dynamicVehicleInfoHighFrequentViewOptions.getEspWheelVelocityRearRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption27);
        }
    }

    public static void putOptionalDynamicVehicleInfoHighFrequentViewOptionsVarArray(ISerializer iSerializer, DynamicVehicleInfoHighFrequentViewOptions[] dynamicVehicleInfoHighFrequentViewOptionsArray) {
        boolean bl = dynamicVehicleInfoHighFrequentViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dynamicVehicleInfoHighFrequentViewOptionsArray.length);
            for (int i2 = 0; i2 < dynamicVehicleInfoHighFrequentViewOptionsArray.length; ++i2) {
                DynamicVehicleInfoHighFrequentViewOptionsSerializer.putOptionalDynamicVehicleInfoHighFrequentViewOptions(iSerializer, dynamicVehicleInfoHighFrequentViewOptionsArray[i2]);
            }
        }
    }

    public static DynamicVehicleInfoHighFrequentViewOptions getOptionalDynamicVehicleInfoHighFrequentViewOptions(IDeserializer iDeserializer) {
        DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions = null;
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
            dynamicVehicleInfoHighFrequentViewOptions = new DynamicVehicleInfoHighFrequentViewOptions();
            dynamicVehicleInfoHighFrequentViewOptions.longitudinalAcceleration = carViewOption27 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.engineSpeed = carViewOption26 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.powermeter = carViewOption25 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.lateralAcceleration = carViewOption24 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.relChargingAirPressure = carViewOption23 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.absChargingAirPressure = carViewOption22 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.currentOutputPower = carViewOption21 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.currentTorque = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.yawRate = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.brakePressure = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.wheelAngle = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.acceleratorPosition = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.vehicleSpeed = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.systemCycleDistance = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.torqueDistributionFrontLeft = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.torqueDistributionFrontRight = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.torqueDistributionRearLeft = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.torqueDistributionRearRight = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.realVehicleSpeed = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.shiftLight = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.allWheelDriveTorque = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.espOversteering = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.espUndersteering = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.espWheelVelocityFrontLeft = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.espWheelVelocityFrontRight = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.espWheelVelocityRearLeft = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dynamicVehicleInfoHighFrequentViewOptions.espWheelVelocityRearRight = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return dynamicVehicleInfoHighFrequentViewOptions;
    }

    public static DynamicVehicleInfoHighFrequentViewOptions[] getOptionalDynamicVehicleInfoHighFrequentViewOptionsVarArray(IDeserializer iDeserializer) {
        DynamicVehicleInfoHighFrequentViewOptions[] dynamicVehicleInfoHighFrequentViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequentViewOptionsArray = new DynamicVehicleInfoHighFrequentViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dynamicVehicleInfoHighFrequentViewOptionsArray[i2] = DynamicVehicleInfoHighFrequentViewOptionsSerializer.getOptionalDynamicVehicleInfoHighFrequentViewOptions(iDeserializer);
            }
        }
        return dynamicVehicleInfoHighFrequentViewOptionsArray;
    }
}

