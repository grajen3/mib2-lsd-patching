/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.InetAddress;
import java.net.InetAddress$CacheElement;

class InetAddress$Cache {
    static int maxSize = 5;
    private static int size = 0;
    private static InetAddress$CacheElement head;

    InetAddress$Cache() {
    }

    static void clear() {
        size = 0;
        head = null;
    }

    static void add(InetAddress inetAddress) {
        InetAddress$CacheElement inetAddress$CacheElement = inetAddress.cacheElement();
        if (size < maxSize) {
            ++size;
        } else {
            InetAddress$Cache.deleteTail();
        }
        inetAddress$CacheElement.next = head;
        head = inetAddress$CacheElement;
    }

    static InetAddress$CacheElement get(String string) {
        InetAddress$CacheElement inetAddress$CacheElement = null;
        InetAddress$CacheElement inetAddress$CacheElement2 = head;
        boolean bl = true;
        while (inetAddress$CacheElement2 != null && (bl = !string.equals(inetAddress$CacheElement2.hostName()))) {
            inetAddress$CacheElement = inetAddress$CacheElement2;
            inetAddress$CacheElement2 = inetAddress$CacheElement2.next;
        }
        if (bl) {
            return null;
        }
        InetAddress$Cache.moveToHead(inetAddress$CacheElement2, inetAddress$CacheElement);
        return inetAddress$CacheElement2;
    }

    private static void deleteTail() {
        if (size == 0) {
            return;
        }
        if (1 == size) {
            head = null;
        }
        InetAddress$CacheElement inetAddress$CacheElement = null;
        InetAddress$CacheElement inetAddress$CacheElement2 = head;
        while (inetAddress$CacheElement2.next != null) {
            inetAddress$CacheElement = inetAddress$CacheElement2;
            inetAddress$CacheElement2 = inetAddress$CacheElement2.next;
        }
        inetAddress$CacheElement.next = null;
    }

    private static void moveToHead(InetAddress$CacheElement inetAddress$CacheElement, InetAddress$CacheElement inetAddress$CacheElement2) {
        if (inetAddress$CacheElement2 == null) {
            head = inetAddress$CacheElement;
        } else {
            inetAddress$CacheElement2.next = inetAddress$CacheElement.next;
            inetAddress$CacheElement.next = head;
            head = inetAddress$CacheElement;
        }
    }
}

