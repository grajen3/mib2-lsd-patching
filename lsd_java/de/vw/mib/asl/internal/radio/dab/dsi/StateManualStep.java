/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;

public final class StateManualStep
extends AbstractState {
    private static final long TIMEOUT;
    EnsembleInfo mFoundEnsemble = null;
    private FrequencyInfo manualModeFrequency = null;
    private FrequencyInfo updatedFrequency = null;
    private boolean manualModeDsiRequestActive = false;

    StateManualStep(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateManualStep is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                GuiApiDab.setUpdateStationInfoBlocked(true);
                this.manualModeDsiRequestActive = false;
                this.setManualModeFrequency(null);
                FrequencyInfo frequencyInfo = null;
                frequencyInfo = this.mTarget.isManualModeStepDirectionUp() ? RadioData.getDabDatabase().mTunerState.setNextFrequencyAsCurrentProgram(true) : RadioData.getDabDatabase().mTunerState.setPreviousFrequencyAsCurrentProgram(true);
                RadioData.getDabDatabase().dabPresetList.setCurrentSelectedPreset(null);
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                if (frequencyInfo == null) {
                    this.trans(this.mTarget.stateIdle);
                    break;
                }
                this.manualModeTuneEnsemble(frequencyInfo);
                break;
            }
            case 100004: 
            case 100006: 
            case 100009: 
            case 100010: 
            case 100016: 
            case 100021: 
            case 100106: 
            case 100113: {
                this.manualModeDsiRequestActive = false;
                this.abortTuneFrequency();
                return this.myParent;
            }
            case 100003: {
                FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.setPreviousFrequencyAsCurrentProgram(true);
                this.manualModeTuneEnsemble(frequencyInfo);
                break;
            }
            case 100002: {
                FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.setNextFrequencyAsCurrentProgram(true);
                this.manualModeTuneEnsemble(frequencyInfo);
                break;
            }
            case 4: {
                this.manualModeDsiRequestActive = false;
                if (null != this.getManualModeFrequency()) {
                    this.manualModeTuneEnsemble(this.getManualModeFrequency());
                }
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(false);
                GuiApiDab.setUpdateStationInfoBlocked(false);
                hsmState = super.handle(eventGeneric);
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    public void dsiDABTunerTuneEnsembleStatus(int n) {
        switch (n) {
            case 1: {
                this.mFoundEnsemble = null;
                this.manualModeDsiRequestActive = true;
                break;
            }
            case 2: {
                if (!this.hasFailed()) {
                    if (this.manualModeDsiRequestActive) {
                        if (this.mFoundEnsemble == null || !this.mTarget.tuneFirstService(this.mFoundEnsemble, this.updatedFrequency)) {
                            DabMainApi.notifyFrequencyTuneDone(this.updatedFrequency, this.mFoundEnsemble);
                        }
                    } else {
                        this.mTarget.tuneLastProgram();
                    }
                }
                this.manualModeDsiRequestActive = false;
                this.setManualModeFrequency(null);
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 0: 
            case 4: 
            case 5: 
            case 6: {
                this.manualModeDsiRequestActive = false;
                if (null != this.getManualModeFrequency()) {
                    this.manualModeTuneEnsemble(this.getManualModeFrequency());
                    break;
                }
                this.failed();
                this.logFailure(this.mTarget.tuneEnsembleStatusToString(n));
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 3: {
                this.manualModeDsiRequestActive = false;
                if (null != this.getManualModeFrequency()) {
                    this.manualModeTuneEnsemble(this.getManualModeFrequency());
                    break;
                }
                GuiApiDab.setUpdateStationInfoBlocked(false);
                if (this.mFoundEnsemble == null || !this.mTarget.tuneFirstService(this.mFoundEnsemble, this.updatedFrequency)) {
                    DabMainApi.notifyFrequencyTuneDone(this.updatedFrequency, this.mFoundEnsemble);
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            default: {
                this.manualModeDsiRequestActive = false;
            }
        }
    }

    public void dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfo)) {
            return;
        }
        this.updatedFrequency = frequencyInfo != null && frequencyInfo.getFrequency() > 0L ? frequencyInfo : null;
    }

    public HsmState dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return null;
        }
        if (null != ensembleInfo && ensembleInfo.ensID > 0) {
            this.mFoundEnsemble = ensembleInfo;
            DabTunerState.correctEmptyLabels(this.mFoundEnsemble);
        } else {
            this.mFoundEnsemble = null;
        }
        return this.myParent;
    }

    @Override
    long getTimeout() {
        return 0;
    }

    private void abortTuneFrequency() {
        this.startAbortTimeout();
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

    public void manualModeTuneEnsemble(FrequencyInfo frequencyInfo) {
        try {
            if (null != frequencyInfo) {
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
                RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
                GuiApiDab.setUpdateStationInfoBlocked(false);
                DabMainApi.notifyCurrentStationInfo(frequencyInfo, null, null, null);
                GuiApiDab.setUpdateStationInfoBlocked(true);
                if (this.manualModeDsiRequestActive) {
                    this.setManualModeFrequency(frequencyInfo);
                } else {
                    this.mTarget.mDsiDabTuner.tuneEnsemble(2, 0, 0, frequencyInfo.frequency);
                    this.setManualModeFrequency(null);
                }
            } else {
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(false);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public FrequencyInfo getManualModeFrequency() {
        return this.manualModeFrequency;
    }

    public void setManualModeFrequency(FrequencyInfo frequencyInfo) {
        this.manualModeFrequency = frequencyInfo;
    }
}

