/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class RegisterStateStruct {
    public int telRegisterState;
    public String telLongProviderName;
    public String telNumProviderName;
    public int telRegMode;

    public RegisterStateStruct() {
        this.telRegisterState = 0;
        this.telLongProviderName = null;
        this.telNumProviderName = null;
        this.telRegMode = 0;
    }

    public RegisterStateStruct(int n, String string, String string2, int n2) {
        this.telRegisterState = n;
        this.telLongProviderName = string;
        this.telNumProviderName = string2;
        this.telRegMode = n2;
    }

    public int getTelRegisterState() {
        return this.telRegisterState;
    }

    public String getTelLongProviderName() {
        return this.telLongProviderName;
    }

    public String getTelNumProviderName() {
        return this.telNumProviderName;
    }

    public int getTelRegMode() {
        return this.telRegMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("RegisterStateStruct");
        stringBuffer.append('(');
        stringBuffer.append("telRegisterState");
        stringBuffer.append('=');
        stringBuffer.append(this.telRegisterState);
        stringBuffer.append(',');
        stringBuffer.append("telLongProviderName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telLongProviderName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telNumProviderName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telNumProviderName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telRegMode");
        stringBuffer.append('=');
        stringBuffer.append(this.telRegMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

