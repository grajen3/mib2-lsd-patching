/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.TimedJobQueue;
import java.util.List;

class TimedJobQueue$1
extends BaseJobFilter {
    private final /* synthetic */ TimedJobQueue this$0;

    TimedJobQueue$1(TimedJobQueue timedJobQueue) {
        this.this$0 = timedJobQueue;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void enqueue(Job job, int n) {
        long l = this.this$0.getTimeSource().getCurrentTime();
        job.setPosted(l);
        TimedJobQueue timedJobQueue = this.this$0;
        synchronized (timedJobQueue) {
            List list = this.this$0.getJobs();
            boolean bl = false;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                Job job2 = this.this$0.getJob(i2);
                if (job2.getDue() <= job.getDue()) continue;
                list.add(i2, job);
                bl = true;
                break;
            }
            if (!bl) {
                list.add(job);
            }
            super.notifyAll();
        }
    }

    public String toString() {
        return "TimedJobQueue: EnqueueFilter";
    }
}

