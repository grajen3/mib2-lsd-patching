/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.util.Msg;
import java.util.Date;
import java.util.Timer$1;
import java.util.Timer$TimerImpl;
import java.util.TimerTask;

public class Timer {
    private Timer$TimerImpl impl;
    private Object finalizer = new Timer$1(this);

    public Timer(boolean bl) {
        this.impl = new Timer$TimerImpl(bl);
    }

    public Timer() {
        this.impl = new Timer$TimerImpl(false);
    }

    public void cancel() {
        this.impl.cancel();
    }

    public void schedule(TimerTask timerTask, Date date) {
        if (date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l = date.getTime() - System.currentTimeMillis();
        this.scheduleImpl(timerTask, l < 0L ? 0L : l, -1L, false);
    }

    public void schedule(TimerTask timerTask, long l) {
        if (l < 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(timerTask, l, -1L, false);
    }

    public void schedule(TimerTask timerTask, long l, long l2) {
        if (l < 0L || l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(timerTask, l, l2, false);
    }

    public void schedule(TimerTask timerTask, Date date, long l) {
        if (l <= 0L || date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l2 = date.getTime() - System.currentTimeMillis();
        this.scheduleImpl(timerTask, l2 < 0L ? 0L : l2, l, false);
    }

    public void scheduleAtFixedRate(TimerTask timerTask, long l, long l2) {
        if (l < 0L || l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(timerTask, l, l2, true);
    }

    public void scheduleAtFixedRate(TimerTask timerTask, Date date, long l) {
        if (l <= 0L || date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l2 = date.getTime() - System.currentTimeMillis();
        this.scheduleImpl(timerTask, l2 < 0L ? 0L : l2, l, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void scheduleImpl(TimerTask timerTask, long l, long l2, boolean bl) {
        Timer$TimerImpl timer$TimerImpl = this.impl;
        synchronized (timer$TimerImpl) {
            if (Timer$TimerImpl.access$1(this.impl)) {
                throw new IllegalStateException(Msg.getString("K00f3"));
            }
            long l3 = l + System.currentTimeMillis();
            if (l3 < 0L) {
                throw new IllegalArgumentException(Msg.getString("K00f5"));
            }
            if (timerTask.isScheduled()) {
                throw new IllegalStateException(Msg.getString("K00f6"));
            }
            if (timerTask.isCancelled()) {
                throw new IllegalStateException(Msg.getString("K00f7"));
            }
            timerTask.when = l3;
            timerTask.period = l2;
            timerTask.fixedRate = bl;
            Timer$TimerImpl.access$2(this.impl, timerTask);
        }
    }

    static /* synthetic */ Timer$TimerImpl access$0(Timer timer) {
        return timer.impl;
    }
}

