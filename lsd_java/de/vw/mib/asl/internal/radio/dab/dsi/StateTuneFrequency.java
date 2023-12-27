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
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;

public final class StateTuneFrequency
extends AbstractState {
    private static final long TIMEOUT;
    private EnsembleInfo mFoundEnsemble = null;
    boolean mTuneStation = false;

    StateTuneFrequency(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateTuneFrequency is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                int n = this.mTarget.mCurrentEvent.getInt(0);
                FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getNearest(n);
                if (frequencyInfo != null) {
                    RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
                    RadioData.getDabDatabase().mTunerState.setFrequencyAsCurrentProgram(frequencyInfo);
                    RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
                    DabMainApi.notifyCurrentStationInfo(frequencyInfo, null, null, null);
                    this.mTarget.mDsiDabTuner.tuneEnsemble(2, 0, 0, frequencyInfo.frequency);
                    break;
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 100009: {
                this.mTuneStation = false;
                return this.myParent;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100010: 
            case 100016: 
            case 100021: 
            case 100106: 
            case 100113: {
                this.mTuneStation = false;
                this.abortTuneFrequency();
                return this.myParent;
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
                this.mTuneStation = true;
                break;
            }
            case 2: {
                this.debugOut('|', "aborted");
                if (!this.hasFailed()) {
                    if (this.mTuneStation) {
                        if (this.mFoundEnsemble == null || !this.mTarget.tuneFirstService(this.mFoundEnsemble, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo())) {
                            DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), this.mFoundEnsemble);
                        }
                    } else {
                        this.mTarget.tuneLastProgram();
                    }
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 0: 
            case 4: 
            case 5: 
            case 6: {
                this.logFailure();
                this.failed();
                this.trans(this.mTarget.stateIdle);
                DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), this.mFoundEnsemble);
                break;
            }
            case 3: {
                if (!(this.mTarget.mNextEvent != null || this.mFoundEnsemble != null && this.mTarget.tuneFirstService(this.mFoundEnsemble, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo()))) {
                    DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), this.mFoundEnsemble);
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
        }
    }

    public HsmState dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return null;
        }
        if (ensembleInfo.ensID > 0) {
            this.mFoundEnsemble = ensembleInfo;
            DabTunerState.correctEmptyLabels(this.mFoundEnsemble);
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
}

