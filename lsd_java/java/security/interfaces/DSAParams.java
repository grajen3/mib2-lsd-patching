/*
 * Decompiled with CFR 0.152.
 */
package java.security.interfaces;

import java.math.BigInteger;

public interface DSAParams {
    default public BigInteger getP() {
    }

    default public BigInteger getQ() {
    }

    default public BigInteger getG() {
    }
}

