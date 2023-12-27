/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.InetAddress;

class InetAddress$CacheElement {
    long timeAdded = System.currentTimeMillis();
    InetAddress$CacheElement next;
    final /* synthetic */ InetAddress this$0;

    public InetAddress$CacheElement(InetAddress inetAddress) {
        this.this$0 = inetAddress;
    }

    String hostName() {
        return this.this$0.hostName;
    }

    InetAddress inetAddress() {
        return this.this$0;
    }
}

