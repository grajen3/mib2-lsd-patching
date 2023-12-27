/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionInfo;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.DSIRadioData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public final class DsiRadioDataAdapter {
    static final int STATION_LOGOS_MAX_ITEM_COUNT;
    public static final int DATABASEALTERATIONRESPONSE_DELETE_LOGO;

    public void requestRadioStationLogos(RadioStationDataRequest[] radioStationDataRequestArray, int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.info(128).append("DsiRadioDataAdapter - requestRadioStationLogos() ++start++, requestType: ").append(n).log();
            }
            if (RadioDataApi.isSouthSideStationLogoDbActive() && null != radioStationDataRequestArray && radioStationDataRequestArray.length > 0 && null != radioStationDataRequestArray[0]) {
                RadioStationLogoRequest[] radioStationLogoRequestArray = new RadioStationLogoRequest[radioStationDataRequestArray.length];
                for (int i2 = 0; i2 < radioStationDataRequestArray.length; ++i2) {
                    radioStationLogoRequestArray[i2] = new RadioStationLogoRequest(radioStationDataRequestArray[i2], this.getPresetStationLogoPriority());
                }
                RadioDataSessionInfo radioDataSessionInfo = new RadioDataSessionInfo();
                radioDataSessionInfo.setRequestType(n);
                radioDataSessionInfo.setRadioStationDataRequest(radioStationDataRequestArray);
                int n2 = RadioDataSessionManager.getInstance().getNewSessionId();
                RadioDataSessionManager.getInstance().setRadioDataSessionInfo(radioDataSessionInfo, n2);
                DSIRadioData dSIRadioData = RadioData.getAmfmDatabase().getDsiRadioData();
                if (null != dSIRadioData) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.info(128).append("sessionId: ").append(n2).log();
                        for (int i3 = 0; i3 < radioStationLogoRequestArray.length; ++i3) {
                            ServiceManager.logger.info(128).append(radioStationLogoRequestArray[i3].toString()).log();
                        }
                    }
                    dSIRadioData.requestRadioStationLogos(radioStationLogoRequestArray, n2);
                }
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.info(128).append("DsiRadioDataAdapter - requestRadioStationLogos() ++end++, requestType: ").append(n).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRadioStationData(RadioStationDataRequest[] radioStationDataRequestArray, int n) {
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive() && null != radioStationDataRequestArray && radioStationDataRequestArray.length > 0) {
                RadioDataSessionInfo radioDataSessionInfo = new RadioDataSessionInfo();
                radioDataSessionInfo.setRequestType(n);
                radioDataSessionInfo.setRadioStationDataRequest(radioStationDataRequestArray);
                int n2 = RadioDataSessionManager.getInstance().getNewSessionId();
                RadioDataSessionManager.getInstance().setRadioDataSessionInfo(radioDataSessionInfo, n2);
                DSIRadioData dSIRadioData = RadioData.getAmfmDatabase().getDsiRadioData();
                if (null != dSIRadioData) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.info(128).append("DsiRadioDataAdapter - requestRadioStationData() - sessionId: ").append(n2).append(", requestType: ").append(n).log();
                        for (int i2 = 0; i2 < radioStationDataRequestArray.length; ++i2) {
                            ServiceManager.logger.info(128).append(radioStationDataRequestArray[i2].toString()).log();
                        }
                    }
                    dSIRadioData.requestRadioStationData(radioStationDataRequestArray, n2);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestPersistStationLogos(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray) {
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive() && null != radioStationDataArray && null != resourceLocatorArray) {
                RadioDataSessionInfo radioDataSessionInfo = new RadioDataSessionInfo();
                radioDataSessionInfo.setRequestType(13);
                int n = RadioDataSessionManager.getInstance().getNewSessionId();
                RadioDataSessionManager.getInstance().setRadioDataSessionInfo(radioDataSessionInfo, n);
                boolean bl = true;
                DSIRadioData dSIRadioData = RadioData.getAmfmDatabase().getDsiRadioData();
                if (null != dSIRadioData) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.info(128).append("DsiRadioDataAdapter - requestPersistStationLogos() - sessionId: ").append(n).append(", requestType: ").append(1).log();
                        for (int i2 = 0; i2 < radioStationDataArray.length; ++i2) {
                            ServiceManager.logger.info(128).append(radioStationDataArray[i2].toString()).log();
                        }
                    }
                    RadioDataApi.setRequestPersistStationLogosInSouthSideDbCalledAfterStartUp(true);
                    dSIRadioData.requestPersistStationLogos(radioStationDataArray, resourceLocatorArray, 1, n);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestDatabaseVersionInfo() {
        try {
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                int n = RadioDataSessionManager.getInstance().getNewSessionId();
                DSIRadioData dSIRadioData = RadioData.getAmfmDatabase().getDsiRadioData();
                if (null != dSIRadioData) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.info(128).append("DsiRadioDataAdapter - requestDatabaseVersionInfo() - sessionId: ").append(n).log();
                    }
                    dSIRadioData.requestDatabaseVersionInfo(n);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRadioStationName() {
    }

    public void requestRadioStationSpeechData() {
    }

    public void requestRadioStationDataForEccCalculation() {
    }

    public void requestDynamicDbDeleteStation() {
    }

    public void requestDynamicDbDeleteLogo() {
    }

    public void requestDynamicDbDeleteLogoAndStation() {
    }

    public void requestDynamicDbAddStation() {
    }

    public void requestDynamicDbAddLogo() {
    }

    public void requestDynamicDbAddLogoAndStation() {
    }

    private int[] getPresetStationLogoPriority() {
        int[] nArray = new int[]{0, 1, 2};
        return nArray;
    }

    public void requestCountryRegionData() {
        try {
            DSIRadioData dSIRadioData = RadioData.getAmfmDatabase().getDsiRadioData();
            if (null != dSIRadioData) {
                int n = RadioDataSessionManager.getInstance().getNewSessionId();
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.info(128).append("DsiRadioDataAdapter - requestCountryRegionData() - sessionId: ").append(n).log();
                }
                RadioDataApi.setInitialDataAlreadyRequested(true);
                dSIRadioData.requestCountryRegionData(n);
            } else if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.info(128).append("DsiRadioDataAdapter - requestCountryRegionData() - dsiRadioData == null").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestCountryRegionTranslationData(String string, int n) {
        try {
            DSIRadioData dSIRadioData = RadioData.getAmfmDatabase().getDsiRadioData();
            if (null != dSIRadioData) {
                RadioDataSessionInfo radioDataSessionInfo = new RadioDataSessionInfo();
                radioDataSessionInfo.setRequestType(n);
                int n2 = RadioDataSessionManager.getInstance().getNewSessionId();
                RadioDataSessionManager.getInstance().setRadioDataSessionInfo(radioDataSessionInfo, n2);
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.info(128).append("DsiRadioDataAdapter - requestCountryRegionTranslationData() - sessionId: ").append(n2).append(", requestType: ").append(n).append(", guiLanguage: ").append(string).log();
                }
                int n3 = -1;
                dSIRadioData.requestCountryRegionTranslationData(-1, string, n2);
            } else if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.info(128).append("DsiRadioDataAdapter - requestCountryRegionTranslationData() - dsiRadioData == null").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

