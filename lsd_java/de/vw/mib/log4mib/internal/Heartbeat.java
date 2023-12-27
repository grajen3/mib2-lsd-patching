/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogHeartbeatInformationProvider;
import de.vw.mib.log4mib.internal.AbstractMessage;
import de.vw.mib.log4mib.internal.Heartbeat$1;
import de.vw.mib.log4mib.internal.LoggingThread;
import de.vw.mib.log4mib.internal.MessageFactory;
import de.vw.mib.log4mib.internal.PooledLogMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;

final class Heartbeat
implements Runnable {
    static final String LOGGING_HEARTBEAT_STARTUPTIME;
    static final String LOGGING_HEARTBEAT_THREAD_PRIORITY;
    static final String LOGGING_HEARTBEAT_VERBOSE;
    static final String LOGGING_WATCHDOG_ENABLED;
    private static final boolean VERBOSE;
    private final AbstractMessage CHECK_LOGGING_THREAD_MESSAGE = new Heartbeat$1(this);
    private final MessageFactory factory;
    private final long heartbeatFrequency;
    private final HashMap heartbeatInfos = new HashMap();
    private final HashMap heartbeatInfoProviders = new HashMap();
    private final Thread heartbeatThread;
    private boolean isWatchdogMessagePending = false;
    private final LoggingThread loggingThread;
    private boolean running = true;
    private final long watchtime;

    Heartbeat(LoggingThread loggingThread, MessageFactory messageFactory, long l) {
        this.factory = messageFactory;
        this.heartbeatFrequency = l;
        this.loggingThread = loggingThread;
        this.watchtime = l >> 1;
        this.heartbeatThread = new Thread(this, "Logging-Heartbeat");
        this.heartbeatThread.setPriority(Integer.getInteger("de.vw.mib.log4mib.heartbeat.thread.prio", 10));
        this.addHeartbeatInformation("protocol.version", "1.2");
        this.addHeartbeatInformation("hmisoftware.base.version", "");
        this.addHeartbeatInformationProvider("logmessage.count", loggingThread);
        this.addHeartbeatInformationProvider("logmessage.data.size", loggingThread);
        this.addHeartbeatInformationProvider("logmessage.queue.size", loggingThread);
    }

    @Override
    public void run() {
        long l = Integer.getInteger("de.vw.mib.log4mib.heartbeat.startuptime", 10000).longValue();
        if (Boolean.getBoolean("de.vw.mib.log4mib.watchdog.enabled")) {
            System.out.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] heartbeat with watchdog started - frequency: ").append(this.heartbeatFrequency).append("ms, first heartbeat after ").append(l).append("ms").toString());
            this.runHeartbeatLoopWithWatchdog(l);
        } else {
            System.out.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] heartbeat started - frequency: ").append(this.heartbeatFrequency).append("ms, first heartbeat after ").append(l).append("ms").toString());
            this.runHeartbeatLoop(l);
        }
        System.out.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] heartbeat stopped!").toString());
    }

    synchronized void addHeartbeatInformation(String string, String string2) {
        if (string == null) {
            return;
        }
        if (string2 == null) {
            this.heartbeatInfos.remove(string);
        } else {
            Object object = this.heartbeatInfos.put(string, string2);
            if (object != null && !object.equals(string2)) {
                this.heartbeat();
            }
        }
    }

    synchronized void addHeartbeatInformationProvider(String string, LogHeartbeatInformationProvider logHeartbeatInformationProvider) {
        if (string == null) {
            return;
        }
        if (logHeartbeatInformationProvider == null) {
            this.heartbeatInfoProviders.remove(string);
        } else {
            this.heartbeatInfoProviders.put(string, logHeartbeatInformationProvider);
        }
    }

    void loggingThreadWorks() {
        if (VERBOSE && this.isWatchdogMessagePending) {
            System.out.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] logging thread works fine!").toString());
        }
        this.isWatchdogMessagePending = false;
    }

    void startHeartbeat() {
        if (VERBOSE) {
            System.out.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] starting heartbeat thread ...").toString());
        }
        this.heartbeatThread.start();
    }

    void stopHeartbeat() {
        if (VERBOSE) {
            System.out.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] stopping heartbeat ...").toString());
        }
        this.running = false;
        this.heartbeatThread.interrupt();
        this.heartbeatThread.interrupt();
    }

    private synchronized void heartbeat() {
        if (this.heartbeatInfos.isEmpty()) {
            return;
        }
        InvocationContext.startInvocation(Thread.currentThread());
        PooledLogMessage pooledLogMessage = this.factory.createLogMessage(8, 512, 2);
        Iterator iterator = this.heartbeatInfos.entrySet().iterator();
        Map$Entry map$Entry = (Map$Entry)iterator.next();
        pooledLogMessage.append(map$Entry.getKey()).append(":=").append(map$Entry.getValue());
        while (iterator.hasNext()) {
            map$Entry = (Map$Entry)iterator.next();
            pooledLogMessage.append(";;");
            pooledLogMessage.append(map$Entry.getKey()).append(":=").append(map$Entry.getValue());
        }
        iterator = this.heartbeatInfoProviders.entrySet().iterator();
        while (iterator.hasNext()) {
            map$Entry = (Map$Entry)iterator.next();
            String string = (String)map$Entry.getKey();
            LogHeartbeatInformationProvider logHeartbeatInformationProvider = (LogHeartbeatInformationProvider)map$Entry.getValue();
            String string2 = logHeartbeatInformationProvider.getInformation(string);
            if (string2 == null) continue;
            pooledLogMessage.append(";;");
            pooledLogMessage.append(string).append(":=").append(string2);
        }
        pooledLogMessage.log();
    }

    private void checkLoggingThread() {
        if (!this.running) {
            return;
        }
        if (VERBOSE) {
            System.out.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] checking logging thread ...").toString());
        }
        if (!this.loggingThread.isAlive()) {
            this.handleThreadDeath();
            return;
        }
        if (!this.loggingThread.isWorking()) {
            if (this.isWatchdogMessagePending) {
                this.handleThreadBlocking();
            } else {
                if (VERBOSE) {
                    System.err.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] logging thread seems to be blocked! Send dummy message ...").toString());
                }
                this.loggingThread.addToQueue(this.CHECK_LOGGING_THREAD_MESSAGE);
                this.isWatchdogMessagePending = true;
            }
            return;
        }
        if (this.isWatchdogMessagePending) {
            this.loggingThreadWorks();
        }
    }

    private void handleThreadBlocking() {
        System.err.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] logging thread is blocked!").toString());
        this.restartLoggingThread();
    }

    private void handleThreadDeath() {
        System.err.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] logging thread is dead!").toString());
        this.restartLoggingThread();
    }

    private void restartLoggingThread() {
        System.err.println(new StringBuffer().append(this.factory.getCurrentTime()).append(" - [Log4MIB-Heartbeat] try to restart logging thread!").toString());
        this.loggingThread.restartLoggingThread();
    }

    private void runHeartbeatLoop(long l) {
        this.zzz(l);
        while (this.running) {
            try {
                this.heartbeat();
                this.zzz(this.heartbeatFrequency);
            }
            catch (Throwable throwable) {
                System.err.println("An error has occurred in the heartbeat thread!");
                throwable.printStackTrace();
            }
        }
    }

    private void runHeartbeatLoopWithWatchdog(long l) {
        this.zzz(l);
        while (this.running) {
            try {
                this.heartbeat();
                this.zzz(this.watchtime);
                this.checkLoggingThread();
                this.zzz(this.watchtime);
                this.checkLoggingThread();
            }
            catch (Throwable throwable) {
                System.err.println("An error has occurred in the heartbeat thread!");
                throwable.printStackTrace();
            }
        }
    }

    private void zzz(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    static {
        VERBOSE = Boolean.getBoolean("de.vw.mib.log4mib.heartbeat.verbose");
    }
}

