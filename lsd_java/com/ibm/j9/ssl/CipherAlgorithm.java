/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.ConnectionState;
import com.ibm.j9.ssl.HashingAlgorithm;
import com.ibm.j9.ssl.Util;
import com.ibm.oti.crypto.Key;
import com.ibm.oti.crypto.Provider;
import com.ibm.oti.util.Msg;
import java.io.IOException;

public class CipherAlgorithm {
    public static final int CIPHER_TYPE_STREAM;
    public static final int CIPHER_TYPE_BLOCK;
    protected ConnectionState state;
    Provider provider;
    Key clientWriteKey = null;
    Key serverWriteKey = null;

    public CipherAlgorithm(Provider provider) {
        this.provider = provider;
    }

    public void setConnectionState(ConnectionState connectionState) {
        this.state = connectionState;
    }

    public int getKeyMaterialSize() {
        return this.provider.getKeyLength();
    }

    public int getBlockSize() {
        return this.provider.getBlockLength();
    }

    public int getIVSize() {
        return this.provider.getIVLength();
    }

    protected int getCipherType() {
        if (this.provider.getIVLength() > 0) {
            return 2;
        }
        return 1;
    }

    private byte[] computeMACHash(byte[] byArray, byte by, int n, byte[] byArray2) {
        if (this.state.isTLS()) {
            return this.computeTLSMACHash(byArray, by, n, byArray2);
        }
        return this.computeSSLMACHash(byArray, by, n, byArray2);
    }

    private byte[] computeTLSMACHash(byte[] byArray, byte by, int n, byte[] byArray2) {
        HashingAlgorithm hashingAlgorithm = this.state.getHashingAlgorithm();
        if (hashingAlgorithm == null || hashingAlgorithm.getHashSize() == 0) {
            return new byte[0];
        }
        byte[] byArray3 = Util.concatenate(Util.getBytes(n, 8), Util.getBytes(by, 1), this.state.getSessionState().getProtocolVersion(), Util.getBytes(byArray.length, 2), byArray);
        return hashingAlgorithm.hashTLS(byArray2, byArray3);
    }

    private byte[] computeSSLMACHash(byte[] byArray, byte by, int n, byte[] byArray2) {
        HashingAlgorithm hashingAlgorithm = this.state.getHashingAlgorithm();
        byte[] byArray3 = hashingAlgorithm.getPad1();
        byte[] byArray4 = hashingAlgorithm.getPad2();
        if (hashingAlgorithm == null || hashingAlgorithm.getHashSize() == 0) {
            return new byte[0];
        }
        byte[] byArray5 = Util.concatenate(byArray2, byArray3, Util.getBytes(n, 8), Util.getBytes(by, 1), Util.getBytes(byArray.length, 2), byArray);
        byte[] byArray6 = hashingAlgorithm.hashSSL(byArray5);
        byte[] byArray7 = Util.concatenate(byArray2, byArray4, byArray6);
        return hashingAlgorithm.hashSSL(byArray7);
    }

    private boolean isValidMACHash(byte[] byArray, byte[] byArray2, byte by) {
        byte[] byArray3 = this.computeMACHash(byArray2, by, this.state.receiveSequenceNumber, this.state.serverWriteMACSecret);
        return Util.equals(byArray, byArray3);
    }

    public byte[] decipher(byte[] byArray, byte by, int n) {
        if (this.serverWriteKey == null) {
            this.serverWriteKey = this.provider.createKey(this.state.serverWriteKey);
        }
        this.serverWriteKey.cryptInit(2, n, this.state.serverWriteIV);
        this.serverWriteKey.cryptUpdate(byArray, 0, byArray.length);
        byte[] byArray2 = this.serverWriteKey.cryptFinish();
        byte[] byArray3 = new byte[this.state.getHashingAlgorithm().getHashSize()];
        System.arraycopy((Object)byArray2, byArray2.length - byArray3.length, (Object)byArray3, 0, byArray3.length);
        byte[] byArray4 = new byte[byArray2.length - byArray3.length];
        System.arraycopy((Object)byArray2, 0, (Object)byArray4, 0, byArray4.length);
        if (byArray3.length > 0 && !this.isValidMACHash(byArray3, byArray4, by)) {
            throw new IOException(Msg.getString("K01d3"));
        }
        System.arraycopy((Object)byArray, byArray.length - this.state.serverWriteIV.length, (Object)this.state.serverWriteIV, 0, this.state.serverWriteIV.length);
        return byArray4;
    }

    public byte[] encipher(byte[] byArray, byte by, int n) {
        byte[] byArray2 = this.computeMACHash(byArray, by, this.state.transmitSequenceNumber, this.state.clientWriteMACSecret);
        byte[] byArray3 = Util.concatenate(byArray, byArray2);
        if (this.clientWriteKey == null) {
            this.clientWriteKey = this.provider.createKey(this.state.clientWriteKey);
        }
        this.clientWriteKey.cryptInit(1, n, this.state.clientWriteIV);
        this.clientWriteKey.cryptUpdate(byArray3, 0, byArray3.length);
        byte[] byArray4 = this.clientWriteKey.cryptFinish();
        System.arraycopy((Object)byArray4, byArray4.length - this.state.clientWriteIV.length, (Object)this.state.clientWriteIV, 0, this.state.clientWriteIV.length);
        return byArray4;
    }
}

