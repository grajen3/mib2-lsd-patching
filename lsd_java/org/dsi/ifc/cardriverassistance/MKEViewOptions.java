/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.global.CarViewOption;

public class MKEViewOptions {
    public CarViewOption systemOnOff;
    public CarViewOption mkeSetFactoryDefault;

    public MKEViewOptions() {
        this.systemOnOff = null;
        this.mkeSetFactoryDefault = null;
    }

    public MKEViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2) {
        this.systemOnOff = carViewOption;
        this.mkeSetFactoryDefault = carViewOption2;
    }

    public CarViewOption getSystemOnOff() {
        return this.systemOnOff;
    }

    public CarViewOption getMkeSetFactoryDefault() {
        return this.mkeSetFactoryDefault;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2100);
        stringBuffer.append("MKEViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("systemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.systemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("mkeSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.mkeSetFactoryDefault);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

