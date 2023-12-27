/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThread;
import de.vw.mib.threads.MIBThreadDescription;
import de.vw.mib.threads.internal.ServiceManager;
import de.vw.mib.threads.internal.ThreadStats;

public abstract class AbstractMIBThread
implements Loggable,
MIBThread,
Runnable {
    protected static final int MAX_FATAL_ERROR_COUNT;
    protected static final int FATAL_ERROR_COUNTER_RESET_COUNTDOWN;
    protected static Logger logger;
    protected final MIBThreadDescription description;
    protected final MIBRunnable runnable;
    protected final Object semaphore;
    protected final ThreadStats stats;
    protected boolean suspended = false;
    protected volatile Thread thread;
    private int fatalErrorCount;
    private int fatalErrorCountReset;

    AbstractMIBThread(MIBRunnable mIBRunnable, MIBThreadDescription mIBThreadDescription) {
        this.runnable = mIBRunnable;
        this.description = mIBThreadDescription;
        this.runnable.setThread(this);
        this.semaphore = new Object();
        this.stats = new ThreadStats();
    }

    @Override
    public int getId() {
        return this.description.getId();
    }

    @Override
    public Thread getJavaThread() {
        return this.thread;
    }

    @Override
    public Object getSemaphore() {
        return this.semaphore;
    }

    @Override
    public boolean isAlive() {
        if (this.thread == null) {
            return false;
        }
        return this.thread.isAlive();
    }

    @Override
    public boolean isInCurrentMIBThread() {
        if (this.thread == null) {
            return false;
        }
        return Thread.currentThread() == this.thread;
    }

    @Override
    public void restart() {
        if (logger.isTraceEnabled(2)) {
            LogMessage logMessage = logger.trace(2);
            logMessage.append("restart ").append(this);
            logMessage.log();
        }
        if (this.thread != null) {
            this.thread.interrupt();
        }
        this.startThread();
        this.stats.restart();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resume() {
        Object object;
        if (logger.isTraceEnabled(2)) {
            object = logger.trace(2);
            object.append("resume ").append(this);
            object.log();
        }
        object = this.semaphore;
        synchronized (object) {
            this.suspended = false;
            this.semaphore.notify();
        }
    }

    @Override
    public void start() {
        if (logger.isTraceEnabled(2)) {
            LogMessage logMessage = logger.trace(2);
            logMessage.append("start ").append(this);
            logMessage.log();
        }
        this.startThread();
    }

    @Override
    public void stop() {
        Object object;
        if (logger.isTraceEnabled(2)) {
            object = logger.trace(2);
            object.append("stop ").append(this);
            object.log();
        }
        this.suspended = false;
        object = this.thread;
        this.thread = null;
        if (object != null) {
            ((Thread)object).interrupt();
        }
        this.stats.stop();
    }

    @Override
    public void suspend() {
        if (logger.isTraceEnabled(2)) {
            LogMessage logMessage = logger.trace(2);
            logMessage.append("suspend ").append(this);
            logMessage.log();
        }
        this.suspended = true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("MIBThread '");
        stringBuffer.append(this.description.getName()).append("'");
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("MIBThread '").append(this.description.getName()).append("'");
    }

    private void startThread() {
        this.thread = new Thread(this, this.description.getName());
        this.thread.setPriority(this.description.getPriority());
        this.thread.start();
        this.stats.start();
    }

    final void countDownForErrorCounterReset() {
        if (this.fatalErrorCountReset == 0) {
            this.fatalErrorCount = 0;
        } else {
            --this.fatalErrorCountReset;
        }
    }

    final MIBThreadDescription getDescription() {
        return this.description;
    }

    final ThreadStats getThreadStats() {
        return this.stats;
    }

    final void handleFatalError(Throwable throwable) {
        ServiceManager.errorHandler.handleError(throwable, this.thread);
        if (this.fatalErrorCount > 5) {
            ServiceManager.errorHandler.rebootSystem(throwable);
        }
        ++this.fatalErrorCount;
        this.fatalErrorCountReset = 100;
    }

    static {
        logger = ServiceManager.loggerFactory.getLogger(256);
    }
}

