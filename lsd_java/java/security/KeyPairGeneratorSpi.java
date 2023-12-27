/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public abstract class KeyPairGeneratorSpi {
    public abstract KeyPair generateKeyPair() {
    }

    public abstract void initialize(int n, SecureRandom secureRandom) {
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        throw new UnsupportedOperationException();
    }
}

