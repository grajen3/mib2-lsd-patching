/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class PortalMessagingData {
    public long messageType;
    public String email;
    public String url;

    public PortalMessagingData() {
        this.messageType = 0L;
        this.email = null;
        this.url = null;
    }

    public PortalMessagingData(long l, String string, String string2) {
        this.messageType = l;
        this.email = string;
        this.url = string2;
    }

    public long getMessageType() {
        return this.messageType;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("PortalMessagingData");
        stringBuffer.append('(');
        stringBuffer.append("messageType");
        stringBuffer.append('=');
        stringBuffer.append(this.messageType);
        stringBuffer.append(',');
        stringBuffer.append("email");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.email);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("url");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.url);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

