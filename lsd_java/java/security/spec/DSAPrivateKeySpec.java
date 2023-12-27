/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class DSAPrivateKeySpec
implements KeySpec {
    private BigInteger p;
    private BigInteger q;
    private BigInteger g;
    private BigInteger x;

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public BigInteger getX() {
        return this.x;
    }

    public DSAPrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.x = bigInteger;
        this.p = bigInteger2;
        this.q = bigInteger3;
        this.g = bigInteger4;
    }
}

