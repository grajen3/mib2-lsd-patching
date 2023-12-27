/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class DisconnectReason {
    public int disconnectReason;
    public int callId;

    public DisconnectReason() {
        this.disconnectReason = 0;
        this.callId = 0;
    }

    public DisconnectReason(int n, int n2) {
        this.disconnectReason = n;
        this.callId = n2;
    }

    public int getDisconnectReason() {
        return this.disconnectReason;
    }

    public int getCallId() {
        return this.callId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DisconnectReason");
        stringBuffer.append('(');
        stringBuffer.append("disconnectReason");
        stringBuffer.append('=');
        stringBuffer.append(this.disconnectReason);
        stringBuffer.append(',');
        stringBuffer.append("callId");
        stringBuffer.append('=');
        stringBuffer.append(this.callId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

