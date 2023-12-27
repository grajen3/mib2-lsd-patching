/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

public class OilLevelRefillVolume {
    public int value;
    public int unit;

    public OilLevelRefillVolume() {
        this.value = 0;
        this.unit = 0;
    }

    public OilLevelRefillVolume(int n, int n2) {
        this.value = n;
        this.unit = n2;
    }

    public int getValue() {
        return this.value;
    }

    public int getUnit() {
        return this.unit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("OilLevelRefillVolume");
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

