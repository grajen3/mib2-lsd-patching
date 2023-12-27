/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface ISocket {
    default public InputStream getInputStream() {
    }

    default public OutputStream getOutputStream() {
    }

    default public void close() {
    }

    default public Socket getSocket() {
    }

    default public boolean isPlainSocket() {
    }
}

