/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;

final class ThreadPoolExecutor$Worker
extends ReentrantLock
implements Runnable {
    private static final long serialVersionUID;
    final Thread thread;
    Runnable firstTask;
    volatile long completedTasks;
    private final /* synthetic */ ThreadPoolExecutor this$0;

    ThreadPoolExecutor$Worker(ThreadPoolExecutor threadPoolExecutor, Runnable runnable) {
        this.this$0 = threadPoolExecutor;
        this.firstTask = runnable;
        this.thread = threadPoolExecutor.getThreadFactory().newThread(this);
    }

    @Override
    public void run() {
        this.this$0.runWorker(this);
    }
}

