/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.datachannel.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.debug.connection.SimpleTcpServer;
import de.vw.mib.debug.connection.SocketHandler;
import de.vw.mib.debug.connection.spi.DebugSPI_Connection;
import de.vw.mib.debug.connection.spi.DebugSPI_ConnectionErrorHandler;
import de.vw.mib.debug.connection.spi.DebugSPI_ConnectionEventHandler;
import de.vw.mib.debug.spi.DebugListener;
import java.io.IOException;
import java.net.Socket;

public class DebugSPI_MessageReceiver
implements DebugSPI_ConnectionEventHandler,
DebugSPI_ConnectionErrorHandler,
SocketHandler {
    private final CowArray debugListeners = new CowArray();
    protected final CowArray connections = new CowArray();
    private final SimpleTcpServer server;

    public DebugSPI_MessageReceiver(int n) {
        this.server = new SimpleTcpServer(this, n);
    }

    public void start() {
        try {
            System.out.println("[DebugSPI] - opening DebugSPI tcp message receiver ...");
            this.server.start("DebugSPI_TcpSink");
        }
        catch (IOException iOException) {
            System.err.println("[DebugSPI] - can't open DebugSPI tcp message receiver!");
            iOException.printStackTrace();
        }
    }

    public void addDebugListener(DebugListener debugListener) {
        this.debugListeners.addIfNotAlreadyIn(debugListener);
    }

    public void close() {
        System.out.println("[DebugSPI] - closing DebugSPI tcp message receiver ...");
        try {
            this.server.close();
        }
        catch (IOException iOException) {
            System.err.println("[DebugSPI] - can't close DebugSPI tcp message receiver server!");
            iOException.printStackTrace();
        }
        Object[] objectArray = this.connections.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugSPI_Connection)objectArray[i2]).close();
        }
    }

    @Override
    public void handle(Socket socket) {
        DebugSPI_Connection debugSPI_Connection = null;
        try {
            System.out.println(new StringBuffer().append("[DebugSPI] - creating new DebugSPI connection for ").append(socket).toString());
            debugSPI_Connection = new DebugSPI_Connection(socket);
            debugSPI_Connection.setDebugSPI_ConnectionEventHandler(this);
            debugSPI_Connection.setDebugSPI_ConnectionErrorHandler(this);
            debugSPI_Connection.start();
            this.connections.addIfNotAlreadyIn(debugSPI_Connection);
        }
        catch (IOException iOException) {
            System.err.println(new StringBuffer().append("[DebugSPI] - error while creating DebugSPI connection for ").append(socket).toString());
            iOException.printStackTrace();
            return;
        }
    }

    @Override
    public void handleConnectionLoss(DebugSPI_Connection debugSPI_Connection) {
        System.err.println(new StringBuffer().append("[DebugSPI] - connection lost: ").append(debugSPI_Connection).toString());
        if (debugSPI_Connection == null) {
            return;
        }
        debugSPI_Connection.close();
        this.connections.remove(debugSPI_Connection);
    }

    @Override
    public void handleException(Throwable throwable) {
        System.err.println("[DebugSPI] - error while reading message!");
        throwable.printStackTrace();
    }

    @Override
    public void consume(byte[] byArray) {
        Object[] objectArray = this.debugListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugListener)objectArray[i2]).updateLogConfig(byArray);
        }
    }

    @Override
    public void consume(long l, byte[] byArray) {
        Object[] objectArray = this.debugListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugListener)objectArray[i2]).readBinaryMessage(l, byArray);
        }
    }

    @Override
    public void logSinkStateChanged(int n, boolean bl) {
        Object[] objectArray = this.debugListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugListener)objectArray[i2]).logSinkStateChange(n, bl);
        }
    }
}

