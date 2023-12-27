/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

public class Network {
    public String macAccessPoint;
    public int channel;
    public String sSID;

    public Network() {
        this.macAccessPoint = null;
        this.channel = 0;
        this.sSID = null;
    }

    public Network(String string, int n, String string2) {
        this.macAccessPoint = string;
        this.channel = n;
        this.sSID = string2;
    }

    public String getMacAccessPoint() {
        return this.macAccessPoint;
    }

    public int getChannel() {
        return this.channel;
    }

    public String getSSID() {
        return this.sSID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("Network");
        stringBuffer.append('(');
        stringBuffer.append("macAccessPoint");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.macAccessPoint);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("channel");
        stringBuffer.append('=');
        stringBuffer.append(this.channel);
        stringBuffer.append(',');
        stringBuffer.append("sSID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.sSID);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

