/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

final class RequesterKey {
    private final int mNamespace;
    private final long mKey;
    private final byte mMode;

    RequesterKey(int n, long l, byte by) {
        this.mNamespace = n;
        this.mKey = l;
        this.mMode = by;
    }

    int getNamespace() {
        return this.mNamespace;
    }

    long getKey() {
        return this.mKey;
    }

    byte getMode() {
        return this.mMode;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 31 + (int)(this.mKey ^ this.mKey >>> 32);
        n2 = 31 * n2 + this.mNamespace;
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
        RequesterKey requesterKey = (RequesterKey)object;
        if (this.mKey != requesterKey.mKey) {
            return false;
        }
        if (this.mMode != requesterKey.mMode) {
            return false;
        }
        return this.mNamespace == requesterKey.mNamespace;
    }
}

