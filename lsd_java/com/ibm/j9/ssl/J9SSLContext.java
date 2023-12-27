/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.J9SSLSessionContext;
import com.ibm.j9.ssl.SessionState;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public interface J9SSLContext {
    default public void getRandomBytes(byte[] byArray) {
    }

    default public void verifyCertificateChain(X509Certificate[] x509CertificateArray) {
    }

    default public void setEnableSessionCreation(boolean bl) {
    }

    default public boolean getSessionCreationEnabled() {
    }

    default public void addSession(SessionState sessionState) {
    }

    default public void removeSession(SessionState sessionState) {
    }

    default public SessionState getSession(String string) {
    }

    default public J9SSLSessionContext getSessionContext() {
    }

    default public String getClientAlias(String[] stringArray, Principal[] principalArray) {
    }

    default public PrivateKey getPrivateKey(String string) {
    }

    default public X509Certificate[] getClientCertificateChain(String string) {
    }
}

