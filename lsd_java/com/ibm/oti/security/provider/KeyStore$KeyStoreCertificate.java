/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.KeyStore;
import com.ibm.oti.security.provider.KeyStore$KeyStoreEntry;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.cert.Certificate;

public class KeyStore$KeyStoreCertificate
extends KeyStore$KeyStoreEntry {
    static final long serialVersionUID;
    Certificate cert;

    public KeyStore$KeyStoreCertificate(Certificate certificate) {
        this.cert = certificate;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        KeyStore.writeCertificate(this.cert, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.cert = KeyStore.readCertificate(objectInputStream);
    }
}

