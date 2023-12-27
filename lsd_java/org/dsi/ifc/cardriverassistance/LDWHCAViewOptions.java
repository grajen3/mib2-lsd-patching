/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.global.CarViewOption;

public class LDWHCAViewOptions {
    public CarViewOption hCAToleranceLevel;
    public CarViewOption lDWSteeringWheelVibration;
    public CarViewOption hCAInterventionStyle;
    public CarViewOption lDWWarningTime;
    public CarViewOption ldwhcaSetFactoryDefault;
    public CarViewOption ldwhcaSystemOnOff;
    public CarViewOption ldwhcaWarningSound;

    public LDWHCAViewOptions() {
        this.hCAToleranceLevel = null;
        this.lDWSteeringWheelVibration = null;
        this.hCAInterventionStyle = null;
        this.lDWWarningTime = null;
        this.ldwhcaSetFactoryDefault = null;
        this.ldwhcaSystemOnOff = null;
        this.ldwhcaWarningSound = null;
    }

    public LDWHCAViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6) {
        this.hCAToleranceLevel = carViewOption;
        this.lDWSteeringWheelVibration = carViewOption2;
        this.hCAInterventionStyle = carViewOption3;
        this.lDWWarningTime = carViewOption4;
        this.ldwhcaSetFactoryDefault = carViewOption5;
        this.ldwhcaSystemOnOff = carViewOption6;
        this.ldwhcaWarningSound = null;
    }

    public LDWHCAViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7) {
        this.hCAToleranceLevel = carViewOption;
        this.lDWSteeringWheelVibration = carViewOption2;
        this.hCAInterventionStyle = carViewOption3;
        this.lDWWarningTime = carViewOption4;
        this.ldwhcaSetFactoryDefault = carViewOption5;
        this.ldwhcaSystemOnOff = carViewOption6;
        this.ldwhcaWarningSound = carViewOption7;
    }

    public CarViewOption getHCAToleranceLevel() {
        return this.hCAToleranceLevel;
    }

    public CarViewOption getLDWSteeringWheelVibration() {
        return this.lDWSteeringWheelVibration;
    }

    public CarViewOption getHCAInterventionStyle() {
        return this.hCAInterventionStyle;
    }

    public CarViewOption getLDWWarningTime() {
        return this.lDWWarningTime;
    }

    public CarViewOption getLdwhcaSetFactoryDefault() {
        return this.ldwhcaSetFactoryDefault;
    }

    public CarViewOption getLdwhcaSystemOnOff() {
        return this.ldwhcaSystemOnOff;
    }

    public CarViewOption getLdwhcaWarningSound() {
        return this.ldwhcaWarningSound;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(7350);
        stringBuffer.append("LDWHCAViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("hCAToleranceLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.hCAToleranceLevel);
        stringBuffer.append(',');
        stringBuffer.append("lDWSteeringWheelVibration");
        stringBuffer.append('=');
        stringBuffer.append(this.lDWSteeringWheelVibration);
        stringBuffer.append(',');
        stringBuffer.append("hCAInterventionStyle");
        stringBuffer.append('=');
        stringBuffer.append(this.hCAInterventionStyle);
        stringBuffer.append(',');
        stringBuffer.append("lDWWarningTime");
        stringBuffer.append('=');
        stringBuffer.append(this.lDWWarningTime);
        stringBuffer.append(',');
        stringBuffer.append("ldwhcaSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.ldwhcaSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("ldwhcaSystemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.ldwhcaSystemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("ldwhcaWarningSound");
        stringBuffer.append('=');
        stringBuffer.append(this.ldwhcaWarningSound);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

