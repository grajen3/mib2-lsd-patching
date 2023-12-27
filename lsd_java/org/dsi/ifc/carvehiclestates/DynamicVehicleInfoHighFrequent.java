/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

import org.dsi.ifc.global.CarBCSpeed;

public class DynamicVehicleInfoHighFrequent {
    public float longitudinalAcceleration;
    public int engineSpeed;
    public int powermeter;
    public float lateralAcceleration;
    public byte relChargingAirPressure;
    public float absChargingAirPressure;
    public float currentOutputPower;
    public float yawRate;
    public float brakePressure;
    public int wheelAngle;
    public byte acceleratorPosition;
    public CarBCSpeed vehicleSpeed;
    public int currentTorque;
    public int systemCycleDistance;
    public int torqueDistributionFrontLeft;
    public int torqueDistributionFrontRight;
    public int torqueDistributionRearLeft;
    public int torqueDistributionRearRight;
    public CarBCSpeed realVehicleSpeed;
    public byte shiftLight;
    public int allWheelDriveTorque;
    public float espOversteering;
    public float espUndersteering;
    public float espWheelVelocityFrontLeft;
    public float espWheelVelocityFrontRight;
    public float espWheelVelocityRearLeft;
    public float espWheelVelocityRearRight;

    public DynamicVehicleInfoHighFrequent() {
        this.longitudinalAcceleration = 0.0f;
        this.engineSpeed = 0;
        this.powermeter = 0;
        this.lateralAcceleration = 0.0f;
        this.relChargingAirPressure = 0;
        this.absChargingAirPressure = 0.0f;
        this.currentOutputPower = 0.0f;
        this.yawRate = 0.0f;
        this.brakePressure = 0.0f;
        this.wheelAngle = 0;
        this.acceleratorPosition = 0;
        this.vehicleSpeed = null;
        this.currentTorque = 0;
        this.systemCycleDistance = 0;
        this.torqueDistributionFrontLeft = 0;
        this.torqueDistributionFrontRight = 0;
        this.torqueDistributionRearLeft = 0;
        this.torqueDistributionRearRight = 0;
        this.realVehicleSpeed = null;
        this.shiftLight = 0;
        this.allWheelDriveTorque = 0;
        this.espOversteering = 0.0f;
        this.espUndersteering = 0.0f;
        this.espWheelVelocityFrontLeft = 0.0f;
        this.espWheelVelocityFrontRight = 0.0f;
        this.espWheelVelocityRearLeft = 0.0f;
        this.espWheelVelocityRearRight = 0.0f;
    }

    public DynamicVehicleInfoHighFrequent(float f2, int n, int n2, float f3, byte by, float f4, float f5, float f6, float f7, int n3, byte by2, CarBCSpeed carBCSpeed, int n4, int n5, int n6, int n7, int n8, int n9, CarBCSpeed carBCSpeed2) {
        this.longitudinalAcceleration = f2;
        this.engineSpeed = n;
        this.powermeter = n2;
        this.lateralAcceleration = f3;
        this.relChargingAirPressure = by;
        this.absChargingAirPressure = f4;
        this.currentOutputPower = f5;
        this.yawRate = f6;
        this.brakePressure = f7;
        this.wheelAngle = n3;
        this.acceleratorPosition = by2;
        this.vehicleSpeed = carBCSpeed;
        this.currentTorque = n4;
        this.systemCycleDistance = n5;
        this.torqueDistributionFrontLeft = n6;
        this.torqueDistributionFrontRight = n7;
        this.torqueDistributionRearLeft = n8;
        this.torqueDistributionRearRight = n9;
        this.realVehicleSpeed = carBCSpeed2;
        this.shiftLight = 0;
        this.allWheelDriveTorque = 0;
        this.espOversteering = 0.0f;
        this.espUndersteering = 0.0f;
        this.espWheelVelocityFrontLeft = 0.0f;
        this.espWheelVelocityFrontRight = 0.0f;
        this.espWheelVelocityRearLeft = 0.0f;
        this.espWheelVelocityRearRight = 0.0f;
    }

    public DynamicVehicleInfoHighFrequent(float f2, int n, int n2, float f3, byte by, float f4, float f5, float f6, float f7, int n3, byte by2, CarBCSpeed carBCSpeed, int n4, int n5, int n6, int n7, int n8, int n9, CarBCSpeed carBCSpeed2, byte by3, int n10) {
        this.longitudinalAcceleration = f2;
        this.engineSpeed = n;
        this.powermeter = n2;
        this.lateralAcceleration = f3;
        this.relChargingAirPressure = by;
        this.absChargingAirPressure = f4;
        this.currentOutputPower = f5;
        this.yawRate = f6;
        this.brakePressure = f7;
        this.wheelAngle = n3;
        this.acceleratorPosition = by2;
        this.vehicleSpeed = carBCSpeed;
        this.currentTorque = n4;
        this.systemCycleDistance = n5;
        this.torqueDistributionFrontLeft = n6;
        this.torqueDistributionFrontRight = n7;
        this.torqueDistributionRearLeft = n8;
        this.torqueDistributionRearRight = n9;
        this.realVehicleSpeed = carBCSpeed2;
        this.shiftLight = by3;
        this.allWheelDriveTorque = n10;
        this.espOversteering = 0.0f;
        this.espUndersteering = 0.0f;
        this.espWheelVelocityFrontLeft = 0.0f;
        this.espWheelVelocityFrontRight = 0.0f;
        this.espWheelVelocityRearLeft = 0.0f;
        this.espWheelVelocityRearRight = 0.0f;
    }

    public DynamicVehicleInfoHighFrequent(float f2, int n, int n2, float f3, byte by, float f4, float f5, float f6, float f7, int n3, byte by2, CarBCSpeed carBCSpeed, int n4, int n5, int n6, int n7, int n8, int n9, CarBCSpeed carBCSpeed2, byte by3, int n10, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.longitudinalAcceleration = f2;
        this.engineSpeed = n;
        this.powermeter = n2;
        this.lateralAcceleration = f3;
        this.relChargingAirPressure = by;
        this.absChargingAirPressure = f4;
        this.currentOutputPower = f5;
        this.yawRate = f6;
        this.brakePressure = f7;
        this.wheelAngle = n3;
        this.acceleratorPosition = by2;
        this.vehicleSpeed = carBCSpeed;
        this.currentTorque = n4;
        this.systemCycleDistance = n5;
        this.torqueDistributionFrontLeft = n6;
        this.torqueDistributionFrontRight = n7;
        this.torqueDistributionRearLeft = n8;
        this.torqueDistributionRearRight = n9;
        this.realVehicleSpeed = carBCSpeed2;
        this.shiftLight = by3;
        this.allWheelDriveTorque = n10;
        this.espOversteering = f8;
        this.espUndersteering = f9;
        this.espWheelVelocityFrontLeft = f10;
        this.espWheelVelocityFrontRight = f11;
        this.espWheelVelocityRearLeft = f12;
        this.espWheelVelocityRearRight = f13;
    }

    public float getLongitudinalAcceleration() {
        return this.longitudinalAcceleration;
    }

    public int getEngineSpeed() {
        return this.engineSpeed;
    }

    public int getPowermeter() {
        return this.powermeter;
    }

    public float getLateralAcceleration() {
        return this.lateralAcceleration;
    }

    public byte getRelChargingAirPressure() {
        return this.relChargingAirPressure;
    }

    public float getAbsChargingAirPressure() {
        return this.absChargingAirPressure;
    }

    public float getCurrentOutputPower() {
        return this.currentOutputPower;
    }

    public float getYawRate() {
        return this.yawRate;
    }

    public float getBrakePressure() {
        return this.brakePressure;
    }

    public int getWheelAngle() {
        return this.wheelAngle;
    }

    public byte getAcceleratorPosition() {
        return this.acceleratorPosition;
    }

    public CarBCSpeed getVehicleSpeed() {
        return this.vehicleSpeed;
    }

    public int getCurrentTorque() {
        return this.currentTorque;
    }

    public int getSystemCycleDistance() {
        return this.systemCycleDistance;
    }

    public int getTorqueDistributionFrontLeft() {
        return this.torqueDistributionFrontLeft;
    }

    public int getTorqueDistributionFrontRight() {
        return this.torqueDistributionFrontRight;
    }

    public int getTorqueDistributionRearLeft() {
        return this.torqueDistributionRearLeft;
    }

    public int getTorqueDistributionRearRight() {
        return this.torqueDistributionRearRight;
    }

    public CarBCSpeed getRealVehicleSpeed() {
        return this.realVehicleSpeed;
    }

    public byte getShiftLight() {
        return this.shiftLight;
    }

    public int getAllWheelDriveTorque() {
        return this.allWheelDriveTorque;
    }

    public float getEspOversteering() {
        return this.espOversteering;
    }

    public float getEspUndersteering() {
        return this.espUndersteering;
    }

    public float getEspWheelVelocityFrontLeft() {
        return this.espWheelVelocityFrontLeft;
    }

    public float getEspWheelVelocityFrontRight() {
        return this.espWheelVelocityFrontRight;
    }

    public float getEspWheelVelocityRearLeft() {
        return this.espWheelVelocityRearLeft;
    }

    public float getEspWheelVelocityRearRight() {
        return this.espWheelVelocityRearRight;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3650);
        stringBuffer.append("DynamicVehicleInfoHighFrequent");
        stringBuffer.append('(');
        stringBuffer.append("longitudinalAcceleration");
        stringBuffer.append('=');
        stringBuffer.append(this.longitudinalAcceleration);
        stringBuffer.append(',');
        stringBuffer.append("engineSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.engineSpeed);
        stringBuffer.append(',');
        stringBuffer.append("powermeter");
        stringBuffer.append('=');
        stringBuffer.append(this.powermeter);
        stringBuffer.append(',');
        stringBuffer.append("lateralAcceleration");
        stringBuffer.append('=');
        stringBuffer.append(this.lateralAcceleration);
        stringBuffer.append(',');
        stringBuffer.append("relChargingAirPressure");
        stringBuffer.append('=');
        stringBuffer.append(this.relChargingAirPressure);
        stringBuffer.append(',');
        stringBuffer.append("absChargingAirPressure");
        stringBuffer.append('=');
        stringBuffer.append(this.absChargingAirPressure);
        stringBuffer.append(',');
        stringBuffer.append("currentOutputPower");
        stringBuffer.append('=');
        stringBuffer.append(this.currentOutputPower);
        stringBuffer.append(',');
        stringBuffer.append("yawRate");
        stringBuffer.append('=');
        stringBuffer.append(this.yawRate);
        stringBuffer.append(',');
        stringBuffer.append("brakePressure");
        stringBuffer.append('=');
        stringBuffer.append(this.brakePressure);
        stringBuffer.append(',');
        stringBuffer.append("wheelAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.wheelAngle);
        stringBuffer.append(',');
        stringBuffer.append("acceleratorPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.acceleratorPosition);
        stringBuffer.append(',');
        stringBuffer.append("vehicleSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.vehicleSpeed);
        stringBuffer.append(',');
        stringBuffer.append("currentTorque");
        stringBuffer.append('=');
        stringBuffer.append(this.currentTorque);
        stringBuffer.append(',');
        stringBuffer.append("systemCycleDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.systemCycleDistance);
        stringBuffer.append(',');
        stringBuffer.append("torqueDistributionFrontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.torqueDistributionFrontLeft);
        stringBuffer.append(',');
        stringBuffer.append("torqueDistributionFrontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.torqueDistributionFrontRight);
        stringBuffer.append(',');
        stringBuffer.append("torqueDistributionRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.torqueDistributionRearLeft);
        stringBuffer.append(',');
        stringBuffer.append("torqueDistributionRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.torqueDistributionRearRight);
        stringBuffer.append(',');
        stringBuffer.append("realVehicleSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.realVehicleSpeed);
        stringBuffer.append(',');
        stringBuffer.append("shiftLight");
        stringBuffer.append('=');
        stringBuffer.append(this.shiftLight);
        stringBuffer.append(',');
        stringBuffer.append("allWheelDriveTorque");
        stringBuffer.append('=');
        stringBuffer.append(this.allWheelDriveTorque);
        stringBuffer.append(',');
        stringBuffer.append("espOversteering");
        stringBuffer.append('=');
        stringBuffer.append(this.espOversteering);
        stringBuffer.append(',');
        stringBuffer.append("espUndersteering");
        stringBuffer.append('=');
        stringBuffer.append(this.espUndersteering);
        stringBuffer.append(',');
        stringBuffer.append("espWheelVelocityFrontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.espWheelVelocityFrontLeft);
        stringBuffer.append(',');
        stringBuffer.append("espWheelVelocityFrontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.espWheelVelocityFrontRight);
        stringBuffer.append(',');
        stringBuffer.append("espWheelVelocityRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.espWheelVelocityRearLeft);
        stringBuffer.append(',');
        stringBuffer.append("espWheelVelocityRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.espWheelVelocityRearRight);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

