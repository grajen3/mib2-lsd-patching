/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.upnp;

public class DeviceInfo {
    public String deviceName;
    public String deviceID;
    public int deviceType;

    public DeviceInfo() {
        this.deviceName = null;
        this.deviceID = null;
        this.deviceType = 0;
    }

    public DeviceInfo(String string, int n) {
        this.deviceName = null;
        this.deviceID = string;
        this.deviceType = n;
    }

    public DeviceInfo(String string, String string2, int n) {
        this.deviceName = string;
        this.deviceID = string2;
        this.deviceType = n;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("DeviceInfo");
        stringBuffer.append('(');
        stringBuffer.append("deviceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("deviceID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("deviceType");
        stringBuffer.append('=');
        stringBuffer.append(this.deviceType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

