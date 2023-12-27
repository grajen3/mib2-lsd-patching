/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

public class Device {
    public int deviceID;
    public String deviceName;
    public int connectionMedium;
    public String deviceAddress;

    public Device() {
        this.deviceID = -1;
        this.deviceName = "";
        this.connectionMedium = 0;
        this.deviceAddress = "";
    }

    public Device(int n, String string, int n2, String string2) {
        this.deviceID = n;
        this.deviceName = string;
        this.connectionMedium = n2;
        this.deviceAddress = string2;
    }

    public int getDeviceID() {
        return this.deviceID;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getConnectionMedium() {
        return this.connectionMedium;
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("Device");
        stringBuffer.append('(');
        stringBuffer.append("deviceID");
        stringBuffer.append('=');
        stringBuffer.append(this.deviceID);
        stringBuffer.append(',');
        stringBuffer.append("deviceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("connectionMedium");
        stringBuffer.append('=');
        stringBuffer.append(this.connectionMedium);
        stringBuffer.append(',');
        stringBuffer.append("deviceAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceAddress);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

