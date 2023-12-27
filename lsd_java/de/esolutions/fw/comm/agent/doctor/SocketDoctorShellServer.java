/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor;

import de.esolutions.fw.comm.agent.doctor.SocketDoctorShell;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SocketDoctorShellServer
implements Runnable {
    private String host = "localhost";
    private int port = 21021;
    private Thread thread;
    private ServerSocket socket;
    private boolean stay;
    private final List clientList = new ArrayList();
    private int clientId;

    public void setup(String string, int n) {
        this.host = string;
        this.port = n;
    }

    public synchronized boolean start() {
        InetAddress inetAddress;
        CommAgentTracing.DOCTOR.log((short)1, "+ start socket server: host=%1 port=%2", (Object)this.host, (Object)new Integer(this.port));
        try {
            inetAddress = InetAddress.getByName(this.host);
        }
        catch (UnknownHostException unknownHostException) {
            CommAgentTracing.DOCTOR.log((short)3, "SocketServer: not started -> unknown host name: %1", (Object)this.host);
            return false;
        }
        try {
            this.socket = new ServerSocket(this.port, 0, inetAddress);
            this.socket.setSoTimeout(0);
        }
        catch (IOException iOException) {
            CommAgentTracing.DOCTOR.log((short)3, "SocketServer: not started -> error creating socket: %1", iOException);
            return false;
        }
        this.stay = true;
        this.thread = new Thread(this, "commDocSrv");
        this.thread.start();
        CommAgentTracing.DOCTOR.log((short)1, "- stop socket server");
        return true;
    }

    public synchronized void stop() {
        CommAgentTracing.DOCTOR.log((short)1, "+ stop socket server");
        this.stay = false;
        if (this.thread != null) {
            this.thread.interrupt();
            try {
                this.thread.join(0);
                this.thread = null;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        try {
            if (this.socket != null) {
                this.socket.close();
            }
            this.socket = null;
        }
        catch (IOException iOException) {
            CommAgentTracing.DOCTOR.log((short)3, "closing server socket failed: %1", iOException);
        }
        Iterator iterator = this.clientList.iterator();
        while (iterator.hasNext()) {
            SocketDoctorShell socketDoctorShell = (SocketDoctorShell)iterator.next();
            socketDoctorShell.stop();
        }
        CommAgentTracing.DOCTOR.log((short)1, "- stop socket server");
    }

    public synchronized void unregister(SocketDoctorShell socketDoctorShell) {
        this.clientList.remove(socketDoctorShell);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        CommAgentTracing.DOCTOR.log((short)2, "SocketServer worker started.");
        while (this.stay) {
            try {
                Socket socket = this.socket.accept();
                SocketDoctorShellServer socketDoctorShellServer = this;
                synchronized (socketDoctorShellServer) {
                    int n;
                    ++this.clientId;
                    SocketDoctorShell socketDoctorShell = new SocketDoctorShell(this, socket, n);
                    if (socketDoctorShell.start()) {
                        CommAgentTracing.DOCTOR.log((short)1, "SocketServer spawned client #%1 for %2", new Integer(n), (Object)socket.getRemoteSocketAddress());
                        this.clientList.add(socketDoctorShell);
                    } else {
                        socket.close();
                        CommAgentTracing.DOCTOR.log((short)3, "SocketServer failed spawning client: %1", socket.getRemoteSocketAddress());
                    }
                }
            }
            catch (IOException iOException) {
                CommAgentTracing.DOCTOR.log((short)3, "SocketServer accept failed: %1", iOException);
            }
        }
        CommAgentTracing.DOCTOR.log((short)2, "SocketServer worker stopped.");
    }
}

