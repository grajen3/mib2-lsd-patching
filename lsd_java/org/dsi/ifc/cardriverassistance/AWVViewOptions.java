/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.cardriverassistance.AWVConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class AWVViewOptions {
    public CarViewOption system;
    public CarViewOption warning;
    public CarViewOption gong;
    public CarViewOption gongVolume;
    public CarViewOption brakeJerk;
    public CarViewOption emergencyBrake;
    public CarViewOption distanceWarning;
    public CarViewOption warningTimegap;
    public CarViewOption setFactoryDefault;
    public AWVConfiguration configuration;

    public AWVViewOptions() {
        this.system = null;
        this.warning = null;
        this.gong = null;
        this.gongVolume = null;
        this.brakeJerk = null;
        this.emergencyBrake = null;
        this.distanceWarning = null;
        this.warningTimegap = null;
        this.setFactoryDefault = null;
        this.configuration = null;
    }

    public AWVViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, AWVConfiguration aWVConfiguration) {
        this.system = carViewOption;
        this.warning = carViewOption2;
        this.gong = carViewOption3;
        this.gongVolume = carViewOption4;
        this.brakeJerk = carViewOption5;
        this.emergencyBrake = carViewOption6;
        this.distanceWarning = carViewOption7;
        this.warningTimegap = carViewOption8;
        this.setFactoryDefault = carViewOption9;
        this.configuration = aWVConfiguration;
    }

    public CarViewOption getSystem() {
        return this.system;
    }

    public CarViewOption getWarning() {
        return this.warning;
    }

    public CarViewOption getGong() {
        return this.gong;
    }

    public CarViewOption getGongVolume() {
        return this.gongVolume;
    }

    public CarViewOption getBrakeJerk() {
        return this.brakeJerk;
    }

    public CarViewOption getEmergencyBrake() {
        return this.emergencyBrake;
    }

    public CarViewOption getDistanceWarning() {
        return this.distanceWarning;
    }

    public CarViewOption getWarningTimegap() {
        return this.warningTimegap;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public AWVConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(10350);
        stringBuffer.append("AWVViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("system");
        stringBuffer.append('=');
        stringBuffer.append(this.system);
        stringBuffer.append(',');
        stringBuffer.append("warning");
        stringBuffer.append('=');
        stringBuffer.append(this.warning);
        stringBuffer.append(',');
        stringBuffer.append("gong");
        stringBuffer.append('=');
        stringBuffer.append(this.gong);
        stringBuffer.append(',');
        stringBuffer.append("gongVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.gongVolume);
        stringBuffer.append(',');
        stringBuffer.append("brakeJerk");
        stringBuffer.append('=');
        stringBuffer.append(this.brakeJerk);
        stringBuffer.append(',');
        stringBuffer.append("emergencyBrake");
        stringBuffer.append('=');
        stringBuffer.append(this.emergencyBrake);
        stringBuffer.append(',');
        stringBuffer.append("distanceWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceWarning);
        stringBuffer.append(',');
        stringBuffer.append("warningTimegap");
        stringBuffer.append('=');
        stringBuffer.append(this.warningTimegap);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

