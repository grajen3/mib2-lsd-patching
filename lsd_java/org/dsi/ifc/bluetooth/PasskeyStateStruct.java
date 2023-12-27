/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

public class PasskeyStateStruct {
    public int btPasskeyState;
    public String btDeviceName;
    public String btDeviceAddress;
    public String btPasskey;

    public PasskeyStateStruct() {
        this.btPasskeyState = 0;
        this.btDeviceAddress = null;
        this.btDeviceName = null;
        this.btPasskey = null;
    }

    public PasskeyStateStruct(int n, String string, String string2, String string3) {
        this.btPasskeyState = n;
        this.btDeviceName = string;
        this.btDeviceAddress = string2;
        this.btPasskey = string3;
    }

    public int getBtPasskeyState() {
        return this.btPasskeyState;
    }

    public String getBtDeviceAddress() {
        return this.btDeviceAddress;
    }

    public String getBtDeviceName() {
        return this.btDeviceName;
    }

    public String getBtPasskey() {
        return this.btPasskey;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("PasskeyStateStruct");
        stringBuffer.append('(');
        stringBuffer.append("btPasskeyState");
        stringBuffer.append('=');
        stringBuffer.append(this.btPasskeyState);
        stringBuffer.append(',');
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
        stringBuffer.append("btPasskey");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.btPasskey);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

