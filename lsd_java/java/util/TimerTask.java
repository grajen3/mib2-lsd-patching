/*
 * Decompiled with CFR 0.152.
 */
package java.util;

public abstract class TimerTask
implements Runnable {
    private boolean cancelled = false;
    long when;
    long period;
    boolean fixedRate;
    private long scheduledTime = 0L;

    void setScheduledTime(long l) {
        this.scheduledTime = l;
    }

    boolean isScheduled() {
        return this.when > 0L || this.scheduledTime > 0L;
    }

    boolean isCancelled() {
        return this.cancelled;
    }

    protected TimerTask() {
    }

    public boolean cancel() {
        boolean bl = !this.cancelled && this.when > 0L;
        this.cancelled = true;
        return bl;
    }

    public long scheduledExecutionTime() {
        return this.scheduledTime;
    }

    @Override
    public abstract void run() {
    }
}

