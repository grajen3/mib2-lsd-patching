/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCTotalDistance {
    public double distanceValue;
    public int distanceUnit;

    public BCTotalDistance() {
        this.distanceValue = 0.0;
        this.distanceUnit = 0;
    }

    public BCTotalDistance(double d2, int n) {
        this.distanceValue = d2;
        this.distanceUnit = n;
    }

    public double getDistanceValue() {
        return this.distanceValue;
    }

    public int getDistanceUnit() {
        return this.distanceUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BCTotalDistance");
        stringBuffer.append('(');
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

