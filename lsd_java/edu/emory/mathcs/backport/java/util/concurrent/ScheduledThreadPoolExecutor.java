/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.RejectedExecutionHandler;
import edu.emory.mathcs.backport.java.util.concurrent.RunnableScheduledFuture;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledFuture;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadFactory;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicLong;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import java.util.List;

public class ScheduledThreadPoolExecutor
extends ThreadPoolExecutor
implements ScheduledExecutorService {
    private volatile boolean continueExistingPeriodicTasksAfterShutdown;
    private volatile boolean executeExistingDelayedTasksAfterShutdown = true;
    private volatile boolean removeOnCancel = false;
    private static final AtomicLong sequencer = new AtomicLong(0L);

    final long now() {
        return Utils.nanoTime();
    }

    boolean canRunInCurrentRunState(boolean bl) {
        return this.isRunningOrShutdown(bl ? this.continueExistingPeriodicTasksAfterShutdown : this.executeExistingDelayedTasksAfterShutdown);
    }

    private void delayedExecute(RunnableScheduledFuture runnableScheduledFuture) {
        if (this.isShutdown()) {
            this.reject(runnableScheduledFuture);
        } else {
            super.getQueue().add(runnableScheduledFuture);
            if (this.isShutdown() && !this.canRunInCurrentRunState(runnableScheduledFuture.isPeriodic()) && this.remove(runnableScheduledFuture)) {
                runnableScheduledFuture.cancel(false);
            } else {
                this.prestartCoreThread();
            }
        }
    }

    void reExecutePeriodic(RunnableScheduledFuture runnableScheduledFuture) {
        if (this.canRunInCurrentRunState(true)) {
            super.getQueue().add(runnableScheduledFuture);
            if (!this.canRunInCurrentRunState(true) && this.remove(runnableScheduledFuture)) {
                runnableScheduledFuture.cancel(false);
            } else {
                this.prestartCoreThread();
            }
        }
    }

    @Override
    void onShutdown() {
        BlockingQueue blockingQueue = super.getQueue();
        boolean bl = this.getExecuteExistingDelayedTasksAfterShutdownPolicy();
        boolean bl2 = this.getContinueExistingPeriodicTasksAfterShutdownPolicy();
        if (!bl && !bl2) {
            blockingQueue.clear();
        } else {
            Object[] objectArray = blockingQueue.toArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                RunnableScheduledFuture runnableScheduledFuture;
                Object object = objectArray[i2];
                if (!(object instanceof RunnableScheduledFuture) || !(!(runnableScheduledFuture = (RunnableScheduledFuture)object).isPeriodic() ? !bl : !bl2) && !runnableScheduledFuture.isCancelled() || !blockingQueue.remove(runnableScheduledFuture)) continue;
                runnableScheduledFuture.cancel(false);
            }
        }
        this.tryTerminate();
    }

    protected RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        return runnableScheduledFuture;
    }

    protected RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        return runnableScheduledFuture;
    }

    public ScheduledThreadPoolExecutor(int n) {
        super(n, -129, 0L, TimeUnit.NANOSECONDS, new ScheduledThreadPoolExecutor$DelayedWorkQueue());
    }

    public ScheduledThreadPoolExecutor(int n, ThreadFactory threadFactory) {
        super(n, -129, 0L, TimeUnit.NANOSECONDS, (BlockingQueue)new ScheduledThreadPoolExecutor$DelayedWorkQueue(), threadFactory);
    }

    public ScheduledThreadPoolExecutor(int n, RejectedExecutionHandler rejectedExecutionHandler) {
        super(n, -129, 0L, TimeUnit.NANOSECONDS, (BlockingQueue)new ScheduledThreadPoolExecutor$DelayedWorkQueue(), rejectedExecutionHandler);
    }

    public ScheduledThreadPoolExecutor(int n, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(n, -129, 0L, TimeUnit.NANOSECONDS, new ScheduledThreadPoolExecutor$DelayedWorkQueue(), threadFactory, rejectedExecutionHandler);
    }

    @Override
    public ScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        if (runnable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (l < 0L) {
            l = 0L;
        }
        long l2 = this.now() + timeUnit.toNanos(l);
        RunnableScheduledFuture runnableScheduledFuture = this.decorateTask(runnable, (RunnableScheduledFuture)new ScheduledThreadPoolExecutor$ScheduledFutureTask(this, runnable, null, l2));
        this.delayedExecute(runnableScheduledFuture);
        return runnableScheduledFuture;
    }

    @Override
    public ScheduledFuture schedule(Callable callable, long l, TimeUnit timeUnit) {
        if (callable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (l < 0L) {
            l = 0L;
        }
        long l2 = this.now() + timeUnit.toNanos(l);
        RunnableScheduledFuture runnableScheduledFuture = this.decorateTask(callable, (RunnableScheduledFuture)new ScheduledThreadPoolExecutor$ScheduledFutureTask(this, callable, l2));
        this.delayedExecute(runnableScheduledFuture);
        return runnableScheduledFuture;
    }

    @Override
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        if (runnable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        if (l < 0L) {
            l = 0L;
        }
        long l3 = this.now() + timeUnit.toNanos(l);
        RunnableScheduledFuture runnableScheduledFuture = this.decorateTask(runnable, (RunnableScheduledFuture)new ScheduledThreadPoolExecutor$ScheduledFutureTask(this, runnable, null, l3, timeUnit.toNanos(l2)));
        this.delayedExecute(runnableScheduledFuture);
        return runnableScheduledFuture;
    }

    @Override
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        if (runnable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        if (l < 0L) {
            l = 0L;
        }
        long l3 = this.now() + timeUnit.toNanos(l);
        RunnableScheduledFuture runnableScheduledFuture = this.decorateTask(runnable, (RunnableScheduledFuture)new ScheduledThreadPoolExecutor$ScheduledFutureTask(this, runnable, null, l3, timeUnit.toNanos(-l2)));
        this.delayedExecute(runnableScheduledFuture);
        return runnableScheduledFuture;
    }

    @Override
    public void execute(Runnable runnable) {
        this.schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @Override
    public Future submit(Runnable runnable) {
        return this.schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @Override
    public Future submit(Runnable runnable, Object object) {
        return this.schedule(Executors.callable(runnable, object), 0L, TimeUnit.NANOSECONDS);
    }

    @Override
    public Future submit(Callable callable) {
        return this.schedule(callable, 0L, TimeUnit.NANOSECONDS);
    }

    public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean bl) {
        this.continueExistingPeriodicTasksAfterShutdown = bl;
        if (!bl && this.isShutdown()) {
            this.onShutdown();
        }
    }

    public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() {
        return this.continueExistingPeriodicTasksAfterShutdown;
    }

    public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean bl) {
        this.executeExistingDelayedTasksAfterShutdown = bl;
        if (!bl && this.isShutdown()) {
            this.onShutdown();
        }
    }

    public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() {
        return this.executeExistingDelayedTasksAfterShutdown;
    }

    public void setRemoveOnCancelPolicy(boolean bl) {
        this.removeOnCancel = bl;
    }

    public boolean getRemoveOnCancelPolicy() {
        return this.removeOnCancel;
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }

    @Override
    public List shutdownNow() {
        return super.shutdownNow();
    }

    @Override
    public BlockingQueue getQueue() {
        return super.getQueue();
    }

    static /* synthetic */ AtomicLong access$000() {
        return sequencer;
    }

    static /* synthetic */ boolean access$100(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return scheduledThreadPoolExecutor.removeOnCancel;
    }
}

