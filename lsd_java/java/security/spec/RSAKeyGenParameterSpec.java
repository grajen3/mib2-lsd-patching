/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class RSAKeyGenParameterSpec
implements AlgorithmParameterSpec {
    public static final BigInteger F0 = new BigInteger("3");
    public static final BigInteger F4 = new BigInteger("65537");
    private int keysize;
    private BigInteger publicExponent;

    public RSAKeyGenParameterSpec(int n, BigInteger bigInteger) {
        this.keysize = n;
        this.publicExponent = bigInteger;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int getKeysize() {
        return this.keysize;
    }
}

