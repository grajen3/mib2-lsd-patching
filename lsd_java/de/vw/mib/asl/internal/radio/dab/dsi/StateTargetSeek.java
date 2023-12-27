/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;

public final class StateTargetSeek
extends AbstractState {
    private final Logger logger = ServiceManager.logger;
    private static final long TIMEOUT;
    private final int SEEK_UP;
    private final int SEEK_DOWN;
    private int mMode;
    private final HsmDabDsi mDsiHsm;
    private boolean mStopAtNext = false;
    private EnsembleInfo mFoundEnsemble = null;
    boolean mTuneStation;

    public StateTargetSeek(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
        this.SEEK_UP = 10;
        this.SEEK_DOWN = 11;
        this.mDsiHsm = hsmDabDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        return this.handleSeekEnsemble(eventGeneric);
    }

    private HsmState handleSeekEnsemble(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateTargetSeek is active with Incoming eventid - ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("StateTargetSeek - HSM_START").log();
                }
                this.mTarget.mCurrentEvent.setBlocked(true);
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
                int n = this.mTarget.mCurrentEvent.getInt(0);
                this.mMode = n == 1 ? 10 : 11;
                this.mStopAtNext = this.mTarget.mCurrentEvent.getBoolean(2);
                GuiApiTunerCommon.updateSeekActive(true);
                this.mDsiHsm.mDsiDabTuner.seekService(this.mMode);
                this.mTarget.mCurrentEvent.setObject(DabDsiApi.P_FOUND_FREQUENCY, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo());
                this.mTarget.mCurrentEvent.setObject(DabDsiApi.P_FOUND_ENSEMBLE, this.mFoundEnsemble);
                break;
            }
            case 4: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("StateTargetSeek - HSM_EXIT").log();
                }
                GuiApiTunerCommon.updateSeekActive(false);
                hsmState = super.handle(eventGeneric);
                break;
            }
            case 100008: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("StateTargetSeek - EV_DAB_ASL_STOP_TARGET_SEEK").log();
                }
                this.abortSeek();
                break;
            }
            case 100007: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("StateTargetSeek - EV_DAB_ASL_STOP_TARGET_SEEK_AT_NEXT").log();
                }
                this.debugOut(' ', "stop targetSeek at next ensemble");
                this.mStopAtNext = true;
                break;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100009: 
            case 100010: 
            case 100016: 
            case 100104: 
            case 100106: 
            case 100113: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("StateTargetSeek with event id - ").append(eventGeneric.getReceiverEventId()).log();
                }
                eventGeneric.setResult(1);
                break;
            }
            case 100012: 
            case 100021: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("StateTargetSeek - EV_DAB_ASL_STOP_TARGET_SEEK_AT_NEXT").append(eventGeneric.getReceiverEventId()).log();
                }
                this.abortSeek();
                return this.myParent;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    private void abortSeek() {
        this.debugOut('>', "abort");
        this.startAbortTimeout();
        this.mDsiHsm.mDsiDabTuner.seekService(4);
    }

    public void dsiDABTunerSeekServiceStatus(int n) {
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("StateTargetSeek - dsiDABTunerSeekServiceStatus").append(n).log();
        }
        switch (n) {
            case 1: {
                this.mTuneStation = true;
                this.mFoundEnsemble = null;
                break;
            }
            case 2: {
                this.debugOut('|', "aborted");
                this.mTarget.mCurrentEvent.setObject(DabDsiApi.P_FOUND_FREQUENCY, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo());
                this.mTarget.mCurrentEvent.setObject(DabDsiApi.P_FOUND_ENSEMBLE, this.mFoundEnsemble);
                this.mTarget.sendResult(this.mTarget.mCurrentEvent, 11);
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 0: 
            case 4: {
                this.logFailure();
                this.mTarget.mCurrentEvent.setObject(DabDsiApi.P_FOUND_FREQUENCY, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo());
                this.mTarget.mCurrentEvent.setObject(DabDsiApi.P_FOUND_ENSEMBLE, this.mFoundEnsemble);
                this.mTarget.sendResult(this.mTarget.mCurrentEvent, 12);
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 3: {
                if (this.mStopAtNext) {
                    this.mTarget.mCurrentEvent.setObject(DabDsiApi.P_FOUND_FREQUENCY, RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo());
                    this.mTarget.mCurrentEvent.setObject(DabDsiApi.P_FOUND_ENSEMBLE, this.mFoundEnsemble);
                    this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
                    this.trans(this.mTarget.stateIdle);
                    break;
                }
                this.retriggerTimeout();
                this.mDsiHsm.mDsiDabTuner.seekService(this.mMode);
                break;
            }
        }
    }

    public HsmState dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("StateTargetSeek - dsiDABTunerUpdateSelectedFrequency").append(frequencyInfo).log();
        }
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfo)) {
            return null;
        }
        RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
        DabMainApi.notifyCurrentStationInfo(frequencyInfo, null, null, null);
        this.retriggerTimeout();
        return this.myParent;
    }

    public HsmState dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return null;
        }
        if (ensembleInfo.ensID > 0) {
            this.mFoundEnsemble = ensembleInfo;
            DabTunerState.correctEmptyLabels(this.mFoundEnsemble);
        } else {
            this.mFoundEnsemble = null;
        }
        return this.myParent;
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

    @Override
    long getTimeout() {
        return 0;
    }
}

