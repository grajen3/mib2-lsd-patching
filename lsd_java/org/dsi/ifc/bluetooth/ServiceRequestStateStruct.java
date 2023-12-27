/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

public class ServiceRequestStateStruct {
    public int btServiceRequestState;
    public String btDeviceAddress;
    public String btDeviceName;

    public ServiceRequestStateStruct() {
        this.btServiceRequestState = 0;
        this.btDeviceAddress = null;
        this.btDeviceName = null;
    }

    public ServiceRequestStateStruct(int n, String string, String string2) {
        this.btServiceRequestState = n;
        this.btDeviceAddress = string;
        this.btDeviceName = string2;
    }

    public int getBtServiceRequestState() {
        return this.btServiceRequestState;
    }

    public String getBtDeviceAddress() {
        return this.btDeviceAddress;
    }

    public String getBtDeviceName() {
        return this.btDeviceName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("ServiceRequestStateStruct");
        stringBuffer.append('(');
        stringBuffer.append("btServiceRequestState");
        stringBuffer.append('=');
        stringBuffer.append(this.btServiceRequestState);
        stringBuffer.append(',');
        stringBuffer.append("btDeviceAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.btDeviceAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("btDeviceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.btDeviceName);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

