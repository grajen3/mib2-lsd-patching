/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarBCSpeedSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.global.CarBCSpeed;

public class DynamicVehicleInfoHighFrequentSerializer {
    public static void putOptionalDynamicVehicleInfoHighFrequent(ISerializer iSerializer, DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent) {
        boolean bl = dynamicVehicleInfoHighFrequent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            float f2 = dynamicVehicleInfoHighFrequent.getLongitudinalAcceleration();
            iSerializer.putFloat(f2);
            int n = dynamicVehicleInfoHighFrequent.getEngineSpeed();
            iSerializer.putInt32(n);
            int n2 = dynamicVehicleInfoHighFrequent.getPowermeter();
            iSerializer.putInt32(n2);
            float f3 = dynamicVehicleInfoHighFrequent.getLateralAcceleration();
            iSerializer.putFloat(f3);
            byte by = dynamicVehicleInfoHighFrequent.getRelChargingAirPressure();
            iSerializer.putInt8(by);
            float f4 = dynamicVehicleInfoHighFrequent.getAbsChargingAirPressure();
            iSerializer.putFloat(f4);
            float f5 = dynamicVehicleInfoHighFrequent.getCurrentOutputPower();
            iSerializer.putFloat(f5);
            float f6 = dynamicVehicleInfoHighFrequent.getYawRate();
            iSerializer.putFloat(f6);
            float f7 = dynamicVehicleInfoHighFrequent.getBrakePressure();
            iSerializer.putFloat(f7);
            int n3 = dynamicVehicleInfoHighFrequent.getWheelAngle();
            iSerializer.putInt32(n3);
            byte by2 = dynamicVehicleInfoHighFrequent.getAcceleratorPosition();
            iSerializer.putInt8(by2);
            CarBCSpeed carBCSpeed = dynamicVehicleInfoHighFrequent.getVehicleSpeed();
            CarBCSpeedSerializer.putOptionalCarBCSpeed(iSerializer, carBCSpeed);
            int n4 = dynamicVehicleInfoHighFrequent.getCurrentTorque();
            iSerializer.putInt32(n4);
            int n5 = dynamicVehicleInfoHighFrequent.getSystemCycleDistance();
            iSerializer.putInt32(n5);
            int n6 = dynamicVehicleInfoHighFrequent.getTorqueDistributionFrontLeft();
            iSerializer.putInt32(n6);
            int n7 = dynamicVehicleInfoHighFrequent.getTorqueDistributionFrontRight();
            iSerializer.putInt32(n7);
            int n8 = dynamicVehicleInfoHighFrequent.getTorqueDistributionRearLeft();
            iSerializer.putInt32(n8);
            int n9 = dynamicVehicleInfoHighFrequent.getTorqueDistributionRearRight();
            iSerializer.putInt32(n9);
            CarBCSpeed carBCSpeed2 = dynamicVehicleInfoHighFrequent.getRealVehicleSpeed();
            CarBCSpeedSerializer.putOptionalCarBCSpeed(iSerializer, carBCSpeed2);
            byte by3 = dynamicVehicleInfoHighFrequent.getShiftLight();
            iSerializer.putInt8(by3);
            int n10 = dynamicVehicleInfoHighFrequent.getAllWheelDriveTorque();
            iSerializer.putInt32(n10);
            float f8 = dynamicVehicleInfoHighFrequent.getEspOversteering();
            iSerializer.putFloat(f8);
            float f9 = dynamicVehicleInfoHighFrequent.getEspUndersteering();
            iSerializer.putFloat(f9);
            float f10 = dynamicVehicleInfoHighFrequent.getEspWheelVelocityFrontLeft();
            iSerializer.putFloat(f10);
            float f11 = dynamicVehicleInfoHighFrequent.getEspWheelVelocityFrontRight();
            iSerializer.putFloat(f11);
            float f12 = dynamicVehicleInfoHighFrequent.getEspWheelVelocityRearLeft();
            iSerializer.putFloat(f12);
            float f13 = dynamicVehicleInfoHighFrequent.getEspWheelVelocityRearRight();
            iSerializer.putFloat(f13);
        }
    }

    public static void putOptionalDynamicVehicleInfoHighFrequentVarArray(ISerializer iSerializer, DynamicVehicleInfoHighFrequent[] dynamicVehicleInfoHighFrequentArray) {
        boolean bl = dynamicVehicleInfoHighFrequentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dynamicVehicleInfoHighFrequentArray.length);
            for (int i2 = 0; i2 < dynamicVehicleInfoHighFrequentArray.length; ++i2) {
                DynamicVehicleInfoHighFrequentSerializer.putOptionalDynamicVehicleInfoHighFrequent(iSerializer, dynamicVehicleInfoHighFrequentArray[i2]);
            }
        }
    }

    public static DynamicVehicleInfoHighFrequent getOptionalDynamicVehicleInfoHighFrequent(IDeserializer iDeserializer) {
        DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            int n;
            byte by;
            CarBCSpeed carBCSpeed;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            CarBCSpeed carBCSpeed2;
            byte by2;
            int n8;
            float f8;
            float f9;
            float f10;
            float f11;
            byte by3;
            float f12;
            int n9;
            int n10;
            float f13;
            dynamicVehicleInfoHighFrequent = new DynamicVehicleInfoHighFrequent();
            dynamicVehicleInfoHighFrequent.longitudinalAcceleration = f13 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.engineSpeed = n10 = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.powermeter = n9 = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.lateralAcceleration = f12 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.relChargingAirPressure = by3 = iDeserializer.getInt8();
            dynamicVehicleInfoHighFrequent.absChargingAirPressure = f11 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.currentOutputPower = f10 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.yawRate = f9 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.brakePressure = f8 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.wheelAngle = n8 = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.acceleratorPosition = by2 = iDeserializer.getInt8();
            dynamicVehicleInfoHighFrequent.vehicleSpeed = carBCSpeed2 = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
            dynamicVehicleInfoHighFrequent.currentTorque = n7 = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.systemCycleDistance = n6 = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.torqueDistributionFrontLeft = n5 = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.torqueDistributionFrontRight = n4 = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.torqueDistributionRearLeft = n3 = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.torqueDistributionRearRight = n2 = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.realVehicleSpeed = carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
            dynamicVehicleInfoHighFrequent.shiftLight = by = iDeserializer.getInt8();
            dynamicVehicleInfoHighFrequent.allWheelDriveTorque = n = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequent.espOversteering = f7 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.espUndersteering = f6 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.espWheelVelocityFrontLeft = f5 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.espWheelVelocityFrontRight = f4 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.espWheelVelocityRearLeft = f3 = iDeserializer.getFloat();
            dynamicVehicleInfoHighFrequent.espWheelVelocityRearRight = f2 = iDeserializer.getFloat();
        }
        return dynamicVehicleInfoHighFrequent;
    }

    public static DynamicVehicleInfoHighFrequent[] getOptionalDynamicVehicleInfoHighFrequentVarArray(IDeserializer iDeserializer) {
        DynamicVehicleInfoHighFrequent[] dynamicVehicleInfoHighFrequentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dynamicVehicleInfoHighFrequentArray = new DynamicVehicleInfoHighFrequent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dynamicVehicleInfoHighFrequentArray[i2] = DynamicVehicleInfoHighFrequentSerializer.getOptionalDynamicVehicleInfoHighFrequent(iDeserializer);
            }
        }
        return dynamicVehicleInfoHighFrequentArray;
    }
}

