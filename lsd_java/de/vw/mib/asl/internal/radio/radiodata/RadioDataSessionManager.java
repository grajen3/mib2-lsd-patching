/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActive;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetList;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetApi;
import de.vw.mib.asl.internal.radio.radiodata.AdapterRadioStationDataRequest;
import de.vw.mib.asl.internal.radio.radiodata.CountryCalculation;
import de.vw.mib.asl.internal.radio.radiodata.CountryList;
import de.vw.mib.asl.internal.radio.radiodata.DsiRadioDataAdapter;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataManager;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionInfo;
import de.vw.mib.asl.internal.radio.radiodata.StationDataBuffer;
import de.vw.mib.asl.internal.radio.radiodata.StationLogoBuffer;
import de.vw.mib.asl.internal.radio.radiodata.StationLogoProcessRequest;
import de.vw.mib.asl.internal.radio.radiodata.StationLogoProcessResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationDataResponse;

public final class RadioDataSessionManager {
    public static final int ARRAY_LENGTH_SESSION_INFO;
    private int sessionId = -1;
    private RadioDataSessionInfo[] radioDataSessionInfos = new RadioDataSessionInfo[50];
    private static RadioDataSessionManager radioDataSessionManager;
    public CountryCalculation homeCountryCalc = new CountryCalculation();
    RadioDataManager radioDataManager = new RadioDataManager();
    public DsiRadioDataAdapter adapterDsiRadioData = new DsiRadioDataAdapter();
    StationLogoBuffer stationLogoBuffer = new StationLogoBuffer();
    StationDataBuffer stationDataBuffer = new StationDataBuffer();
    public StationLogoProcessResponse stationLogoResponse = new StationLogoProcessResponse(this);
    StationLogoProcessRequest stationLogoRequest = new StationLogoProcessRequest(this);
    public CountryList countryList = new CountryList();
    HashSet databaseSpeechSetFm = null;
    HashSet databaseSpeechSetDabServices = null;

    private RadioDataSessionManager() {
    }

    public static RadioDataSessionManager getInstance() {
        if (null == radioDataSessionManager) {
            radioDataSessionManager = new RadioDataSessionManager();
        }
        return radioDataSessionManager;
    }

    public int getNewSessionId() {
        ++this.sessionId;
        if (this.sessionId >= 50 || this.sessionId < 0) {
            this.sessionId = 0;
        }
        return this.sessionId;
    }

    public void setRadioDataSessionInfo(RadioDataSessionInfo radioDataSessionInfo, int n) {
        if (n >= 0 && n < 50) {
            this.radioDataSessionInfos[n] = radioDataSessionInfo;
        }
    }

    public RadioDataSessionInfo getRadioDataSessionInfo(int n) {
        if (n >= 0 && n < 50) {
            return this.radioDataSessionInfos[n];
        }
        return null;
    }

    public void processRadioStationDataResponse(RadioStationDataResponse[] radioStationDataResponseArray, int n) {
        try {
            RadioDataSessionInfo radioDataSessionInfo;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataSessionManager processRadioStationDataResponse() - START").log();
            }
            if (null == (radioDataSessionInfo = this.getRadioDataSessionInfo(n))) {
                ServiceManager.logger.error(128).append("RadioDataSessionManager - processRadioStationDataResponse() - null == radioDataSessionInfo").log();
                return;
            }
            if (radioDataSessionInfo.getRequestType() == 11) {
                this.tuneFmStation(radioStationDataResponseArray);
            } else if (radioDataSessionInfo.getRequestType() == 12) {
                this.tuneDabService(radioStationDataResponseArray);
            } else if (radioDataSessionInfo.getRequestType() == 16) {
                this.tuneDabEnsemble(radioStationDataResponseArray);
            } else if (radioDataSessionInfo.getRequestType() == 9) {
                RadioData.targetRadioData.stopTimer(-1719205632);
                this.compressFmRadioStationDataResponse(radioStationDataResponseArray, radioDataSessionInfo);
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("After compressFmRadioStationDataResponse():").log();
                    this.traceRadioStationDataResponse(radioStationDataResponseArray);
                }
                this.stationDataBuffer.setRadioStationData(radioStationDataResponseArray, radioDataSessionInfo);
                if (null != AmFmStationListFM.currentFmStationList) {
                    RadioDataApi.calculateHomeCountry(AmFmStationListFM.currentFmStationList);
                }
                RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateFmListToSpeech(RadioData.getAmfmDatabase().getAslStationListFM().getListCopyAsArray());
            } else if (radioDataSessionInfo.getRequestType() == 10 || radioDataSessionInfo.getRequestType() == 15) {
                // empty if block
            }
            radioDataSessionInfo = null;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("RadioDataSessionManager - processRadioStationDataResponse() - END").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestFmRadioStationData(Station[] stationArray) {
        try {
            RadioStationDataRequest[] radioStationDataRequestArray = this.radioDataManager.createRequestFmStationList(stationArray);
            this.adapterDsiRadioData.requestRadioStationData(radioStationDataRequestArray, 9);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestDabRadioStationData(ServiceInfo[] serviceInfoArray) {
        try {
            RadioStationDataRequest[] radioStationDataRequestArray = this.radioDataManager.createRequestDabStationList(serviceInfoArray);
            this.adapterDsiRadioData.requestRadioStationData(radioStationDataRequestArray, 10);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestDabEnsembleData(EnsembleInfo[] ensembleInfoArray) {
        try {
            RadioStationDataRequest[] radioStationDataRequestArray = this.radioDataManager.createRequestDabEnsembleData(ensembleInfoArray);
            this.adapterDsiRadioData.requestRadioStationData(radioStationDataRequestArray, 15);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRadioStationDataForTuningTheStation(int n, int n2) {
        try {
            if (n > -1) {
                RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
                AdapterRadioStationDataRequest.setStationId(radioStationDataRequest, n);
                radioStationDataRequest.maxItemCount = 1;
                RadioStationDataRequest[] radioStationDataRequestArray = new RadioStationDataRequest[]{radioStationDataRequest};
                this.adapterDsiRadioData.requestRadioStationData(radioStationDataRequestArray, n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRadioDabStationLogos(ServiceInfo[] serviceInfoArray, int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("requestRadioDabStationLogos() ++start++, requestType = ").append(n).log();
            }
            this.stationLogoRequest.requestRadioDabStationLogos(serviceInfoArray, n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRadioFmStationLogos(AmFmStation[] amFmStationArray, int n) {
        int n2;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("RadioDataSessionManager - requestRadioFmStationLogos() - requestType = ").append(n).log();
            for (n2 = 0; n2 < amFmStationArray.length; ++n2) {
                if (null == amFmStationArray[n2]) continue;
                ServiceManager.logger.trace(128).append(amFmStationArray[n2].toString()).log();
            }
        }
        n2 = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
        int n3 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(n2);
        if (n2 > 1) {
            if (-1 == n3) {
                ServiceManager.logger.error(128).append("RadioDataSessionManager - requestRadioFmStationLogos() - Request strategy is invalid: ").append(n3).log();
            } else if (2 == n3) {
                this.stationLogoRequest.requestRadioFmStationLogos(amFmStationArray, n);
            } else {
                this.stationLogoRequest.requestRadioFmStationLogosForAllNeighboringCountries(amFmStationArray, n);
            }
        }
    }

    public void requestRadioAmStationLogos(AmFmStation[] amFmStationArray, int n) {
        this.stationLogoRequest.requestRadioAmStationLogos(amFmStationArray, n);
    }

    public void requestGenericRadioFmStationLogo() {
        this.stationLogoRequest.requestGenericRadioFmStationLogo();
    }

    public void requestGenericRadioDabStationLogo() {
        this.stationLogoRequest.requestGenericRadioDabStationLogo();
    }

    public void requestGenericRadioAmStationLogo() {
        this.stationLogoRequest.requestGenericRadioAmStationLogo();
    }

    public void requestPersistStationLogos() {
        try {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            this.addStationLogosAmFm(0, linkedList, linkedList2);
            this.addStationLogosAmFm(1, linkedList, linkedList2);
            this.addStationLogosDab(linkedList, linkedList2);
            Object[] objectArray = new RadioStationData[linkedList.size()];
            objectArray = (RadioStationData[])linkedList.toArray(objectArray);
            Object[] objectArray2 = new ResourceLocator[linkedList2.size()];
            objectArray2 = (ResourceLocator[])linkedList2.toArray(objectArray2);
            this.adapterDsiRadioData.requestPersistStationLogos((RadioStationData[])objectArray, (ResourceLocator[])objectArray2);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void addStationLogosAmFm(int n, List list, List list2) {
        try {
            AmFmPresetList amFmPresetList = AmFmPresetApi.getList(n);
            if (amFmPresetList == null) {
                return;
            }
            AmFmPreset[] amFmPresetArray = amFmPresetList.getPresets();
            if (amFmPresetArray == null) {
                return;
            }
            for (int i2 = 0; i2 < amFmPresetArray.length; ++i2) {
                if (null == amFmPresetArray[i2] || !amFmPresetArray[i2].isValid()) continue;
                AmFmStation amFmStation = amFmPresetArray[i2].getPresetStation();
                ResourceLocator resourceLocator = amFmPresetArray[i2].getImage();
                if (null == amFmStation) continue;
                RadioStationData radioStationData = new RadioStationData();
                radioStationData.stationId = 1;
                radioStationData.country = -1;
                radioStationData.extendedCountryCode = -1;
                radioStationData.piSid = amFmStation.getPi();
                radioStationData.linkedPiSid = -1;
                radioStationData.ensembleId = -1;
                radioStationData.scidi = -1;
                radioStationData.longName = "";
                radioStationData.shortName = "";
                radioStationData.frequency = amFmStation.getFrequency();
                radioStationData.subChannelId = amFmStation.getSubChannel();
                radioStationData.stationType = 0 == n ? "AM" : (1 == n ? "FM" : "");
                radioStationData.radioSdsId = -1L;
                radioStationData.logoId = -1;
                list.add(radioStationData);
                list2.add(resourceLocator);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void addStationLogosDab(List list, List list2) {
        try {
            DabPreset[] dabPresetArray = DabPresetApi.getValidPresetStationList();
            if (null != dabPresetArray) {
                for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
                    if (null == dabPresetArray[i2]) continue;
                    RadioStationData radioStationData = new RadioStationData();
                    ServiceInfo serviceInfo = dabPresetArray[i2].getService();
                    ResourceLocator resourceLocator = dabPresetArray[i2].getImage();
                    if (null == serviceInfo) continue;
                    radioStationData.stationId = 1;
                    radioStationData.country = -1;
                    radioStationData.extendedCountryCode = serviceInfo.getEnsECC();
                    radioStationData.piSid = (int)serviceInfo.getSID();
                    radioStationData.linkedPiSid = -1;
                    radioStationData.ensembleId = -1;
                    radioStationData.scidi = -1;
                    radioStationData.longName = "";
                    radioStationData.shortName = "";
                    radioStationData.frequency = -1L;
                    radioStationData.subChannelId = -1;
                    radioStationData.stationType = "DAB";
                    radioStationData.radioSdsId = -1L;
                    radioStationData.logoId = -1;
                    list.add(radioStationData);
                    list2.add(resourceLocator);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void tuneFmStation(RadioStationDataResponse[] radioStationDataResponseArray) {
        try {
            RadioStationData[] radioStationDataArray;
            if (null != radioStationDataResponseArray && radioStationDataResponseArray.length == 1 && null != radioStationDataResponseArray[0] && radioStationDataResponseArray[0].getTotalItemCount() == 1 && null != (radioStationDataArray = radioStationDataResponseArray[0].getRadioStationData()) && radioStationDataArray.length == 1 && null != radioStationDataArray[0]) {
                int n = -1;
                if (radioStationDataArray[0].getStationType().equals("FM")) {
                    n = 1;
                } else if (radioStationDataArray[0].getStationType().equals("AM")) {
                    n = 3;
                }
                if (n != -1) {
                    AmFmStation amFmStation = new AmFmStation(n, (int)radioStationDataArray[0].getFrequency(), radioStationDataArray[0].getPiSid(), radioStationDataArray[0].getSubChannelId());
                    amFmStation.setName(radioStationDataArray[0].getShortName());
                    StateAmFmActive.tuneStationTriggeredBySpeechControl(amFmStation);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void tuneDabService(RadioStationDataResponse[] radioStationDataResponseArray) {
        try {
            RadioStationData[] radioStationDataArray;
            if (null != radioStationDataResponseArray && radioStationDataResponseArray.length == 1 && null != radioStationDataResponseArray[0] && radioStationDataResponseArray[0].getTotalItemCount() == 1 && null != (radioStationDataArray = radioStationDataResponseArray[0].getRadioStationData()) && radioStationDataArray.length == 1 && null != radioStationDataArray[0]) {
                ServiceInfo serviceInfo = new ServiceInfo();
                serviceInfo.sID = radioStationDataArray[0].getPiSid();
                serviceInfo.ensECC = radioStationDataArray[0].getExtendedCountryCode();
                serviceInfo.ensID = radioStationDataArray[0].getEnsembleId();
                ServiceInfo serviceInfo2 = RadioData.getDabDatabase().mTunerState.getCurrentService();
                if (null == serviceInfo2) {
                    DabDsiApi.selectService(serviceInfo);
                } else if (serviceInfo2.sID != serviceInfo.sID || serviceInfo2.ensID != serviceInfo.ensID) {
                    DabDsiApi.selectService(serviceInfo);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void tuneDabEnsemble(RadioStationDataResponse[] radioStationDataResponseArray) {
        try {
            RadioStationData[] radioStationDataArray;
            if (null != radioStationDataResponseArray && radioStationDataResponseArray.length == 1 && null != radioStationDataResponseArray[0] && radioStationDataResponseArray[0].getTotalItemCount() == 1 && null != (radioStationDataArray = radioStationDataResponseArray[0].getRadioStationData()) && radioStationDataArray.length == 1 && null != radioStationDataArray[0]) {
                EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
                int n = radioStationDataArray[0].getEnsembleId();
                int n2 = radioStationDataArray[0].getExtendedCountryCode();
                if (null == ensembleInfo) {
                    DabDsiApi.tuneEnsemble(n, n2);
                } else if (ensembleInfo.ensID != n) {
                    DabDsiApi.tuneEnsemble(n, n2);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private ComponentInfo getServiceFromCurrentDabServiceList(ComponentInfo[] componentInfoArray, RadioStationData radioStationData) {
        ComponentInfo componentInfo = null;
        if (null != componentInfoArray && null != radioStationData) {
            for (int i2 = 0; i2 < componentInfoArray.length; ++i2) {
                if (null == componentInfoArray[i2] || componentInfoArray[i2].sID != (long)radioStationData.getPiSid() || componentInfoArray[i2].ensECC != radioStationData.getExtendedCountryCode() || componentInfoArray[i2].sCIDI != -1) continue;
                componentInfo = componentInfoArray[i2];
                componentInfoArray[i2] = null;
            }
        }
        return componentInfo;
    }

    public int getDbIdForDabService(ServiceInfo serviceInfo) {
        RadioStationData[] radioStationDataArray;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("RadioDataSessionManager - getDbIdForDabService() - START").log();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(348) && RadioDataApi.isSouthSideStationLogoDbActive() && null != (radioStationDataArray = this.stationLogoBuffer.getDabRadioStationData(serviceInfo)) && radioStationDataArray.length == 1 && null != radioStationDataArray[0]) {
            return radioStationDataArray[0].stationId;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("RadioDataSessionManager - getDbIdForDabService() - END").log();
        }
        return -1;
    }

    public void processDatabaseVersionInfo(int n, int n2, int n3, int n4) {
        int n5 = RadioData.getAmfmDatabase().getSettingsPersistable().getDatabaseMajorVersion();
        int n6 = RadioData.getAmfmDatabase().getSettingsPersistable().getDatabaseMinorVersion();
        if (!(n5 == -1 || n6 == -1 || n5 == n && n6 == n2 || n4 != 2 && n4 != 3)) {
            ServiceManager.logger.info(128).append(new StringBuffer().append("RadioDataSessionManager - processDatabaseVersionInfo(), versionMajor: ").append(n).append(" versionMinor: ").append(n2).append(" versionRevision: ").append(n3).append(" oldDataBaseVersionMajor: ").append(n5).append(" oldDataBaseVersionMinor: ").append(n6).append(" So deleting preset logos and databaseids ").toString());
            AmFmPresetApi.deleteAllDatabaseStationIds(0);
            AmFmPresetApi.deleteAllDatabaseStationIds(1);
            RadioData.getDabDatabase().dabPresetList.deleteAllDatabaseStationIds();
            RadioDataApi.setPersistStationLogosInSouthSideDbUnlocked(false);
            AmFmPresetApi.deleteAllPresetLogos(0);
            AmFmPresetApi.deleteAllPresetLogos(1);
            RadioData.getDabDatabase().dabPresetList.deleteAllPresetLogos();
            RadioDataSessionManager.getInstance().stationLogoBuffer.deleteHmiLogoBuffer();
            RadioDataApi.setPersistStationLogosInSouthSideDbUnlocked(true);
            RadioDataApi.requestPersistStationLogosInSouthSideDb();
        }
        RadioData.getAmfmDatabase().getSettingsPersistable().setDatabaseMajorVersion(n);
        RadioData.getAmfmDatabase().getSettingsPersistable().setDatabaseMinorVersion(n2);
        RadioData.getAmfmDatabase().getSettingsPersistable().setDatabaseRevisionVersion(n3);
    }

    private void compressFmRadioStationDataResponse(RadioStationDataResponse[] radioStationDataResponseArray, RadioDataSessionInfo radioDataSessionInfo) {
        if (null == radioDataSessionInfo) {
            return;
        }
        RadioStationDataRequest[] radioStationDataRequestArray = radioDataSessionInfo.getRadioStationDataRequest();
        if (null != radioStationDataResponseArray && null != radioStationDataRequestArray && radioStationDataResponseArray.length == radioStationDataRequestArray.length) {
            for (int i2 = 0; i2 < radioStationDataResponseArray.length; ++i2) {
                RadioStationData[] radioStationDataArray;
                if (null == radioStationDataResponseArray[i2] || null == (radioStationDataArray = radioStationDataResponseArray[i2].getRadioStationData()) || null == radioStationDataRequestArray[i2]) continue;
                radioStationDataResponseArray[i2].radioStationData = this.compressFmRadioStationDataResponse(radioStationDataArray, radioStationDataRequestArray[i2]);
                radioStationDataResponseArray[i2].totalItemCount = null != radioStationDataResponseArray[i2].radioStationData ? radioStationDataResponseArray[i2].radioStationData.length : 0;
            }
        }
    }

    private RadioStationData[] compressFmRadioStationDataResponse(RadioStationData[] radioStationDataArray, RadioStationDataRequest radioStationDataRequest) {
        int n;
        if (null == radioStationDataArray || radioStationDataArray.length < 2) {
            return radioStationDataArray;
        }
        if (null != radioStationDataRequest.shortName) {
            radioStationDataRequest.shortName = radioStationDataRequest.shortName.trim();
            for (int i2 = 0; i2 < radioStationDataArray.length; ++i2) {
                if (null == radioStationDataArray[i2]) continue;
                String string = radioStationDataArray[i2].shortName;
                int n2 = radioStationDataArray[i2].getPiSid();
                if (null == string || !(string = string.trim()).equalsIgnoreCase(radioStationDataRequest.shortName) || n2 != radioStationDataRequest.piSid) continue;
                return new RadioStationData[]{radioStationDataArray[i2]};
            }
        }
        ArrayList arrayList = new ArrayList(0);
        for (n = 0; n < radioStationDataArray.length; ++n) {
            if (null == radioStationDataArray[n]) continue;
            String string = radioStationDataArray[n].shortName;
            int n3 = radioStationDataArray[n].getPiSid();
            for (int i3 = 0; i3 < radioStationDataArray.length; ++i3) {
                if (i3 == n || null == radioStationDataArray[i3]) continue;
                String string2 = radioStationDataArray[i3].shortName;
                int n4 = radioStationDataArray[i3].getPiSid();
                if (null == string || null == string2 || !(string = string.trim()).equalsIgnoreCase(string2 = string2.trim()) || n3 != n4) continue;
                radioStationDataArray[i3] = null;
            }
        }
        for (n = 0; n < radioStationDataArray.length; ++n) {
            if (null == radioStationDataArray[n]) continue;
            arrayList.add(radioStationDataArray[n]);
        }
        return (RadioStationData[])arrayList.toArray(new RadioStationData[arrayList.size()]);
    }

    public void traceRadioStationDataResponse(RadioStationDataResponse[] radioStationDataResponseArray) {
        try {
            if (null != radioStationDataResponseArray) {
                for (int i2 = 0; i2 < radioStationDataResponseArray.length; ++i2) {
                    RadioStationData[] radioStationDataArray;
                    if (null == radioStationDataResponseArray[i2] || null == (radioStationDataArray = radioStationDataResponseArray[i2].getRadioStationData())) continue;
                    for (int i3 = 0; i3 < radioStationDataArray.length; ++i3) {
                        if (null == radioStationDataArray[i3] || !ServiceManager.logger.isTraceEnabled(128)) continue;
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append(new StringBuffer().append("RadioStationDataResponse[").append(i2).append("]radioStationData[").append(i3).append("] = ").append(radioStationDataArray[i3].toString()).toString()).log();
                    }
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    static {
        radioDataSessionManager = null;
    }
}

