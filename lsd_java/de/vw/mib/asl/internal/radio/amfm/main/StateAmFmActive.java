/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.SystemLanguage;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmConstants;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmProxyHelper;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmUIStationList;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveEmergencySeek;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveListUpdate;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveSeek;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveTargetSeek;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmBandSwitch;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmTrafficInformationJapan;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.amfm.radiotext.Radiotext;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmHDOptionRequester;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMMath;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementView;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreDone;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.tagging.TaggingApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;

public final class StateAmFmActive
extends AbstractHsmState {
    private final Logger logger = ServiceManager.logger;
    private final HsmTarget mTarget;
    private boolean manualModeDsiRequestActive = false;
    private boolean setNewManualFrequency;
    private int timerAudioConnectionStarts = 0;
    private static boolean volumeLockActivated = false;
    private int bandToLock = 1;
    private boolean entertainmentManagerCancel = false;
    private final Radiotext mRadiotext;
    public static int currentStationHDStatus = 0;
    public static boolean isSpsCovertArtRemovalTimerRunning = false;

    StateAmFmActive(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState, Radiotext radiotext) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
        this.mRadiotext = radiotext;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActive is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 1076141828: {
                this.processEventSetViewEntered(eventGeneric);
                break;
            }
            case 1073742979: {
                AmFmFactory.getAslAmfmModelController().updateFmRadioTextPlus("", "");
                AmFmFactory.getAslAmfmModelController().updateHDStationInfo("", "", "");
                break;
            }
            case 100210: {
                this.setNewManualFrequency = false;
                this.manualModeDsiRequestActive = false;
                break;
            }
            case 2: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmActive - HSM_ENTRY").log();
                }
                this.mRadiotext.activate();
                HsmTarget.seekAbort = false;
                break;
            }
            case 3: {
                this.trans(this.mTarget.stateAmFmBandSwitch);
                break;
            }
            case 4: {
                SelectedStationHighlighting.setStationSelectionIsActive(false, true);
                AmFmPresetApi.updateGui(false);
                this.mRadiotext.deactivate();
                break;
            }
            case 100241: {
                this.mTarget.stopTimer(1938227456);
                AmFmPresetApi.dehighlightPresets();
                this.trans(this.mTarget.stateAmFmBandSwitch);
                AmFmFactory.getAslAmfmModelController().updateAmHdRadioState(3);
                AmFmFactory.getAslAmfmModelController().updateFmHdRadioState(3);
                break;
            }
            case 100240: {
                eventGeneric.setBoolean(0, true);
                eventGeneric.setResult(0);
                if (!RadioData.amFmTunerIsInitialized || !this.mTarget.audioConnectionTunerLwExists) {
                    this.trans(this.mTarget.stateAmFmInactiveIdle);
                } else {
                    this.timerAudioConnectionStarts = 1;
                    this.mTarget.startTimer(1938227456, (long)0, false);
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    TaggingApi.notifyAMFMStationChanged();
                    TaggingApi.stopAmbiguousTagging();
                }
                AmFmPresetApi.dehighlightPresets();
                break;
            }
            case 4000015: {
                int n = eventGeneric.getInt(0);
                if (n != 13) break;
                this.mTarget.audioConnectionTunerLwExists = false;
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                ServiceManager.logger.info(128).append("ASL_SOUND_AUDIOMNGMNT_STATUS with Status : ").append(n).append("mTarget.mAudioAvailable : ").append(this.mTarget.mAudioAvailable).append("mTarget.mTunerStatus : ").append(RadioData.amFmTunerAvailabilityStatus).log();
                if (n == 2 || n == 1) {
                    if (!this.mTarget.mAudioAvailable) {
                        this.trans(this.mTarget.stateAmFmBandSwitch);
                    }
                    this.mTarget.mAudioAvailable = true;
                    break;
                }
                if (n != 0) break;
                this.mTarget.mAudioAvailable = false;
                break;
            }
            case 100211: {
                if (this.timerAudioConnectionStarts <= 4 && this.mTarget.audioConnectionTunerLwExists) {
                    ++this.timerAudioConnectionStarts;
                    this.mTarget.startTimer(1938227456, (long)0, false);
                    break;
                }
                this.mTarget.audioConnectionTunerLwExists = false;
                this.trans(this.mTarget.stateAmFmInactiveIdle);
                break;
            }
            case 1400006: {
                this.entertainmentManagerCancel = true;
                break;
            }
            case 100246: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append("Response of Audio Connection is not handled in BandSwitch state").log();
                }
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("stateAmFmActive : got answer for audio connection request: ").append(eventGeneric.getResult()).append(", connection: ").append(eventGeneric.getInt(0)).log();
                }
                if (eventGeneric.getResult() != 0 || this.entertainmentManagerCancel) {
                    this.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("request audio connection: NOT OK => going to inactive idle").log();
                    this.trans(this.mTarget.stateAmFmInactiveIdle);
                    break;
                }
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("received request connection OK, tuning LSM now").log();
                }
                AmFmDsiApi.setSwitchLinkingDeviceUsageMode(2);
                if (StateAutostoreDone.getAutoStoreDone()) {
                    StateAutostoreDone.setAutoStoreDone(false);
                    AmFmPresetApi.setFeedbackEvent(this.mTarget.getTargetId(), -1417281280);
                    if (!AmFmPresetApi.activateStationPreset(0)) {
                        AmFmDsiApi.selectStation(this.mTarget.getTargetId(), -1417281280, RadioData.getAmfmDatabase().getCurrentStation());
                    }
                    AmFmPresetApi.setFeedbackEvent(0, 0);
                } else {
                    AmFmDsiApi.selectStation(this.mTarget.getTargetId(), -1417281280, RadioData.getAmfmDatabase().getCurrentStation());
                }
                if (RadioCurrentWaveband.get() != 0) break;
                this.mTarget.audioConnectionTunerLwExists = true;
                break;
            }
            case 100006: 
            case 100011: {
                this.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AMFM tuner received answer for audio connection request");
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("prepare tuning: got answer for audio connection request: ").append(eventGeneric.getResult()).append(", connection: ").append(eventGeneric.getInt(0)).log();
                }
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("received request connection OK, tuning LSM now").log();
                }
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(RadioData.getAmfmDatabase().getLastStationForBand(RadioCurrentWaveband.get()));
                AudioConnectionUtils.requestFadeInForBand(RadioCurrentWaveband.get(), this.mTarget, -1366949632);
                break;
            }
            case 100014: {
                int n = eventGeneric.getInt(0);
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("stateAmFmActive[EV_AMFM_ANSWER_FADE_TO_CONNECTION] connection=").append(n).append(", result=").append(eventGeneric.getResult()).log();
                }
                if (eventGeneric.getResult() == 0) break;
                this.mTarget.getTextLogger().info(this.mTarget.getClassifier()).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("request fade-in: not ok").log();
                break;
            }
            case 0x400004A4: {
                AmFmPresetApi.updateGui(false);
                SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                if (null == amFmStation) break;
                AmFmPresetApi.setFreezedStation(amFmStation);
                if (RadioData.getAmfmDatabase().getFixedStationList().getName(amFmStation.getPi(), amFmStation.getFrequency()) != null) break;
                RadioData.getAmfmDatabase().getFixedStationList().freezePS(amFmStation);
                break;
            }
            case 1073743011: {
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                RadioData.getAmfmDatabase().getFixedStationList().add();
                AmFmFactory.getAslAmfmModelController().updatePsFixed(true);
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation);
                AmFmPresetApi.changeName(RadioCurrentWaveband.get());
                break;
            }
            case 0x400004E4: {
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                if (null == amFmStation) break;
                RadioData.getAmfmDatabase().getFixedStationList().remove(amFmStation);
                AmFmFactory.getAslAmfmModelController().updatePsFixed(false);
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation);
                break;
            }
            case 1073742987: {
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(true, 1170613248, -1);
                    break;
                }
                this.activateRadioStation(1, 0);
                break;
            }
            case 1073742991: {
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(false, 1170613248, -1);
                    break;
                }
                this.activateRadioStation(2, 1);
                break;
            }
            case 1073742986: {
                RadioData.getAmfmDatabase().skipStation(0);
                break;
            }
            case 1073742989: {
                RadioData.getAmfmDatabase().skipStation(1);
                break;
            }
            case 1073743013: {
                int n = eventGeneric.getInt(0);
                AmFmPresetApi.setFreezedListStation(n);
                AmFmStationList.setListItemPressed(true);
                break;
            }
            case 1073743078: {
                AmFmStationList.setListItemPressed(false);
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                if (null == amFmStation) break;
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation);
                AmFmUIStationList amFmUIStationList = AmFmFactory.getInstanceEUStationListViewWalker();
                if (amFmStation.getServiceId() > 1) {
                    amFmUIStationList.updateSubStation(amFmStation);
                    break;
                }
                amFmUIStationList.updateStation(amFmStation, false, false);
                AmFmPresetApi.syncFmName(amFmStation);
                int n = amFmStation.getWaveband();
                int n2 = AMFMUtil.convertDSIBandConstantToHMIBandConstant(n);
                AmFmPresetApi.autoCompare(n2, amFmStation);
                break;
            }
            case 1073742994: {
                int n = eventGeneric.getInt(0);
                AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
                AmFmStation amFmStation = amFmStationList.get(n);
                if (null == amFmStationList || null == amFmStation) break;
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    this.mTarget.updateSelectedStation(amFmStation);
                }
                AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(amFmStation), AmFmPresetApi.getCurrentIndex());
                RadioData.getAmfmDatabase().setStationListIndex(n);
                AmFmDsiApi.selectStation(amFmStation);
                this.mRadiotext.notifyStationChange();
                break;
            }
            case 1073743077: {
                RadioData.getAmfmDatabase().getFixedStationList().unfreezePS();
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                if (null == amFmStation) break;
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation);
                break;
            }
            case 1073743080: {
                if (StateAmFmActiveListUpdate.isListUpdateActive()) {
                    if (!ServiceManager.logger.isTraceEnabled(128)) break;
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_LIST_UPDATE).append("StateAmFmActive ASL_RADIO_UPDATE_STATION_LIST update is already active!!!").log();
                    break;
                }
                this.trans(this.mTarget.stateAmFmActiveListUpdate);
                break;
            }
            case 1073743017: {
                RadioData.getAmfmDatabase().setStationListViewIsOpen(true);
                if (!HsmTarget.waitingForUpdateSelectedStation) {
                    SelectedStationHighlighting.updateGui(false);
                }
                SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                this.trans(this.mTarget.stateAmFmActiveListView);
                break;
            }
            case 0x400004CC: {
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
                AmFmPresetApi.dehighlightPresets();
                this.mTarget.mSeekMode = 6;
                this.trans(this.mTarget.stateAmFmActiveTargetSeek);
                this.mRadiotext.notifyStationChange();
                break;
            }
            case 1073743053: {
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
                AmFmPresetApi.dehighlightPresets();
                this.mTarget.mSeekMode = 5;
                this.trans(this.mTarget.stateAmFmActiveTargetSeek);
                this.mRadiotext.notifyStationChange();
                break;
            }
            case 0x400004D0: {
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
                AudioConnectionUtils.requestVolumeLock(RadioCurrentWaveband.get(), true, this.mTarget);
                int n = eventGeneric.getInt(0);
                StateAmFmActiveSeek.setSeekStatus(1);
                AmFmPresetApi.dehighlightPresets();
                this.mTarget.mSeekMode = n == 1 ? 1 : 2;
                this.trans(this.mTarget.stateAmFmActiveSeek);
                this.mRadiotext.notifyStationChange();
                break;
            }
            case 1073743057: {
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
                int n = eventGeneric.getInt(0);
                AmFmPresetApi.dehighlightPresets();
                this.mTarget.mSeekMode = n == 1 ? 5 : 6;
                this.trans(this.mTarget.stateAmFmActiveTargetSeek);
                this.mRadiotext.notifyStationChange();
                break;
            }
            case 1073743014: {
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
                StateAmFmActiveSeek.setSeekStatus(0);
                this.setFrequencyManually(1);
                break;
            }
            case 1073743002: {
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
                StateAmFmActiveSeek.setSeekStatus(0);
                this.setFrequencyManually(-1);
                break;
            }
            case 1073743037: {
                AmFmFactory.getAslAmfmModelController().updateHDStationInfo("", "", "");
                AmFmFactory.getAslAmfmModelController().updateTaggingButtonVisibility(false);
                AmFmPresetApi.dehighlightPresets();
                StateAmFmActiveSeek.setSeekStatus(0);
                AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency(eventGeneric.getInt(0));
                this.setFrequencyManually(0);
                break;
            }
            case 1073743065: {
                if (this.mTarget.mManualMode) {
                    AmFmDsiApi.stopAutoSeek(this.mTarget.getTargetId(), true);
                    break;
                }
                AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
                break;
            }
            case 1073743064: {
                if (this.mTarget.mManualMode) {
                    AmFmDsiApi.stopAutoSeek(this.mTarget.getTargetId(), false);
                    break;
                }
                AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
                break;
            }
            case 1073743055: {
                AmFmPresetApi.updateGui(false);
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
                SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                this.mRadiotext.notifyStationChange();
                this.trans(this.mTarget.stateAmFmActiveScanMode);
                break;
            }
            case 1073743043: {
                if (!RadioCurrentWaveband.isFm() && !RadioCurrentWaveband.isAm()) break;
                this.mTarget.mManualMode = eventGeneric.getBoolean(0);
                StateAmFmActiveTargetSeek.setTargetSeekStatus(0);
                StateAmFmActiveSeek.setSeekStatus(0);
                StateAmFmActiveEmergencySeek.setEmergencySeekStatus(0);
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmActive - ASLRadioServiceConstants.SET_MANUAL_MODE: mTarget.mManualMode = ").append(this.mTarget.mManualMode).log();
                }
                if (this.mTarget.mManualMode) {
                    StateAmFmBandSwitch.manualModeWasActiveAfterBandSwitch = true;
                    SelectedStationHighlighting.setApplicationStationToHmiStation();
                    SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                    AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                    if (null == amFmStation) break;
                    AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency(amFmStation.getFrequency());
                    AmFmFactory.getAslAmfmPropertyManager().setManualModeActive(true);
                    GuiApiTunerCommon.updateRadioManualMode(true);
                    AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation);
                    break;
                }
                if (RadioCurrentWaveband.isFm() && StateAmFmBandSwitch.manualModeWasActiveAfterBandSwitch) {
                    if (SelectedStationHighlighting.isTunedStationNameValid()) {
                        SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                        SelectedStationHighlighting.updateGui(true);
                    } else {
                        SelectedStationHighlighting.setStationSelectionIsActive(true, false);
                    }
                }
                this.manualModeDsiRequestActive = false;
                AmFmFactory.getAslAmfmPropertyManager().setManualModeActive(false);
                this.mTarget.stopTimer(1921450240);
                GuiApiTunerCommon.updateRadioManualMode(false);
                AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
                break;
            }
            case 4300068: {
                int n = eventGeneric.getInt(1);
                if (n != 10) break;
                this.mTarget.fireModelStopScanOrSeekEvent();
                AmFmFactory.getAslAmfmModelController().updateHDStationInfo("", "", "");
                AmFmFactory.getAslAmfmModelController().updateTaggingButtonVisibility(false);
                AmFmPresetApi.dehighlightPresets();
                StateAmFmActiveSeek.setSeekStatus(0);
                this.setFrequencyManually(eventGeneric.getInt(0));
                break;
            }
            case 0x400004AA: {
                break;
            }
            case 1073743026: {
                this.activateViewState(eventGeneric.getInt(0));
                break;
            }
            case 1073743025: {
                this.activateViewState(eventGeneric.getInt(0));
                break;
            }
            case 0x4000044A: {
                long l = eventGeneric.getLong(0);
                AmFmStation amFmStation = null;
                AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
                SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                if (null != amFmStationList) {
                    amFmStation = amFmStationList.getByID(l);
                }
                if (amFmStation != null) {
                    int n = AmFmPresetApi.getIndexOfPreset(amFmStation);
                    AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(l, n);
                    if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        this.mTarget.updateSelectedStation(amFmStation);
                        RadioData.getAmfmDatabase().setCurrentStation(amFmStation);
                    }
                } else {
                    amFmStation = RadioUtil.cumputeStationFromUniqueID(l);
                    int n = AmFmPresetApi.getIndexOfPreset(amFmStation);
                    AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(l, n);
                }
                AmFmDsiApi.selectStation(amFmStation);
                this.mRadiotext.notifyStationChange();
                break;
            }
            case 1073743747: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("received event ASL_RADIO_START_TRAFFIC_INFORMATION in state AMFM active").log();
                }
                this.trans(this.mTarget.stateAmFmActiveTIJapan);
                break;
            }
            case 1073743075: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("received event TUNE_TO_NEXT_AVAILABLE_MULTICAST_STATION").log();
                }
                if (SelectedStationHighlighting.getStationSelectionIsActive()) {
                    SelectedStationHighlighting.setStationSelectionIsActive(false, true);
                }
                if (AmFmFactory.getAslAmfmPropertyManager().getManualModeActive()) {
                    AmFmFactory.getAslAmfmPropertyManager().setManualModeActive(false);
                    GuiApiTunerCommon.updateRadioManualMode(false);
                }
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                if (this.logger.isTraceEnabled(128)) {
                    if (null == amFmStation) {
                        this.logger.trace(128).append("ASLRadioServiceConstants.TUNE_TO_NEXT_AVAILABLE_MULTICAST_STATION - null == currentStation").log();
                    } else {
                        this.logger.trace(128).append(" Sub channel count : ").append(amFmStation.getSubChannelCount()).append(" ServiceID of current toggle station : ").append(amFmStation.getServiceId()).append(" Sub Channel bit mask : ").append(amFmStation.getSubChannelBitMask()).log();
                    }
                }
                if (amFmStation != null && amFmStation.getSubChannelCount() > 0 && amFmStation.getServiceId() > 0 && amFmStation.getSubChannelBitMask() > 0) {
                    AmFmStation amFmStation2;
                    int n = AMFMMath.getNextSetBitValue(amFmStation.getSubChannelBitMask(), amFmStation.getServiceId());
                    if (n < 1) {
                        n = 1;
                    }
                    if (null != (amFmStation2 = RadioData.getAmfmDatabase().getAslStationListFM().getByFrequencyAndSubChannel(amFmStation.getFrequency(), n))) {
                        amFmStation = amFmStation2;
                    } else {
                        amFmStation.setServiceId(n);
                        amFmStation.setPI(0);
                        amFmStation.setStationArt(null);
                    }
                    AmFmDsiApi.selectStation(amFmStation);
                    this.mRadiotext.notifyStationChange();
                    break;
                }
                this.logger.warn(128, "Values required to calculate next ServiceID could be zero");
                break;
            }
            case 100207: {
                isSpsCovertArtRemovalTimerRunning = false;
                AmFmFactory.getAslAmfmModelController().updateHDStationInfo("", "", "");
                TaggingApi.notifyHDStationInfoChanged(AmFmConstants.EMPTY_HDSTATIONINFO, false);
                ResourceLocator resourceLocator = null;
                HdStationInfo hdStationInfo = RadioData.getAmfmDatabase().getCurrentHDStation();
                if (hdStationInfo != null) {
                    if (RadioUtil.isValid(hdStationInfo.stationArt)) {
                        if (this.logger.isTraceEnabled(128)) {
                            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" Display Station Logo when subservice lost the reception : ").append(hdStationInfo.stationArt.toString()).log();
                        }
                        resourceLocator = hdStationInfo.getStationArt();
                    }
                    AmFmFactory.getAslAmfmPropertyManager().setHDSingalLostStation(hdStationInfo.frequency, hdStationInfo.serviceId);
                }
                AmFmFactory.getAslAmfmModelController().updateLogoInStationView(resourceLocator);
                break;
            }
            case 100214: {
                if (!RadioData.getAmfmDatabase().isCoverArtReceived() || RadioData.getAmfmDatabase().getSettingsPersistable().getFmViewState() != 1) break;
                ResourceLocator resourceLocator = null;
                HdStationInfo hdStationInfo = RadioData.getAmfmDatabase().getCurrentHDStation();
                if (hdStationInfo != null) {
                    if (RadioUtil.isValid(hdStationInfo.coverArt)) {
                        if (this.logger.isTraceEnabled(128)) {
                            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" Displaying Cover Art after 2 seconds : ").append(hdStationInfo.coverArt.toString()).log();
                        }
                        resourceLocator = hdStationInfo.coverArt;
                    } else if (RadioUtil.isValid(hdStationInfo.stationArt)) {
                        if (AmFmPresetApi.isImageUserAssignedForCurrentPreset()) {
                            int n = AmFmPresetApi.getCurrentIndex();
                            if (n >= 0) {
                                resourceLocator = AmFmPresetApi.getImage(RadioCurrentWaveband.get(), n);
                                if (this.logger.isTraceEnabled(128) && null != resourceLocator) {
                                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" Displaying User selected Logo after 2 secs : ").append(resourceLocator.toString()).log();
                                }
                            }
                        } else {
                            if (this.logger.isTraceEnabled(128)) {
                                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" Displaying Station Logo after 2 secs : ").append(hdStationInfo.stationArt.toString()).log();
                            }
                            resourceLocator = hdStationInfo.getStationArt();
                        }
                    }
                }
                RadioData.getAmfmDatabase().setCoverArtReceived(false);
                AmFmFactory.getAslAmfmModelController().updateLogoInStationView(resourceLocator);
                break;
            }
            case 100266: {
                TileStationList tileStationList = RadioServiceManager.getServiceManager().getTileStationList();
                if (null == tileStationList || !RadioData.getAmfmDatabase().isTileCoverArtReceived() || !RadioCodingAdapter.isRadioTileFeatureActivated() || !RadioCurrentWaveband.isAm() && !RadioCurrentWaveband.isFm() || !tileStationList.isTileLVisible() && !tileStationList.isTileSVisible()) break;
                ResourceLocator resourceLocator = AmFmFactory.getAslAmfmModelController().getLogoForStationView();
                RadioData.getAmfmDatabase().setTileCoverArtReceived(false);
                tileStationList.updateLogoForSelectedAmFmHdStation(resourceLocator, 1170613248);
                tileStationList.updateLogoForSelectedAmFmHdStation(resourceLocator, 1153836032);
                break;
            }
            case 1073743036: {
                String string = eventGeneric.getString(0);
                this.tuneFrequencyTriggeredBySpeechControl(string, 0);
                break;
            }
            case 1076141831: {
                String string = eventGeneric.getString(0);
                int n = 0;
                if (RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption() && RadioCurrentWaveband.isFm() || RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption() && RadioCurrentWaveband.isAm()) {
                    n = eventGeneric.getInt(1);
                }
                this.tuneFrequencyTriggeredBySpeechControl(string, n);
                break;
            }
            case 1073742995: {
                this.tuneStationTriggeredBySpeechControl(eventGeneric);
                hsmState = null;
                break;
            }
            case 1073744320: {
                RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreLogoActive(eventGeneric);
                break;
            }
            case 100222: {
                this.consumeEventHdStatusChanged();
                break;
            }
            case 100232: {
                HdStationInfo hdStationInfo = RadioData.getAmfmDatabase().getCurrentHDStation();
                if (hdStationInfo.getCoverArt() != null) {
                    if (AmFmPresetApi.isImageUserAssignedForCurrentPreset()) {
                        AmFmFactory.getAslAmfmModelController().updateLogoInStationView(AmFmPresetApi.getCurrentImage());
                    } else {
                        AmFmFactory.getAslAmfmModelController().updateLogoInStationView(hdStationInfo.getStationArt());
                    }
                }
                AmFmFactory.getAslAmfmModelController().updateHDStationInfo("", "", "");
                AmFmFactory.getAslAmfmPropertyManager().setHDSingalLostStation(hdStationInfo.frequency, hdStationInfo.serviceId);
                RadioData.getAmfmDatabase().setMpsCoverArtRemovalTimerRunning(false);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAMFMTunerSelectFrequencyStatus(int n) {
        if (StateAmFmTrafficInformationJapan.amFmJapanTrafficInfIsActive) {
            return;
        }
        AmFmProxyHelper.tuneFrequencyStepsStatus(this.mTarget.getTargetId(), n);
        if (this.manualModeDsiRequestActive) {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AMFM frequency setting - dsiAMFMTunerSelectFrequencyStatus - selectFrequencyStatus: ").append(n).log();
            }
            switch (n) {
                case 0: {
                    SelectedStationHighlighting.setTunedStationByApplication(null);
                    break;
                }
                case 1: {
                    break;
                }
                case 2: {
                    this.mTarget.stopTimer(1921450240);
                    this.manualModeDsiRequestActive = false;
                    if (this.setNewManualFrequency) {
                        if (this.logger.isTraceEnabled(128)) {
                            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("frequency setting - dsiAMFMTunerTuneFrequencyStepsStatus - tuneFrequencySteps - setNewFrequency: ").append(this.setNewManualFrequency).log();
                        }
                        SelectedStationHighlighting.setTunedStationByApplication(null);
                        this.setFrequencyManually(0);
                        break;
                    }
                    if (SelectedStationHighlighting.getTunedStationByApplication() != null) {
                        AmFmStation amFmStation = SelectedStationHighlighting.getTunedStationByApplication();
                        if (AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency() == amFmStation.getFrequency()) {
                            if (this.logger.isTraceEnabled(128)) {
                                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AMFM frequency setting - set GUI frequency 1.1, tmpStation f: ").append(amFmStation.getFrequency()).append(", DDS f: ").append(AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency()).log();
                            }
                            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                                AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
                                if (null == amFmStation2 || amFmStation2.getFrequency() == amFmStation.getFrequency() && amFmStation2.getServiceId() == amFmStation.getServiceId()) break;
                                this.mTarget.updateGuiHD(amFmStation);
                                break;
                            }
                            this.mTarget.updateGui(amFmStation);
                            break;
                        }
                        if (!this.logger.isTraceEnabled(128)) break;
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("frequency setting - set GUI frequency 1.2, DDS f: ").append(AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency()).log();
                        break;
                    }
                    if (SelectedStationHighlighting.getTunedStationByApplication() != null) break;
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("frequency setting - set GUI frequency 1.3, DDS f: ").append(AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency()).log();
                    }
                    AmFmFactory.getAslAmfmModelController().updateCurrentStationInfoFrequencyOnly(AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency());
                    AmFmStation amFmStation = new AmFmStation(AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency());
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) break;
                    AmFmDsiApi.selectStation(amFmStation);
                    break;
                }
                case 3: 
                case 4: {
                    SelectedStationHighlighting.setTunedStationByApplication(null);
                    this.mTarget.stopTimer(1921450240);
                    this.manualModeDsiRequestActive = false;
                    if (!this.setNewManualFrequency) break;
                    this.setFrequencyManually(0);
                    break;
                }
            }
        }
    }

    private void setFrequencyManually(int n) {
        AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmActive - setFrequencyManually - manualDsiRequestActive").append(this.manualModeDsiRequestActive).log();
        }
        if (StateAmFmActiveSeek.isSeekActive()) {
            return;
        }
        if (!this.manualModeDsiRequestActive) {
            AmFmStation amFmStation;
            this.manualModeDsiRequestActive = true;
            int n2 = AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency();
            AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency(RadioData.getAmfmDatabase().getFrequencyForTicks(n, n2, RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband()));
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("frequency setting - set GUI frequency 3.1 - ASLSystemServiceIds.DDS_MENU_ROTATED - ticks: ").append(n).append(", old frequency: ").append(n2).append(", new frequency: ").append(AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency()).log();
            }
            if (null != (amFmStation = RadioData.getAmfmDatabase().getCurrentStation())) {
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(new AmFmStation(amFmStation.getWaveband(), AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency()));
            }
            this.selectNewFrequency();
        } else {
            AmFmStation amFmStation;
            this.setNewManualFrequency = true;
            int n3 = AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency();
            AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency(RadioData.getAmfmDatabase().getFrequencyForTicks(n, n3, RadioCurrentWaveband.get()));
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("frequency setting - set GUI frequency 3.2 - ASLSystemServiceIds.DDS_MENU_ROTATED - ticks: ").append(n).append(", cumulatedSteps: ").append(this.setNewManualFrequency).append(", old frequency: ").append(n3).append(", new frequency: ").append(AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency()).log();
            }
            if (null != (amFmStation = RadioData.getAmfmDatabase().getCurrentStation())) {
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(new AmFmStation(amFmStation.getWaveband(), AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency()));
            }
        }
        this.mRadiotext.notifyStationChange();
    }

    void selectNewFrequency() {
        this.setNewManualFrequency = false;
        HsmTarget.mHdstruct = -1;
        this.mTarget.stopTimer(1921450240);
        this.mTarget.startTimer(1921450240, (long)0, false);
        int n = AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency();
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            AmFmFactory.getAslAmfmModelController().updateAmHdRadioState(1);
            AmFmFactory.getAslAmfmModelController().updateFmHdRadioState(1);
            AmFmFactory.getAslAmfmModelController().updateLogoInStationView(null);
            RadioServiceManager.getServiceManager().getGuiBapApi().changeInFmHdStationLogosForKombi(null);
        }
        RadioData.getAmfmDatabase().setCurrentStation(new AmFmStation(n));
        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
        if (null != dSIAMFMTuner) {
            dSIAMFMTuner.selectFrequency(n);
        }
    }

    public void dsiAMFMTunerUpdateLinkingUsageStatus(int n, int n2) {
        switch (n) {
            case 2: {
                break;
            }
            case 1: {
                break;
            }
            case 5: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 6: {
                break;
            }
        }
    }

    public void dsiAMFMTunerUpdateAvailability(int n, int n2) {
        ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> dsiAMFMTunerUpdateAvailability in stateAmFmActive ").append(" availability: ").append(n).append("  validflag: ").append(n2).log();
        if (n2 != 1) {
            return;
        }
        if (2 == n) {
            ++RadioData.dsiAmFmTunerUpdateAvailabilityAvailableCount;
        }
        AmFmProxyHelper.updateAvailability(this.mTarget.getTargetId(), n, n2);
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("update availability: ").append(n).append("  validflag: ").append(n2).log();
        }
        int n3 = RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband();
        if (RadioData.amFmTunerAvailabilityStatus == 1 && n == 2) {
            AmFmDsiApi.setSwitchLinkingDeviceUsageMode(2);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2) && RadioData.amFmTunerIsInitialized) {
                int n4 = 1;
                if (!AmFmHDOptionRequester.getAm() && !AmFmHDOptionRequester.getFm()) {
                    n4 = 2;
                } else if (AmFmHDOptionRequester.getAm() && !AmFmHDOptionRequester.getFm()) {
                    n4 = 6;
                } else if (!AmFmHDOptionRequester.getAm() && AmFmHDOptionRequester.getFm()) {
                    n4 = 5;
                }
                AmFmHDOptionRequester.setModeHD(n4);
            }
            AudioConnectionUtils.requestAudioConnectionForBand(n3, this.mTarget, -1501167360);
            if (RadioData.amFmTunerIsInitialized && RadioData.dsiAmFmTunerUpdateAvailabilityAvailableCount > 1) {
                AmFmDsiApi.setSwitchLinkingDeviceUsageMode(2);
                AmFmDsiApi.selectStation(RadioData.getAmfmDatabase().getCurrentStation());
            }
        }
        if (RadioData.amFmTunerAvailabilityStatus == 2 && n == 2) {
            AudioConnectionUtils.requestAudioConnectionForBand(n3, this.mTarget, -1501167360);
        }
        RadioData.amFmTunerAvailabilityStatus = n;
        this.mTarget.triggerAmFmPerformanceTrace();
    }

    public static String getTunerUpdateAvailabilityAsString(int n) {
        switch (n) {
            case 0: {
                return "AVAILABILITY_UNDEFINED";
            }
            case 1: {
                return "AVAILABILITY_NOTAVAILABLE";
            }
            case 2: {
                return "AVAILABILITY_AVAILABLE";
            }
        }
        return Integer.toString(n);
    }

    public void dsiAMFMTunerUpdateSelectedStation(Station station, int n) {
        if (!HsmTarget.isUpdateSelectedStationValid(n, station)) {
            return;
        }
        this.mTarget.logDsiAMFMTunerUpdateSelectedStation(station, "StateAmFmActive");
        if (StateAmFmTrafficInformationJapan.amFmJapanTrafficInfIsActive) {
            return;
        }
        if (StateAmFmActiveEmergencySeek.isEmergencySeekActive() && ((StateAmFmActiveEmergencySeek)this.mTarget.stateAmFmActiveEmergencySeek).checkBandRangeIteration(station)) {
            return;
        }
        if (StateAmFmActive.isDsiStationValid(station)) {
            this.mTarget.checkDsiAMFMTunerUpdateSelectedStation(station);
            SelectedStationHighlighting.setTunedStationByApplication(station);
            if (!station.rds) {
                this.mRadiotext.notifyLostRDS();
            }
            this.mTarget.notifyStationChangeForRadioText(new AmFmStation(station));
            if (SelectedStationHighlighting.getStationSelectionIsActive()) {
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                if (null != amFmStation) {
                    String string = amFmStation.getName();
                    if (!(RadioCodingAdapter.isPiActivated() || null == station.name || station.name.length() <= 0 || (long)amFmStation.getFrequency() != station.frequency || null != string && string.length() >= 1)) {
                        AmFmFactory.getAslAmfmModelController().updateStationNameInMainView(new AmFmStation(station));
                    }
                }
                return;
            }
            if (this.mTarget.mManualMode) {
                if ((long)AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency() == station.getFrequency() || StateAmFmActiveSeek.isSeekActive() || StateAmFmActiveTargetSeek.isTargetSeekActive()) {
                    this.mTarget.updateGui(new AmFmStation(station));
                }
            } else {
                this.mTarget.updateGui(new AmFmStation(station));
            }
        } else if (!HsmTarget.mIsTASliderActive && !AnnouncementView.getTaActive()) {
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
            short s = StateAmFmBandSwitch.getTuningTrialAfterBandSwitch();
            if (null != amFmStation && s < 5) {
                s = (short)(s + 1);
                StateAmFmBandSwitch.setTuningTrialAfterBandSwitch(s);
                AmFmDsiApi.selectStation(amFmStation);
            }
        }
    }

    public void dsiAMFMTunerUpdateSelectedStationHD(Station station, int n, int n2) {
        try {
            if (!HsmTarget.isUpdateSelectedStationValid(n2, station)) {
                return;
            }
            if (!station.isHd()) {
                station.serviceId = 0;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> dsiAMFMTunerUpdateSelectedStationHD in stateAmFmActive: ").append("Station: ").append(station.toString()).append("  validflag: ").append(n2).log();
            }
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmActive - dsiAMFMTunerUpdateSelectedStationHD -> ").append(station.toString()).append(" HDStructure Bit mask = ").append(n).log();
            }
            if (AMFMUtil.isStationValidInBand(station)) {
                AmFmStation amFmStation;
                if (AmFmFactory.getAslAmfmPropertyManager().isStationTuneStarted()) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Checks if NAR station changed after reply for tune command ").log();
                    }
                    if (!(AmFmFactory.getAslAmfmPropertyManager().isPresetTuned() || HsmTarget.mHdstruct != n || AMFMUtil.isNARStationChanged(HsmTarget.selectedStationInfo, station) || HsmTarget.stationTunedBySpeech)) {
                        if (this.logger.isTraceEnabled(128)) {
                            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Station is same as before").log();
                        }
                        return;
                    }
                    if (AmFmFactory.getAslAmfmPropertyManager().isPresetTuned() && null != (amFmStation = RadioData.getAmfmDatabase().getCurrentStation()) && (station.getFrequency() != (long)amFmStation.getFrequency() || station.getServiceId() != amFmStation.getServiceId() && amFmStation.getServiceId() > 1 && station.getServiceId() > 1)) {
                        if (this.logger.isTraceEnabled(128)) {
                            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("preset Station is tuned and updated station information is not the same").log();
                        }
                        return;
                    }
                    AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
                }
                if (RadioData.getAmfmDatabase().checkIfStationChanged(station, HsmTarget.selectedStationInfo) && this.mTarget.getTimerServer().isTimerActive(this.mTarget.getTargetId(), -2004418304)) {
                    this.mTarget.stopTimer(-2004418304);
                    RadioData.getAmfmDatabase().setMpsCoverArtRemovalTimerRunning(false);
                }
                if (null == (amFmStation = RadioData.getAmfmDatabase().handleStationInfoChange(station, HsmTarget.selectedStationInfo))) {
                    return;
                }
                HsmTarget.selectedStationInfo = station;
                HsmTarget.mHdstruct = n;
                amFmStation.setSubChannelBitMask(n);
                if (StateAmFmActiveEmergencySeek.isEmergencySeekActive() && ((StateAmFmActiveEmergencySeek)this.mTarget.stateAmFmActiveEmergencySeek).checkBandRangeIteration(station)) {
                    return;
                }
                if (!station.rds) {
                    this.mRadiotext.notifyLostRDS();
                }
                SelectedStationHighlighting.setTunedStationByApplication(station);
                SelectedStationHighlighting.setHdStructure(n);
                if (SelectedStationHighlighting.getStationSelectionIsActive()) {
                    AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
                    if (null != amFmStation2 && (null == amFmStation2.getShortNameHD() || amFmStation2.getShortNameHD().length() < 1) && null != station.shortNameHD && station.shortNameHD.length() > 0 && (long)amFmStation2.getFrequency() == station.getFrequency() && station.getServiceId() >= 1) {
                        AmFmFactory.getAslAmfmModelController().updateStationNameInMainView(new AmFmStation(station));
                    }
                    return;
                }
                if (this.mTarget.mManualMode && !HsmTarget.stationTunedBySpeech) {
                    if ((long)AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency() == station.getFrequency() || StateAmFmActiveSeek.isSeekActive() || StateAmFmActiveTargetSeek.isTargetSeekActive()) {
                        this.mTarget.updateGuiHD(amFmStation);
                        AmFmPresetApi.updateGuiList(RadioCurrentWaveband.get());
                    }
                    return;
                }
                AmFmStation amFmStation3 = RadioData.getAmfmDatabase().getCurrentStation();
                if (null != amFmStation3 && amFmStation3.getFrequency() == amFmStation.getFrequency() && amFmStation.getServiceId() > 1 && amFmStation.getShortNameHD() == null) {
                    amFmStation.setShortNameHD(amFmStation3.getShortNameHD());
                }
                this.mTarget.updateGuiHD(amFmStation);
                AmFmPresetApi.updateGuiList(RadioCurrentWaveband.get());
                if (HsmTarget.stationTunedBySpeech) {
                    RadioServiceManager.getServiceManager().getAdapterAslSpeech().sendAmFmTuningResponse(new AmFmStation(station), 1);
                    HsmTarget.stationTunedBySpeech = false;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean isDsiStationValid(Station station) {
        int n = RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband();
        boolean bl = false;
        boolean bl2 = false;
        if (station.waveband == 1 && n == 1 || (station.waveband == 3 || station.waveband == 4) && n == 0) {
            bl = true;
        }
        if (n == 1 && station.frequency >= RadioData.getAmfmDatabase().getFmBandInfo().getLowerLimit() && station.frequency <= RadioData.getAmfmDatabase().getFmBandInfo().getUpperLimit()) {
            bl2 = true;
        } else if (n == 0 && station.frequency >= RadioData.getAmfmDatabase().getAmBandInfo().getLowerLimit() && station.frequency <= RadioData.getAmfmDatabase().getAmBandInfo().getUpperLimit()) {
            bl2 = true;
        }
        return bl && bl2;
    }

    public void dsiAMFMTunerUpdateHdStationInfo(HdStationInfo hdStationInfo, int n) {
        boolean bl;
        if (HsmTarget.waitingForStatusRunning || n != 1 || !RadioData.amFmTunerIsInitialized || null == hdStationInfo) {
            return;
        }
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
        if (hdStationInfo.getFrequency() != amFmStation.getFrequency() || hdStationInfo.getServiceId() != amFmStation.getServiceId()) {
            return;
        }
        if (currentStationHDStatus == 0 || currentStationHDStatus == 1 || currentStationHDStatus == 3) {
            return;
        }
        boolean bl2 = RadioUtil.isValid(hdStationInfo.getStationArt());
        if (!bl2) {
            hdStationInfo.stationArt = null;
        }
        if (!(bl = RadioUtil.isValid(hdStationInfo.getCoverArt()))) {
            hdStationInfo.coverArt = null;
        }
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("HD Station Info: ").append(hdStationInfo.toString()).log();
        }
        ResourceLocator resourceLocator = null;
        RadioData.getAmfmDatabase().setCurrentHDStation(hdStationInfo);
        if (RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption() || RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption() && HsmTarget.selectedStationInfo != null && HsmTarget.selectedStationInfo.hd) {
            int n2;
            if (AmFmFactory.getAslAmfmPropertyManager().isHDSignalLostStationActive()) {
                AmFmFactory.getAslAmfmPropertyManager().setHDSingalLostStation(0, -1);
            }
            String string = hdStationInfo.artistName == null ? "" : hdStationInfo.artistName.trim();
            String string2 = hdStationInfo.songTitle == null ? "" : hdStationInfo.songTitle.trim();
            String string3 = hdStationInfo.albumTitle == null ? "" : hdStationInfo.albumTitle.trim();
            AmFmFactory.getAslAmfmModelController().updateHDStationInfo(string, string2, string3);
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(" Cover Art : ").append(hdStationInfo.coverArt != null ? hdStationInfo.coverArt.toString() : "null").append(" Station Logo : ").append(hdStationInfo.stationArt != null ? hdStationInfo.stationArt.toString() : "null").log();
            }
            resourceLocator = AmFmFactory.getAslAmfmModelController().getLogoForStationView();
            if (!this.mTarget.getTimerServer().isTimerActive(this.mTarget.getTargetId(), 1988559104)) {
                if (RadioData.getAmfmDatabase().getSettingsPersistable().getFmViewState() == 1) {
                    if (resourceLocator != null) {
                        this.mTarget.startTimer(1988559104, (long)0, false);
                    }
                } else {
                    AmFmFactory.getAslAmfmModelController().updateLogoInStationView(null);
                }
                AmFmFactory.getAslAmfmModelController().updateLogoInStationView(resourceLocator);
            } else if (RadioUtil.isValid(hdStationInfo.coverArt)) {
                RadioData.getAmfmDatabase().setCoverArtReceived(true);
            } else {
                RadioData.getAmfmDatabase().setCoverArtReceived(false);
            }
            ResourceLocator resourceLocator2 = AmFmFactory.getAslAmfmModelController().getAmFmStationArt(amFmStation);
            RadioServiceManager.getServiceManager().getGuiBapApi().changeInFmHdStationLogosForKombi(resourceLocator2);
            if (!this.mTarget.getTimerServer().isTimerActive(this.mTarget.getTargetId(), -1433992960)) {
                TileStationList tileStationList = RadioServiceManager.getServiceManager().getTileStationList();
                if (null != tileStationList) {
                    if (RadioCodingAdapter.isRadioTileFeatureActivated() && (tileStationList.isTileLVisible() || tileStationList.isTileSVisible())) {
                        if (resourceLocator != null && RadioUtil.isValid(hdStationInfo.coverArt)) {
                            tileStationList.startTileCoverArtTimer();
                        }
                    } else {
                        resourceLocator = null;
                    }
                    tileStationList.updateLogoForSelectedAmFmHdStation(resourceLocator, 1170613248);
                    tileStationList.updateLogoForSelectedAmFmHdStation(resourceLocator, 1153836032);
                }
            } else if (RadioUtil.isValid(hdStationInfo.coverArt)) {
                RadioData.getAmfmDatabase().setTileCoverArtReceived(true);
            } else {
                RadioData.getAmfmDatabase().setTileCoverArtReceived(false);
            }
            if (RadioUtil.isValid(hdStationInfo.stationArt) && !SelectedStationHighlighting.getStationSelectionIsActive() && (n2 = AmFmPresetApi.getCurrentIndex()) >= 0) {
                ResourceLocator resourceLocator3;
                AmFmStation amFmStation2;
                AmFmPreset amFmPreset;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(" Preset available for uploading the station logo :  index -> ").append(n2).log();
                }
                if (null != (amFmPreset = AmFmPresetApi.getPresetByIndex(RadioCurrentWaveband.get(), n2)) && null != (amFmStation2 = amFmPreset.getPresetStation()) && amFmStation2.getFrequency() == hdStationInfo.getFrequency() && amFmStation2.getServiceId() == hdStationInfo.serviceId && amFmStation2.getShortNameHD().equals(amFmStation.getShortNameHD()) && (resourceLocator3 = AmFmPresetApi.getCurrentImage()) != null) {
                    boolean bl3;
                    boolean bl4 = hdStationInfo.stationArt.isIntResource() ? hdStationInfo.stationArt.id != resourceLocator3.id : (bl3 = !hdStationInfo.stationArt.getUrl().equalsIgnoreCase(resourceLocator3.getUrl()));
                    if (!AmFmPresetApi.isImageUserAssignedForCurrentPreset() && bl3) {
                        if (this.logger.isTraceEnabled(128)) {
                            this.logger.trace(128).append(" Preset image is set when Different image is available :  ").append(hdStationInfo.stationArt.toString()).log();
                        }
                        AmFmPresetApi.setImage(RadioCurrentWaveband.get(), n2, hdStationInfo.stationArt, false);
                        AmFmPresetApi.updateGuiList(RadioCurrentWaveband.get());
                    }
                }
            }
        }
        if (RadioData.getAmfmDatabase().checkForHdStationInfoChanged(hdStationInfo)) {
            TaggingApi.notifyHDStationInfoChanged(hdStationInfo, true);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void dsiAMFMTunerUpdateHdStatus(int n, int n2) {
        if (HsmTarget.waitingForStatusRunning || n2 != 1 || !RadioData.amFmTunerIsInitialized) {
            return;
        }
        currentStationHDStatus = n;
        int n3 = -1;
        boolean bl = false;
        if (HsmTarget.selectedStationInfo == null) return;
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(" DSI HD status for station with frequency : ").append(HsmTarget.selectedStationInfo.getFrequency()).append(" ServiceID : ").append(HsmTarget.selectedStationInfo.serviceId).append(" HDSTATUS  : ").append(n).log();
        }
        if (HsmTarget.selectedStationInfo.fullDigital && n == 1) {
            n = 3;
        }
        if (n != 3) {
            if (volumeLockActivated) {
                volumeLockActivated = false;
                AudioConnectionUtils.requestVolumeLock(this.bandToLock, false, this.mTarget);
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.info(128).append(" Volume lock activated On HDStatus deMute ").log();
                }
            }
            if (isSpsCovertArtRemovalTimerRunning) {
                isSpsCovertArtRemovalTimerRunning = false;
                this.mTarget.stopTimer(1871118592);
            }
        }
        if (RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption() || RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption() && HsmTarget.selectedStationInfo != null && HsmTarget.selectedStationInfo.hd) {
            switch (n) {
                case 4: {
                    n3 = 2;
                    break;
                }
                case 2: {
                    n3 = 0;
                    break;
                }
                case 3: {
                    n3 = 1;
                    if (!volumeLockActivated && (HsmTarget.selectedStationInfo.getServiceId() > 1 || HsmTarget.selectedStationInfo.fullDigital)) {
                        this.bandToLock = RadioCurrentWaveband.get();
                        AudioConnectionUtils.requestVolumeLock(this.bandToLock, true, this.mTarget);
                        volumeLockActivated = true;
                        if (this.logger.isTraceEnabled(128)) {
                            this.logger.info(128).append(" Volume lock activated On HDStatus Mute ").log();
                        }
                        if (HsmTarget.selectedStationInfo.getServiceId() <= 1) break;
                        isSpsCovertArtRemovalTimerRunning = true;
                        this.mTarget.stopTimer(1871118592);
                        this.mTarget.startTimer(1871118592, (long)0, false);
                        break;
                    }
                    bl = true;
                    break;
                }
                case 5: 
                case 6: {
                    n3 = 0;
                    break;
                }
                default: {
                    n3 = 1;
                    bl = true;
                    break;
                }
            }
        } else {
            n3 = 3;
            bl = true;
        }
        if (n3 >= 0) {
            AmFmStationPersistence amFmStationPersistence = RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentStationPersistence();
            if (n == 5) {
                AmFmFactory.getAslAmfmModelController().updateFmHdRadioState(n3);
                AmFmFactory.getAslAmfmModelController().updateAmHdRadioState(1);
            } else if (n == 6) {
                AmFmFactory.getAslAmfmModelController().updateAmHdRadioState(n3);
                AmFmFactory.getAslAmfmModelController().updateFmHdRadioState(1);
            } else {
                AmFmFactory.getAslAmfmModelController().updateAmHdRadioState(n3);
                AmFmFactory.getAslAmfmModelController().updateFmHdRadioState(n3);
            }
            if (null != amFmStationPersistence) {
                amFmStationPersistence.setHdStatus(n3);
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                this.startMpsCoverartRemovalTimer();
                this.mTarget.triggerMe(eventGeneric, 2122776832);
            }
        }
        if (bl) {
            bl = false;
            TaggingApi.notifyHDStationInfoChanged(AmFmConstants.EMPTY_HDSTATIONINFO, false);
        }
    }

    private void activateRadioStation(int n, int n2) {
        if (AmfmScopeOfArrowKeys.get() == 1) {
            AmFmPresetApi.updateGui(false);
            SelectedStationHighlighting.setStationSelectionIsActive(false, false);
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
            if (null != amFmStation && RadioData.getAmfmDatabase().getCurrentListSize() < 3) {
                StateAmFmActiveEmergencySeek.setInitialAslStation(amFmStation);
                StateAmFmActiveEmergencySeek.setEmergencySeekStatus(1);
                AmFmPresetApi.dehighlightPresets();
                AmFmDsiApi.doAutoSeek(this.mTarget.getTargetId(), -1568276224, n);
                AudioConnectionUtils.requestVolumeLock(RadioCurrentWaveband.get(), true, this.mTarget);
                this.trans(this.mTarget.stateAmFmActiveEmergencySeek);
            } else {
                RadioData.getAmfmDatabase().skipStation(n2);
            }
        }
    }

    private void activateViewState(int n) {
        ResourceLocator resourceLocator = null;
        if (RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband() == 1) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setFmViewState(n);
            if (n == 1) {
                resourceLocator = AmFmFactory.getAslAmfmModelController().getLogoForStationView();
            } else {
                this.mTarget.stopTimer(1988559104);
            }
            AmFmFactory.getAslAmfmModelController().updateFmViewState(n);
            if (resourceLocator != null) {
                this.mTarget.startTimer(1988559104, (long)0, false);
                AmFmFactory.getAslAmfmModelController().updateLogoInStationView(resourceLocator);
                return;
            }
        } else {
            RadioData.getAmfmDatabase().getSettingsPersistable().setAmViewState(n);
            AmFmFactory.getAslAmfmModelController().updateAmViewState(n);
        }
        if (n == 1) {
            AmFmFactory.getAslAmfmModelController().updateLogoInStationView(AmFmFactory.getAslAmfmModelController().getLogoForStationView());
        }
    }

    private void tuneFrequencyTriggeredBySpeechControl(String string, int n) {
        try {
            int n2 = -1;
            int n3 = RadioCurrentWaveband.get();
            string = string.replace(',', '.');
            n2 = n3 == 1 ? (int)(Float.valueOf(string).floatValue() * 31300) : Integer.valueOf(string);
            boolean bl = true;
            if (n3 != 1 && n3 != 0) {
                bl = false;
            } else {
                if (n3 == 1) {
                    if ((long)n2 < RadioData.getAmfmDatabase().getFmBandInfo().getLowerLimit() || (long)n2 > RadioData.getAmfmDatabase().getFmBandInfo().getUpperLimit()) {
                        bl = false;
                    }
                    if (n2 % 100 != 0) {
                        bl = false;
                    }
                }
                if (n3 == 0 && ((long)n2 < RadioData.getAmfmDatabase().getAmBandInfo().getLowerLimit() || (long)n2 > RadioData.getAmfmDatabase().getAmBandInfo().getUpperLimit())) {
                    bl = false;
                }
            }
            if (bl) {
                AmFmStation amFmStation;
                AmFmStation amFmStation2 = new AmFmStation(n2);
                if (n > 1 && null == (amFmStation = RadioData.getAmfmDatabase().getAslStationListFM().getByFrequencyAndSubChannel(n2, n))) {
                    n = 0;
                }
                amFmStation2.setServiceId(n);
                AmFmDsiApi.selectStation(amFmStation2);
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(RadioData.getAmfmDatabase().getCurrentStation());
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(218);
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    HsmTarget.stationTunedBySpeech = true;
                }
            } else {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(217);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(217);
        }
    }

    private void tuneStationTriggeredBySpeechControl(EventGeneric eventGeneric) {
        try {
            long l = eventGeneric.getLong(0);
            AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
            AmFmStation amFmStation = null;
            if (RadioUtil.isIdADatabaseStationId(l)) {
                amFmStation = amFmStationList.getByDatabaseId(l >> 1);
                if (null == amFmStation) {
                    amFmStation = RadioDataApi.getFmStationDataFromHmiDataBuffer((int)(l >> 1));
                    if (null != amFmStation) {
                        StateAmFmActive.tuneStationTriggeredBySpeechControl(amFmStation);
                    }
                } else {
                    StateAmFmActive.tuneStationTriggeredBySpeechControl(amFmStation);
                }
            } else {
                if (null != amFmStationList) {
                    amFmStation = amFmStationList.getByStationId(l);
                }
                if (null == amFmStation) {
                    amFmStation = RadioUtil.cumputeStationFromUniqueID(l);
                }
                StateAmFmActive.tuneStationTriggeredBySpeechControl(amFmStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(214);
        }
    }

    public static void tuneStationTriggeredBySpeechControl(AmFmStation amFmStation) {
        try {
            if (null != amFmStation && (RadioCurrentWaveband.isFm() && amFmStation.isValidFmFrequency() || RadioCurrentWaveband.isAm() && amFmStation.isValidAmFrequency())) {
                AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(amFmStation), AmFmPresetApi.getCurrentIndex());
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation);
                AmFmDsiApi.selectStation(amFmStation);
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(215);
            } else {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(214);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(214);
        }
    }

    private void processEventSetViewEntered(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            if (n == 1) {
                RadioDataApi.requestCountryRegionTranslationData(SystemLanguage.getInstance().getLanguage());
                RadioDataApi.generateCountryList();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void startMpsCoverartRemovalTimer() {
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
        if (null != amFmStation && amFmStation.isHD() && amFmStation.getServiceId() <= 1 && amFmStation.getHDStatus() != 0) {
            this.mTarget.startTimer(-2004418304, (long)0, false);
            RadioData.getAmfmDatabase().setMpsCoverArtRemovalTimerRunning(true);
        }
    }

    private void consumeEventHdStatusChanged() {
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
        if (null == amFmStation) {
            return;
        }
        if (amFmStation.isHD() && amFmStation.getServiceId() <= 1) {
            if (amFmStation.getHDStatus() == 0) {
                HdStationInfo hdStationInfo = RadioData.getAmfmDatabase().getCurrentHDStation();
                if (this.mTarget.getTimerServer().isTimerActive(this.mTarget.getTargetId(), -2004418304)) {
                    this.mTarget.stopTimer(-2004418304);
                    RadioData.getAmfmDatabase().setMpsCoverArtRemovalTimerRunning(false);
                } else if (null != hdStationInfo && amFmStation.getFrequency() == AmFmFactory.getAslAmfmPropertyManager().getHDSignalLostStationFrequency() && amFmStation.getServiceId() == AmFmFactory.getAslAmfmPropertyManager().getHDSignalLostStationServiceId()) {
                    AmFmFactory.getAslAmfmModelController().updateLogoInStationView(AmFmFactory.getAslAmfmModelController().getLogoForStationView());
                    AmFmFactory.getAslAmfmModelController().updateHDStationInfo(hdStationInfo.artistName, hdStationInfo.songTitle, hdStationInfo.albumTitle);
                    AmFmFactory.getAslAmfmPropertyManager().setHDSingalLostStation(0, -1);
                }
                TaggingApi.notifyHDStationInfoChanged(hdStationInfo, false);
            }
        } else if (amFmStation.getServiceId() > 1 && amFmStation.getFrequency() == AmFmFactory.getAslAmfmPropertyManager().getHDSignalLostStationFrequency() && amFmStation.getServiceId() == AmFmFactory.getAslAmfmPropertyManager().getHDSignalLostStationServiceId()) {
            HdStationInfo hdStationInfo = RadioData.getAmfmDatabase().getCurrentHDStation();
            if (RadioUtil.isValid(hdStationInfo.coverArt)) {
                AmFmFactory.getAslAmfmModelController().updateLogoInStationView(hdStationInfo.getCoverArt());
            }
            AmFmFactory.getAslAmfmModelController().updateHDStationInfo(hdStationInfo.artistName, hdStationInfo.songTitle, hdStationInfo.albumTitle);
            AmFmFactory.getAslAmfmPropertyManager().setHDSingalLostStation(0, -1);
            TaggingApi.notifyHDStationInfoChanged(hdStationInfo, false);
        }
    }
}

