/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.InetAddress;

public final class Inet4Address
extends InetAddress {
    private static final long serialVersionUID;

    Inet4Address(byte[] byArray) {
        this.ipaddress = byArray;
    }

    Inet4Address(byte[] byArray, String string) {
        this.ipaddress = byArray;
        this.hostName = string;
    }

    @Override
    public boolean isMulticastAddress() {
        return (this.ipaddress[0] & 0xF0) == 224;
    }

    @Override
    public boolean isAnyLocalAddress() {
        int n = 0;
        while (n < this.ipaddress.length) {
            if (this.ipaddress[n] != 0) {
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    public boolean isLoopbackAddress() {
        return (this.ipaddress[0] & 0xFF) == 127;
    }

    @Override
    public boolean isLinkLocalAddress() {
        return (this.ipaddress[0] & 0xFF) == 169 && (this.ipaddress[1] & 0xFF) == 254;
    }

    @Override
    public boolean isSiteLocalAddress() {
        return (this.ipaddress[0] & 0xFF) == 10 || (this.ipaddress[0] & 0xFF) == 172 && (this.ipaddress[1] & 0xFF) > 15 && (this.ipaddress[1] & 0xFF) < 32 || (this.ipaddress[0] & 0xFF) == 192 && (this.ipaddress[1] & 0xFF) == 168;
    }

    @Override
    public boolean isMCGlobal() {
        if (!this.isMulticastAddress()) {
            return false;
        }
        int n = InetAddress.bytesToInt(this.ipaddress, 0);
        if (n >>> 8 < 0x100E000) {
            return false;
        }
        return n >>> 24 <= 238;
    }

    @Override
    public boolean isMCNodeLocal() {
        return false;
    }

    @Override
    public boolean isMCLinkLocal() {
        return InetAddress.bytesToInt(this.ipaddress, 0) >>> 8 == 57344;
    }

    @Override
    public boolean isMCSiteLocal() {
        return InetAddress.bytesToInt(this.ipaddress, 0) >>> 16 == -1114112;
    }

    @Override
    public boolean isMCOrgLocal() {
        int n = InetAddress.bytesToInt(this.ipaddress, 0) >>> 16;
        return n >= -1058078720 && n <= -1007747072;
    }

    @Override
    public String getHostAddress() {
        String string = "";
        int n = 0;
        while (n < 4) {
            string = new StringBuffer(String.valueOf(string)).append(this.ipaddress[n] & 0xFF).toString();
            if (n != 3) {
                string = new StringBuffer(String.valueOf(string)).append(".").toString();
            }
            ++n;
        }
        return string;
    }

    @Override
    public int hashCode() {
        return InetAddress.bytesToInt(this.ipaddress, 0);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    private Object writeReplace() {
        return new InetAddress(this.ipaddress, this.hostName);
    }
}

