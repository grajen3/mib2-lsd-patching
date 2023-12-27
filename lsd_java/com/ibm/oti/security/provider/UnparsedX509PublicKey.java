/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import java.security.PublicKey;

public class UnparsedX509PublicKey
implements PublicKey {
    private byte[] encodedKeySpec;
    String algorithm;

    public UnparsedX509PublicKey(byte[] byArray) {
        this.encodedKeySpec = byArray;
    }

    @Override
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override
    public byte[] getEncoded() {
        return (byte[])this.encodedKeySpec.clone();
    }

    @Override
    public String getFormat() {
        return "X.509";
    }

    public void setAlgorithm(String string) {
        this.algorithm = string;
    }
}

