/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class NetworkProvider {
    public String telLongProviderName;
    public String telNumProviderName;
    public int telProviderState;

    public NetworkProvider() {
        this.telLongProviderName = null;
        this.telNumProviderName = null;
        this.telProviderState = 0;
    }

    public NetworkProvider(String string, String string2, int n) {
        this.telLongProviderName = string;
        this.telNumProviderName = string2;
        this.telProviderState = n;
    }

    public String getTelLongProviderName() {
        return this.telLongProviderName;
    }

    public String getTelNumProviderName() {
        return this.telNumProviderName;
    }

    public int getTelProviderState() {
        return this.telProviderState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("NetworkProvider");
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
        stringBuffer.append("telProviderState");
        stringBuffer.append('=');
        stringBuffer.append(this.telProviderState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

