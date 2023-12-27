/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket.ssl;

import de.esolutions.fw.util.transport.socket.ISocket;
import de.esolutions.fw.util.transport.socket.ssl.JSSESockets;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

class JSSESockets$SocketWrapper
implements ISocket {
    private final SSLSocket socket;
    private final /* synthetic */ JSSESockets this$0;

    public JSSESockets$SocketWrapper(JSSESockets jSSESockets, SSLSocket sSLSocket) {
        this.this$0 = jSSESockets;
        this.socket = sSLSocket;
        JSSESockets.access$000(jSSESockets, sSLSocket);
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
        return false;
    }
}

