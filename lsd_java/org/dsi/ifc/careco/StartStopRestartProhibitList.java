/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class StartStopRestartProhibitList {
    public byte listPosition;
    public int reason;

    public StartStopRestartProhibitList() {
        this.listPosition = 0;
        this.reason = 0;
    }

    public StartStopRestartProhibitList(byte by, int n) {
        this.listPosition = by;
        this.reason = n;
    }

    public byte getListPosition() {
        return this.listPosition;
    }

    public int getReason() {
        return this.reason;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("StartStopRestartProhibitList");
        stringBuffer.append('(');
        stringBuffer.append("listPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.listPosition);
        stringBuffer.append(',');
        stringBuffer.append("reason");
        stringBuffer.append('=');
        stringBuffer.append(this.reason);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

