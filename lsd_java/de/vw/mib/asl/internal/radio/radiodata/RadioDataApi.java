/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioAdaptationAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.presets.PresetManualPictureStore;
import de.vw.mib.asl.internal.radio.radiodata.CountryList;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.radiodata.StationLogoData;
import de.vw.mib.asl.internal.radio.radiodata.TargetRadioData;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public final class RadioDataApi {
    static boolean isPersistStationLogosInSouthSideDbUnlocked = true;
    private static boolean initialDataAlreadyRequested = false;
    public static final int INVALID_DATABASE_STATION_ID;
    public static final int INVALID_DATABASE_STATE;
    private static int dbState;
    private static int currentDatabaseVersionMajor;
    private static int currentDatabaseVersionMinor;
    private static int currentDatabaseVersionRevision;
    private static int currentDatabaseSuccessCode;
    private static boolean countryRegionTranslationDataRequested;
    private static boolean isRequestPersistStationLogosInSouthSideDbAfterStartUpCalled;
    public static boolean presetsWereUpdatedAfterStartUpOrProfileChange;
    public static boolean isDsiResponsePersistStationLogosSuccessful;

    private RadioDataApi() {
    }

    public static void setDbState(int n) {
        dbState = n;
    }

    public static int getDbState() {
        return dbState;
    }

    public static void initializeAfterStartUp() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - initializeAfterStartUp()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("RadioDataApi - initializeAfterStartUp() - isSouthSideStationLogoDbActive() == true").log();
                }
                AmFmFactory.getAslAmfmModelController().updateAutoStoreStationLogosFeatureAvailable(true);
                AmFmFactory.getAslAmfmModelController().updateHomeCountrySetupOptionVisible(true);
                int n = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
                RadioDataSessionManager.getInstance().countryList.updateHomeCountryNameInSetup(n);
            } else {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("RadioDataApi - initializeAfterStartUp() - isSouthSideStationLogoDbActive() == false").log();
                }
                AmFmFactory.getAslAmfmModelController().updateAutoStoreStationLogosFeatureAvailable(false);
                AmFmFactory.getAslAmfmModelController().updateHomeCountrySetupOptionVisible(false);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestFmRadioStationData(Station[] stationArray) {
        try {
            if (null == stationArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - requestFmRadioStationData() - null == stationList").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - requestFmRadioStationData()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive() && stationArray.length > 0) {
                RadioData.targetRadioData.retriggerOrStartTimer(-1719205632, (long)0, false);
                RadioDataSessionManager.getInstance().requestFmRadioStationData(stationArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestDabRadioStationData(ServiceInfo[] serviceInfoArray) {
        try {
            if (null == serviceInfoArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - requestDabRadioStationData() - null == serviceList").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - requestDabRadioStationData()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive() && null != serviceInfoArray && serviceInfoArray.length > 0) {
                RadioDataSessionManager.getInstance().requestDabRadioStationData(serviceInfoArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestDabEnsembleData(EnsembleInfo[] ensembleInfoArray) {
        try {
            if (null == ensembleInfoArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - requestDabEnsembleData() - null == ensembleList").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - requestDabEnsembleData()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive() && null != ensembleInfoArray && ensembleInfoArray.length > 0) {
                RadioDataSessionManager.getInstance().requestDabEnsembleData(ensembleInfoArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestRadioStationDataForTuningTheStation(int n, int n2) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - requestRadioStationDataForTuningTheStation()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && n > -1) {
                RadioDataSessionManager.getInstance().requestRadioStationDataForTuningTheStation(n, n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestRadioDabStationLogos(ServiceInfo[] serviceInfoArray, int n) {
        if (null == serviceInfoArray) {
            ServiceManager.logger.error(128).append("RadioDataApi - requestRadioDabStationLogos() - null == serviceInfo").log();
            return;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - requestRadioDabStationLogos() ++start++, requestType = ").append(n).log();
        }
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                RadioData.targetRadioData.retriggerOrStartTimer(-1652096768, (long)0, false);
                RadioDataSessionManager.getInstance().requestRadioDabStationLogos(serviceInfoArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static ResourceLocator requestRadioDabStationLogoFromHmiBuffer(ServiceInfo serviceInfo) {
        try {
            if (null == serviceInfo) {
                ServiceManager.logger.error(128).append("RadioDataApi - requestRadioDabStationLogoFromHmiBuffer() - null == serviceInfo").log();
                return null;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - requestRadioDabStationLogoFromHmiBuffer()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                StationLogoData stationLogoData = RadioDataSessionManager.getInstance().stationLogoBuffer.getDabStationLogo(serviceInfo);
                if (null != stationLogoData) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("requestRadioDabStationLogoFromHmiBuffer() - ").append(stationLogoData.getResourceLocator()).log();
                    }
                    return stationLogoData.getResourceLocator();
                }
                return null;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    public static StationLogoData requestRadioFmStationDataFromHmiBuffer(AmFmStation amFmStation, int n) {
        try {
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append("RadioDataApi - requestRadioFmStationLogoFromHmiBuffer() - null == fmStation").log();
                return null;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - requestRadioFmStationLogoFromHmiBuffer()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                return RadioDataSessionManager.getInstance().stationLogoBuffer.getFmStationData(amFmStation, n);
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static RadioStationLogoResponse requestRadioDabStationDataFromHmiBuffer(ServiceInfo serviceInfo) {
        if (null == serviceInfo) {
            ServiceManager.logger.error(128).append("RadioDataApi - requestRadioDabStationDataFromHmiBuffer() - null == serviceInfo").log();
            return null;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - requestRadioDabStationDataFromHmiBuffer(serviceInfo)").log();
        }
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive() && null != serviceInfo) {
                return RadioDataSessionManager.getInstance().stationLogoBuffer.getDabStationData(serviceInfo);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    public static RadioStationData requestRadioDabStationDataFromHmiBuffer(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - requestRadioDabStationDataFromHmiBuffer(databaseStationId) : ").append(n).log();
        }
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                return RadioDataSessionManager.getInstance().stationLogoBuffer.getDabStationData(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    public static RadioStationDataRequest requestRadioDabStationRequestDataFromHmiBuffer(int n) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.info(256).append("RadioDataApi - requestRadioDabStationDataFromHmiBuffer(databaseStationId) : ").append(n).log();
        }
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                return RadioDataSessionManager.getInstance().stationLogoBuffer.getDabRadioStationDataRequest(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    public static void requestRadioFmStationLogos(AmFmStation[] amFmStationArray, int n) {
        try {
            if (null == amFmStationArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - requestRadioFmStationLogos() - null == fmStations").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - requestRadioFmStationLogos() - requestType = ").append(n).log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                RadioDataSessionManager.getInstance().requestRadioFmStationLogos(amFmStationArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestRadioAmStationLogos(AmFmStation[] amFmStationArray, int n) {
        if (null == amFmStationArray) {
            ServiceManager.logger.error(128).append("RadioDataApi - requestRadioAmStationLogos() - null == amStations").log();
            return;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - requestRadioAmStationLogos()").log();
        }
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                RadioDataSessionManager.getInstance().requestRadioAmStationLogos(amFmStationArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestGenericRadioAmStationLogo() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - requestGenericRadioAmStationLogo()").log();
        }
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                RadioDataSessionManager.getInstance().requestGenericRadioAmStationLogo();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestGenericRadioFmStationLogo() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - requestGenericRadioFmStationLogo()").log();
        }
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                RadioDataSessionManager.getInstance().requestGenericRadioFmStationLogo();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestGenericRadioDabStationLogo() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - requestGenericRadioDabStationLogo()").log();
        }
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                RadioDataSessionManager.getInstance().requestGenericRadioDabStationLogo();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestPersistStationLogosInSouthSideDb() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - requestPersistStationLogosInSouthSideDb()").log();
        }
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive() && isPersistStationLogosInSouthSideDbUnlocked) {
                RadioDataSessionManager.getInstance().requestPersistStationLogos();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setPersistStationLogosInSouthSideDbUnlocked(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - setPersistStationLogosInSouthSideDbUnlocked()").log();
        }
        isPersistStationLogosInSouthSideDbUnlocked = bl;
    }

    public static void processDsiResponseRadioStationData(RadioStationDataResponse[] radioStationDataResponseArray, int n) {
        try {
            if (null == radioStationDataResponseArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - processDsiResponseRadioStationData() - null == radioStationDataResponse").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiResponseRadioStationData()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().processRadioStationDataResponse(radioStationDataResponseArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void calculateHomeCountry(Station[] stationArray) {
        try {
            if (null == stationArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - calculateHomeCountry() - null == stationList").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - calculateHomeCountry()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioDataSessionManager.getInstance().countryList.isAutomaticCountryCalculationInDbActivated(CountryList.PI_AUTO_MODE)) {
                RadioDataSessionManager.getInstance().homeCountryCalc.calculateHomeCountry(stationArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void processDsiResponseRadioStationLogosSouthSide(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        try {
            if (null == radioStationLogoResponseArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - processDsiResponseRadioStationLogosSouthSide() - null == stationLogosResponse").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiResponseRadioStationLogosSouthSide() - sessionId = ").append(n).log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoResponse.setStationLogosFromDatabaseSouthSide(radioStationLogoResponseArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void processDsiResponseDynamicDatabaseAlteration(int n, int n2) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiResponseDynamicDatabaseAlteration() - sessionId = ").append(n2).log();
            }
            if (!RadioDataApi.isSouthSideStationLogoDbActive()) return;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void processDsiResponseCountryRegionData(CountryRegionData[] countryRegionDataArray, int n) {
        try {
            if (null == countryRegionDataArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - processDsiResponseCountryRegionData() - null == countryRegionData").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiResponseCountryRegionData() - sessionId = ").append(n).log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().countryList.processCountryRegionDataResponse(countryRegionDataArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void processDsiRadioDataResponseCountryRegionTranslationData(CountryRegionTranslationData[] countryRegionTranslationDataArray, int n) {
        try {
            if (null == countryRegionTranslationDataArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - processDsiRadioDataResponseCountryRegionTranslationData() - null == countryRegionTranslationData").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiRadioDataResponseCountryRegionTranslationData() - sessionId = ").append(n).log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().countryList.processCountryRegionTranslationData(countryRegionTranslationDataArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void processDsiResponseDatabaseVersionInfo(int n, int n2, int n3, String string, int n4, int n5, int n6) {
        try {
            if (null == string) {
                string = "";
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiResponseDatabaseVersionInfo( ").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(string).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataApi.setCurrentDatabaseVersionMajor(n);
                RadioDataApi.setCurrentDatabaseVersionMinor(n2);
                RadioDataApi.setCurrentDatabaseVersionRevision(n3);
                RadioDataApi.setCurrentDatabaseSuccessCode(n5);
                RadioDataSessionManager.getInstance().processDatabaseVersionInfo(n, n2, n3, n5);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void processDsiUpdateDatabaseState(int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiUpdateDatabaseState( ").append(n).append(" )").log();
            }
            dbState = n;
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataApi.updatedPresetsAfterStartUpOrProfileChange();
                RadioDataSessionManager.getInstance().adapterDsiRadioData.requestDatabaseVersionInfo();
                AmFmFactory.getAslAmfmModelController().updateAutoStoreStationLogosFeatureAvailable(true);
                AmFmFactory.getAslAmfmModelController().updateHomeCountrySetupOptionVisible(true);
            } else {
                AmFmFactory.getAslAmfmModelController().updateAutoStoreStationLogosFeatureAvailable(false);
                AmFmFactory.getAslAmfmModelController().updateHomeCountrySetupOptionVisible(false);
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && !RadioDataApi.isInitialDataAlreadyRequested()) {
                RadioDataApi.requestCountryRegionData();
            }
            if (!RadioDataApi.isRequestPersistStationLogosInSouthSideDbCalledAfterStartUp()) {
                RadioDataApi.requestPersistStationLogosInSouthSideDb();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean isInitialDataAlreadyRequested() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - isInitialDataAlreadyRequested() - initialDataAlreadyRequested = ").append(initialDataAlreadyRequested).log();
        }
        return initialDataAlreadyRequested;
    }

    public static void setInitialDataAlreadyRequested(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataApi - setInitialDataAlreadyRequested( ").append(bl).append(" )").log();
        }
        initialDataAlreadyRequested = bl;
    }

    public static void processDsiResponsePersistStationLogos(int n, int n2) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiResponsePersistStationLogos( ").append(n).append(", ").append(n2).append(" )").log();
            }
            if (0 == n) {
                isDsiResponsePersistStationLogosSuccessful = true;
                RadioDataApi.updatedPresetsAfterStartUpOrProfileChange();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && 1 == n) {
                ServiceManager.logger.error(128, "DSI: REQUESTPERSISTSTALOGOS_REQUEST_FAILED");
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void processDsiUpdateRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray) {
        try {
            if (null == radioStationLogoResponseArray) {
                ServiceManager.logger.error(128).append("RadioDataApi - processDsiUpdateRadioStationLogos() - null == stationLogosResponse").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiUpdateRadioStationLogos()").log();
            }
            if (!RadioDataApi.isSouthSideStationLogoDbActive()) return;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static ResourceLocator getGenericAmLogoFromHmiLogoBuffer() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - getGenericAmLogoFromHmiLogoBuffer()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                return RadioDataSessionManager.getInstance().stationLogoBuffer.getGenericAmLogoResourceLocator();
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static ResourceLocator getGenericFmLogoFromHmiLogoBuffer() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - getGenericFmLogoFromHmiLogoBuffer()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                return RadioDataSessionManager.getInstance().stationLogoBuffer.getGenericFmLogoResourceLocator();
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static RadioStationData getFmStationDataFromHmiDataBuffer(AmFmStation amFmStation) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - getFmStationDataFromHmiDataBuffer()").log();
            }
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append("RadioDataApi - getFmStationDataFromHmiDataBuffer() - null == fmStation").log();
                return null;
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                return RadioDataSessionManager.getInstance().stationDataBuffer.getRadioStationData(amFmStation);
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static String getFmStationNameFromHmiDataBuffer(AmFmStation amFmStation) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - getFmStationNameFromHmiDataBuffer()").log();
            }
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append("RadioDataApi - getFmStationNameFromHmiDataBuffer() - null == fmStation").log();
                return "";
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                return RadioDataSessionManager.getInstance().stationDataBuffer.getRadioStationName(amFmStation);
            }
            return "";
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "";
        }
    }

    public static AmFmStation getFmStationDataFromHmiDataBuffer(int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - getFmStationDataFromHmiDataBuffer( ").append(n).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                return RadioDataSessionManager.getInstance().stationDataBuffer.getRadioStationData(n);
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static ResourceLocator getGenericDabLogoFromHmiLogoBuffer() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - getGenericDabLogoFromHmiLogoBuffer()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                return RadioDataSessionManager.getInstance().stationLogoBuffer.getGenericDabLogoResourceLocator();
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static void deleteHmiLogoBuffer() {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - deleteHmiLogoBuffer()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoBuffer.deleteHmiLogoBuffer();
                RadioDataSessionManager.getInstance().stationDataBuffer.createStationDataArray();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setUserSelectedHomeCountry(EventGeneric eventGeneric) {
        try {
            if (null == eventGeneric) {
                ServiceManager.logger.error(128).append("RadioDataApi - setUserSelectedHomeCountry() - null == genericEvent").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - setUserSelectedHomeCountry( ").append(eventGeneric.toString()).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().countryList.setUserSelectedHomeCountry(eventGeneric);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setUserSelectedStationLogoSouthSide(EventGeneric eventGeneric) {
        try {
            if (null == eventGeneric) {
                ServiceManager.logger.error(128).append("RadioDataApi - setUserSelectedStationLogoSouthSide() - null == genericEvent").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - setUserSelectedStationLogoSouthSide( ").append(eventGeneric.toString()).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoResponse.setUserSelectedStationLogoSouthSide(eventGeneric);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setAmStationLogoInHmiLogoBuffer(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        try {
            if (null == resourceLocator || null == amFmStation) {
                ServiceManager.logger.error(128).append("RadioDataApi - setAmStationLogoInHmiLogoBuffer() - null == resourceLocator || null == amFmStation").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - setAmStationLogoInHmiLogoBuffer( ").append(resourceLocator.toString()).append(", ").append(amFmStation.toString()).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoBuffer.setAmStationLogo(resourceLocator, amFmStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setFmStationLogoInHmiLogoBuffer(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        try {
            if (null == resourceLocator || null == amFmStation) {
                ServiceManager.logger.error(128).append("RadioDataApi - setFmStationLogoInHmiLogoBuffer() - null == resourceLocator || null == amFmStation").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - setFmStationLogoInHmiLogoBuffer( ").append(resourceLocator.toString()).append(", ").append(amFmStation.toString()).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoBuffer.setFmStationLogo(resourceLocator, amFmStation, false);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setDabStationLogoInHmiLogoBuffer(ResourceLocator resourceLocator, ServiceInfo serviceInfo) {
        try {
            if (null == resourceLocator || null == serviceInfo) {
                ServiceManager.logger.error(128).append("RadioDataApi - setDabStationLogoInHmiLogoBuffer() - null == resourceLocator || null == service").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - setDabStationLogoInHmiLogoBuffer( ").append(resourceLocator.toString()).append(", ").append(serviceInfo.toString()).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoBuffer.setDabStationLogo(resourceLocator, serviceInfo);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void deleteAmLogoFromHmiLogoBuffer(AmFmStation amFmStation) {
        try {
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append("RadioDataApi - deleteAmLogoFromHmiLogoBuffer() - null == amFmStation").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - deleteAmLogoFromHmiLogoBuffer( ").append(amFmStation.toString()).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoBuffer.deleteAmStationLogo(amFmStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void deleteFmLogoFromHmiLogoBuffer(AmFmStation amFmStation) {
        try {
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append("RadioDataApi - deleteFmLogoFromHmiLogoBuffer() - null == amFmStation").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - deleteFmLogoFromHmiLogoBuffer( ").append(amFmStation.toString()).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoBuffer.deleteFmStationLogo(amFmStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void deleteDabLogoFromHmiLogoBuffer(ServiceInfo serviceInfo) {
        try {
            if (null == serviceInfo) {
                ServiceManager.logger.error(128).append("RadioDataApi - deleteDabLogoFromHmiLogoBuffer() - null == serviceInfo").log();
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - deleteDabLogoFromHmiLogoBuffer( ").append(serviceInfo.toString()).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoBuffer.deleteDabStationLogo(serviceInfo);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void generateCountryList() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - generateCountryList()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().countryList.generateCountryList();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setHomeCountryAutoSelectionActive() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - setHomeCountryAutoSelectionActive()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("RadioDataApi - setHomeCountryAutoSelectionActive() - call: countryList.setHomeCountryAutoSelectionActive()").log();
                }
                RadioDataSessionManager.getInstance().countryList.setHomeCountryAutoSelectionActive();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestCountryRegionData() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - requestCountryRegionData()").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("RadioDataApi - requestCountryRegionData() - call: adapterDsiRadioData.requestCountryRegionData()").log();
                }
                RadioDataSessionManager.getInstance().adapterDsiRadioData.requestCountryRegionData();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestCountryRegionTranslationData(String string) {
        try {
            RadioDataApi.setCountryRegionTranslationDataRequested(true);
            if (null == string || string.equals("NO_LANGUAGE")) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("RadioDataApi - requestCountryRegionTranslationData() - null == guiLanguage || guiLanguage.equals( LscData.NO_LANGUAGE )").log();
                }
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("requestCountryRegionTranslationData( ").append(string).append(" )").log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && !RadioDataSessionManager.getInstance().countryList.isCountryRegionTranslationAvailable(string)) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("RadioDataApi - requestCountryRegionTranslationData() - call: adapterDsiRadioData.requestCountryRegionTranslationData()").log();
                }
                RadioDataSessionManager.getInstance().adapterDsiRadioData.requestCountryRegionTranslationData(string, 17);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static int getCurrentDatabaseVersionMajor() {
        return currentDatabaseVersionMajor;
    }

    public static void setCurrentDatabaseVersionMajor(int n) {
        currentDatabaseVersionMajor = n;
    }

    public static int getCurrentDatabaseVersionMinor() {
        return currentDatabaseVersionMinor;
    }

    public static void setCurrentDatabaseVersionMinor(int n) {
        currentDatabaseVersionMinor = n;
    }

    public static int getCurrentDatabaseVersionRevision() {
        return currentDatabaseVersionRevision;
    }

    public static void setCurrentDatabaseVersionRevision(int n) {
        currentDatabaseVersionRevision = n;
    }

    public static int getCurrentDatabaseSuccessCode() {
        return currentDatabaseSuccessCode;
    }

    public static void setCurrentDatabaseSuccessCode(int n) {
        currentDatabaseSuccessCode = n;
    }

    public static boolean isCountryRegionTranslationDataRequested() {
        return countryRegionTranslationDataRequested;
    }

    public static void setCountryRegionTranslationDataRequested(boolean bl) {
        countryRegionTranslationDataRequested = bl;
    }

    public static boolean isRequestPersistStationLogosInSouthSideDbCalledAfterStartUp() {
        return isRequestPersistStationLogosInSouthSideDbAfterStartUpCalled;
    }

    public static void setRequestPersistStationLogosInSouthSideDbCalledAfterStartUp(boolean bl) {
        isRequestPersistStationLogosInSouthSideDbAfterStartUpCalled = bl;
    }

    public static void processDsiUpdatePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - processDsiUpdatePersistStationLogosWithChangedUrls()").log();
            }
            if (0 == n) {
                isDsiResponsePersistStationLogosSuccessful = true;
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                RadioDataSessionManager.getInstance().stationLogoResponse.updateStationLogosFromDatabase(radioStationDataArray, resourceLocatorArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void updatedPresetsAfterStartUpOrProfileChange() {
        try {
            if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2) && !presetsWereUpdatedAfterStartUpOrProfileChange && RadioDataApi.isDrawStationLogoActivated()) {
                presetsWereUpdatedAfterStartUpOrProfileChange = true;
                AmFmPresetApi.updateGuiList(RadioCurrentWaveband.get());
                GuiApiDab.updatePresetList();
                RadioData.targetRadioData.stopTimer(-1484324608);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean isDrawStationLogoActivated() {
        boolean bl = false;
        try {
            int n;
            bl = ServiceManager.configManagerDiag.isFeatureFlagSet(2) ? true : ((n = RadioAdaptationAdapter.getStationLogoDbMode()) > 0 ? RadioDataApi.isSouthSideStationLogoDbActive() && TargetRadioData.isDsiConnectionAfterStartUpInitialized && dbState != -1 && isDsiResponsePersistStationLogosSuccessful && PresetManualPictureStore.isPictureStoreTargetAvailable() : PresetManualPictureStore.isPictureStoreTargetAvailable());
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataApi - isDrawStationLogoActivated() = ").append(bl).log();
            }
            return bl;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return bl;
        }
    }

    public static boolean isSouthSideStationLogoDbActive() {
        try {
            boolean bl;
            int n = RadioAdaptationAdapter.getStationLogoDbMode();
            boolean bl2 = bl = TargetRadioData.powerOnAlreadyReceived && n > 0 && dbState != 0 && dbState != 1;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("isSouthSideStationLogoDbActive() - powerOnAlreadyReceived = ").append(TargetRadioData.powerOnAlreadyReceived).append(" and stationLogoDbMode = ").append(n).append(new StringBuffer().append(" and dbState = ").append(dbState).toString()).append(", isDatabaseActive = ").append(bl).log();
            }
            return bl;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    static {
        dbState = -1;
        currentDatabaseVersionMajor = -1;
        currentDatabaseVersionMinor = -1;
        currentDatabaseVersionRevision = -1;
        currentDatabaseSuccessCode = -1;
        countryRegionTranslationDataRequested = false;
        isRequestPersistStationLogosInSouthSideDbAfterStartUpCalled = false;
        presetsWereUpdatedAfterStartUpOrProfileChange = false;
        isDsiResponsePersistStationLogosSuccessful = false;
    }
}

