/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.IBlockedJobHandler;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

public class CheckBlockedInterceptor
extends BaseInterceptor
implements IInterceptor {
    private final ITimeSource timeSource;
    private final long timeout;
    private final IBlockedJobHandler blockedHandler;
    private Job currentJob;
    private Job latestBlocker = null;

    public CheckBlockedInterceptor(ITimeSource iTimeSource, long l, IBlockedJobHandler iBlockedJobHandler) {
        this.timeSource = iTimeSource;
        this.timeout = l;
        this.blockedHandler = iBlockedJobHandler;
        this.currentJob = null;
        if (iBlockedJobHandler == null) {
            throw new IllegalArgumentException("JobCheckBlocked() blockedHandler must not be null!");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute(Job job) {
        try {
            CheckBlockedInterceptor checkBlockedInterceptor = this;
            synchronized (checkBlockedInterceptor) {
                this.currentJob = job;
            }
            super.execute(job);
        }
        finally {
            CheckBlockedInterceptor checkBlockedInterceptor = this;
            synchronized (checkBlockedInterceptor) {
                this.currentJob = null;
                if (this.latestBlocker != null) {
                    this.checkJobBlocked();
                }
            }
        }
    }

    public synchronized void checkJobBlocked() {
        if (this.currentJob != null && this.timeSource.getCurrentTime() - this.currentJob.getStarted() > this.timeout) {
            if (this.currentJob != this.latestBlocker) {
                if (this.latestBlocker != null) {
                    this.blockedHandler.unblocked(this.latestBlocker);
                }
                this.latestBlocker = this.currentJob;
                this.blockedHandler.blocked(this.latestBlocker, this.currentJob.getStarted());
            }
        } else if (this.latestBlocker != null) {
            this.blockedHandler.unblocked(this.latestBlocker);
            this.latestBlocker = null;
        }
    }
}

