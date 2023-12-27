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
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActive;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.amfm.radiotext.Radiotext;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.radio.Station;

public final class StateAmFmActiveListView
extends AbstractHsmState {
    private Logger logger = ServiceManager.logger;
    private final HsmTarget mTarget;
    private boolean timerUpdateSelectedStationDelayOn = false;
    private Station bufferedStation = null;
    private final Radiotext mRadiotext;

    StateAmFmActiveListView(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState, Radiotext radiotext) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
        this.mRadiotext = radiotext;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActiveListView is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                AmFmStationListFM.setStationListIsFreezed(false);
                this.timerUpdateSelectedStationDelayOn = false;
                break;
            }
            case 3: {
                AmFmStationList amFmStationList;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("HSM_START").log();
                }
                if (this.logger.isTraceEnabled(128)) {
                    int n = -1;
                    AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                    if (null != amFmStation) {
                        n = amFmStation.getWaveband();
                    }
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("entering station list, waveband: ").append(n).log();
                }
                if (RadioCurrentWaveband.isFm()) {
                    AmFmFactory.getInstanceEUStationListViewWalker().setFmComparator();
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2) && null != AmFmFactory.getAslAmfmModelController()) {
                    AmFmFactory.getAslAmfmModelController().updateHDFilterinFM(RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDFilter());
                    AmFmFactory.getAslAmfmModelController().updateHDFilterinAM(RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDFilter());
                }
                if (null == (amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList())) break;
                amFmStationList.updateStationListToHMI();
                RadioSystemEventsUtil.sendListUpdateFinished();
                break;
            }
            case 4: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("HSM_EXIT").log();
                }
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(AmFmFactory.getInstanceEUStationListViewWalker().getCurrentStation());
                RadioData.getAmfmDatabase().updateStationListToBap();
                if (this.timerUpdateSelectedStationDelayOn) {
                    this.mTarget.stopTimer(1753678080);
                }
                AmFmStationList.setListItemPressed(false);
                RadioData.getAmfmDatabase().setStationListViewIsOpen(false);
                break;
            }
            case 1073742986: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("ASL_RADIO_ACTIVATE_NEXT_LIST_STATION").log();
                }
                this.startTimer();
                AmFmFactory.getInstanceEUStationListViewWalker().nextStation();
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) break;
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(554);
                break;
            }
            case 1073742989: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("ASL_RADIO_ACTIVATE_PREVIOUS_LIST_STATION").log();
                }
                this.startTimer();
                AmFmFactory.getInstanceEUStationListViewWalker().previousStation();
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) break;
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(554);
                break;
            }
            case 1073742987: {
                this.startTimer();
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    HsmTarget.stationTunedBySpeech = true;
                    RadioData.getAmfmDatabase().skipStation(0);
                } else {
                    AmFmFactory.getInstanceEUStationListViewWalker().nextStation();
                }
                hsmState = null;
                break;
            }
            case 1073742991: {
                this.startTimer();
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    HsmTarget.stationTunedBySpeech = true;
                    RadioData.getAmfmDatabase().skipStation(1);
                } else {
                    AmFmFactory.getInstanceEUStationListViewWalker().previousStation();
                }
                hsmState = null;
                break;
            }
            case 1073742994: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - ASLRadioServiceConstants.ACTIVATE_STATION").log();
                }
                int n = eventGeneric.getInt(0);
                this.activateStation(n);
                break;
            }
            case 100260: 
            case 1073742995: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - ASLRadioServiceConstants.ACTIVATE_STATION_BY_ID").log();
                }
                this.tuneStationTriggeredBySpeechControl(eventGeneric);
                hsmState = null;
                break;
            }
            case 0x4000044A: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - ASLRadioBapServiceConstants.ACTIVATE_STATION_BY_ID").log();
                }
                long l = eventGeneric.getLong(0);
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - ASLRadioBapServiceConstants.ACTIVATE_STATION_BY_ID - stationId : ").append(l).log();
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    AmFmStation amFmStation = null;
                    AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
                    if (null != amFmStationList) {
                        amFmStation = amFmStationList.getByID(l);
                    }
                    if (amFmStation == null) {
                        amFmStation = RadioUtil.cumputeStationFromUniqueID(l);
                    }
                    if (amFmStation.isSubService()) {
                        AmFmFactory.getInstanceEUStationListViewWalker().tuneSubStation(amFmStation);
                    } else {
                        AmFmFactory.getInstanceEUStationListViewWalker().tuneStation(amFmStation);
                    }
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(554);
                    break;
                }
                this.activateStationById(l);
                break;
            }
            case 1073743009: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - ASLRadioServiceConstants.EXIT_STATION_LIST").log();
                }
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 100200: {
                this.timerUpdateSelectedStationDelayOn = false;
                if (this.bufferedStation != null) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("EV_AMFM_TIMER_AUTOCOMPARE - Update buffered station: ").append(this.bufferedStation.toString()).log();
                    }
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        if (this.bufferedStation.getServiceId() > 1) {
                            AmFmFactory.getInstanceEUStationListViewWalker().updateSubStationWithListIndexChange(this.bufferedStation);
                        } else {
                            AmFmFactory.getInstanceEUStationListViewWalker().updateStationWithListIndexChange(this.bufferedStation);
                        }
                    } else {
                        AmFmFactory.getInstanceEUStationListViewWalker().updateStationListItem(this.bufferedStation);
                    }
                    this.bufferedStation = null;
                    break;
                }
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("EV_AMFM_TIMER_AUTOCOMPARE -  mBufferedStation == null").log();
                break;
            }
            case 0x400004AA: {
                AmFmStationList amFmStationList;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("EV_AMFM_TIMER_AUTOCOMPARE").log();
                }
                if (null == (amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList())) break;
                amFmStationList.updateStationListToHMI();
                break;
            }
            case 1073742983: {
                int n = eventGeneric.getInt(0);
                if (AmFmFactory.getInstanceEUStationListViewWalker().getCurrentSubListIndex() != n) {
                    ListManager.getGenericASLList(3094).setActiveIndex(n);
                    AmFmFactory.getInstanceEUStationListViewWalker().tuneSubStation(n);
                }
                AmFmFactory.getAslAmfmModelController().updateFrequencyToStoreOnPreset(AmFmFactory.getInstanceEUStationListViewWalker().getCurrentStation());
                break;
            }
            case 1073743017: {
                break;
            }
            case 100222: {
                AmFmFactory.getInstanceEUStationListViewWalker().updateActiveListItem();
                break;
            }
            case 0x40000494: {
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) break;
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(554);
                break;
            }
            case 1076141830: {
                boolean bl = eventGeneric.getBoolean(0);
                RadioData.getAmfmDatabase().getSettingsPersistable().setFMHDFilter(bl);
                AmFmFactory.getAslAmfmModelController().updateHDFilterinFM(RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDFilter());
                AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
                if (null != amFmStationList) {
                    amFmStationList.updateStationListToHMI();
                }
                try {
                    TileStationList tileStationList;
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    tileStationList.initTiles();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 1076141829: {
                boolean bl = eventGeneric.getBoolean(0);
                RadioData.getAmfmDatabase().getSettingsPersistable().setAMHDFilter(bl);
                AmFmFactory.getAslAmfmModelController().updateHDFilterinAM(RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDFilter());
                AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
                if (null == amFmStationList) break;
                amFmStationList.updateStationListToHMI();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public HsmState dsiAMFMTunerUpdateSelectedStation(Station station, int n) {
        try {
            boolean bl;
            Object object;
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - dsiAMFMTunerUpdateSelectedStation( ").append(station.toString()).append(", ").append(n).append(" )").log();
            }
            if (!HsmTarget.isUpdateSelectedStationValid(n, station)) {
                return null;
            }
            this.mTarget.logDsiAMFMTunerUpdateSelectedStation(station, "StateAmFmActiveListView");
            if (!StateAmFmActive.isDsiStationValid(station)) {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - dsiAMFMTunerUpdateSelectedStation() - StateAmFmActive.isDsiStationValid() == false").log();
                }
                return null;
            }
            this.mTarget.checkDsiAMFMTunerUpdateSelectedStation(station);
            boolean bl2 = false;
            if (station.isScrollingPS() || station.getName().length() < 1) {
                if (!bl2 && RadioDataSessionManager.getInstance().countryList.isDatabaseNameActivatedForStationList() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                    object = RadioDataApi.getFmStationNameFromHmiDataBuffer(new AmFmStation(station));
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmActiveListView - dsiAMFMTunerUpdateSelectedStation() - ").append("stationNameDb: ").append((String)object).log();
                    }
                    if (null != object && ((String)object).length() > 0) {
                        station.name = object;
                        station.scrollingPS = false;
                        bl2 = true;
                    }
                }
                if (!bl2 && ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != (object = RadioData.getAmfmDatabase().getStationNameFreqList())) {
                    String string = ((StationNameFreqList)object).getStationName((int)station.frequency);
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("StateAmFmActiveListView - dsiAMFMTunerUpdateSelectedStation() - ").append("Name from NAV database: ").append(string).log();
                    }
                    if (string.length() > 0) {
                        station.name = string;
                    }
                }
            }
            SelectedStationHighlighting.setTunedStationByApplication(station);
            object = new AmFmStation(station);
            ((AmFmStation)object).setRdsPiIgnoreProperties();
            this.mTarget.notifyStationChangeForRadioText((AmFmStation)object);
            boolean bl3 = false;
            boolean bl4 = true;
            if (this.timerUpdateSelectedStationDelayOn) {
                bl3 = true;
                bl4 = false;
            }
            boolean bl5 = bl = station.getServiceId() > 1 ? AmFmFactory.getInstanceEUStationListViewWalker().updateSubStation((AmFmStation)object) : AmFmFactory.getInstanceEUStationListViewWalker().updateStation((AmFmStation)object, bl4, bl3);
            if (bl) {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("dsiAMFMTunerUpdateSelectedStation() - Station is not updated.").log();
                }
                this.bufferedStation = new Station(station.name, station.frequency, station.pi, station.receptionQuality, station.ptyCode, station.waveband, station.rds, station.tp, station.ta, station.tmc, station.scrollingPS, station.radioText, station.realPS, station.hd, station.shortNameHD, station.longNameHD, station.fullDigital, station.serviceId, station.subscription, station.eon, station.coChannel, station.stationArt);
            } else {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("dsiAMFMTunerUpdateSelectedStation() - Station is updated.").log();
                }
                this.bufferedStation = null;
            }
            if (!station.rds) {
                this.mRadiotext.notifyLostRDS();
            }
            AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency((int)station.frequency);
            this.mTarget.updateSelectedStation(new AmFmStation(station));
            AmFmFactory.getAslAmfmModelController().updateLogoToHmi();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    public HsmState dsiAMFMTunerUpdateSelectedStationHD(Station station, int n, int n2) {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append("StateAmFmActiveListView - dsiAMFMTunerUpdateSelectedStationHD -> ").append(station.toString()).append(" HDStructure Bit mask = ").append(n).log();
            }
            if (!HsmTarget.isUpdateSelectedStationValid(n2, station)) {
                return null;
            }
            if (!station.isHd()) {
                station.serviceId = 0;
            }
            if (AMFMUtil.isStationValidInBand(station)) {
                boolean bl;
                AmFmStation amFmStation;
                if (AmFmFactory.getAslAmfmPropertyManager().isStationTuneStarted()) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Checks if NAR station changed after reply for tune command ").log();
                    }
                    if (!(null == (amFmStation = RadioData.getAmfmDatabase().getCurrentStation()) || HsmTarget.stationTunedBySpeech || RadioData.getAmfmDatabase().checkIfStationChanged(station, HsmTarget.selectedStationInfo) && station.getFrequency() == (long)amFmStation.getFrequency() && station.getServiceId() == amFmStation.getServiceId())) {
                        if (this.logger.isTraceEnabled(128)) {
                            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("Station received is not the same as tuned station ").log();
                        }
                        return null;
                    }
                    AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
                }
                SelectedStationHighlighting.setTunedStationByApplication(station);
                amFmStation = RadioData.getAmfmDatabase().handleStationInfoChange(station, HsmTarget.selectedStationInfo);
                if (null == amFmStation) {
                    return null;
                }
                HsmTarget.selectedStationInfo = station;
                amFmStation.setSubChannelBitMask(n);
                this.mTarget.notifyStationChangeForRadioText(amFmStation);
                boolean bl2 = bl = station.getServiceId() > 1 ? AmFmFactory.getInstanceEUStationListViewWalker().updateSubStation(amFmStation) : AmFmFactory.getInstanceEUStationListViewWalker().updateStation(amFmStation, false, false);
                if (bl) {
                    this.bufferedStation = new Station(station.name, station.frequency, station.pi, station.receptionQuality, station.ptyCode, station.waveband, station.rds, station.tp, station.ta, station.tmc, station.scrollingPS, station.radioText, station.realPS, station.hd, station.shortNameHD, station.longNameHD, station.fullDigital, station.serviceId, station.subscription, station.eon, station.coChannel, station.stationArt);
                    if (!this.timerUpdateSelectedStationDelayOn) {
                        AmFmFactory.getInstanceEUStationListViewWalker().updateStationWithListIndexChange(this.bufferedStation);
                        this.bufferedStation = null;
                    }
                } else {
                    this.bufferedStation = null;
                }
                if (!station.rds) {
                    this.mRadiotext.notifyLostRDS();
                }
                AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency((int)station.frequency);
                this.mTarget.updateSelectedStationHD(amFmStation);
                AmFmFactory.getAslAmfmModelController().updateLogoToHmi();
                AmFmPresetApi.updateGuiList(RadioCurrentWaveband.get());
                if (HsmTarget.stationTunedBySpeech) {
                    AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
                    amFmStationList.updateStationListToHMI();
                    RadioServiceManager.getServiceManager().getAdapterAslSpeech().sendAmFmTuningResponse(new AmFmStation(station), 1);
                    HsmTarget.stationTunedBySpeech = false;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    private void activateStation(int n) {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - activateStation( ").append(n).append(" )").log();
            }
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                if (AmFmFactory.getInstanceEUStationListViewWalker().getCurrentIndex() != n) {
                    this.tuneStationByIndex(n);
                }
                AmFmFactory.getAslAmfmModelController().updateFrequencyToStoreOnPreset(AmFmFactory.getInstanceEUStationListViewWalker().getCurrentStation());
            } else {
                this.tuneStationByIndex(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void tuneStationByIndex(int n) {
        AmFmStationInfoCollector[] amFmStationInfoCollectorArray;
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - tuneStationByIndex( ").append(n).append(" )").log();
        }
        if (null != (amFmStationInfoCollectorArray = AmFmFactory.getInstanceEUStationListViewWalker().getStationInfoCollectors()) && n >= 0 && n < amFmStationInfoCollectorArray.length && null != amFmStationInfoCollectorArray[n] && amFmStationInfoCollectorArray[n].getPtyGroupTitleId() == -1) {
            this.bufferedStation = null;
            this.startTimer();
            AmFmFactory.getInstanceEUStationListViewWalker().tuneStation(n);
        }
    }

    private void tuneNotAvailableStationInList(AmFmStation amFmStation) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("Tuning the not available station in the list").log();
        }
        this.bufferedStation = null;
        this.startTimer();
        AmFmFactory.getInstanceEUStationListViewWalker().updateStation(amFmStation, true, false);
        AmFmPresetApi.syncFmName(amFmStation);
        int n = amFmStation.getWaveband();
        int n2 = AMFMUtil.convertDSIBandConstantToHMIBandConstant(n);
        AmFmPresetApi.autoCompare(n2, amFmStation);
        AmFmDsiApi.selectStation(amFmStation);
    }

    private void startTimer() {
        if (this.timerUpdateSelectedStationDelayOn) {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - Restart timer EV_AMFM_TIMER_AUTOCOMPARE").log();
            }
            this.mTarget.restartTimer(1753678080);
        } else {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - Start timer EV_AMFM_TIMER_AUTOCOMPARE").log();
            }
            this.mTarget.startTimer(1753678080, (long)0, false);
            this.timerUpdateSelectedStationDelayOn = true;
        }
    }

    private boolean tuneStationTriggeredBySpeechControl(EventGeneric eventGeneric) {
        try {
            long l = eventGeneric.getLong(0);
            return this.tuneStationTriggeredBySpeechControl(l);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    public boolean tuneStationTriggeredBySpeechControl(long l) {
        try {
            int n = -1;
            boolean bl = false;
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - tuneStationTriggeredBySpeechControl() - stationId = ").append(l).log();
            }
            if (-1 != (n = RadioUtil.isIdADatabaseStationId(l) ? AmFmFactory.getInstanceEUStationListViewWalker().getStationByDatabaseId(l >> 1) : AmFmFactory.getInstanceEUStationListViewWalker().getStationIndexById(l))) {
                this.tuneStationByIndex(n);
                bl = true;
            } else if (!RadioUtil.isIdADatabaseStationId(l)) {
                this.tuneNotAvailableStationInList(RadioUtil.cumputeStationFromUniqueID(l));
                bl = true;
            }
            return bl;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    private void activateStationById(long l) {
        int n = AmFmFactory.getInstanceEUStationListViewWalker().getStationIndexById(l);
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("StateAmFmActiveListView - activateStationById - itemIndexInStationList : ").append(n).log();
        }
        if (RadioData.getAmfmDatabase().getAslStationListFM().isListSortingFmPtyGroups()) {
            AmFmStationInfoCollector[] amFmStationInfoCollectorArray = AmFmFactory.getInstanceEUStationListViewWalker().getStationInfoCollectors();
            if (RadioData.getAmfmDatabase().getAslStationListFM().isListItemNoFmPtyGroupTitle(amFmStationInfoCollectorArray, n)) {
                if (-1 != n) {
                    this.activateStation(n);
                } else {
                    this.tuneNotAvailableStationInList(RadioUtil.cumputeStationFromUniqueID(l));
                }
            }
        } else if (-1 != n) {
            this.activateStation(n);
        } else {
            this.tuneNotAvailableStationInList(RadioUtil.cumputeStationFromUniqueID(l));
        }
    }
}

