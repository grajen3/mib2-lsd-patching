/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket.ssl;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public interface ISSLCredentialProvider {
    default public void init() {
    }

    default public KeyManagerFactory getKeyManagerFactory() {
    }

    default public TrustManagerFactory getTrustManagerFactory() {
    }
}

