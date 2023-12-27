/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket.ssl;

import de.esolutions.fw.util.transport.socket.ssl.ISSLCredentialProvider;

public class CredentialProvider {
    private static ISSLCredentialProvider provider;

    private CredentialProvider() {
    }

    public static synchronized ISSLCredentialProvider getInstance() {
        return provider;
    }

    public static synchronized void setInstance(ISSLCredentialProvider iSSLCredentialProvider) {
        provider = iSSLCredentialProvider;
    }
}

