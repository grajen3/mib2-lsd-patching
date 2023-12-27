/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class CarBCDistance {
    public int distanceValueState;
    public double distanceValue;
    public int distanceUnit;

    public CarBCDistance() {
        this.distanceValueState = 0;
        this.distanceValue = 0.0;
        this.distanceUnit = 0;
    }

    public CarBCDistance(int n, double d2, int n2) {
        this.distanceValueState = n;
        this.distanceValue = d2;
        this.distanceUnit = n2;
    }

    public int getDistanceValueState() {
        return this.distanceValueState;
    }

    public double getDistanceValue() {
        return this.distanceValue;
    }

    public int getDistanceUnit() {
        return this.distanceUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CarBCDistance");
        stringBuffer.append('(');
        stringBuffer.append("distanceValueState");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceValueState);
        stringBuffer.append(',');
        stringBuffer.append("distanceValue");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceValue);
        stringBuffer.append(',');
        stringBuffer.append("distanceUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

