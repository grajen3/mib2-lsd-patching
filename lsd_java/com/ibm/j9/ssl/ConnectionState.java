/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.CipherAlgorithm;
import com.ibm.j9.ssl.HashingAlgorithm;
import com.ibm.j9.ssl.HashingAlgorithmMD5;
import com.ibm.j9.ssl.HashingAlgorithmSHA1;
import com.ibm.j9.ssl.SessionState;
import com.ibm.j9.ssl.TLSProtocol;
import com.ibm.j9.ssl.Util;

public class ConnectionState {
    private SessionState session;
    private CipherAlgorithm cipherAlgorithm;
    private HashingAlgorithm hashingAlgorithm;
    public byte[] serverRandom;
    public byte[] clientRandom;
    public byte[] clientWriteMACSecret;
    public byte[] serverWriteMACSecret;
    public byte[] clientWriteKey;
    public byte[] serverWriteKey;
    public byte[] clientWriteIV;
    public byte[] serverWriteIV;
    public int receiveSequenceNumber = 0;
    public int transmitSequenceNumber = 0;

    public SessionState getSessionState() {
        return this.session;
    }

    public void setSessionState(SessionState sessionState) {
        this.session = sessionState;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        if (this.session == null) {
            return null;
        }
        if (this.cipherAlgorithm == null) {
            this.cipherAlgorithm = this.session.getCipherSpec().newCipherAlgorithm();
            if (this.cipherAlgorithm != null) {
                this.cipherAlgorithm.setConnectionState(this);
            }
        }
        return this.cipherAlgorithm;
    }

    public HashingAlgorithm getHashingAlgorithm() {
        if (this.session == null) {
            return null;
        }
        if (this.hashingAlgorithm == null) {
            this.hashingAlgorithm = this.session.getCipherSpec().getHashingAlgorithm();
        }
        return this.hashingAlgorithm;
    }

    public void generateConnectionKeys() {
        byte[] byArray = this.generateKeyBlock(this.session.getMasterSecret());
        int n = 0;
        this.clientWriteMACSecret = new byte[this.getHashingAlgorithm().getHashSize()];
        System.arraycopy((Object)byArray, n, (Object)this.clientWriteMACSecret, 0, this.clientWriteMACSecret.length);
        this.serverWriteMACSecret = new byte[this.getHashingAlgorithm().getHashSize()];
        System.arraycopy((Object)byArray, n += this.clientWriteMACSecret.length, (Object)this.serverWriteMACSecret, 0, this.serverWriteMACSecret.length);
        this.clientWriteKey = new byte[this.session.getCipherSpec().keyMaterialLength];
        System.arraycopy((Object)byArray, n += this.serverWriteMACSecret.length, (Object)this.clientWriteKey, 0, this.clientWriteKey.length);
        this.serverWriteKey = new byte[this.session.getCipherSpec().keyMaterialLength];
        System.arraycopy((Object)byArray, n += this.clientWriteKey.length, (Object)this.serverWriteKey, 0, this.serverWriteKey.length);
        n += this.serverWriteKey.length;
        this.clientWriteIV = new byte[this.getCipherAlgorithm().getIVSize()];
        this.serverWriteIV = new byte[this.getCipherAlgorithm().getIVSize()];
        if (this.session.getCipherSpec().isExportable) {
            this.applyExportControl();
        } else {
            System.arraycopy((Object)byArray, n, (Object)this.clientWriteIV, 0, this.clientWriteIV.length);
            System.arraycopy((Object)byArray, n += this.clientWriteIV.length, (Object)this.serverWriteIV, 0, this.serverWriteIV.length);
            n += this.serverWriteIV.length;
        }
    }

    private void applyExportControl() {
        if (this.isTLS()) {
            this.applyTLSExportControl();
        } else {
            this.applySSLExportControl();
        }
    }

    private void applySSLExportControl() {
        byte[] byArray = HashingAlgorithmMD5.hashMD5(Util.concatenate(this.clientWriteKey, this.clientRandom, this.serverRandom));
        this.clientWriteKey = new byte[this.getCipherAlgorithm().getKeyMaterialSize()];
        System.arraycopy((Object)byArray, 0, (Object)this.clientWriteKey, 0, this.clientWriteKey.length);
        byte[] byArray2 = HashingAlgorithmMD5.hashMD5(Util.concatenate(this.serverWriteKey, this.serverRandom, this.clientRandom));
        this.serverWriteKey = new byte[this.getCipherAlgorithm().getKeyMaterialSize()];
        System.arraycopy((Object)byArray2, 0, (Object)this.serverWriteKey, 0, this.serverWriteKey.length);
        byte[] byArray3 = HashingAlgorithmMD5.hashMD5(Util.concatenate(this.clientRandom, this.serverRandom));
        System.arraycopy((Object)byArray3, 0, (Object)this.clientWriteIV, 0, this.clientWriteIV.length);
        byte[] byArray4 = HashingAlgorithmMD5.hashMD5(Util.concatenate(this.serverRandom, this.clientRandom));
        System.arraycopy((Object)byArray4, 0, (Object)this.serverWriteIV, 0, this.serverWriteIV.length);
    }

    private void applyTLSExportControl() {
        byte[] byArray = Util.concatenate(this.clientRandom, this.serverRandom);
        byte[] byArray2 = TLSProtocol.PRF(this.clientWriteKey, "client write key", byArray, this.getCipherAlgorithm().getKeyMaterialSize());
        this.clientWriteKey = new byte[this.getCipherAlgorithm().getKeyMaterialSize()];
        System.arraycopy((Object)byArray2, 0, (Object)this.clientWriteKey, 0, this.clientWriteKey.length);
        byte[] byArray3 = TLSProtocol.PRF(this.serverWriteKey, "server write key", byArray, this.getCipherAlgorithm().getKeyMaterialSize());
        this.serverWriteKey = new byte[this.getCipherAlgorithm().getKeyMaterialSize()];
        System.arraycopy((Object)byArray3, 0, (Object)this.serverWriteKey, 0, this.serverWriteKey.length);
        byte[] byArray4 = TLSProtocol.PRF(new byte[0], "IV block", byArray, this.clientWriteIV.length + this.serverWriteIV.length);
        System.arraycopy((Object)byArray4, 0, (Object)this.clientWriteIV, 0, this.clientWriteIV.length);
        System.arraycopy((Object)byArray4, this.clientWriteIV.length, (Object)this.serverWriteIV, 0, this.serverWriteIV.length);
    }

    private byte[] generateKeyBlock(byte[] byArray) {
        int n = 2 * this.getHashingAlgorithm().getHashSize() + 2 * this.session.getCipherSpec().keyMaterialLength;
        if (!this.session.getCipherSpec().isExportable && this.getCipherAlgorithm().getIVSize() > 0) {
            n += 2 * this.getCipherAlgorithm().getIVSize();
        }
        if (this.isTLS()) {
            return this.generateTLSKeyBlock(byArray, n);
        }
        return this.generateSSLKeyBlock(byArray, n);
    }

    private byte[] generateSSLKeyBlock(byte[] byArray, int n) {
        byte[] byArray2 = new byte[]{};
        int n2 = 1;
        while (byArray2.length < n) {
            byArray2 = Util.concatenate(byArray2, this.generateKeyBlockSegment(byArray, n2++));
        }
        return byArray2;
    }

    private byte[] generateTLSKeyBlock(byte[] byArray, int n) {
        byte[] byArray2 = Util.concatenate(this.serverRandom, this.clientRandom);
        return TLSProtocol.PRF(byArray, "key expansion", byArray2, n);
    }

    public boolean isTLS() {
        return Util.equals(TLSProtocol.TLS_PROTOCOL_VERSION, this.getSessionState().getProtocolVersion());
    }

    public int getPadType() {
        if (this.isTLS()) {
            return 4;
        }
        return 3;
    }

    private byte[] generateKeyBlockSegment(byte[] byArray, int n) {
        byte[] byArray2 = new byte[n];
        int n2 = 0;
        while (n2 < n) {
            byArray2[n2] = (byte)(65 + (n - 1));
            ++n2;
        }
        return HashingAlgorithmMD5.hashMD5(Util.concatenate(byArray, HashingAlgorithmSHA1.hashSHA1(Util.concatenate(byArray2, byArray, this.serverRandom, this.clientRandom))));
    }
}

