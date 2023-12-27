/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobBase;

class HistoryInterceptor$HistoryEntry
extends JobBase {
    private final String payload;

    HistoryInterceptor$HistoryEntry(Job job) {
        super(job);
        this.payload = job.toString();
    }

    public String toString() {
        return this.payload;
    }
}

