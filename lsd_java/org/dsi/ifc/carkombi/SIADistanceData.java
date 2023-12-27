/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class SIADistanceData {
    public int state;
    public int distance;
    public int unit;

    public SIADistanceData() {
        this.state = 0;
        this.distance = 0;
        this.unit = 0;
    }

    public SIADistanceData(int n, int n2, int n3) {
        this.state = n;
        this.distance = n2;
        this.unit = n3;
    }

    public int getState() {
        return this.state;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getUnit() {
        return this.unit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("SIADistanceData");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("unit");
        stringBuffer.append('=');
        stringBuffer.append(this.unit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

