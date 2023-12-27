/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class CarBCAcceleration {
    public int state;
    public float accelerationValue;
    public int accelerationUnit;

    public CarBCAcceleration() {
        this.state = 0;
        this.accelerationValue = 0.0f;
        this.accelerationUnit = 0;
    }

    public CarBCAcceleration(int n, float f2, int n2) {
        this.state = n;
        this.accelerationValue = f2;
        this.accelerationUnit = n2;
    }

    public int getState() {
        return this.state;
    }

    public float getAccelerationValue() {
        return this.accelerationValue;
    }

    public int getAccelerationUnit() {
        return this.accelerationUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CarBCAcceleration");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("accelerationValue");
        stringBuffer.append('=');
        stringBuffer.append(this.accelerationValue);
        stringBuffer.append(',');
        stringBuffer.append("accelerationUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.accelerationUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

