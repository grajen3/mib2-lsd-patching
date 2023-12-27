/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

public class AreaWarningInfo {
    public int type;
    public int reserved;

    public AreaWarningInfo() {
        this.type = 0;
        this.reserved = 0;
    }

    public AreaWarningInfo(int n, int n2) {
        this.type = n;
        this.reserved = n2;
    }

    public int getType() {
        return this.type;
    }

    public int getReserved() {
        return this.reserved;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("AreaWarningInfo");
        stringBuffer.append('(');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("reserved");
        stringBuffer.append('=');
        stringBuffer.append(this.reserved);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

