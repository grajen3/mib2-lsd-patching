/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class CarBCSpeed {
    public int speedValueState;
    public float speedValue;
    public int speedUnit;

    public CarBCSpeed() {
        this.speedValueState = 0;
        this.speedValue = 0.0f;
        this.speedUnit = 0;
    }

    public CarBCSpeed(int n, float f2, int n2) {
        this.speedValueState = n;
        this.speedValue = f2;
        this.speedUnit = n2;
    }

    public int getSpeedValueState() {
        return this.speedValueState;
    }

    public float getSpeedValue() {
        return this.speedValue;
    }

    public int getSpeedUnit() {
        return this.speedUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CarBCSpeed");
        stringBuffer.append('(');
        stringBuffer.append("speedValueState");
        stringBuffer.append('=');
        stringBuffer.append(this.speedValueState);
        stringBuffer.append(',');
        stringBuffer.append("speedValue");
        stringBuffer.append('=');
        stringBuffer.append(this.speedValue);
        stringBuffer.append(',');
        stringBuffer.append("speedUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.speedUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

