/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket.ssl;

import de.esolutions.fw.util.transport.socket.IServerSocket;
import de.esolutions.fw.util.transport.socket.ISocket;
import de.esolutions.fw.util.transport.socket.ssl.JSSESockets;
import de.esolutions.fw.util.transport.socket.ssl.JSSESockets$SocketWrapper;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

class JSSESockets$ServerSocketWrapper
implements IServerSocket {
    private final SSLServerSocket socket;
    private final /* synthetic */ JSSESockets this$0;

    public JSSESockets$ServerSocketWrapper(JSSESockets jSSESockets, SSLServerSocket sSLServerSocket) {
        this.this$0 = jSSESockets;
        this.socket = sSLServerSocket;
    }

    @Override
    public ISocket accept() {
        SSLSocket sSLSocket = (SSLSocket)this.socket.accept();
        return new JSSESockets$SocketWrapper(this.this$0, sSLSocket);
    }

    @Override
    public void close() {
        this.socket.close();
    }
}

