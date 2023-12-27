/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class UGDOVersionData {
    public int countryCode;
    public int state;
    public int version;

    public UGDOVersionData() {
        this.countryCode = 0;
        this.state = 0;
        this.version = 0;
    }

    public UGDOVersionData(int n, int n2, int n3) {
        this.countryCode = n;
        this.state = n2;
        this.version = n3;
    }

    public int getCountryCode() {
        return this.countryCode;
    }

    public int getState() {
        return this.state;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("UGDOVersionData");
        stringBuffer.append('(');
        stringBuffer.append("countryCode");
        stringBuffer.append('=');
        stringBuffer.append(this.countryCode);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("version");
        stringBuffer.append('=');
        stringBuffer.append(this.version);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

