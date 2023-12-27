/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mobilityhorizon;

public class ValueUnitPair {
    public float value;
    public int unit;

    public ValueUnitPair(float f2, int n) {
        this.value = f2;
        this.unit = n;
    }

    public ValueUnitPair() {
        this.value = 0.0f;
        this.unit = 0;
    }

    public float getValue() {
        return this.value;
    }

    public int getUnit() {
        return this.unit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ValueUnitPair");
        stringBuffer.append('(');
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

