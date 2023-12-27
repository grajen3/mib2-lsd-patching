/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCMenueConfiguration {
    public boolean cruisingRange;
    public boolean averageConsumption;
    public boolean currentConsumption;
    public boolean averageSpeed;
    public boolean drivingTime;
    public boolean drivenDistance;
    public boolean menueDisplay;
    public boolean refuelVolume;
    public boolean speedWarningFIS;
    public boolean coolantTemp;
    public boolean secondarySpeed;
    public boolean resetTime;
    public boolean comfortPowerConsumption;
    public boolean zeroEmissionTime;
    public boolean zeroEmissionDistance;

    public BCMenueConfiguration() {
        this.cruisingRange = false;
        this.averageConsumption = false;
        this.currentConsumption = false;
        this.averageSpeed = false;
        this.drivingTime = false;
        this.drivenDistance = false;
        this.menueDisplay = false;
        this.refuelVolume = false;
        this.speedWarningFIS = false;
        this.coolantTemp = false;
        this.secondarySpeed = false;
        this.resetTime = false;
        this.comfortPowerConsumption = false;
        this.zeroEmissionTime = false;
        this.zeroEmissionDistance = false;
    }

    public BCMenueConfiguration(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15) {
        this.cruisingRange = bl;
        this.averageConsumption = bl2;
        this.currentConsumption = bl3;
        this.averageSpeed = bl4;
        this.drivingTime = bl5;
        this.drivenDistance = bl6;
        this.menueDisplay = bl7;
        this.refuelVolume = bl8;
        this.speedWarningFIS = bl9;
        this.coolantTemp = bl10;
        this.secondarySpeed = bl11;
        this.resetTime = bl12;
        this.comfortPowerConsumption = bl13;
        this.zeroEmissionTime = bl14;
        this.zeroEmissionDistance = bl15;
    }

    public boolean isCruisingRange() {
        return this.cruisingRange;
    }

    public boolean isAverageConsumption() {
        return this.averageConsumption;
    }

    public boolean isCurrentConsumption() {
        return this.currentConsumption;
    }

    public boolean isAverageSpeed() {
        return this.averageSpeed;
    }

    public boolean isDrivingTime() {
        return this.drivingTime;
    }

    public boolean isDrivenDistance() {
        return this.drivenDistance;
    }

    public boolean isMenueDisplay() {
        return this.menueDisplay;
    }

    public boolean isRefuelVolume() {
        return this.refuelVolume;
    }

    public boolean isSpeedWarningFIS() {
        return this.speedWarningFIS;
    }

    public boolean isCoolantTemp() {
        return this.coolantTemp;
    }

    public boolean isSecondarySpeed() {
        return this.secondarySpeed;
    }

    public boolean isResetTime() {
        return this.resetTime;
    }

    public boolean isComfortPowerConsumption() {
        return this.comfortPowerConsumption;
    }

    public boolean isZeroEmissionTime() {
        return this.zeroEmissionTime;
    }

    public boolean isZeroEmissionDistance() {
        return this.zeroEmissionDistance;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(750);
        stringBuffer.append("BCMenueConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("cruisingRange");
        stringBuffer.append('=');
        stringBuffer.append(this.cruisingRange);
        stringBuffer.append(',');
        stringBuffer.append("averageConsumption");
        stringBuffer.append('=');
        stringBuffer.append(this.averageConsumption);
        stringBuffer.append(',');
        stringBuffer.append("currentConsumption");
        stringBuffer.append('=');
        stringBuffer.append(this.currentConsumption);
        stringBuffer.append(',');
        stringBuffer.append("averageSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.averageSpeed);
        stringBuffer.append(',');
        stringBuffer.append("drivingTime");
        stringBuffer.append('=');
        stringBuffer.append(this.drivingTime);
        stringBuffer.append(',');
        stringBuffer.append("drivenDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.drivenDistance);
        stringBuffer.append(',');
        stringBuffer.append("menueDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.menueDisplay);
        stringBuffer.append(',');
        stringBuffer.append("refuelVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.refuelVolume);
        stringBuffer.append(',');
        stringBuffer.append("speedWarningFIS");
        stringBuffer.append('=');
        stringBuffer.append(this.speedWarningFIS);
        stringBuffer.append(',');
        stringBuffer.append("coolantTemp");
        stringBuffer.append('=');
        stringBuffer.append(this.coolantTemp);
        stringBuffer.append(',');
        stringBuffer.append("secondarySpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.secondarySpeed);
        stringBuffer.append(',');
        stringBuffer.append("resetTime");
        stringBuffer.append('=');
        stringBuffer.append(this.resetTime);
        stringBuffer.append(',');
        stringBuffer.append("comfortPowerConsumption");
        stringBuffer.append('=');
        stringBuffer.append(this.comfortPowerConsumption);
        stringBuffer.append(',');
        stringBuffer.append("zeroEmissionTime");
        stringBuffer.append('=');
        stringBuffer.append(this.zeroEmissionTime);
        stringBuffer.append(',');
        stringBuffer.append("zeroEmissionDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.zeroEmissionDistance);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

