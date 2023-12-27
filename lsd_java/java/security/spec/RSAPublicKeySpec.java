/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class RSAPublicKeySpec
implements KeySpec {
    private BigInteger modulus;
    private BigInteger publicExponent;

    public RSAPublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.modulus = bigInteger;
        this.publicExponent = bigInteger2;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }
}

