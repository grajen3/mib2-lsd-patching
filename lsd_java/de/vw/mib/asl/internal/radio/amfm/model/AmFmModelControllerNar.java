/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.model;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActive;
import de.vw.mib.asl.internal.radio.amfm.model.AmFmModelControllerBase;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.asl.internal.radio.transformer.AMStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoAMCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoFMCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.HdStationInfo;

public class AmFmModelControllerNar
extends AmFmModelControllerBase {
    @Override
    public void updateFmStationList(FMStationInfoCollector[] fMStationInfoCollectorArray, int n, int n2, long l) {
        Object[] objectArray = fMStationInfoCollectorArray == null ? new FMStationInfoCollector[]{} : fMStationInfoCollectorArray;
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("NAR FM active index: ").append(n).log();
        }
        this.updateFmActiveStationIndex(n2);
        ListManager.getGenericASLList(3093).setActiveIndex(n);
        this.updateNewStationListIDAndPresetIndexForBAP(l, AmFmPresetApi.getCurrentIndex());
        AmFmFactory.getAslAmfmModelController().isHDFilteredStationListEmpty(objectArray.length == 0);
        ListManager.getGenericASLList(3093).updateList(objectArray);
    }

    @Override
    public void updateFmSubStationList(FMStationInfoCollector[] fMStationInfoCollectorArray, int n, long l) {
        Object[] objectArray = fMStationInfoCollectorArray == null ? new FMStationInfoCollector[]{} : fMStationInfoCollectorArray;
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("NAR FM  active sub index: ").append(n).log();
        }
        ListManager.getGenericASLList(3094).setActiveIndex(n);
        this.updateFmActiveSubStationIndex(n);
        ListManager.getGenericASLList(3094).updateList(objectArray);
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
    }

    @Override
    public void updateAmStationListItem(AMStationInfoCollector aMStationInfoCollector, int n) {
        if (aMStationInfoCollector == null) {
            aMStationInfoCollector = new AMStationInfoCollector(new AmFmStation());
        }
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating AM station list item: active index").append(n).log();
        }
        ListManager.getGenericASLList(1452).setActiveIndex(n);
        this.updateAmActiveStationIndex(n);
        ListManager.getGenericASLList(1452).updateListItem(n, aMStationInfoCollector);
    }

    @Override
    public void updateFmStationListItem(FMStationInfoCollector fMStationInfoCollector, int n, int n2) {
        FMStationInfoCollector fMStationInfoCollector2 = fMStationInfoCollector == null ? new FMStationInfoCollector(new AmFmStation()) : fMStationInfoCollector;
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("NAR FM active index: ").append(n).log();
        }
        ListManager.getGenericASLList(3093).setActiveIndex(n);
        this.updateFmActiveStationIndex(n2);
        ListManager.getGenericASLList(3093).updateListItem(n, fMStationInfoCollector2);
    }

    @Override
    public void updateFmSubStationListItem(FMStationInfoCollector fMStationInfoCollector, int n) {
        FMStationInfoCollector fMStationInfoCollector2 = fMStationInfoCollector == null ? new FMStationInfoCollector(new AmFmStation()) : fMStationInfoCollector;
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("NAR FM sub station index: ").append(n).log();
        }
        ListManager.getGenericASLList(3094).setActiveIndex(n);
        this.updateFmActiveSubStationIndex(n);
        ListManager.getGenericASLList(3094).updateListItem(n, fMStationInfoCollector2);
    }

    @Override
    public void updateFmActiveSubStationIndex(int n) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("FM active sub station list index: ").append(n).log();
        }
        this.setPropertyInteger(1367, n);
    }

    @Override
    public void updateHDStationInfo(String string, String string2, String string3) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("updating HD Station Info, artist: '").append(string).append("'  title: '").append(string2).append("'  album: '").append(string3).append("'").log();
        }
        this.setPropertyString(3404, string);
        this.setPropertyString(3403, string2);
        this.setPropertyString(3405, string3);
        if (RadioCodingAdapter.isRadioTileFeatureActivated()) {
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateHDStationRadioText(string, string2);
        }
    }

    @Override
    public void updateHdRadioState(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("HD Radio State Integer : ").append(n).log();
        }
        this.setPropertyInteger(1394, n);
    }

    @Override
    public void updateAmHdRadioState(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("AM HD Radio State Integer : ").append(n).log();
        }
        this.setPropertyInteger(516301824, n);
    }

    @Override
    public void updateFmHdRadioState(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("FM HD Radio State Integer : ").append(n).log();
        }
        this.setPropertyInteger(533079040, n);
    }

    @Override
    public void updateAMHDRadioEnabled(boolean bl) {
        this.setPropertyBoolean(348529664, bl);
    }

    @Override
    public void updateFMHDRadioEnabled(boolean bl) {
        this.setPropertyBoolean(365306880, bl);
    }

    public int getFmDefaultFrequency() {
        return (int)RadioConstants.FM_BANDRANGE_NAR.getLowerLimit();
    }

    public int getAmDefaultFrequency() {
        return (int)RadioConstants.AM_BANDRANGE_NAR.getLowerLimit();
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
            String string = "";
            string = amFmStation.isHD() ? amFmStation.getLongNameHD() : amFmStation.getName();
            switch (amFmStation.getWaveband()) {
                case 1: {
                    Object[] objectArray = ListManager.getGenericASLList(1456).getDSIObjects();
                    if (null == objectArray || objectArray.length < 1) {
                        return;
                    }
                    Object[] objectArray2 = (RadioCurrentStationInfoFMCollector[])objectArray;
                    if (null == objectArray2 || objectArray2.length <= 0 || null == objectArray2[0]) break;
                    objectArray2[0].radio_current_station_info_fm__name = string;
                    objectArray2[0].radio_current_station_info_fm__short_station_name = amFmStation.getShortNameHD();
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
                    if (null == objectArray3 || objectArray3.length <= 0 || null == objectArray3[0]) break;
                    objectArray3[0].radio_current_station_info_am__name = string;
                    objectArray3[0].radio_current_station_info_am__short_name = amFmStation.getShortNameHD();
                    ListManager.getGenericASLList(1454).updateList(objectArray3);
                    RadioHASUpdater.updateCurrentAMStation((RadioCurrentStationInfoAMCollector)objectArray3[0]);
                    break;
                }
            }
        }
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
            objectArray[0].radio_current_station_info_fm__hd_available = false;
            objectArray[0].radio_current_station_info_fm__hd_channel_number = -1;
            objectArray[0].radio_current_station_info_fm__short_station_name = "";
            ListManager.getGenericASLList(1456).updateList(objectArray);
        } else {
            Object[] objectArray = new RadioCurrentStationInfoAMCollector[]{new RadioCurrentStationInfoAMCollector()};
            objectArray[0].radio_current_station_info_am__name = "";
            objectArray[0].radio_current_station_info_am__frequency = n;
            objectArray[0].radio_current_station_info_am__hd_available = false;
            objectArray[0].radio_current_station_info_am__hd_channel_number = -1;
            objectArray[0].radio_current_station_info_am__short_name = "";
            ListManager.getGenericASLList(1454).updateList(objectArray);
        }
    }

    @Override
    public void updateCurrentStationInfo(AmFmStation amFmStation) {
        if (amFmStation != null) {
            if (AmFmFactory.getAslAmfmPropertyManager().getManualModeActive() && AmFmFactory.getAslAmfmPropertyManager().getManualModeFrequency() != amFmStation.getFrequency()) {
                return;
            }
            boolean bl = false;
            int n = amFmStation.getFrequency();
            switch (amFmStation.getWaveband()) {
                case 1: {
                    Object[] objectArray;
                    String string = "";
                    if (SelectedStationHighlighting.getStationSelectionIsActive()) {
                        objectArray = AmFmPresetApi.getPresetByIndex(RadioCurrentWaveband.get(), AmFmPresetApi.getCurrentIndex());
                        if (null != objectArray) {
                            AmFmStation amFmStation2 = objectArray.getPresetStation();
                            string = ServiceManager.configManagerDiag.isFeatureFlagSet(2) && amFmStation2 != null && (amFmStation.getFrequency() != amFmStation2.getFrequency() || amFmStation.getServiceId() != amFmStation2.getServiceId()) ? "" : AmFmPresetApi.getCurrentPresetName();
                        }
                    } else {
                        string = amFmStation.isHD() ? amFmStation.getLongNameHD() : amFmStation.getName();
                    }
                    if (string != null && string.length() > 0) {
                        bl = true;
                    }
                    if (n <= 0) {
                        n = this.getFmDefaultFrequency();
                    }
                    objectArray = new RadioCurrentStationInfoFMCollector[]{new RadioCurrentStationInfoFMCollector()};
                    objectArray[0].radio_current_station_info_fm__name = string;
                    objectArray[0].radio_current_station_info_fm__hd_available = amFmStation.isHD();
                    if (amFmStation.isHD()) {
                        objectArray[0].radio_current_station_info_fm__short_station_name = amFmStation.getShortNameHD();
                        objectArray[0].radio_current_station_info_fm__hd_channel_number = RadioData.getAmfmDatabase().hasSubServiceList(amFmStation) || amFmStation.getSubChannelCount() > 0 || amFmStation.getServiceId() > 1 ? amFmStation.getSubChannel() : 0;
                    } else {
                        objectArray[0].radio_current_station_info_fm__short_station_name = "";
                        objectArray[0].radio_current_station_info_fm__hd_channel_number = -1;
                    }
                    objectArray[0].radio_current_station_info_fm__frequency = n;
                    objectArray[0].radio_current_station_info_fm__tmc_available = amFmStation.isTmc();
                    objectArray[0].radio_current_station_info_fm__ta_tp_available = amFmStation.isTa() || amFmStation.isTp();
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
                    if (n <= 0) {
                        n = this.getAmDefaultFrequency();
                    }
                    Object[] objectArray = new RadioCurrentStationInfoAMCollector[]{new RadioCurrentStationInfoAMCollector()};
                    objectArray[0].radio_current_station_info_am__name = amFmStation.isHD() ? amFmStation.getLongNameHD() : amFmStation.getName();
                    objectArray[0].radio_current_station_info_am__frequency = n;
                    objectArray[0].radio_current_station_info_am__hd_available = amFmStation.isHD();
                    objectArray[0].radio_current_station_info_am__hd_channel_number = amFmStation.isHD() ? 0 : -1;
                    objectArray[0].radio_current_station_info_am__short_name = amFmStation.getShortNameHD();
                    ListManager.getGenericASLList(1454).updateList(objectArray);
                    if (logger.isTraceEnabled(128)) {
                        logger.trace(128).append("updating current AM station to HMI: Frequency: ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__frequency).append("  Name : ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__name).append("  ShortName : ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__short_name).append("  Channel Number : ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__hd_channel_number).append("  HD : ").append(((RadioCurrentStationInfoAMCollector)objectArray[0]).radio_current_station_info_am__hd_available).log();
                    }
                    RadioHASUpdater.updateCurrentAMStation((RadioCurrentStationInfoAMCollector)objectArray[0]);
                    break;
                }
            }
            this.setPropertyBoolean(1440, bl);
        }
    }

    @Override
    public void updateFrequencyToStoreOnPreset(AmFmStation amFmStation) {
        if (null != amFmStation) {
            if (RadioCurrentWaveband.isAm()) {
                this.updateAMFrequencyToStoreOnPreset(amFmStation.getFrequency());
            } else if (RadioCurrentWaveband.isFm()) {
                this.updateFMFrequencyToStoreOnPreset(amFmStation.getFrequency());
                int n = amFmStation.getSubChannel();
                if (amFmStation.getServiceId() == 1 && !RadioData.getAmfmDatabase().hasSubServiceList(amFmStation)) {
                    n = 0;
                }
                this.updateFMStationSubChannelNrToStoreOnPreset(n);
            }
            this.updateStationShortNameToStoreOnPreset(amFmStation.isHD() ? amFmStation.getShortNameHD() : "");
        }
    }

    @Override
    public ResourceLocator getLogoForStationView() {
        try {
            ResourceLocator resourceLocator = null;
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
            if (null != amFmStation) {
                HdStationInfo hdStationInfo = RadioData.getAmfmDatabase().getCurrentHDStation();
                if (hdStationInfo != null && hdStationInfo.getFrequency() == amFmStation.getFrequency() && hdStationInfo.getServiceId() == amFmStation.getServiceId()) {
                    if (!(null == hdStationInfo.getCoverArt() || StateAmFmActive.currentStationHDStatus != 4 && StateAmFmActive.currentStationHDStatus != 2 || RadioUtil.isValid(resourceLocator = hdStationInfo.getCoverArt()))) {
                        resourceLocator = null;
                    }
                    if (logger.isTraceEnabled(128)) {
                        logger.trace(128).append(" getLogoForStationView: Image taken from Cover art: ").append(resourceLocator != null ? resourceLocator.toString() : "NULL").log();
                    }
                }
                if (null == resourceLocator) {
                    resourceLocator = this.getAmFmStationArt(amFmStation);
                }
            }
            if (!RadioUtil.isValid(resourceLocator)) {
                if (logger.isTraceEnabled(128)) {
                    logger.trace(128).append(" getLogoForStationView: locator.id <= 0 && null == locator.url ").log();
                }
                resourceLocator = null;
            }
            return resourceLocator;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    @Override
    public ResourceLocator getAmFmStationArt(AmFmStation amFmStation) {
        try {
            ResourceLocator resourceLocator = null;
            if (null != amFmStation) {
                int n = AmFmPresetApi.getIndexOfPreset(amFmStation);
                if (n >= 0) {
                    resourceLocator = AmFmPresetApi.getImage(RadioCurrentWaveband.get(), n);
                    if (logger.isTraceEnabled(128)) {
                        logger.trace(128).append(" getAmFmStationArt: Image taken from Preset: ").append(resourceLocator != null ? resourceLocator.toString() : "NULL").log();
                    }
                } else if (logger.isTraceEnabled(128)) {
                    // empty if block
                }
                if (null == resourceLocator) {
                    HdStationInfo hdStationInfo = RadioData.getAmfmDatabase().getCurrentHDStation();
                    if (null != hdStationInfo && hdStationInfo.getFrequency() == amFmStation.getFrequency() && hdStationInfo.getServiceId() == amFmStation.getServiceId()) {
                        resourceLocator = hdStationInfo.getStationArt();
                        if (logger.isTraceEnabled(128)) {
                            logger.trace(128).append(" getAmFmStationArt: Image taken from HdStation art: ").append(resourceLocator != null ? resourceLocator.toString() : "NULL").log();
                        }
                    }
                    if (null == resourceLocator) {
                        resourceLocator = amFmStation.getStationArt();
                        if (logger.isTraceEnabled(128)) {
                            logger.trace(128).append(" getAmFmStationArt: Image taken from Station: ").append(resourceLocator != null ? resourceLocator.toString() : "NULL").log();
                        }
                        if (resourceLocator == null) {
                            AmFmStation amFmStation2 = null;
                            if (amFmStation.getWaveband() == 1) {
                                amFmStation2 = RadioData.getAmfmDatabase().getAslStationListFM().getByFrequencyAndSubChannel(amFmStation.getFrequency(), amFmStation.getServiceId());
                            } else if (amFmStation.getWaveband() == 3 || amFmStation.getWaveband() == 4) {
                                amFmStation2 = RadioData.getAmfmDatabase().getAslStationListAM().getByFrequency(amFmStation.getFrequency());
                            }
                            if (null != amFmStation2) {
                                resourceLocator = amFmStation2.getStationArt();
                                if (logger.isTraceEnabled(128)) {
                                    logger.trace(128).append(" getAmFmStationArt: Image taken from Station list: ").append(resourceLocator != null ? resourceLocator.toString() : "NULL").log();
                                }
                            }
                        }
                    }
                }
            }
            if (!RadioUtil.isValid(resourceLocator)) {
                if (logger.isTraceEnabled(128)) {
                    logger.trace(128).append(" getAmFmStationArt: locator.id <= 0 && null == locator.url ").log();
                }
                resourceLocator = null;
            }
            return resourceLocator;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    @Override
    public void updateLogoToHmi() {
        AmFmStation amFmStation;
        AmFmPreset amFmPreset;
        AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
        this.updateLogoInStationView(this.getLogoForStationView());
        ResourceLocator resourceLocator = this.getAmFmStationArt(amFmStation2);
        RadioServiceManager.getServiceManager().getGuiBapApi().changeInFmHdStationLogosForKombi(resourceLocator);
        int n = AmFmPresetApi.getCurrentIndex();
        if (n >= 0 && !AmFmPresetApi.isImageUserAssignedForCurrentPreset() && null != (amFmPreset = AmFmPresetApi.getPresetByIndex(RadioCurrentWaveband.get(), n)) && null != amFmStation2 && null != (amFmStation = amFmPreset.getPresetStation()) && amFmStation.getFrequency() == amFmStation2.getFrequency() && amFmStation.getServiceId() == amFmStation2.getServiceId() && amFmStation.getShortNameHD().equals(amFmStation2.getShortNameHD()) && !RadioUtil.equals(resourceLocator, amFmStation.getStationArt())) {
            if (logger.isTraceEnabled(128)) {
                logger.trace(128).append(" Preset image is set when Different image is available : ").append(resourceLocator != null ? resourceLocator.toString() : "NULL").log();
            }
            amFmPreset.setImage(resourceLocator, false);
            AmFmPresetApi.updateGuiList(RadioCurrentWaveband.get());
        }
    }

    @Override
    public void updateLogoInStationView(ResourceLocator resourceLocator) {
        if (resourceLocator == null) {
            resourceLocator = new ResourceLocator();
        }
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("Resource Locator updated to Model: ").append(resourceLocator.toString()).log();
        }
        if (RadioCurrentWaveband.isAm()) {
            this.setPropertyResourceLocator(1415, resourceLocator);
        } else {
            this.setPropertyResourceLocator(1414, resourceLocator);
        }
    }

    @Override
    public void updateHDFilterinAM(boolean bl) {
        this.setPropertyBoolean(549856256, bl);
    }

    @Override
    public void updateHDFilterinFM(boolean bl) {
        this.setPropertyBoolean(566633472, bl);
    }

    @Override
    public void isHDFilteredStationListEmpty(boolean bl) {
        this.setPropertyBoolean(868623360, bl);
    }

    @Override
    public void updateTaggingButtonVisibility(boolean bl) {
        this.setPropertyBoolean(1427, bl);
    }
}

