/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class TIMStatus {
    public int status;
    public int timePosition;

    public TIMStatus() {
        this.status = 0;
        this.timePosition = 0;
    }

    public TIMStatus(int n, int n2) {
        this.status = n;
        this.timePosition = n2;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTimePosition() {
        return this.timePosition;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("TIMStatus");
        stringBuffer.append('(');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(',');
        stringBuffer.append("timePosition");
        stringBuffer.append('=');
        stringBuffer.append(this.timePosition);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

