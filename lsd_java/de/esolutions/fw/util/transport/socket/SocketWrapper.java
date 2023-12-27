/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.ISocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketWrapper
implements ISocket {
    private final Socket socket;

    public SocketWrapper(Socket socket) {
        this.socket = socket;
    }

    @Override
    public InputStream getInputStream() {
        return this.socket.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() {
        return this.socket.getOutputStream();
    }

    @Override
    public void close() {
        this.socket.close();
    }

    @Override
    public Socket getSocket() {
        return this.socket;
    }

    @Override
    public boolean isPlainSocket() {
        return true;
    }
}

