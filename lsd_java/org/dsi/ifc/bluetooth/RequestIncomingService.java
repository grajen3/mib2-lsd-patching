/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

public class RequestIncomingService {
    public String btDeviceName;
    public String btDeviceAddress;
    public int btServiceType;

    public RequestIncomingService() {
        this.btDeviceName = null;
        this.btDeviceAddress = null;
        this.btServiceType = 0;
    }

    public RequestIncomingService(String string, String string2, int n) {
        this.btDeviceName = string;
        this.btDeviceAddress = string2;
        this.btServiceType = n;
    }

    public String getBtDeviceName() {
        return this.btDeviceName;
    }

    public String getBtDeviceAddress() {
        return this.btDeviceAddress;
    }

    public int getBtServiceType() {
        return this.btServiceType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("RequestIncomingService");
        stringBuffer.append('(');
        stringBuffer.append("btDeviceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.btDeviceName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("btDeviceAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.btDeviceAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("btServiceType");
        stringBuffer.append('=');
        stringBuffer.append(this.btServiceType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

