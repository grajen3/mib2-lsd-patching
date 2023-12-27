/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

public class ListChangedInformation {
    public int reason;
    public int listSize;

    public ListChangedInformation() {
        this.reason = -1;
        this.listSize = -1;
    }

    public ListChangedInformation(int n, int n2) {
        this.reason = n;
        this.listSize = n2;
    }

    public int getReason() {
        return this.reason;
    }

    public int getListSize() {
        return this.listSize;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ListChangedInformation");
        stringBuffer.append('(');
        stringBuffer.append("reason");
        stringBuffer.append('=');
        stringBuffer.append(this.reason);
        stringBuffer.append(',');
        stringBuffer.append("listSize");
        stringBuffer.append('=');
        stringBuffer.append(this.listSize);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

