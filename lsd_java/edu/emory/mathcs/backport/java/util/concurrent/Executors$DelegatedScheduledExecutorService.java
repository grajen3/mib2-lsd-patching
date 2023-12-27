/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$DelegatedExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledFuture;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

class Executors$DelegatedScheduledExecutorService
extends Executors$DelegatedExecutorService
implements ScheduledExecutorService {
    private final ScheduledExecutorService e;

    Executors$DelegatedScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.e = scheduledExecutorService;
    }

    @Override
    public ScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        return this.e.schedule(runnable, l, timeUnit);
    }

    @Override
    public ScheduledFuture schedule(Callable callable, long l, TimeUnit timeUnit) {
        return this.e.schedule(callable, l, timeUnit);
    }

    @Override
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        return this.e.scheduleAtFixedRate(runnable, l, l2, timeUnit);
    }

    @Override
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        return this.e.scheduleWithFixedDelay(runnable, l, l2, timeUnit);
    }
}

