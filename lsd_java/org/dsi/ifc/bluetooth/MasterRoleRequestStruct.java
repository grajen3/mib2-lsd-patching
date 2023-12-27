/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

public class MasterRoleRequestStruct {
    public String btDeviceAddress;
    public String btDeviceName;
    public boolean requested;

    public MasterRoleRequestStruct() {
        this.btDeviceAddress = null;
        this.btDeviceName = null;
        this.requested = false;
    }

    public MasterRoleRequestStruct(String string, String string2, boolean bl) {
        this.btDeviceAddress = string;
        this.btDeviceName = string2;
        this.requested = bl;
    }

    public String getBtDeviceAddress() {
        return this.btDeviceAddress;
    }

    public String getBtDeviceName() {
        return this.btDeviceName;
    }

    public boolean isRequested() {
        return this.requested;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("MasterRoleRequestStruct");
        stringBuffer.append('(');
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
        stringBuffer.append(',');
        stringBuffer.append("requested");
        stringBuffer.append('=');
        stringBuffer.append(this.requested);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

