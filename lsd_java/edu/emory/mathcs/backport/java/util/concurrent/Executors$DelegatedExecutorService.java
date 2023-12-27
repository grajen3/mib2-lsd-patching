/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.AbstractExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.util.Collection;
import java.util.List;

class Executors$DelegatedExecutorService
extends AbstractExecutorService {
    private final ExecutorService e;

    Executors$DelegatedExecutorService(ExecutorService executorService) {
        this.e = executorService;
    }

    @Override
    public void execute(Runnable runnable) {
        this.e.execute(runnable);
    }

    @Override
    public void shutdown() {
        this.e.shutdown();
    }

    @Override
    public List shutdownNow() {
        return this.e.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return this.e.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return this.e.isTerminated();
    }

    @Override
    public boolean awaitTermination(long l, TimeUnit timeUnit) {
        return this.e.awaitTermination(l, timeUnit);
    }

    @Override
    public Future submit(Runnable runnable) {
        return this.e.submit(runnable);
    }

    @Override
    public Future submit(Callable callable) {
        return this.e.submit(callable);
    }

    @Override
    public Future submit(Runnable runnable, Object object) {
        return this.e.submit(runnable, object);
    }

    @Override
    public List invokeAll(Collection collection) {
        return this.e.invokeAll(collection);
    }

    @Override
    public List invokeAll(Collection collection, long l, TimeUnit timeUnit) {
        return this.e.invokeAll(collection, l, timeUnit);
    }

    @Override
    public Object invokeAny(Collection collection) {
        return this.e.invokeAny(collection);
    }

    @Override
    public Object invokeAny(Collection collection, long l, TimeUnit timeUnit) {
        return this.e.invokeAny(collection, l, timeUnit);
    }
}

