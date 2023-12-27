/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

import de.esolutions.fw.util.commons.timeout.MonoTimer$TimerImpl;
import de.esolutions.fw.util.commons.timeout.MonoTimerTask;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import java.util.Date;

public class MonoTimer {
    private static long timerId;
    private final MonoTimer$TimerImpl impl;

    private static synchronized long nextId() {
        long l = timerId;
        long l2 = l;
        timerId = l + 1L;
    }

    public MonoTimer(String string, boolean bl) {
        if (string == null) {
            throw new NullPointerException("name == null");
        }
        this.impl = new MonoTimer$TimerImpl(string, bl);
    }

    public MonoTimer(String string) {
        this(string, false);
    }

    public MonoTimer(boolean bl) {
        this(new StringBuffer().append("MonoTimer-").append(MonoTimer.nextId()).toString(), bl);
    }

    public MonoTimer() {
        this(false);
    }

    public void cancel() {
        this.impl.cancel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int purge() {
        MonoTimer$TimerImpl monoTimer$TimerImpl = this.impl;
        synchronized (monoTimer$TimerImpl) {
            return this.impl.purge();
        }
    }

    public void schedule(MonoTimerTask monoTimerTask, Date date) {
        if (date.getTime() < 0L) {
            throw new IllegalArgumentException(new StringBuffer().append("when < 0: ").append(date.getTime()).toString());
        }
        long l = date.getTime() - TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
        this.scheduleImpl(monoTimerTask, l < 0L ? 0L : l, -1L, false);
    }

    public void schedule(MonoTimerTask monoTimerTask, long l) {
        if (l < 0L) {
            throw new IllegalArgumentException(new StringBuffer().append("delay < 0: ").append(l).toString());
        }
        this.scheduleImpl(monoTimerTask, l, -1L, false);
    }

    public void schedule(MonoTimerTask monoTimerTask, long l, long l2) {
        if (l < 0L || l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(monoTimerTask, l, l2, false);
    }

    public void schedule(MonoTimerTask monoTimerTask, Date date, long l) {
        if (l <= 0L || date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l2 = date.getTime() - TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
        this.scheduleImpl(monoTimerTask, l2 < 0L ? 0L : l2, l, false);
    }

    public void scheduleAtFixedRate(MonoTimerTask monoTimerTask, long l, long l2) {
        if (l < 0L || l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(monoTimerTask, l, l2, true);
    }

    public void scheduleAtFixedRate(MonoTimerTask monoTimerTask, Date date, long l) {
        if (l <= 0L || date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l2 = date.getTime() - TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
        this.scheduleImpl(monoTimerTask, l2, l, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void scheduleImpl(MonoTimerTask monoTimerTask, long l, long l2, boolean bl) {
        MonoTimer$TimerImpl monoTimer$TimerImpl = this.impl;
        synchronized (monoTimer$TimerImpl) {
            if (MonoTimer$TimerImpl.access$300(this.impl)) {
                throw new IllegalStateException("Timer was canceled");
            }
            long l3 = l + TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
            if (l3 < 0L) {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal delay to start the TimerTask: ").append(l3).toString());
            }
            Object object = monoTimerTask.lock;
            synchronized (object) {
                if (monoTimerTask.isScheduled()) {
                    throw new IllegalStateException("TimerTask is scheduled already");
                }
                if (monoTimerTask.cancelled) {
                    throw new IllegalStateException("TimerTask is canceled");
                }
                monoTimerTask.when = l3;
                monoTimerTask.period = l2;
                monoTimerTask.fixedRate = bl;
            }
            MonoTimer$TimerImpl.access$400(this.impl, monoTimerTask);
        }
    }
}

