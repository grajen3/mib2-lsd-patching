/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

public class NavPhoneData {
    public String number;
    public int numberType;

    public NavPhoneData() {
        this.number = "";
        this.numberType = 0;
    }

    public NavPhoneData(String string, int n) {
        this.number = string;
        this.numberType = n;
    }

    public String getNumber() {
        return this.number;
    }

    public int getNumberType() {
        return this.numberType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("NavPhoneData");
        stringBuffer.append('(');
        stringBuffer.append("number");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.number);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("numberType");
        stringBuffer.append('=');
        stringBuffer.append(this.numberType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

