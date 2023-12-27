/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.internal.sinks;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.debug.connection.SimpleTcpServer;
import de.vw.mib.debug.connection.SocketHandler;
import de.vw.mib.debug.connection.spi.DebugSPI_Connection;
import de.vw.mib.debug.connection.spi.DebugSPI_ConnectionErrorHandler;
import de.vw.mib.debug.connection.spi.DebugSPI_ConnectionEventHandler;
import de.vw.mib.debug.spi.internal.sinks.DebugSPI_Sink;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class DebugSPI_TcpSink
implements DebugSPI_ConnectionEventHandler,
DebugSPI_ConnectionErrorHandler,
DebugSPI_Sink,
SocketHandler {
    protected final CowArray connections = new CowArray();
    private final DebugSPI_ConnectionEventHandler handler;
    private final SimpleTcpServer server;

    public DebugSPI_TcpSink(DebugSPI_ConnectionEventHandler debugSPI_ConnectionEventHandler) {
        this.handler = debugSPI_ConnectionEventHandler;
        this.server = new SimpleTcpServer(this, DebugSPI_Connection.SERVER_PORT);
        try {
            System.out.println("[DebugSPI] - opening DebugSPI tcp sink ...");
            this.server.start("DebugSPI_TcpSink");
        }
        catch (IOException iOException) {
            System.err.println("[DebugSPI] - can't open DebugSPI tcp sink!");
            iOException.printStackTrace();
        }
    }

    @Override
    public void close() {
        System.out.println("[DebugSPI] - closing DebugSPI tcp sink ...");
        try {
            this.server.close();
        }
        catch (IOException iOException) {
            System.err.println("[DebugSPI] - can't close DebugSPI tcp sink server!");
            iOException.printStackTrace();
        }
        Object[] objectArray = this.connections.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugSPI_Connection)objectArray[i2]).close();
        }
        this.handler.logSinkStateChanged(1, false);
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
            if (this.connections.length() == 1) {
                this.handler.logSinkStateChanged(1, true);
            }
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
        if (this.connections.length() == 0) {
            this.handler.logSinkStateChanged(1, false);
        }
    }

    @Override
    public void handleException(Throwable throwable) {
        System.err.println("[DebugSPI] - error while reading message!");
        throwable.printStackTrace();
    }

    @Override
    public void write(int n, short s, byte[] byArray, int n2) {
        try {
            Object[] objectArray = this.connections.getArray();
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                ((DebugSPI_Connection)objectArray[i2]).write(n, s, byArray, n2);
            }
        }
        catch (SocketException socketException) {
            Object[] objectArray = this.connections.getArray();
            for (int i3 = objectArray.length - 1; i3 >= 0; --i3) {
                this.handleConnectionLoss((DebugSPI_Connection)objectArray[i3]);
            }
        }
        catch (Exception exception) {
            System.err.println("[DebugSPI] - error while processing write queue");
            exception.printStackTrace();
        }
    }

    @Override
    public void consume(byte[] byArray) {
        this.handler.consume(byArray);
    }

    @Override
    public void consume(long l, byte[] byArray) {
        this.handler.consume(l, byArray);
    }

    @Override
    public void writeBinaryLogMessages(long[] lArray, byte[][] byArray, int[] nArray, int[] nArray2, int n, int n2) {
        try {
            Object[] objectArray = this.connections.getArray();
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                ((DebugSPI_Connection)objectArray[i2]).writeBinaryLogMessages(lArray, byArray, nArray, nArray2, n, n2);
            }
        }
        catch (SocketException socketException) {
            Object[] objectArray = this.connections.getArray();
            for (int i3 = objectArray.length - 1; i3 >= 0; --i3) {
                this.handleConnectionLoss((DebugSPI_Connection)objectArray[i3]);
            }
        }
        catch (Exception exception) {
            System.err.println("[DebugSPI] - error while processing write queue");
            exception.printStackTrace();
        }
    }

    @Override
    public void writeTextLogMessages(long[] lArray, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, byte[][] byArray, int[] nArray5, int n, int n2) {
        try {
            Object[] objectArray = this.connections.getArray();
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                ((DebugSPI_Connection)objectArray[i2]).writeTextLogMessages(lArray, nArray, nArray2, nArray3, nArray4, byArray, nArray5, n, n2);
            }
        }
        catch (SocketException socketException) {
            Object[] objectArray = this.connections.getArray();
            for (int i3 = objectArray.length - 1; i3 >= 0; --i3) {
                this.handleConnectionLoss((DebugSPI_Connection)objectArray[i3]);
            }
        }
        catch (Exception exception) {
            System.err.println("[DebugSPI] - error while processing write queue");
            exception.printStackTrace();
        }
    }

    @Override
    public void logSinkStateChanged(int n, boolean bl) {
        this.handler.logSinkStateChanged(n, bl);
    }
}

