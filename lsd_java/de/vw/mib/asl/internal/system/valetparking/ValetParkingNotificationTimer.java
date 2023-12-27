/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.valetparking.TimeoutListener;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingNotificationTimer$1;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public class ValetParkingNotificationTimer {
    private static final int CALLBACK_TIMEOUT;
    private static final String CALLBACK_TIMEOUT_NAME;
    private Timer currentTimer = null;
    private final Invoker timerInvoker;
    private final TimerManager timerManager;

    ValetParkingNotificationTimer(SystemServices systemServices) {
        if (systemServices == null) {
            throw new IllegalArgumentException("Mandatory argument must not be null");
        }
        this.timerInvoker = systemServices.getThreadSwitcher();
        this.timerManager = systemServices.getTimerManager();
    }

    void createTimeoutNotification(TimeoutListener timeoutListener) {
        if (timeoutListener == null) {
            throw new IllegalArgumentException("Listener is mandatory.");
        }
        if (this.currentTimer != null) {
            throw new IllegalStateException("Last timer must be stopped.");
        }
        this.currentTimer = this.timerManager.createTimer("AslSystemValetParkingServiceNotificationCallbackTimeout", 0, false, this.createTimeoutNotificationRunnable(timeoutListener), this.timerInvoker);
        this.currentTimer.start();
    }

    void stopTimer() {
        if (this.currentTimer != null) {
            this.currentTimer.stop();
        }
        this.currentTimer = null;
    }

    private Runnable createTimeoutNotificationRunnable(TimeoutListener timeoutListener) {
        return new ValetParkingNotificationTimer$1(this, timeoutListener);
    }
}

