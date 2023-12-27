/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.RDKConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class RDKViewOptions {
    public CarViewOption tireDisplay;
    public CarViewOption tireChanged;
    public CarViewOption pressureChanged;
    public CarViewOption systemOnOff;
    public CarViewOption speedLimit;
    public CarViewOption tireSetup;
    public RDKConfiguration configuration;
    public CarViewOption pressureLevel;
    public CarViewOption differentialPressure;
    public CarViewOption residualBatteryLifetime;
    public CarViewOption actualState;
    public CarViewOption actualPressure;
    public CarViewOption requiredPressure;
    public CarViewOption actualTemperature;
    public CarViewOption setFactoryDefault;

    public RDKViewOptions() {
        this.tireDisplay = null;
        this.tireChanged = null;
        this.pressureChanged = null;
        this.systemOnOff = null;
        this.speedLimit = null;
        this.tireSetup = null;
        this.configuration = null;
        this.pressureLevel = null;
        this.differentialPressure = null;
        this.residualBatteryLifetime = null;
        this.actualState = null;
        this.actualPressure = null;
        this.requiredPressure = null;
        this.actualTemperature = null;
        this.setFactoryDefault = null;
    }

    public RDKViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, RDKConfiguration rDKConfiguration) {
        this.tireDisplay = carViewOption;
        this.tireChanged = carViewOption2;
        this.pressureChanged = carViewOption3;
        this.systemOnOff = carViewOption4;
        this.speedLimit = carViewOption5;
        this.tireSetup = carViewOption6;
        this.configuration = rDKConfiguration;
        this.pressureLevel = null;
        this.differentialPressure = null;
        this.residualBatteryLifetime = null;
        this.actualState = null;
        this.actualPressure = null;
        this.requiredPressure = null;
        this.actualTemperature = null;
        this.setFactoryDefault = null;
    }

    public RDKViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, RDKConfiguration rDKConfiguration, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9) {
        this.tireDisplay = carViewOption;
        this.tireChanged = carViewOption2;
        this.pressureChanged = carViewOption3;
        this.systemOnOff = carViewOption4;
        this.speedLimit = carViewOption5;
        this.tireSetup = carViewOption6;
        this.configuration = rDKConfiguration;
        this.pressureLevel = carViewOption7;
        this.differentialPressure = carViewOption8;
        this.residualBatteryLifetime = carViewOption9;
        this.actualState = null;
        this.actualPressure = null;
        this.requiredPressure = null;
        this.actualTemperature = null;
        this.setFactoryDefault = null;
    }

    public RDKViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, RDKConfiguration rDKConfiguration, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13, CarViewOption carViewOption14) {
        this.tireDisplay = carViewOption;
        this.tireChanged = carViewOption2;
        this.pressureChanged = carViewOption3;
        this.systemOnOff = carViewOption4;
        this.speedLimit = carViewOption5;
        this.tireSetup = carViewOption6;
        this.configuration = rDKConfiguration;
        this.pressureLevel = carViewOption7;
        this.differentialPressure = carViewOption8;
        this.residualBatteryLifetime = carViewOption9;
        this.actualState = carViewOption10;
        this.actualPressure = carViewOption11;
        this.requiredPressure = carViewOption12;
        this.actualTemperature = carViewOption13;
        this.setFactoryDefault = carViewOption14;
    }

    public CarViewOption getTireDisplay() {
        return this.tireDisplay;
    }

    public CarViewOption getTireChanged() {
        return this.tireChanged;
    }

    public CarViewOption getPressureChanged() {
        return this.pressureChanged;
    }

    public CarViewOption getSystemOnOff() {
        return this.systemOnOff;
    }

    public CarViewOption getSpeedLimit() {
        return this.speedLimit;
    }

    public CarViewOption getTireSetup() {
        return this.tireSetup;
    }

    public RDKConfiguration getConfiguration() {
        return this.configuration;
    }

    public CarViewOption getPressureLevel() {
        return this.pressureLevel;
    }

    public CarViewOption getDifferentialPressure() {
        return this.differentialPressure;
    }

    public CarViewOption getResidualBatteryLifetime() {
        return this.residualBatteryLifetime;
    }

    public CarViewOption getActualState() {
        return this.actualState;
    }

    public CarViewOption getActualPressure() {
        return this.actualPressure;
    }

    public CarViewOption getRequiredPressure() {
        return this.requiredPressure;
    }

    public CarViewOption getActualTemperature() {
        return this.actualTemperature;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(15600);
        stringBuffer.append("RDKViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("tireDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.tireDisplay);
        stringBuffer.append(',');
        stringBuffer.append("tireChanged");
        stringBuffer.append('=');
        stringBuffer.append(this.tireChanged);
        stringBuffer.append(',');
        stringBuffer.append("pressureChanged");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureChanged);
        stringBuffer.append(',');
        stringBuffer.append("systemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.systemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("speedLimit");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimit);
        stringBuffer.append(',');
        stringBuffer.append("tireSetup");
        stringBuffer.append('=');
        stringBuffer.append(this.tireSetup);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(',');
        stringBuffer.append("pressureLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureLevel);
        stringBuffer.append(',');
        stringBuffer.append("differentialPressure");
        stringBuffer.append('=');
        stringBuffer.append(this.differentialPressure);
        stringBuffer.append(',');
        stringBuffer.append("residualBatteryLifetime");
        stringBuffer.append('=');
        stringBuffer.append(this.residualBatteryLifetime);
        stringBuffer.append(',');
        stringBuffer.append("actualState");
        stringBuffer.append('=');
        stringBuffer.append(this.actualState);
        stringBuffer.append(',');
        stringBuffer.append("actualPressure");
        stringBuffer.append('=');
        stringBuffer.append(this.actualPressure);
        stringBuffer.append(',');
        stringBuffer.append("requiredPressure");
        stringBuffer.append('=');
        stringBuffer.append(this.requiredPressure);
        stringBuffer.append(',');
        stringBuffer.append("actualTemperature");
        stringBuffer.append('=');
        stringBuffer.append(this.actualTemperature);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

