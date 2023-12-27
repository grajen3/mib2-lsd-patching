/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class IntLightRGBValues {
    public int baseColorRed;
    public int baseColorGreen;
    public int baseColorBlue;

    public IntLightRGBValues() {
        this.baseColorRed = 0;
        this.baseColorGreen = 0;
        this.baseColorBlue = 0;
    }

    public IntLightRGBValues(int n, int n2, int n3) {
        this.baseColorRed = n;
        this.baseColorGreen = n2;
        this.baseColorBlue = n3;
    }

    public int getBaseColorRed() {
        return this.baseColorRed;
    }

    public int getBaseColorGreen() {
        return this.baseColorGreen;
    }

    public int getBaseColorBlue() {
        return this.baseColorBlue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("IntLightRGBValues");
        stringBuffer.append('(');
        stringBuffer.append("baseColorRed");
        stringBuffer.append('=');
        stringBuffer.append(this.baseColorRed);
        stringBuffer.append(',');
        stringBuffer.append("baseColorGreen");
        stringBuffer.append('=');
        stringBuffer.append(this.baseColorGreen);
        stringBuffer.append(',');
        stringBuffer.append("baseColorBlue");
        stringBuffer.append('=');
        stringBuffer.append(this.baseColorBlue);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

