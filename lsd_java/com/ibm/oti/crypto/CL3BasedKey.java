/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.j9.bluez.crypto.CL3Key;
import com.ibm.oti.crypto.Key;
import com.ibm.oti.crypto.Provider;
import com.ibm.oti.util.Msg;
import java.io.IOException;

public abstract class CL3BasedKey
extends Key {
    CL3Key workingKey;

    CL3BasedKey(Provider provider, byte[] byArray) {
        super(provider, byArray);
        if (byArray.length != this.getMinimumKeyLength()) {
            throw new IOException(Msg.getString("K01f9"));
        }
    }

    public abstract int getMinimumKeyLength() {
    }
}

