/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.KeyStore;
import java.io.ObjectInputStream;
import java.security.PrivilegedAction;

final class KeyStore$1
implements PrivilegedAction {
    final /* synthetic */ KeyStore this$0;
    private final /* synthetic */ ObjectInputStream val$stream;

    KeyStore$1(KeyStore keyStore, ObjectInputStream objectInputStream) {
        this.this$0 = keyStore;
        this.val$stream = objectInputStream;
    }

    @Override
    public Object run() {
        try {
            return this.val$stream.readObject();
        }
        catch (Exception exception) {
            return null;
        }
    }
}

