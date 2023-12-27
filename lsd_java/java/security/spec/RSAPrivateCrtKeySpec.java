/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.math.BigInteger;
import java.security.spec.RSAPrivateKeySpec;

public class RSAPrivateCrtKeySpec
extends RSAPrivateKeySpec {
    private BigInteger pubExpE;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger dPCRT;
    private BigInteger dQCRT;
    private BigInteger qInvCRT;

    public RSAPrivateCrtKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(bigInteger, bigInteger3);
        this.pubExpE = bigInteger2;
        this.primeP = bigInteger4;
        this.primeQ = bigInteger5;
        this.dPCRT = bigInteger6;
        this.dQCRT = bigInteger7;
        this.qInvCRT = bigInteger8;
    }

    public BigInteger getPublicExponent() {
        return this.pubExpE;
    }

    public BigInteger getCrtCoefficient() {
        return this.qInvCRT;
    }

    public BigInteger getPrimeP() {
        return this.primeP;
    }

    public BigInteger getPrimeQ() {
        return this.primeQ;
    }

    public BigInteger getPrimeExponentP() {
        return this.dPCRT;
    }

    public BigInteger getPrimeExponentQ() {
        return this.dQCRT;
    }
}

