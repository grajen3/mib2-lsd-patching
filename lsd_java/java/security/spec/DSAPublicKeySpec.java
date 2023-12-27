/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class DSAPublicKeySpec
implements KeySpec {
    private BigInteger p;
    private BigInteger q;
    private BigInteger g;
    private BigInteger y;

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public BigInteger getY() {
        return this.y;
    }

    public DSAPublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.y = bigInteger;
        this.p = bigInteger2;
        this.q = bigInteger3;
        this.g = bigInteger4;
    }
}

