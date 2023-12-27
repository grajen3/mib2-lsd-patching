/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlselection;

public class LameClient {
    public String deviceId;
    public int mostId;

    public LameClient() {
        this.deviceId = null;
        this.mostId = 0;
    }

    public LameClient(String string, int n) {
        this.deviceId = string;
        this.mostId = n;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getMostId() {
        return this.mostId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("LameClient");
        stringBuffer.append('(');
        stringBuffer.append("deviceId");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceId);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("mostId");
        stringBuffer.append('=');
        stringBuffer.append(this.mostId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

