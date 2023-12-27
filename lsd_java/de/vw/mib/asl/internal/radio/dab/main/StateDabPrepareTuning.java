/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabPrepareTuning
extends AbstractHsmState {
    private final HsmTarget mTarget;

    public StateDabPrepareTuning(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabPrepareTuning is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.dabActive = true;
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("Starting StateDabPrepareTuning").log();
                }
                RadioData.getDabDatabase().mAudioManager.resetAudioLock();
                GuiApiTunerCommon.setDabRadioTextLoadingStateToLoading();
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("Radio DAB PrepareTuning: requesting audio connection").log();
                }
                this.initializeTuner();
                this.trans(this.mTarget.stateDabPrepareAudio);
                break;
            }
            case 100241: {
                this.mTarget.setCurrentEvent(eventGeneric);
                break;
            }
            case 100240: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateDabPrepareTuning - DEVICE_DEACTIVATE received").log();
                }
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger.trace(4).append("StateDabPrepareTuning - DEVICE_DEACTIVATE received").log();
                }
                this.trans(this.mTarget.stateDabInactive);
                this.mTarget.setCurrentEvent(null);
                eventGeneric.setInt(0, 2);
                eventGeneric.setResult(0);
                break;
            }
            case 1400006: {
                this.trans(this.mTarget.stateDabInactive);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    void initializeTuner() {
        GuiApiDab.updateRadioText("");
        RadioCurrentWaveband.set(2);
        RadioData.getDabDatabase().mOptionLinking.notifyHMI();
        RadioData.getDabDatabase().mRadioTextSetupState.notifyHMI();
        if (null != this.mTarget.mDsiDabTuner) {
            this.mTarget.mDsiDabTuner.switchLinking(RadioData.getDabDatabase().mOptionLinking.getOption());
            int[] nArray = new int[]{1, 4, 33};
            this.mTarget.mDsiDabTuner.enableRadioTextPlus(nArray);
        }
    }
}

