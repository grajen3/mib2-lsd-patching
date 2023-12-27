/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class StartStopProhibitList {
    public byte listPosition;
    public int reason;

    public StartStopProhibitList() {
        this.listPosition = 0;
        this.reason = 0;
    }

    public StartStopProhibitList(byte by, int n) {
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
        stringBuffer.append("StartStopProhibitList");
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

