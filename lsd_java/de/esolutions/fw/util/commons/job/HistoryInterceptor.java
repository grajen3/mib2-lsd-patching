/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.HistoryInterceptor$HistoryEntry;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobBase;
import java.io.PrintStream;

public class HistoryInterceptor
extends BaseInterceptor
implements IInterceptor {
    private final int logSize;
    private final long longJobLimit;
    private final JobBase[] trail;
    private final JobBase[] longRunners;
    int start = 0;
    int startLongRunners = 0;

    public HistoryInterceptor(int n, long l) {
        this.logSize = n;
        this.longJobLimit = l;
        this.trail = new JobBase[n];
        this.longRunners = new JobBase[n];
    }

    private int keepJob(Job job) {
        int n = this.start++;
        this.trail[n] = job;
        if (this.start >= this.logSize) {
            this.start = 0;
        }
        return n;
    }

    private void updateHistory(int n, Job job) {
        this.trail[n] = new HistoryInterceptor$HistoryEntry(job);
    }

    private boolean isLongRunner(Job job) {
        return job.getNeeded() > this.longJobLimit;
    }

    private void keepLongRunner(Job job) {
        this.longRunners[this.startLongRunners] = new HistoryInterceptor$HistoryEntry(job);
        ++this.startLongRunners;
        if (this.startLongRunners >= this.logSize) {
            this.startLongRunners = 0;
        }
    }

    private void dump(PrintStream printStream, String string, JobBase[] jobBaseArray, int n) {
        int n2;
        for (n2 = n; n2 < jobBaseArray.length; ++n2) {
            if (jobBaseArray[n2] == null) continue;
            jobBaseArray[n2].dump(printStream, string);
        }
        for (n2 = 0; n2 < n; ++n2) {
            if (jobBaseArray[n2] == null) continue;
            jobBaseArray[n2].dump(printStream, string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute(Job job) {
        int n = this.keepJob(job);
        try {
            super.execute(job);
        }
        finally {
            this.updateHistory(n, job);
            if (this.isLongRunner(job)) {
                this.keepLongRunner(job);
            }
        }
    }

    @Override
    public void dump(PrintStream printStream) {
        if (printStream != null) {
            printStream.println("processed Jobs:");
            this.dump(printStream, "  ", this.trail, this.start);
            printStream.println();
            printStream.println("long running Jobs:");
            this.dump(printStream, "  ", this.longRunners, this.startLongRunners);
            super.dump(printStream);
        }
    }
}

