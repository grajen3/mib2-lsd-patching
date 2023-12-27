/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.oti.crypto.Key;
import com.ibm.oti.crypto.Provider;

public class NullProvider
extends Provider {
    public NullProvider() {
        super(6, 0);
    }

    @Override
    void destroyKey(Key key) {
    }

    @Override
    void cryptInit(Key key, int n, int n2, byte[] byArray) {
    }

    @Override
    byte[] cryptUpdate(Key key, byte[] byArray, int n, int n2, boolean bl) {
        byte[] byArray2 = new byte[n2];
        System.arraycopy((Object)byArray, n, (Object)byArray2, 0, n2);
        return byArray2;
    }
}

