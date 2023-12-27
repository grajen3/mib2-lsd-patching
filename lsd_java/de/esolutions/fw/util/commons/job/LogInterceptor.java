/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.commons.job.Job;

public class LogInterceptor
extends BaseInterceptor
implements IInterceptor {
    private final String name;
    private final IJobLogger log;

    public LogInterceptor(String string, IJobLogger iJobLogger) {
        this.name = string;
        this.log = iJobLogger;
        if (iJobLogger == null) {
            throw new IllegalArgumentException("LogInterceptor() parameter 'log' must not be null!");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute(Job job) {
        this.log.log(1078071040, "%1: dispatching %2, latency %3ms", (Object)this.name, job, (int)job.getLatency());
        try {
            super.execute(job);
        }
        finally {
            this.log.log(1078071040, "%1: dispatching %2 done in %3ms", (Object)this.name, job, (int)job.getNeeded());
        }
    }
}

