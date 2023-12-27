/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.spec.AlgorithmParameterSpec;

public abstract class AlgorithmParametersSpi {
    protected abstract byte[] engineGetEncoded() {
    }

    protected abstract byte[] engineGetEncoded(String string) {
    }

    protected abstract AlgorithmParameterSpec engineGetParameterSpec(Class clazz) {
    }

    protected abstract void engineInit(byte[] byArray) {
    }

    protected abstract void engineInit(byte[] byArray, String string) {
    }

    protected abstract void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
    }

    protected abstract String engineToString() {
    }
}

