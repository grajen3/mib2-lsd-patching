/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

public class ADBPhoneData {
    public String phoneNumber;
    public long phoneType;

    public ADBPhoneData() {
        this.phoneNumber = null;
        this.phoneType = 0L;
    }

    public ADBPhoneData(String string, long l) {
        this.phoneNumber = string;
        this.phoneType = l;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public long getPhoneType() {
        return this.phoneType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ADBPhoneData");
        stringBuffer.append('(');
        stringBuffer.append("phoneNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.phoneNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("phoneType");
        stringBuffer.append('=');
        stringBuffer.append(this.phoneType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

