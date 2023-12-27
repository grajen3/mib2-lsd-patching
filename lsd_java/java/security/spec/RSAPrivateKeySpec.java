/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class RSAPrivateKeySpec
implements KeySpec {
    private BigInteger modulus;
    private BigInteger privateExponent;

    public RSAPrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.modulus = bigInteger;
        this.privateExponent = bigInteger2;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }
}

