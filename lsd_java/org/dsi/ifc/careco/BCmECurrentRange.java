/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmECurrentRange {
    public int rangeGainValuePrimary;
    public int rangeGainValueSecondary;
    public int rangeGainValueTotal;
    public int rangeValuePrimary;
    public int rangeValueSecondary;
    public int rangeValueTotal;
    public int rangeUnit;

    public BCmECurrentRange() {
        this.rangeGainValuePrimary = 0;
        this.rangeGainValueSecondary = 0;
        this.rangeGainValueTotal = 0;
        this.rangeValuePrimary = 0;
        this.rangeValueSecondary = 0;
        this.rangeValueTotal = 0;
        this.rangeUnit = 0;
    }

    public BCmECurrentRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.rangeGainValuePrimary = n;
        this.rangeGainValueSecondary = n2;
        this.rangeGainValueTotal = n3;
        this.rangeValuePrimary = n4;
        this.rangeValueSecondary = n5;
        this.rangeValueTotal = n6;
        this.rangeUnit = n7;
    }

    public int getRangeGainValuePrimary() {
        return this.rangeGainValuePrimary;
    }

    public int getRangeGainValueSecondary() {
        return this.rangeGainValueSecondary;
    }

    public int getRangeGainValueTotal() {
        return this.rangeGainValueTotal;
    }

    public int getRangeValuePrimary() {
        return this.rangeValuePrimary;
    }

    public int getRangeValueSecondary() {
        return this.rangeValueSecondary;
    }

    public int getRangeValueTotal() {
        return this.rangeValueTotal;
    }

    public int getRangeUnit() {
        return this.rangeUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("BCmECurrentRange");
        stringBuffer.append('(');
        stringBuffer.append("rangeGainValuePrimary");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeGainValuePrimary);
        stringBuffer.append(',');
        stringBuffer.append("rangeGainValueSecondary");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeGainValueSecondary);
        stringBuffer.append(',');
        stringBuffer.append("rangeGainValueTotal");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeGainValueTotal);
        stringBuffer.append(',');
        stringBuffer.append("rangeValuePrimary");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeValuePrimary);
        stringBuffer.append(',');
        stringBuffer.append("rangeValueSecondary");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeValueSecondary);
        stringBuffer.append(',');
        stringBuffer.append("rangeValueTotal");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeValueTotal);
        stringBuffer.append(',');
        stringBuffer.append("rangeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

