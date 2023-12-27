/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.serversocket;

import com.ibm.oti.connection.ConnectionUtil;
import com.ibm.oti.connection.CreateConnection;
import com.ibm.oti.connection.socket.SocketHelper;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import javax.microedition.io.ServerSocketConnection;
import javax.microedition.io.StreamConnection;

public class Connection
implements CreateConnection,
ServerSocketConnection {
    static final int DEFAULT_TIMEOUT;
    private boolean closed = false;
    private int timeout = 0;
    private int backlog = -1;
    private ServerSocket socket;

    @Override
    public javax.microedition.io.Connection setParameters2(String string, int n, boolean bl) {
        String[][] stringArray = ConnectionUtil.NO_PARAMETERS;
        int n2 = string.indexOf(59);
        if (n2 != -1) {
            stringArray = ConnectionUtil.getParameters(string.substring(n2 + 1));
            string = string.substring(0, n2);
        }
        this.setParameters(string, stringArray, n, bl);
        return this;
    }

    private void setParameters(String string, String[][] stringArray, int n, boolean bl) {
        int[] nArray = new int[1];
        int n2 = 0;
        while (n2 < stringArray.length) {
            String string2 = stringArray[n2][0];
            stringArray[n2][0] = stringArray[n2][0].toLowerCase();
            if (ConnectionUtil.intParam("so_timeout", stringArray[n2], 1, nArray)) {
                this.timeout = nArray[0];
            } else if (ConnectionUtil.intParam("backlog", stringArray[n2], 1, nArray)) {
                this.backlog = nArray[0];
            } else {
                throw new IllegalArgumentException(Msg.getString("K00a5", string2));
            }
            ++n2;
        }
        if (bl && this.timeout == 0) {
            this.timeout = 8000;
        }
        nArray[0] = 0;
        SocketHelper.parseURL(string, nArray, false, true);
        try {
            this.socket = this.backlog == -1 ? new ServerSocket(nArray[0]) : new ServerSocket(nArray[0], this.backlog);
            if (this.timeout > 0) {
                this.socket.setSoTimeout(this.timeout);
            }
        }
        catch (SocketException socketException) {
            throw new IOException(socketException.getMessage());
        }
    }

    @Override
    public void close() {
        this.closed = true;
        this.socket.close();
    }

    @Override
    public StreamConnection acceptAndOpen() {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        try {
            Socket socket = this.socket.accept();
            com.ibm.oti.connection.socket.Connection connection = new com.ibm.oti.connection.socket.Connection(socket);
            return connection;
        }
        catch (SocketException socketException) {
            throw new IOException(socketException.getMessage());
        }
    }

    @Override
    public String getLocalAddress() {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        InetAddress inetAddress = this.socket.getInetAddress();
        String string = inetAddress.getHostAddress();
        if (inetAddress.isAnyLocalAddress()) {
            return InetAddress.getLocalHost().getHostAddress();
        }
        return string;
    }

    @Override
    public int getLocalPort() {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        return this.socket.getLocalPort();
    }
}

