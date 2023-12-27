/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.CipherSpec;
import com.ibm.j9.ssl.ConnectionState;
import com.ibm.j9.ssl.SessionState;

public interface HandshakeSocket {
    default public String getHostName() {
    }

    default public void sendSocketAlert(byte by, byte by2) {
    }

    default public long getTimeoutLength() {
    }

    default public boolean readData() {
    }

    default public void writeData(byte[] byArray, int n, int n2, byte by) {
    }

    default public void setSessionState(SessionState sessionState) {
    }

    default public void setWriteConnectionState(ConnectionState connectionState) {
    }

    default public void setReadPendingConnectionState(ConnectionState connectionState) {
    }

    default public CipherSpec[] getEnabledCipherSpecs() {
    }

    default public String[] getEnabledProtocols() {
    }
}

