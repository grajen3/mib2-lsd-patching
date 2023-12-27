/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.IServerSocket;
import de.esolutions.fw.util.transport.socket.ISocket;
import de.esolutions.fw.util.transport.socket.SocketWrapper;
import java.net.ServerSocket;

public class ServerSocketWrapper
implements IServerSocket {
    private final ServerSocket serverSocket;

    public ServerSocketWrapper(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public ISocket accept() {
        return new SocketWrapper(this.serverSocket.accept());
    }

    @Override
    public void close() {
        this.serverSocket.close();
    }
}

