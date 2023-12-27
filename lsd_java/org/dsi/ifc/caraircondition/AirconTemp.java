/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconTemp {
    public int tempValue;
    public int tempUnit;

    public AirconTemp() {
        this.tempValue = 0;
        this.tempUnit = 0;
    }

    public AirconTemp(int n, int n2) {
        this.tempValue = n;
        this.tempUnit = n2;
    }

    public int getTempValue() {
        return this.tempValue;
    }

    public int getTempUnit() {
        return this.tempUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("AirconTemp");
        stringBuffer.append('(');
        stringBuffer.append("tempValue");
        stringBuffer.append('=');
        stringBuffer.append(this.tempValue);
        stringBuffer.append(',');
        stringBuffer.append("tempUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.tempUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

