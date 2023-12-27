/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swap;

public class SFscStatus {
    public int swid;
    public int state;
    public int index;

    public SFscStatus() {
        this.swid = 0;
        this.state = 0;
        this.index = 0;
    }

    public SFscStatus(int n, int n2, int n3) {
        this.swid = n;
        this.state = n2;
        this.index = n3;
    }

    public int getSwid() {
        return this.swid;
    }

    public int getState() {
        return this.state;
    }

    public int getIndex() {
        return this.index;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("SFscStatus");
        stringBuffer.append('(');
        stringBuffer.append("swid");
        stringBuffer.append('=');
        stringBuffer.append(this.swid);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("index");
        stringBuffer.append('=');
        stringBuffer.append(this.index);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

