/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class LISpellerData {
    public short[] spellerStateData;

    public LISpellerData() {
        this.spellerStateData = null;
    }

    public LISpellerData(short[] sArray) {
        this.spellerStateData = sArray;
    }

    public short[] getSpellerStateData() {
        return this.spellerStateData;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("LISpellerData");
        stringBuffer.append('(');
        stringBuffer.append("spellerStateData");
        stringBuffer.append('[');
        if (this.spellerStateData != null) {
            stringBuffer.append(this.spellerStateData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.spellerStateData != null) {
            int n = this.spellerStateData.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.spellerStateData[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.spellerStateData);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

