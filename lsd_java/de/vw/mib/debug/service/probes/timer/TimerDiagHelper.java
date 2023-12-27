/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.timer;

import de.vw.mib.debug.common.probes.timer.TimerProbeConfiguration;
import de.vw.mib.debug.service.probes.timer.TimerCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.timer.diag.TimerDiag;
import de.vw.mib.timer.diag.TimerDiagInfo;

public class TimerDiagHelper
implements TimerDiag {
    private final ProbeSystemServices probeSystemServices;
    private final TimerProbeConfiguration config;

    TimerDiagHelper(ProbeSystemServices probeSystemServices) {
        this.config = (TimerProbeConfiguration)probeSystemServices.getConfiguration();
        this.probeSystemServices = probeSystemServices;
    }

    @Override
    public void configureTimer(TimerDiagInfo timerDiagInfo) {
        if (!this.config.isTraceTimerConfiguration()) {
            return;
        }
        TimerCodec timerCodec = (TimerCodec)this.probeSystemServices.borrowCodec();
        timerCodec.encodeConfigureTimer(timerDiagInfo);
        this.probeSystemServices.releaseCodec(timerCodec);
    }

    @Override
    public void createTimer(TimerDiagInfo timerDiagInfo) {
        if (!this.config.isTraceTimerCreation()) {
            return;
        }
        TimerCodec timerCodec = (TimerCodec)this.probeSystemServices.borrowCodec();
        timerCodec.encodeCreateTimer(timerDiagInfo);
        this.probeSystemServices.releaseCodec(timerCodec);
    }

    @Override
    public void resumeTimer(TimerDiagInfo timerDiagInfo) {
        if (!this.config.isTraceTimerControlling()) {
            return;
        }
        TimerCodec timerCodec = (TimerCodec)this.probeSystemServices.borrowCodec();
        timerCodec.encodeResumeTimer(timerDiagInfo);
        this.probeSystemServices.releaseCodec(timerCodec);
    }

    @Override
    public void startTimer(TimerDiagInfo timerDiagInfo) {
        if (!this.config.isTraceTimerControlling()) {
            return;
        }
        TimerCodec timerCodec = (TimerCodec)this.probeSystemServices.borrowCodec();
        timerCodec.encodeStartTimer(timerDiagInfo);
        this.probeSystemServices.releaseCodec(timerCodec);
    }

    @Override
    public void stopTimer(TimerDiagInfo timerDiagInfo) {
        if (!this.config.isTraceTimerControlling()) {
            return;
        }
        TimerCodec timerCodec = (TimerCodec)this.probeSystemServices.borrowCodec();
        timerCodec.encodeStopTimer(timerDiagInfo);
        this.probeSystemServices.releaseCodec(timerCodec);
    }

    @Override
    public void suspendTimer(TimerDiagInfo timerDiagInfo) {
        if (!this.config.isTraceTimerControlling()) {
            return;
        }
        TimerCodec timerCodec = (TimerCodec)this.probeSystemServices.borrowCodec();
        timerCodec.encodeSuspendTimer(timerDiagInfo);
        this.probeSystemServices.releaseCodec(timerCodec);
    }

    @Override
    public void timerExecuted(TimerDiagInfo timerDiagInfo) {
        if (!this.config.isTraceTimerExecution()) {
            return;
        }
        TimerCodec timerCodec = (TimerCodec)this.probeSystemServices.borrowCodec();
        timerCodec.encodeTimerExecuted(timerDiagInfo);
        this.probeSystemServices.releaseCodec(timerCodec);
    }

    @Override
    public void timerUpdated(TimerDiagInfo timerDiagInfo) {
        if (!this.config.isTraceTimerThreadUpdates()) {
            return;
        }
        TimerCodec timerCodec = (TimerCodec)this.probeSystemServices.borrowCodec();
        timerCodec.encodeTimerUpdated(timerDiagInfo);
        this.probeSystemServices.releaseCodec(timerCodec);
    }
}

