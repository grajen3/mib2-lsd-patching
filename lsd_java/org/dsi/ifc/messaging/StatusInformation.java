/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

public class StatusInformation {
    public String messageId;
    public int status;

    public StatusInformation() {
        this.messageId = "";
        this.status = 0;
    }

    public StatusInformation(String string, int n) {
        this.messageId = string;
        this.status = n;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("StatusInformation");
        stringBuffer.append('(');
        stringBuffer.append("messageId");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.messageId);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

