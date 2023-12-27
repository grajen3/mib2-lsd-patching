/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

final class DispatcherBase$FinishedNowInterceptor
extends BaseInterceptor {
    private final ITimeSource timeSource;

    public DispatcherBase$FinishedNowInterceptor(ITimeSource iTimeSource) {
        this.timeSource = iTimeSource;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute(Job job) {
        try {
            super.execute(job);
        }
        finally {
            job.setFinished(this.timeSource.getCurrentTime());
        }
    }
}

