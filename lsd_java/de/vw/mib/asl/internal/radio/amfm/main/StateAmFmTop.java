/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.api.carplay.ASLCarPlayFactory;
import de.vw.mib.asl.api.carplay.ASLCarplayServices;
import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.api.vicsetc.ASLVICSETCFactory;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioAdaptationAdapter;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmASLVICSETCAsiaTrafficMenuListenerAdapter;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListAM;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmAlternativeFrequencySwitch;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmHDOptionRequester;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmPTY31Option;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRadioTextOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRegStateOptionRequester;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmTPOption;
import de.vw.mib.asl.internal.radio.api.impl.ASLRadioCarplayServicesListenerImpl;
import de.vw.mib.asl.internal.radio.api.impl.speech.AmFrequencyScaleImpl;
import de.vw.mib.asl.internal.radio.api.impl.speech.AslRadioAmFmFacadeImpl;
import de.vw.mib.asl.internal.radio.api.impl.speech.FmFrequencyScaleImpl;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.TargetRadioData;
import de.vw.mib.asl.internal.radio.tagging.TaggingApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.Station;

public final class StateAmFmTop
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private Logger logger = ServiceManager.logger;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale;

    public StateAmFmTop(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmTop is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.registerObservers();
                this.mTarget.start();
                this.mTarget.mManualMode = false;
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    TaggingApi.startModule(this.mTarget);
                    break;
                }
                AmFmFactory.getAslAmfmModelController().updateAmHdRadioState(1);
                AmFmFactory.getAslAmfmModelController().updateFmHdRadioState(1);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                AmFmDsiApi.stop();
                break;
            }
            case 100243: {
                try {
                    Object object;
                    this.mTarget.loadPersistence();
                    ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTop - After Load Persistence.").log();
                    this.mTarget.setNotification();
                    this.mTarget.initializeAmFmPresets();
                    this.mTarget.initializeAmFmTuner(false);
                    TargetRadioData.initializeDsiConnectionAfterStartUp();
                    RadioDataApi.initializeAfterStartUp();
                    ASLVICSETCFactory.getVICSETCApi().registerVicsEtcListener(new AmFmASLVICSETCAsiaTrafficMenuListenerAdapter());
                    ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade == null ? (class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade = StateAmFmTop.class$("de.vw.mib.asl.api.radio.speech.amfm.AslRadioAmFmFacade")) : class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade, new AslRadioAmFmFacadeImpl());
                    ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale == null ? (class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale = StateAmFmTop.class$("de.vw.mib.asl.api.radio.amFm.FmFrequencyScale")) : class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale, new FmFrequencyScaleImpl());
                    ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale == null ? (class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale = StateAmFmTop.class$("de.vw.mib.asl.api.radio.amFm.AmFrequencyScale")) : class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale, new AmFrequencyScaleImpl());
                    ASLCarplayServices aSLCarplayServices = ASLCarPlayFactory.getCarPlayApi().getServices();
                    if (null != aSLCarplayServices) {
                        aSLCarplayServices.registerListener(new ASLRadioCarplayServicesListenerImpl());
                    }
                    AmFmDsiApi.setSwitchLinkingDeviceUsageMode(2);
                    if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        object = RadioData.getAmfmDatabase().getLastStationForBand(1);
                        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
                        if (null != object && null != dSIAMFMTuner) {
                            dSIAMFMTuner.selectStation(((AmFmStation)object).getFrequency(), ((AmFmStation)object).getPi(), ((AmFmStation)object).getServiceId());
                        }
                    }
                    this.mTarget.triggerAmFmPerformanceTrace();
                    new de.vw.mib.asl.internal.radio.autostore.HsmTarget(this.mTarget.getMainObject(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AUTOSTORE, this.mTarget.getTaskId());
                    object = ServiceManager.mGenericEventFactory.newEvent(this.mTarget.getTargetId(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AUTOSTORE, 106);
                    this.mTarget.send((EventGeneric)object);
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                try {
                    this.mTarget.send(ServiceManager.mGenericEventFactory.newEvent(this.mTarget.getTargetId(), ASLRadioTargetIds.ASL_RADIO_MANAGER, -1803091712));
                    this.mTarget.send(ServiceManager.mGenericEventFactory.newEvent(this.mTarget.getTargetId(), ASLRadioTargetIds.ASL_RADIO_MANAGER, -1836646144));
                    this.trans(this.mTarget.stateAmFmInactiveIdle);
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 100223: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTop received EV_AMFM_RESET_RADIO_SETTINGS").log();
                }
                if (!this.mTarget.isStateActive(this.mTarget.stateAmFmActive)) break;
                AmFmDsiApi.selectStation(RadioData.getAmfmDatabase().getCurrentFMStation());
                break;
            }
            case 0x400004B0: {
                AmFmAlternativeFrequencySwitch.notifyDSI(eventGeneric.getBoolean(0));
                break;
            }
            case 1073743045: {
                boolean bl = eventGeneric.getBoolean(0);
                AmfmPTY31Option.set(bl);
                break;
            }
            case 1073743049: {
                int n = eventGeneric.getInt(0);
                AmfmScopeOfArrowKeys.set(n);
                break;
            }
            case 1073743048: {
                int n = eventGeneric.getInt(0);
                n = AmfmRegStateOptionRequester.hmiToDsi(n);
                AmfmRegStateOptionRequester.notifyDsi(n);
                break;
            }
            case 1073743047: {
                AmfmRDSOption.set(eventGeneric.getBoolean(0), true);
                if (!ServiceManager.logger.isTraceEnabled(8192)) break;
                ServiceManager.logger.trace(8192).append("[TA-AMFM]RDS set to ").append(AmfmRDSOption.get()).log();
                break;
            }
            case 1073743046: {
                AmfmRadioTextOption.setupOptionByUser(eventGeneric.getBoolean(0));
                break;
            }
            case 1073743426: {
                boolean bl = eventGeneric.getBoolean(0);
                RadioData.getAmfmDatabase().getSettingsPersistable().setRadioTextPlusOption(bl);
                AmFmFactory.getAslAmfmModelController().updateRadioTextPlusSetupState(bl);
                break;
            }
            case 1073743051: {
                AmfmTPOption.set(eventGeneric.getBoolean(0));
                if (ServiceManager.logger.isTraceEnabled(8192)) {
                    ServiceManager.logger.trace(8192).append("[TA-AMFM]TP set to ").append(AmfmTPOption.get()).log();
                }
                if (!AmfmTPOption.get()) break;
                int n = RadioData.mGlobalTAAvailability ? 0 : 1;
                GuiApiTunerCommon.updateTpState(n);
                if (!AmfmTPOption.get() || n != 1 || !RadioCurrentWaveband.isFm() || !this.mTarget.isStateActive(this.mTarget.stateAmFmActiveIdle)) break;
                this.trans(this.mTarget.stateAmFmActiveTASeek);
                break;
            }
            case 100240: {
                this.logger.trace(128, "# # #  DEACTIVATE DEVICE  # # #  in state is AMFMTop, IdEvent.DEVICE_DEACTIVATE");
                break;
            }
            case 100241: {
                this.logger.trace(128, "# # #  ACTIVATE DEVICE  # # #  in state is AMFMTop, IdEvent.DEVICE_ACTIVATE");
                break;
            }
            case 40659: {
                RadioData.getAmfmDatabase().setTimeOutAmRemove(eventGeneric.getInt(0));
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("radio update AM list station remove time, timeout: ").append(RadioData.getAmfmDatabase().getTimeOutAmRemove()).log();
                break;
            }
            case 40658: {
                RadioData.getAmfmDatabase().setTimeOutAmMinTuneTime(eventGeneric.getInt(0));
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("radio update AM min tune time from GEM, timeout: ").append(RadioData.getAmfmDatabase().getTimeOutAmMinTuneTime()).log();
                break;
            }
            case 1200004: {
                int n = eventGeneric.getInt(2);
                long l = eventGeneric.getLong(3);
                if (n == -687821311 && l == 1L) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding changed after startup").log();
                    }
                    ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.mTarget.getTargetId(), -1400504064);
                    break;
                }
                if (n != -536825343 || l != 0) break;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Adaptation changed after startup").log();
                }
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.mTarget.getTargetId(), -1383726848);
                break;
            }
            case 100012: {
                try {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding Answer Event").log();
                    }
                    RadioCodingAdapter.mAmFmCodingData = (Coding)eventGeneric.getObject(1);
                    this.clearAllStationLists();
                    this.mTarget.initializeAmFmTuner(true);
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 100013: {
                this.answerDiagnosisAdaptationDataBeyondStartup(eventGeneric);
                break;
            }
            case 0x400004C4: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("pay HD option set to: ").append(bl);
                }
                if (bl) {
                    AmFmHDOptionRequester.setModeHD(1);
                    break;
                }
                AmFmHDOptionRequester.setModeHD(2);
                break;
            }
            case 1076141825: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("pay HD setup option set to: ").append(bl);
                }
                AmFmHDOptionRequester.fmSetup(true);
                AmFmHDOptionRequester.set(bl);
                AmFmHDOptionRequester.notifyDSI(bl, this.mTarget.getTargetId());
                AmFmStationListFM.setStationListIsFreezed(false);
                if (bl) break;
                AmFmFactory.getAslAmfmModelController().updateHDFilterinFM(false);
                RadioData.getAmfmDatabase().getSettingsPersistable().setFMHDFilter(false);
                RadioData.getAmfmDatabase().clearHdInformation();
                break;
            }
            case 1076141824: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("pay HD setup option set to: ").append(bl);
                }
                AmFmHDOptionRequester.fmSetup(false);
                AmFmHDOptionRequester.set(bl);
                AmFmHDOptionRequester.notifyDSI(bl, this.mTarget.getTargetId());
                if (bl) break;
                RadioData.getAmfmDatabase().clearHdInformation();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAMFMTunerUpdateAFSwitchStatus(boolean bl, int n) {
        if (RadioData.amFmTunerIsInitialized && 1 == n) {
            boolean bl2 = RadioData.getAmfmDatabase().getSettingsPersistable().getAFOption();
            if (bl2 != bl) {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> dsiAMFMTunerUpdateAFSwitchStatus in StateAmFmTop - north south mismatch : ").append("  HMI: ").append(bl2).append("  DSI-response: ").append(bl).log();
            }
            AmFmAlternativeFrequencySwitch.set(bl);
        }
    }

    public void dsiAMFMTunerUpdateREGSwitchStatus(int n, int n2) {
        if (RadioData.amFmTunerIsInitialized && 1 == n2) {
            AmfmRegStateOptionRequester.set(n);
        }
    }

    public void dsiAMFMTunerUpdateAvailability(int n, int n2) {
        ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> dsiAMFMTunerUpdateAvailability in StateAmFmTop").append("  availability: ").append(n).append("  validflag: ").append(n2).log();
        if (n2 != 1) {
            return;
        }
        if (2 == n) {
            ++RadioData.dsiAmFmTunerUpdateAvailabilityAvailableCount;
        }
        if (2 == n && RadioData.amFmTunerAvailabilityStatus != n && !ManagerTarget.isRadioActive) {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("update availability in StateTop: ").append(n).append("  validflag: ").append(n2).log();
            }
            if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2) && RadioData.amFmTunerIsInitialized && RadioData.dsiAmFmTunerUpdateAvailabilityAvailableCount > 1) {
                AmFmDsiApi.setSwitchLinkingDeviceUsageMode(2);
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentFMStation();
                this.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Retuning again because of ").append("  RadioData.dsiAmFmTunerUpdateAvailabilityAvailableCount: ").append(RadioData.dsiAmFmTunerUpdateAvailabilityAvailableCount).log();
                AmFmDsiApi.selectStation(amFmStation);
                AmFmDsiApi.setSwitchLinkingDeviceUsageMode(1);
            } else if (RadioData.amFmTunerIsInitialized) {
                int n3 = 1;
                if (!AmFmHDOptionRequester.getAm() && !AmFmHDOptionRequester.getFm()) {
                    n3 = 2;
                } else if (AmFmHDOptionRequester.getAm() && !AmFmHDOptionRequester.getFm()) {
                    n3 = 6;
                } else if (!AmFmHDOptionRequester.getAm() && AmFmHDOptionRequester.getFm()) {
                    n3 = 5;
                }
                AmFmHDOptionRequester.setModeHD(n3);
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> setModeHD() called in StateAmFmTop (dsiAMFMTunerUpdateAvailability) ").append("  hd_mode: ").append(n3).log();
            }
        }
        RadioData.amFmTunerAvailabilityStatus = n;
        this.mTarget.triggerAmFmPerformanceTrace();
    }

    public void dsiAMFMTunerUpdateHdMode(int n, int n2) {
        ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> dsiAMFMTunerUpdateHdMode in StateAmFmTop ").append(" hdMode: ").append(n).append("  validflag: ").append(n2).log();
        if (n2 != 1) {
            return;
        }
        if (!HsmTarget.hdFeedBack) {
            AmFmStation amFmStation;
            HsmTarget.hdFeedBack = true;
            if (RadioData.amFmTunerIsInitialized && AmFmDsiApi.doSwitchLinkingDeviceUsageMode == 2 && null != (amFmStation = RadioData.getAmfmDatabase().getCurrentStation())) {
                AmFmDsiApi.selectStation(amFmStation);
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> selectStation() called in dsiAMFMTunerUpdateHdMode in StateAmFmTop ").append(" CurrentStation: ").append(amFmStation.toString()).log();
            }
        }
        boolean bl = n != 2 && n != 0;
        if (n == 5) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setFMHDSetupOption(bl);
            AmFmFactory.getAslAmfmModelController().updateFMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption());
            RadioData.getAmfmDatabase().getSettingsPersistable().setAMHDSetupOption(false);
            AmFmFactory.getAslAmfmModelController().updateAMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption());
        } else if (n == 6) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setAMHDSetupOption(bl);
            AmFmFactory.getAslAmfmModelController().updateAMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption());
            RadioData.getAmfmDatabase().getSettingsPersistable().setFMHDSetupOption(false);
            AmFmFactory.getAslAmfmModelController().updateFMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption());
        } else {
            RadioData.getAmfmDatabase().getSettingsPersistable().setFMHDSetupOption(bl);
            AmFmFactory.getAslAmfmModelController().updateFMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption());
            RadioData.getAmfmDatabase().getSettingsPersistable().setAMHDSetupOption(bl);
            AmFmFactory.getAslAmfmModelController().updateAMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption());
        }
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AMFMTuner updateHDMode: ").append(n).append(" / ").append(bl).append("  valid flag: ").append(n2).log();
        }
    }

    public void dsiAMFMTunerUpdateStationListMW(Station[] stationArray, int n) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AMFMTuner updateStationList, received AM station list with ").append(stationArray.length).append(" stations").log();
            for (int i2 = 0; i2 < stationArray.length; ++i2) {
                new AmFmStation(stationArray[i2]).toLogString(this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN)).log();
            }
        }
        RadioData.getAmfmDatabase().getAslStationListAM().setMWStations(stationArray);
        AmFmStationListAM.currentAmStationList = AmFmStationList.copyStationList(stationArray);
        try {
            TileStationList tileStationList;
            if (RadioCodingAdapter.isRadioTileFeatureActivated() && RadioCurrentWaveband.isAm() && null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList()) && !RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                tileStationList.initTiles();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        if (RadioCurrentWaveband.isAm() && !this.mTarget.isStateActive(this.mTarget.stateAmFmActiveListView)) {
            RadioData.getAmfmDatabase().updateStationListToBap();
        }
    }

    public void dsiAMFMTunerUpdateStationListLW(Station[] stationArray, int n) {
        RadioData.getAmfmDatabase().getAslStationListAM().setLWStations(stationArray);
        if (RadioCurrentWaveband.isAm() && !this.mTarget.isStateActive(this.mTarget.stateAmFmActiveListView)) {
            RadioData.getAmfmDatabase().updateStationListToBap();
        }
    }

    public void dsiAMFMTunerUpdateStationList(Station[] stationArray, int n) {
        if (!this.mTarget.mManualMode) {
            Object object;
            if (null == stationArray) {
                return;
            }
            RadioData.getAmfmDatabase().getAslStationListFM().setFmStations(stationArray);
            RadioDataApi.requestFmRadioStationData(stationArray);
            try {
                if (RadioCodingAdapter.isRadioTileFeatureActivated()) {
                    AmFmStation[] amFmStationArray = RadioData.getAmfmDatabase().getAslStationListFM().getDeepListCopy();
                    RadioDataApi.requestRadioFmStationLogos(amFmStationArray, 19);
                    object = RadioServiceManager.getServiceManager().getTileStationList();
                    if (null != object && !RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible() && RadioCurrentWaveband.isFm()) {
                        ((TileStationList)object).initTiles();
                    }
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
            AmFmStationListFM.currentFmStationList = AmFmStationList.copyStationList(stationArray);
            RadioDataApi.calculateHomeCountry(stationArray);
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AMFMTuner updateStationList, received FM station list with ").append(stationArray.length).append(" stations").log();
                for (int i2 = 0; i2 < stationArray.length; ++i2) {
                    object = new AmFmStation(stationArray[i2]);
                    ((AmFmStation)object).toLogString(this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN)).log();
                }
            }
            if (RadioCurrentWaveband.isFm() && !this.mTarget.isStateActive(this.mTarget.stateAmFmActiveListView)) {
                RadioData.getAmfmDatabase().updateStationListToBap();
            }
        }
    }

    public void clearAllStationLists() {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTop - clearAllStationLists()").log();
            }
            this.dsiAMFMTunerUpdateStationList(new Station[0], 1);
            this.dsiAMFMTunerUpdateStationListMW(new Station[0], 1);
            this.dsiAMFMTunerUpdateStationListLW(new Station[0], 1);
            RadioData.getAmfmDatabase().getFixedStationList().clearAndMarkDirty();
            AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
            if (null != amFmStationList) {
                amFmStationList.updateStationListToHMI();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void answerDiagnosisAdaptationDataBeyondStartup(EventGeneric eventGeneric) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTop - answerDiagnosisAdaptationDataBeyondStartup()").log();
            }
            if (null == eventGeneric) {
                if (null != ServiceManager.logger) {
                    ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTop - answerDiagnosisAdaptationDataBeyondStartup() - null == genericEvent").log();
                }
                return;
            }
            if (null == RadioData.getAmfmDatabase()) {
                if (null != ServiceManager.logger) {
                    ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTop - answerDiagnosisAdaptationDataBeyondStartup() - null == RadioData.mAmfmDatabase").log();
                }
                return;
            }
            RadioAdaptationAdapter.mAmFmAdaptationData = (Adaptation)eventGeneric.getObject(1);
            RadioDataApi.initializeAfterStartUp();
            RadioData.getAmfmDatabase().getSettingsPersistable().setUserSelectedHomeCountry(-1);
            RadioDataApi.setHomeCountryAutoSelectionActive();
            RadioDataApi.generateCountryList();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

