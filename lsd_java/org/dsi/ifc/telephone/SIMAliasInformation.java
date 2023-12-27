/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class SIMAliasInformation {
    public String btAddress;
    public String imsi;
    public String activeName;
    public String inactiveName;

    public SIMAliasInformation() {
        this.btAddress = "";
        this.imsi = "";
        this.activeName = "";
        this.inactiveName = "";
    }

    public SIMAliasInformation(String string, String string2, String string3, String string4) {
        this.btAddress = string;
        this.imsi = string2;
        this.activeName = string3;
        this.inactiveName = string4;
    }

    public String getBtAddress() {
        return this.btAddress;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getActiveName() {
        return this.activeName;
    }

    public String getInactiveName() {
        return this.inactiveName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("SIMAliasInformation");
        stringBuffer.append('(');
        stringBuffer.append("btAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.btAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("imsi");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imsi);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("activeName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.activeName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("inactiveName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.inactiveName);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

