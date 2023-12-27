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

public final class StateDdsUsed
extends AbstractState {
    private int mDdsFrequency = 0;
    private int mCumulatedSteps = 0;
    private final long TIMEOUT;
    private EnsembleInfo mFoundEnsemble;
    boolean mTuneStation;
    boolean mAborted = false;

    StateDdsUsed(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
        this.TIMEOUT = 0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDdsUsed is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        super.handle(eventGeneric);
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
                this.mAborted = false;
                int n = 0;
                if (this.mDdsFrequency <= 0) {
                    this.mDdsFrequency = RadioData.getDabDatabase().mTunerState.getFrequencyIndex();
                }
                int n2 = this.mTarget.mCurrentEvent.getInt(0);
                this.mDdsFrequency = n = RadioData.getDabDatabase().mTunerState.getFrequencyForTicks(n2, this.mDdsFrequency);
                this.tuneFrequency(n);
                FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getNearest(n);
                RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
                DabMainApi.notifyCurrentStationInfo(frequencyInfo, null, null, null);
                RadioData.getDabDatabase().dabPresetList.setCurrentSelectedPreset(null);
                this.mTarget.mCurrentEvent = null;
                break;
            }
            case 100106: {
                if (this.hasFailed()) break;
                int n = eventGeneric.getInt(0);
                int n3 = RadioData.getDabDatabase().mTunerState.getFrequencyForTicks(n, this.mDdsFrequency);
                FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getNearest(n3);
                this.mDdsFrequency = n3;
                this.mCumulatedSteps += n;
                RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
                DabMainApi.notifyCurrentStationInfo(frequencyInfo, null, null, null);
                break;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100009: 
            case 100010: 
            case 100016: 
            case 100021: 
            case 100113: {
                this.mTuneStation = false;
                this.abortTuneFrequency();
                return this.myParent;
            }
            case 4: {
                this.mDdsFrequency = 0;
                this.mCumulatedSteps = 0;
                hsmState = super.handle(eventGeneric);
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    private void tuneFrequency(int n) {
        FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getNearest(n);
        RadioData.getDabDatabase().mTunerState.setFrequencyAsCurrentProgram(frequencyInfo);
        this.mTarget.mDsiDabTuner.tuneEnsemble(2, 0, 0, frequencyInfo.frequency);
    }

    public void dsiDABTunerTuneEnsembleStatus(int n) {
        switch (n) {
            case 3: {
                if (this.mTarget.mNextEvent == null) {
                    if (this.mCumulatedSteps != 0) {
                        if (!this.mAborted) {
                            this.tuneFrequency(this.mDdsFrequency);
                            this.mCumulatedSteps = 0;
                            this.retriggerTimeout();
                            break;
                        }
                        if (!this.mTuneStation) break;
                        if (this.mFoundEnsemble == null || !this.mTarget.tuneFirstService(this.mFoundEnsemble, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo())) {
                            DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), this.mFoundEnsemble);
                        }
                        this.trans(this.mTarget.stateIdle);
                        break;
                    }
                    if (this.mTuneStation && (this.mFoundEnsemble == null || !this.mTarget.tuneFirstService(this.mFoundEnsemble, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo()))) {
                        DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), this.mFoundEnsemble);
                    }
                    this.trans(this.mTarget.stateIdle);
                    break;
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 2: {
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 1: {
                this.mFoundEnsemble = null;
                this.mTuneStation = true;
                this.retriggerTimeout();
                break;
            }
            default: {
                this.logFailure(this.mTarget.tuneEnsembleStatusToString(n));
                DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), this.mFoundEnsemble);
                this.trans(this.mTarget.stateIdle);
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
        this.mAborted = true;
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
}

