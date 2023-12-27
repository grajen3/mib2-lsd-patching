/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.IJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue$1;
import de.esolutions.fw.util.commons.job.JobQueue$NullJob;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JobQueue {
    static final int INITIAL_SIZE;
    private final List jobs = new ArrayList(10);
    private final ITimeSource timeSource;
    private final JobQueue$NullJob nullJob;
    private IJobFilter filterchain;
    private int suspendCount;
    private volatile boolean dead = false;
    private volatile boolean wakeup = false;

    protected JobQueue(ITimeSource iTimeSource, IJobFilter iJobFilter) {
        this.timeSource = iTimeSource;
        this.nullJob = new JobQueue$NullJob();
        this.suspendCount = 0;
        this.initFilterChain(iJobFilter);
    }

    public JobQueue(ITimeSource iTimeSource) {
        this(iTimeSource, null);
        this.initFilterChain(new JobQueue$1(this));
    }

    protected final Job getNullJob() {
        return this.nullJob;
    }

    protected final synchronized void initFilterChain(IJobFilter iJobFilter) {
        this.filterchain = iJobFilter;
    }

    public synchronized void addFilter(IJobFilter iJobFilter) {
        if (iJobFilter == null) {
            throw new IllegalArgumentException("JobQueue.addFilter: parameter filter must no be null!");
        }
        if (iJobFilter.getNext() != null) {
            throw new IllegalArgumentException("JobFilter to add is already added to a JobQueue!");
        }
        iJobFilter.setNext(this.filterchain);
        this.filterchain = iJobFilter;
    }

    public synchronized boolean removeFilter(IJobFilter iJobFilter) {
        if (iJobFilter == null) {
            throw new IllegalArgumentException("JobQueue.addFilter: parameter toRemove must no be null!");
        }
        IJobFilter iJobFilter2 = this.filterchain;
        if (iJobFilter2 == iJobFilter) {
            this.filterchain = this.filterchain.getNext();
            iJobFilter.setNext(null);
            return true;
        }
        while (iJobFilter2.getNext() != null) {
            IJobFilter iJobFilter3 = iJobFilter2.getNext();
            if (iJobFilter3 == iJobFilter) {
                iJobFilter2.setNext(iJobFilter3.getNext());
                iJobFilter.setNext(null);
                return true;
            }
            iJobFilter2 = iJobFilter3;
        }
        return false;
    }

    protected synchronized List getJobs() {
        return this.jobs;
    }

    protected Job getJob(int n) {
        return (Job)this.jobs.get(n);
    }

    protected Job removeFirstJob() {
        return (Job)this.jobs.remove(0);
    }

    protected ITimeSource getTimeSource() {
        return this.timeSource;
    }

    public synchronized int length() {
        return this.jobs.size();
    }

    public synchronized int getDueJobs() {
        return this.length();
    }

    public final synchronized boolean isEmpty() {
        return this.jobs.isEmpty();
    }

    public final boolean isDead() {
        return this.dead;
    }

    public final boolean isWakeup() {
        return this.wakeup;
    }

    public synchronized void enqueue(Job job) {
        if (this.isDead()) {
            throw new IllegalStateException("Queue was already shut down!");
        }
        this.filterchain.enqueue(job, this.length());
        super.notifyAll();
    }

    protected final void waitForNextJob() {
        while ((this.isSuspended() || this.isEmpty()) && !this.isDead() && !this.wakeup) {
            try {
                super.wait();
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
        }
    }

    public synchronized Job getNextJob() {
        this.waitForNextJob();
        if (this.isDead() || this.isWakeup()) {
            this.clearWakeup();
            return this.getNullJob();
        }
        super.notifyAll();
        return this.removeFirstJob();
    }

    public synchronized void wakeup() {
        this.wakeup = true;
        super.notifyAll();
    }

    protected void clearWakeup() {
        this.wakeup = false;
    }

    public final synchronized void waitForEmpty() {
        while (!this.isEmpty() && !this.isDead()) {
            try {
                super.wait();
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
        }
    }

    public synchronized void clear() {
        this.jobs.clear();
        super.notifyAll();
    }

    public synchronized void shutdown(boolean bl) {
        if (bl || this.isSuspended()) {
            this.clear();
        } else {
            this.waitForEmpty();
        }
        this.dead = true;
        super.notifyAll();
    }

    public synchronized Job peek() {
        return this.isEmpty() ? null : this.getJob(0);
    }

    public synchronized void suspend() {
        ++this.suspendCount;
    }

    public synchronized void resume() {
        if (this.suspendCount > 0) {
            --this.suspendCount;
            super.notifyAll();
        }
    }

    public synchronized boolean isSuspended() {
        return this.suspendCount > 0;
    }

    public synchronized void dump(PrintStream printStream) {
        if (printStream != null) {
            printStream.println("Filter:");
            this.filterchain.dump(printStream);
            printStream.println("JobQueue contents:");
            Iterator iterator = this.jobs.iterator();
            while (iterator.hasNext()) {
                Job job = (Job)iterator.next();
                job.dump(printStream, "  ");
            }
        }
    }
}

