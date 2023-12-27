/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Delayed;
import edu.emory.mathcs.backport.java.util.concurrent.FutureTask;
import edu.emory.mathcs.backport.java.util.concurrent.RunnableScheduledFuture;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

class ScheduledThreadPoolExecutor$ScheduledFutureTask
extends FutureTask
implements RunnableScheduledFuture {
    private final long sequenceNumber;
    private long time;
    private final long period;
    int heapIndex;
    private final /* synthetic */ ScheduledThreadPoolExecutor this$0;

    ScheduledThreadPoolExecutor$ScheduledFutureTask(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, Runnable runnable, Object object, long l) {
        this.this$0 = scheduledThreadPoolExecutor;
        super(runnable, object);
        this.time = l;
        this.period = 0L;
        this.sequenceNumber = ScheduledThreadPoolExecutor.access$000().getAndIncrement();
    }

    ScheduledThreadPoolExecutor$ScheduledFutureTask(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, Runnable runnable, Object object, long l, long l2) {
        this.this$0 = scheduledThreadPoolExecutor;
        super(runnable, object);
        this.time = l;
        this.period = l2;
        this.sequenceNumber = ScheduledThreadPoolExecutor.access$000().getAndIncrement();
    }

    ScheduledThreadPoolExecutor$ScheduledFutureTask(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, Callable callable, long l) {
        this.this$0 = scheduledThreadPoolExecutor;
        super(callable);
        this.time = l;
        this.period = 0L;
        this.sequenceNumber = ScheduledThreadPoolExecutor.access$000().getAndIncrement();
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        long l = timeUnit.convert(this.time - this.this$0.now(), TimeUnit.NANOSECONDS);
        return l;
    }

    @Override
    public int compareTo(Object object) {
        Delayed delayed = (Delayed)object;
        if (delayed == this) {
            return 0;
        }
        if (delayed instanceof ScheduledThreadPoolExecutor$ScheduledFutureTask) {
            ScheduledThreadPoolExecutor$ScheduledFutureTask scheduledThreadPoolExecutor$ScheduledFutureTask = (ScheduledThreadPoolExecutor$ScheduledFutureTask)object;
            long l = this.time - scheduledThreadPoolExecutor$ScheduledFutureTask.time;
            if (l < 0L) {
                return -1;
            }
            if (l > 0L) {
                return 1;
            }
            if (this.sequenceNumber < scheduledThreadPoolExecutor$ScheduledFutureTask.sequenceNumber) {
                return -1;
            }
            return 1;
        }
        long l = this.getDelay(TimeUnit.NANOSECONDS) - delayed.getDelay(TimeUnit.NANOSECONDS);
        return l == 0L ? 0 : (l < 0L ? -1 : 1);
    }

    @Override
    public boolean isPeriodic() {
        return this.period != 0L;
    }

    private void setNextRunTime() {
        long l = this.period;
        this.time = l > 0L ? (this.time += l) : this.this$0.now() - l;
    }

    @Override
    public boolean cancel(boolean bl) {
        boolean bl2 = super.cancel(bl);
        if (bl2 && ScheduledThreadPoolExecutor.access$100(this.this$0) && this.heapIndex >= 0) {
            this.this$0.remove(this);
        }
        return bl2;
    }

    @Override
    public void run() {
        boolean bl = this.isPeriodic();
        if (!this.this$0.canRunInCurrentRunState(bl)) {
            this.cancel(false);
        } else if (!bl) {
            ScheduledThreadPoolExecutor$ScheduledFutureTask.super.run();
        } else if (ScheduledThreadPoolExecutor$ScheduledFutureTask.super.runAndReset()) {
            this.setNextRunTime();
            this.this$0.reExecutePeriodic(this);
        }
    }
}

