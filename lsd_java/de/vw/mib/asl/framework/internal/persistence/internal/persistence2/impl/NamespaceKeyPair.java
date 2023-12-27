/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

public class NamespaceKeyPair {
    private final int namespace;
    private final long key;

    public NamespaceKeyPair(int n, long l) {
        this.namespace = n;
        this.key = l;
    }

    public int getNamespace() {
        return this.namespace;
    }

    public long getKey() {
        return this.key;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (int)(this.key ^ this.key >>> 32);
        n2 = 31 * n2 + this.namespace;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        NamespaceKeyPair namespaceKeyPair = (NamespaceKeyPair)object;
        if (this.key != namespaceKeyPair.key) {
            return false;
        }
        return this.namespace == namespaceKeyPair.namespace;
    }
}

