/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Executor;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.util.Collection;
import java.util.List;

public interface ExecutorService
extends Executor {
    default public void shutdown() {
    }

    default public List shutdownNow() {
    }

    default public boolean isShutdown() {
    }

    default public boolean isTerminated() {
    }

    default public boolean awaitTermination(long l, TimeUnit timeUnit) {
    }

    default public Future submit(Callable callable) {
    }

    default public Future submit(Runnable runnable, Object object) {
    }

    default public Future submit(Runnable runnable) {
    }

    default public List invokeAll(Collection collection) {
    }

    default public List invokeAll(Collection collection, long l, TimeUnit timeUnit) {
    }

    default public Object invokeAny(Collection collection) {
    }

    default public Object invokeAny(Collection collection, long l, TimeUnit timeUnit) {
    }
}

