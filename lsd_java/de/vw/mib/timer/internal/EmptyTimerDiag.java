/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.timer.diag.TimerDiag;
import de.vw.mib.timer.diag.TimerDiagInfo;

final class EmptyTimerDiag
implements TimerDiag {
    EmptyTimerDiag() {
    }

    @Override
    public void timerExecuted(TimerDiagInfo timerDiagInfo) {
    }

    @Override
    public void createTimer(TimerDiagInfo timerDiagInfo) {
    }

    @Override
    public void resumeTimer(TimerDiagInfo timerDiagInfo) {
    }

    @Override
    public void startTimer(TimerDiagInfo timerDiagInfo) {
    }

    @Override
    public void stopTimer(TimerDiagInfo timerDiagInfo) {
    }

    @Override
    public void suspendTimer(TimerDiagInfo timerDiagInfo) {
    }

    @Override
    public void timerUpdated(TimerDiagInfo timerDiagInfo) {
    }

    @Override
    public void configureTimer(TimerDiagInfo timerDiagInfo) {
    }
}

