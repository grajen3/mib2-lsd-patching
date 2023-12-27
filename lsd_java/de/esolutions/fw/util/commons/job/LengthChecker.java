/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.IBlockedJobHandler;
import de.esolutions.fw.util.commons.job.IJobFilter;
import de.esolutions.fw.util.commons.job.Job;

public class LengthChecker
extends BaseJobFilter
implements IJobFilter {
    private final IBlockedJobHandler errorHandler;
    private final int maxQueueLength;
    private volatile boolean dumped = false;

    public LengthChecker(IBlockedJobHandler iBlockedJobHandler, int n) {
        this.errorHandler = iBlockedJobHandler;
        this.maxQueueLength = n;
    }

    @Override
    public void enqueue(Job job, int n) {
        if (this.dumped) {
            if (n < this.maxQueueLength >>> 1) {
                this.dumped = false;
            }
        } else if (n >= this.maxQueueLength) {
            this.errorHandler.lengthExceeded(this.maxQueueLength, n);
            this.dumped = true;
        }
        super.enqueue(job, n);
    }
}

