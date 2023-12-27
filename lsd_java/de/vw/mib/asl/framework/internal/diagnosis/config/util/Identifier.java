/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.config.util;

public final class Identifier {
    private final int mNamespace;
    private final long mKey;

    public Identifier(int n, long l) {
        this.mNamespace = n;
        this.mKey = l;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (int)(this.mKey ^ this.mKey >>> 32);
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
        Identifier identifier = (Identifier)object;
        if (this.mKey != identifier.mKey) {
            return false;
        }
        return this.mNamespace == identifier.mNamespace;
    }
}

