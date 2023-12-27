/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlife;

public class CallState {
    public int status;
    public int direction;

    public CallState() {
        this.status = 0;
        this.direction = 0;
    }

    public CallState(int n, int n2) {
        this.status = n;
        this.direction = n2;
    }

    public int getStatus() {
        return this.status;
    }

    public int getDirection() {
        return this.direction;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("CallState");
        stringBuffer.append('(');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(',');
        stringBuffer.append("direction");
        stringBuffer.append('=');
        stringBuffer.append(this.direction);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

