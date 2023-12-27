/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.cardriverassistance.ACCConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class ACCViewOptions {
    public CarViewOption gongState;
    public CarViewOption gongVolume;
    public CarViewOption timegap;
    public CarViewOption drivingProgram;
    public CarViewOption defaultMode;
    public CarViewOption curveAssist;
    public CarViewOption speedLimitAdoption;
    public CarViewOption speedLimitOffset;
    public CarViewOption trafficJamAssist;
    public CarViewOption distanceWarning;
    public CarViewOption setFactoryDefault;
    public ACCConfiguration configuration;
    public CarViewOption paccSensibility;
    public CarViewOption paccMaxSpeed;
    public CarViewOption paccMeanVelocity;
    public CarViewOption paccMeanConsumption;
    public CarViewOption paccCoastingPercentage;
    public CarViewOption paccDrivingProgram;
    public CarViewOption paccSystemState;

    public ACCViewOptions() {
        this.gongState = null;
        this.gongVolume = null;
        this.timegap = null;
        this.drivingProgram = null;
        this.defaultMode = null;
        this.curveAssist = null;
        this.speedLimitAdoption = null;
        this.speedLimitOffset = null;
        this.trafficJamAssist = null;
        this.distanceWarning = null;
        this.setFactoryDefault = null;
        this.configuration = null;
        this.paccSensibility = null;
        this.paccMaxSpeed = null;
        this.paccMeanVelocity = null;
        this.paccMeanConsumption = null;
        this.paccCoastingPercentage = null;
        this.paccDrivingProgram = null;
        this.paccSystemState = null;
    }

    public ACCViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, ACCConfiguration aCCConfiguration) {
        this.gongState = carViewOption;
        this.gongVolume = carViewOption2;
        this.timegap = carViewOption3;
        this.drivingProgram = carViewOption4;
        this.defaultMode = carViewOption5;
        this.curveAssist = carViewOption6;
        this.speedLimitAdoption = carViewOption7;
        this.speedLimitOffset = carViewOption8;
        this.trafficJamAssist = carViewOption9;
        this.distanceWarning = carViewOption10;
        this.setFactoryDefault = carViewOption11;
        this.configuration = aCCConfiguration;
    }

    public ACCViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, ACCConfiguration aCCConfiguration, CarViewOption carViewOption12, CarViewOption carViewOption13, CarViewOption carViewOption14, CarViewOption carViewOption15, CarViewOption carViewOption16, CarViewOption carViewOption17, CarViewOption carViewOption18) {
        this.gongState = carViewOption;
        this.gongVolume = carViewOption2;
        this.timegap = carViewOption3;
        this.drivingProgram = carViewOption4;
        this.defaultMode = carViewOption5;
        this.curveAssist = carViewOption6;
        this.speedLimitAdoption = carViewOption7;
        this.speedLimitOffset = carViewOption8;
        this.trafficJamAssist = carViewOption9;
        this.distanceWarning = carViewOption10;
        this.setFactoryDefault = carViewOption11;
        this.configuration = aCCConfiguration;
        this.paccSensibility = carViewOption12;
        this.paccMaxSpeed = carViewOption13;
        this.paccMeanVelocity = carViewOption14;
        this.paccMeanConsumption = carViewOption15;
        this.paccCoastingPercentage = carViewOption16;
        this.paccDrivingProgram = carViewOption17;
        this.paccSystemState = carViewOption18;
    }

    public CarViewOption getGongState() {
        return this.gongState;
    }

    public CarViewOption getGongVolume() {
        return this.gongVolume;
    }

    public CarViewOption getTimegap() {
        return this.timegap;
    }

    public CarViewOption getDrivingProgram() {
        return this.drivingProgram;
    }

    public CarViewOption getDefaultMode() {
        return this.defaultMode;
    }

    public CarViewOption getCurveAssist() {
        return this.curveAssist;
    }

    public CarViewOption getSpeedLimitAdoption() {
        return this.speedLimitAdoption;
    }

    public CarViewOption getSpeedLimitOffset() {
        return this.speedLimitOffset;
    }

    public CarViewOption getTrafficJamAssist() {
        return this.trafficJamAssist;
    }

    public CarViewOption getDistanceWarning() {
        return this.distanceWarning;
    }

    public CarViewOption getPaccSensibility() {
        return this.paccSensibility;
    }

    public CarViewOption getPaccMaxSpeed() {
        return this.paccMaxSpeed;
    }

    public CarViewOption getPaccMeanVelocity() {
        return this.paccMeanVelocity;
    }

    public CarViewOption getPaccMeanConsumption() {
        return this.paccMeanConsumption;
    }

    public CarViewOption getPaccCoastingPercentage() {
        return this.paccCoastingPercentage;
    }

    public CarViewOption getPaccDrivingProgram() {
        return this.paccDrivingProgram;
    }

    public CarViewOption getPaccSystemState() {
        return this.paccSystemState;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public ACCConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(19750);
        stringBuffer.append("ACCViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("gongState");
        stringBuffer.append('=');
        stringBuffer.append(this.gongState);
        stringBuffer.append(',');
        stringBuffer.append("gongVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.gongVolume);
        stringBuffer.append(',');
        stringBuffer.append("timegap");
        stringBuffer.append('=');
        stringBuffer.append(this.timegap);
        stringBuffer.append(',');
        stringBuffer.append("drivingProgram");
        stringBuffer.append('=');
        stringBuffer.append(this.drivingProgram);
        stringBuffer.append(',');
        stringBuffer.append("defaultMode");
        stringBuffer.append('=');
        stringBuffer.append(this.defaultMode);
        stringBuffer.append(',');
        stringBuffer.append("curveAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.curveAssist);
        stringBuffer.append(',');
        stringBuffer.append("speedLimitAdoption");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimitAdoption);
        stringBuffer.append(',');
        stringBuffer.append("speedLimitOffset");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimitOffset);
        stringBuffer.append(',');
        stringBuffer.append("trafficJamAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficJamAssist);
        stringBuffer.append(',');
        stringBuffer.append("distanceWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceWarning);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(',');
        stringBuffer.append("paccSensibility");
        stringBuffer.append('=');
        stringBuffer.append(this.paccSensibility);
        stringBuffer.append(',');
        stringBuffer.append("paccMaxSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.paccMaxSpeed);
        stringBuffer.append(',');
        stringBuffer.append("paccMeanVelocity");
        stringBuffer.append('=');
        stringBuffer.append(this.paccMeanVelocity);
        stringBuffer.append(',');
        stringBuffer.append("paccMeanConsumption");
        stringBuffer.append('=');
        stringBuffer.append(this.paccMeanConsumption);
        stringBuffer.append(',');
        stringBuffer.append("paccCoastingPercentage");
        stringBuffer.append('=');
        stringBuffer.append(this.paccCoastingPercentage);
        stringBuffer.append(',');
        stringBuffer.append("paccDrivingProgram");
        stringBuffer.append('=');
        stringBuffer.append(this.paccDrivingProgram);
        stringBuffer.append(',');
        stringBuffer.append("paccSystemState");
        stringBuffer.append('=');
        stringBuffer.append(this.paccSystemState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

