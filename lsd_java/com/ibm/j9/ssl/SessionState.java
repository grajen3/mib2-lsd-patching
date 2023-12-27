/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.CipherSpec;
import com.ibm.j9.ssl.SSLProtocol;
import com.ibm.oti.security.provider.X509CertImpl;
import java.util.Enumeration;
import java.util.Vector;

public class SessionState {
    private String host = null;
    private byte[] sessionID = null;
    private final long creationTime;
    private long lastAccessTime;
    private Vector peerCertificates = new Vector(0);
    private CipherSpec cipherSpec = CipherSpec.NULL_SPEC;
    private byte[] masterSecret = null;
    private boolean isResumable = true;
    private byte[] protocolVersion = SSLProtocol.SSL_PROTOCOL_VERSION;

    public SessionState(String string) {
        this.lastAccessTime = this.creationTime = System.currentTimeMillis();
        this.host = string;
    }

    public String getHostName() {
        return this.host;
    }

    public byte[] getSessionID() {
        return this.sessionID;
    }

    public byte[] getMasterSecret() {
        return this.masterSecret;
    }

    public byte[] getProtocolVersion() {
        return this.protocolVersion;
    }

    void setPeerCertificates(Vector vector) {
        this.peerCertificates = new Vector(vector.size());
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            this.peerCertificates.addElement(enumeration.nextElement());
        }
    }

    public X509CertImpl[] getPeerCertificates() {
        X509CertImpl[] x509CertImplArray = new X509CertImpl[this.peerCertificates.size()];
        Enumeration enumeration = this.peerCertificates.elements();
        int n = 0;
        while (enumeration.hasMoreElements()) {
            x509CertImplArray[n++] = (X509CertImpl)enumeration.nextElement();
        }
        return x509CertImplArray;
    }

    public X509CertImpl[] getLocalCertificates() {
        return null;
    }

    void serverHelloUpdate(byte[] byArray, CipherSpec cipherSpec, byte by, byte[] byArray2) {
        this.sessionID = byArray;
        this.cipherSpec = cipherSpec;
        this.protocolVersion = byArray2;
    }

    void setMasterSecret(byte[] byArray) {
        this.masterSecret = byArray;
    }

    void updateLastAccessTime(long l) {
        this.lastAccessTime = l;
    }

    public CipherSpec getCipherSpec() {
        return this.cipherSpec;
    }

    public long getCreationTime() {
        return this.creationTime;
    }

    public long getLastAccessTime() {
        return this.lastAccessTime;
    }

    public void invalidate() {
        this.isResumable = false;
    }

    public boolean isValid() {
        return this.isResumable;
    }
}

