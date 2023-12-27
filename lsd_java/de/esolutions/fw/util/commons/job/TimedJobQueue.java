/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.job.TimedJobQueue$1;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

public class TimedJobQueue
extends JobQueue {
    public TimedJobQueue(ITimeSource iTimeSource) {
        super(iTimeSource, null);
        this.initFilterChain(new TimedJobQueue$1(this));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public synchronized Job getNextJob() {
        while (true) {
            this.waitForNextJob();
            if (this.isDead() || this.isWakeup()) {
                this.clearWakeup();
                return this.getNullJob();
            }
            Job job = this.getJob(0);
            if (job.isCanceled()) return this.removeFirstJob();
            long l = job.getDue() - this.getTimeSource().getCurrentTime();
            if (l > 0L) {
                try {
                    super.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
                continue;
            }
            if (!this.isSuspended()) return this.removeFirstJob();
        }
    }

    @Override
    public synchronized int getDueJobs() {
        long l = this.getTimeSource().getCurrentTime();
        for (int i2 = 0; i2 < this.length(); ++i2) {
            if (this.getJob(i2).getDue() <= l) continue;
            return i2;
        }
        return this.length();
    }
}

