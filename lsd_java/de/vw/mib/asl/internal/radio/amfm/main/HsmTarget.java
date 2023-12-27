/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.SystemLanguage;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActive;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveEmergencyScan;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveEmergencySeek;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveIdle;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveListUpdate;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveListView;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveScanMode;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveSeek;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveTASeek;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveTargetSeek;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmBandSwitch;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmInactiveIdle;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmTop;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmTrafficInformationJapan;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.radiotext.Radiotext;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextFactory;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmAlternativeFrequencySwitch;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmHDOptionRequester;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmAMBandRangeRequester;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmPTY31Option;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRadioTextOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRegStateOptionRequester;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmTPOption;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTarget;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.tagging.TaggingApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navservicesapi.DSINavServicesAPI;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public final class HsmTarget
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    protected DSINavServicesAPI dsiNavServicesAPI = null;
    protected DSIListener dsiNavServicesAPIListener = null;
    private final Radiotext mRadiotext;
    private final AnnouncementTarget mAnnouncement;
    final HsmState stateAmFmTop;
    final HsmState stateAmFmInactiveIdle;
    final HsmState stateAmFmActive;
    public final HsmState stateAmFmActiveListView;
    final HsmState stateAmFmActiveTASeek;
    final HsmState stateAmFmActiveSeek;
    final HsmState stateAmFmActiveTargetSeek;
    final HsmState stateAmFmBandSwitch;
    final HsmState stateAmFmActiveScanMode;
    final HsmState stateAmFmActiveIdle;
    final HsmState stateAmFmActiveListUpdate;
    final HsmState stateAmFmActiveEmergencySeek;
    final HsmState stateAmFmActiveEmergencyScan;
    final HsmState stateAmFmActiveTIJapan;
    HsmState mNextState = null;
    int mTuneDirection = 0;
    boolean mManualMode = false;
    int mSeekMode = 0;
    boolean mAutostore = false;
    boolean mSleep = false;
    AmFmStation mTargetStation = new AmFmStation();
    boolean audioConnectionTunerLwExists = false;
    public static Station selectedStationInfo = null;
    public boolean mAudioAvailable = true;
    public static boolean mIsTASliderActive = false;
    public static boolean waitingForStatusRunning = false;
    public static boolean waitingForUpdateSelectedStation = false;
    public static boolean seekAbort = false;
    public static boolean hdFeedBack = false;
    public static boolean stationTunedBySpeech = false;
    private boolean updateAmFmReadyFirstTime = true;
    public static int mHdstruct = -1;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTunerListener;

    public HsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        RadioServiceManager.getServiceManager().setRadioAmFMTarget(this);
        this.hsm.verbose = false;
        AmFmStationListFM.setRadioAmFMTarget(this);
        RadiotextFactory.createInstance(this.getMainObject());
        this.mRadiotext = RadiotextFactory.getRadioTextInstance();
        this.mAnnouncement = new AnnouncementTarget(this.getMainObject());
        this.stateAmFmTop = new StateAmFmTop(this, this.hsm, "stateAmFmTop", this.getWorkStateParent());
        this.stateAmFmInactiveIdle = new StateAmFmInactiveIdle(this, this.hsm, "stateAmFmInactiveIdle", this.stateAmFmTop);
        this.stateAmFmActive = new StateAmFmActive(this, this.hsm, "stateAmFmActive", this.stateAmFmTop, this.mRadiotext);
        this.stateAmFmActiveListView = new StateAmFmActiveListView(this, this.hsm, "stateAmFmActiveListView", this.stateAmFmActive, this.mRadiotext);
        this.stateAmFmActiveTASeek = new StateAmFmActiveTASeek(this, this.hsm, "stateAmFmActiveTASeek", this.stateAmFmActive);
        this.stateAmFmActiveSeek = new StateAmFmActiveSeek(this, this.hsm, "stateAmFmActiveSeek", this.stateAmFmActive);
        this.stateAmFmActiveTargetSeek = new StateAmFmActiveTargetSeek(this, this.hsm, "stateAmFmActiveTargetSeek", this.stateAmFmActive);
        this.stateAmFmBandSwitch = new StateAmFmBandSwitch(this, this.hsm, "stateAmFmActivePrepareTuning", this.stateAmFmActive);
        this.stateAmFmActiveScanMode = new StateAmFmActiveScanMode(this, this.hsm, "stateAmFmActiveScanMode", this.stateAmFmActive);
        this.stateAmFmActiveIdle = new StateAmFmActiveIdle(this, this.hsm, "stateAmFmActiveIdle", this.stateAmFmActive);
        this.stateAmFmActiveListUpdate = new StateAmFmActiveListUpdate(this, this.hsm, "stateAmFmActiveListUpdate", this.stateAmFmActive);
        this.stateAmFmActiveEmergencySeek = new StateAmFmActiveEmergencySeek(this, this.hsm, "stateAmFmActiveEmergencySeek", this.stateAmFmActive);
        this.stateAmFmActiveEmergencyScan = new StateAmFmActiveEmergencyScan(this, this.hsm, "stateAmFmActiveEmergencyScan", this.stateAmFmActive);
        this.stateAmFmActiveTIJapan = new StateAmFmTrafficInformationJapan(this, this.hsm, "stateAmFmTrafficInformationJapan", this.stateAmFmActive);
    }

    @Override
    public int getDefaultTargetId() {
        return ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM;
    }

    void start() {
        this.mRadiotext.start(this.getTaskId());
        this.mAnnouncement.start(this.getTaskId());
        AmFmDsiApi.start(ServiceManager.eventMain, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM_DSI, "hsmtask", this);
    }

    public boolean isActive() {
        return this.isStateActive(this.stateAmFmActive);
    }

    public boolean isActiveIdle() {
        return this.isStateActive(this.stateAmFmActiveIdle);
    }

    public boolean isActiveListView() {
        return this.isStateActive(this.stateAmFmActiveListView);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateAmFmTop;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 100264: 
            case 100265: 
            case 1076141841: 
            case 1076141842: 
            case 1076141843: 
            case 1076141844: 
            case 1076141845: 
            case 1076141846: 
            case 1076141847: 
            case 1076141848: 
            case 1076141849: 
            case 1076141850: {
                if (!RadioCodingAdapter.isRadioTileFeatureActivated()) break;
                RadioServiceManager.getServiceManager().getRadioTileEventHandling().gotEvent(eventGeneric);
                break;
            }
            case 4300042: {
                RadioData.setWriteToPersistenceEnabled(false);
                if (!ServiceManager.logger.isTraceEnabled(128)) break;
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("HsmTarget - gotEvent( ASLSystemServiceIds.SHUTDOWN_IMMINENT)").log();
                break;
            }
            case 4300054: {
                RadioData.setWriteToPersistenceEnabled(true);
                if (!ServiceManager.logger.isTraceEnabled(128)) break;
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("HsmTarget - gotEvent( ASLSystemServiceIds.TRANSITION_TO_ON)").log();
                break;
            }
            case 100212: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - gotEvent(RadioEvents.EV_TIMER_FM_STATION_LIST_FREEZING), AmFmStationListFM.setStationListIsFreezed( false )").log();
                }
                AmFmStationListFM.setStationListIsFreezed(false);
                break;
            }
            case 1076141834: {
                RadioDataApi.setUserSelectedHomeCountry(eventGeneric);
                break;
            }
            case 1076141840: {
                RadioDataApi.generateCountryList();
                break;
            }
            case 1076141833: {
                AmFmPresetApi.setAmfmPresetCountFromModel(eventGeneric);
                break;
            }
            case 40003: {
                int n = eventGeneric.getInt(0);
                String string = eventGeneric.getString(1);
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - LscTNGEventDeclaration.LSCTNG_CHANGE_LANGUAGE - transactionId = ").append(n).append(", newLanguage = ").append(string).log();
                }
                SystemLanguage.getInstance().setLanguage(string);
                EventGeneric eventGeneric2 = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1151074304);
                eventGeneric2.setInt(0, n);
                eventGeneric2.setBoolean(1, true);
                eventGeneric2.setString(2, string);
                this.send(eventGeneric2);
                break;
            }
            case 0x40000A00: {
                int n = eventGeneric.getInt(0);
                AmFmFactory.getInstanceEUStationListViewWalker().setFmStationListSortOrder(n);
                break;
            }
            default: {
                super.gotEvent(eventGeneric);
            }
        }
    }

    public void updateSelectedStation(AmFmStation amFmStation) {
        if (null != amFmStation) {
            AmFmStation amFmStation2;
            if (AmFmFactory.getAslAmfmPropertyManager().getManualModeActive() && AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency() != amFmStation.getFrequency()) {
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("update selected station, frequency: ").append(amFmStation.getFrequency()).log();
            }
            if ((amFmStation2 = new AmFmStation(amFmStation)) != null) {
                AmFmPresetApi.syncFmName(amFmStation2);
                RadioData.getAmfmDatabase().setCurrentStation(amFmStation2);
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation2);
                if (!(StateAmFmActiveTargetSeek.isTargetSeekActive() || StateAmFmActiveSeek.isSeekActive() || StateAmFmActiveEmergencySeek.isEmergencySeekActive())) {
                    AmFmPresetApi.autoCompare();
                }
            }
        }
    }

    public void updateSelectedStationHD(AmFmStation amFmStation) {
        if (amFmStation != null) {
            if (AmFmFactory.getAslAmfmPropertyManager().getManualModeActive() && AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency() != amFmStation.getFrequency()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget: Manual mode freq:").append(AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency()).append("recvd freq:").append(amFmStation.getFrequency()).log();
                }
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("update HD selected station, frequency: ").append(amFmStation.getFrequency()).log();
            }
            if (AmfmRDSOption.get() && amFmStation.getPi() > 0) {
                AmFmPresetApi.syncFmName(amFmStation);
            }
            RadioData.getAmfmDatabase().setCurrentStation(amFmStation);
            AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation);
            if (!(StateAmFmActiveTargetSeek.isTargetSeekActive() || StateAmFmActiveSeek.isSeekActive() || StateAmFmActiveEmergencySeek.isEmergencySeekActive())) {
                AmFmPresetApi.autoCompare();
            }
        }
    }

    public void notifyStationChangeForRadioText(AmFmStation amFmStation) {
        AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getOldStation();
        if (amFmStation2 != null) {
            int n = amFmStation2.getPi();
            int n2 = amFmStation.getPi();
            int n3 = amFmStation2.getFrequency();
            int n4 = amFmStation.getFrequency();
            if (amFmStation.isCoChannel()) {
                this.mRadiotext.notifyStationChange();
                return;
            }
            if (AmfmRDSOption.get() && RadioCodingAdapter.isPiActivated() && RadioCurrentWaveband.isFm() && (ProgramIdentification.isValidPI(n) || ProgramIdentification.isValidPI(n2))) {
                if (ProgramIdentification.isLocalStation(n2) && ProgramIdentification.isLocalStation(n) || !AmFmAlternativeFrequencySwitch.get()) {
                    if (n3 != n4 || n != n2) {
                        this.mRadiotext.notifyStationChange();
                    }
                } else if (n != n2) {
                    this.mRadiotext.notifyStationChange();
                }
            } else if (n3 != n4) {
                this.stopTimer(1988559104);
                TileStationList tileStationList = RadioServiceManager.getServiceManager().getTileStationList();
                if (null != tileStationList) {
                    tileStationList.stopTileCoverArtTimer();
                    RadioData.getAmfmDatabase().setTileCoverArtReceived(false);
                }
                this.mRadiotext.notifyStationChange();
            }
        }
        RadioData.getAmfmDatabase().setOldStation(amFmStation);
    }

    public void broadcastScanModeToFriends(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(-929169408, eventGeneric);
    }

    public void avoidRTandTPFlickering(boolean bl) {
        if (RadioCurrentWaveband.get() == 1) {
            if (bl) {
                if (RadioData.getAmfmDatabase().getSettingsPersistable().getTPOption()) {
                    AmfmTPOption.notifyHMI(false);
                }
                if (RadioData.getAmfmDatabase().getSettingsPersistable().getRadioTextOption()) {
                    AmFmFactory.getAslAmfmModelController().updateFmRadiotextAndState("", 2);
                    AmFmFactory.getAslAmfmModelController().setRadioTextBlocked(true);
                }
            } else {
                if (RadioData.getAmfmDatabase().getSettingsPersistable().getTPOption()) {
                    AmfmTPOption.notifyHMI(true);
                }
                if (RadioData.getAmfmDatabase().getSettingsPersistable().getRadioTextOption()) {
                    AmFmFactory.getAslAmfmModelController().setRadioTextBlocked(false);
                }
            }
        }
    }

    public void processDiagnosisData(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - processDiagnosisData()").log();
        }
        if (RadioCodingAdapter.mAmFmCodingData != null) {
            boolean bl2 = !RadioCodingAdapter.isAmDisabled();
            boolean bl3 = false;
            boolean bl4 = false;
            int n = RadioCodingAdapter.getAmTunerBandSettings();
            int n2 = RadioData.getAmfmDatabase().getSettingsPersistable().getAmRangeOption();
            if (AMFMUtil.getDSIAmBandRangeForCodingValue(n) != n2) {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("WARNING: AM BAND CODING CHANGED from: ").append(AMFMUtil.getDsiAmBandRangeStringForDsiValue(n2)).append(" (").append(n2).append(")").append(" to: ").append(AMFMUtil.getAmBandRangeCodingStringForCodingValue(n)).append(" (").append(n).append(")").log();
                this.processAMBandSetting(n, false, true);
                bl4 = true;
            } else {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("No AM band coding alteration - HMI value: ").append(AMFMUtil.getDsiAmBandRangeStringForDsiValue(n2)).append(" (").append(n2).append(")").append(" - Coding value: ").append(AMFMUtil.getAmBandRangeCodingStringForCodingValue(n)).append(" (").append(n).append(")").log();
                }
                this.processAMBandSetting(n, false, false);
            }
            int n3 = RadioCodingAdapter.getFmTunerBandSettings();
            int n4 = RadioData.getAmfmDatabase().getSettingsPersistable().getFmRangeOption();
            if (AMFMUtil.getHMIFmBandRangeForCodingValue(n3) != n4) {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("WARNING: FM BAND CODING CHANGED from: ").append(AMFMUtil.getDsiFmBandRangeStringForDsiValue(n4)).append(" (").append(n4).append(")").append(" to: ").append(AMFMUtil.getFmBandRangeCodingStringForCodingValue(n3)).append(" (").append(n3).append(")").log();
                this.processFMBandSetting(n3, true);
                bl4 = true;
            } else {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("No FM band coding alteration - HMI value: ").append(AMFMUtil.getDsiFmBandRangeStringForDsiValue(n4)).append(" (").append(n4).append(")").append(" - Coding value: ").append(AMFMUtil.getFmBandRangeCodingStringForCodingValue(n3)).append(" (").append(n3).append(")").log();
                this.processFMBandSetting(n3, false);
            }
            if (bl4) {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("processDiagnosisData() - Reseting AM FM tuner because of band change!").log();
                RadioData.resetAMFMTunerSettings();
            }
            this.processRadioCodingData(bl);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AM FM tuner coding:").log();
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding: AM Band Available: ").append(bl2).log();
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding: LW Activated: ").append(false).append(" (ignored by VW HMI)").log();
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding: AM Band Setting: ").append(AMFMUtil.getAmBandRangeCodingStringForCodingValue(n)).log();
                if (n <= 0) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding: ERROR: AM band setting undefined - using fallback 'AM_BANDRANGE_EU'").log();
                }
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding: FM Band Setting: ").append(AMFMUtil.getFmBandRangeCodingStringForCodingValue(n3)).log();
                if (n3 <= 0) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding ERROR: FM band setting undefined - using fallback 'FM_BANDRANGE_EU_RDW instead'").log();
                }
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding: RDS switch: ").append(RadioCodingAdapter.isRdsButtonVisible()).log();
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding: PI ignore: ").append(String.valueOf(!RadioCodingAdapter.isPiActivated())).log();
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding: Radio Text+ option: ").append(String.valueOf(RadioCodingAdapter.isRadioTextPlusActivated())).log();
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Coding: PTY31 option: ").append(String.valueOf(RadioCodingAdapter.isFmPty31AlarmOn())).log();
            }
        }
    }

    private void processRadioCodingData(boolean bl) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - processRadioCodingData()").log();
            }
            boolean bl2 = RadioCodingAdapter.isRdsButtonVisible();
            AmFmFactory.getAslAmfmModelController().updateRdsSetupOptionAvailable(bl2);
            boolean bl3 = RadioCodingAdapter.isPiActivated();
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                RadioData.getAmfmDatabase().getAslStationListFM().switchPIComparison();
            }
            AmFmFactory.getAslAmfmModelController().updatePICoding(bl3);
            if (bl) {
                if (!bl2 && bl3) {
                    this.enableRadioTextAndSetAdvancedTextTo(true);
                    RadioData.getAmfmDatabase().getSettingsPersistable().setFmStationListSortOrder(1);
                    AmfmTPOption.set(false);
                    AmfmTPOption.setTpOnBeforeRdsOff(false);
                    AmfmPTY31Option.set(true);
                } else if (bl2 && bl3) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setFmStationListSortOrder(1);
                    this.enableRadioTextAndSetAdvancedTextTo(true);
                    AmfmTPOption.set(false);
                    AmfmTPOption.setTpOnBeforeRdsOff(false);
                    AmfmPTY31Option.set(true);
                } else if (!bl2 && !bl3) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setFmStationListSortOrder(2);
                    this.enableRadioTextAndSetAdvancedTextTo(false);
                    AmfmTPOption.set(false);
                    AmfmTPOption.setTpOnBeforeRdsOff(false);
                    AmfmPTY31Option.set(true);
                } else if (bl2 && !bl3) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setFmStationListSortOrder(2);
                    if (RadioCodingAdapter.getFmTunerBandSettings() == 5) {
                        AmfmRadioTextOption.set(false);
                        AmfmRadioTextOption.setRadioTextOnBeforeRDSOff(false);
                        this.setAdvancedRadioText(false);
                    } else {
                        this.enableRadioTextAndSetAdvancedTextTo(false);
                    }
                    AmfmTPOption.set(false);
                    AmfmTPOption.setTpOnBeforeRdsOff(false);
                    AmfmPTY31Option.set(true);
                }
                AmfmRegStateOptionRequester.set(3);
                AmfmRegStateOptionRequester.setREGFixBeforeRDSOff(3);
            }
            if (bl || RadioData.getAmfmDatabase().getSettingsPersistable().isRdsValueInCoding() != RadioCodingAdapter.isRdsActivated()) {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("processCodingData : ").append(bl).append(" or persisted RDS value : ").append(RadioData.getAmfmDatabase().getSettingsPersistable().isRdsValueInCoding()).append(" is different from Coding value : ").append(RadioCodingAdapter.isRdsActivated()).log();
                RadioData.getAmfmDatabase().getSettingsPersistable().setRdsValueInCoding(RadioCodingAdapter.isRdsActivated());
                AmfmRDSOption.set(RadioCodingAdapter.isRdsActivated(), true);
            }
            if (bl || RadioData.getAmfmDatabase().getSettingsPersistable().isAfValueInCoding() != RadioCodingAdapter.isAfActivated()) {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("processCodingData : ").append(bl).append(" or persisted AF value : ").append(RadioData.getAmfmDatabase().getSettingsPersistable().isAfValueInCoding()).append(" is different from Coding value : ").append(RadioCodingAdapter.isAfActivated()).log();
                RadioData.getAmfmDatabase().getSettingsPersistable().setAfValueInCoding(RadioCodingAdapter.isAfActivated());
                AmFmAlternativeFrequencySwitch.set(RadioCodingAdapter.isAfActivated());
                AmFmAlternativeFrequencySwitch.setAFOnBeforeRDSOff(RadioCodingAdapter.isAfActivated());
            }
            if (!bl2 && bl3) {
                AmfmPTY31Option.set(true);
            } else if (bl2 && bl3) {
                AmfmPTY31Option.set(true);
            } else if (!bl2 && !bl3) {
                AmfmRegStateOptionRequester.set(3);
                AmfmRegStateOptionRequester.setREGFixBeforeRDSOff(3);
                AmfmTPOption.set(false);
                AmfmTPOption.setTpOnBeforeRdsOff(false);
                AmfmPTY31Option.set(true);
            } else if (bl2 && !bl3) {
                AmfmRegStateOptionRequester.set(3);
                AmfmRegStateOptionRequester.setREGFixBeforeRDSOff(3);
                AmfmTPOption.set(false);
                AmfmTPOption.setTpOnBeforeRdsOff(false);
                AmfmPTY31Option.set(true);
            }
            AmFmFactory.getAslAmfmModelController().updateRadioTextPlusSetupOptionAvailable(RadioCodingAdapter.isRadioTextPlusActivated());
            boolean bl4 = RadioCodingAdapter.isFmPty31AlarmOn();
            ServiceManager.logger.info(8192).append("[ApiAnnouncement]FM-PTY31 Coding: ").append(bl4).log();
            AmfmPTY31Option.set(bl4);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void enableRadioTextAndSetAdvancedTextTo(boolean bl) {
        AmfmRadioTextOption.set(true);
        AmfmRadioTextOption.setRadioTextOnBeforeRDSOff(true);
        this.setAdvancedRadioText(bl);
    }

    private void setAdvancedRadioText(boolean bl) {
        AmfmRadioTextOption.setEnhancedRadioTextOption(bl);
        RadioData.getAmfmDatabase().getSettingsPersistable().setEnhancedRadioTextOptionBeforeRdsOff(bl);
    }

    private void processAMBandSetting(int n, boolean bl, boolean bl2) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - processAMBandSetting()").log();
        }
        if (null != RadioCodingAdapter.mAmFmCodingData) {
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerOff(n)) {
                this.updateAmBandRanges(RadioConstants.AM_BANDRANGE_AUS);
                AmFmFactory.getAslAmfmModelController().updateAMFrequencyScale(3);
                AmfmAMBandRangeRequester.set(5);
                if (bl2) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentAmStation(new AmFmStation(3, (int)RadioConstants.AM_BANDRANGE_AUS.getLowerLimit()));
                }
            } else if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerEu(n)) {
                if (bl) {
                    this.updateAmBandRanges(RadioConstants.AM_BANDRANGE_EU_LW);
                    AmFmFactory.getAslAmfmModelController().updateAMFrequencyScale(3);
                    AmfmAMBandRangeRequester.set(4);
                    if (bl2) {
                        RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentAmStation(new AmFmStation(3, (int)RadioConstants.AM_BANDRANGE_EU_RDW.getLowerLimit()));
                    }
                } else {
                    this.updateAmBandRanges(RadioConstants.AM_BANDRANGE_EU);
                    AmFmFactory.getAslAmfmModelController().updateAMFrequencyScale(4);
                    AmfmAMBandRangeRequester.set(2);
                    if (bl2) {
                        RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentAmStation(new AmFmStation(3, (int)RadioConstants.AM_BANDRANGE_EU_RDW.getLowerLimit()));
                    }
                }
            } else if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerEuRdw(n)) {
                this.updateAmBandRanges(RadioConstants.AM_BANDRANGE_EU_RDW);
                AmFmFactory.getAslAmfmModelController().updateAMFrequencyScale(0);
                AmfmAMBandRangeRequester.set(2);
                if (bl2) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentAmStation(new AmFmStation(3, (int)RadioConstants.AM_BANDRANGE_EU_RDW.getLowerLimit()));
                }
            } else if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerJp(n)) {
                this.updateAmBandRanges(RadioConstants.AM_BANDRANGE_JP);
                AmFmFactory.getAslAmfmModelController().updateAMFrequencyScale(2);
                AmfmAMBandRangeRequester.set(3);
                if (bl2) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentAmStation(new AmFmStation(3, (int)RadioConstants.AM_BANDRANGE_JP.getLowerLimit()));
                }
            } else if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerNar(n)) {
                this.updateAmBandRanges(RadioConstants.AM_BANDRANGE_NAR);
                AmFmFactory.getAslAmfmModelController().updateAMFrequencyScale(1);
                AmfmAMBandRangeRequester.set(1);
                if (bl2) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentAmStation(new AmFmStation(3, (int)RadioConstants.AM_BANDRANGE_NAR.getLowerLimit()));
                }
            } else {
                this.warn("AMFM: processAMBandSetting: Coding.BAND_AM_NO_SETTING, setting band settings to default");
                this.updateAmBandRanges(RadioConstants.AM_BANDRANGE_EU_RDW);
                AmFmFactory.getAslAmfmModelController().updateAMFrequencyScale(4);
                AmfmAMBandRangeRequester.set(2);
                if (bl2) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentAmStation(new AmFmStation(3, (int)RadioConstants.AM_BANDRANGE_EU_RDW.getLowerLimit()));
                }
            }
            if (bl2) {
                this.getTextLogger().info(this.getClassifier()).append("### RESETTING AM LSM STATION! New LSM: ").append(RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentAmStation().toString()).log();
            }
        }
    }

    private void processFMBandSetting(int n, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - processFMBandSetting()").log();
        }
        if (null != RadioCodingAdapter.mAmFmCodingData) {
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerChina(n)) {
                this.updateFmBandRanges(RadioConstants.FM_BANDRANGE_CHINA);
                AmFmFactory.getAslAmfmModelController().updateFmFrequencyScale(4);
                RadioData.getAmfmDatabase().getSettingsPersistable().setFmRangeOption(4);
                if (bl) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentFmStation(new AmFmStation(1, (int)RadioConstants.FM_BANDRANGE_CHINA.getLowerLimit()));
                }
            } else if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerEuRdw(n)) {
                this.updateFmBandRanges(RadioConstants.FM_BANDRANGE_EU_RDW);
                AmFmFactory.getAslAmfmModelController().updateFmFrequencyScale(0);
                RadioData.getAmfmDatabase().getSettingsPersistable().setFmRangeOption(0);
                if (bl) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentFmStation(RadioConstants.FM_DEFAULT_STATION_EU_RDW);
                }
            } else if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerJp(n)) {
                this.updateFmBandRanges(RadioConstants.FM_BANDRANGE_JP);
                AmFmFactory.getAslAmfmModelController().updateFmFrequencyScale(2);
                RadioData.getAmfmDatabase().getSettingsPersistable().setFmRangeOption(2);
                if (bl) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentFmStation(new AmFmStation(1, (int)RadioConstants.FM_BANDRANGE_JP.getLowerLimit()));
                }
            } else if (n == 8) {
                this.updateFmBandRanges(RadioConstants.FM_BANDRANGE_JP_EXTENDED);
                AmFmFactory.getAslAmfmModelController().updateFmFrequencyScale(5);
                RadioData.getAmfmDatabase().getSettingsPersistable().setFmRangeOption(5);
                if (bl) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentFmStation(new AmFmStation(1, (int)RadioConstants.FM_BANDRANGE_JP_EXTENDED.getLowerLimit()));
                }
            } else if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerKor(n)) {
                this.updateFmBandRanges(RadioConstants.FM_BANDRANGE_KOR);
                AmFmFactory.getAslAmfmModelController().updateFmFrequencyScale(3);
                RadioData.getAmfmDatabase().getSettingsPersistable().setFmRangeOption(3);
                if (bl) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentFmStation(new AmFmStation(1, (int)RadioConstants.FM_BANDRANGE_KOR.getLowerLimit()));
                }
            } else if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerNar(n)) {
                this.updateFmBandRanges(RadioConstants.FM_BANDRANGE_NAR);
                AmFmFactory.getAslAmfmModelController().updateFmFrequencyScale(1);
                RadioData.getAmfmDatabase().getSettingsPersistable().setFmRangeOption(1);
                if (bl) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentFmStation(new AmFmStation(1, (int)RadioConstants.FM_BANDRANGE_NAR.getLowerLimit()));
                }
            } else {
                this.warn("AMFM: processFMBandSetting: Coding.BAND_FM_NO_SETTING, setting band settings to default");
                this.updateFmBandRanges(RadioConstants.FM_BANDRANGE_EU_RDW);
                AmFmFactory.getAslAmfmModelController().updateFmFrequencyScale(0);
                RadioData.getAmfmDatabase().getSettingsPersistable().setFmRangeOption(0);
                if (bl) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentFmStation(new AmFmStation(1, (int)RadioConstants.FM_BANDRANGE_EU_RDW.getLowerLimit()));
                }
            }
            if (bl) {
                this.getTextLogger().info(this.getClassifier()).append("### RESETTING FM LSM STATION! New LSM: ").append(RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentFmStation().toString()).log();
            }
        }
    }

    private void updateFmBandRanges(WavebandInfo wavebandInfo) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("FM band range update:  limit low: ").append(wavebandInfo.lowerLimit).append("  limit high: ").append(wavebandInfo.getUpperLimit()).append("  step width: ").append(wavebandInfo.getStepWidth()).log();
        }
        AmFmFactory.getAslAmfmModelController().updateFmFrequencyMinValue((int)wavebandInfo.getLowerLimit());
        AmFmFactory.getAslAmfmModelController().updateFmFrequencyMaxValue((int)wavebandInfo.getUpperLimit());
        AmFmFactory.getAslAmfmModelController().updateFmFrequencyStepValue((int)wavebandInfo.getStepWidth());
    }

    private void updateAmBandRanges(WavebandInfo wavebandInfo) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AM band range update:  limit low: ").append(wavebandInfo.lowerLimit).append("  limit high: ").append(wavebandInfo.getUpperLimit()).append("  step width: ").append(wavebandInfo.getStepWidth()).log();
        }
        AmFmFactory.getAslAmfmModelController().updateAmFrequencyMaxValue((int)wavebandInfo.getUpperLimit());
        AmFmFactory.getAslAmfmModelController().updateAmFrequencyMinValue((int)wavebandInfo.getLowerLimit());
        AmFmFactory.getAslAmfmModelController().updateAmFrequencyStepValue((int)wavebandInfo.getStepWidth());
    }

    void loadPersistence() {
        RadioServiceManager.getServiceManager().getAdapterAslPersistence().loadPersistenceInitially();
        RadioData.getAmfmDatabase().getFixedStationList().fromPersistence();
    }

    public void initializeAmFmTuner(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - initializeAmFmTuner() - START").log();
        }
        AmFmFactory.getAslAmfmModelController().updateIsHongKongVariant(RadioCodingAdapter.isHongKongVariant());
        AmFmFactory.getAslAmfmModelController().updateIsSetupTrafficProgramButtonAvailable(RadioCodingAdapter.isPiActivated() && !RadioCodingAdapter.isHongKongVariant());
        AmFmFactory.getAslAmfmModelController().updateIsSetupAdvancedRdsRegButtonAvailable(RadioCodingAdapter.isPiActivated() && !RadioCodingAdapter.isHongKongVariant());
        this.processDiagnosisData(bl);
        AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentFmStation());
        AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentAmStation());
        AmfmRadioTextOption.setEnhancedRadioTextOption(RadioData.getAmfmDatabase().getSettingsPersistable().isEnhancedRadioTextActive());
        AmFmAlternativeFrequencySwitch.notifyHMI();
        AmfmAMBandRangeRequester.notifyDSI();
        AmfmRadioTextOption.notifyHMI();
        AmfmScopeOfArrowKeys.notifyHMI();
        AmfmRDSOption.notifyDSI();
        AmfmRDSOption.notifyHMI();
        AmfmRDSOption.notifyFriends();
        AmFmFactory.getAslAmfmModelController().updateRadioTextPlusSetupState(RadioData.getAmfmDatabase().getSettingsPersistable().getRadioTextPlusOption());
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            AmFmHDOptionRequester.notifyHMIAmFm();
            AmFmHDOptionRequester.notifyDSIHDMode(AmFmHDOptionRequester.getAm(), this.getTargetId());
            ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> notifyDSIHDMode() called in HsmTarget (initializeAmFmTuner())").append("  AmFmHDOptionRequester: ").append(AmFmHDOptionRequester.getAm()).log();
            TaggingApi.requestTagInstance(RadioData.getAmfmDatabase().getTaggingInstance() <= -1);
        }
        int n = RadioCurrentWaveband.get();
        RadioCurrentWaveband.set(n);
        boolean bl2 = AmfmTPOption.get();
        AmfmTPOption.notifyHMI(bl2);
        AmfmTPOption.notifyFriends(bl2);
        if (bl && RadioCodingAdapter.isAmDisabled() && ManagerTarget.isRadioActive) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, 1);
            this.triggerObserver(-2096889792, eventGeneric);
        }
        AmFmFactory.getAslAmfmModelController().updateLogoAutoStoreActive(RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive());
        RadioData.amFmTunerIsInitialized = true;
        AmFmAlternativeFrequencySwitch.notifyDSI(AmFmAlternativeFrequencySwitch.get());
        AmfmRegStateOptionRequester.notifyDsi(AmfmRegStateOptionRequester.get());
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - initializeAmFmTuner() - END").log();
        }
        if (bl) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreLogoActiveChangedByUser(false);
        }
        RadioDataSessionManager.getInstance().countryList.setSetupAutoStoreStationLogoSwitchOnOrOff();
    }

    public void initializeAmFmPresets() {
        AmFmPresetApi.start(this);
        AmFmPresetApi.fromPersistence();
        AmFmPresetApi.updateDSI();
    }

    public void registerObservers() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - registerObservers()").log();
        }
        this.addObserver(161424448);
        this.addObserver(-1979449280);
        this.addObserver(-1962672064);
        this.addObserver(-1929117632);
        this.addObserver(-1895563200);
        this.addObserver(-1845231552);
        this.addObserver(-1828454336);
        this.addObserver(0x4A040040);
        this.addObserver(-1811677120);
        this.addObserver(-1459355584);
        this.addObserver(-1593573312);
        this.addObserver(-1727791040);
        this.addObserver(-402390976);
        this.addObserver(-1023147968);
        this.addObserver(-1711013824);
        this.addObserver(-1509687232);
        this.addObserver(-1140588480);
        this.addObserver(127870016);
        this.addObserver(-1073151936);
        this.addObserver(1745551424);
        this.addObserver(-1123811264);
        this.addObserver(-872153024);
        this.addObserver(-855375808);
        this.addObserver(-754712512);
        this.addObserver(-805044160);
        this.addObserver(-788266944);
        this.addObserver(-654049216);
        this.addObserver(-620494784);
        this.addObserver(-1560018880);
        this.addObserver(-1543241664);
        this.addObserver(-1526464448);
        this.addObserver(-469499840);
        this.addObserver(-452722624);
        this.addObserver(-435945408);
        this.addObserver(-1341915072);
        this.addObserver(-972816320);
        this.addObserver(1107689536);
        this.addObserver(-989593536);
        this.addObserver(-956039104);
        this.addObserver(-939261888);
        this.addObserver(-922484672);
        this.addObserver(-888930240);
        this.addObserver(-821821376);
        this.addObserver(-670826432);
        this.addObserver(-603717568);
        this.addObserver(-385613760);
        this.addObserver(-536608704);
        this.addObserver(655424);
        this.addObserver(77538368);
        this.addObserver(-1325137856);
        this.addObserver(-1308360640);
        this.addObserver(-1442578368);
        this.addObserver(27206720);
        this.addObserver(10429504);
        this.addObserver(111092800);
        this.addObserver(94315584);
        this.addObserver(557853696);
        this.addObserver(-509739008);
        this.addObserver(-660733952);
        this.addObserver(-425852928);
        this.addObserver(-967043840);
        this.addObserver(-2096693184);
        this.addObserver(-2079915968);
        this.addObserver(1225130048);
        this.addObserver(-486277056);
        this.addObserver(-536608704);
        this.addObserver(-2029780928);
        this.addObserver(420035840);
        this.addObserver(453590272);
        this.addObserver(178201664);
        this.addObserver(278864960);
        this.addObserver(-2096889792);
        this.addObserver(983508032);
        this.addObserver(614285568);
        this.addObserver(178077952);
        this.addObserver(379404544);
        this.addObserver(252263680);
        this.addObserver(352926976);
        this.registerService(-761397248);
        this.addObserver(-761397248);
        this.addObserver(-2075192832);
        this.addObserver(-1017375488);
        this.addObserver(1134297088);
        RadioServiceManager.getServiceManager().getRadioTileEventHandling().registerObservers(this);
        ServiceRegister serviceRegister = this.getServiceRegister();
        serviceRegister.registerService(-929169408, 0, 0, 0, false, true);
        serviceRegister.registerService(-778174464, 0, 0, 0, false, true);
        serviceRegister.registerService(-845283328, 0, 0, 0, false, true);
        serviceRegister.registerService(-727842816, 0, 0, 0, false, true);
        serviceRegister.registerService(1268973568, 0, 0, 0, false, true);
        serviceRegister.registerService(1285750784, 0, 0, 0, false, true);
        serviceRegister.registerService(1302528000, 0, this.getTargetId(), 0, false, true);
        serviceRegister.registerService(1319305216, 0, this.getTargetId(), 0, false, true);
        serviceRegister.registerService(1336082432, 0, this.getTargetId(), 0, false, true);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1083965440);
        eventGeneric.setInt(0, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM);
        eventGeneric.setInt(1, 0);
        eventGeneric.setString(2, SystemLanguage.getInstance().getLanguage());
        this.sendSafe(eventGeneric);
    }

    void setNotification() {
        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = HsmTarget.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener);
        ServiceManager.dsiServiceLocator.addResponseListener(this, class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = HsmTarget.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener, dSIListener);
        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
        if (null != dSIAMFMTuner) {
            dSIAMFMTuner.setNotification(7, dSIListener);
            dSIAMFMTuner.setNotification(9, dSIListener);
            dSIAMFMTuner.setNotification(14, dSIListener);
            dSIAMFMTuner.setNotification(13, dSIListener);
            dSIAMFMTuner.setNotification(8, dSIListener);
            dSIAMFMTuner.setNotification(2, dSIListener);
            dSIAMFMTuner.setNotification(4, dSIListener);
            dSIAMFMTuner.setNotification(3, dSIListener);
            dSIAMFMTuner.setNotification(18, dSIListener);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                dSIAMFMTuner.setNotification(20, dSIListener);
                dSIAMFMTuner.setNotification(15, dSIListener);
                dSIAMFMTuner.setNotification(17, dSIListener);
                dSIAMFMTuner.setNotification(16, dSIListener);
            } else {
                dSIAMFMTuner.setNotification(1, dSIListener);
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - registered()").log();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(423) && string.intern() == RuntimeGeneratedConstants.SERVICE_TS_NS[84]) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - registered() - dsiNavServicesAPIListener").log();
            }
            this.dsiNavServicesAPI.setNotification(4, this.dsiNavServicesAPIListener);
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    public void updateGui(AmFmStation amFmStation) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - updateGui()").log();
        }
        if (null != amFmStation) {
            AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency(amFmStation.getFrequency());
            this.updateSelectedStation(amFmStation);
            AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(RadioData.getAmfmDatabase().getCurrentStation()), AmFmPresetApi.getCurrentIndex());
            AmFmFactory.getAslAmfmModelController().updateLogoToHmi();
            try {
                TileStationList tileStationList;
                if (RadioCodingAdapter.isRadioTileFeatureActivated() && (RadioCurrentWaveband.isAm() || RadioCurrentWaveband.isFm()) && !RadioServiceManager.getServiceManager().getTileStationList().isStationSelectionByTiles() && null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) {
                    if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                        tileStationList.updateSelectedAmFmStation(amFmStation, 1170613248);
                    }
                    if (RadioServiceManager.getServiceManager().getTileStationList().isTileLVisible()) {
                        tileStationList.updateSelectedAmFmStation(amFmStation, 1153836032);
                    }
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public void updateGuiHD(AmFmStation amFmStation) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - updateGuiHD()").log();
        }
        if (null != amFmStation) {
            AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency(amFmStation.getFrequency());
            this.updateSelectedStationHD(amFmStation);
            AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(RadioData.getAmfmDatabase().getCurrentStation()), AmFmPresetApi.getCurrentIndex());
            if (!StateAmFmActive.isSpsCovertArtRemovalTimerRunning && !RadioData.getAmfmDatabase().isMpsCoverArtRemovalTimerRunning()) {
                AmFmFactory.getAslAmfmModelController().updateLogoToHmi();
            } else if (!amFmStation.isHD()) {
                AmFmFactory.getAslAmfmModelController().updateLogoInStationView(null);
            }
            try {
                TileStationList tileStationList;
                if (RadioCodingAdapter.isRadioTileFeatureActivated() && (RadioCurrentWaveband.isAm() || RadioCurrentWaveband.isFm()) && (RadioServiceManager.getServiceManager().getTileStationList().isTileLVisible() || RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) && null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) {
                    tileStationList.updateSelectedAmFmStation(amFmStation, 1170613248);
                    tileStationList.updateSelectedAmFmStation(amFmStation, 1153836032);
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public void startStationListFreezedTimer() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - startStationListFreezedTimer()").log();
        }
        this.startTimer(1955004672, (long)0, false);
    }

    public void restartStationListFreezedTimer() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - restartStationListFreezedTimer()").log();
        }
        this.restartTimer(1955004672);
    }

    public void stopStationListFreezedTimer() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - stopStationListFreezedTimer()").log();
        }
        this.stopTimer(1955004672);
    }

    public void checkDsiAMFMTunerUpdateSelectedStation(Station station) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("HsmTarget - checkDsiAMFMTunerUpdateSelectedStation()").log();
        }
        if (!RadioCodingAdapter.isRdsActivated() && !RadioCodingAdapter.isRdsButtonVisible()) {
            station.name = "";
        }
        if (!station.rds) {
            station.pi = -1;
            station.tp = false;
            station.ta = false;
        }
        if (!RadioCodingAdapter.isPiActivated()) {
            station.tp = false;
            station.ta = false;
        }
        if (station.isCoChannel()) {
            station.name = "";
        }
        if (!AmfmRDSOption.get()) {
            station.name = "";
            station.scrollingPS = false;
        }
        selectedStationInfo = station;
    }

    public void logDsiAMFMTunerUpdateSelectedStation(Station station, String string) {
        if (null == station) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(string).append(" - dsiAMFMTunerUpdateSelectedStation - selectedStation == null").log();
            }
        } else if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(string).append(" - dsiAMFMTunerUpdateSelectedStation - frequency: ").append(station.getFrequency()).append(" Name = ").append(station.name).append(" ShortName = ").append(station.shortNameHD).append(" HD = ").append(station.hd).append(" Service ID = ").append(station.serviceId).log();
        }
    }

    public static boolean isUpdateSelectedStationValid(int n, Station station) {
        if (waitingForStatusRunning || n != 1 || !RadioData.amFmTunerIsInitialized || null == station || RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
            return false;
        }
        waitingForUpdateSelectedStation = false;
        return true;
    }

    void triggerAmFmPerformanceTrace() {
        if (this.updateAmFmReadyFirstTime && null != ServiceManager.perfService && RadioData.amFmTunerIsInitialized && RadioData.amFmTunerAvailabilityStatus == 2) {
            this.updateAmFmReadyFirstTime = false;
            ServiceManager.perfService.performanceLogMsgByID(2);
            ServiceManager.perfService.performanceLogMsgByID(3);
        }
    }

    public boolean isListViewActive() {
        return this.isStateActive(this.stateAmFmActiveListView);
    }

    public void fireModelStopScanOrSeekEvent() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("firing STOP_SCAN or STOP_SEEK model event because Speech is Active ").log();
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            if (RadioServiceManager.getServiceManager().isScanIsActive()) {
                this.triggerObserver(-670826432, eventGeneric);
            } else if (RadioServiceManager.getServiceManager().isSeekIsActive()) {
                this.triggerObserver(-654049216, eventGeneric);
            }
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

