/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.CipherSpec;
import com.ibm.j9.ssl.ClientHello;
import com.ibm.j9.ssl.ClientKeyExchange;
import com.ibm.j9.ssl.ConnectionState;
import com.ibm.j9.ssl.HandshakeMessage;
import com.ibm.j9.ssl.HandshakeSocket;
import com.ibm.j9.ssl.HashingAlgorithmMD5;
import com.ibm.j9.ssl.HashingAlgorithmSHA1;
import com.ibm.j9.ssl.J9DefaultSSLContext;
import com.ibm.j9.ssl.J9HandshakeException;
import com.ibm.j9.ssl.J9ProtocolException;
import com.ibm.j9.ssl.J9SSLContext;
import com.ibm.j9.ssl.SessionState;
import com.ibm.j9.ssl.StreamQueue;
import com.ibm.j9.ssl.TLSProtocol;
import com.ibm.j9.ssl.Util;
import com.ibm.oti.security.provider.MD5OutputStream;
import com.ibm.oti.security.provider.PKCS1;
import com.ibm.oti.security.provider.RSAPrivateKey;
import com.ibm.oti.security.provider.RSAPublicKey;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509CertImpl;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.SHAOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Vector;

public class HandshakeHandler {
    private HandshakeSocket socket;
    private J9SSLContext context;
    private StreamQueue outputQueue = new StreamQueue();
    private StreamQueue inputQueue = new StreamQueue();
    private boolean isHandshaking = false;
    private boolean shouldHandshake = true;
    private byte[] pre_master_secret = null;
    private RSAPublicKey tempKey = null;
    private boolean resumeSession = false;
    private SHAOutputStream shaMessageHash = new SHAOutputStream(new byte[]{103, 69, 35, 1, -17, -51, -85, -119, -104, -70, -36, -2, 16, 50, 84, 118, -61, -46, -31, -16});
    private MD5OutputStream md5MessageHash = new MD5OutputStream(new byte[]{103, 69, 35, 1, -17, -51, -85, -119, -104, -70, -36, -2, 16, 50, 84, 118});
    private SessionState pendingSession;
    private ConnectionState pendingConnection;
    private boolean clientCertificateRequested = false;
    private String clientAlias = null;

    public HandshakeHandler(HandshakeSocket handshakeSocket) {
        this.socket = handshakeSocket;
        this.context = new J9DefaultSSLContext();
    }

    public HandshakeHandler(HandshakeSocket handshakeSocket, J9SSLContext j9SSLContext) {
        this.socket = handshakeSocket;
        this.context = j9SSLContext;
    }

    public boolean shouldHandshake() {
        return this.shouldHandshake;
    }

    public synchronized void run() {
        this.beginHandshakeSequence();
        long l = this.socket.getTimeoutLength();
        l = l < 1L ? -1L : (l += System.currentTimeMillis());
        boolean bl = true;
        while (bl && this.isHandshaking) {
            bl = this.socket.readData();
            this.processQueuedMessages();
            if (l == -1L || System.currentTimeMillis() <= l) continue;
            throw new J9HandshakeException(Msg.getString("K01ee"));
        }
        this.endHandshakeSequence();
    }

    public void notifyReceived(byte[] byArray) {
        try {
            this.inputQueue.getWriteStream().write(byArray);
        }
        catch (IOException iOException) {}
    }

    private void beginHandshakeSequence() {
        this.isHandshaking = true;
        this.pendingSession = this.context.getSession(this.socket.getHostName());
        if (this.pendingSession == null || this.pendingSession.getSessionID() == null || this.pendingSession.getSessionID().length == 0) {
            if (!this.context.getSessionCreationEnabled()) {
                throw new J9HandshakeException(Msg.getString("K03b1"));
            }
            this.pendingSession = new SessionState(this.socket.getHostName());
        } else {
            this.resumeSession = true;
            this.pendingSession.updateLastAccessTime(System.currentTimeMillis());
        }
        this.pendingConnection = new ConnectionState();
        this.pendingConnection.setSessionState(this.pendingSession);
        this.shaMessageHash.reset();
        this.md5MessageHash.reset();
        byte[] byArray = Util.getBytes(System.currentTimeMillis() / 0, 4);
        byte[] byArray2 = new byte[28];
        this.context.getRandomBytes(byArray2);
        this.pendingConnection.clientRandom = Util.concatenate(byArray, byArray2);
        this.socket.setSessionState(this.pendingSession);
        this.sendMessage((byte)1);
        this.flushMessages();
    }

    private void endHandshakeSequence() {
        this.isHandshaking = false;
        this.shouldHandshake = false;
        this.context.addSession(this.pendingSession);
    }

    private void updateMessagesHash(HandshakeMessage handshakeMessage) {
        if (handshakeMessage.type != 0) {
            byte[] byArray = handshakeMessage.toByteArray();
            try {
                this.shaMessageHash.write(byArray);
                this.md5MessageHash.write(byArray);
            }
            catch (IOException iOException) {}
        }
    }

    public boolean hasQueuedMessages() {
        return this.inputQueue.getSize() > 0;
    }

    public void processQueuedMessages() {
        while (this.hasQueuedMessages()) {
            this.processNextMessage();
        }
    }

    private void processNextMessage() {
        HandshakeMessage handshakeMessage = new HandshakeMessage(this.inputQueue.getReadStream());
        if (handshakeMessage.type != 0 && handshakeMessage.type != 20) {
            this.updateMessagesHash(handshakeMessage);
        }
        switch (handshakeMessage.type) {
            case 0: {
                this.processHelloRequest(handshakeMessage);
                break;
            }
            case 2: {
                this.processServerHello(handshakeMessage);
                break;
            }
            case 11: {
                this.processCertificate(handshakeMessage);
                break;
            }
            case 12: {
                this.processServerKeyExchange(handshakeMessage);
                break;
            }
            case 13: {
                this.processCertificateRequest(handshakeMessage);
                break;
            }
            case 14: {
                this.processServerHelloDone(handshakeMessage);
                break;
            }
            case 20: {
                this.processServerFinished(handshakeMessage);
                break;
            }
            default: {
                throw new IOException();
            }
        }
    }

    private void sendMessage(byte by) {
        HandshakeMessage handshakeMessage = new HandshakeMessage();
        handshakeMessage.type = by;
        switch (by) {
            case 1: {
                handshakeMessage.rawData = this.generateClientHelloData();
                break;
            }
            case 16: {
                handshakeMessage.rawData = this.generateClientKeyExchangeData();
                break;
            }
            case 20: {
                handshakeMessage.rawData = this.generateClientFinishedData();
                break;
            }
            case 11: {
                handshakeMessage.rawData = this.generateClientCertificateData();
                break;
            }
            case 15: {
                handshakeMessage.rawData = this.generateCertificateVerifyData();
            }
        }
        this.updateMessagesHash(handshakeMessage);
        this.outputQueue.getWriteStream().write(handshakeMessage.toByteArray());
    }

    private void processHelloRequest(HandshakeMessage handshakeMessage) {
        if (!this.isHandshaking) {
            this.sendMessage((byte)1);
            this.flushMessages();
        }
    }

    private byte[] generateClientHelloData() {
        ClientHello clientHello = new ClientHello(this.socket, this.pendingConnection.clientRandom, this.pendingSession.getSessionID(), new byte[1]);
        return clientHello.toByteArray();
    }

    private byte[] generateClientCertificateData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        X509Certificate[] x509CertificateArray = this.context.getClientCertificateChain(this.clientAlias);
        byteArrayOutputStream.write(Util.getBytes((long)x509CertificateArray.length, 3));
        int n = 0;
        while (n < x509CertificateArray.length) {
            try {
                byte[] byArray = ((com.ibm.oti.security.provider.X509Certificate)x509CertificateArray[n]).getEncoded();
                byteArrayOutputStream.write(Util.getBytes((long)byArray.length, 3));
                byteArrayOutputStream.write(byArray);
            }
            catch (CertificateEncodingException certificateEncodingException) {
                throw new IOException(Msg.getString("K03a7"));
            }
            ++n;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] generateCertificateVerifyData() {
        byte[] byArray = this.computeFinishedMD5Hash(new byte[0]);
        byte[] byArray2 = this.computeFinishedSHAHash(new byte[0]);
        byte[] byArray3 = Util.concatenate(byArray, byArray2);
        PKCS1 pKCS1 = new PKCS1("SHA1");
        byArray3 = pKCS1.signSSA_PKCS1_v15Impl_NO_DER((RSAPrivateKey)this.context.getPrivateKey(this.clientAlias), byArray3);
        byte[] byArray4 = Util.getBytes(byArray3.length, 2);
        byArray3 = Util.concatenate(byArray4, byArray3);
        return byArray3;
    }

    private boolean isProtocolVersionSupported(byte[] byArray) {
        String string = CipherSpec.getProtocolName(byArray);
        int n = 0;
        while (n < this.socket.getEnabledProtocols().length) {
            if (this.socket.getEnabledProtocols()[n].equals(string)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    private void processServerHello(HandshakeMessage handshakeMessage) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(handshakeMessage.rawData);
        byte[] byArray = new byte[2];
        byteArrayInputStream.read(byArray);
        this.pendingConnection.serverRandom = new byte[32];
        byteArrayInputStream.read(this.pendingConnection.serverRandom);
        byte[] byArray2 = new byte[byteArrayInputStream.read()];
        if (byArray2.length > 0) {
            byteArrayInputStream.read(byArray2);
        }
        CipherSpec cipherSpec = CipherSpec.getCipherSpec(byteArrayInputStream);
        byte by = (byte)byteArrayInputStream.read();
        if (!this.isProtocolVersionSupported(byArray)) {
            throw new J9ProtocolException(Msg.getString("K01e5", (Object)byArray));
        }
        if (cipherSpec == null) {
            throw new J9ProtocolException(Msg.getString("K01e6", cipherSpec));
        }
        if (by != 0) {
            throw new J9ProtocolException(Msg.getString("K01e7", by));
        }
        if (this.resumeSession && !Util.equals(this.pendingSession.getSessionID(), byArray2)) {
            this.resumeSession = false;
            this.pendingSession = new SessionState(this.socket.getHostName());
            this.pendingConnection.setSessionState(this.pendingSession);
        }
        this.pendingSession.serverHelloUpdate(byArray2, cipherSpec, by, byArray);
        if (this.resumeSession) {
            this.pendingConnection.generateConnectionKeys();
            this.socket.setReadPendingConnectionState(this.pendingConnection);
        }
    }

    private void processCertificate(HandshakeMessage handshakeMessage) {
        Vector vector = new Vector();
        int n = 0;
        n += 3;
        while (n < handshakeMessage.rawData.length) {
            try {
                int n2 = (int)Util.getLong(handshakeMessage.rawData, n, 3);
                byte[] byArray = new byte[n2];
                System.arraycopy((Object)handshakeMessage.rawData, n += 3, (Object)byArray, 0, n2);
                n += n2;
                X509CertImpl x509CertImpl = X509CertImpl.certificateFromASN1Object(byArray);
                vector.addElement(x509CertImpl);
            }
            catch (CertificateException certificateException) {
                throw new J9HandshakeException(Msg.getString("K01e8", certificateException.getMessage()));
            }
        }
        if (vector == null || vector.size() == 0) {
            throw new J9HandshakeException(Msg.getString("K01e9"));
        }
        try {
            X509Certificate[] x509CertificateArray = new com.ibm.oti.security.provider.X509Certificate[vector.size()];
            int n3 = 0;
            while (n3 < vector.size()) {
                x509CertificateArray[n3] = new com.ibm.oti.security.provider.X509Certificate((X509CertImpl)vector.elementAt(n3));
                ++n3;
            }
            this.context.verifyCertificateChain(x509CertificateArray);
        }
        catch (CertificateException certificateException) {
            throw new J9HandshakeException(certificateException.getMessage());
        }
        this.pendingSession.setPeerCertificates(vector);
    }

    private void processServerKeyExchange(HandshakeMessage handshakeMessage) {
        if (handshakeMessage.rawData == null || handshakeMessage.rawData.length < 3) {
            return;
        }
        int n = 0;
        int n2 = (int)Util.getLong(handshakeMessage.rawData, n, 2);
        if (n2 > handshakeMessage.rawData.length - n) {
            throw new J9ProtocolException(Msg.getString("K01ea"));
        }
        byte[] byArray = new byte[n2];
        System.arraycopy((Object)handshakeMessage.rawData, n += 2, (Object)byArray, 0, n2);
        BigInteger bigInteger = new BigInteger(1, byArray);
        int n3 = (int)Util.getLong(handshakeMessage.rawData, n += n2, 2);
        if (n3 > handshakeMessage.rawData.length - n) {
            throw new J9ProtocolException(Msg.getString("K01ea"));
        }
        byte[] byArray2 = new byte[n3];
        System.arraycopy((Object)handshakeMessage.rawData, n += 2, (Object)byArray2, 0, n3);
        BigInteger bigInteger2 = new BigInteger(1, byArray2);
        n += n3;
        this.tempKey = new RSAPublicKey(bigInteger, bigInteger2);
    }

    private void processCertificateRequest(HandshakeMessage handshakeMessage) {
        this.clientCertificateRequested = true;
        this.clientAlias = null;
        if (handshakeMessage.rawData == null || handshakeMessage.rawData.length < 4) {
            return;
        }
        int n = handshakeMessage.rawData[0];
        String[] stringArray = new String[n];
        int n2 = 0;
        while (n2 < n) {
            stringArray[n2] = this.getKeyAlogorithmName(handshakeMessage.rawData[n2 + 1]);
            ++n2;
        }
        Vector vector = new Vector();
        int n3 = 1 + n + 2;
        while (n3 < handshakeMessage.rawData.length) {
            int n4 = (int)Util.getLong(handshakeMessage.rawData, n3, 2);
            byte[] byArray = new byte[n4];
            System.arraycopy((Object)handshakeMessage.rawData, n3 += 2, (Object)byArray, 0, n4);
            vector.addElement(new X500Principal(byArray));
            n3 += n4;
        }
        Principal[] principalArray = new X500Principal[vector.size()];
        int n5 = 0;
        while (n5 < vector.size()) {
            principalArray[n5] = (X500Principal)vector.elementAt(n5);
            ++n5;
        }
        this.clientAlias = this.context.getClientAlias(stringArray, principalArray);
    }

    private String getKeyAlogorithmName(byte by) {
        switch (by) {
            case 1: {
                return "RSA";
            }
            case 2: {
                return "DSS";
            }
        }
        return "unknown";
    }

    private void processServerHelloDone(HandshakeMessage handshakeMessage) {
        if (!this.resumeSession) {
            this.generatePreMasterSecret();
            if (this.isTLS()) {
                this.pendingSession.setMasterSecret(this.generateTLSMasterSecret());
            } else {
                this.pendingSession.setMasterSecret(this.generateSSLMasterSecret());
            }
            if (this.clientCertificateRequested && this.clientAlias == null) {
                this.socket.sendSocketAlert((byte)1, (byte)41);
            }
            if (this.clientCertificateRequested && this.clientAlias != null) {
                this.sendMessage((byte)11);
                this.flushMessages();
            }
            this.sendMessage((byte)16);
            this.flushMessages();
            if (this.clientCertificateRequested && this.clientAlias != null) {
                this.sendMessage((byte)15);
                this.flushMessages();
            }
        }
        this.pendingConnection.generateConnectionKeys();
        this.socket.setSessionState(this.pendingSession);
        this.socket.setWriteConnectionState(this.pendingConnection);
        this.socket.setReadPendingConnectionState(this.pendingConnection);
        this.sendMessage((byte)20);
        this.flushMessages();
    }

    private byte[] generateTLSMasterSecret() {
        byte[] byArray = Util.concatenate(this.pendingConnection.clientRandom, this.pendingConnection.serverRandom);
        byte[] byArray2 = TLSProtocol.PRF(this.pre_master_secret, "master secret", byArray, 48);
        return byArray2;
    }

    private byte[] generateSSLMasterSecret() {
        byte[] byArray = Util.concatenate(new byte[]{65}, this.pre_master_secret, this.pendingConnection.clientRandom, this.pendingConnection.serverRandom);
        byte[] byArray2 = Util.concatenate(this.pre_master_secret, HashingAlgorithmSHA1.hashSHA1(byArray));
        byte[] byArray3 = HashingAlgorithmMD5.hashMD5(byArray2);
        byArray = Util.concatenate(new byte[]{66, 66}, this.pre_master_secret, this.pendingConnection.clientRandom, this.pendingConnection.serverRandom);
        byArray2 = Util.concatenate(this.pre_master_secret, HashingAlgorithmSHA1.hashSHA1(byArray));
        byte[] byArray4 = HashingAlgorithmMD5.hashMD5(byArray2);
        byArray = Util.concatenate(new byte[]{67, 67, 67}, this.pre_master_secret, this.pendingConnection.clientRandom, this.pendingConnection.serverRandom);
        byArray2 = Util.concatenate(this.pre_master_secret, HashingAlgorithmSHA1.hashSHA1(byArray));
        byte[] byArray5 = HashingAlgorithmMD5.hashMD5(byArray2);
        byte[] byArray6 = Util.concatenate(byArray3, byArray4, byArray5);
        return byArray6;
    }

    private void generatePreMasterSecret() {
        byte[] byArray = new byte[46];
        this.context.getRandomBytes(byArray);
        this.pre_master_secret = Util.concatenate(this.pendingSession.getProtocolVersion(), byArray);
    }

    private byte[] generateClientKeyExchangeData() {
        X509CertImpl[] x509CertImplArray = this.pendingConnection.getSessionState().getPeerCertificates();
        if (x509CertImplArray == null || x509CertImplArray.length == 0) {
            throw new IOException(Msg.getString("K0196"));
        }
        X509CertImpl x509CertImpl = x509CertImplArray[0];
        RSAPublicKey rSAPublicKey = null;
        rSAPublicKey = this.tempKey != null ? this.tempKey : (RSAPublicKey)x509CertImpl.getPublicKey();
        ClientKeyExchange clientKeyExchange = new ClientKeyExchange(rSAPublicKey, this.pre_master_secret);
        if (this.isTLS()) {
            byte[] byArray = Util.getBytes(clientKeyExchange.toByteArray().length, 2);
            return Util.concatenate(byArray, clientKeyExchange.toByteArray());
        }
        return clientKeyExchange.toByteArray();
    }

    private boolean isTLS() {
        return this.pendingConnection.isTLS();
    }

    private void processServerFinished(HandshakeMessage handshakeMessage) {
        if (this.isTLS()) {
            this.processTLSServerFinished(handshakeMessage);
        } else {
            this.processSSLServerFinished(handshakeMessage);
        }
        if (this.resumeSession) {
            this.updateMessagesHash(handshakeMessage);
            this.socket.setSessionState(this.pendingSession);
            this.socket.setWriteConnectionState(this.pendingConnection);
            this.sendMessage((byte)20);
            this.flushMessages();
        }
        this.isHandshaking = false;
    }

    private void processTLSServerFinished(HandshakeMessage handshakeMessage) {
        byte[] byArray = new byte[12];
        System.arraycopy((Object)handshakeMessage.rawData, 0, (Object)byArray, 0, 12);
        byte[] byArray2 = Util.concatenate(this.getMD5Hash(), this.getSHAHash());
        byte[] byArray3 = TLSProtocol.PRF(this.pendingSession.getMasterSecret(), "server finished", byArray2, 12);
        if (!Util.equals(byArray, byArray3)) {
            this.socket.sendSocketAlert((byte)2, (byte)40);
            throw new J9HandshakeException(Msg.getString("K01eb"));
        }
    }

    private byte[] generateTLSClientFinishedData() {
        byte[] byArray = Util.concatenate(this.getMD5Hash(), this.getSHAHash());
        byte[] byArray2 = TLSProtocol.PRF(this.pendingSession.getMasterSecret(), "client finished", byArray, 12);
        return byArray2;
    }

    private void processSSLServerFinished(HandshakeMessage handshakeMessage) {
        byte[] byArray = new byte[]{83, 82, 86, 82};
        byte[] byArray2 = new byte[16];
        System.arraycopy((Object)handshakeMessage.rawData, 0, (Object)byArray2, 0, 16);
        byte[] byArray3 = new byte[20];
        System.arraycopy((Object)handshakeMessage.rawData, 16, (Object)byArray3, 0, 20);
        byte[] byArray4 = this.computeFinishedMD5Hash(byArray);
        byte[] byArray5 = this.computeFinishedSHAHash(byArray);
        if (!Util.equals(byArray2, byArray4)) {
            this.socket.sendSocketAlert((byte)2, (byte)40);
            throw new J9HandshakeException(Msg.getString("K01eb"));
        }
        if (!Util.equals(byArray3, byArray5)) {
            this.socket.sendSocketAlert((byte)2, (byte)40);
            throw new J9HandshakeException(Msg.getString("K01eb"));
        }
    }

    private byte[] generateClientFinishedData() {
        if (this.isTLS()) {
            return this.generateTLSClientFinishedData();
        }
        return this.generateSSLClientFinishedData();
    }

    private byte[] generateSSLClientFinishedData() {
        byte[] byArray = new byte[]{67, 76, 78, 84};
        byte[] byArray2 = this.computeFinishedMD5Hash(byArray);
        byte[] byArray3 = this.computeFinishedSHAHash(byArray);
        byte[] byArray4 = Util.concatenate(byArray2, byArray3);
        return byArray4;
    }

    private byte[] computeFinishedMD5Hash(byte[] byArray) {
        try {
            MD5OutputStream mD5OutputStream = this.md5MessageHash.copyOf();
            mD5OutputStream.write(byArray);
            mD5OutputStream.write(this.pendingSession.getMasterSecret());
            mD5OutputStream.write(HashingAlgorithmMD5.PAD_1);
            return HashingAlgorithmMD5.hashMD5(Util.concatenate(this.pendingSession.getMasterSecret(), HashingAlgorithmMD5.PAD_2, mD5OutputStream.getHashAsBytes()));
        }
        catch (IOException iOException) {
            return null;
        }
    }

    private byte[] getMD5Hash() {
        MD5OutputStream mD5OutputStream = this.md5MessageHash.copyOf();
        return mD5OutputStream.getHashAsBytes();
    }

    private byte[] getSHAHash() {
        try {
            SHAOutputStream sHAOutputStream = (SHAOutputStream)this.shaMessageHash.clone();
            return sHAOutputStream.getHashAsBytes(true);
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return new byte[0];
        }
    }

    private byte[] computeFinishedSHAHash(byte[] byArray) {
        try {
            SHAOutputStream sHAOutputStream = (SHAOutputStream)this.shaMessageHash.clone();
            sHAOutputStream.write(byArray);
            sHAOutputStream.write(this.pendingSession.getMasterSecret());
            sHAOutputStream.write(HashingAlgorithmSHA1.PAD_1);
            return HashingAlgorithmSHA1.hashSHA1(Util.concatenate(this.pendingSession.getMasterSecret(), HashingAlgorithmSHA1.PAD_2, sHAOutputStream.getHashAsBytes(true)));
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
        }
        catch (IOException iOException) {}
        return null;
    }

    private void flushMessages() {
        byte[] byArray = new byte[this.outputQueue.getSize()];
        this.outputQueue.getReadStream().read(byArray);
        this.socket.writeData(byArray, 0, byArray.length, (byte)22);
    }
}

