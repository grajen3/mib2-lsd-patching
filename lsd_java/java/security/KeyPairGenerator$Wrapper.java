/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyPairGeneratorSpi;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

class KeyPairGenerator$Wrapper
extends KeyPairGenerator {
    KeyPairGeneratorSpi keyPairGeneratorProvider;

    KeyPairGenerator$Wrapper(KeyPairGeneratorSpi keyPairGeneratorSpi, String string) {
        super(string);
        this.keyPairGeneratorProvider = keyPairGeneratorSpi;
    }

    @Override
    public KeyPair generateKeyPair() {
        return this.keyPairGeneratorProvider.generateKeyPair();
    }

    @Override
    public void initialize(int n, SecureRandom secureRandom) {
        this.keyPairGeneratorProvider.initialize(n, secureRandom);
    }

    @Override
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.keyPairGeneratorProvider.initialize(algorithmParameterSpec, secureRandom);
    }
}

