/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;

final class Executors$RunnableAdapter
implements Callable {
    final Runnable task;
    final Object result;

    Executors$RunnableAdapter(Runnable runnable, Object object) {
        this.task = runnable;
        this.result = object;
    }

    @Override
    public Object call() {
        this.task.run();
        return this.result;
    }
}

