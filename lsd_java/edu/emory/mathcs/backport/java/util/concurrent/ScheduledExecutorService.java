/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledFuture;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public interface ScheduledExecutorService
extends ExecutorService {
    default public ScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeUnit) {
    }

    default public ScheduledFuture schedule(Callable callable, long l, TimeUnit timeUnit) {
    }

    default public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
    }

    default public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
    }
}

