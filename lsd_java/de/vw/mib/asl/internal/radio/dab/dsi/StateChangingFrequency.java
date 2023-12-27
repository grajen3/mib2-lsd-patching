/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;

public final class StateChangingFrequency
extends AbstractState {
    private static final long TIMEOUT;
    private int mDirection;
    private boolean mWrap;
    private boolean stopTuneEnsemble = false;
    private EnsembleInfo mFoundEnsemble = null;

    StateChangingFrequency(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateChangingFrequency is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
                this.mDirection = this.mTarget.mCurrentEvent.getInt(0);
                this.mWrap = this.mTarget.mCurrentEvent.getBoolean(1);
                this.stopTuneEnsemble = false;
                RadioData.getDabDatabase().dabPresetList.setCurrentSelectedPreset(null);
                this.tune();
                break;
            }
            case 100005: {
                this.stopTuneEnsemble = true;
                break;
            }
            case 100009: 
            case 100113: {
                this.stopTuneEnsemble = true;
                return this.myParent;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100010: 
            case 100104: {
                this.stopTuneEnsemble = true;
                eventGeneric.setResult(1);
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    private void tune() {
        this.debugOut('>', "tune");
        FrequencyInfo frequencyInfo = null;
        frequencyInfo = this.mDirection == 1 ? RadioData.getDabDatabase().mTunerState.setNextFrequencyAsCurrentProgram(this.mWrap) : RadioData.getDabDatabase().mTunerState.setPreviousFrequencyAsCurrentProgram(this.mWrap);
        if (frequencyInfo != null) {
            this.mTarget.mDsiDabTuner.tuneEnsemble(2, 0, 0, frequencyInfo.frequency);
            RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
            DabMainApi.notifyCurrentStationInfo(frequencyInfo, null, null, null);
        } else {
            this.trans(this.mTarget.stateIdle);
        }
    }

    public void dsiDABTunerTuneEnsembleStatus(int n) {
        switch (n) {
            case 1: {
                this.mFoundEnsemble = null;
                break;
            }
            case 0: 
            case 4: 
            case 5: 
            case 6: {
                this.failed();
                this.logFailure(this.mTarget.tuneEnsembleStatusToString(n));
                DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), this.mFoundEnsemble);
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 2: 
            case 3: {
                if (!this.stopTuneEnsemble) {
                    this.tune();
                    this.retriggerTimeout();
                    break;
                }
                if (this.mFoundEnsemble == null || !this.mTarget.tuneFirstService(this.mFoundEnsemble, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo())) {
                    DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), this.mFoundEnsemble);
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
        }
    }

    public void dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfo)) {
            return;
        }
        DabRadioSlsApi.notifyStationSelected();
        if (this.mFoundEnsemble != null && (long)this.mFoundEnsemble.frequencyValue != frequencyInfo.frequency) {
            this.mFoundEnsemble = null;
        }
    }

    public void dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return;
        }
        if (ensembleInfo.ensID > 0) {
            this.mFoundEnsemble = ensembleInfo;
            DabTunerState.correctEmptyLabels(this.mFoundEnsemble);
        } else {
            this.mFoundEnsemble = null;
        }
    }

    @Override
    long getTimeout() {
        return 0;
    }

    private void abortTuneFrequency() {
        this.mTarget.trace("---> cancel ");
        this.mTarget.mDsiDabTuner.tuneEnsemble(3, 0, 0, 0L);
    }

    @Override
    protected String dsiRequestToString() {
        return "tuneEnsemble(DSIDABTuner.TUNEENSEMBLEMODE_FREQUENCY )";
    }

    @Override
    protected String dsiAbortRequestToString() {
        return "tuneEnsemble(DSIDABTuner.TUNEENSEMBLEMODE_ABORT )";
    }

    @Override
    protected boolean abort() {
        this.abortTuneFrequency();
        return true;
    }
}

