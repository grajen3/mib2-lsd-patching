/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.ISocket;

public interface IServerSocket {
    default public ISocket accept() {
    }

    default public void close() {
    }
}

