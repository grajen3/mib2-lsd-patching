/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

public class TrustedDevice {
    public String deviceName;
    public String deviceAddress;
    public int deviceRole;
    public int deviceClass;
    public int deviceSecurity;
    public int linkMode;
    public int linkkeyStrength;
    public int lastConnectedServiceTypes;
    public int activeServiceTypes;
    public int offeredServiceTypes;

    public TrustedDevice() {
        this.deviceName = null;
        this.deviceAddress = null;
        this.deviceRole = 0;
        this.deviceClass = 0;
        this.deviceSecurity = 0;
        this.linkMode = 0;
        this.linkkeyStrength = 0;
        this.lastConnectedServiceTypes = 0;
        this.activeServiceTypes = 0;
        this.offeredServiceTypes = 0;
    }

    public TrustedDevice(String string, String string2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.deviceName = string;
        this.deviceAddress = string2;
        this.deviceRole = n;
        this.deviceClass = n2;
        this.deviceSecurity = n3;
        this.linkMode = n4;
        this.linkkeyStrength = n5;
        this.lastConnectedServiceTypes = n6;
        this.activeServiceTypes = n7;
        this.offeredServiceTypes = n8;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    public int getDeviceRole() {
        return this.deviceRole;
    }

    public int getDeviceClass() {
        return this.deviceClass;
    }

    public int getDeviceSecurity() {
        return this.deviceSecurity;
    }

    public int getLinkMode() {
        return this.linkMode;
    }

    public int getLinkkeyStrength() {
        return this.linkkeyStrength;
    }

    public int getLastConnectedServiceTypes() {
        return this.lastConnectedServiceTypes;
    }

    public int getActiveServiceTypes() {
        return this.activeServiceTypes;
    }

    public int getOfferedServiceTypes() {
        return this.offeredServiceTypes;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(700);
        stringBuffer.append("TrustedDevice");
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
        stringBuffer.append("deviceRole");
        stringBuffer.append('=');
        stringBuffer.append(this.deviceRole);
        stringBuffer.append(',');
        stringBuffer.append("deviceClass");
        stringBuffer.append('=');
        stringBuffer.append(this.deviceClass);
        stringBuffer.append(',');
        stringBuffer.append("deviceSecurity");
        stringBuffer.append('=');
        stringBuffer.append(this.deviceSecurity);
        stringBuffer.append(',');
        stringBuffer.append("linkMode");
        stringBuffer.append('=');
        stringBuffer.append(this.linkMode);
        stringBuffer.append(',');
        stringBuffer.append("linkkeyStrength");
        stringBuffer.append('=');
        stringBuffer.append(this.linkkeyStrength);
        stringBuffer.append(',');
        stringBuffer.append("lastConnectedServiceTypes");
        stringBuffer.append('=');
        stringBuffer.append(this.lastConnectedServiceTypes);
        stringBuffer.append(',');
        stringBuffer.append("activeServiceTypes");
        stringBuffer.append('=');
        stringBuffer.append(this.activeServiceTypes);
        stringBuffer.append(',');
        stringBuffer.append("offeredServiceTypes");
        stringBuffer.append('=');
        stringBuffer.append(this.offeredServiceTypes);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

