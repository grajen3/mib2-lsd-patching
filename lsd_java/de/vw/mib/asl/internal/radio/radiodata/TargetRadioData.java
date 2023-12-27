/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.presets.PresetManualPictureStore;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.DSIRadioData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public final class TargetRadioData
extends AbstractTarget {
    public static boolean powerOnAlreadyReceived = false;
    static boolean isDsiConnectionAfterStartUpInitialized = false;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$DSIRadioData;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$DSIRadioDataListener;

    public TargetRadioData(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        RadioData.targetRadioData = this;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("TargetRadioData received POWER_ON, powerOnAlreadyReceived = ").append(powerOnAlreadyReceived).log();
                }
                if (powerOnAlreadyReceived) break;
                powerOnAlreadyReceived = true;
                TargetRadioData.initializeDsiConnectionAfterStartUp();
                this.retriggerOrStartTimer(-1484324608, (long)0, false);
                break;
            }
            case 100249: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("TargetRadioData received the timeout event EV_DB_FEEDBACK_WAITING_TIMER so updating the existing ids from the hmi buffer to speech").log();
                }
                RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateFmListToSpeech(RadioData.getAmfmDatabase().getAslStationListFM().getListCopyAsArray());
                break;
            }
            case 100263: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("TargetRadioData received the timeout event EV_TIMER_DSI_RESPONSE_PERSIST_STATION_LOGOS_AND_PICTURESTORE_TARGET_AVAILABILITY").log();
                }
                RadioDataApi.isDsiResponsePersistStationLogosSuccessful = true;
                RadioDataApi.updatedPresetsAfterStartUpOrProfileChange();
                if (PresetManualPictureStore.isPictureStoreTargetAvailable()) break;
                PresetManualPictureStore.setPictureStoreTargetAvailable(true);
                break;
            }
            case 100253: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_RADIODATA).append("TargetRadioData received the timeout event EV_DB_DABSERVICELIST_DATA_WAITING_TIMER so updating the existing ids from the hmi buffer to speech").log();
                }
                RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateDabServiceListToSpeech();
                break;
            }
        }
    }

    @Override
    public int getDefaultTargetId() {
        return ASLRadioTargetIds.ASL_RADIO_DATA_TARGET;
    }

    public static void initializeDsiConnectionAfterStartUp() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("TargetRadioData - initializeDsiConnectionAfterStartUp()").log();
            }
            if (!isDsiConnectionAfterStartUpInitialized && powerOnAlreadyReceived && RadioData.amFmTunerIsInitialized && null != RadioData.targetRadioData) {
                isDsiConnectionAfterStartUpInitialized = true;
                if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("initializeDsiConnectionAfterStartUp() - isSouthSideStationLogoDbActive() == true").log();
                    }
                    RadioDataApi.setDbState(1);
                    DSIRadioData dSIRadioData = (DSIRadioData)ServiceManager.dsiServiceLocator.getService(RadioData.targetRadioData, class$org$dsi$ifc$radiodata$DSIRadioData == null ? (class$org$dsi$ifc$radiodata$DSIRadioData = TargetRadioData.class$("org.dsi.ifc.radiodata.DSIRadioData")) : class$org$dsi$ifc$radiodata$DSIRadioData);
                    if (null != dSIRadioData) {
                        if (ServiceManager.logger.isTraceEnabled(128)) {
                            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("initializeDsiConnectionAfterStartUp() - null != dsiRadioData").log();
                        }
                        RadioData.getAmfmDatabase().setDsiRadioData(dSIRadioData);
                        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(RadioData.targetRadioData, class$org$dsi$ifc$radiodata$DSIRadioDataListener == null ? (class$org$dsi$ifc$radiodata$DSIRadioDataListener = TargetRadioData.class$("org.dsi.ifc.radiodata.DSIRadioDataListener")) : class$org$dsi$ifc$radiodata$DSIRadioDataListener);
                        ServiceManager.dsiServiceLocator.addResponseListener(RadioData.targetRadioData, class$org$dsi$ifc$radiodata$DSIRadioDataListener == null ? (class$org$dsi$ifc$radiodata$DSIRadioDataListener = TargetRadioData.class$("org.dsi.ifc.radiodata.DSIRadioDataListener")) : class$org$dsi$ifc$radiodata$DSIRadioDataListener, dSIListener);
                        RadioData.getAmfmDatabase().getDsiRadioData().setNotification(1, dSIListener);
                        RadioData.getAmfmDatabase().getDsiRadioData().setNotification(4, dSIListener);
                        if (!RadioDataApi.isRequestPersistStationLogosInSouthSideDbCalledAfterStartUp()) {
                            RadioDataApi.requestPersistStationLogosInSouthSideDb();
                        }
                    }
                }
                RadioDataApi.updatedPresetsAfterStartUpOrProfileChange();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataResponseRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        try {
            RadioDataApi.processDsiResponseRadioStationLogosSouthSide(radioStationLogoResponseArray, n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataResponseRadioStationData(RadioStationDataResponse[] radioStationDataResponseArray, int n) {
        try {
            RadioDataApi.processDsiResponseRadioStationData(radioStationDataResponseArray, n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataResponsePersistStationLogos(int n, int n2) {
        try {
            RadioDataApi.processDsiResponsePersistStationLogos(n, n2);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataResponseDynamicDatabaseAlteration(int n, int n2) {
        try {
            RadioDataApi.processDsiResponseDynamicDatabaseAlteration(n, n2);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataResponseDatabaseVersionInfo(int n, int n2, int n3, String string, int n4, int n5, int n6) {
        try {
            RadioDataApi.processDsiResponseDatabaseVersionInfo(n, n2, n3, string, n4, n5, n6);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataUpdateDatabaseState(int n, int n2) {
        try {
            if (1 == n2) {
                RadioDataApi.processDsiUpdateDatabaseState(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataUpdateRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        try {
            if (1 == n) {
                RadioDataApi.processDsiUpdateRadioStationLogos(radioStationLogoResponseArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataResponseCountryRegionData(CountryRegionData[] countryRegionDataArray, int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("TargetRadioData - dsiRadioDataResponseCountryRegionData() - sessionId = ").append(n).log();
            }
            RadioDataApi.processDsiResponseCountryRegionData(countryRegionDataArray, n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataResponseCountryRegionTranslationData(CountryRegionTranslationData[] countryRegionTranslationDataArray, int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("TargetRadioData - dsiRadioDataResponseCountryRegionTranslationData() - sessionId = ").append(n).log();
            }
            RadioDataApi.processDsiRadioDataResponseCountryRegionTranslationData(countryRegionTranslationDataArray, n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataUpdatePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        try {
            if (1 == n2 && n == 0) {
                RadioDataApi.processDsiUpdatePersistStationLogosWithChangedUrls(radioStationDataArray, resourceLocatorArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void dsiRadioDataResponsePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        try {
            if (n == 0) {
                RadioDataApi.processDsiUpdatePersistStationLogosWithChangedUrls(radioStationDataArray, resourceLocatorArray, n);
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

