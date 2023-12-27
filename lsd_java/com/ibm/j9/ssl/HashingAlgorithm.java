/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

public abstract class HashingAlgorithm {
    public abstract int getHashSize() {
    }

    public abstract byte[] hashSSL(byte[] byArray) {
    }

    public abstract byte[] hashTLS(byte[] byArray, byte[] byArray2) {
    }

    public abstract byte[] getPad1() {
    }

    public abstract byte[] getPad2() {
    }
}

