/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class ServiceInfo {
    public int ensID;
    public int ensECC;
    public long sID;
    public String shortName;
    public String fullName;
    public byte[] ptyCodes;
    public boolean tp;
    public boolean radiotext;

    public ServiceInfo() {
        this.ensID = 0;
        this.ensECC = 0;
        this.sID = 0L;
        this.shortName = "";
        this.fullName = "";
        this.ptyCodes = null;
        this.radiotext = false;
        this.tp = false;
    }

    public ServiceInfo(int n, int n2, long l, String string, String string2, byte[] byArray, boolean bl, boolean bl2) {
        this.ensID = n;
        this.ensECC = n2;
        this.sID = l;
        this.shortName = string;
        this.fullName = string2;
        this.ptyCodes = byArray;
        this.radiotext = bl2;
        this.tp = bl;
    }

    public boolean isRadiotext() {
        return this.radiotext;
    }

    public int getEnsID() {
        return this.ensID;
    }

    public int getEnsECC() {
        return this.ensECC;
    }

    public long getSID() {
        return this.sID;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public byte[] getPtyCodes() {
        return this.ptyCodes;
    }

    public boolean isTp() {
        return this.tp;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("ServiceInfo");
        stringBuffer.append('(');
        stringBuffer.append("ensID");
        stringBuffer.append('=');
        stringBuffer.append(this.ensID);
        stringBuffer.append(',');
        stringBuffer.append("ensECC");
        stringBuffer.append('=');
        stringBuffer.append(this.ensECC);
        stringBuffer.append(',');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("shortName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("fullName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.fullName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("ptyCodes");
        stringBuffer.append('[');
        if (this.ptyCodes != null) {
            stringBuffer.append(this.ptyCodes.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.ptyCodes != null) {
            int n = this.ptyCodes.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.ptyCodes[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.ptyCodes);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("tp");
        stringBuffer.append('=');
        stringBuffer.append(this.tp);
        stringBuffer.append(',');
        stringBuffer.append("radiotext");
        stringBuffer.append('=');
        stringBuffer.append(this.radiotext);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

