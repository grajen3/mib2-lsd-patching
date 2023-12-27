/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.j9.bluez.crypto.CL3Key;
import com.ibm.j9.bluez.crypto.DES;
import com.ibm.oti.crypto.CL3BasedProvider;
import com.ibm.oti.crypto.DESKey;
import com.ibm.oti.crypto.Key;
import com.ibm.oti.util.Msg;
import java.io.IOException;

public final class DESProvider
extends CL3BasedProvider {
    private final int DES_EFFECT_KEY_LENGTH_BITS;

    public DESProvider(int n) {
        super(1, n);
        this.DES_EFFECT_KEY_LENGTH_BITS = 56;
        if (n != 56) {
            throw new IOException(Msg.getString("K01f9"));
        }
    }

    @Override
    public Key createKey(byte[] byArray) {
        return new DESKey(this, byArray);
    }

    @Override
    void cl3Call(CL3Key cL3Key, int n, byte[] byArray, int n2, byte[] byArray2, int n3, byte[] byArray3, int n4, int n5) {
        DES.des(cL3Key, n, byArray, n2, byArray2, n3, byArray3, n4, n5);
    }
}

