/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

public class DiscoveredNetwork {
    public String networkName;
    public String bssidAddress;
    public int signalStrength;
    public int encryptionType;
    public boolean wpsAvailable;

    public DiscoveredNetwork() {
        this.networkName = null;
        this.bssidAddress = null;
        this.signalStrength = 0;
        this.encryptionType = 0;
        this.wpsAvailable = false;
    }

    public DiscoveredNetwork(String string, String string2, int n, int n2, boolean bl) {
        this.networkName = string;
        this.bssidAddress = string2;
        this.signalStrength = n;
        this.encryptionType = n2;
        this.wpsAvailable = bl;
    }

    public String getNetworkName() {
        return this.networkName;
    }

    public String getBssidAddress() {
        return this.bssidAddress;
    }

    public int gethSignalStrength() {
        return this.signalStrength;
    }

    public int getEncryptionType() {
        return this.encryptionType;
    }

    public int getSignalStrength() {
        return this.signalStrength;
    }

    public boolean isWpsAvailable() {
        return this.wpsAvailable;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("DiscoveredNetwork");
        stringBuffer.append('(');
        stringBuffer.append("networkName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.networkName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("bssidAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.bssidAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("signalStrength");
        stringBuffer.append('=');
        stringBuffer.append(this.signalStrength);
        stringBuffer.append(',');
        stringBuffer.append("encryptionType");
        stringBuffer.append('=');
        stringBuffer.append(this.encryptionType);
        stringBuffer.append(',');
        stringBuffer.append("wpsAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.wpsAvailable);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

