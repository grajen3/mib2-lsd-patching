/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

public class PhoneData {
    public String number;
    public int numberType;
    public int speedDialKey;

    public PhoneData() {
        this.number = null;
        this.numberType = 0;
        this.speedDialKey = -1;
    }

    public PhoneData(String string, int n, int n2) {
        this.number = string;
        this.numberType = n;
        this.speedDialKey = n2;
    }

    public String getNumber() {
        return this.number;
    }

    public int getNumberType() {
        return this.numberType;
    }

    public int getSpeedDialKey() {
        return this.speedDialKey;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("PhoneData");
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
        stringBuffer.append(',');
        stringBuffer.append("speedDialKey");
        stringBuffer.append('=');
        stringBuffer.append(this.speedDialKey);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

