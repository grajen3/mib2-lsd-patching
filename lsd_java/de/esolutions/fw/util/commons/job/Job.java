/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.JobBase;

public class Job
extends JobBase {
    private final Object payload;
    private volatile boolean canceled;

    public Job(Object object) {
        this(object, 0L);
    }

    public Job(Object object, long l) {
        super(l);
        if (null == object) {
            throw new NullPointerException();
        }
        this.payload = object;
        this.canceled = false;
    }

    public final Object getPayload() {
        return this.payload;
    }

    public final boolean isCanceled() {
        return this.canceled;
    }

    public final void cancel() {
        this.canceled = true;
    }

    public String toString() {
        return this.payload.toString();
    }
}

