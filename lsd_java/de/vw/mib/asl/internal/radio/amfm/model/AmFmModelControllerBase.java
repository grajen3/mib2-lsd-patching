/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.model;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveEmergencySeek;
import de.vw.mib.asl.internal.radio.amfm.model.AmFmModelController;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmDefaultSettings;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.transformer.AMStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoAMCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoFMCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.Station;

public class AmFmModelControllerBase
implements AmFmModelController {
    private boolean isRadioTextBlocked = false;
    protected static Logger logger = ServiceManager.logger;

    @Override
    public void setPropertyBoolean(int n, boolean bl) {
        if (null != ServiceManager.aslPropertyManager) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
        }
    }

    @Override
    public void setPropertyInteger(int n, int n2) {
        if (null != ServiceManager.aslPropertyManager) {
            ServiceManager.aslPropertyManager.valueChangedInteger(n, n2);
        }
    }

    @Override
    public void setPropertyLong(int n, long l) {
        if (null != ServiceManager.aslPropertyManager) {
            ServiceManager.aslPropertyManager.valueChangedLong(n, l);
        }
    }

    @Override
    public void setPropertyString(int n, String string) {
        if (null != ServiceManager.aslPropertyManager) {
            ServiceManager.aslPropertyManager.valueChangedString(n, string);
        }
    }

    @Override
    public void setPropertyResourceLocator(int n, ResourceLocator resourceLocator) {
        if (null != resourceLocator && null != ServiceManager.aslPropertyManager) {
            ServiceManager.aslPropertyManager.valueChangedResourceLocator(n, resourceLocator);
        }
    }

    @Override
    public void updateAfSetupOptionState(boolean bl) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating AF setup option: ").append(bl).log();
        }
        this.setPropertyBoolean(1315, bl);
    }

    @Override
    public void updateFmPresetBankWithEmptyElement(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating index of FM bank with empty element: ").append(n).log();
        }
        this.setPropertyInteger(1365, n);
    }

    @Override
    public void updateFmActiveStationIndex(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("FM active station List index: ").append(n).log();
        }
        this.setPropertyInteger(1368, n);
    }

    @Override
    public void updateFmActiveSubStationIndex(int n) {
    }

    @Override
    public void updateFmRadioTextPlus(String string, String string2) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("updating RT+, artist: '").append(string).append("'  title: '").append(string2).append("'").log();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateRadioPlusTextNar(string, string2);
        }
        this.setPropertyString(1371, string);
        this.setPropertyString(1372, string2);
    }

    @Override
    public void updateRadioTextPlusSetupOptionAvailable(boolean bl) {
        this.setPropertyBoolean(2863, bl);
    }

    @Override
    public void updateRadioTextPlusFM(String string, String string2, String string3) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("updating RT+, artist: '").append(string).append("'  title: '").append(string2).append("'  album: '").append(string3).append("'").log();
        }
        this.setPropertyString(3404, string);
        this.setPropertyString(3403, string2);
        this.setPropertyString(3405, string3);
    }

    @Override
    public void updateHDStationInfo(String string, String string2, String string3) {
    }

    @Override
    public void updateRadioTextSetupState(boolean bl) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating Radio Text setup option: ").append(bl).log();
        }
        this.setPropertyBoolean(1409, bl);
        int n = 0;
        if (!bl) {
            n = 2;
        }
        GuiApiTunerCommon.setFmRadioTextLoadingState(n);
    }

    @Override
    public void updateRadioTextPlusSetupState(boolean bl) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating Radio Text Plus setup option: ").append(bl).log();
        }
        this.setPropertyBoolean(2323, bl);
    }

    @Override
    public void updateIndexOfFirstOccupiedPresetFm(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating index of first occupied FM preset: ").append(n).log();
        }
        this.setPropertyInteger(1401, n);
    }

    @Override
    public void updateRdsSetupOptionAvailable(boolean bl) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating RDS setup option available: ").append(bl).log();
        }
        this.setPropertyBoolean(1444, bl);
    }

    @Override
    public void updateRdsRegionalizationOptionState(int n) {
        if (null != logger && logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating RDS Reg option state: ").append(n).log();
        }
        if (RadioCodingAdapter.isHongKongVariant()) {
            n = 1;
        }
        this.setPropertyInteger(1411, n);
    }

    @Override
    public void updatePsFixed(boolean bl) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating PS fixed: ").append(bl).log();
        }
        this.setPropertyBoolean(1439, bl);
    }

    @Override
    public void updatePsNameAvailable(boolean bl) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating PS name available: ").append(bl).log();
        }
        this.setPropertyBoolean(1440, bl);
    }

    @Override
    public void updateFmRadioText(String string) {
        this.setPropertyString(1370, string);
    }

    @Override
    public void updateFmRadiotextAndState(String string, int n) {
        if (null == string) {
            logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("null == radioText").log();
            return;
        }
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("updating RT, text: '").append(string).append("'  loading State: ").append(n).log();
        }
        if (this.isRadioTextBlocked()) {
            if (logger.isTraceEnabled(128)) {
                logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("updating RT, isRadioTextBlocked() = true").log();
            }
            return;
        }
        String string2 = "KEINE MELDUNG (NIX GUT)";
        if (n == 2) {
            string2 = "KEIN RADIOTEXT VERF\u00dcGBAR";
        } else if (n == 0) {
            string2 = "RADIO TEXT LOADING:";
        } else if (n == 1) {
            string2 = "RADIO TEXT VERF\u00dcGBAR";
        }
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("message to HMI: '").append(string2).append("'  text: '").append(string).append("'").log();
        }
        GuiApiTunerCommon.setFmRadioTextLoadingState(n);
        this.updateFmRadioText(string);
        if (RadioCurrentWaveband.isFm() && RadioCodingAdapter.isRadioTileFeatureActivated()) {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateRadioTextNar(string);
            } else {
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateRadioText(string);
            }
        }
    }

    @Override
    public void updateAmActiveStationIndex(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating AM list index: ").append(n).log();
        }
        this.setPropertyInteger(1318, n);
    }

    @Override
    public void updateListState(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating current AM list state: ").append(n).log();
        }
        this.setPropertyInteger(1317, n);
    }

    @Override
    public void updateAmRadioTextArtist(String string, String string2) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("updating AM RT: artist: '").append(string).append("'  title: '").append(string2).append("'").log();
        }
        this.setPropertyString(1320, string);
        this.setPropertyString(1321, string2);
    }

    @Override
    public void updatePresetBankWithEmptyElement(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating AM preset first bank with empty slot: ").append(n).log();
        }
        this.setPropertyInteger(1363, n);
    }

    @Override
    public void updateAmIndexOfFirstOccupiedPreset(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating AM preset bank with first occupied slot: ").append(n).log();
        }
        this.setPropertyInteger(1399, n);
    }

    @Override
    public void updateIndexOfActivatedAmPreset(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating AM active preset: ").append(n).log();
        }
        if (-1 == n) {
            n = 255;
        }
        this.setPropertyInteger(1396, n);
    }

    @Override
    public void updateAmIndexOfPresetBank(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating index of visible AM bank: ").append(n).log();
        }
        this.setPropertyInteger(1402, n);
    }

    @Override
    public void updateFmIndexOfPresetBank(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating index of visible FM bank: ").append(n).log();
        }
        this.setPropertyInteger(1404, n);
    }

    @Override
    public void updateAtLeastOnePresetHasLogo(int n, boolean bl) {
        if (n == 0) {
            if (logger.isTraceEnabled(128)) {
                logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating AM preset logo available if atleast one assigned: ").append(bl).log();
            }
            this.setPropertyBoolean(3894, bl);
        } else if (n == 1) {
            if (logger.isTraceEnabled(128)) {
                logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating FM preset logo available if atleast one assigned: ").append(bl).log();
            }
            this.setPropertyBoolean(3895, bl);
        }
    }

    @Override
    public void updateAmStationList(AMStationInfoCollector[] aMStationInfoCollectorArray, int n, long l) {
        if (aMStationInfoCollectorArray == null) {
            aMStationInfoCollectorArray = new AMStationInfoCollector[]{};
        }
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating AM station list: active index").append(n).append("  list size: ").append(aMStationInfoCollectorArray.length).log();
        }
        ListManager.getGenericASLList(1452).setActiveIndex(n);
        this.updateNewStationListIDAndPresetIndexForBAP(l, AmFmPresetApi.getCurrentIndex());
        GuiApiTunerCommon.updateBapReceptionList(AMFMUtil.convertCollectorToAmFmStationArray(aMStationInfoCollectorArray));
        this.updateAmActiveStationIndex(n);
        ListManager.getGenericASLList(1452).updateList(aMStationInfoCollectorArray);
        RadioHASUpdater.updateAmStationList(aMStationInfoCollectorArray);
    }

    @Override
    public void updateFmStationList(FMStationInfoCollector[] fMStationInfoCollectorArray, int n, int n2, long l) {
        try {
            if (fMStationInfoCollectorArray == null) {
                fMStationInfoCollectorArray = new FMStationInfoCollector[]{};
            }
            if (logger.isTraceEnabled(128)) {
                logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("FM active list index: ").append(n).append("  updating FM list size: ").append(fMStationInfoCollectorArray.length).log();
            }
            this.updateFmActiveStationIndex(n);
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLListManager().getGenericASLList(1462).setActiveIndex(n);
            AmFmFactory.getInstanceEUStationListViewWalker().updateFmList(AMFMUtil.searchForRegionals2ndNibble(fMStationInfoCollectorArray));
            this.updateNewStationListIDAndPresetIndexForBAP(l, AmFmPresetApi.getCurrentIndex());
            GuiApiTunerCommon.updateBapReceptionList(AMFMUtil.convertCollectorToAmFmStationArray(fMStationInfoCollectorArray));
            RadioHASUpdater.updateFmStationList(fMStationInfoCollectorArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void updateFmSubStationList(FMStationInfoCollector[] fMStationInfoCollectorArray, int n, long l) {
    }

    @Override
    public void updateCurrentStationInfoFrequencyOnly(int n) {
        if (AmFmFactory.getAslAmfmPropertyManager().getManualModeActive() && AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency() != n) {
            return;
        }
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating frequency (DDS tuning): ").append(n).log();
        }
        if (RadioCurrentWaveband.isFm()) {
            Object[] objectArray = new RadioCurrentStationInfoFMCollector[]{new RadioCurrentStationInfoFMCollector()};
            objectArray[0].radio_current_station_info_fm__name = "";
            objectArray[0].radio_current_station_info_fm__frequency = n;
            objectArray[0].radio_current_station_info_fm__tmc_available = false;
            objectArray[0].radio_current_station_info_fm__ta_tp_available = false;
            ListManager.getGenericASLList(1456).updateList(objectArray);
        } else {
            Object[] objectArray = new RadioCurrentStationInfoAMCollector[]{new RadioCurrentStationInfoAMCollector()};
            objectArray[0].radio_current_station_info_am__name = "";
            objectArray[0].radio_current_station_info_am__frequency = n;
            ListManager.getGenericASLList(1454).updateList(objectArray);
        }
    }

    @Override
    public void updateCurrentStationInfoHmiAndBap(AmFmStation amFmStation, int n) {
        if (amFmStation != null) {
            this.updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(amFmStation), n);
            this.updateCurrentStationInfo(amFmStation);
        }
    }

    @Override
    public void updateStationNameInMainView(AmFmStation amFmStation) {
        if (amFmStation != null) {
            if (AmFmFactory.getAslAmfmPropertyManager().getManualModeActive() && AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency() != amFmStation.getFrequency()) {
                return;
            }
            if (RadioData.getAmfmDatabase().getFixedStationList().getFreezedPS() != null) {
                return;
            }
            Station station = amFmStation.getAsDSIStation();
            if (station == null) {
                return;
            }
            switch (amFmStation.getWaveband()) {
                case 1: {
                    Object[] objectArray = ListManager.getGenericASLList(1456).getDSIObjects();
                    if (null == objectArray || objectArray.length < 1) {
                        return;
                    }
                    Object[] objectArray2 = (RadioCurrentStationInfoFMCollector[])objectArray;
                    if (null == objectArray2 || objectArray2.length <= 0 || null == objectArray2[0] || null == station.getName()) break;
                    objectArray2[0].radio_current_station_info_fm__name = station.getName();
                    ListManager.getGenericASLList(1456).updateList(objectArray2);
                    RadioHASUpdater.updateCurrentFMStation((RadioCurrentStationInfoFMCollector)objectArray2[0], amFmStation);
                    break;
                }
                case 2: 
                case 3: 
                case 4: {
                    Object[] objectArray = ListManager.getGenericASLList(1454).getDSIObjects();
                    if (null == objectArray || objectArray.length < 1) {
                        return;
                    }
                    Object[] objectArray3 = (RadioCurrentStationInfoAMCollector[])objectArray;
                    if (null == objectArray3 || objectArray3.length <= 0 || null == objectArray3[0] || null == station.getName()) break;
                    objectArray3[0].radio_current_station_info_am__name = station.getName();
                    ListManager.getGenericASLList(1454).updateList(objectArray3);
                    RadioHASUpdater.updateCurrentAMStation((RadioCurrentStationInfoAMCollector)objectArray3[0]);
                    break;
                }
            }
        }
    }

    @Override
    public void updateCurrentStationInfo(AmFmStation amFmStation) {
        if (amFmStation != null) {
            if (!StateAmFmActiveEmergencySeek.isEmergencySeekActive() && AmFmFactory.getAslAmfmPropertyManager().getManualModeActive() && AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency() != amFmStation.getFrequency()) {
                return;
            }
            if (RadioData.getAmfmDatabase().getFixedStationList().getFreezedPS() != null) {
                return;
            }
            if (RadioData.getAmfmDatabase().getFixedStationList().getName(amFmStation.getPi(), amFmStation.getFrequency()) != null) {
                this.updatePsFixed(true);
            } else {
                this.updatePsFixed(false);
            }
            long l = amFmStation.getFrequency();
            switch (amFmStation.getWaveband()) {
                case 1: {
                    if (l <= 0L) {
                        l = AmFmDefaultSettings.getFmDefaultFrequency();
                    }
                    Object[] objectArray = new RadioCurrentStationInfoFMCollector[]{new RadioCurrentStationInfoFMCollector()};
                    objectArray[0].radio_current_station_info_fm__name = this.getFmStationName(amFmStation);
                    objectArray[0].radio_current_station_info_fm__short_station_name = amFmStation.getShortNameHD();
                    objectArray[0].radio_current_station_info_fm__hd_channel_number = -1;
                    objectArray[0].radio_current_station_info_fm__frequency = (int)l;
                    objectArray[0].radio_current_station_info_fm__tmc_available = amFmStation.isTmc();
                    objectArray[0].radio_current_station_info_fm__ta_tp_available = amFmStation.isTa() || amFmStation.isTp();
                    objectArray[0].radio_current_station_info_fm__hd_available = amFmStation.isHD();
                    objectArray[0].radio_current_station_info_fm__manual_assigned_logo = AmFmPresetApi.getCurrentImage();
                    ListManager.getGenericASLList(1456).updateList(objectArray);
                    if (logger.isTraceEnabled(128)) {
                        logger.trace(128).append("updating current FM station to HMI: Frequency: ").append(((RadioCurrentStationInfoFMCollector)objectArray[0]).radio_current_station_info_fm__frequency).append("  Name : ").append(((RadioCurrentStationInfoFMCollector)objectArray[0]).radio_current_station_info_fm__name).append("  ShortName : ").append(((RadioCurrentStationInfoFMCollector)objectArray[0]).radio_current_station_info_fm__short_station_name).append("  Channel Number : ").append(((RadioCurrentStationInfoFMCollector)objectArray[0]).radio_current_station_info_fm__hd_channel_number).append("  HD : ").append(((RadioCurrentStationInfoFMCollector)objectArray[0]).radio_current_station_info_fm__hd_available).log();
                    }
                    RadioHASUpdater.updateCurrentFMStation((RadioCurrentStationInfoFMCollector)objectArray[0], amFmStation);
                    break;
                }
                case 2: 
                case 3: 
                case 4: {
                    if (l <= 0L) {
                        l = AmFmDefaultSettings.getAmDefaultFrequency();
                    }
                    Object[] objectArray = new RadioCurrentStationInfoAMCollector[]{new RadioCurrentStationInfoAMCollector()};
                    objectArray[0].radio_current_station_info_am__name = this.getAmStationName(amFmStation);
                    objectArray[0].radio_current_station_info_am__short_name = amFmStation.getShortNameHD();
                    objectArray[0].radio_current_station_info_am__frequency = (int)l;
                    objectArray[0].radio_current_station_info_am__hd_channel_number = -1;
                    objectArray[0].radio_current_station_info_am__hd_available = amFmStation.isHD();
                    objectArray[0].radio_current_station_info_am__manual_assigned_logo = AmFmPresetApi.getCurrentImage();
                    ListManager.getGenericASLList(1454).updateList(objectArray);
                    if (logger.isTraceEnabled(128)) {
                        logger.trace(128).append("updating current AM station to HMI: Frequency: ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__frequency).append("  Name : ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__name).append("  ShortName : ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__short_name).append("  Channel Number : ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__hd_channel_number).append("  HD : ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__hd_available).log();
                    }
                    RadioHASUpdater.updateCurrentAMStation((RadioCurrentStationInfoAMCollector)objectArray[0]);
                    break;
                }
            }
        }
    }

    @Override
    public String getAmStationName(AmFmStation amFmStation) {
        return "";
    }

    @Override
    public String getFmStationName(AmFmStation amFmStation) {
        try {
            Object object;
            if (null == amFmStation) {
                return "";
            }
            String string = RadioData.getAmfmDatabase().getFixedStationList().getName(amFmStation.getPi(), amFmStation.getFrequency());
            if (AmfmRDSOption.get() && string != null && string.length() > 1) {
                return string;
            }
            Object object2 = null;
            if (SelectedStationHighlighting.getStationSelectionIsActive()) {
                object2 = AmFmPresetApi.getCurrentPresetName();
            }
            if ((null == object2 || ((String)object2).length() < 1) && RadioDataSessionManager.getInstance().countryList.isDatabaseNameActivatedForMainView() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive() && amFmStation.getName().length() < 1 && !amFmStation.isScrollingPS()) {
                object = RadioDataApi.getFmStationNameFromHmiDataBuffer(amFmStation);
                if (logger.isTraceEnabled(128)) {
                    logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmModelControllerBase - getFmStationName() - ").append("stationNameDb: ").append((String)object).log();
                }
                if (null != object && ((String)object).length() > 0) {
                    object2 = object;
                }
            }
            if ((null == object2 || ((String)object2).length() < 1) && amFmStation.getName().length() < 1 && ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != (object = RadioData.getAmfmDatabase().getStationNameFreqList())) {
                object2 = ((StationNameFreqList)object).getStationName(amFmStation.getFrequency());
                if (logger.isTraceEnabled(128)) {
                    logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmModelControllerBase - getFmStationName() - ").append("Name from NAV database: ").append((String)object2).log();
                }
            }
            if ((null == object2 || ((String)object2).length() < 1) && amFmStation.getStationName() != null) {
                object2 = amFmStation.getStationName().trim();
            }
            if (object2 == null) {
                object2 = "";
            }
            if (((String)object2).length() <= 0 && amFmStation.isScrollingPS() && AmfmRDSOption.get() && amFmStation.isRds()) {
                object2 = " ";
            }
            if (amFmStation.isCoChannel()) {
                object2 = "";
            }
            if (object2 == null) {
                object2 = "";
            }
            if (RadioCodingAdapter.isRdsButtonVisible() && !RadioData.getAmfmDatabase().getSettingsPersistable().getUserSelectedRdsValue()) {
                object2 = "";
            }
            if (((String)object2).length() > 0) {
                this.setPropertyBoolean(1440, true);
            } else {
                this.setPropertyBoolean(1440, false);
            }
            return object2;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "";
        }
    }

    @Override
    public void updateRdsSetupOptionState(boolean bl) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmModelControllerBase - updateRdsSetupOptionState( ").append(bl).append(" )").log();
        }
        this.setPropertyBoolean(1410, bl);
    }

    @Override
    public void updateIndexOfActivatedFmPreset(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("updating active FM preset: ").append(n).log();
        }
        if (-1 == n) {
            n = 255;
        }
        this.setPropertyInteger(1398, n);
    }

    @Override
    public void updateNewStationListIDAndPresetIndexForBAP(long l, int n) {
        try {
            RadioServiceManager.getServiceManager().getGuiBapApi().updateBapCurrentStationIndices(n, l);
        }
        catch (Exception exception) {
            logger.error(128, "Exception in updateNewStationListIDAndPresetIndexForBAP() ", exception);
        }
    }

    @Override
    public void updateAmFrequencyMinValue(int n) {
        this.setPropertyInteger(1382, n);
    }

    @Override
    public void updateAmFrequencyMaxValue(int n) {
        this.setPropertyInteger(1381, n);
    }

    @Override
    public void updateAmFrequencyStepValue(int n) {
        this.setPropertyInteger(1384, n);
    }

    @Override
    public void updateFmFrequencyMinValue(int n) {
        this.setPropertyInteger(1389, n);
    }

    @Override
    public void updateFmFrequencyMaxValue(int n) {
        this.setPropertyInteger(1388, n);
    }

    @Override
    public void updateFmFrequencyStepValue(int n) {
        this.setPropertyInteger(1391, n);
    }

    @Override
    public void updateTAEmergencyState(boolean bl) {
        this.setPropertyBoolean(1447, bl);
    }

    @Override
    public void updateAMFrequencyScale(int n) {
        this.setPropertyInteger(1316, n);
        RadioHASUpdater.updateAMBandRange(n);
    }

    @Override
    public void updateFmFrequencyScale(int n) {
        this.setPropertyInteger(1366, n);
        RadioHASUpdater.updateFMBandRange(n);
    }

    @Override
    public void updatePICoding(boolean bl) {
        this.setPropertyBoolean(1426, bl);
    }

    @Override
    public void updateFMStationShortNameToStoreOnPreset(String string) {
        this.setPropertyString(1350, string);
    }

    @Override
    public void updateFMStationSubChannelNrToStoreOnPreset(int n) {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            this.setPropertyInteger(3400, n);
        } else {
            this.setPropertyInteger(3400, -1);
        }
    }

    @Override
    public void updateFMFrequencyToStoreOnPreset(int n) {
        this.setPropertyInteger(1334, n);
    }

    @Override
    public void updateAMStationShortNameToStoreOnPreset(String string) {
        this.setPropertyString(1351, string);
    }

    @Override
    public void updateAMFrequencyToStoreOnPreset(int n) {
        this.setPropertyInteger(1333, n);
    }

    @Override
    public void updateFrequencyToStoreOnPreset(AmFmStation amFmStation) {
        if (null != amFmStation) {
            if (RadioCurrentWaveband.isAm()) {
                this.updateAMFrequencyToStoreOnPreset(amFmStation.getFrequency());
            } else if (RadioCurrentWaveband.isFm()) {
                this.updateFMFrequencyToStoreOnPreset(amFmStation.getFrequency());
            }
            this.updateStationShortNameToStoreOnPreset(amFmStation.getName().trim());
        }
    }

    @Override
    public void updateStationShortNameToStoreOnPreset(String string) {
        if (RadioCurrentWaveband.isAm()) {
            this.updateAMStationShortNameToStoreOnPreset(string);
        } else if (RadioCurrentWaveband.isFm()) {
            this.updateFMStationShortNameToStoreOnPreset(string);
        }
    }

    @Override
    public void updateFmViewState(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating current FM view state: ").append(n).log();
        }
        this.setPropertyInteger(1361, n);
    }

    @Override
    public void updateAmViewState(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating AM view state: ").append(n).log();
        }
        this.setPropertyInteger(1360, n);
    }

    @Override
    public void updateLogoToHmi() {
    }

    @Override
    public void updateTrafficInformationFrequency(int n) {
        this.setPropertyInteger(2397, n);
    }

    @Override
    public void updateAMHDRadioEnabled(boolean bl) {
    }

    @Override
    public void updateTransferredSongTags(int n) {
    }

    public void updateIsCurrentStationTagged(boolean bl) {
    }

    @Override
    public void updateTransferringSongTagsActive(boolean bl) {
    }

    @Override
    public void updateFMPresetLogosAutoSelectList(String[] stringArray) {
        ListManager.getGenericASLList(4058).updateList(stringArray);
    }

    @Override
    public void openSelectPresetLogoPopup() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(500);
    }

    @Override
    public void presetStoredSuccessfully() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(520);
    }

    @Override
    public void enableTaggingButton(boolean bl) {
        this.setPropertyBoolean(3537, bl);
    }

    @Override
    public void updateFmStationListSortOrder(int n) {
        this.setPropertyInteger(3571, n);
    }

    @Override
    public void updateLogoAutoStoreActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3499, bl);
    }

    @Override
    public void updateAmStationListItem(AMStationInfoCollector aMStationInfoCollector, int n) {
    }

    @Override
    public void updateFmStationListItem(FMStationInfoCollector fMStationInfoCollector, int n, int n2) {
    }

    @Override
    public void updateFmSubStationListItem(FMStationInfoCollector fMStationInfoCollector, int n) {
    }

    @Override
    public void updateHomeCountryNameInSetup(String string) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("updateHomeCountryName: ").append(string).log();
        }
        if (null == string) {
            this.setPropertyString(734405632, "");
        } else {
            this.setPropertyString(734405632, string);
        }
    }

    @Override
    public void updateEnhancedRadioTextSetupOptionState(boolean bl) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updateEnhancedRadioTextSetupOptionState: ").append(bl).log();
        }
        this.setPropertyBoolean(4100, bl);
    }

    @Override
    public void updateAutoStoreStationLogosFeatureAvailable(boolean bl) {
        logger.info(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("updateAutoStoreStationLogosFeatureAvailable: ").append(bl).log();
        this.setPropertyBoolean(667296768, bl);
        this.setPropertyBoolean(684073984, bl);
    }

    @Override
    public void updateHomeCountrySetupOptionVisible(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("updateHomeCountrySetupOptionVisible: ").append(bl).log();
        }
        this.setPropertyBoolean(751182848, bl);
    }

    @Override
    public boolean isRadioTextBlocked() {
        return this.isRadioTextBlocked;
    }

    @Override
    public void setRadioTextBlocked(boolean bl) {
        this.isRadioTextBlocked = bl;
    }

    @Override
    public void updateFMHDRadioEnabled(boolean bl) {
    }

    @Override
    public void updateAmHdRadioState(int n) {
    }

    @Override
    public void updateFmHdRadioState(int n) {
    }

    @Override
    public void updateHDFilterinAM(boolean bl) {
    }

    @Override
    public void updateHDFilterinFM(boolean bl) {
    }

    @Override
    public void isHDFilteredStationListEmpty(boolean bl) {
    }

    @Override
    public void updateFmSetupHomeCountryListBackButtonVisible(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("isFmSetupHomeCountryListBackButtonVisible: ").append(bl).log();
        }
        this.setPropertyBoolean(969286656, bl);
    }

    @Override
    public void updateTaggingButtonVisibility(boolean bl) {
    }

    @Override
    public void updateHdRadioState(int n) {
    }

    @Override
    public void updateIsHongKongVariant(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            logger.trace(128).append("AmFmModelControllerBase - updateIsHongKongVariant( ").append(bl).append(" )").log();
        }
        this.setPropertyBoolean(1069949952, bl);
    }

    @Override
    public void updateIsSetupTrafficProgramButtonAvailable(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            logger.trace(128).append("AmFmModelControllerBase - updateIsSetupTrafficProgramButtonAvailable( ").append(bl).append(" )").log();
        }
        this.setPropertyBoolean(1086727168, bl);
    }

    @Override
    public void updateIsSetupAdvancedRdsRegButtonAvailable(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            logger.trace(128).append("AmFmModelControllerBase - updateIsSetupAdvancedRdsRegButtonAvailable( ").append(bl).append(" )").log();
        }
        this.setPropertyBoolean(1103504384, bl);
    }

    @Override
    public ResourceLocator getLogoForStationView() {
        return null;
    }

    @Override
    public void updateLogoInStationView(ResourceLocator resourceLocator) {
    }

    @Override
    public ResourceLocator getAmFmStationArt(AmFmStation amFmStation) {
        return null;
    }
}

