/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmERangeGainTotal {
    public int rangeGainTotalValue;
    public int rangeUnit;

    public BCmERangeGainTotal() {
        this.rangeGainTotalValue = 0;
        this.rangeUnit = 0;
    }

    public BCmERangeGainTotal(int n, int n2) {
        this.rangeGainTotalValue = n;
        this.rangeUnit = n2;
    }

    public int getRangeGainTotalValue() {
        return this.rangeGainTotalValue;
    }

    public int getRangeUnit() {
        return this.rangeUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BCmERangeGainTotal");
        stringBuffer.append('(');
        stringBuffer.append("rangeGainTotalValue");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeGainTotalValue);
        stringBuffer.append(',');
        stringBuffer.append("rangeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

