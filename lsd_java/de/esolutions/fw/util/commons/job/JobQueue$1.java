/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;

class JobQueue$1
extends BaseJobFilter {
    private final /* synthetic */ JobQueue this$0;

    JobQueue$1(JobQueue jobQueue) {
        this.this$0 = jobQueue;
    }

    @Override
    public void enqueue(Job job, int n) {
        job.setPosted(this.this$0.getTimeSource().getCurrentTime());
        this.this$0.getJobs().add(job);
    }
}

