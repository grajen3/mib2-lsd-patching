/*
 * Decompiled with CFR 0.152.
 */
package java.security.interfaces;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;

public interface RSAPrivateCrtKey
extends RSAPrivateKey {
    default public BigInteger getPublicExponent() {
    }

    default public BigInteger getPrimeP() {
    }

    default public BigInteger getPrimeQ() {
    }

    default public BigInteger getPrimeExponentP() {
    }

    default public BigInteger getPrimeExponentQ() {
    }

    default public BigInteger getCrtCoefficient() {
    }
}

