/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public interface CompletionService {
    default public Future submit(Callable callable) {
    }

    default public Future submit(Runnable runnable, Object object) {
    }

    default public Future take() {
    }

    default public Future poll() {
    }

    default public Future poll(long l, TimeUnit timeUnit) {
    }
}

