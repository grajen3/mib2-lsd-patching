/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmDefaultSettings;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreDone;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget;
import de.vw.mib.asl.internal.radio.tagging.TaggingApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public final class StateAmFmBandSwitch
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private AmFmStation mLastStation = null;
    private static boolean getAudioConnectionAmFmFirstTime = true;
    private final Logger logger = ServiceManager.logger;
    private int mLastWaveband;
    private static short tuningTrialAfterBandSwitch = (short)6;
    public static final short MAX_TUNING_TRIAL_AFTER_BAND_SWITCH;
    private boolean entertainmentManagerCancel;
    private boolean activateBandRequest = false;
    public static boolean manualModeWasActiveAfterBandSwitch;

    StateAmFmBandSwitch(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
        this.mLastStation = new AmFmStation();
        this.entertainmentManagerCancel = false;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmBandSwitch is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - HSM_ENTRY").log();
                }
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    this.logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - HSM_ENTRY").log();
                }
                this.mTarget.audioConnectionTunerLwExists = false;
                tuningTrialAfterBandSwitch = (short)6;
                this.initLastStation();
                this.entertainmentManagerCancel = false;
                break;
            }
            case 3: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - HSM_START").log();
                }
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    this.logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - HSM_START").log();
                }
                this.activateBandRequest = false;
                manualModeWasActiveAfterBandSwitch = false;
                SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                if (!StateAutostoreDone.suppressTuning) {
                    if (ManagerTarget.isRadioActive) {
                        Object object;
                        this.mLastWaveband = RadioCurrentWaveband.get();
                        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                            this.initLastStation();
                            if (RadioCurrentWaveband.isAm()) {
                                AmFmFactory.getAslAmfmModelController().updateFmRadiotextAndState("", 2);
                            }
                        }
                        if (this.logger.isTraceEnabled(128) && null != this.mLastStation) {
                            object = this.logger.trace(128);
                            object.append(RadioUtil.LOG_PREFIX_AMFM).append("prepare tuning of: ").append(this.mLastStation.toLogString((LogMessage)object)).append(",Band: ").append(this.mLastWaveband).log();
                        }
                        if (ServiceManager.logger2.isTraceEnabled(4)) {
                            ServiceManager.logger2.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("prepare tuning, requesting audio connection").log();
                        }
                        if (this.mLastWaveband == 0 || this.mLastWaveband == 1) {
                            AudioConnectionUtils.requestAudioConnectionForBand(this.mLastWaveband, this.mTarget, -1769537280);
                        }
                        RadioCurrentWaveband.set(this.mLastWaveband);
                        RadioData.getAmfmDatabase().notifyStationChanged(this.mLastStation);
                        AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(this.mLastStation);
                        AmFmPresetApi.initializePresetBankForBand();
                        RadioData.getAmfmDatabase().updateStationListToBap();
                        AmFmFactory.getAslAmfmModelController().updateFmViewState(RadioData.getAmfmDatabase().getSettingsPersistable().getFmViewState());
                        AmFmFactory.getAslAmfmModelController().updateAmViewState(RadioData.getAmfmDatabase().getSettingsPersistable().getAmViewState());
                        try {
                            if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (object = RadioServiceManager.getServiceManager().getTileStationList())) break;
                            ((TileStationList)object).initTiles();
                        }
                        catch (Exception exception) {
                            ServiceManager.errorHandler.handleError(exception);
                        }
                        break;
                    }
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmActivePrepareTuning - HSM_START: ManagerTarget.mIsRadio == false").log();
                    }
                    this.trans(this.mTarget.stateAmFmInactiveIdle);
                    break;
                }
                if (this.logger.isTraceEnabled(128)) {
                    if (ManagerTarget.isRadioActive) {
                        if (null != this.mLastStation) {
                            LogMessage logMessage = this.logger.trace(128);
                            logMessage.append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmActivePrepareTuning[HSM_START] autostore - ignoring tuning of: ").append(this.mLastStation.toLogString(logMessage)).log();
                        }
                    } else {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmActivePrepareTuning[HSM_START] ignored - autostore in progress...").log();
                    }
                }
                AudioConnectionUtils.requestAudioConnectionForBand(this.mLastWaveband, this.mTarget, 0);
                AudioConnectionUtils.requestMuteAndVolumeLockForRadio(true, this.mTarget);
                this.trans(this.mTarget.stateAmFmInactiveIdle);
                break;
            }
            case 1400006: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - CANCEL").log();
                }
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    this.logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - CANCEL").log();
                }
                this.entertainmentManagerCancel = true;
                break;
            }
            case 1073742979: {
                this.activateBandRequest = true;
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - ACTIVATE_BAND - activateBandRequest: ").append(this.activateBandRequest).log();
                if (!ServiceManager.logger2.isTraceEnabled(4)) break;
                ServiceManager.logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - ACTIVATE_BAND - activateBandRequest: ").append(this.activateBandRequest).log();
                break;
            }
            case 4: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - HSM_EXIT").log();
                }
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    this.logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - HSM_EXIT").log();
                }
                switch (RadioCurrentWaveband.get()) {
                    case 1: {
                        AmFmPresetApi.setPresetIndexForParticleBackgroundService(AmFmPresetApi.getCurrentIndex(), 1);
                        break;
                    }
                    case 0: {
                        AmFmPresetApi.setPresetIndexForParticleBackgroundService(AmFmPresetApi.getCurrentIndex(), 0);
                        break;
                    }
                }
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
                this.mTarget.triggerObserver(1635924736, eventGeneric2);
                break;
            }
            case 100246: {
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmBandSwitch - prepare tuning: got answer for audio connection request: ").append(eventGeneric.getResult()).append(", connection: ").append(eventGeneric.getInt(0)).log();
                }
                if (eventGeneric.getResult() != 0 || this.entertainmentManagerCancel) {
                    this.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmBandSwitch - EV_AMFM_ANSWER_BANDSWITCH_REQUEST_AUDIO_CONNECTION - request audio connection: NOT OK => going to inactive idle").log();
                    this.trans(this.mTarget.stateAmFmInactiveIdle);
                    break;
                }
                if (getAudioConnectionAmFmFirstTime) {
                    getAudioConnectionAmFmFirstTime = false;
                    if (ServiceManager.perfService != null) {
                        ServiceManager.perfService.performanceLogMsgByID(14);
                    }
                }
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmBandSwitch - EV_AMFM_ANSWER_BANDSWITCH_REQUEST_AUDIO_CONNECTION - received request connection OK, tuning LSM now").log();
                }
                AmFmDsiApi.setSwitchLinkingDeviceUsageMode(2);
                if (this.activateBandRequest) {
                    this.trans(this.mTarget.stateAmFmInactiveIdle);
                    ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> activateBandRequest is  ").append(this.activateBandRequest).append(", so transferring to state stateAmFmInactiveIdle before selectStation").log();
                } else if (StateAutostoreDone.getAutoStoreDone()) {
                    StateAutostoreDone.setAutoStoreDone(false);
                    AmFmPresetApi.setFeedbackEvent(this.mTarget.getTargetId(), -1417281280);
                    if (!AmFmPresetApi.activateStationPreset(0)) {
                        this.tuneLastStation();
                    }
                    AmFmPresetApi.setFeedbackEvent(0, 0);
                } else {
                    this.tuneLastStation();
                }
                if (RadioCurrentWaveband.get() != 0) break;
                this.mTarget.audioConnectionTunerLwExists = true;
                break;
            }
            case 100011: {
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("prepare tuning: got answer for select station").log();
                }
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - EV_AMFM_ANSWER_SELECTSTATION").log();
                }
                if (this.activateBandRequest) {
                    this.trans(this.mTarget.stateAmFmInactiveIdle);
                    ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> activateBandRequest is  ").append(this.activateBandRequest).append(", so transferring to state stateAmFmInactiveIdle before requestFadeInForBand").log();
                    break;
                }
                AudioConnectionUtils.requestFadeInForBand(RadioCurrentWaveband.get(), this.mTarget, -1366949632);
                if (!ServiceManager.logger.isTraceEnabled(128)) break;
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - requestFadeInForBand() is called in the event of EV_AMFM_ANSWER_SELECTSTATION - ").append(this.activateBandRequest).log();
                break;
            }
            case 100014: {
                int n = eventGeneric.getInt(0);
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("prepare tuning: got answer for fading, result: ").append(eventGeneric.getResult()).log();
                }
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmBandSwitch - EV_AMFM_ANSWER_FADE_TO_CONNECTION - connection = ").append(n).append(", result = ").append(eventGeneric.getResult()).log();
                }
                if (eventGeneric.getResult() != 0) {
                    this.mTarget.getTextLogger().info(this.mTarget.getClassifier()).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("request fade-in: not ok").log();
                }
                if (n != AudioConnectionUtils.getCorrespondingAudioConnection(this.mLastWaveband)) {
                    this.logger.warn(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Received answer for fadeTo. Connections do not match: prepared ").append(AudioConnectionUtils.getCorrespondingAudioConnection(this.mLastWaveband)).append(", answer ").append(n).log();
                }
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("received answer for fade to connection, going into active idle").log();
                }
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 100240: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmActivePrepareTuning - DEVICE_DEACTIVATE").log();
                    Throwable throwable = new Throwable();
                    StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
                    for (int i2 = 0; i2 < stackTraceElementArray.length; ++i2) {
                        ServiceManager.logger.error(128).append("STACK TRACE: ").append(stackTraceElementArray[i2]).log();
                    }
                }
                if (this.mTarget.getTimerServer().isTimerActive(this.mTarget.getTargetId(), -2004418304)) {
                    this.mTarget.stopTimer(-2004418304);
                    RadioData.getAmfmDatabase().setMpsCoverArtRemovalTimerRunning(false);
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    TaggingApi.notifyAMFMStationChanged();
                }
                AmFmPresetApi.dehighlightPresets();
                eventGeneric.setBoolean(0, true);
                eventGeneric.setResult(0);
                this.trans(this.mTarget.stateAmFmInactiveIdle);
                break;
            }
            case 100211: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void tuneLastStation() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmBandSwitch - tuneLastStation()");
        }
        tuningTrialAfterBandSwitch = 0;
        AmFmDsiApi.selectStation(this.mTarget.getTargetId(), -1417281280, this.mLastStation);
        RadioData.getAmfmDatabase().setCurrentStation(this.mLastStation);
    }

    private void initLastStation() {
        AmFmStation amFmStation;
        if (null == this.mLastStation) {
            this.mLastStation = new AmFmStation();
        }
        if (null == (amFmStation = RadioData.getAmfmDatabase().getCurrentStation())) {
            amFmStation = AmFmDefaultSettings.getAmFmDefaultStation();
            ServiceManager.logger.error(128).append("StateAmFmActivePrepareTuning - initLastStation() - currentStation = null ").log();
        }
        this.mLastStation.copyOf(amFmStation);
    }

    public static short getTuningTrialAfterBandSwitch() {
        return tuningTrialAfterBandSwitch;
    }

    public static void setTuningTrialAfterBandSwitch(short s) {
        tuningTrialAfterBandSwitch = s;
    }

    static {
        manualModeWasActiveAfterBandSwitch = false;
    }
}

