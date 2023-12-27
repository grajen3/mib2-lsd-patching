/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBThreadConfiguration;
import de.vw.mib.threads.internal.ServiceManager;
import de.vw.mib.threads.internal.ThreadErrorHandler;
import de.vw.mib.threads.internal.ThreadWithWatchdog;
import java.util.ArrayList;

public final class Watchdog
extends Thread {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(256);
    private ThreadWithWatchdog currentThread;
    private boolean currentThreadAnswered;
    private final long pollTime;
    private final ThreadErrorHandler errorHandler;
    private final ArrayList threads;

    Watchdog(MIBThreadConfiguration mIBThreadConfiguration, ThreadErrorHandler threadErrorHandler) {
        this.pollTime = mIBThreadConfiguration.getWatchdogPollTime();
        this.errorHandler = threadErrorHandler;
        this.threads = new ArrayList();
        this.setName("WATCHDOG");
        this.setPriority(mIBThreadConfiguration.getWatchdogPriority());
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (true) {
                    this.checkAllThreads();
                    Thread.sleep(this.pollTime);
                }
            }
            catch (InterruptedException interruptedException) {
                continue;
            }
            break;
        }
    }

    private synchronized void checkThread(ThreadWithWatchdog threadWithWatchdog) {
        if (logger.isTraceEnabled(8)) {
            LogMessage logMessage = logger.trace(8);
            logMessage.append("check ").append(threadWithWatchdog);
            logMessage.log();
        }
        this.currentThread = threadWithWatchdog;
        this.currentThreadAnswered = false;
        if (!threadWithWatchdog.isAlive()) {
            this.errorHandler.handleThreadDeath(threadWithWatchdog);
            return;
        }
        if (!threadWithWatchdog.askThread()) {
            return;
        }
        super.wait(threadWithWatchdog.getDescription().getWatchdogTimeout());
        if (!this.currentThreadAnswered) {
            if (!threadWithWatchdog.isAlive()) {
                this.errorHandler.handleThreadDeath(threadWithWatchdog);
                return;
            }
            this.errorHandler.dump();
            threadWithWatchdog.askThread();
            super.wait(threadWithWatchdog.getDescription().getWatchdogTimeout());
            if (!this.currentThreadAnswered) {
                if (!threadWithWatchdog.isAlive()) {
                    this.errorHandler.handleThreadDeath(threadWithWatchdog);
                    return;
                }
                this.errorHandler.handleTimeout(threadWithWatchdog);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkAllThreads() {
        ArrayList arrayList;
        logger.trace(8, "checking all threads ...");
        ArrayList arrayList2 = this.threads;
        synchronized (arrayList2) {
            arrayList = new ArrayList(this.threads);
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            this.checkThread((ThreadWithWatchdog)arrayList.get(i2));
        }
    }

    synchronized void answerWatchdog(ThreadWithWatchdog threadWithWatchdog) {
        if (this.currentThread != threadWithWatchdog) {
            LogMessage logMessage = logger.error(8);
            logMessage.append("answered by the wrong thread! ");
            logMessage.append(threadWithWatchdog).append(" has answered but ");
            logMessage.append(this.currentThread).append(" was expected to answer!").log();
            return;
        }
        if (logger.isTraceEnabled(8)) {
            LogMessage logMessage = logger.trace(8);
            logMessage.append("answer from ").append(threadWithWatchdog);
            logMessage.log();
        }
        this.currentThreadAnswered = true;
        super.notify();
    }

    long getPollTime() {
        return this.pollTime;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void registerThread(ThreadWithWatchdog threadWithWatchdog) {
        Object object;
        if (logger.isTraceEnabled(8)) {
            object = logger.trace(8);
            object.append("register ").append(threadWithWatchdog);
            object.log();
        }
        object = this.threads;
        synchronized (object) {
            this.threads.add(threadWithWatchdog);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void unregisterThread(ThreadWithWatchdog threadWithWatchdog) {
        Object object;
        if (logger.isTraceEnabled(8)) {
            object = logger.trace(8);
            object.append("unregister ").append(threadWithWatchdog);
            object.log();
        }
        object = this.threads;
        synchronized (object) {
            this.threads.remove(threadWithWatchdog);
        }
    }
}

