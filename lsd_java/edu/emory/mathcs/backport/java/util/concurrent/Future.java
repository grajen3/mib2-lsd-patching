/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public interface Future {
    default public boolean cancel(boolean bl) {
    }

    default public boolean isCancelled() {
    }

    default public boolean isDone() {
    }

    default public Object get() {
    }

    default public Object get(long l, TimeUnit timeUnit) {
    }
}

