/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;

public abstract class KeyFactorySpi {
    protected abstract PrivateKey engineGeneratePrivate(KeySpec keySpec) {
    }

    protected abstract PublicKey engineGeneratePublic(KeySpec keySpec) {
    }

    protected abstract KeySpec engineGetKeySpec(Key key, Class clazz) {
    }

    protected abstract Key engineTranslateKey(Key key) {
    }
}

