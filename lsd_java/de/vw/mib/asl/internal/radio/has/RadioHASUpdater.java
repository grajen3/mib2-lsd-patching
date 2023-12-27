/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.has;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.transformer.AMPresetListInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.AMStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.DabPresetListInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMPresetListInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCurrentChannelInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoAMCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoDABCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoFMCollector;
import generated.de.vw.mib.has.containers.RadioBandContainer;
import generated.de.vw.mib.has.containers.RadioBandsContainer;
import generated.de.vw.mib.has.containers.RadioFrequencyRangesContainer;
import generated.de.vw.mib.has.containers.RadioPresetContainer;
import generated.de.vw.mib.has.containers.RadioPresetsContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.RadioStationsContainer;
import generated.de.vw.mib.has.containers.RadioTextContainer;
import generated.de.vw.mib.has.containers.TrafficAnnouncementContainer;
import generated.de.vw.mib.has.contexts.radio.RadioProperties;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.sdars.StationInfo;

public class RadioHASUpdater {
    private static final RadioProperties HAS_PROPERTIES;
    private static final RadioBandsContainer RADIO_BANDS_CONTAINER;
    private static final RadioBandContainer RADIO_BAND_CONTAINER_FM;
    private static final RadioBandContainer RADIO_BAND_CONTAINER_AM;
    private static final RadioBandContainer RADIO_BAND_CONTAINER_DAB;
    private static final RadioBandContainer RADIO_BAND_CONTAINER_SDARS;
    private static final RadioFrequencyRangesContainer RADIO_FREQUENCY_RANGES_CONTAINER;
    private static final RadioStationsContainer AVAILABLE_AM_STATIONS_CONTAINER;
    private static final RadioStationsContainer AVAILABLE_FM_STATIONS_CONTAINER;
    private static final RadioStationsContainer AVAILABLE_DAB_SERVICES_CONTAINER;
    private static final RadioStationsContainer AVAILABLE_DAB_ENSEMBLES_CONTAINER;
    private static final RadioStationsContainer AVAILABLE_DAB_COMPONENTS_CONTAINER;
    private static final RadioStationsContainer AVAILABLE_SDARS_STATIONS_CONTAINER;
    private static final RadioStationInfoContainer CURRENT_STATION_CONTAINER;
    private static final RadioPresetsContainer RADIO_AM_PRESETS_CONTAINER;
    private static final RadioPresetsContainer RADIO_FM_PRESETS_CONTAINER;
    private static final RadioPresetsContainer RADIO_DAB_PRESETS_CONTAINER;
    private static final TrafficAnnouncementContainer TRAFFIC_ANNOUNCEMENT_CONTAINER;
    private static final RadioTextContainer RADIO_TEXT_CONTAINER;
    private static boolean[] tunerAvailable;

    public static void setTunerAvailable(int n) {
        if (n == ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM) {
            RadioHASUpdater.tunerAvailable[0] = true;
        } else if (n == ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB) {
            RadioHASUpdater.tunerAvailable[1] = ServiceManager.configManagerDiag.isFeatureFlagSet(49);
        } else if (n == ASLRadioTargetIds.ASL_SDARS_MAIN_TARGET) {
            RadioHASUpdater.tunerAvailable[2] = ServiceManager.configManagerDiag.isFeatureFlagSet(238);
        }
        ArrayList arrayList = new ArrayList();
        if (tunerAvailable[0]) {
            arrayList.add(RADIO_BAND_CONTAINER_FM);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(1)) {
                arrayList.add(RADIO_BAND_CONTAINER_AM);
            }
        }
        if (tunerAvailable[1]) {
            arrayList.add(RADIO_BAND_CONTAINER_DAB);
        }
        if (tunerAvailable[2]) {
            arrayList.add(RADIO_BAND_CONTAINER_SDARS);
        }
        if (Util.isNullOrEmpty(arrayList)) {
            RADIO_BANDS_CONTAINER.unsetBands();
        } else {
            RADIO_BANDS_CONTAINER.setBands((RadioBandContainer[])arrayList.toArray(new RadioBandContainer[arrayList.size()]));
        }
        HAS_PROPERTIES.updateAvailableRadioBands(RADIO_BANDS_CONTAINER);
    }

    public static void updateAmStationList(AMStationInfoCollector[] aMStationInfoCollectorArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioStationInfoContainer[] radioStationInfoContainerArray = new RadioStationInfoContainer[aMStationInfoCollectorArray.length];
        for (int i2 = 0; i2 < aMStationInfoCollectorArray.length; ++i2) {
            AMStationInfoCollector aMStationInfoCollector = aMStationInfoCollectorArray[i2];
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(1);
            radioStationInfoContainer.unsetEnsembleId();
            radioStationInfoContainer.unsetExtendedCountryCode();
            radioStationInfoContainer.setFrequency(aMStationInfoCollector.station.getFrequency() * 1000);
            radioStationInfoContainer.unsetFrequencyLabel();
            radioStationInfoContainer.unsetName();
            radioStationInfoContainer.unsetPICode();
            radioStationInfoContainer.unsetRDS();
            radioStationInfoContainer.unsetServiceComponentId();
            radioStationInfoContainer.unsetServiceId();
            radioStationInfoContainer.unsetShortName();
            radioStationInfoContainer.unsetStationLogo();
            radioStationInfoContainer.unsetTP();
            radioStationInfoContainerArray[i2] = radioStationInfoContainer;
        }
        AVAILABLE_AM_STATIONS_CONTAINER.setStations(radioStationInfoContainerArray);
        HAS_PROPERTIES.updateAvailableAMStations(AVAILABLE_AM_STATIONS_CONTAINER);
    }

    public static void updateAmStationList(AmFmStation[] amFmStationArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioStationInfoContainer[] radioStationInfoContainerArray = new RadioStationInfoContainer[amFmStationArray.length];
        for (int i2 = 0; i2 < amFmStationArray.length; ++i2) {
            AmFmStation amFmStation = amFmStationArray[i2];
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(1);
            radioStationInfoContainer.unsetEnsembleId();
            radioStationInfoContainer.unsetExtendedCountryCode();
            radioStationInfoContainer.setFrequency(amFmStation.getFrequency() * 1000);
            radioStationInfoContainer.unsetFrequencyLabel();
            radioStationInfoContainer.unsetName();
            radioStationInfoContainer.unsetPICode();
            radioStationInfoContainer.unsetRDS();
            radioStationInfoContainer.unsetServiceComponentId();
            radioStationInfoContainer.unsetServiceId();
            radioStationInfoContainer.unsetShortName();
            radioStationInfoContainer.unsetStationLogo();
            radioStationInfoContainer.unsetTP();
            radioStationInfoContainerArray[i2] = radioStationInfoContainer;
        }
        AVAILABLE_AM_STATIONS_CONTAINER.setStations(radioStationInfoContainerArray);
        HAS_PROPERTIES.updateAvailableAMStations(AVAILABLE_AM_STATIONS_CONTAINER);
    }

    public static void updateSdarsStationList(StationInfo[] stationInfoArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioStationInfoContainer[] radioStationInfoContainerArray = new RadioStationInfoContainer[stationInfoArray.length];
        for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
            StationInfo stationInfo = stationInfoArray[i2];
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(4);
            radioStationInfoContainer.unsetEnsembleId();
            radioStationInfoContainer.unsetExtendedCountryCode();
            radioStationInfoContainer.unsetFrequency();
            radioStationInfoContainer.unsetFrequencyLabel();
            radioStationInfoContainer.setName(stationInfo.getFullLabel());
            radioStationInfoContainer.unsetPICode();
            radioStationInfoContainer.unsetRDS();
            radioStationInfoContainer.unsetServiceComponentId();
            radioStationInfoContainer.setServiceId(stationInfo.getSID());
            radioStationInfoContainer.setShortName(stationInfo.getShortLabel());
            radioStationInfoContainer.setStationLogo(stationInfo.getChannelArt());
            radioStationInfoContainer.unsetTP();
            radioStationInfoContainerArray[i2] = radioStationInfoContainer;
        }
        AVAILABLE_SDARS_STATIONS_CONTAINER.setStations(radioStationInfoContainerArray);
    }

    public static void updateFmStationList(FMStationInfoCollector[] fMStationInfoCollectorArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioStationInfoContainer[] radioStationInfoContainerArray = new RadioStationInfoContainer[fMStationInfoCollectorArray.length];
        for (int i2 = 0; i2 < fMStationInfoCollectorArray.length; ++i2) {
            FMStationInfoCollector fMStationInfoCollector = fMStationInfoCollectorArray[i2];
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(2);
            radioStationInfoContainer.unsetEnsembleId();
            radioStationInfoContainer.unsetExtendedCountryCode();
            radioStationInfoContainer.setFrequency(fMStationInfoCollector.station.getFrequency() * 1000);
            radioStationInfoContainer.unsetFrequencyLabel();
            radioStationInfoContainer.setName(fMStationInfoCollector.station.getRealName());
            radioStationInfoContainer.setPICode(fMStationInfoCollector.station.getPi());
            radioStationInfoContainer.setRDS(fMStationInfoCollector.station.isRds());
            radioStationInfoContainer.unsetServiceComponentId();
            radioStationInfoContainer.unsetServiceId();
            radioStationInfoContainer.unsetShortName();
            radioStationInfoContainer.unsetStationLogo();
            radioStationInfoContainer.setTP(fMStationInfoCollector.station.getTP());
            radioStationInfoContainerArray[i2] = radioStationInfoContainer;
        }
        AVAILABLE_FM_STATIONS_CONTAINER.setStations(radioStationInfoContainerArray);
        HAS_PROPERTIES.updateAvailableFMStations(AVAILABLE_FM_STATIONS_CONTAINER);
    }

    public static void updateFmStationList(AmFmStation[] amFmStationArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioStationInfoContainer[] radioStationInfoContainerArray = new RadioStationInfoContainer[amFmStationArray.length];
        for (int i2 = 0; i2 < amFmStationArray.length; ++i2) {
            AmFmStation amFmStation = amFmStationArray[i2];
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(2);
            radioStationInfoContainer.unsetEnsembleId();
            radioStationInfoContainer.unsetExtendedCountryCode();
            radioStationInfoContainer.setFrequency(amFmStation.getFrequency() * 1000);
            radioStationInfoContainer.unsetFrequencyLabel();
            radioStationInfoContainer.setName(amFmStation.getRealName());
            radioStationInfoContainer.setPICode(amFmStation.getPi());
            radioStationInfoContainer.setRDS(amFmStation.isRds());
            radioStationInfoContainer.unsetServiceComponentId();
            radioStationInfoContainer.unsetServiceId();
            radioStationInfoContainer.unsetShortName();
            radioStationInfoContainer.unsetStationLogo();
            radioStationInfoContainer.setTP(amFmStation.getTP());
            radioStationInfoContainerArray[i2] = radioStationInfoContainer;
        }
        AVAILABLE_FM_STATIONS_CONTAINER.setStations(radioStationInfoContainerArray);
        HAS_PROPERTIES.updateAvailableFMStations(AVAILABLE_FM_STATIONS_CONTAINER);
    }

    public static void updateDABServiceList(ServiceInfo[] serviceInfoArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioStationInfoContainer[] radioStationInfoContainerArray = new RadioStationInfoContainer[serviceInfoArray.length];
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            ServiceInfo serviceInfo = serviceInfoArray[i2];
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(3);
            radioStationInfoContainer.setEnsembleId(serviceInfo.getEnsID());
            radioStationInfoContainer.setExtendedCountryCode(serviceInfo.getEnsECC());
            radioStationInfoContainer.unsetFrequency();
            radioStationInfoContainer.unsetFrequencyLabel();
            radioStationInfoContainer.setName(serviceInfo.getFullName());
            radioStationInfoContainer.unsetPICode();
            radioStationInfoContainer.unsetRDS();
            radioStationInfoContainer.unsetServiceComponentId();
            radioStationInfoContainer.setServiceId(serviceInfo.getSID());
            radioStationInfoContainer.setShortName(serviceInfo.getShortName());
            radioStationInfoContainer.unsetStationLogo();
            radioStationInfoContainer.setTP(serviceInfo.isTp());
            radioStationInfoContainerArray[i2] = radioStationInfoContainer;
        }
        AVAILABLE_DAB_SERVICES_CONTAINER.setStations(radioStationInfoContainerArray);
        HAS_PROPERTIES.updateAvailableDABServices(AVAILABLE_DAB_SERVICES_CONTAINER);
    }

    public static void updateDABEnsembleList(EnsembleInfo[] ensembleInfoArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioStationInfoContainer[] radioStationInfoContainerArray = new RadioStationInfoContainer[ensembleInfoArray.length];
        for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
            EnsembleInfo ensembleInfo = ensembleInfoArray[i2];
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(3);
            radioStationInfoContainer.setEnsembleId(ensembleInfo.getEnsID());
            radioStationInfoContainer.setExtendedCountryCode(ensembleInfo.getEnsECC());
            radioStationInfoContainer.setFrequency(ensembleInfo.getFrequencyValue());
            radioStationInfoContainer.setFrequencyLabel(ensembleInfo.getFrequencyLabel());
            radioStationInfoContainer.setName(ensembleInfo.getFullName());
            radioStationInfoContainer.unsetPICode();
            radioStationInfoContainer.unsetRDS();
            radioStationInfoContainer.unsetServiceComponentId();
            radioStationInfoContainer.unsetServiceId();
            radioStationInfoContainer.setShortName(ensembleInfo.getShortName());
            radioStationInfoContainer.unsetStationLogo();
            radioStationInfoContainer.setTP(ensembleInfo.isTp());
            radioStationInfoContainerArray[i2] = radioStationInfoContainer;
        }
        AVAILABLE_DAB_ENSEMBLES_CONTAINER.setStations(radioStationInfoContainerArray);
        HAS_PROPERTIES.updateAvailableDABEnsembles(AVAILABLE_DAB_ENSEMBLES_CONTAINER);
    }

    public static void updateDABComponentList(ComponentInfo[] componentInfoArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioStationInfoContainer[] radioStationInfoContainerArray = new RadioStationInfoContainer[componentInfoArray.length];
        for (int i2 = 0; i2 < componentInfoArray.length; ++i2) {
            ComponentInfo componentInfo = componentInfoArray[i2];
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(3);
            radioStationInfoContainer.setEnsembleId(componentInfo.getEnsID());
            radioStationInfoContainer.setExtendedCountryCode(componentInfo.getEnsECC());
            radioStationInfoContainer.unsetFrequency();
            radioStationInfoContainer.unsetFrequencyLabel();
            radioStationInfoContainer.setName(componentInfo.getFullName());
            radioStationInfoContainer.unsetPICode();
            radioStationInfoContainer.unsetRDS();
            radioStationInfoContainer.setServiceComponentId(componentInfo.getSCIDI());
            radioStationInfoContainer.setServiceId(componentInfo.getSID());
            radioStationInfoContainer.setShortName(componentInfo.getShortName());
            radioStationInfoContainer.unsetStationLogo();
            radioStationInfoContainer.unsetTP();
            radioStationInfoContainerArray[i2] = radioStationInfoContainer;
        }
        AVAILABLE_DAB_COMPONENTS_CONTAINER.setStations(radioStationInfoContainerArray);
        HAS_PROPERTIES.updateAvailableDABServiceComponents(AVAILABLE_DAB_COMPONENTS_CONTAINER);
    }

    public static void updateFMBandRange(int n) {
        int n2 = RadioHASUpdater.convertFMBandRangeASL2HAS(n);
        if (n2 == -1) {
            RADIO_FREQUENCY_RANGES_CONTAINER.unsetFMRange();
        } else {
            RADIO_FREQUENCY_RANGES_CONTAINER.setFMRange(n2);
        }
        HAS_PROPERTIES.updateRadioFrequencyRanges(RADIO_FREQUENCY_RANGES_CONTAINER);
    }

    public static void updateAMBandRange(int n) {
        int n2 = RadioHASUpdater.convertAMBandRangeASL2HAS(n);
        if (n2 == -1) {
            RADIO_FREQUENCY_RANGES_CONTAINER.unsetAMRange();
        } else {
            RADIO_FREQUENCY_RANGES_CONTAINER.setAMRange(n2);
        }
        HAS_PROPERTIES.updateRadioFrequencyRanges(RADIO_FREQUENCY_RANGES_CONTAINER);
    }

    private static int convertAMBandRangeASL2HAS(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
        }
        return -1;
    }

    private static int convertFMBandRangeASL2HAS(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
        }
        return -1;
    }

    public static void updateCurrentFMStation(RadioCurrentStationInfoFMCollector radioCurrentStationInfoFMCollector, AmFmStation amFmStation) {
        CURRENT_STATION_CONTAINER.setBand(2);
        CURRENT_STATION_CONTAINER.unsetEnsembleId();
        CURRENT_STATION_CONTAINER.unsetExtendedCountryCode();
        CURRENT_STATION_CONTAINER.unsetFMLinkingActive();
        CURRENT_STATION_CONTAINER.setFrequency(radioCurrentStationInfoFMCollector.radio_current_station_info_fm__frequency * 1000);
        CURRENT_STATION_CONTAINER.unsetFrequencyLabel();
        CURRENT_STATION_CONTAINER.setName(radioCurrentStationInfoFMCollector.radio_current_station_info_fm__name);
        if (amFmStation.getPi() != -1) {
            CURRENT_STATION_CONTAINER.setPICode(amFmStation.getPi());
        } else {
            CURRENT_STATION_CONTAINER.unsetPICode();
        }
        CURRENT_STATION_CONTAINER.setRDS(amFmStation.isRds());
        CURRENT_STATION_CONTAINER.setShortName(radioCurrentStationInfoFMCollector.radio_current_station_info_fm__short_station_name);
        CURRENT_STATION_CONTAINER.unsetServiceComponentId();
        CURRENT_STATION_CONTAINER.unsetServiceId();
        CURRENT_STATION_CONTAINER.setStationLogo(radioCurrentStationInfoFMCollector.radio_current_station_info_fm__manual_assigned_logo);
        CURRENT_STATION_CONTAINER.setTP(radioCurrentStationInfoFMCollector.radio_current_station_info_fm__ta_tp_available);
        HAS_PROPERTIES.updateRadioTuner(CURRENT_STATION_CONTAINER);
    }

    public static void updateCurrentSdarsStation(RadioSATCurrentChannelInfoCollector radioSATCurrentChannelInfoCollector) {
        CURRENT_STATION_CONTAINER.setBand(4);
        CURRENT_STATION_CONTAINER.unsetEnsembleId();
        CURRENT_STATION_CONTAINER.unsetExtendedCountryCode();
        CURRENT_STATION_CONTAINER.unsetFMLinkingActive();
        CURRENT_STATION_CONTAINER.unsetFrequency();
        CURRENT_STATION_CONTAINER.unsetFrequencyLabel();
        CURRENT_STATION_CONTAINER.setName(radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__name);
        CURRENT_STATION_CONTAINER.unsetPICode();
        CURRENT_STATION_CONTAINER.unsetRDS();
        CURRENT_STATION_CONTAINER.setShortName(radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__short_name);
        CURRENT_STATION_CONTAINER.unsetServiceComponentId();
        CURRENT_STATION_CONTAINER.setServiceId(radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__number);
        CURRENT_STATION_CONTAINER.setStationLogo(radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__logo);
        CURRENT_STATION_CONTAINER.unsetTP();
        HAS_PROPERTIES.updateRadioTuner(CURRENT_STATION_CONTAINER);
    }

    public static void updateCurrentAMStation(RadioCurrentStationInfoAMCollector radioCurrentStationInfoAMCollector) {
        CURRENT_STATION_CONTAINER.setBand(1);
        CURRENT_STATION_CONTAINER.unsetEnsembleId();
        CURRENT_STATION_CONTAINER.unsetExtendedCountryCode();
        CURRENT_STATION_CONTAINER.unsetFMLinkingActive();
        CURRENT_STATION_CONTAINER.setFrequency(radioCurrentStationInfoAMCollector.radio_current_station_info_am__frequency * 1000);
        CURRENT_STATION_CONTAINER.unsetFrequencyLabel();
        CURRENT_STATION_CONTAINER.setName(radioCurrentStationInfoAMCollector.radio_current_station_info_am__name);
        CURRENT_STATION_CONTAINER.unsetPICode();
        CURRENT_STATION_CONTAINER.unsetRDS();
        CURRENT_STATION_CONTAINER.setShortName(radioCurrentStationInfoAMCollector.radio_current_station_info_am__short_name);
        CURRENT_STATION_CONTAINER.unsetServiceComponentId();
        CURRENT_STATION_CONTAINER.unsetServiceId();
        CURRENT_STATION_CONTAINER.setStationLogo(radioCurrentStationInfoAMCollector.radio_current_station_info_am__manual_assigned_logo != null ? radioCurrentStationInfoAMCollector.radio_current_station_info_am__manual_assigned_logo : radioCurrentStationInfoAMCollector.radio_current_station_info_am__auto_assigned_logo);
        CURRENT_STATION_CONTAINER.unsetTP();
        HAS_PROPERTIES.updateRadioTuner(CURRENT_STATION_CONTAINER);
    }

    public static void updateCurrentDABFMLinking(boolean bl) {
        CURRENT_STATION_CONTAINER.setFMLinkingActive(bl);
        HAS_PROPERTIES.updateRadioTuner(CURRENT_STATION_CONTAINER);
    }

    public static void updateCurrentDABStation(RadioCurrentStationInfoDABCollector radioCurrentStationInfoDABCollector, EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        CURRENT_STATION_CONTAINER.setBand(3);
        if (ensembleInfo == null) {
            CURRENT_STATION_CONTAINER.unsetEnsembleId();
            CURRENT_STATION_CONTAINER.unsetExtendedCountryCode();
            CURRENT_STATION_CONTAINER.unsetFrequency();
        } else {
            CURRENT_STATION_CONTAINER.setEnsembleId(ensembleInfo.getEnsID());
            CURRENT_STATION_CONTAINER.setExtendedCountryCode(ensembleInfo.getEnsECC());
            CURRENT_STATION_CONTAINER.setFrequency(ensembleInfo.getFrequencyValue());
        }
        CURRENT_STATION_CONTAINER.setFrequencyLabel(radioCurrentStationInfoDABCollector.radio_current_station_info_dab__frequency_label);
        CURRENT_STATION_CONTAINER.setName(componentInfo != null ? radioCurrentStationInfoDABCollector.radio_current_station_info_dab__secondary_service_name : radioCurrentStationInfoDABCollector.radio_current_station_info_dab__service_ps);
        CURRENT_STATION_CONTAINER.unsetPICode();
        CURRENT_STATION_CONTAINER.unsetRDS();
        CURRENT_STATION_CONTAINER.setShortName(componentInfo != null ? radioCurrentStationInfoDABCollector.radio_current_station_info_dab__secondary_service_short_name : radioCurrentStationInfoDABCollector.radio_current_station_info_dab__service_short_name);
        if (componentInfo == null) {
            CURRENT_STATION_CONTAINER.unsetServiceComponentId();
        } else {
            CURRENT_STATION_CONTAINER.setServiceComponentId(componentInfo.getSCIDI());
        }
        if (serviceInfo == null) {
            CURRENT_STATION_CONTAINER.unsetServiceId();
        } else {
            CURRENT_STATION_CONTAINER.setServiceId(serviceInfo.getSID());
        }
        CURRENT_STATION_CONTAINER.setStationLogo(radioCurrentStationInfoDABCollector.radio_current_station_info_dab__manual_assigned_logo);
        CURRENT_STATION_CONTAINER.setTP(radioCurrentStationInfoDABCollector.radio_current_station_info_dab__tp_available);
        HAS_PROPERTIES.updateRadioTuner(CURRENT_STATION_CONTAINER);
    }

    public static void updateAMPresetList(AMPresetListInfoCollector[] aMPresetListInfoCollectorArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioPresetContainer[] radioPresetContainerArray = new RadioPresetContainer[aMPresetListInfoCollectorArray.length];
        for (int i2 = 0; i2 < aMPresetListInfoCollectorArray.length; ++i2) {
            AMPresetListInfoCollector aMPresetListInfoCollector = aMPresetListInfoCollectorArray[i2];
            RadioPresetContainer radioPresetContainer = (RadioPresetContainer)hASFactory.createContainer(40);
            radioPresetContainer.setPresetLogo(aMPresetListInfoCollector.imageResoureLocator);
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(1);
            radioStationInfoContainer.unsetEnsembleId();
            radioStationInfoContainer.unsetExtendedCountryCode();
            radioStationInfoContainer.setFrequency(aMPresetListInfoCollector.frequency * 1000);
            radioStationInfoContainer.unsetFrequencyLabel();
            radioStationInfoContainer.setName(aMPresetListInfoCollector.name);
            radioStationInfoContainer.unsetPICode();
            radioStationInfoContainer.unsetRDS();
            radioStationInfoContainer.unsetShortName();
            radioStationInfoContainer.unsetServiceComponentId();
            radioStationInfoContainer.unsetServiceId();
            radioStationInfoContainer.setStationLogo(aMPresetListInfoCollector.imageResoureLocator);
            radioStationInfoContainer.unsetTP();
            radioPresetContainer.setStation(radioStationInfoContainer);
            radioPresetContainerArray[i2] = radioPresetContainer;
        }
        RADIO_AM_PRESETS_CONTAINER.setStations(radioPresetContainerArray);
        HAS_PROPERTIES.updateRadioAMPresets(RADIO_AM_PRESETS_CONTAINER);
    }

    public static void updateFMPresetList(FMPresetListInfoCollector[] fMPresetListInfoCollectorArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioPresetContainer[] radioPresetContainerArray = new RadioPresetContainer[fMPresetListInfoCollectorArray.length];
        for (int i2 = 0; i2 < fMPresetListInfoCollectorArray.length; ++i2) {
            FMPresetListInfoCollector fMPresetListInfoCollector = fMPresetListInfoCollectorArray[i2];
            RadioPresetContainer radioPresetContainer = (RadioPresetContainer)hASFactory.createContainer(40);
            radioPresetContainer.setPresetLogo(fMPresetListInfoCollector.imageResourceLocator);
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(2);
            radioStationInfoContainer.unsetEnsembleId();
            radioStationInfoContainer.unsetExtendedCountryCode();
            radioStationInfoContainer.setFrequency(fMPresetListInfoCollector.frequency * 1000);
            radioStationInfoContainer.unsetFrequencyLabel();
            radioStationInfoContainer.setName(fMPresetListInfoCollector.name);
            radioStationInfoContainer.setPICode(fMPresetListInfoCollector.pi);
            radioStationInfoContainer.unsetRDS();
            radioStationInfoContainer.unsetShortName();
            radioStationInfoContainer.unsetServiceComponentId();
            radioStationInfoContainer.unsetServiceId();
            radioStationInfoContainer.setStationLogo(fMPresetListInfoCollector.imageResourceLocator);
            radioStationInfoContainer.unsetTP();
            radioPresetContainer.setStation(radioStationInfoContainer);
            radioPresetContainerArray[i2] = radioPresetContainer;
        }
        RADIO_FM_PRESETS_CONTAINER.setStations(radioPresetContainerArray);
        HAS_PROPERTIES.updateRadioFMPresets(RADIO_FM_PRESETS_CONTAINER);
    }

    public static void updateDABPresetList(DabPresetListInfoCollector[] dabPresetListInfoCollectorArray, DabPreset[] dabPresetArray) {
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RadioPresetContainer[] radioPresetContainerArray = new RadioPresetContainer[dabPresetListInfoCollectorArray.length];
        for (int i2 = 0; i2 < dabPresetListInfoCollectorArray.length; ++i2) {
            DabPresetListInfoCollector dabPresetListInfoCollector = dabPresetListInfoCollectorArray[i2];
            DabPreset dabPreset = dabPresetArray[i2];
            RadioPresetContainer radioPresetContainer = (RadioPresetContainer)hASFactory.createContainer(40);
            radioPresetContainer.setPresetLogo(dabPresetListInfoCollector.mResource);
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASFactory.createContainer(26);
            radioStationInfoContainer.setBand(3);
            if (dabPreset != null && dabPreset.getEnsemble() != null) {
                radioStationInfoContainer.setEnsembleId(dabPreset.getEnsemble().getEnsID());
                radioStationInfoContainer.setExtendedCountryCode(dabPreset.getEnsemble().getEnsECC());
                radioStationInfoContainer.setFrequency(dabPreset.getEnsemble().getFrequencyValue());
                radioStationInfoContainer.setFrequencyLabel(dabPreset.getEnsemble().getFrequencyLabel());
            } else {
                radioStationInfoContainer.unsetEnsembleId();
                radioStationInfoContainer.unsetExtendedCountryCode();
                radioStationInfoContainer.unsetFrequency();
                radioStationInfoContainer.unsetFrequencyLabel();
            }
            radioStationInfoContainer.setName(dabPresetListInfoCollector.mPresetName);
            radioStationInfoContainer.unsetPICode();
            radioStationInfoContainer.unsetRDS();
            radioStationInfoContainer.unsetShortName();
            radioStationInfoContainer.unsetServiceComponentId();
            if (dabPreset != null && dabPreset.getService() != null) {
                radioStationInfoContainer.setServiceId(dabPreset.getService().getSID());
            } else {
                radioStationInfoContainer.unsetServiceId();
            }
            radioStationInfoContainer.setStationLogo(dabPresetListInfoCollector.mResource);
            radioStationInfoContainer.unsetTP();
            radioPresetContainer.setStation(radioStationInfoContainer);
            radioPresetContainerArray[i2] = radioPresetContainer;
        }
        RADIO_DAB_PRESETS_CONTAINER.setStations(radioPresetContainerArray);
        HAS_PROPERTIES.updateRadioDABPresets(RADIO_DAB_PRESETS_CONTAINER);
    }

    public static int convertRadioBandHAS2ASL(int n) {
        switch (n) {
            case 1: {
                return 0;
            }
            case 3: {
                return tunerAvailable[1] ? 2 : 1;
            }
            case 4: {
                return tunerAvailable[2] ? 3 : 1;
            }
        }
        return 1;
    }

    public static void updateTAStatus(boolean bl, int n, String string) {
        TRAFFIC_ANNOUNCEMENT_CONTAINER.setActive(bl);
        if (n == -1) {
            TRAFFIC_ANNOUNCEMENT_CONTAINER.unsetFrequency();
        } else {
            TRAFFIC_ANNOUNCEMENT_CONTAINER.setFrequency(n * 1000);
        }
        if (Util.isNullOrEmpty(string)) {
            TRAFFIC_ANNOUNCEMENT_CONTAINER.unsetStationName();
        } else {
            TRAFFIC_ANNOUNCEMENT_CONTAINER.setStationName(string);
        }
        HAS_PROPERTIES.updateTrafficAnnouncement(TRAFFIC_ANNOUNCEMENT_CONTAINER);
    }

    public static void updateRadioTextInfo(String string, String string2, String string3, String string4) {
        if (Util.isNullOrEmpty(string)) {
            RADIO_TEXT_CONTAINER.unsetRadioText();
        } else {
            RADIO_TEXT_CONTAINER.setRadioText(string);
        }
        if (Util.isNullOrEmpty(string2)) {
            RADIO_TEXT_CONTAINER.unsetTitle();
        } else {
            RADIO_TEXT_CONTAINER.setTitle(string2.trim());
        }
        if (Util.isNullOrEmpty(string3)) {
            RADIO_TEXT_CONTAINER.unsetArtist();
        } else {
            RADIO_TEXT_CONTAINER.setArtist(string3.trim());
        }
        if (Util.isNullOrEmpty(string4)) {
            RADIO_TEXT_CONTAINER.unsetAlbum();
        } else {
            RADIO_TEXT_CONTAINER.setAlbum(string4.trim());
        }
        RADIO_TEXT_CONTAINER.setRadioImageAvailable(false);
        HAS_PROPERTIES.updateRadioText(RADIO_TEXT_CONTAINER);
    }

    public static void updateSlideShowImageAvailable(boolean bl) {
        RADIO_TEXT_CONTAINER.setRadioImageAvailable(bl);
        HAS_PROPERTIES.updateRadioText(RADIO_TEXT_CONTAINER);
    }

    public static void updateSlideShowImage(ResourceLocator resourceLocator) {
        if (resourceLocator == null) {
            RADIO_TEXT_CONTAINER.unsetRadioImage();
        } else {
            RADIO_TEXT_CONTAINER.setRadioImage(resourceLocator);
        }
        RADIO_TEXT_CONTAINER.setRadioImageAvailable(resourceLocator != null);
        HAS_PROPERTIES.updateRadioText(RADIO_TEXT_CONTAINER);
    }

    public static void updateBand() {
        if (RadioCurrentWaveband.isAm()) {
            CURRENT_STATION_CONTAINER.setBand(1);
        } else if (RadioCurrentWaveband.isFm()) {
            CURRENT_STATION_CONTAINER.setBand(2);
        } else if (RadioCurrentWaveband.isDab()) {
            CURRENT_STATION_CONTAINER.setBand(3);
        } else if (RadioCurrentWaveband.isSdars()) {
            CURRENT_STATION_CONTAINER.setBand(4);
        } else {
            CURRENT_STATION_CONTAINER.unsetBand();
        }
        CURRENT_STATION_CONTAINER.unsetEnsembleId();
        CURRENT_STATION_CONTAINER.unsetExtendedCountryCode();
        CURRENT_STATION_CONTAINER.unsetFMLinkingActive();
        CURRENT_STATION_CONTAINER.unsetFrequency();
        CURRENT_STATION_CONTAINER.unsetFrequencyLabel();
        CURRENT_STATION_CONTAINER.unsetName();
        CURRENT_STATION_CONTAINER.unsetPICode();
        CURRENT_STATION_CONTAINER.unsetRDS();
        CURRENT_STATION_CONTAINER.unsetServiceComponentId();
        CURRENT_STATION_CONTAINER.unsetServiceId();
        CURRENT_STATION_CONTAINER.unsetShortName();
        CURRENT_STATION_CONTAINER.unsetStationLogo();
        CURRENT_STATION_CONTAINER.unsetTP();
        HAS_PROPERTIES.updateRadioTuner(CURRENT_STATION_CONTAINER);
    }

    static {
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Radio");
        HAS_PROPERTIES = (RadioProperties)hASContext.getPropertiesImpl();
        HASFactory hASFactory = HAS.getInstance().getFactory();
        RADIO_BANDS_CONTAINER = (RadioBandsContainer)hASFactory.createContainer(35);
        RADIO_BAND_CONTAINER_FM = (RadioBandContainer)hASFactory.createContainer(30);
        RADIO_BAND_CONTAINER_FM.setBand(2);
        RADIO_BAND_CONTAINER_AM = (RadioBandContainer)hASFactory.createContainer(30);
        RADIO_BAND_CONTAINER_AM.setBand(1);
        RADIO_BAND_CONTAINER_DAB = (RadioBandContainer)hASFactory.createContainer(30);
        RADIO_BAND_CONTAINER_DAB.setBand(3);
        RADIO_BAND_CONTAINER_SDARS = (RadioBandContainer)hASFactory.createContainer(30);
        RADIO_BAND_CONTAINER_SDARS.setBand(4);
        CURRENT_STATION_CONTAINER = (RadioStationInfoContainer)hASFactory.createContainer(26);
        RADIO_FREQUENCY_RANGES_CONTAINER = (RadioFrequencyRangesContainer)hASFactory.createContainer(42);
        AVAILABLE_AM_STATIONS_CONTAINER = (RadioStationsContainer)hASFactory.createContainer(39);
        AVAILABLE_FM_STATIONS_CONTAINER = (RadioStationsContainer)hASFactory.createContainer(39);
        AVAILABLE_DAB_ENSEMBLES_CONTAINER = (RadioStationsContainer)hASFactory.createContainer(39);
        AVAILABLE_DAB_SERVICES_CONTAINER = (RadioStationsContainer)hASFactory.createContainer(39);
        AVAILABLE_DAB_COMPONENTS_CONTAINER = (RadioStationsContainer)hASFactory.createContainer(39);
        AVAILABLE_SDARS_STATIONS_CONTAINER = (RadioStationsContainer)hASFactory.createContainer(39);
        RADIO_AM_PRESETS_CONTAINER = (RadioPresetsContainer)hASFactory.createContainer(41);
        RADIO_FM_PRESETS_CONTAINER = (RadioPresetsContainer)hASFactory.createContainer(41);
        RADIO_DAB_PRESETS_CONTAINER = (RadioPresetsContainer)hASFactory.createContainer(41);
        TRAFFIC_ANNOUNCEMENT_CONTAINER = (TrafficAnnouncementContainer)hASFactory.createContainer(51);
        RADIO_TEXT_CONTAINER = (RadioTextContainer)hASFactory.createContainer(52);
        tunerAvailable = new boolean[]{false, false, false};
    }
}

