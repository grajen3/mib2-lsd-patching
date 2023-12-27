/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.algorithms;

public class Blake2s$Param {
    private int digestLength;
    public final byte[] salt;
    public final byte[] personal;

    public Blake2s$Param() {
        this.setDigestLength(32);
        this.salt = new byte[8];
        this.personal = new byte[8];
    }

    public void setDigestLength(int n) {
        if (n < 1 || n > 32) {
            throw new IllegalArgumentException(new StringBuffer().append("Length of digest out of bounds: ").append(n).toString());
        }
        this.digestLength = n;
    }

    public int getDigestLength() {
        return this.digestLength;
    }
}

