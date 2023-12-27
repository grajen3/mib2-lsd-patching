/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThreadDescription;
import de.vw.mib.threads.internal.AbstractMIBThread;
import de.vw.mib.threads.internal.Watchdog;

final class ThreadWithWatchdog
extends AbstractMIBThread {
    private final Watchdog watchdog;
    private boolean watchdogPending;

    ThreadWithWatchdog(MIBRunnable mIBRunnable, MIBThreadDescription mIBThreadDescription, Watchdog watchdog) {
        super(mIBRunnable, mIBThreadDescription);
        this.watchdog = watchdog;
    }

    @Override
    public void restart() {
        super.restart();
        this.watchdog.registerThread(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        logger.normal(2).append(this).append(" started!").log();
        Thread thread = Thread.currentThread();
        while (this.thread == thread) {
            try {
                if (this.watchdogPending) {
                    this.watchdogPending = false;
                    this.watchdog.answerWatchdog(this);
                } else {
                    if (this.suspended) {
                        Object object = this.semaphore;
                        synchronized (object) {
                            while (this.suspended && !this.watchdogPending) {
                                try {
                                    this.semaphore.wait();
                                }
                                catch (InterruptedException interruptedException) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                    }
                    try {
                        this.runnable.operate();
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.countDownForErrorCounterReset();
            }
            catch (Throwable throwable) {
                this.handleFatalError(throwable);
            }
        }
        logger.info(2).append(this).append(" stopped!").log();
    }

    @Override
    public void start() {
        super.start();
        this.watchdog.registerThread(this);
    }

    @Override
    public void stop() {
        this.watchdog.unregisterThread(this);
        super.stop();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean askThread() {
        if (this.description.getWatchdogStartTime() > (long)this.stats.getNumberOfChecks() * this.watchdog.getPollTime()) {
            this.stats.check();
            return false;
        }
        this.watchdogPending = true;
        if (this.suspended) {
            Object object = this.semaphore;
            synchronized (object) {
                this.semaphore.notify();
            }
        }
        this.stats.check();
        return true;
    }

    void threadDeathDetected() {
        this.watchdog.unregisterThread(this);
        this.runnable.threadDeathDetected();
        this.stats.error();
    }

    void timeoutDetected() {
        this.watchdog.unregisterThread(this);
        this.runnable.timeoutDetected();
        this.stats.error();
    }
}

