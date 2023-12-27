/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

public class Node {
    public String macAddress;

    public Node() {
        this.macAddress = null;
    }

    public Node(String string) {
        this.macAddress = string;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("Node");
        stringBuffer.append('(');
        stringBuffer.append("macAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.macAddress);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

