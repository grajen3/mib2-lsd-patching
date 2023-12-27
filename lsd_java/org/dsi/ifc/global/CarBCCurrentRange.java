/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class CarBCCurrentRange {
    public int state;
    public int currentRangeValue;
    public int currentRangeUnit;

    public CarBCCurrentRange() {
        this.state = 0;
        this.currentRangeValue = 0;
        this.currentRangeUnit = 0;
    }

    public CarBCCurrentRange(int n, int n2, int n3) {
        this.state = n;
        this.currentRangeValue = n2;
        this.currentRangeUnit = n3;
    }

    public int getState() {
        return this.state;
    }

    public int getCurrentRangeValue() {
        return this.currentRangeValue;
    }

    public int getCurrentRangeUnit() {
        return this.currentRangeUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CarBCCurrentRange");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("currentRangeValue");
        stringBuffer.append('=');
        stringBuffer.append(this.currentRangeValue);
        stringBuffer.append(',');
        stringBuffer.append("currentRangeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.currentRangeUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

