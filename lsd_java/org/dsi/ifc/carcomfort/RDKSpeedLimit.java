/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class RDKSpeedLimit {
    public int state;
    public int speedValue;
    public int speedUnit;

    public RDKSpeedLimit() {
        this.state = 0;
        this.speedValue = 0;
        this.speedUnit = 0;
    }

    public RDKSpeedLimit(int n, int n2, int n3) {
        this.state = n;
        this.speedValue = n2;
        this.speedUnit = n3;
    }

    public int getState() {
        return this.state;
    }

    public int getSpeedValue() {
        return this.speedValue;
    }

    public int getSpeedUnit() {
        return this.speedUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("RDKSpeedLimit");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
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

