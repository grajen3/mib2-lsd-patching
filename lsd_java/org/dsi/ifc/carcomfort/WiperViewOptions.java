/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.global.CarViewOption;

public class WiperViewOptions {
    public CarViewOption wiperServicePosition;
    public CarViewOption wiperRainSensorOnOff;
    public CarViewOption wiperRainSensorConfig;
    public CarViewOption wiperRearWiping;
    public CarViewOption wiperTearsWiping;
    public CarViewOption wiperWinterPosition;
    public CarViewOption easyEntrySteeringColumn;
    public CarViewOption wiperSetFactoryDefault;

    public WiperViewOptions() {
        this.wiperServicePosition = null;
        this.wiperRainSensorOnOff = null;
        this.wiperRainSensorConfig = null;
        this.wiperRearWiping = null;
        this.wiperTearsWiping = null;
        this.wiperWinterPosition = null;
        this.easyEntrySteeringColumn = null;
        this.wiperSetFactoryDefault = null;
    }

    public WiperViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8) {
        this.wiperServicePosition = carViewOption;
        this.wiperRainSensorOnOff = carViewOption2;
        this.wiperRainSensorConfig = carViewOption3;
        this.wiperRearWiping = carViewOption4;
        this.wiperTearsWiping = carViewOption5;
        this.wiperWinterPosition = carViewOption6;
        this.easyEntrySteeringColumn = carViewOption7;
        this.wiperSetFactoryDefault = carViewOption8;
    }

    public CarViewOption getWiperServicePosition() {
        return this.wiperServicePosition;
    }

    public CarViewOption getWiperRainSensorOnOff() {
        return this.wiperRainSensorOnOff;
    }

    public CarViewOption getWiperRainSensorConfig() {
        return this.wiperRainSensorConfig;
    }

    public CarViewOption getWiperRearWiping() {
        return this.wiperRearWiping;
    }

    public CarViewOption getWiperTearsWiping() {
        return this.wiperTearsWiping;
    }

    public CarViewOption getWiperWinterPosition() {
        return this.wiperWinterPosition;
    }

    public CarViewOption getEasyEntrySteeringColumn() {
        return this.easyEntrySteeringColumn;
    }

    public CarViewOption getWiperSetFactoryDefault() {
        return this.wiperSetFactoryDefault;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(8400);
        stringBuffer.append("WiperViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("wiperServicePosition");
        stringBuffer.append('=');
        stringBuffer.append(this.wiperServicePosition);
        stringBuffer.append(',');
        stringBuffer.append("wiperRainSensorOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.wiperRainSensorOnOff);
        stringBuffer.append(',');
        stringBuffer.append("wiperRainSensorConfig");
        stringBuffer.append('=');
        stringBuffer.append(this.wiperRainSensorConfig);
        stringBuffer.append(',');
        stringBuffer.append("wiperRearWiping");
        stringBuffer.append('=');
        stringBuffer.append(this.wiperRearWiping);
        stringBuffer.append(',');
        stringBuffer.append("wiperTearsWiping");
        stringBuffer.append('=');
        stringBuffer.append(this.wiperTearsWiping);
        stringBuffer.append(',');
        stringBuffer.append("wiperWinterPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.wiperWinterPosition);
        stringBuffer.append(',');
        stringBuffer.append("easyEntrySteeringColumn");
        stringBuffer.append('=');
        stringBuffer.append(this.easyEntrySteeringColumn);
        stringBuffer.append(',');
        stringBuffer.append("wiperSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.wiperSetFactoryDefault);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

