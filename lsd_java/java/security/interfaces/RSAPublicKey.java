/*
 * Decompiled with CFR 0.152.
 */
package java.security.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;

public interface RSAPublicKey
extends PublicKey,
RSAKey {
    default public BigInteger getPublicExponent() {
    }
}

