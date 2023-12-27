/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThreadDescription;
import de.vw.mib.threads.internal.AbstractMIBThread;

final class ThreadWithoutWatchdog
extends AbstractMIBThread {
    ThreadWithoutWatchdog(MIBRunnable mIBRunnable, MIBThreadDescription mIBThreadDescription) {
        super(mIBRunnable, mIBThreadDescription);
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
                if (this.suspended) {
                    Object object = this.semaphore;
                    synchronized (object) {
                        while (this.suspended) {
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
                catch (Throwable throwable) {
                    try {
                        logger.error(2).append("exception occurs in ").append(this).append(": ").attachThrowable(throwable).log();
                    }
                    catch (Throwable throwable2) {
                        // empty catch block
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
}

