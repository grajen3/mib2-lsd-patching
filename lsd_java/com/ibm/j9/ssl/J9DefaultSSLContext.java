/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.j9.ssl.J9SSLContext;
import com.ibm.j9.ssl.J9SSLSessionContext;
import com.ibm.j9.ssl.SessionState;
import com.ibm.oti.security.provider.CertificateVerifierSecurity;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

public class J9DefaultSSLContext
implements J9SSLContext {
    private J9SSLSessionContext sessionTable = new J9SSLSessionContext();
    private boolean sessionCreationEnabled = true;

    @Override
    public void getRandomBytes(byte[] byArray) {
        CL3.rng(null, byArray, 0, byArray.length);
    }

    @Override
    public void verifyCertificateChain(X509Certificate[] x509CertificateArray) {
        try {
            CertificateVerifierSecurity.verifyCertificateChain(x509CertificateArray, new Date());
        }
        catch (IOException iOException) {
            throw new CertificateException(iOException.getMessage());
        }
    }

    @Override
    public void addSession(SessionState sessionState) {
        this.sessionTable.addSession(sessionState);
    }

    @Override
    public SessionState getSession(String string) {
        return this.sessionTable.getSession(string);
    }

    @Override
    public void removeSession(SessionState sessionState) {
        this.sessionTable.removeSession(sessionState);
    }

    @Override
    public J9SSLSessionContext getSessionContext() {
        return this.sessionTable;
    }

    @Override
    public boolean getSessionCreationEnabled() {
        return this.sessionCreationEnabled;
    }

    @Override
    public void setEnableSessionCreation(boolean bl) {
        this.sessionCreationEnabled = bl;
    }

    @Override
    public PrivateKey getPrivateKey(String string) {
        throw new UnsupportedOperationException(Msg.getString("K03ab"));
    }

    @Override
    public X509Certificate[] getClientCertificateChain(String string) {
        throw new UnsupportedOperationException(Msg.getString("K03ab"));
    }

    @Override
    public String getClientAlias(String[] stringArray, Principal[] principalArray) {
        throw new UnsupportedOperationException(Msg.getString("K03ab"));
    }
}

