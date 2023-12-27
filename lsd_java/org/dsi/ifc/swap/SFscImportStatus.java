/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swap;

public class SFscImportStatus {
    public int swid;
    public int state;
    public int suppinfo;
    public int index;

    public SFscImportStatus() {
        this.swid = 0;
        this.state = 0;
        this.suppinfo = 0;
        this.index = 0;
    }

    public SFscImportStatus(int n, int n2, int n3, int n4) {
        this.swid = n;
        this.state = n2;
        this.suppinfo = n3;
        this.index = n4;
    }

    public int getSwid() {
        return this.swid;
    }

    public int getState() {
        return this.state;
    }

    public int getSuppinfo() {
        return this.suppinfo;
    }

    public int getIndex() {
        return this.index;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("SFscImportStatus");
        stringBuffer.append('(');
        stringBuffer.append("swid");
        stringBuffer.append('=');
        stringBuffer.append(this.swid);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("suppinfo");
        stringBuffer.append('=');
        stringBuffer.append(this.suppinfo);
        stringBuffer.append(',');
        stringBuffer.append("index");
        stringBuffer.append('=');
        stringBuffer.append(this.index);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

