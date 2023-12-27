/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.smartphoneintegration;

public class Device {
    public int deviceID;
    public String deviceName;
    public int connectionType;
    public String deviceAddress;
    public int connectionMethod;

    public Device() {
        this.deviceID = -1;
        this.deviceName = null;
        this.connectionType = 0;
        this.deviceAddress = null;
        this.connectionMethod = 0;
    }

    public Device(int n, String string, int n2, String string2, int n3) {
        this.deviceID = n;
        this.deviceName = string;
        this.connectionType = n2;
        this.deviceAddress = string2;
        this.connectionMethod = n3;
    }

    public int getDeviceID() {
        return this.deviceID;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    public int getConnectionMethod() {
        return this.connectionMethod;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
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
        stringBuffer.append("connectionType");
        stringBuffer.append('=');
        stringBuffer.append(this.connectionType);
        stringBuffer.append(',');
        stringBuffer.append("deviceAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("connectionMethod");
        stringBuffer.append('=');
        stringBuffer.append(this.connectionMethod);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

