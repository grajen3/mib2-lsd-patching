/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

final class CacheKey {
    private final int mNamespace;
    private final long mKey;

    CacheKey(int n, long l) {
        this.mNamespace = n;
        this.mKey = l;
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
        CacheKey cacheKey = (CacheKey)object;
        if (this.mKey != cacheKey.mKey) {
            return false;
        }
        return this.mNamespace == cacheKey.mNamespace;
    }

    public long getKey() {
        return this.mKey;
    }

    public int getNamespace() {
        return this.mNamespace;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 31 + (int)(this.mKey ^ this.mKey >>> 32);
        n2 = 31 * n2 + this.mNamespace;
        return n2;
    }
}

