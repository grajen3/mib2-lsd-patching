/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.debug.ITransportDebug;

public interface IByteTransport {
    default public void send(byte[] byArray, int n, Object object) {
    }

    default public int recv(byte[] byArray, Object object) {
    }

    default public void open() {
    }

    default public void close(boolean bl) {
    }

    default public int getSendBufferSize() {
    }

    default public int getReceiveBufferSize() {
    }

    default public boolean isReliable() {
    }

    default public boolean detectsPeerReset() {
    }

    default public String getDescription() {
    }

    default public void setDebug(ITransportDebug iTransportDebug) {
    }
}

