/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.connection;

import de.vw.mib.debug.connection.SocketHandler;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class SimpleTcpServer
implements Runnable {
    private static final int RECEIVE_BUFFER_SIZE;
    private final int port;
    private ServerSocket serverSocket;
    private final SocketHandler socketHandler;
    private volatile boolean running = true;
    private Thread thread;
    private final ThreadFactory threadFactory;

    public SimpleTcpServer(SocketHandler socketHandler, int n) {
        this.port = n;
        this.socketHandler = socketHandler;
        this.threadFactory = Executors.defaultThreadFactory();
    }

    public void close() {
        this.running = false;
        this.serverSocket.close();
    }

    @Override
    public void run() {
        System.out.println(new StringBuffer().append("[SimpleTcpServer] Creating server socket for port ").append(this.port).toString());
        try {
            this.serverSocket = new ServerSocket(this.port);
        }
        catch (IOException iOException) {
            System.err.println(new StringBuffer().append("[SimpleTcpServer] Error while creating server socket for port ").append(this.port).toString());
            iOException.printStackTrace();
            return;
        }
        while (this.running) {
            try {
                Socket socket = this.serverSocket.accept();
                socket.setReceiveBufferSize(256);
                System.out.println(new StringBuffer().append("[SimpleTcpServer] Connection established: ").append(socket).toString());
                this.socketHandler.handle(socket);
            }
            catch (IOException iOException) {}
        }
        System.out.println("[SimpleTcpServer] Waiting for connections stopped!");
    }

    public void start(String string) {
        this.thread = this.threadFactory.newThread(this);
        this.thread.setName(string);
        this.thread.start();
    }

    public void start() {
        this.thread = this.threadFactory.newThread(this);
        this.thread.setName("SimpleTcpServer");
        this.thread.start();
    }
}

