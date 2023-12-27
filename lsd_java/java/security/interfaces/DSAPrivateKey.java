/*
 * Decompiled with CFR 0.152.
 */
package java.security.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.interfaces.DSAKey;

public interface DSAPrivateKey
extends DSAKey,
PrivateKey {
    public static final long serialVersionUID;

    default public BigInteger getX() {
    }
}

