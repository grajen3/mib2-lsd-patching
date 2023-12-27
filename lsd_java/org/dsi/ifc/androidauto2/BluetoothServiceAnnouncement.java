/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto2;

public class BluetoothServiceAnnouncement {
    public String macAddressHU;
    public int supportedPairingMethods;

    public BluetoothServiceAnnouncement() {
        this.macAddressHU = null;
        this.supportedPairingMethods = 0;
    }

    public BluetoothServiceAnnouncement(String string, int n) {
        this.macAddressHU = string;
        this.supportedPairingMethods = n;
    }

    public String getMacAddressHU() {
        return this.macAddressHU;
    }

    public int getSupportedPairingMethods() {
        return this.supportedPairingMethods;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("BluetoothServiceAnnouncement");
        stringBuffer.append('(');
        stringBuffer.append("macAddressHU");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.macAddressHU);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("supportedPairingMethods");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedPairingMethods);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

