/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.spec.AlgorithmParameterSpec;

public class DSAParameterSpec
implements AlgorithmParameterSpec,
DSAParams {
    private BigInteger p;
    private BigInteger q;
    private BigInteger g;

    @Override
    public BigInteger getG() {
        return this.g;
    }

    @Override
    public BigInteger getP() {
        return this.p;
    }

    @Override
    public BigInteger getQ() {
        return this.q;
    }

    public DSAParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.p = bigInteger;
        this.q = bigInteger2;
        this.g = bigInteger3;
    }
}

