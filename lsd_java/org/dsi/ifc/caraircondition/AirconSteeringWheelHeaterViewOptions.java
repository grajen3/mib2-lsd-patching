/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

import org.dsi.ifc.global.CarViewOption;

public class AirconSteeringWheelHeaterViewOptions {
    public CarViewOption heating;
    public CarViewOption autoHeating;
    public CarViewOption heatingStep;
    public CarViewOption adjustViaSeatHeating;
    public CarViewOption currentState;

    public AirconSteeringWheelHeaterViewOptions() {
        this.heating = null;
        this.autoHeating = null;
        this.heatingStep = null;
        this.adjustViaSeatHeating = null;
        this.currentState = null;
    }

    public AirconSteeringWheelHeaterViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5) {
        this.heating = carViewOption;
        this.autoHeating = carViewOption2;
        this.heatingStep = carViewOption3;
        this.adjustViaSeatHeating = carViewOption4;
        this.currentState = carViewOption5;
    }

    public CarViewOption getHeating() {
        return this.heating;
    }

    public CarViewOption getAutoHeating() {
        return this.autoHeating;
    }

    public CarViewOption getHeatingStep() {
        return this.heatingStep;
    }

    public CarViewOption getAdjustViaSeatHeating() {
        return this.adjustViaSeatHeating;
    }

    public CarViewOption getCurrentState() {
        return this.currentState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(5200);
        stringBuffer.append("AirconSteeringWheelHeaterViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("heating");
        stringBuffer.append('=');
        stringBuffer.append(this.heating);
        stringBuffer.append(',');
        stringBuffer.append("autoHeating");
        stringBuffer.append('=');
        stringBuffer.append(this.autoHeating);
        stringBuffer.append(',');
        stringBuffer.append("heatingStep");
        stringBuffer.append('=');
        stringBuffer.append(this.heatingStep);
        stringBuffer.append(',');
        stringBuffer.append("adjustViaSeatHeating");
        stringBuffer.append('=');
        stringBuffer.append(this.adjustViaSeatHeating);
        stringBuffer.append(',');
        stringBuffer.append("currentState");
        stringBuffer.append('=');
        stringBuffer.append(this.currentState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

