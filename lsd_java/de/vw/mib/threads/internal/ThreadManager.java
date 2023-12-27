/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThread;
import de.vw.mib.threads.MIBThreadConfiguration;
import de.vw.mib.threads.MIBThreadDescription;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.threads.internal.ServiceManager;
import de.vw.mib.threads.internal.ThreadErrorHandler;
import de.vw.mib.threads.internal.ThreadWithWatchdog;
import de.vw.mib.threads.internal.ThreadWithoutWatchdog;
import de.vw.mib.threads.internal.Watchdog;

final class ThreadManager
implements MIBThreadManager {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(256);
    private final MIBThreadDescription[] threadDescriptions;
    private final Watchdog watchdog;

    ThreadManager(MIBThreadConfiguration mIBThreadConfiguration) {
        this.threadDescriptions = mIBThreadConfiguration.getMIBThreadDescriptions();
        ThreadErrorHandler threadErrorHandler = new ThreadErrorHandler(this);
        this.watchdog = new Watchdog(mIBThreadConfiguration, threadErrorHandler);
    }

    @Override
    public MIBThread createThread(int n, MIBRunnable mIBRunnable) {
        MIBThreadDescription mIBThreadDescription = this.getThreadDescription(n);
        logger.normal(4).append("create MIBThread - id: ").append(n).append(", runnable: ").append(mIBRunnable).log();
        if (mIBThreadDescription.isUseWatchdog()) {
            return new ThreadWithWatchdog(mIBRunnable, mIBThreadDescription, this.watchdog);
        }
        return new ThreadWithoutWatchdog(mIBRunnable, mIBThreadDescription);
    }

    @Override
    public Thread createThread(int n, Runnable runnable) {
        MIBThreadDescription mIBThreadDescription = this.getThreadDescription(n);
        logger.normal(4).append("create thread - id: ").append(n).append(", runnable: ").append(runnable).log();
        Thread thread = new Thread(runnable, mIBThreadDescription.getName());
        thread.setPriority(mIBThreadDescription.getPriority());
        return thread;
    }

    @Override
    public void dump() {
        logger.info(4, "thread dump triggered");
        if (ServiceManager.debugSpi == null) {
            logger.warn(4, "Couldn't create thread dump! No method available!");
            return;
        }
        ServiceManager.debugSpi.dumpAllThreadStacks();
    }

    private MIBThreadDescription getThreadDescription(int n) {
        return this.threadDescriptions[n];
    }
}

