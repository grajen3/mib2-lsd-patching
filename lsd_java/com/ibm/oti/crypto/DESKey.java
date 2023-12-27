/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.j9.bluez.crypto.DES;
import com.ibm.oti.crypto.CL3BasedKey;
import com.ibm.oti.crypto.Provider;

public final class DESKey
extends CL3BasedKey {
    public static final int KEY_LENTH_BYTES;

    public DESKey(Provider provider, byte[] byArray) {
        super(provider, byArray);
        this.workingKey = DES.desKey(byArray, 0, byArray.length);
    }

    @Override
    public int getMinimumKeyLength() {
        return 8;
    }
}

