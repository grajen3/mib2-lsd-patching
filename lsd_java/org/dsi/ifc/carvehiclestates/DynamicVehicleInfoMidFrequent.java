/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

public class DynamicVehicleInfoMidFrequent {
    public boolean coastingIsActive;
    public int gearboxOilTemperature;
    public int blinkingState;
    public int currentGear;
    public int recommendedGear;
    public int clutch;
    public boolean acceleratorKickDown;
    public boolean driverIsBraking;
    public boolean aCCIsActive;
    public int automaticGearShiftTransMode;
    public int recuperationLevel;
    public int hdcColor;
    public float hdcSpeed;
    public int edsDisplay;
    public boolean valetParkingState;
    public boolean highwayBlinkingState;
    public float batteryVoltage;
    public boolean lowBeamHeadlightIsActive;
    public boolean highBeamHeadlightIsActive;
    public boolean fogLightFrontIsActive;
    public boolean fogLightRearIsActive;
    public boolean daytimeRunningLightIsActive;
    public boolean espLight;
    public boolean espPassiveSensing;
    public float tirePressureFrontLeft;
    public float tirePressureFrontRight;
    public float tirePressureRearLeft;
    public float tirePressureRearRight;

    public DynamicVehicleInfoMidFrequent() {
        this.coastingIsActive = false;
        this.gearboxOilTemperature = 0;
        this.blinkingState = 0;
        this.currentGear = 0;
        this.recommendedGear = 0;
        this.clutch = 0;
        this.acceleratorKickDown = false;
        this.driverIsBraking = false;
        this.aCCIsActive = false;
        this.automaticGearShiftTransMode = 0;
        this.recuperationLevel = 0;
        this.hdcColor = 0;
        this.hdcSpeed = 0.0f;
        this.edsDisplay = 0;
        this.valetParkingState = false;
        this.highwayBlinkingState = false;
        this.batteryVoltage = 0.0f;
        this.lowBeamHeadlightIsActive = false;
        this.highBeamHeadlightIsActive = false;
        this.fogLightFrontIsActive = false;
        this.fogLightRearIsActive = false;
        this.daytimeRunningLightIsActive = false;
        this.espLight = false;
        this.espPassiveSensing = false;
        this.tirePressureFrontLeft = 0.0f;
        this.tirePressureFrontRight = 0.0f;
        this.tirePressureRearLeft = 0.0f;
        this.tirePressureRearRight = 0.0f;
    }

    public DynamicVehicleInfoMidFrequent(boolean bl, int n, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3, boolean bl4, int n6, int n7) {
        this.coastingIsActive = bl;
        this.gearboxOilTemperature = n;
        this.blinkingState = n2;
        this.currentGear = n3;
        this.recommendedGear = n4;
        this.clutch = n5;
        this.acceleratorKickDown = bl2;
        this.driverIsBraking = bl3;
        this.aCCIsActive = bl4;
        this.automaticGearShiftTransMode = n6;
        this.recuperationLevel = n7;
        this.hdcColor = 0;
        this.hdcSpeed = 0.0f;
        this.edsDisplay = 0;
        this.valetParkingState = false;
        this.highwayBlinkingState = false;
        this.batteryVoltage = 0.0f;
        this.lowBeamHeadlightIsActive = false;
        this.highBeamHeadlightIsActive = false;
        this.fogLightFrontIsActive = false;
        this.fogLightRearIsActive = false;
        this.daytimeRunningLightIsActive = false;
        this.espLight = false;
        this.espPassiveSensing = false;
        this.tirePressureFrontLeft = 0.0f;
        this.tirePressureFrontRight = 0.0f;
        this.tirePressureRearLeft = 0.0f;
        this.tirePressureRearRight = 0.0f;
    }

    public DynamicVehicleInfoMidFrequent(boolean bl, int n, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3, boolean bl4, int n6, int n7, int n8, float f2, int n9, boolean bl5, boolean bl6) {
        this.coastingIsActive = bl;
        this.gearboxOilTemperature = n;
        this.blinkingState = n2;
        this.currentGear = n3;
        this.recommendedGear = n4;
        this.clutch = n5;
        this.acceleratorKickDown = bl2;
        this.driverIsBraking = bl3;
        this.aCCIsActive = bl4;
        this.automaticGearShiftTransMode = n6;
        this.recuperationLevel = n7;
        this.hdcColor = n8;
        this.hdcSpeed = f2;
        this.edsDisplay = n9;
        this.valetParkingState = bl5;
        this.highwayBlinkingState = bl6;
        this.batteryVoltage = 0.0f;
        this.lowBeamHeadlightIsActive = false;
        this.highBeamHeadlightIsActive = false;
        this.daytimeRunningLightIsActive = false;
        this.fogLightFrontIsActive = false;
        this.fogLightRearIsActive = false;
        this.espLight = false;
        this.espPassiveSensing = false;
        this.tirePressureFrontLeft = 0.0f;
        this.tirePressureFrontRight = 0.0f;
        this.tirePressureRearLeft = 0.0f;
        this.tirePressureRearRight = 0.0f;
    }

    public DynamicVehicleInfoMidFrequent(boolean bl, int n, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3, boolean bl4, int n6, int n7, int n8, float f2, int n9, boolean bl5, boolean bl6, float f3, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11) {
        this.coastingIsActive = bl;
        this.gearboxOilTemperature = n;
        this.blinkingState = n2;
        this.currentGear = n3;
        this.recommendedGear = n4;
        this.clutch = n5;
        this.acceleratorKickDown = bl2;
        this.driverIsBraking = bl3;
        this.aCCIsActive = bl4;
        this.automaticGearShiftTransMode = n6;
        this.recuperationLevel = n7;
        this.hdcColor = n8;
        this.hdcSpeed = f2;
        this.edsDisplay = n9;
        this.valetParkingState = bl5;
        this.highwayBlinkingState = bl6;
        this.batteryVoltage = f3;
        this.lowBeamHeadlightIsActive = bl7;
        this.highBeamHeadlightIsActive = bl8;
        this.fogLightFrontIsActive = bl9;
        this.fogLightRearIsActive = bl10;
        this.daytimeRunningLightIsActive = bl11;
        this.espLight = false;
        this.espPassiveSensing = false;
        this.tirePressureFrontLeft = 0.0f;
        this.tirePressureFrontRight = 0.0f;
        this.tirePressureRearLeft = 0.0f;
        this.tirePressureRearRight = 0.0f;
    }

    public DynamicVehicleInfoMidFrequent(boolean bl, int n, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3, boolean bl4, int n6, int n7, int n8, float f2, int n9, boolean bl5, boolean bl6, float f3, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12) {
        this.coastingIsActive = bl;
        this.gearboxOilTemperature = n;
        this.blinkingState = n2;
        this.currentGear = n3;
        this.recommendedGear = n4;
        this.clutch = n5;
        this.acceleratorKickDown = bl2;
        this.driverIsBraking = bl3;
        this.aCCIsActive = bl4;
        this.automaticGearShiftTransMode = n6;
        this.recuperationLevel = n7;
        this.hdcColor = n8;
        this.hdcSpeed = f2;
        this.edsDisplay = n9;
        this.valetParkingState = bl5;
        this.highwayBlinkingState = bl6;
        this.batteryVoltage = f3;
        this.lowBeamHeadlightIsActive = bl7;
        this.highBeamHeadlightIsActive = bl8;
        this.fogLightFrontIsActive = bl9;
        this.fogLightRearIsActive = bl10;
        this.daytimeRunningLightIsActive = bl11;
        this.espLight = bl12;
        this.espPassiveSensing = false;
        this.tirePressureFrontLeft = 0.0f;
        this.tirePressureFrontRight = 0.0f;
        this.tirePressureRearLeft = 0.0f;
        this.tirePressureRearRight = 0.0f;
    }

    public DynamicVehicleInfoMidFrequent(boolean bl, int n, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3, boolean bl4, int n6, int n7, int n8, float f2, int n9, boolean bl5, boolean bl6, float f3, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, float f4, float f5, float f6, float f7) {
        this.coastingIsActive = bl;
        this.gearboxOilTemperature = n;
        this.blinkingState = n2;
        this.currentGear = n3;
        this.recommendedGear = n4;
        this.clutch = n5;
        this.acceleratorKickDown = bl2;
        this.driverIsBraking = bl3;
        this.aCCIsActive = bl4;
        this.automaticGearShiftTransMode = n6;
        this.recuperationLevel = n7;
        this.hdcColor = n8;
        this.hdcSpeed = f2;
        this.edsDisplay = n9;
        this.valetParkingState = bl5;
        this.highwayBlinkingState = bl6;
        this.batteryVoltage = f3;
        this.lowBeamHeadlightIsActive = bl7;
        this.highBeamHeadlightIsActive = bl8;
        this.fogLightFrontIsActive = bl9;
        this.fogLightRearIsActive = bl10;
        this.daytimeRunningLightIsActive = bl11;
        this.espLight = bl12;
        this.espPassiveSensing = bl13;
        this.tirePressureFrontLeft = f4;
        this.tirePressureFrontRight = f5;
        this.tirePressureRearLeft = f6;
        this.tirePressureRearRight = f7;
    }

    public boolean isCoastingIsActive() {
        return this.coastingIsActive;
    }

    public int getGearboxOilTemperature() {
        return this.gearboxOilTemperature;
    }

    public int getBlinkingState() {
        return this.blinkingState;
    }

    public int getCurrentGear() {
        return this.currentGear;
    }

    public int getRecommendedGear() {
        return this.recommendedGear;
    }

    public int getClutch() {
        return this.clutch;
    }

    public boolean isAcceleratorKickDown() {
        return this.acceleratorKickDown;
    }

    public boolean isDriverIsBraking() {
        return this.driverIsBraking;
    }

    public boolean isACCIsActive() {
        return this.aCCIsActive;
    }

    public int getAutomaticGearShiftTransMode() {
        return this.automaticGearShiftTransMode;
    }

    public int getRecuperationLevel() {
        return this.recuperationLevel;
    }

    public int getHdcColor() {
        return this.hdcColor;
    }

    public float getHdcSpeed() {
        return this.hdcSpeed;
    }

    public int getEdsDisplay() {
        return this.edsDisplay;
    }

    public boolean isValetParkingState() {
        return this.valetParkingState;
    }

    public boolean isHighwayBlinkingState() {
        return this.highwayBlinkingState;
    }

    public float getBatteryVoltage() {
        return this.batteryVoltage;
    }

    public boolean isLowBeamHeadlightIsActive() {
        return this.lowBeamHeadlightIsActive;
    }

    public boolean isHighBeamHeadlightIsActive() {
        return this.highBeamHeadlightIsActive;
    }

    public boolean isFogLightFrontIsActive() {
        return this.fogLightFrontIsActive;
    }

    public boolean isFogLightRearIsActive() {
        return this.fogLightRearIsActive;
    }

    public boolean isDaytimeRunningLightIsActive() {
        return this.daytimeRunningLightIsActive;
    }

    public boolean isEspLight() {
        return this.espLight;
    }

    public boolean isEspPassiveSensing() {
        return this.espPassiveSensing;
    }

    public float getTirePressureFrontLeft() {
        return this.tirePressureFrontLeft;
    }

    public float getTirePressureFrontRight() {
        return this.tirePressureFrontRight;
    }

    public float getTirePressureRearLeft() {
        return this.tirePressureRearLeft;
    }

    public float getTirePressureRearRight() {
        return this.tirePressureRearRight;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1650);
        stringBuffer.append("DynamicVehicleInfoMidFrequent");
        stringBuffer.append('(');
        stringBuffer.append("coastingIsActive");
        stringBuffer.append('=');
        stringBuffer.append(this.coastingIsActive);
        stringBuffer.append(',');
        stringBuffer.append("gearboxOilTemperature");
        stringBuffer.append('=');
        stringBuffer.append(this.gearboxOilTemperature);
        stringBuffer.append(',');
        stringBuffer.append("blinkingState");
        stringBuffer.append('=');
        stringBuffer.append(this.blinkingState);
        stringBuffer.append(',');
        stringBuffer.append("currentGear");
        stringBuffer.append('=');
        stringBuffer.append(this.currentGear);
        stringBuffer.append(',');
        stringBuffer.append("recommendedGear");
        stringBuffer.append('=');
        stringBuffer.append(this.recommendedGear);
        stringBuffer.append(',');
        stringBuffer.append("clutch");
        stringBuffer.append('=');
        stringBuffer.append(this.clutch);
        stringBuffer.append(',');
        stringBuffer.append("acceleratorKickDown");
        stringBuffer.append('=');
        stringBuffer.append(this.acceleratorKickDown);
        stringBuffer.append(',');
        stringBuffer.append("driverIsBraking");
        stringBuffer.append('=');
        stringBuffer.append(this.driverIsBraking);
        stringBuffer.append(',');
        stringBuffer.append("aCCIsActive");
        stringBuffer.append('=');
        stringBuffer.append(this.aCCIsActive);
        stringBuffer.append(',');
        stringBuffer.append("automaticGearShiftTransMode");
        stringBuffer.append('=');
        stringBuffer.append(this.automaticGearShiftTransMode);
        stringBuffer.append(',');
        stringBuffer.append("recuperationLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.recuperationLevel);
        stringBuffer.append(',');
        stringBuffer.append("hdcColor");
        stringBuffer.append('=');
        stringBuffer.append(this.hdcColor);
        stringBuffer.append(',');
        stringBuffer.append("hdcSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.hdcSpeed);
        stringBuffer.append(',');
        stringBuffer.append("edsDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.edsDisplay);
        stringBuffer.append(',');
        stringBuffer.append("valetParkingState");
        stringBuffer.append('=');
        stringBuffer.append(this.valetParkingState);
        stringBuffer.append(',');
        stringBuffer.append("highwayBlinkingState");
        stringBuffer.append('=');
        stringBuffer.append(this.highwayBlinkingState);
        stringBuffer.append(',');
        stringBuffer.append("batteryVoltage");
        stringBuffer.append('=');
        stringBuffer.append(this.batteryVoltage);
        stringBuffer.append(',');
        stringBuffer.append("lowBeamHeadlightIsActive");
        stringBuffer.append('=');
        stringBuffer.append(this.lowBeamHeadlightIsActive);
        stringBuffer.append(',');
        stringBuffer.append("highBeamHeadlightIsActive");
        stringBuffer.append('=');
        stringBuffer.append(this.highBeamHeadlightIsActive);
        stringBuffer.append(',');
        stringBuffer.append("fogLightFrontIsActive");
        stringBuffer.append('=');
        stringBuffer.append(this.fogLightFrontIsActive);
        stringBuffer.append(',');
        stringBuffer.append("fogLightRearIsActive");
        stringBuffer.append('=');
        stringBuffer.append(this.fogLightRearIsActive);
        stringBuffer.append(',');
        stringBuffer.append("daytimeRunningLightIsActive");
        stringBuffer.append('=');
        stringBuffer.append(this.daytimeRunningLightIsActive);
        stringBuffer.append(',');
        stringBuffer.append("espLight");
        stringBuffer.append('=');
        stringBuffer.append(this.espLight);
        stringBuffer.append(',');
        stringBuffer.append("espPassiveSensing");
        stringBuffer.append('=');
        stringBuffer.append(this.espPassiveSensing);
        stringBuffer.append(',');
        stringBuffer.append("tirePressureFrontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.tirePressureFrontLeft);
        stringBuffer.append(',');
        stringBuffer.append("tirePressureFrontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.tirePressureFrontRight);
        stringBuffer.append(',');
        stringBuffer.append("tirePressureRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.tirePressureRearLeft);
        stringBuffer.append(',');
        stringBuffer.append("tirePressureRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.tirePressureRearRight);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

