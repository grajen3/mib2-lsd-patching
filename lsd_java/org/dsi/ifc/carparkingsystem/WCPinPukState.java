/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class WCPinPukState {
    public String serialNumber;
    public int state;
    public int lockTime;

    public WCPinPukState() {
        this.serialNumber = null;
        this.state = 255;
        this.lockTime = -16842752;
    }

    public WCPinPukState(String string, int n, int n2) {
        this.serialNumber = string;
        this.state = n;
        this.lockTime = n2;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public int getState() {
        return this.state;
    }

    public int getLockTime() {
        return this.lockTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("WCPinPukState");
        stringBuffer.append('(');
        stringBuffer.append("serialNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.serialNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("lockTime");
        stringBuffer.append('=');
        stringBuffer.append(this.lockTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

