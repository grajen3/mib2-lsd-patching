/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.global.CarViewOption;

public class PAViewOptions {
    public CarViewOption paSystemOnOff;
    public CarViewOption paSetFactoryDefault;
    public CarViewOption paConfigInformation;
    public CarViewOption paConfigWarning;
    public CarViewOption paWarningTimegap;

    public PAViewOptions() {
        this.paSystemOnOff = null;
        this.paSetFactoryDefault = null;
        this.paConfigInformation = null;
        this.paConfigWarning = null;
        this.paWarningTimegap = null;
    }

    public PAViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5) {
        this.paSystemOnOff = carViewOption;
        this.paSetFactoryDefault = carViewOption2;
        this.paConfigInformation = carViewOption3;
        this.paConfigWarning = carViewOption4;
        this.paWarningTimegap = carViewOption5;
    }

    public CarViewOption getPaSystemOnOff() {
        return this.paSystemOnOff;
    }

    public CarViewOption getPaSetFactoryDefault() {
        return this.paSetFactoryDefault;
    }

    public CarViewOption getPaConfigInformation() {
        return this.paConfigInformation;
    }

    public CarViewOption getPaConfigWarning() {
        return this.paConfigWarning;
    }

    public CarViewOption getPaWarningTimegap() {
        return this.paWarningTimegap;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(5250);
        stringBuffer.append("PAViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("paSystemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.paSystemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("paSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.paSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("paConfigInformation");
        stringBuffer.append('=');
        stringBuffer.append(this.paConfigInformation);
        stringBuffer.append(',');
        stringBuffer.append("paConfigWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.paConfigWarning);
        stringBuffer.append(',');
        stringBuffer.append("paWarningTimegap");
        stringBuffer.append('=');
        stringBuffer.append(this.paWarningTimegap);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

