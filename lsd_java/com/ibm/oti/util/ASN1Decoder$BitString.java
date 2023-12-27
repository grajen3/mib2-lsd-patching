/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

public class ASN1Decoder$BitString {
    public int unusedBits;
    public byte[] data;

    public ASN1Decoder$BitString(int n, byte[] byArray) {
        this.unusedBits = n;
        this.data = byArray;
    }

    public int bitLength() {
        return this.data.length * 8 - this.unusedBits;
    }

    public boolean bitAt(int n) {
        int n2 = n / 8;
        int n3 = this.data[n2] & 0xFF;
        int n4 = n % 8;
        return (n3 >>> 7 - n4 & 1) == 1;
    }
}

