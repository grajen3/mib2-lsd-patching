/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmPersistenceService;
import de.vw.mib.asl.amfm.persistence.AmFmPersistenceServiceImpl;
import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettings;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.amfm.persistence.DabPersistence;
import de.vw.mib.asl.amfm.persistence.DabPresetPersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettings;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.amfm.persistence.SatImage;
import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerFactory;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerResponder;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListenerCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.AdapterAslPersistence$1;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.appadapter.ApiAppAdapterGlobalSetupWizard;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.sdars.StationInfo;

public final class AdapterAslPersistence {
    private RadioAmFmSettings radioAmFmSettings = null;
    private AmFmPresetSettings amFmPresetSettings = null;
    private AmFmFixedStationListPersistence amFmFixedStationListPersistence = null;
    private DabPersistence dabPersistence = null;
    private SatPersistence satPersistence = null;
    public static final int INVALID_OBJECT_ID;
    public static final int EVENT_CALLBACK_OBJECT_INDEX;
    private boolean profileChangeStarted = false;
    int oldWaveBand = 1;
    private DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback = null;
    private final DsiAwareProfileChangeListener dsiAwareProfileChangeListener = new AdapterAslPersistence$1(this);

    public void loadPersistenceInitially() {
        try {
            AmFmPersistenceServiceImpl.getInstance().addProfileChangeListener(this.dsiAwareProfileChangeListener);
            this.loadPersistence();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void loadPersistence() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("AdapterAslPersistence - loadPersistence() ").log();
                ServiceManager.logger.trace(128).append("Checking the Persistable object-IDs - ").append(AmFmPersistenceServiceImpl.getInstance().loadRadioAmFmSettings().toString()).log();
            }
            this.setRadioAmFmSettings(AmFmPersistenceServiceImpl.getInstance().loadRadioAmFmSettings());
            RadioData.getAmfmDatabase().getSettingsPersistable().setRadioAmFmSettings(this.getRadioAmFmSettings());
            AmFmFactory.getInstanceEUStationListViewWalker().setFmStationListSortOrder(RadioData.getAmfmDatabase().getSettingsPersistable().getFmStationListSortOrder());
            this.setAmFmPresetSettings(AmFmPersistenceServiceImpl.getInstance().loadAmFmPresetSettings());
            this.setAmFmFixedStationListPersistence(AmFmPersistenceServiceImpl.getInstance().loadAmFmFixedStationListPersistence());
            this.setDabPersistence(AmFmPersistenceServiceImpl.getInstance().loadDabPersistence());
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                this.setSatPersistence(AmFmPersistenceServiceImpl.getInstance().loadSatPersistence());
            }
            AmFmFactory.getAslAmfmModelController().updateFmViewState(RadioData.getAmfmDatabase().getSettingsPersistable().getFmViewState());
            AmFmFactory.getAslAmfmModelController().updateAmViewState(RadioData.getAmfmDatabase().getSettingsPersistable().getAmViewState());
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void handleUserProfileChangedEvent() {
        try {
            EntertainmentManagerResponder entertainmentManagerResponder;
            HsmTarget hsmTarget;
            RadioServiceManager.getServiceManager().setAmFmDefaultOrLsmFreqYetTobeTuned(true);
            RadioServiceManager.getServiceManager().setSdarsDefaultOrLsmFreqYetTobeTuned(true);
            this.loadPersistence();
            RadioDataApi.deleteHmiLogoBuffer();
            ApiAppAdapterGlobalSetupWizard.activateStartScanButton();
            RadioData.getAmfmDatabase().getFixedStationList().fromPersistence();
            de.vw.mib.asl.internal.radio.amfm.main.HsmTarget hsmTarget2 = RadioServiceManager.getServiceManager().getRadioAmFMTarget();
            if (null != hsmTarget2) {
                hsmTarget2.initializeAmFmPresets();
                hsmTarget2.initializeAmFmTuner(false);
            }
            if (null != (hsmTarget = RadioServiceManager.getServiceManager().getRadioDabTarget()) && RadioData.getDabDatabase().getDabDeviceFitted()) {
                RadioData.getDabDatabase().mPersistable.clear();
                hsmTarget.initFromPersistence();
                hsmTarget.informDSINewUserSettings();
                hsmTarget.userProfileChangeRequested = true;
            }
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                SatDb.getInstance().getPersistable().fromPersistence(false);
            }
            if (null != (entertainmentManagerResponder = ASLEntertainmentmanagerFactory.getEntertainmentmanagerApi().createEntertainmentManagerResponder(1, ASLRadioTargetIds.ASL_RADIO_MANAGER))) {
                int n = RadioCurrentWaveband.get();
                if (2 == n && !RadioData.getDabDatabase().getDabDeviceFitted() || 3 == n && !ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    n = 1;
                }
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("handleUserProfileChangedEvent - oldWaveBand: ").append(this.oldWaveBand).append("handleUserProfileChangedEvent - newWaveBand: ").append(n).log();
                RadioCurrentWaveband.set(this.oldWaveBand);
                entertainmentManagerResponder.weakRequest(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    void postActionAfterNewUser() {
        if (-1 != RadioDataApi.getCurrentDatabaseVersionMajor()) {
            RadioDataApi.processDsiResponseDatabaseVersionInfo(RadioDataApi.getCurrentDatabaseVersionMajor(), RadioDataApi.getCurrentDatabaseVersionMinor(), RadioDataApi.getCurrentDatabaseVersionRevision(), "", 0, RadioDataApi.getCurrentDatabaseSuccessCode(), 0);
        }
        RadioDataApi.requestPersistStationLogosInSouthSideDb();
    }

    public AmFmStationPersistence createAmFmStationPersistence(AmFmStation amFmStation) {
        try {
            if (null == AmFmPersistenceServiceImpl.getInstance()) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - createAmFmStationPersistence() - null == radioPersistenceService").log();
                return null;
            }
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - createAmFmStationPersistence() - null == amFmStation").log();
                return null;
            }
            AmFmStationPersistence amFmStationPersistence = AmFmPersistenceServiceImpl.getInstance().createAmFmStationPersistence();
            Station station = amFmStation.getAsDSIStation();
            if (null != station.name) {
                amFmStationPersistence.setStationName(station.name);
            } else {
                amFmStationPersistence.setStationName("");
            }
            amFmStationPersistence.setStationFrequency(station.frequency);
            amFmStationPersistence.setStationPi(station.pi);
            amFmStationPersistence.setStationReceptionQuality(station.receptionQuality);
            amFmStationPersistence.setStationPtyCode(station.ptyCode);
            amFmStationPersistence.setStationWaveband(station.waveband);
            amFmStationPersistence.setStationRds(station.rds);
            amFmStationPersistence.setStationTp(station.tp);
            amFmStationPersistence.setStationTa(station.ta);
            amFmStationPersistence.setStationTmc(station.tmc);
            amFmStationPersistence.setStationScrollingPs(station.scrollingPS);
            amFmStationPersistence.setStationRadioText(station.radioText);
            if (null != station.realPS) {
                amFmStationPersistence.setStationRealPs(station.realPS);
            } else {
                amFmStationPersistence.setStationRealPs("");
            }
            amFmStationPersistence.setStationHd(station.hd);
            if (null != station.shortNameHD) {
                amFmStationPersistence.setStationShortNameHd(station.shortNameHD);
            } else {
                amFmStationPersistence.setStationShortNameHd("");
            }
            if (null != station.longNameHD) {
                amFmStationPersistence.setStationLongNameHd(station.longNameHD);
            } else {
                amFmStationPersistence.setStationLongNameHd("");
            }
            amFmStationPersistence.setStationFullDigital(station.fullDigital);
            amFmStationPersistence.setStationServiceId(station.serviceId);
            amFmStationPersistence.setStationSubscription(station.subscription);
            amFmStationPersistence.setStationEon(station.eon);
            amFmStationPersistence.setStationCoChannel(station.coChannel);
            if (null != amFmStation.getRealName()) {
                amFmStationPersistence.setRealName(amFmStation.getRealName());
            } else {
                amFmStationPersistence.setRealName("");
            }
            if (null != amFmStation.getRegionalisation()) {
                amFmStationPersistence.setRegString(amFmStation.getRegionalisation());
            } else {
                amFmStationPersistence.setRegString("");
            }
            amFmStationPersistence.setHdStatus(amFmStation.getHDStatus());
            amFmStationPersistence.setSubChannelCount(amFmStation.getSubChannelCount());
            amFmStationPersistence.setChannelMask(amFmStation.getSubChannelBitMask());
            amFmStationPersistence.setUniqueId(amFmStation.getUniqueId());
            amFmStationPersistence.setMpsWithSPSAlreadyStored(amFmStation.getMpsWithSpsAlreadyStored());
            amFmStationPersistence.setMpsWithoutSPSAlreadyStored(amFmStation.getMpsWithoutSPSAlreadyStored());
            ResourceLocator resourceLocator = amFmStation.getStationArt();
            ResourceLocatorPersistence resourceLocatorPersistence = AmFmPersistenceServiceImpl.getInstance().createResourceLocatorPersistence();
            this.initResourceLocatorPersistence(resourceLocatorPersistence, resourceLocator);
            amFmStationPersistence.setStationImage(resourceLocatorPersistence);
            return amFmStationPersistence;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public AmFmStation createAmFmStationHmi(AmFmStationPersistence amFmStationPersistence) {
        try {
            if (null != AmFmPersistenceServiceImpl.getInstance() && null != amFmStationPersistence) {
                AmFmStation amFmStation = new AmFmStation();
                Station station = amFmStation.getAsDSIStation();
                station.name = amFmStationPersistence.getStationName();
                station.frequency = amFmStationPersistence.getStationFrequency();
                station.pi = amFmStationPersistence.getStationPi();
                station.receptionQuality = amFmStationPersistence.getStationReceptionQuality();
                station.ptyCode = amFmStationPersistence.getStationPtyCode();
                station.waveband = amFmStationPersistence.getStationWaveband();
                station.rds = amFmStationPersistence.isStationRds();
                station.tp = amFmStationPersistence.isStationTp();
                station.ta = amFmStationPersistence.isStationTa();
                station.tmc = amFmStationPersistence.isStationTmc();
                station.scrollingPS = amFmStationPersistence.isStationScrollingPs();
                station.radioText = amFmStationPersistence.isStationRadioText();
                station.realPS = amFmStationPersistence.getStationRealPs();
                station.hd = amFmStationPersistence.isStationHd();
                station.shortNameHD = amFmStationPersistence.getStationShortNameHd();
                station.longNameHD = amFmStationPersistence.getStationLongNameHd();
                station.fullDigital = amFmStationPersistence.isStationFullDigital();
                station.serviceId = amFmStationPersistence.getStationServiceId();
                station.subscription = amFmStationPersistence.getStationSubscription();
                station.eon = amFmStationPersistence.isStationEon();
                station.coChannel = amFmStationPersistence.isStationCoChannel();
                amFmStation.setRealName(amFmStationPersistence.getRealName());
                amFmStation.setRegionalisation(amFmStationPersistence.getRegString());
                amFmStation.setHDStatus(amFmStationPersistence.getHdStatus());
                amFmStation.setSubChannelCount(amFmStationPersistence.getSubChannelCount());
                amFmStation.setSubChannelBitMask(amFmStationPersistence.getChannelMask());
                amFmStation.setUniqueId(amFmStationPersistence.getUniqueId());
                amFmStation.setMpsWithSPSAlreadyStored(amFmStationPersistence.isMpsWithSPSAlreadyStored());
                amFmStation.setMpsWithoutSPSAlreadyStored(amFmStationPersistence.isMpsWithoutSPSAlreadyStored());
                ResourceLocatorPersistence resourceLocatorPersistence = amFmStationPersistence.getStationImage();
                ResourceLocator resourceLocator = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createResourceLocatorHmi(resourceLocatorPersistence);
                amFmStation.setStationArt(resourceLocator);
                return amFmStation;
            }
            if (null == AmFmPersistenceServiceImpl.getInstance()) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - createAmFmStationHmi() - null == radioPersistenceService").log();
            }
            if (null == amFmStationPersistence) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - createAmFmStationHmi() - null == amFmStationPersistence").log();
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public AmFmPresetPersistence createAmFmPresetPersistence(AmFmPreset amFmPreset) {
        try {
            if (null != AmFmPersistenceServiceImpl.getInstance() && null != amFmPreset) {
                AmFmPresetPersistence amFmPresetPersistence = AmFmPersistenceServiceImpl.getInstance().createAmFmPresetPersistence();
                ResourceLocatorPersistence resourceLocatorPersistence = AmFmPersistenceServiceImpl.getInstance().createResourceLocatorPersistence();
                AmFmStation amFmStation = amFmPreset.getPresetStation();
                AmFmStationPersistence amFmStationPersistence = this.createAmFmStationPersistence(amFmStation);
                amFmPresetPersistence.setAmFmStation(amFmStationPersistence);
                amFmPresetPersistence.setManualAsssignedLogo(amFmPreset.isLogoManuallyAssignedToPreset());
                amFmPresetPersistence.setAutoStoredLogoState(amFmPreset.getAutoStoredLogoState());
                amFmPresetPersistence.setStationLogoType(amFmPreset.getStationLogoType());
                amFmPresetPersistence.setDatabaseStationId(amFmPreset.getDatabaseStationId());
                amFmPresetPersistence.setLogoDeletedIntentionallyForNar(amFmPreset.isLogoDeletedIntentionallyForNar());
                ResourceLocator resourceLocator = amFmPreset.getImage();
                this.initResourceLocatorPersistence(resourceLocatorPersistence, resourceLocator);
                amFmPresetPersistence.setStationImage(resourceLocatorPersistence);
                return amFmPresetPersistence;
            }
            if (null == AmFmPersistenceServiceImpl.getInstance()) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - createAmFmPresetPersistence() - null == radioPersistenceService").log();
            }
            if (null == amFmPreset) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - createAmFmPresetPersistence() - null == amFmPreset").log();
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void createAmFmPresetHmi(AmFmPresetPersistence amFmPresetPersistence, AmFmPreset amFmPreset) {
        try {
            AmFmStationPersistence amFmStationPersistence;
            if (null != amFmPresetPersistence && null != amFmPreset && null != (amFmStationPersistence = amFmPresetPersistence.getAmFmStation())) {
                AmFmStation amFmStation = this.createAmFmStationHmi(amFmStationPersistence);
                amFmPreset.setPresetStation(amFmStation);
                amFmPreset.setManualAssignedLogo(amFmPresetPersistence.isManualAsssignedLogo());
                amFmPreset.setLogoDeletedIntentionallyForNar(amFmPresetPersistence.isLogoDeletedIntentionallyForNar());
                if (null != amFmStation) {
                    ResourceLocatorPersistence resourceLocatorPersistence = amFmPresetPersistence.getStationImage();
                    if (null == resourceLocatorPersistence) {
                        amFmPreset.setImage(null, amFmPreset.isLogoManuallyAssignedToPreset());
                    } else {
                        int n = resourceLocatorPersistence.getIdentification();
                        String string = resourceLocatorPersistence.getUrl();
                        if (n <= -1 && (null == string || string.length() < 1)) {
                            amFmPreset.setImage(null, amFmPreset.isLogoManuallyAssignedToPreset());
                        } else {
                            amFmPreset.setImage(new ResourceLocator(n, string), amFmPreset.isLogoManuallyAssignedToPreset());
                        }
                    }
                    amFmPreset.setAutoStoredLogoState(amFmPresetPersistence.getAutoStoredLogoState());
                    amFmPreset.setStationLogoType(amFmPresetPersistence.getStationLogoType());
                    amFmPreset.setDatabaseStationId(amFmPresetPersistence.getDatabaseStationId());
                }
            }
            if (null == amFmPresetPersistence) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - createAmFmPresetHmi() - null == amFmPresetPersistence").log();
            }
            if (null == amFmPreset) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - createAmFmPresetHmi() - null == amFmPreset").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void initFrequencyPersistence(FrequencyPersistence frequencyPersistence, FrequencyInfo frequencyInfo) {
        try {
            if (null != frequencyPersistence) {
                if (frequencyInfo == null || frequencyInfo.frequency <= 0L || frequencyInfo.label.length() < 1) {
                    frequencyPersistence.setFrequency(0L);
                } else {
                    frequencyPersistence.setFrequency(frequencyInfo.frequency);
                    if (null != frequencyInfo.label) {
                        frequencyPersistence.setLabel(frequencyInfo.label);
                    } else {
                        frequencyPersistence.setLabel("");
                    }
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public FrequencyInfo createFrequencyHmi(FrequencyPersistence frequencyPersistence) {
        try {
            if (null == frequencyPersistence || frequencyPersistence.getFrequency() <= 0L) {
                return null;
            }
            FrequencyInfo frequencyInfo = new FrequencyInfo();
            frequencyInfo.frequency = frequencyPersistence.getFrequency();
            frequencyInfo.label = frequencyPersistence.getLabel();
            return frequencyInfo;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void initEnsemblePersistence(EnsemblePersistence ensemblePersistence, EnsembleInfo ensembleInfo) {
        try {
            if (null != ensemblePersistence) {
                if (ensembleInfo == null) {
                    ensemblePersistence.setEnsId(-1);
                } else {
                    ensemblePersistence.setEnsEcc(ensembleInfo.ensECC);
                    ensemblePersistence.setEnsId(ensembleInfo.ensID);
                    if (null != ensembleInfo.frequencyLabel) {
                        ensemblePersistence.setFrequencyLabel(ensembleInfo.frequencyLabel);
                    } else {
                        ensemblePersistence.setFrequencyLabel("");
                    }
                    ensemblePersistence.setFrequencyValue(ensembleInfo.frequencyValue);
                    if (null != ensembleInfo.fullName) {
                        ensemblePersistence.setFullName(ensembleInfo.fullName);
                    } else {
                        ensemblePersistence.setFullName("");
                    }
                    ensemblePersistence.setPotentiallyReceivable(ensembleInfo.potentiallyReceivable);
                    if (null != ensembleInfo.shortName) {
                        ensemblePersistence.setShortName(ensembleInfo.shortName);
                    } else {
                        ensemblePersistence.setShortName("");
                    }
                    ensemblePersistence.setTp(ensembleInfo.tp);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public EnsembleInfo createEnsembleHmi(EnsemblePersistence ensemblePersistence) {
        try {
            if (null == ensemblePersistence || ensemblePersistence.getEnsId() <= -1) {
                return null;
            }
            EnsembleInfo ensembleInfo = new EnsembleInfo();
            ensembleInfo.ensECC = ensemblePersistence.getEnsEcc();
            ensembleInfo.ensID = ensemblePersistence.getEnsId();
            ensembleInfo.frequencyLabel = ensemblePersistence.getFrequencyLabel();
            ensembleInfo.frequencyValue = ensemblePersistence.getFrequencyValue();
            ensembleInfo.fullName = ensemblePersistence.getFullName();
            ensembleInfo.potentiallyReceivable = ensemblePersistence.isPotentiallyReceivable();
            ensembleInfo.shortName = ensemblePersistence.getShortName();
            ensembleInfo.tp = ensemblePersistence.isTp();
            return ensembleInfo;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void initServicePersistence(ServicePersistence servicePersistence, ServiceInfo serviceInfo) {
        try {
            if (null != servicePersistence) {
                if (serviceInfo == null) {
                    servicePersistence.setServiceId(-1L);
                } else {
                    List list;
                    servicePersistence.setEnsEcc(serviceInfo.ensECC);
                    servicePersistence.setEnsId(serviceInfo.ensID);
                    servicePersistence.setServiceId(serviceInfo.sID);
                    if (null != serviceInfo.fullName) {
                        servicePersistence.setFullName(serviceInfo.fullName);
                    } else {
                        servicePersistence.setFullName("");
                    }
                    if (null != serviceInfo.shortName) {
                        servicePersistence.setShortName(serviceInfo.shortName);
                    } else {
                        servicePersistence.setShortName("");
                    }
                    if (serviceInfo.ptyCodes == null) {
                        serviceInfo.ptyCodes = new byte[0];
                    }
                    if (null != (list = servicePersistence.getPtyCodes())) {
                        list.clear();
                        for (int i2 = 0; i2 < serviceInfo.ptyCodes.length; ++i2) {
                            list.add(new Byte(serviceInfo.ptyCodes[i2]));
                        }
                    }
                    servicePersistence.setTp(serviceInfo.tp);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public ServiceInfo createServiceHmi(ServicePersistence servicePersistence) {
        try {
            if (null == servicePersistence || servicePersistence.getServiceId() <= -1L) {
                return null;
            }
            ServiceInfo serviceInfo = new ServiceInfo();
            serviceInfo.ensECC = servicePersistence.getEnsEcc();
            serviceInfo.ensID = servicePersistence.getEnsId();
            serviceInfo.sID = servicePersistence.getServiceId();
            serviceInfo.fullName = servicePersistence.getFullName();
            serviceInfo.shortName = servicePersistence.getShortName();
            List list = servicePersistence.getPtyCodes();
            if (null != list) {
                Iterator iterator = list.iterator();
                serviceInfo.ptyCodes = new byte[list.size()];
                if (null != iterator) {
                    for (int i2 = 0; iterator.hasNext() && i2 < serviceInfo.ptyCodes.length; ++i2) {
                        Byte by = (Byte)iterator.next();
                        if (null == by) continue;
                        serviceInfo.ptyCodes[i2] = by;
                    }
                }
            } else {
                serviceInfo.ptyCodes = new byte[0];
            }
            serviceInfo.tp = servicePersistence.isTp();
            return serviceInfo;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void initComponentPersistence(ComponentPersistence componentPersistence, ComponentInfo componentInfo) {
        try {
            if (null != componentPersistence) {
                if (componentInfo == null || componentInfo.ensID <= 0 || componentInfo.sID <= 0L) {
                    componentPersistence.setSid(-1L);
                } else {
                    componentPersistence.setEnsId(componentInfo.ensID);
                    componentPersistence.setEnsEcc(componentInfo.ensECC);
                    componentPersistence.setSid(componentInfo.sID);
                    componentPersistence.setScidi(componentInfo.sCIDI);
                    if (null != componentInfo.fullName) {
                        componentPersistence.setFullName(componentInfo.fullName);
                    } else {
                        componentPersistence.setFullName("");
                    }
                    if (null != componentInfo.shortName) {
                        componentPersistence.setShortName(componentInfo.shortName);
                    } else {
                        componentPersistence.setShortName("");
                    }
                    componentPersistence.setPrimaryService(componentInfo.primaryService);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public ComponentInfo createComponentHmi(ComponentPersistence componentPersistence) {
        try {
            if (null == componentPersistence || componentPersistence.getSid() <= -1L) {
                return null;
            }
            ComponentInfo componentInfo = new ComponentInfo();
            componentInfo.ensID = componentPersistence.getEnsId();
            componentInfo.ensECC = componentPersistence.getEnsEcc();
            componentInfo.sID = componentPersistence.getSid();
            componentInfo.sCIDI = componentPersistence.getScidi();
            componentInfo.fullName = componentPersistence.getFullName();
            componentInfo.shortName = componentPersistence.getShortName();
            componentInfo.primaryService = componentPersistence.isPrimaryService();
            return componentInfo;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public DabPresetPersistence createDabPresetPersistence(DabPreset dabPreset) {
        try {
            if (null != AmFmPersistenceServiceImpl.getInstance()) {
                DabPresetPersistence dabPresetPersistence = AmFmPersistenceServiceImpl.getInstance().createDabPresetPersistence();
                EnsemblePersistence ensemblePersistence = AmFmPersistenceServiceImpl.getInstance().createEnsemblePersistence();
                ServicePersistence servicePersistence = AmFmPersistenceServiceImpl.getInstance().createServicePersistence();
                FrequencyPersistence frequencyPersistence = AmFmPersistenceServiceImpl.getInstance().createFrequencyPersistence();
                ResourceLocatorPersistence resourceLocatorPersistence = AmFmPersistenceServiceImpl.getInstance().createResourceLocatorPersistence();
                if (dabPreset != null && dabPreset.getService() != null) {
                    EnsembleInfo ensembleInfo = dabPreset.getEnsemble();
                    ServiceInfo serviceInfo = dabPreset.getService();
                    this.initEnsemblePersistence(ensemblePersistence, ensembleInfo);
                    this.initServicePersistence(servicePersistence, serviceInfo);
                    FrequencyInfo frequencyInfo = dabPreset.getFrequency();
                    this.initFrequencyPersistence(frequencyPersistence, frequencyInfo);
                    ResourceLocator resourceLocator = dabPreset.getImage();
                    if (null == resourceLocator) {
                        resourceLocatorPersistence.setIdentification(-1);
                        resourceLocatorPersistence.setUrl("");
                    } else {
                        resourceLocatorPersistence.setIdentification(resourceLocator.id);
                        resourceLocatorPersistence.setUrl(resourceLocator.url);
                    }
                    dabPresetPersistence.setDatabaseStationId(dabPreset.getDatabaseStationId());
                    dabPresetPersistence.setService(servicePersistence);
                    dabPresetPersistence.setEnsemble(ensemblePersistence);
                    dabPresetPersistence.setFrequency(frequencyPersistence);
                    dabPresetPersistence.setStationImage(resourceLocatorPersistence);
                    return dabPresetPersistence;
                }
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public DabPreset createDabPresetHmi(DabPresetPersistence dabPresetPersistence) {
        try {
            if (null == dabPresetPersistence) {
                return null;
            }
            ServicePersistence servicePersistence = dabPresetPersistence.getService();
            EnsemblePersistence ensemblePersistence = dabPresetPersistence.getEnsemble();
            if (null == servicePersistence || servicePersistence.getServiceId() <= -1L || null == ensemblePersistence || ensemblePersistence.getEnsId() <= -1) {
                return null;
            }
            ServiceInfo serviceInfo = this.createServiceHmi(servicePersistence);
            EnsembleInfo ensembleInfo = this.createEnsembleHmi(ensemblePersistence);
            DabPreset dabPreset = new DabPreset(serviceInfo, ensembleInfo);
            FrequencyPersistence frequencyPersistence = dabPresetPersistence.getFrequency();
            dabPreset.setFrequency(this.createFrequencyHmi(frequencyPersistence));
            ResourceLocatorPersistence resourceLocatorPersistence = dabPresetPersistence.getStationImage();
            dabPreset.setPicture(this.createResourceLocatorHmi(resourceLocatorPersistence));
            dabPreset.setDatabaseStationId(dabPresetPersistence.getDatabaseStationId());
            return dabPreset;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void initStationInfoPersistence(StationInfoPersistence stationInfoPersistence, StationInfo stationInfo) {
        try {
            if (null != stationInfoPersistence) {
                if (stationInfo == null) {
                    stationInfoPersistence.setSid(-1);
                } else {
                    stationInfoPersistence.setCategoryNumber(stationInfo.categoryNumber);
                    stationInfoPersistence.setSubscription(stationInfo.subscription);
                    stationInfoPersistence.setSid((short)stationInfo.sID);
                    stationInfoPersistence.setStationNumber(stationInfo.stationNumber);
                    if (null != stationInfo.shortLabel) {
                        stationInfoPersistence.setShortLabel(stationInfo.shortLabel);
                    } else {
                        stationInfoPersistence.setShortLabel("");
                    }
                    if (null != stationInfo.fullLabel) {
                        stationInfoPersistence.setFullLabel(stationInfo.fullLabel);
                    } else {
                        stationInfoPersistence.setFullLabel("");
                    }
                    stationInfoPersistence.setMature(stationInfo.mature);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public StationInfo createStationInfo(StationInfoPersistence stationInfoPersistence) {
        try {
            if (null == stationInfoPersistence || stationInfoPersistence.getSid() <= -1) {
                return null;
            }
            StationInfo stationInfo = new StationInfo();
            stationInfo.categoryNumber = (short)stationInfoPersistence.getCategoryNumber();
            stationInfo.subscription = stationInfoPersistence.getSubscription();
            stationInfo.sID = stationInfoPersistence.getSid();
            stationInfo.stationNumber = (short)stationInfoPersistence.getStationNumber();
            stationInfo.shortLabel = stationInfoPersistence.getShortLabel();
            stationInfo.fullLabel = stationInfoPersistence.getFullLabel();
            stationInfo.mature = stationInfoPersistence.isMature();
            return stationInfo;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void initSatImagePersistence(SatImage satImage, IntObjectMap$Entry intObjectMap$Entry) {
        try {
            if (null != satImage) {
                if (intObjectMap$Entry == null) {
                    satImage.setSid(-1);
                } else {
                    int n = intObjectMap$Entry.getKey();
                    satImage.setSid((short)n);
                    ResourceLocator resourceLocator = (ResourceLocator)intObjectMap$Entry.getValue();
                    ResourceLocatorPersistence resourceLocatorPersistence = AmFmPersistenceServiceImpl.getInstance().createResourceLocatorPersistence();
                    this.initResourceLocatorPersistence(resourceLocatorPersistence, resourceLocator);
                    satImage.setResourceLocator(resourceLocatorPersistence);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void initResourceLocatorPersistence(ResourceLocatorPersistence resourceLocatorPersistence, ResourceLocator resourceLocator) {
        try {
            if (null != resourceLocatorPersistence) {
                if (null == resourceLocator) {
                    resourceLocatorPersistence.setIdentification(-1);
                    resourceLocatorPersistence.setUrl("");
                } else {
                    resourceLocatorPersistence.setIdentification(resourceLocator.id);
                    resourceLocatorPersistence.setUrl(resourceLocator.url);
                }
            } else {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - initResourceLocatorPersistence() - null == resourceLocatorPersistence").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public ResourceLocator createResourceLocatorHmi(ResourceLocatorPersistence resourceLocatorPersistence) {
        try {
            if (null == resourceLocatorPersistence) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AdapterAslPersistence - createResourceLocatorHmi() - null == resourceLocatorPersistence").log();
                return null;
            }
            String string = resourceLocatorPersistence.getUrl();
            int n = resourceLocatorPersistence.getIdentification();
            if (null == string && n <= -1 || null != string && string.length() == 0 && n <= -1) {
                return null;
            }
            return new ResourceLocator(n, string);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public RadioAmFmSettings getRadioAmFmSettings() {
        return this.radioAmFmSettings;
    }

    public void setRadioAmFmSettings(RadioAmFmSettings radioAmFmSettings) {
        this.radioAmFmSettings = radioAmFmSettings;
    }

    public AmFmPresetSettings getAmFmPresetSettings() {
        return this.amFmPresetSettings;
    }

    public void setAmFmPresetSettings(AmFmPresetSettings amFmPresetSettings) {
        this.amFmPresetSettings = amFmPresetSettings;
    }

    public AmFmFixedStationListPersistence getAmFmFixedStationListPersistence() {
        return this.amFmFixedStationListPersistence;
    }

    public void setAmFmFixedStationListPersistence(AmFmFixedStationListPersistence amFmFixedStationListPersistence) {
        this.amFmFixedStationListPersistence = amFmFixedStationListPersistence;
    }

    public AmFmPersistenceService getRadioPersistenceService() {
        return AmFmPersistenceServiceImpl.getInstance();
    }

    public DabPersistence getDabPersistence() {
        return this.dabPersistence;
    }

    public void setDabPersistence(DabPersistence dabPersistence) {
        this.dabPersistence = dabPersistence;
    }

    public SatPersistence getSatPersistence() {
        return this.satPersistence;
    }

    public void setSatPersistence(SatPersistence satPersistence) {
        this.satPersistence = satPersistence;
    }

    public boolean isProfileChangeStarted() {
        return this.profileChangeStarted;
    }

    public void setProfileChangeStarted(boolean bl) {
        this.profileChangeStarted = bl;
    }

    public DsiAwareProfileChangeListenerCallback getDsiAwareProfileChangeListenerCallback() {
        return this.dsiAwareProfileChangeListenerCallback;
    }

    public void setDsiAwareProfileChangeListenerCallback(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        this.dsiAwareProfileChangeListenerCallback = dsiAwareProfileChangeListenerCallback;
    }

    public void resetLoadedPersistenceAndAnswerCallBack() {
        ServiceManager.logger.info(128).append("AdapterAslPersistence - resetLoadedPersistenceAndAnswerCallBack() with RadioData.amFmTunerIsCompletlyInitialized - ").append(RadioData.amFmTunerIsCompletelyInitialized).append("isProfileChangeStarted() - ").append(this.isProfileChangeStarted()).log();
        if (null != this.getDsiAwareProfileChangeListenerCallback() && RadioData.amFmTunerIsCompletelyInitialized && this.isProfileChangeStarted()) {
            this.oldWaveBand = RadioCurrentWaveband.get();
            RadioDataApi.isDsiResponsePersistStationLogosSuccessful = false;
            RadioDataApi.presetsWereUpdatedAfterStartUpOrProfileChange = false;
            this.setRadioAmFmSettings(null);
            RadioData.getAmfmDatabase().getSettingsPersistable().setRadioAmFmSettings(null);
            this.setAmFmPresetSettings(null);
            this.setAmFmFixedStationListPersistence(null);
            this.setDabPersistence(null);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                this.setSatPersistence(null);
            }
            this.getDsiAwareProfileChangeListenerCallback().notifyTaskDone(true);
        }
    }
}

