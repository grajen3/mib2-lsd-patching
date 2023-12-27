/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateJumpLearnMemory
extends AbstractState {
    private final int MODE_LM_UP;
    private final int MODE_LM_DOWN;
    private static final long TIMEOUT;
    private int mMode;
    private final HsmDabDsi mDsiHsm;
    private EnsembleInfo mFoundEnsemble = null;
    private boolean mRunning;
    private FrequencyInfo mCurrentFrequency = null;

    public StateJumpLearnMemory(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
        this.MODE_LM_UP = 8;
        this.MODE_LM_DOWN = 9;
        this.mDsiHsm = hsmDabDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        return this.handleSeekEnsemble(eventGeneric);
    }

    private HsmState handleSeekEnsemble(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateJumpLearnMemory is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mRunning = true;
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
                boolean bl = this.mTarget.mCurrentEvent.getBoolean(0);
                int n = this.mMode = bl ? 8 : 9;
                if (!ServiceManager.configManagerDiag.getTUNERDABsupportsJumpLmBoolean()) break;
                this.mDsiHsm.mDsiDabTuner.seekService(this.mMode);
                RadioData.getDabDatabase().dabPresetList.setCurrentSelectedPreset(null);
                DabRadioSlsApi.notifySearching();
                GuiApiTunerCommon.setDabRadioTextLoadingStateToLoading();
                GuiApiDab.updateDabSearching(true);
                RadioData.getDabDatabase().mTunerState.setCurrentService(null, null);
                HmiDabListViewApi.notifyJumpLmStarted();
                this.mCurrentFrequency = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo();
                break;
            }
            case 4: {
                GuiApiDab.updateDabSearching(false);
                hsmState = super.handle(eventGeneric);
                break;
            }
            case 100022: {
                boolean bl = eventGeneric.getBoolean(0);
                if ((!bl || this.mMode == 8) && (bl || this.mMode != 8)) break;
                this.abortSeek();
                break;
            }
            case 100025: {
                this.abortSeek();
                break;
            }
            case 100110: {
                boolean bl = eventGeneric.getBoolean(0);
                if ((!bl || this.mMode == 8) && (bl || this.mMode != 8)) break;
                this.abortSeek();
                break;
            }
            case 100008: {
                this.abortSeek();
                break;
            }
            case 100009: 
            case 100010: 
            case 100012: 
            case 100016: 
            case 100021: 
            case 100113: {
                this.abortSeek();
                hsmState = this.myParent;
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100106: {
                this.abortSeek();
                eventGeneric.setResult(1);
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    private void abortSeek() {
        this.debugOut('>', "abort");
        this.mDsiHsm.mDsiDabTuner.seekService(4);
        this.startAbortTimeout();
    }

    public void dsiDABTunerSeekServiceStatus(int n) {
        switch (n) {
            case 1: {
                this.mFoundEnsemble = null;
                break;
            }
            case 2: {
                this.debugOut('|', "aborted");
                if (!this.hasFailed() && this.mTarget.mNextEvent == null && !this.mTarget.tuneLsm()) {
                    DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), null);
                }
                HmiDabListViewApi.notifyJumpLmAborted();
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 0: 
            case 4: {
                this.failed();
                this.logFailure();
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 3: {
                if (this.mFoundEnsemble != null) {
                    RadioData.getDabDatabase().mTunerState.setCurrentService(null, null);
                    boolean bl = this.mMode == 8 ? this.mTarget.tuneFirstService(this.mFoundEnsemble, this.mCurrentFrequency) : this.mTarget.tuneLastService(this.mFoundEnsemble, this.mCurrentFrequency);
                    if (bl) {
                        RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
                        this.trans(this.mTarget.stateIdle);
                    } else {
                        this.retriggerTimeout();
                    }
                    this.mRunning = false;
                    break;
                }
                this.mTarget.tuneLsm();
                this.trans(this.mTarget.stateIdle);
                break;
            }
        }
    }

    void tuneNextEnsemble(int n) {
    }

    public HsmState dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfo)) {
            return null;
        }
        RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
        this.mCurrentFrequency = frequencyInfo;
        this.retriggerTimeout();
        return this.myParent;
    }

    public HsmState dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return null;
        }
        if (ensembleInfo.ensID > 0) {
            DabTunerState.correctEmptyLabels(ensembleInfo);
            this.mFoundEnsemble = ensembleInfo;
        }
        return this.myParent;
    }

    public void dsiDABTunerUpdateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        RadioData.getDabDatabase().mTunerState.setServiceList(serviceInfoArray);
        DabMainApi.notifyUpdateServiceList(serviceInfoArray);
        if (ServiceManager.logger.isTraceEnabled(256)) {
            RadioDabTraceUtil.dumpServiceList(this.mTarget.getTargetId());
        }
        if (!this.mRunning && this.mFoundEnsemble != null) {
            boolean bl = this.mMode == 8 ? this.mTarget.tuneFirstService(this.mFoundEnsemble, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo()) : this.mTarget.tuneLastService(this.mFoundEnsemble, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo());
            if (!bl) {
                this.retriggerTimeout();
                DabMainApi.notifyFrequencyTuneDone(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), this.mFoundEnsemble);
            } else {
                this.trans(this.mTarget.stateIdle);
            }
        }
    }

    @Override
    long getTimeout() {
        return 0;
    }

    @Override
    protected String dsiRequestToString() {
        return new StringBuffer().append("seekService(").append(this.mTarget.seekModesToString(this.mMode)).append(")").toString();
    }

    @Override
    protected String dsiAbortRequestToString() {
        return "seekService(SEEKSERVICEMODE_ABORT)";
    }

    @Override
    protected boolean abort() {
        this.abortSeek();
        return true;
    }
}

