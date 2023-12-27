/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.oti.security.provider.SignatureRSA;

public class SignatureMD2withRSA
extends SignatureRSA {
    private static final int MD2_HASH_LEN_BYTES;
    private byte[] resultBuffer = new byte[16];
    private CL3 hash = CL3.md2Init(null);

    public SignatureMD2withRSA() {
        super("MD2");
    }

    @Override
    protected void resetHash() {
        this.hash = CL3.md2Init(null);
        this.resultBuffer = new byte[16];
    }

    @Override
    protected void updateHash(byte[] byArray, int n, int n2) {
        CL3.md2(this.hash, byArray, n, n2, this.resultBuffer, 0);
    }

    @Override
    protected void updateHash(byte by) {
        byte[] byArray = new byte[]{by};
        CL3.md2(this.hash, byArray, 0, 1, this.resultBuffer, 0);
    }

    @Override
    protected byte[] getHash() {
        return this.resultBuffer;
    }
}

