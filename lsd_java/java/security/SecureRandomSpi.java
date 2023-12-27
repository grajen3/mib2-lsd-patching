/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.Serializable;

public abstract class SecureRandomSpi
implements Serializable {
    protected abstract byte[] engineGenerateSeed(int n) {
    }

    protected abstract void engineNextBytes(byte[] byArray) {
    }

    protected abstract void engineSetSeed(byte[] byArray) {
    }
}

