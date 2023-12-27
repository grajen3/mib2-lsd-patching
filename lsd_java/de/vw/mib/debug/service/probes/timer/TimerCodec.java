/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.timer;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.timer.diag.TimerDiagInfo;

public final class TimerCodec
extends AbstractProbeCodec {
    public TimerCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encodeConfigureTimer(TimerDiagInfo timerDiagInfo) {
        BinaryMessage binaryMessage = this.appendHeader((byte)3, timerDiagInfo);
        binaryMessage.append(timerDiagInfo.getDelay());
        binaryMessage.append(timerDiagInfo.isRepeat());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getRunnable()).toString());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getInvoker()).toString());
        binaryMessage.send();
    }

    public void encodeCreateTimer(TimerDiagInfo timerDiagInfo) {
        BinaryMessage binaryMessage = this.appendHeader((byte)2, timerDiagInfo);
        binaryMessage.send();
    }

    public void encodeResumeTimer(TimerDiagInfo timerDiagInfo) {
        BinaryMessage binaryMessage = this.appendHeader((byte)9, timerDiagInfo);
        binaryMessage.append(timerDiagInfo.getDelay());
        binaryMessage.append(timerDiagInfo.isRepeat());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getRunnable()).toString());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getInvoker()).toString());
        binaryMessage.send();
    }

    public void encodeStartTimer(TimerDiagInfo timerDiagInfo) {
        BinaryMessage binaryMessage = this.appendHeader((byte)4, timerDiagInfo);
        binaryMessage.append(timerDiagInfo.getDelay());
        binaryMessage.append(timerDiagInfo.isRepeat());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getRunnable()).toString());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getInvoker()).toString());
        binaryMessage.send();
    }

    public void encodeStopTimer(TimerDiagInfo timerDiagInfo) {
        BinaryMessage binaryMessage = this.appendHeader((byte)5, timerDiagInfo);
        binaryMessage.append(timerDiagInfo.getDelay());
        binaryMessage.append(timerDiagInfo.isRepeat());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getRunnable()).toString());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getInvoker()).toString());
        binaryMessage.send();
    }

    public void encodeSuspendTimer(TimerDiagInfo timerDiagInfo) {
        BinaryMessage binaryMessage = this.appendHeader((byte)8, timerDiagInfo);
        binaryMessage.append(timerDiagInfo.getDelay());
        binaryMessage.append(timerDiagInfo.isRepeat());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getRunnable()).toString());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getInvoker()).toString());
        binaryMessage.send();
    }

    public void encodeTimerExecuted(TimerDiagInfo timerDiagInfo) {
        BinaryMessage binaryMessage = this.appendHeader((byte)7, timerDiagInfo);
        binaryMessage.append(timerDiagInfo.getDelay());
        binaryMessage.append(timerDiagInfo.isRepeat());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getRunnable()).toString());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getInvoker()).toString());
        binaryMessage.send();
    }

    public void encodeTimerUpdated(TimerDiagInfo timerDiagInfo) {
        BinaryMessage binaryMessage = this.appendHeader((byte)6, timerDiagInfo);
        binaryMessage.append(timerDiagInfo.getDelay());
        binaryMessage.append(timerDiagInfo.isRepeat());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getRunnable()).toString());
        binaryMessage.append(new StringBuffer().append("").append(timerDiagInfo.getInvoker()).toString());
        binaryMessage.send();
    }

    private BinaryMessage appendHeader(byte by, TimerDiagInfo timerDiagInfo) {
        BinaryMessage binaryMessage = this.createMessage(by);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(timerDiagInfo.getName());
        binaryMessage.append(timerDiagInfo.getId());
        return binaryMessage;
    }

    @Override
    protected byte getCodecVersion() {
        return -3;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 59;
    }

    @Override
    protected short getMessageType() {
        return 277;
    }
}

