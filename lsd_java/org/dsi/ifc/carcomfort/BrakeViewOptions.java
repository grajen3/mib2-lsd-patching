/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.BrakeConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class BrakeViewOptions {
    public CarViewOption brakeElectricalParking;
    public CarViewOption brakeAutoHold;
    public CarViewOption brakeEscMode;
    public BrakeConfiguration configuration;
    public CarViewOption brakeHdcMode;

    public BrakeViewOptions() {
        this.brakeElectricalParking = null;
        this.brakeAutoHold = null;
        this.brakeEscMode = null;
        this.configuration = null;
        this.brakeHdcMode = null;
    }

    public BrakeViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, BrakeConfiguration brakeConfiguration, CarViewOption carViewOption4) {
        this.brakeElectricalParking = carViewOption;
        this.brakeAutoHold = carViewOption2;
        this.brakeEscMode = carViewOption3;
        this.configuration = brakeConfiguration;
        this.brakeHdcMode = carViewOption4;
    }

    public CarViewOption getBrakeElectricalParking() {
        return this.brakeElectricalParking;
    }

    public CarViewOption getBrakeAutoHold() {
        return this.brakeAutoHold;
    }

    public CarViewOption getBrakeEscMode() {
        return this.brakeEscMode;
    }

    public CarViewOption getBrakeHdcMode() {
        return this.brakeHdcMode;
    }

    public BrakeConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(5200);
        stringBuffer.append("BrakeViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("brakeElectricalParking");
        stringBuffer.append('=');
        stringBuffer.append(this.brakeElectricalParking);
        stringBuffer.append(',');
        stringBuffer.append("brakeAutoHold");
        stringBuffer.append('=');
        stringBuffer.append(this.brakeAutoHold);
        stringBuffer.append(',');
        stringBuffer.append("brakeEscMode");
        stringBuffer.append('=');
        stringBuffer.append(this.brakeEscMode);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(',');
        stringBuffer.append("brakeHdcMode");
        stringBuffer.append('=');
        stringBuffer.append(this.brakeHdcMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

