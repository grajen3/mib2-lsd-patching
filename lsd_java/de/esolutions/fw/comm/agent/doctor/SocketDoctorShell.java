/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.SocketDoctorShellServer;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.commons.Buffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class SocketDoctorShell
implements Runnable {
    private final SocketDoctorShellServer server;
    private final Socket socket;
    private final int id;
    private DoctorShell shell;
    private PrintStream out;
    private BufferedReader in;
    private Thread thread;
    private boolean stay;

    public SocketDoctorShell(SocketDoctorShellServer socketDoctorShellServer, Socket socket, int n) {
        this.server = socketDoctorShellServer;
        this.socket = socket;
        this.id = n;
    }

    public boolean start() {
        try {
            InputStreamReader inputStreamReader;
            this.out = new PrintStream(this.socket.getOutputStream());
            this.shell = new DoctorShell();
            InputStream inputStream = this.socket.getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                inputStreamReader = new InputStreamReader(inputStream);
            }
            this.in = new BufferedReader(inputStreamReader);
            this.stay = true;
            this.thread = new Thread(this, new StringBuffer().append("commDoc").append(this.id).toString());
            this.thread.start();
            return true;
        }
        catch (IOException iOException) {
            CommAgentTracing.DOCTOR.log((short)3, "Error starting client %1: %2", this.socket.getRemoteSocketAddress(), (Object)iOException);
            return false;
        }
    }

    public void stop() {
        this.stay = false;
    }

    @Override
    public void run() {
        CommAgentTracing.DOCTOR.log((short)1, "+ run client #%1: %2", new Integer(this.id), (Object)this.socket.getRemoteSocketAddress());
        this.shell.printWelcome(this.out);
        while (this.stay) {
            try {
                this.out.print(this.shell.getPrompt());
                this.out.flush();
                String string = this.in.readLine();
                if (string == null) continue;
                boolean bl = false;
                char[] cArray = string.toCharArray();
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < cArray.length; ++i2) {
                    char c2 = cArray[i2];
                    if (c2 >= ' ') {
                        buffer.append(c2);
                        continue;
                    }
                    bl = true;
                }
                string = buffer.toString();
                if (bl) {
                    this.out.println();
                }
                if (!this.shell.handleCommand(string, this.out)) continue;
                this.stay = false;
            }
            catch (IOException iOException) {
                iOException.printStackTrace(this.out);
            }
        }
        this.shell.printGoodbye(this.out);
        try {
            this.socket.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        CommAgentTracing.DOCTOR.log((short)1, "- run client #%1: %2", new Integer(this.id), (Object)this.socket.getRemoteSocketAddress());
        this.server.unregister(this);
    }
}

