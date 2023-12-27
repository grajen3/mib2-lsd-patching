/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class CarViewOption {
    public int state;
    public int reason;

    public CarViewOption() {
        this.state = 0;
        this.reason = 0;
    }

    public CarViewOption(int n, int n2) {
        this.state = n;
        this.reason = n2;
    }

    public int getState() {
        return this.state;
    }

    public int getReason() {
        return this.reason;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ViewOption(");
        stringBuffer.append("state: ");
        stringBuffer.append(this.state);
        stringBuffer.append(",");
        stringBuffer.append("reason: ");
        stringBuffer.append(this.reason);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}

