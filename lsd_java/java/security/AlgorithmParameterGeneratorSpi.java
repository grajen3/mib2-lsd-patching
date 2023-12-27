/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public abstract class AlgorithmParameterGeneratorSpi {
    protected abstract AlgorithmParameters engineGenerateParameters() {
    }

    protected abstract void engineInit(int n, SecureRandom secureRandom) {
    }

    protected abstract void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
    }
}

