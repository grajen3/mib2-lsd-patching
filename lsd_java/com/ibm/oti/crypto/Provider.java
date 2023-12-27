/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.oti.crypto.AESProvider;
import com.ibm.oti.crypto.DESProvider;
import com.ibm.oti.crypto.Key;
import com.ibm.oti.crypto.NullProvider;
import com.ibm.oti.crypto.TripleDESProvider;
import java.io.IOException;

public abstract class Provider {
    public static final int ALG_DES;
    public static final int ALG_3DES;
    public static final int ALG_RC2;
    public static final int ALG_RC4;
    public static final int ALG_AES;
    public static final int ALG_NULL;
    protected int algorithm;
    protected int effectiveKeyBitLength;
    protected boolean isDestroyed = false;

    public static Provider getProvider(int n, int n2) {
        switch (n) {
            case 1: {
                return new DESProvider(n2);
            }
            case 2: {
                return new TripleDESProvider(n2);
            }
            case 5: {
                return new AESProvider(n2);
            }
            case 6: {
                return new NullProvider();
            }
        }
        throw new IOException();
    }

    protected Provider(int n, int n2) {
        this.algorithm = n;
        this.effectiveKeyBitLength = n2;
    }

    public int getAlgorithm() {
        return this.algorithm;
    }

    public final int getBlockLength() {
        switch (this.algorithm) {
            case 1: 
            case 2: 
            case 3: {
                return 8;
            }
            case 4: {
                return 0;
            }
            case 5: {
                return 16;
            }
        }
        return 0;
    }

    public int getEffectiveKeyBitLength() {
        return this.effectiveKeyBitLength;
    }

    public final int getKeyLength() {
        switch (this.algorithm) {
            case 1: {
                return 8;
            }
            case 2: {
                return 24;
            }
            case 3: 
            case 4: 
            case 5: {
                return 16;
            }
            case 6: {
                return 0;
            }
        }
        return -1;
    }

    public final int getIVLength() {
        switch (this.algorithm) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return this.getBlockLength();
            }
        }
        return -1;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public Key createKey(byte[] byArray) {
        return new Key(this, byArray);
    }

    public void destroy() {
        if (!this.isDestroyed) {
            this.isDestroyed = true;
        }
    }

    abstract void destroyKey(Key key) {
    }

    abstract void cryptInit(Key key, int n, int n2, byte[] byArray) {
    }

    abstract byte[] cryptUpdate(Key key, byte[] byArray, int n, int n2, boolean bl) {
    }
}

