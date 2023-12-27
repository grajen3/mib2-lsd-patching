/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ThreadFactory;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicInteger;

class Executors$DefaultThreadFactory
implements ThreadFactory {
    static final AtomicInteger poolNumber = new AtomicInteger(1);
    final ThreadGroup group;
    final AtomicInteger threadNumber = new AtomicInteger(1);
    final String namePrefix;

    Executors$DefaultThreadFactory() {
        SecurityManager securityManager = System.getSecurityManager();
        this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = new StringBuffer().append("pool-").append(poolNumber.getAndIncrement()).append("-thread-").toString();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.group, runnable, new StringBuffer().append(this.namePrefix).append(this.threadNumber.getAndIncrement()).toString(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}

