/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class CarBCTime {
    public int state;
    public int timeValue;

    public CarBCTime() {
        this.state = 0;
        this.timeValue = 0;
    }

    public CarBCTime(int n, int n2) {
        this.state = n;
        this.timeValue = n2;
    }

    public int getState() {
        return this.state;
    }

    public int getTimeValue() {
        return this.timeValue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CarBCTime");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("timeValue");
        stringBuffer.append('=');
        stringBuffer.append(this.timeValue);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

