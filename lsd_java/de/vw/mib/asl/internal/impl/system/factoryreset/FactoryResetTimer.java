/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimer$1;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimer$TimeoutListener;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

class FactoryResetTimer {
    private static final String CALLBACK_TIMEOUT_NAME;
    private Timer currentTimer = null;
    private final Invoker timerInvoker;
    private final TimerManager timerManager;

    FactoryResetTimer(Invoker invoker, TimerManager timerManager) {
        Preconditions.checkArgumentNotNull(timerManager);
        Preconditions.checkArgumentNotNull(invoker);
        this.timerInvoker = invoker;
        this.timerManager = timerManager;
    }

    void startTimer(long l, FactoryResetTimer$TimeoutListener factoryResetTimer$TimeoutListener) {
        Preconditions.checkArgumentNotNull(factoryResetTimer$TimeoutListener);
        if (l < 1L) {
            throw new IllegalArgumentException("The factory reset timeout must be at least 1ms.");
        }
        if (this.currentTimer != null) {
            throw new IllegalStateException("Another timeout is in progress.");
        }
        this.currentTimer = this.timerManager.createTimer("AslSystemFactoryResetTimerCallbackTimeout", l, false, this.createTimeoutRunnable(factoryResetTimer$TimeoutListener), this.timerInvoker);
        this.currentTimer.start();
    }

    void stopTimer() {
        if (this.currentTimer != null) {
            this.currentTimer.stop();
        }
        this.currentTimer = null;
    }

    private Runnable createTimeoutRunnable(FactoryResetTimer$TimeoutListener factoryResetTimer$TimeoutListener) {
        return new FactoryResetTimer$1(this, factoryResetTimer$TimeoutListener);
    }
}

