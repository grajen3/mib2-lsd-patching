/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swap;

public class SFscDetails {
    public int swid;
    public int state;
    public int index;
    public short version;
    public String vin;
    public String date;
    public String vcrn;

    public SFscDetails() {
        this.swid = 0;
        this.state = 0;
        this.index = 0;
        this.version = 0;
        this.vin = null;
        this.date = null;
        this.vcrn = null;
    }

    public SFscDetails(int n, int n2, int n3, short s, String string, String string2, String string3) {
        this.swid = n;
        this.state = n2;
        this.index = n3;
        this.version = s;
        this.vin = string;
        this.date = string2;
        this.vcrn = string3;
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

    public short getVersion() {
        return this.version;
    }

    public String getVin() {
        return this.vin;
    }

    public String getVcrn() {
        return this.vcrn;
    }

    public String getDate() {
        return this.date;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("SFscDetails");
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
        stringBuffer.append(',');
        stringBuffer.append("version");
        stringBuffer.append('=');
        stringBuffer.append(this.version);
        stringBuffer.append(',');
        stringBuffer.append("vin");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.vin);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("date");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.date);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("vcrn");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.vcrn);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

