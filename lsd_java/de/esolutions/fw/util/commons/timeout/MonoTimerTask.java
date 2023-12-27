/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

public abstract class MonoTimerTask
implements Runnable {
    final Object lock = new Object();
    boolean cancelled;
    long when;
    long period;
    boolean fixedRate;
    private long scheduledTime;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    long getWhen() {
        Object object = this.lock;
        synchronized (object) {
            return this.when;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setScheduledTime(long l) {
        Object object = this.lock;
        synchronized (object) {
            this.scheduledTime = l;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean isScheduled() {
        Object object = this.lock;
        synchronized (object) {
            return this.when > 0L || this.scheduledTime > 0L;
        }
    }

    protected MonoTimerTask() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean cancel() {
        Object object = this.lock;
        synchronized (object) {
            boolean bl = !this.cancelled && this.when > 0L;
            this.cancelled = true;
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long scheduledExecutionTime() {
        Object object = this.lock;
        synchronized (object) {
            return this.scheduledTime;
        }
    }

    @Override
    public abstract void run() {
    }
}

