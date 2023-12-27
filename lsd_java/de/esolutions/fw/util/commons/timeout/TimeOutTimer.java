/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

import de.esolutions.fw.util.commons.timeout.ITimeOutHandler;
import de.esolutions.fw.util.commons.timeout.MonoTimer;
import de.esolutions.fw.util.commons.timeout.MonoTimerTask;
import de.esolutions.fw.util.commons.timeout.TimeOutTimer$TimeOutTask;

public class TimeOutTimer {
    private static Object timerLock = new Object();
    private static MonoTimer timer = null;
    private static int timerUsers = 0;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TimeOutTimer() {
        Object object = timerLock;
        synchronized (object) {
            if (timerUsers == 0) {
                timer = new MonoTimer();
            }
            ++timerUsers;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancel() {
        Object object = timerLock;
        synchronized (object) {
            if (--timerUsers == 0) {
                timer.cancel();
                timer = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TimeOutTimer$TimeOutTask schedule(ITimeOutHandler iTimeOutHandler, long l) {
        TimeOutTimer$TimeOutTask timeOutTimer$TimeOutTask = new TimeOutTimer$TimeOutTask(Thread.currentThread(), iTimeOutHandler);
        Object object = timerLock;
        synchronized (object) {
            if (timer != null) {
                timer.schedule((MonoTimerTask)timeOutTimer$TimeOutTask, l);
            }
        }
        return timeOutTimer$TimeOutTask;
    }
}

