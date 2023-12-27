/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class OSRNotifyProperties {
    public String idonlineapp;
    public int priority;
    public int reason;

    public OSRNotifyProperties() {
        this.idonlineapp = "";
        this.priority = -1;
        this.reason = -1;
    }

    public OSRNotifyProperties(String string, int n, int n2) {
        this.idonlineapp = string;
        this.priority = n;
        this.reason = n2;
    }

    public String getIdonlineapp() {
        return this.idonlineapp;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getReason() {
        return this.reason;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("OSRNotifyProperties");
        stringBuffer.append('(');
        stringBuffer.append("idonlineapp");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.idonlineapp);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("priority");
        stringBuffer.append('=');
        stringBuffer.append(this.priority);
        stringBuffer.append(',');
        stringBuffer.append("reason");
        stringBuffer.append('=');
        stringBuffer.append(this.reason);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

