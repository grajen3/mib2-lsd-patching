/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class NetworkProviderName {
    public String telLongProviderName;
    public String telNumProviderName;
    public int telRegMode;

    public NetworkProviderName() {
        this.telLongProviderName = null;
        this.telNumProviderName = null;
        this.telRegMode = 0;
    }

    public NetworkProviderName(String string, String string2, int n) {
        this.telLongProviderName = string;
        this.telNumProviderName = string2;
        this.telRegMode = n;
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
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("NetworkProviderName");
        stringBuffer.append('(');
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

