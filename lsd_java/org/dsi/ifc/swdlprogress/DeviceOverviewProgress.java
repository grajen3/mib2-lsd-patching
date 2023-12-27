/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlprogress;

public class DeviceOverviewProgress {
    public String fileName;
    public int value;
    public int type;

    public DeviceOverviewProgress() {
        this.fileName = null;
        this.value = 0;
        this.type = 0;
    }

    public DeviceOverviewProgress(String string, int n, int n2) {
        this.fileName = string;
        this.value = n;
        this.type = n2;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getValue() {
        return this.value;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DeviceOverviewProgress");
        stringBuffer.append('(');
        stringBuffer.append("fileName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.fileName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append(this.value);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

