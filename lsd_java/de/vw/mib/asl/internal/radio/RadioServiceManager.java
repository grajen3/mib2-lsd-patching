/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.AdapterAslPersistence;
import de.vw.mib.asl.internal.radio.AdapterAslSpeech;
import de.vw.mib.asl.internal.radio.GuiBapApi;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmNavigationService;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.api.impl.speech.RadioSpeechEngineAdapter;
import de.vw.mib.asl.internal.radio.dab.DabEnsembleServiceComponentFrequecyChecker;
import de.vw.mib.asl.internal.radio.dab.DabServiceComparator;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.tile.RadioTileEventHandling;
import de.vw.mib.asl.internal.radio.tile.gui.ApiGuiRadioTiles;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.sdars.StationInfo;

public final class RadioServiceManager {
    private static RadioServiceManager serviceManager = null;
    private final AdapterAslPersistence adapterAslPersistence;
    private final AdapterAslSpeech adapterAslSpeech;
    private final RadioSpeechEngineAdapter radioSpeechEngineAdapter;
    private de.vw.mib.asl.internal.radio.amfm.main.HsmTarget amFmTarget = null;
    private HsmState unifiedRadioStateTopMain = null;
    private HsmState stateActiveUnifiedRadio = null;
    private HsmTarget dabTarget = null;
    DabEnsembleServiceComponentFrequecyChecker dabEnsembleServiceComponentFrequecyChecker = null;
    private GuiBapApi guiBapApi = null;
    private boolean isFactoryResetInProgress = false;
    private boolean scanIsActive = false;
    private boolean seekIsActive = false;
    private AmFmNavigationService amFmNavigationService;
    private NavigationTrafficService navigationTrafficService;
    private TileStationList tileStationList;
    private RadioTileEventHandling radioTileEventHandling;
    private ApiGuiRadioTiles apiGuiRadioTiles;
    private HsmDabDsi hsmDabDsi;
    private DabServiceComparator tileServiceComparator;
    private boolean defaultAmFmFreqYetToTune = false;
    private boolean defaultSdarsFreqYetToTune = false;
    private HdStationInfo taggingHdStationInfo = new HdStationInfo();
    private StationInfo taggingSatChannel = new StationInfo();
    private boolean tileLCioIntentRegistrationFinished = false;
    private boolean isRadioTileLNextWavebandInitialized = false;

    private RadioServiceManager() {
        this.setAmFmNavigationService(new AmFmNavigationService());
        this.navigationTrafficService = null;
        this.adapterAslPersistence = new AdapterAslPersistence();
        this.isFactoryResetInProgress = false;
        this.dabEnsembleServiceComponentFrequecyChecker = new DabEnsembleServiceComponentFrequecyChecker();
        this.guiBapApi = new GuiBapApi();
        this.adapterAslSpeech = new AdapterAslSpeech();
        this.radioSpeechEngineAdapter = new RadioSpeechEngineAdapter();
    }

    public static RadioServiceManager getServiceManager() {
        if (serviceManager == null) {
            serviceManager = new RadioServiceManager();
        }
        return serviceManager;
    }

    public AdapterAslPersistence getAdapterAslPersistence() {
        return this.adapterAslPersistence;
    }

    public AdapterAslSpeech getAdapterAslSpeech() {
        return this.adapterAslSpeech;
    }

    public DabEnsembleServiceComponentFrequecyChecker getDabEnsembleServiceComponentFrequecyChecker() {
        return this.dabEnsembleServiceComponentFrequecyChecker;
    }

    public void setRadioAmFMTarget(de.vw.mib.asl.internal.radio.amfm.main.HsmTarget hsmTarget) {
        this.amFmTarget = hsmTarget;
    }

    public de.vw.mib.asl.internal.radio.amfm.main.HsmTarget getRadioAmFMTarget() {
        return this.amFmTarget;
    }

    public void setRadioDabTarget(HsmTarget hsmTarget) {
        this.dabTarget = hsmTarget;
    }

    public HsmTarget getRadioDabTarget() {
        return this.dabTarget;
    }

    public boolean isFactoryResetInProgress() {
        return this.isFactoryResetInProgress;
    }

    public void setFactoryResetInProgress(boolean bl) {
        this.isFactoryResetInProgress = bl;
    }

    public GuiBapApi getGuiBapApi() {
        return this.guiBapApi;
    }

    public AmFmNavigationService getAmFmNavigationService() {
        return this.amFmNavigationService;
    }

    public void setAmFmNavigationService(AmFmNavigationService amFmNavigationService) {
        this.amFmNavigationService = amFmNavigationService;
    }

    public NavigationTrafficService getNavigationTrafficService() {
        try {
            if (null == this.navigationTrafficService) {
                this.navigationTrafficService = ASLNavigationFactory.getNavigationApi().getNavigationTrafficService(this.amFmNavigationService);
            }
            return this.navigationTrafficService;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void setUnifiedRadioStateTopMain(HsmState hsmState) {
        this.unifiedRadioStateTopMain = hsmState;
    }

    public HsmState getUnifiedRadioStateTopMain() {
        return this.unifiedRadioStateTopMain;
    }

    public TileStationList getTileStationList() {
        if (null == this.tileStationList) {
            this.tileStationList = new TileStationList();
        }
        return this.tileStationList;
    }

    public RadioTileEventHandling getRadioTileEventHandling() {
        if (null == this.radioTileEventHandling) {
            this.radioTileEventHandling = new RadioTileEventHandling();
        }
        return this.radioTileEventHandling;
    }

    public ApiGuiRadioTiles getApiGuiRadioTiles() {
        if (null == this.apiGuiRadioTiles) {
            this.apiGuiRadioTiles = new ApiGuiRadioTiles();
        }
        return this.apiGuiRadioTiles;
    }

    public DabServiceComparator getTileServiceComparator() {
        if (null == this.tileServiceComparator) {
            this.tileServiceComparator = new DabServiceComparator(null, 1);
        }
        return this.tileServiceComparator;
    }

    public HsmDabDsi getHsmDabDsi() {
        return this.hsmDabDsi;
    }

    public void setHsmDabDsi(HsmDabDsi hsmDabDsi) {
        this.hsmDabDsi = hsmDabDsi;
    }

    public HsmState getStateActiveUnifiedRadio() {
        return this.stateActiveUnifiedRadio;
    }

    public void setStateActiveUnifiedRadio(HsmState hsmState) {
        this.stateActiveUnifiedRadio = hsmState;
    }

    public boolean isScanIsActive() {
        return this.scanIsActive;
    }

    public void setScanIsActive(boolean bl) {
        this.scanIsActive = bl;
    }

    public boolean isSeekIsActive() {
        return this.seekIsActive;
    }

    public void setSeekIsActive(boolean bl) {
        this.seekIsActive = bl;
    }

    public boolean isAmFmDeafultFreqYetTobeTuned() {
        return this.defaultAmFmFreqYetToTune;
    }

    public void setAmFmDefaultOrLsmFreqYetTobeTuned(boolean bl) {
        this.defaultAmFmFreqYetToTune = bl;
    }

    public boolean isAmFmStationOverridenNotAllowed() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("isStationOverridenNotAllowed() ").append("profileInProgress - ").append(this.getAdapterAslPersistence().isProfileChangeStarted()).append("isAmFmDeafultFreqYetTobeTuned - ").append(this.isAmFmDeafultFreqYetTobeTuned()).log();
        }
        return this.getAdapterAslPersistence().isProfileChangeStarted() || this.isAmFmDeafultFreqYetTobeTuned();
    }

    public boolean isSdarsDeafultFreqYetTobeTuned() {
        return this.defaultSdarsFreqYetToTune;
    }

    public void setSdarsDefaultOrLsmFreqYetTobeTuned(boolean bl) {
        this.defaultSdarsFreqYetToTune = bl;
    }

    public boolean isSdarsStationOverridenNotAllowed() {
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512).append("isStationOverridenNotAllowed() ").append("profileInProgress - ").append(this.getAdapterAslPersistence().isProfileChangeStarted()).append("isSdarsDeafultFreqYetTobeTuned - ").append(this.isSdarsDeafultFreqYetTobeTuned()).log();
        }
        return this.getAdapterAslPersistence().isProfileChangeStarted() || this.isSdarsDeafultFreqYetTobeTuned();
    }

    public void setTaggingFMHDStationInfo(HdStationInfo hdStationInfo) {
        this.taggingHdStationInfo = hdStationInfo;
    }

    public HdStationInfo getTaggingStationInfo() {
        return this.taggingHdStationInfo;
    }

    public void setTaggingSatChannel(StationInfo stationInfo) {
        this.taggingSatChannel = stationInfo;
    }

    public StationInfo getTaggingSatChannel() {
        return this.taggingSatChannel;
    }

    public String getCorrectFmStationName(AmFmStation amFmStation) {
        try {
            Object object;
            if (null == amFmStation) {
                return "";
            }
            Object object2 = null;
            String string = RadioData.getAmfmDatabase().getFixedStationList().getName(amFmStation.getPi(), amFmStation.getFrequency());
            if (AmfmRDSOption.get() && string != null) {
                object2 = string;
            }
            if ((null == object2 || ((String)object2).length() < 1) && RadioDataSessionManager.getInstance().countryList.isDatabaseNameActivatedForMainView() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive() && amFmStation.getName().length() < 1 && !amFmStation.isScrollingPS()) {
                object = RadioDataApi.getFmStationNameFromHmiDataBuffer(amFmStation);
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("RadioServiceManager - getCorrectFmStationName() - ").append("stationNameDb: ").append((String)object).log();
                }
                if (null != object && ((String)object).length() > 0) {
                    object2 = object;
                }
            }
            if ((null == object2 || ((String)object2).length() < 1) && amFmStation.getName().length() < 1 && ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != (object = RadioData.getAmfmDatabase().getStationNameFreqList())) {
                object2 = ((StationNameFreqList)object).getStationName(amFmStation.getFrequency());
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("RadioServiceManager - getCorrectFmStationName() - ").append("Name from NAV database: ").append((String)object2).log();
                }
            }
            if (object2 == null && amFmStation.getStationName() != null) {
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
            return object2;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "";
        }
    }

    public void setRadioTileLCioIntentRegistrationFinished(boolean bl) {
        this.tileLCioIntentRegistrationFinished = bl;
    }

    public boolean isRadioTileLCioIntentRegistrationFinished() {
        return this.tileLCioIntentRegistrationFinished;
    }

    public void setRadioTileLNextWavebandInitializedAfterStartup(boolean bl) {
        this.isRadioTileLNextWavebandInitialized = bl;
    }

    public boolean isRadioTileLNextWavebandInitializedAfterStartup() {
        return this.isRadioTileLNextWavebandInitialized;
    }
}

