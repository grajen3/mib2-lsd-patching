/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.IServerSocket;
import de.esolutions.fw.util.transport.socket.ISocket;
import de.esolutions.fw.util.transport.socket.ServerSocketWrapper;
import de.esolutions.fw.util.transport.socket.SocketOptions;
import de.esolutions.fw.util.transport.socket.SocketWrapper;
import de.esolutions.fw.util.transport.socket.ssl.CredentialProvider;
import de.esolutions.fw.util.transport.socket.ssl.ISSLCredentialProvider;
import de.esolutions.fw.util.transport.socket.ssl.JSSEFileCredentialProvider;
import de.esolutions.fw.util.transport.socket.ssl.JSSESockets;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketHelper {
    private final SocketOptions opts;
    private JSSESockets jsse;

    public SocketHelper(SocketOptions socketOptions) {
        this.opts = socketOptions;
        if (socketOptions != null && socketOptions.useSSL) {
            ISSLCredentialProvider iSSLCredentialProvider = this.getSSLCredentialProvider(socketOptions);
            if (iSSLCredentialProvider == null) {
                throw new IOException("SSLCredentialManager not found!");
            }
            this.jsse = new JSSESockets(socketOptions, iSSLCredentialProvider);
        }
    }

    private ISSLCredentialProvider getSSLCredentialProvider(SocketOptions socketOptions) {
        if (CredentialProvider.getInstance() != null) {
            return CredentialProvider.getInstance();
        }
        if (socketOptions.keyStorePath != null && socketOptions.trustStorePath != null) {
            JSSEFileCredentialProvider jSSEFileCredentialProvider = new JSSEFileCredentialProvider();
            jSSEFileCredentialProvider.setKeyStorePath(socketOptions.keyStorePath);
            jSSEFileCredentialProvider.setTrustStorePath(socketOptions.trustStorePath);
            jSSEFileCredentialProvider.setKeyStorePassPhrase(socketOptions.keyStorePassPhrase);
            jSSEFileCredentialProvider.setTrustStorePassPhrase(socketOptions.trustStorePassPhrase);
            CredentialProvider.setInstance(jSSEFileCredentialProvider);
            return jSSEFileCredentialProvider;
        }
        return null;
    }

    public ISocket createSocket(InetAddress inetAddress, int n) {
        ISocket iSocket;
        if (this.opts != null && this.opts.useSSL) {
            iSocket = this.jsse.createSocket(inetAddress, n);
        } else {
            Socket socket = new Socket(inetAddress, n);
            iSocket = new SocketWrapper(socket);
        }
        this.setupSocket(iSocket.getSocket());
        return iSocket;
    }

    public IServerSocket createServerSocket(InetAddress inetAddress, int n) {
        IServerSocket iServerSocket;
        int n2 = 1;
        if (this.opts != null) {
            n2 = this.opts.serverBackLog;
        }
        if (n2 < 1) {
            n2 = 1;
        }
        if (this.opts != null && this.opts.useSSL) {
            iServerSocket = this.jsse.createServerSocket(inetAddress, n, n2);
        } else {
            ServerSocket serverSocket = new ServerSocket(n, n2, inetAddress);
            iServerSocket = new ServerSocketWrapper(serverSocket);
        }
        return iServerSocket;
    }

    public ISocket accept(IServerSocket iServerSocket) {
        ISocket iSocket = iServerSocket.accept();
        this.setupSocket(iSocket.getSocket());
        return iSocket;
    }

    private void setupSocket(Socket socket) {
        if (this.opts != null) {
            if (this.opts.keepAlive) {
                socket.setKeepAlive(true);
            }
            socket.setSoTimeout(this.opts.timeOut);
            socket.setTcpNoDelay(this.opts.noDelay);
        }
    }
}

