/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.diag;

import de.vw.mib.timer.diag.TimerDiagInfo;

public interface TimerDiag {
    default public void configureTimer(TimerDiagInfo timerDiagInfo) {
    }

    default public void createTimer(TimerDiagInfo timerDiagInfo) {
    }

    default public void resumeTimer(TimerDiagInfo timerDiagInfo) {
    }

    default public void startTimer(TimerDiagInfo timerDiagInfo) {
    }

    default public void stopTimer(TimerDiagInfo timerDiagInfo) {
    }

    default public void suspendTimer(TimerDiagInfo timerDiagInfo) {
    }

    default public void timerExecuted(TimerDiagInfo timerDiagInfo) {
    }

    default public void timerUpdated(TimerDiagInfo timerDiagInfo) {
    }
}

