/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.threading;

import de.esolutions.fw.util.commons.threading.ThreadPool$1;

class ThreadPool$PriorizedRunnable
implements Runnable {
    private final Runnable job;
    private final int priority;

    private ThreadPool$PriorizedRunnable(Runnable runnable, int n) {
        this.job = runnable;
        this.priority = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = Thread.currentThread().getPriority();
        Thread.currentThread().setPriority(this.priority);
        try {
            this.job.run();
        }
        finally {
            Thread.currentThread().setPriority(n);
        }
    }

    /* synthetic */ ThreadPool$PriorizedRunnable(Runnable runnable, int n, ThreadPool$1 threadPool$1) {
        this(runnable, n);
    }
}

