/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.osgi.AgentDumpInfoProvider$DumperRunnable;
import de.esolutions.fw.comm.agent.osgi.MuteableOutputStream;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

public class AgentDumpInfoProvider
implements DumpInfoProvider {
    private Thread dumperThread;
    private boolean doDump = false;
    private boolean doDumpReady = false;
    private PrintStream printStream;
    private int timeout;
    private Object syncWaitForDump = new Object();
    private Object syncWaitForDumpReady = new Object();

    private int readTimeoutFromProperty() {
        int n = 1000;
        String string = System.getProperty("ipl.errordump.timeout");
        try {
            n = Integer.parseInt(string);
        }
        catch (Exception exception) {
            // empty catch block
        }
        return n;
    }

    public AgentDumpInfoProvider() {
        this.dumperThread = new Thread(new AgentDumpInfoProvider$DumperRunnable(this, null), "commAgentDumpInfoProvider");
        this.dumperThread.start();
        this.timeout = this.readTimeoutFromProperty();
        this.doDump = false;
        this.doDumpReady = false;
    }

    @Override
    public String getName() {
        return "commAgent";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void dump(PrintStream printStream, String string) {
        MuteableOutputStream muteableOutputStream;
        Object object = this.syncWaitForDump;
        synchronized (object) {
            muteableOutputStream = new MuteableOutputStream(printStream);
            this.printStream = new PrintStream(muteableOutputStream);
            this.doDump = true;
            this.doDumpReady = false;
            this.syncWaitForDump.notifyAll();
        }
        object = this.syncWaitForDumpReady;
        synchronized (object) {
            try {
                if (!this.doDumpReady) {
                    this.syncWaitForDumpReady.wait(this.timeout);
                    if (!this.doDumpReady) {
                        printStream.println("dump report aborted, timeout");
                    }
                    muteableOutputStream.disableWrites();
                }
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }

    static /* synthetic */ Object access$100(AgentDumpInfoProvider agentDumpInfoProvider) {
        return agentDumpInfoProvider.syncWaitForDump;
    }

    static /* synthetic */ boolean access$200(AgentDumpInfoProvider agentDumpInfoProvider) {
        return agentDumpInfoProvider.doDump;
    }

    static /* synthetic */ PrintStream access$300(AgentDumpInfoProvider agentDumpInfoProvider) {
        return agentDumpInfoProvider.printStream;
    }

    static /* synthetic */ Object access$400(AgentDumpInfoProvider agentDumpInfoProvider) {
        return agentDumpInfoProvider.syncWaitForDumpReady;
    }

    static /* synthetic */ boolean access$502(AgentDumpInfoProvider agentDumpInfoProvider, boolean bl) {
        agentDumpInfoProvider.doDumpReady = bl;
        return agentDumpInfoProvider.doDumpReady;
    }

    static /* synthetic */ boolean access$202(AgentDumpInfoProvider agentDumpInfoProvider, boolean bl) {
        agentDumpInfoProvider.doDump = bl;
        return agentDumpInfoProvider.doDump;
    }
}

