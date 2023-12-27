/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

import org.dsi.ifc.global.CarViewOption;

public class EAViewOptions {
    public CarViewOption system;
    public CarViewOption pedalJerk;
    public CarViewOption setFactoryDefault;
    public CarViewOption freeWheeling;
    public CarViewOption startStop;

    public EAViewOptions() {
        this.system = null;
        this.pedalJerk = null;
        this.setFactoryDefault = null;
        this.freeWheeling = null;
        this.startStop = null;
    }

    public EAViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3) {
        this.system = carViewOption;
        this.pedalJerk = carViewOption2;
        this.setFactoryDefault = carViewOption3;
        this.freeWheeling = null;
        this.startStop = null;
    }

    public EAViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5) {
        this.system = carViewOption;
        this.pedalJerk = carViewOption2;
        this.setFactoryDefault = carViewOption3;
        this.freeWheeling = carViewOption4;
        this.startStop = carViewOption5;
    }

    public CarViewOption getSystem() {
        return this.system;
    }

    public CarViewOption getPedalJerk() {
        return this.pedalJerk;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public CarViewOption getFreeWheeling() {
        return this.freeWheeling;
    }

    public CarViewOption getStartStop() {
        return this.startStop;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(5200);
        stringBuffer.append("EAViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("system");
        stringBuffer.append('=');
        stringBuffer.append(this.system);
        stringBuffer.append(',');
        stringBuffer.append("pedalJerk");
        stringBuffer.append('=');
        stringBuffer.append(this.pedalJerk);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("freeWheeling");
        stringBuffer.append('=');
        stringBuffer.append(this.freeWheeling);
        stringBuffer.append(',');
        stringBuffer.append("startStop");
        stringBuffer.append('=');
        stringBuffer.append(this.startStop);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

