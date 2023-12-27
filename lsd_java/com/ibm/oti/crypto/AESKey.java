/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.j9.bluez.crypto.AESCipher;
import com.ibm.oti.crypto.CL3BasedKey;
import com.ibm.oti.crypto.Provider;

public final class AESKey
extends CL3BasedKey {
    public static final int KEY_LENGTH_BYTES;

    public AESKey(Provider provider, byte[] byArray) {
        super(provider, byArray);
        this.workingKey = AESCipher.aesKey(byArray, 0, byArray.length, 16);
    }

    @Override
    public int getMinimumKeyLength() {
        return 16;
    }
}

