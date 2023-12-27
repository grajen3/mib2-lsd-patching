/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

import org.dsi.ifc.global.CarViewOption;

public class SemiStaticDataViewOptions {
    public CarViewOption maxChargingAirPressure;
    public CarViewOption maxOutputPower;
    public CarViewOption maxTorque;
    public CarViewOption engineDisplacement;
    public CarViewOption typeOfInjectionSystem;

    public SemiStaticDataViewOptions() {
        this.maxChargingAirPressure = null;
        this.maxOutputPower = null;
        this.maxTorque = null;
        this.engineDisplacement = null;
        this.typeOfInjectionSystem = null;
    }

    public SemiStaticDataViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2) {
        this.maxChargingAirPressure = carViewOption;
        this.maxOutputPower = carViewOption2;
        this.maxTorque = null;
        this.engineDisplacement = null;
        this.typeOfInjectionSystem = null;
    }

    public SemiStaticDataViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3) {
        this.maxChargingAirPressure = carViewOption;
        this.maxOutputPower = carViewOption2;
        this.maxTorque = carViewOption3;
        this.engineDisplacement = null;
        this.typeOfInjectionSystem = null;
    }

    public SemiStaticDataViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5) {
        this.maxChargingAirPressure = carViewOption;
        this.maxOutputPower = carViewOption2;
        this.maxTorque = carViewOption3;
        this.engineDisplacement = carViewOption4;
        this.typeOfInjectionSystem = carViewOption5;
    }

    public CarViewOption getMaxChargingAirPressure() {
        return this.maxChargingAirPressure;
    }

    public CarViewOption getMaxOutputPower() {
        return this.maxOutputPower;
    }

    public CarViewOption getMaxTorque() {
        return this.maxTorque;
    }

    public CarViewOption getEngineDisplacement() {
        return this.engineDisplacement;
    }

    public CarViewOption getTypeOfInjectionSystem() {
        return this.typeOfInjectionSystem;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(5250);
        stringBuffer.append("SemiStaticDataViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("maxChargingAirPressure");
        stringBuffer.append('=');
        stringBuffer.append(this.maxChargingAirPressure);
        stringBuffer.append(',');
        stringBuffer.append("maxOutputPower");
        stringBuffer.append('=');
        stringBuffer.append(this.maxOutputPower);
        stringBuffer.append(',');
        stringBuffer.append("maxTorque");
        stringBuffer.append('=');
        stringBuffer.append(this.maxTorque);
        stringBuffer.append(',');
        stringBuffer.append("engineDisplacement");
        stringBuffer.append('=');
        stringBuffer.append(this.engineDisplacement);
        stringBuffer.append(',');
        stringBuffer.append("typeOfInjectionSystem");
        stringBuffer.append('=');
        stringBuffer.append(this.typeOfInjectionSystem);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

