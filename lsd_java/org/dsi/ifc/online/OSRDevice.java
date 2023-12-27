/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.online.OSRPersonalIdentifier;

public class OSRDevice {
    public String name;
    public OSRPersonalIdentifier pIdentifier;
    public int connectionState;

    public OSRDevice(String string, OSRPersonalIdentifier oSRPersonalIdentifier, int n) {
        this.name = string;
        this.pIdentifier = oSRPersonalIdentifier;
        this.connectionState = n;
    }

    public OSRDevice() {
        this.name = null;
        this.pIdentifier = null;
        this.connectionState = 0;
    }

    public String getName() {
        return this.name;
    }

    public OSRPersonalIdentifier getPIdentifier() {
        return this.pIdentifier;
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("OSRDevice");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("pIdentifier");
        stringBuffer.append('=');
        stringBuffer.append(this.pIdentifier);
        stringBuffer.append(',');
        stringBuffer.append("connectionState");
        stringBuffer.append('=');
        stringBuffer.append(this.connectionState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

