/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.connection.spi;

import de.vw.mib.debug.connection.spi.DebugSPI_Connection$1;
import de.vw.mib.debug.connection.spi.DebugSPI_ConnectionErrorHandler;
import de.vw.mib.debug.connection.spi.DebugSPI_ConnectionEventHandler;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderCodec;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderCodecListener;
import de.vw.mib.debug.spi.messages.internal.DebugSPI_MLPHeaderCodec;
import de.vw.mib.debug.spi.messages.internal.DebugSPI_PaseHeaderCodec;
import de.vw.mib.log4mib.internal.MainLogger;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class DebugSPI_Connection
implements DebugSPI_HeaderCodecListener {
    public static int SERVER_PORT = Integer.parseInt(System.getProperty("debugspi.port", "15001"));
    private final OutputStream output;
    private final Thread readerThread;
    private final Socket socket;
    private final ThreadFactory threadFactory = Executors.defaultThreadFactory();
    boolean closing = false;
    DebugSPI_HeaderCodec codec;
    DebugSPI_ConnectionEventHandler connectionEventHandler;
    DebugSPI_ConnectionErrorHandler connectionErrorHandler;
    final DataInputStream input;
    volatile boolean reading = true;
    boolean socketAvailable = true;

    public DebugSPI_Connection(Socket socket) {
        this.socket = socket;
        this.codec = MainLogger.DEBUG_SPI_MLP_ENABLED ? new DebugSPI_MLPHeaderCodec(this) : new DebugSPI_PaseHeaderCodec(this);
        this.input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        this.output = new BufferedOutputStream(socket.getOutputStream());
        this.readerThread = this.createReadingThread(socket);
    }

    public void close() {
        if (this.closing) {
            return;
        }
        this.closing = true;
        System.out.println(new StringBuffer().append("[DebugSPI_Connection] closing connection ").append(this).append(" ...").toString());
        this.reading = false;
        this.socketAvailable = false;
        try {
            this.socket.shutdownInput();
        }
        catch (IOException iOException) {
            System.err.println("[DebugSPI_Connection] error while closing socket input stream!");
            System.err.println(new StringBuffer().append("[DebugSPI_Connection] ").append(iOException.getMessage()).toString());
        }
        try {
            this.socket.shutdownOutput();
        }
        catch (IOException iOException) {
            System.err.println("[DebugSPI_Connection] error while closing socket output stream!");
            System.err.println(new StringBuffer().append("[DebugSPI_Connection] ").append(iOException.getMessage()).toString());
        }
        try {
            this.socket.close();
        }
        catch (IOException iOException) {
            System.err.println("[DebugSPI_Connection] error while closing socket!");
            iOException.printStackTrace();
        }
        System.out.println(new StringBuffer().append("[DebugSPI_Connection] Connection ").append(this).append(" closed!").toString());
    }

    public void setDebugSPI_ConnectionEventHandler(DebugSPI_ConnectionEventHandler debugSPI_ConnectionEventHandler) {
        this.connectionEventHandler = debugSPI_ConnectionEventHandler;
    }

    public void setDebugSPI_ConnectionErrorHandler(DebugSPI_ConnectionErrorHandler debugSPI_ConnectionErrorHandler) {
        this.connectionErrorHandler = debugSPI_ConnectionErrorHandler;
    }

    public void start() {
        this.readerThread.start();
    }

    public void start(int n) {
        this.readerThread.setPriority(n);
        this.start();
    }

    public String toString() {
        return new StringBuffer().append("DebugSPI_Connection - ").append(this.socket).toString();
    }

    private Thread createReadingThread(Socket socket) {
        Thread thread = this.threadFactory.newThread(new DebugSPI_Connection$1(this, socket));
        thread.setName(new StringBuffer().append("DebugSPIConnection Reader [").append(socket).append("]").toString());
        return thread;
    }

    void handleConnectionError(Exception exception) {
        if (this.connectionEventHandler != null) {
            this.connectionEventHandler.handleException(exception);
        }
    }

    void handleConnectionLoss() {
        if (this.connectionErrorHandler != null) {
            this.connectionErrorHandler.handleConnectionLoss(this);
        }
        this.close();
    }

    public void write(long l, int n, short s, byte[] byArray, int n2) {
        this.write(n, s, byArray, n2);
    }

    public void write(int n, short s, byte[] byArray, int n2) {
        this.write(this.codec.encode(4, s, byArray, n2));
    }

    public void writeBinaryLogMessage(long l, byte[] byArray, int n, int n2) {
        this.write(this.codec.encode(l, byArray, n, n2));
    }

    public void writeBinaryLogMessages(long[] lArray, byte[][] byArray, int[] nArray, int[] nArray2, int n, int n2) {
        this.write(this.codec.encode(lArray, byArray, nArray, nArray2, n, n2));
    }

    public void writeTextLogMessage(long l, int n, int n2, int n3, int n4, byte[] byArray, int n5) {
        this.write(this.codec.encode(l, n, n2, n3, n4, byArray, n5));
    }

    public void writeTextLogMessages(long[] lArray, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, byte[][] byArray, int[] nArray5, int n, int n2) {
        this.write(this.codec.encode(lArray, nArray, nArray2, nArray3, nArray4, byArray, nArray5, n, n2));
    }

    private void write(byte[] byArray) {
        if (!this.socketAvailable) {
            return;
        }
        try {
            this.output.write(byArray);
            this.output.flush();
        }
        catch (SocketException socketException) {
            System.err.println(new StringBuffer().append("[DebugSPI_Connection] error while writing to ").append(this.socket).append("!").toString());
            this.handleConnectionLoss();
        }
    }

    @Override
    public void messageDecoded(long l, byte[] byArray) {
        if (this.connectionEventHandler != null) {
            this.connectionEventHandler.consume(l, byArray);
        }
    }

    @Override
    public void messageDecoded(int n, short s, byte[] byArray) {
        if (this.connectionEventHandler != null) {
            this.connectionEventHandler.consume(byArray);
        }
    }
}

