/*
 * Decompiled with CFR 0.152.
 */
package java.net;

class NegCacheElement {
    long timeAdded = System.currentTimeMillis();
    String hostName;

    public NegCacheElement() {
    }

    public NegCacheElement(String string) {
        this.hostName = string;
    }

    String hostName() {
        return this.hostName;
    }
}

