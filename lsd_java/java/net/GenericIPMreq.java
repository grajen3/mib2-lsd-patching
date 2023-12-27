/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

final class GenericIPMreq {
    private InetAddress multiaddr;
    private InetAddress interfaceAddr;
    private boolean isIPV6Address;
    private int interfaceIdx;

    GenericIPMreq(InetAddress inetAddress) {
        this.multiaddr = inetAddress;
        this.interfaceAddr = null;
        this.interfaceIdx = 0;
        this.init();
    }

    GenericIPMreq(InetAddress inetAddress, NetworkInterface networkInterface) {
        this.multiaddr = inetAddress;
        if (networkInterface != null) {
            this.interfaceIdx = networkInterface.getIndex();
            this.interfaceAddr = null;
            Enumeration enumeration = networkInterface.getInetAddresses();
            if (inetAddress instanceof Inet4Address && enumeration != null) {
                boolean bl = false;
                while (enumeration.hasMoreElements() && !bl) {
                    InetAddress inetAddress2 = (InetAddress)enumeration.nextElement();
                    if (!(inetAddress2 instanceof Inet4Address)) continue;
                    this.interfaceAddr = inetAddress2;
                    bl = true;
                }
            }
        } else {
            this.interfaceIdx = 0;
            this.interfaceAddr = null;
        }
        this.init();
    }

    private void init() {
        this.isIPV6Address = false;
        if (this.multiaddr != null && this.multiaddr instanceof Inet6Address) {
            this.isIPV6Address = true;
        }
    }
}

