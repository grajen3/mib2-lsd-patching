/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

class PersistableReader$CacheId {
    private final int hashCode;

    PersistableReader$CacheId(int n, int n2) {
        int n3 = 31;
        int n4 = 1;
        n4 = 31 * n4 + n;
        this.hashCode = n4 = 31 * n4 + n2;
    }

    public int hashCode() {
        return this.hashCode;
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
        PersistableReader$CacheId persistableReader$CacheId = (PersistableReader$CacheId)object;
        return persistableReader$CacheId.hashCode == this.hashCode;
    }
}

