/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class ServiceCodeTypeStruct {
    public int telDialNumberType;
    public String telServiceCode;
    public int telServiceCodeRequestType;

    public ServiceCodeTypeStruct() {
        this.telDialNumberType = 0;
        this.telServiceCode = null;
        this.telServiceCodeRequestType = 0;
    }

    public ServiceCodeTypeStruct(int n, String string, int n2) {
        this.telDialNumberType = n;
        this.telServiceCode = string;
        this.telServiceCodeRequestType = n2;
    }

    public int getTelDialNumberType() {
        return this.telDialNumberType;
    }

    public String getTelServiceCode() {
        return this.telServiceCode;
    }

    public int getTelServiceCodeRequestType() {
        return this.telServiceCodeRequestType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("ServiceCodeTypeStruct");
        stringBuffer.append('(');
        stringBuffer.append("telDialNumberType");
        stringBuffer.append('=');
        stringBuffer.append(this.telDialNumberType);
        stringBuffer.append(',');
        stringBuffer.append("telServiceCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telServiceCode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telServiceCodeRequestType");
        stringBuffer.append('=');
        stringBuffer.append(this.telServiceCodeRequestType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

