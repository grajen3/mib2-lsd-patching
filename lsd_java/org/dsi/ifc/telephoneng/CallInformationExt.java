/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class CallInformationExt {
    public short telEntryType;
    public int telDBPhoneNumberIndex;
    public int adbPhoneDataCount;

    public CallInformationExt() {
        this.telEntryType = 0;
        this.telDBPhoneNumberIndex = 0;
        this.adbPhoneDataCount = 0;
    }

    public CallInformationExt(short s, int n, int n2) {
        this.telEntryType = s;
        this.telDBPhoneNumberIndex = n;
        this.adbPhoneDataCount = n2;
    }

    public short getTelEntryType() {
        return this.telEntryType;
    }

    public int getTelDBPhoneNumberIndex() {
        return this.telDBPhoneNumberIndex;
    }

    public int getAdbPhoneDataCount() {
        return this.adbPhoneDataCount;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CallInformationExt");
        stringBuffer.append('(');
        stringBuffer.append("telEntryType");
        stringBuffer.append('=');
        stringBuffer.append(this.telEntryType);
        stringBuffer.append(',');
        stringBuffer.append("telDBPhoneNumberIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.telDBPhoneNumberIndex);
        stringBuffer.append(',');
        stringBuffer.append("adbPhoneDataCount");
        stringBuffer.append('=');
        stringBuffer.append(this.adbPhoneDataCount);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

