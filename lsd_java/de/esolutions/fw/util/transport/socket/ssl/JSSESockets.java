/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket.ssl;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.transport.socket.IServerSocket;
import de.esolutions.fw.util.transport.socket.ISocket;
import de.esolutions.fw.util.transport.socket.SocketOptions;
import de.esolutions.fw.util.transport.socket.ssl.ISSLCredentialProvider;
import de.esolutions.fw.util.transport.socket.ssl.JSSESockets$Checker;
import de.esolutions.fw.util.transport.socket.ssl.JSSESockets$ServerSocketWrapper;
import de.esolutions.fw.util.transport.socket.ssl.JSSESockets$SocketWrapper;
import java.io.IOException;
import java.net.InetAddress;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class JSSESockets {
    private final SocketOptions opts;
    private final ISSLCredentialProvider mgrs;
    private final SSLContext ctx;

    public JSSESockets(SocketOptions socketOptions, ISSLCredentialProvider iSSLCredentialProvider) {
        this.opts = socketOptions;
        this.mgrs = iSSLCredentialProvider;
        try {
            this.ctx = this.createContext();
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new IOException(new StringBuffer().append("General Security: ").append(generalSecurityException).toString());
        }
    }

    private SSLContext createContext() {
        this.mgrs.init();
        KeyManagerFactory keyManagerFactory = this.mgrs.getKeyManagerFactory();
        if (keyManagerFactory == null) {
            throw new IOException("No key manager factory!");
        }
        TrustManagerFactory trustManagerFactory = this.mgrs.getTrustManagerFactory();
        if (trustManagerFactory == null) {
            throw new IOException("No trust manager factory!");
        }
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        return sSLContext;
    }

    public IServerSocket createServerSocket(InetAddress inetAddress, int n, int n2) {
        SSLServerSocket sSLServerSocket = (SSLServerSocket)this.ctx.getServerSocketFactory().createServerSocket(n, n2, inetAddress);
        String[] stringArray = sSLServerSocket.getEnabledCipherSuites();
        stringArray = this.filterSuites(stringArray);
        sSLServerSocket.setEnabledCipherSuites(stringArray);
        return new JSSESockets$ServerSocketWrapper(this, sSLServerSocket);
    }

    public ISocket createSocket(InetAddress inetAddress, int n) {
        SSLSocket sSLSocket = (SSLSocket)this.ctx.getSocketFactory().createSocket(inetAddress, n);
        String[] stringArray = sSLSocket.getEnabledCipherSuites();
        stringArray = this.filterSuites(stringArray);
        sSLSocket.setEnabledCipherSuites(stringArray);
        String[] stringArray2 = sSLSocket.getSupportedProtocols();
        stringArray2 = this.filterProtocols(stringArray2);
        if (stringArray2 != null) {
            sSLSocket.setEnabledProtocols(stringArray2);
        }
        return new JSSESockets$SocketWrapper(this, sSLSocket);
    }

    private String[] filterSuites(String[] stringArray) {
        String string = this.opts.cipherSuiteFilter;
        if (string == null) {
            return stringArray;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string2 = stringArray[i2];
            if (string2.indexOf(string) == -1) continue;
            arrayList.add(string2);
        }
        Object[] objectArray = new String[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    private String[] filterProtocols(String[] stringArray) {
        if (stringArray == null) {
            throw new IllegalArgumentException("supportedProtocols is null");
        }
        String[] stringArray2 = SocketOptions.protocols;
        if (stringArray2 == null || stringArray2.length == 0) {
            return null;
        }
        Buffer buffer = new Buffer();
        buffer.append(' ');
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            buffer.append(stringArray[i2]);
            buffer.append(" ");
        }
        String string = buffer.toString();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < stringArray2.length; ++i3) {
            String string2 = stringArray2[i3];
            if (string.indexOf(new StringBuffer().append(" ").append(string2).append(" ").toString()) == -1) continue;
            arrayList.add(string2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Object[] objectArray = new String[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    private void installCallback(SSLSocket sSLSocket) {
        JSSESockets$Checker jSSESockets$Checker = new JSSESockets$Checker(null);
        sSLSocket.addHandshakeCompletedListener(jSSESockets$Checker);
    }

    static /* synthetic */ void access$000(JSSESockets jSSESockets, SSLSocket sSLSocket) {
        jSSESockets.installCallback(sSLSocket);
    }
}

