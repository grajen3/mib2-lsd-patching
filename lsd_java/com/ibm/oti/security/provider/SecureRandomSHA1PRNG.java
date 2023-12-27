/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.oti.util.SHAOutputStream;
import java.security.SecureRandomSpi;

public class SecureRandomSHA1PRNG
extends SecureRandomSpi {
    private static final int SHA_SIZE;
    private static final byte[] NO_SEED;
    private transient SHAOutputStream sha = new SHAOutputStream();
    private int count = 20;
    private byte[] state;

    static {
        NO_SEED = new byte[0];
    }

    @Override
    protected byte[] engineGenerateSeed(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        byte[] byArray = new byte[n];
        int n2 = 0;
        while (n2 < byArray.length) {
            byArray[n2] = (byte)CL3.trngNextByte();
            ++n2;
        }
        return byArray;
    }

    @Override
    protected void engineNextBytes(byte[] byArray) {
        if (this.state == null) {
            this.state = this.engineGenerateSeed(20);
        }
        int n = byArray.length;
        int n2 = 0;
        int n3 = 20 - this.count;
        while (n2 < n) {
            int n4;
            if (this.count >= this.state.length) {
                this.digestData(this.state);
                this.count = 0;
                n3 = 20;
            }
            if ((n4 = n - n2) > n3) {
                n4 = n3;
            }
            System.arraycopy((Object)this.state, this.count, (Object)byArray, n2, n4);
            n2 += n4;
            this.count += n4;
        }
    }

    @Override
    protected void engineSetSeed(byte[] byArray) {
        if (this.state != null) {
            this.sha.write(this.state, 0, this.state.length);
        }
        this.digestData(byArray);
        this.count = 20;
    }

    private void digestData(byte[] byArray) {
        this.sha.write(byArray, 0, byArray.length);
        this.state = this.sha.getHashAsBytes();
    }
}

