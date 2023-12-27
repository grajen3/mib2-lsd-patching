/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.StartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.operation.TaskPool$1;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.threads.AsyncServiceFactory;

public class TaskPool {
    private final IntArrayList idleWorkers = new IntArrayList();
    private final AsyncServiceFactory asyncServiceFactory;

    public TaskPool(AsyncServiceFactory asyncServiceFactory, int n) {
        Preconditions.checkArgument(n >= 1, "Worker count needs to be >= 1.");
        this.asyncServiceFactory = asyncServiceFactory;
        for (int i2 = 0; i2 < n; ++i2) {
            this.idleWorkers.add(i2);
        }
    }

    public boolean hasIdleWorkers() {
        return !this.idleWorkers.isEmpty();
    }

    public int run(StartupTask startupTask, Runnable runnable) {
        Preconditions.checkArgument(runnable != null, "Given callback must not be null.");
        Preconditions.checkState(this.hasIdleWorkers(), "TaskPool has no idle workers.");
        if (startupTask == null) {
            throw new IllegalArgumentException("Given task must not be null.");
        }
        int n = this.seizeWorker();
        StartupTask startupTask2 = (StartupTask)this.asyncServiceFactory.create(startupTask);
        startupTask2.run(this.wrapCallback(runnable, n));
        return n;
    }

    void releaseWorker(int n) {
        this.idleWorkers.add(n);
    }

    private int seizeWorker() {
        int n = this.idleWorkers.get(0);
        this.idleWorkers.removeFirst();
        return n;
    }

    private Runnable wrapCallback(Runnable runnable, int n) {
        return new TaskPool$1(this, n, runnable);
    }
}

