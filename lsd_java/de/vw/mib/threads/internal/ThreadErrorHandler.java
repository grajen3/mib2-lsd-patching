/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBThreadDescription;
import de.vw.mib.threads.internal.ServiceManager;
import de.vw.mib.threads.internal.ThreadManager;
import de.vw.mib.threads.internal.ThreadStats;
import de.vw.mib.threads.internal.ThreadWithWatchdog;

final class ThreadErrorHandler {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(256);
    private final ThreadManager threadManager;

    ThreadErrorHandler(ThreadManager threadManager) {
        this.threadManager = threadManager;
    }

    void dump() {
        this.threadManager.dump();
    }

    private void handleError(ThreadWithWatchdog threadWithWatchdog) {
        this.threadManager.dump();
        MIBThreadDescription mIBThreadDescription = threadWithWatchdog.getDescription();
        ThreadStats threadStats = threadWithWatchdog.getThreadStats();
        if (mIBThreadDescription.isTerminateOnError()) {
            ServiceManager.errorHandler.rebootSystem(new Exception(new StringBuffer().append("reboot system because of fatal error in ").append(threadWithWatchdog).toString()));
            return;
        }
        if (mIBThreadDescription.getWatchdogRetries() >= threadStats.getNumberOfRestarts()) {
            threadWithWatchdog.restart();
        } else {
            ServiceManager.errorHandler.rebootSystem(new Exception(new StringBuffer().append("reboot system because of fatal error in ").append(threadWithWatchdog).toString()));
        }
    }

    void handleThreadDeath(ThreadWithWatchdog threadWithWatchdog) {
        logger.error(16).append(threadWithWatchdog).append(" has died!").log();
        threadWithWatchdog.threadDeathDetected();
        this.handleError(threadWithWatchdog);
    }

    void handleTimeout(ThreadWithWatchdog threadWithWatchdog) {
        logger.error(16).append("Timeout for ").append(threadWithWatchdog).append("!").log();
        threadWithWatchdog.timeoutDetected();
        this.handleError(threadWithWatchdog);
    }
}

