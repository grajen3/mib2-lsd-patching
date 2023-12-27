/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabPrepareAudio
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private static boolean getAudioConnectionDabFirstTime = true;

    public StateDabPrepareAudio(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabPrepareAudio is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger.trace(4).append("StateDabPrepareAudio - HSM_START - mTarget.isAudioAvailable() = ").append(this.mTarget.isAudioAvailable()).log();
                }
                if (!this.mTarget.isAudioAvailable()) break;
                AudioConnectionUtils.requestAudioConnectionForBand(RadioCurrentWaveband.get(), this.mTarget, 1753678080);
                break;
            }
            case 100200: {
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger.trace(4).append("StateDabPrepareAudio - EV_DAB_ASL_ANSWER_REQUEST_AUDIO_CONNECTION - ev.getResult() = ").append(eventGeneric.getResult()).log();
                }
                if (eventGeneric.getResult() != 0) {
                    this.mTarget.sendAnswer(16);
                    this.trans(this.mTarget.stateDabInactive);
                    break;
                }
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("Radio DAB PrepareTuning: got audio connection -> activate tuner!").log();
                }
                if (getAudioConnectionDabFirstTime) {
                    getAudioConnectionDabFirstTime = false;
                    if (ServiceManager.perfService != null) {
                        ServiceManager.perfService.performanceLogMsgByID(14);
                    }
                }
                if (this.mTarget.isDeactivated()) {
                    this.trans(this.mTarget.stateDabInactive);
                    this.mTarget.sendAnswer(0);
                    break;
                }
                this.mTarget.setAudioRestored();
                this.trans(this.mTarget.stateDabPrepareTuner);
                break;
            }
            case 1400006: {
                this.trans(this.mTarget.stateDabInactive);
                break;
            }
            case 100240: {
                this.trans(this.mTarget.stateDabInactive);
                this.mTarget.setCurrentEvent(null);
                eventGeneric.setInt(0, 2);
                eventGeneric.setResult(0);
                break;
            }
            case 4: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

