/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class RangeDataResidualEnergy {
    public int state;
    public float value;
    public int unit;

    public RangeDataResidualEnergy() {
        this.state = 0;
        this.value = 0.0f;
        this.unit = 0;
    }

    public RangeDataResidualEnergy(int n, float f2, int n2) {
        this.state = n;
        this.value = f2;
        this.unit = n2;
    }

    public int getState() {
        return this.state;
    }

    public float getValue() {
        return this.value;
    }

    public int getUnit() {
        return this.unit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("RangeDataResidualEnergy");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append(this.value);
        stringBuffer.append(',');
        stringBuffer.append("unit");
        stringBuffer.append('=');
        stringBuffer.append(this.unit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

