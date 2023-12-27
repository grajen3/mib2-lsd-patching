/*
 * Decompiled with CFR 0.152.
 */
package java.security.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.interfaces.RSAKey;

public interface RSAPrivateKey
extends PrivateKey,
RSAKey {
    default public BigInteger getPrivateExponent() {
    }
}

