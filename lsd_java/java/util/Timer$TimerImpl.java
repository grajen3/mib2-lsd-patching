/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Timer$TimerImpl$TimerNode;
import java.util.Timer$TimerImpl$TimerTree;
import java.util.TimerTask;

final class Timer$TimerImpl
extends Thread {
    private boolean cancelled = false;
    private boolean finished = false;
    private Timer$TimerImpl$TimerTree tasks = new Timer$TimerImpl$TimerTree();

    Timer$TimerImpl(boolean bl) {
        this.setDaemon(bl);
        this.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        while (true) {
            TimerTask timerTask;
            Timer$TimerImpl timer$TimerImpl = this;
            synchronized (timer$TimerImpl) {
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
                    catch (Exception exception) {}
                    continue;
                }
                long l = System.currentTimeMillis();
                Timer$TimerImpl$TimerNode timer$TimerImpl$TimerNode = this.tasks.minimum();
                timerTask = timer$TimerImpl$TimerNode.task;
                if (timerTask.isCancelled()) {
                    this.tasks.delete(timer$TimerImpl$TimerNode);
                    continue;
                }
                long l2 = timerTask.when - l;
                if (l2 > 0L) {
                    try {
                        super.wait(l2);
                    }
                    catch (Exception exception) {}
                    continue;
                }
                timerTask.setScheduledTime(timerTask.when);
                this.tasks.delete(timer$TimerImpl$TimerNode);
                if (timerTask.period >= 0L) {
                    timerTask.when = timerTask.fixedRate ? (timerTask.when += timerTask.period) : System.currentTimeMillis() + timerTask.period;
                    this.insertTask(timerTask);
                } else {
                    timerTask.when = 0L;
                }
            }
            try {
                timerTask.run();
                continue;
            }
            catch (Exception exception) {
                continue;
            }
            break;
        }
    }

    private void insertTask(TimerTask timerTask) {
        this.tasks.insert(new Timer$TimerImpl$TimerNode(timerTask));
        super.notify();
    }

    public synchronized void cancel() {
        this.cancelled = true;
        this.tasks = new Timer$TimerImpl$TimerTree();
        super.notify();
    }

    static /* synthetic */ void access$0(Timer$TimerImpl timer$TimerImpl, boolean bl) {
        timer$TimerImpl.finished = bl;
    }

    static /* synthetic */ boolean access$1(Timer$TimerImpl timer$TimerImpl) {
        return timer$TimerImpl.cancelled;
    }

    static /* synthetic */ void access$2(Timer$TimerImpl timer$TimerImpl, TimerTask timerTask) {
        timer$TimerImpl.insertTask(timerTask);
    }
}

