/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.j9.bluez.crypto.AESCipher;
import com.ibm.j9.bluez.crypto.CL3Key;
import com.ibm.oti.crypto.AESKey;
import com.ibm.oti.crypto.CL3BasedProvider;
import com.ibm.oti.crypto.Key;
import com.ibm.oti.util.Msg;
import java.io.IOException;

public class AESProvider
extends CL3BasedProvider {
    private static final int AES_EFFECT_KEY_LENGTH_BITS;

    public AESProvider(int n) {
        super(5, n);
        if (n != 128) {
            throw new IOException(Msg.getString("K01f9"));
        }
    }

    @Override
    public Key createKey(byte[] byArray) {
        return new AESKey(this, byArray);
    }

    @Override
    void cl3Call(CL3Key cL3Key, int n, byte[] byArray, int n2, byte[] byArray2, int n3, byte[] byArray3, int n4, int n5) {
        AESCipher.aes(cL3Key, n, byArray, n2, byArray2, n3, byArray3, n4, n5);
    }
}

