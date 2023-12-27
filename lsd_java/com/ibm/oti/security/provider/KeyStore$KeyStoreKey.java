/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.KeyStore;
import com.ibm.oti.security.provider.KeyStore$KeyStoreEntry;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.cert.Certificate;

public class KeyStore$KeyStoreKey
extends KeyStore$KeyStoreEntry {
    static final long serialVersionUID;
    protected Object key;
    protected Certificate[] chain;
    byte[] digest;

    protected KeyStore$KeyStoreKey() {
    }

    protected KeyStore$KeyStoreKey(byte[] byArray) {
        this(byArray, null);
    }

    protected KeyStore$KeyStoreKey(Key key) {
        this(key, null);
    }

    protected KeyStore$KeyStoreKey(Object object, Certificate[] certificateArray) {
        this.key = object;
        this.chain = certificateArray;
    }

    public Object getKey() {
        return this.key;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.key);
        objectOutputStream.writeObject(this.digest);
        if (this.chain == null) {
            objectOutputStream.writeObject(this.chain);
        } else {
            objectOutputStream.writeObject(new Integer(this.chain.length));
            int n = 0;
            while (n < this.chain.length) {
                KeyStore.writeCertificate(this.chain[n], objectOutputStream);
                ++n;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.key = objectInputStream.readObject();
        this.digest = (byte[])objectInputStream.readObject();
        Object object = objectInputStream.readObject();
        if (object != null) {
            Integer n = (Integer)object;
            this.chain = new Certificate[n.intValue()];
            int n2 = 0;
            while (n2 < n) {
                this.chain[n2] = KeyStore.readCertificate(objectInputStream);
                ++n2;
            }
        }
    }
}

