/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

public class DiscoveredDevice {
    public String deviceName;
    public String deviceAddress;
    public String deviceClass;
    public int serviceTypes;

    public DiscoveredDevice() {
        this.deviceName = null;
        this.deviceAddress = null;
        this.deviceClass = null;
        this.serviceTypes = 0;
    }

    public DiscoveredDevice(String string, String string2, String string3, int n) {
        this.deviceName = string;
        this.deviceAddress = string2;
        this.deviceClass = string3;
        this.serviceTypes = n;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    public String getDeviceClass() {
        return this.deviceClass;
    }

    public int getServiceTypes() {
        return this.serviceTypes;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("DiscoveredDevice");
        stringBuffer.append('(');
        stringBuffer.append("deviceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("deviceAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("deviceClass");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceClass);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("serviceTypes");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceTypes);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

