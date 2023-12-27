/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.threading.ThreadPool;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

public final class PooledDispatcher
extends DispatcherBase {
    public PooledDispatcher(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, ThreadPool threadPool) {
        super(string, iTimeSource, iJobLogger, threadPool);
    }

    public PooledDispatcher(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, JobQueue jobQueue, ThreadPool threadPool) {
        super(string, iTimeSource, iJobLogger, jobQueue, threadPool);
    }

    public PooledDispatcher(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, JobQueue jobQueue, IInterceptor iInterceptor, Job job, ThreadPool threadPool) {
        super(string, iTimeSource, iJobLogger, jobQueue, iInterceptor, job, threadPool);
    }

    @Override
    public Job executeJob(Job job) {
        super.executeJob(job);
        super.startThread();
        return job;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected Job getNextJob() {
        PooledDispatcher pooledDispatcher = this;
        synchronized (pooledDispatcher) {
            if (this.getQueue().isEmpty()) {
                this.stopThread();
                return this.getQueue().getNullJob();
            }
        }
        return super.getNextJob();
    }

    @Override
    public synchronized void start() {
        if (!this.isActive()) {
            this.setStarted(true);
            if (!this.getQueue().isEmpty()) {
                this.startThread();
            }
        }
    }
}

