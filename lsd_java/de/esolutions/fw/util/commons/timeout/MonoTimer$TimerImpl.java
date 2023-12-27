/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

import de.esolutions.fw.util.commons.timeout.MonoTimer$TimerImpl$TimerHeap;
import de.esolutions.fw.util.commons.timeout.MonoTimerTask;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;

final class MonoTimer$TimerImpl
extends Thread {
    private boolean cancelled;
    private boolean finished;
    private MonoTimer$TimerImpl$TimerHeap tasks = new MonoTimer$TimerImpl$TimerHeap(null);

    MonoTimer$TimerImpl(String string, boolean bl) {
        this.setName(string);
        this.setDaemon(bl);
        this.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        while (true) {
            MonoTimerTask monoTimerTask;
            MonoTimer$TimerImpl monoTimer$TimerImpl = this;
            synchronized (monoTimer$TimerImpl) {
                long l;
                if (this.cancelled) {
                    return;
                }
                if (this.tasks.isEmpty()) {
                    if (this.finished) {
                        return;
                    }
                    try {
                        super.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                    continue;
                }
                long l2 = TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
                monoTimerTask = this.tasks.minimum();
                Object object = monoTimerTask.lock;
                synchronized (object) {
                    if (monoTimerTask.cancelled) {
                        this.tasks.delete(0);
                        continue;
                    }
                    l = monoTimerTask.when - l2;
                }
                if (l > 0L) {
                    try {
                        super.wait(l);
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                    continue;
                }
                object = monoTimerTask.lock;
                synchronized (object) {
                    int n = 0;
                    if (this.tasks.minimum().when != monoTimerTask.when) {
                        n = MonoTimer$TimerImpl$TimerHeap.access$100(this.tasks, monoTimerTask);
                    }
                    if (monoTimerTask.cancelled) {
                        this.tasks.delete(MonoTimer$TimerImpl$TimerHeap.access$100(this.tasks, monoTimerTask));
                        continue;
                    }
                    monoTimerTask.setScheduledTime(monoTimerTask.when);
                    this.tasks.delete(n);
                    if (monoTimerTask.period >= 0L) {
                        monoTimerTask.when = monoTimerTask.fixedRate ? (monoTimerTask.when += monoTimerTask.period) : TimeSourceProvider.getMonotonicTimeSource().getCurrentTime() + monoTimerTask.period;
                        this.insertTask(monoTimerTask);
                    } else {
                        monoTimerTask.when = 0L;
                    }
                }
            }
            boolean bl = false;
            try {
                monoTimerTask.run();
                bl = true;
                continue;
            }
            finally {
                if (bl) continue;
                MonoTimer$TimerImpl monoTimer$TimerImpl2 = this;
                synchronized (monoTimer$TimerImpl2) {
                    this.cancelled = true;
                }
                continue;
            }
            break;
        }
    }

    private void insertTask(MonoTimerTask monoTimerTask) {
        this.tasks.insert(monoTimerTask);
        super.notify();
    }

    public synchronized void cancel() {
        this.cancelled = true;
        this.tasks.reset();
        super.notify();
    }

    public int purge() {
        if (this.tasks.isEmpty()) {
            return 0;
        }
        MonoTimer$TimerImpl$TimerHeap.access$202(this.tasks, 0);
        this.tasks.deleteIfCancelled();
        return MonoTimer$TimerImpl$TimerHeap.access$200(this.tasks);
    }

    static /* synthetic */ boolean access$300(MonoTimer$TimerImpl monoTimer$TimerImpl) {
        return monoTimer$TimerImpl.cancelled;
    }

    static /* synthetic */ void access$400(MonoTimer$TimerImpl monoTimer$TimerImpl, MonoTimerTask monoTimerTask) {
        monoTimer$TimerImpl.insertTask(monoTimerTask);
    }
}

