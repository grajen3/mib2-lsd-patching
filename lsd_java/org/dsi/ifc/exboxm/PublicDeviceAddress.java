/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

public class PublicDeviceAddress {
    public String publicDeviceAddress;

    public PublicDeviceAddress() {
        this.publicDeviceAddress = null;
    }

    public PublicDeviceAddress(String string) {
        this.publicDeviceAddress = string;
    }

    public String getPublicDeviceAddress() {
        return this.publicDeviceAddress;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("PublicDeviceAddress");
        stringBuffer.append('(');
        stringBuffer.append("publicDeviceAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.publicDeviceAddress);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

