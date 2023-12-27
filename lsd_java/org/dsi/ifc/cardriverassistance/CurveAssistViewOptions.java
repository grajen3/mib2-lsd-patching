/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.global.CarViewOption;

public class CurveAssistViewOptions {
    public CarViewOption curveAssistSystemOnOff;
    public CarViewOption curveAssistSetFactoryDefault;

    public CurveAssistViewOptions() {
        this.curveAssistSystemOnOff = null;
        this.curveAssistSetFactoryDefault = null;
    }

    public CurveAssistViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2) {
        this.curveAssistSystemOnOff = carViewOption;
        this.curveAssistSetFactoryDefault = carViewOption2;
    }

    public CarViewOption getCurveAssistSystemOnOff() {
        return this.curveAssistSystemOnOff;
    }

    public CarViewOption getCurveAssistSetFactoryDefault() {
        return this.curveAssistSetFactoryDefault;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2150);
        stringBuffer.append("CurveAssistViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("curveAssistSystemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.curveAssistSystemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("curveAssistSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.curveAssistSetFactoryDefault);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

