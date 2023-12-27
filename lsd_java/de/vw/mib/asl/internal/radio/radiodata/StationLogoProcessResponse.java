/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionInfo;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.radiodata.StationLogoBuffer;
import de.vw.mib.asl.internal.radio.transformer.RadioStationLogoSelectionCollector;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class StationLogoProcessResponse {
    static final int APPLICATION_LOGO_BUFFER_IS_FULL;
    RadioDataSessionManager radioDataSessionManager = null;
    private RadioDataSessionInfo radioDataSessionInfoLogoSelection = null;
    private ResourceLocator[] resourceLocatorsLogoSelection = null;

    public StationLogoProcessResponse(RadioDataSessionManager radioDataSessionManager) {
        this.radioDataSessionManager = radioDataSessionManager;
    }

    public void setStationLogosFromDatabaseSouthSide(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        int n2;
        this.requestGenericStationLogo();
        if (null == radioStationLogoResponseArray) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - setStationLogosFromDatabaseSouthSide: stationLogosResponse == null, sessionId: ").append(n).log();
            return;
        }
        if (radioStationLogoResponseArray.length < 1) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - setStationLogosFromDatabaseSouthSide: stationLogosResponse.length < 1, sessionId: ").append(n).log();
            return;
        }
        if (null == radioStationLogoResponseArray[0]) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - setStationLogosFromDatabaseSouthSide: null == stationLogosResponse[0], sessionId: ").append(n).log();
            return;
        }
        if (n < 0 || n >= 50) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - setStationLogosFromDatabaseSouthSide: sessionId < 0 || sessionId >= ARRAY_LENGTH_SESSION_INFO, sessionId: ").append(n).log();
            return;
        }
        for (int i2 = 0; i2 < radioStationLogoResponseArray.length; ++i2) {
            if (null == radioStationLogoResponseArray[i2] || radioStationLogoResponseArray[i2].totalItemCount != -999) continue;
            RadioDataSessionManager.getInstance().stationLogoBuffer.deleteHmiLogoBuffer();
            return;
        }
        RadioDataSessionInfo radioDataSessionInfo = this.radioDataSessionManager.getRadioDataSessionInfo(n);
        if (null == radioDataSessionInfo) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setStationLogosFromDatabaseSouthSide: radioDataSessionInfo == null, sessionId: ").append(n).log();
            }
            return;
        }
        RadioStationDataRequest[] radioStationDataRequestArray = radioDataSessionInfo.getRadioStationDataRequest();
        if (null == radioStationDataRequestArray) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - setStationLogosFromDatabaseSouthSide: radioStationDataSessionInfo == null, sessionId: ").append(n).log();
            return;
        }
        if (radioStationLogoResponseArray.length != radioStationDataRequestArray.length) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - setStationLogosFromDatabaseSouthSide: stationLogosResponse.length != radioStationDataSessionInfo.length, sessionId: ").append(n).log();
            return;
        }
        if (7 == radioDataSessionInfo.getRequestType()) {
            for (int i3 = 0; i3 < radioStationLogoResponseArray.length; ++i3) {
                this.compareStationNames(radioStationLogoResponseArray[i3], radioDataSessionInfo.getRequestType(), radioStationDataRequestArray[i3]);
                ResourceLocator[] resourceLocatorArray = radioStationLogoResponseArray[i3].getResourceLocators();
                if (null != resourceLocatorArray && null != radioStationDataRequestArray[i3] && resourceLocatorArray.length == 1) {
                    this.radioDataSessionManager.stationLogoBuffer.setDabStationLogo(resourceLocatorArray[0], radioStationDataRequestArray[i3], radioStationLogoResponseArray[i3]);
                    continue;
                }
                if (null != resourceLocatorArray || null == radioStationDataRequestArray[i3]) continue;
                this.radioDataSessionManager.stationLogoBuffer.setDabStationLogo(null, radioStationDataRequestArray[i3], radioStationLogoResponseArray[i3]);
            }
            RadioData.targetRadioData.stopTimer(-1652096768);
            RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateDabServiceListToSpeech();
            if (RadioCodingAdapter.isRadioTileFeatureActivated()) {
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                    RadioServiceManager.getServiceManager().getTileStationList().setDabDatabaseData(1170613248);
                }
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileLVisible()) {
                    RadioServiceManager.getServiceManager().getTileStationList().setDabDatabaseData(1153836032);
                }
            }
            return;
        }
        int n3 = -1;
        for (n2 = 0; n2 < radioStationDataRequestArray.length; ++n2) {
            if (null == radioStationDataRequestArray[n2]) continue;
            n3 = radioStationDataRequestArray[n2].linkedPiSid;
            break;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.info(128).append("StationLogoProcessResponse - setStationLogosFromDatabaseSouthSide: handle request strategy = ").append(n3).log();
        }
        this.resolveRadioFmPresetStationLogoResponse(radioStationLogoResponseArray, radioDataSessionInfo.getRequestType(), radioStationDataRequestArray);
        switch (n3) {
            case 1: 
            case 3: 
            case 4: 
            case 5: {
                if (19 == radioDataSessionInfo.getRequestType() || 20 == radioDataSessionInfo.getRequestType()) {
                    return;
                }
                this.setStationLogoFromDatabaseSouthSide(radioStationLogoResponseArray, radioDataSessionInfo.getRequestType(), radioStationDataRequestArray, n);
                break;
            }
            case 2: {
                for (n2 = 0; n2 < radioStationLogoResponseArray.length; ++n2) {
                    this.compareStationNames(radioStationLogoResponseArray[n2], radioDataSessionInfo.getRequestType(), radioStationDataRequestArray[n2]);
                    this.setStationLogoFromDatabaseSouthSide(radioStationLogoResponseArray[n2], radioDataSessionInfo.getRequestType(), radioStationDataRequestArray[n2], n);
                }
                if (20 != radioDataSessionInfo.getRequestType() && 19 != radioDataSessionInfo.getRequestType() || !RadioCodingAdapter.isRadioTileFeatureActivated()) break;
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                    RadioServiceManager.getServiceManager().getTileStationList().setFmDatabaseData(1170613248);
                }
                if (!RadioServiceManager.getServiceManager().getTileStationList().isTileLVisible()) break;
                RadioServiceManager.getServiceManager().getTileStationList().setFmDatabaseData(1153836032);
                break;
            }
        }
    }

    private void compareStationNames(RadioStationLogoResponse radioStationLogoResponse, int n, RadioStationDataRequest radioStationDataRequest) {
        if (null == radioStationLogoResponse || null == radioStationDataRequest) {
            return;
        }
        ResourceLocator[] resourceLocatorArray = radioStationLogoResponse.getResourceLocators();
        RadioStationData[] radioStationDataArray = radioStationLogoResponse.getRadioStationData();
        if (null == resourceLocatorArray || null == radioStationDataArray) {
            return;
        }
        if (resourceLocatorArray.length < 2) {
            return;
        }
        if ((n == 7 || n == 6 || n == 1 || n == 19 || n == 2 || n == 4 || n == 5) && radioStationDataArray.length == resourceLocatorArray.length) {
            String string;
            String string2 = radioStationDataRequest.getShortName();
            if (null != string2 && string2.length() > 0) {
                string2 = this.getLettersAndDigitsFromString(string2);
                for (int i2 = 0; i2 < radioStationDataArray.length; ++i2) {
                    String string3;
                    if (null == resourceLocatorArray[i2] || null == radioStationDataArray[i2] || null == (string3 = radioStationDataArray[i2].shortName) || string3.length() <= 0 || !(string3 = this.getLettersAndDigitsFromString(string3)).equalsIgnoreCase(string2)) continue;
                    radioStationLogoResponse.resourceLocators = new ResourceLocator[]{resourceLocatorArray[i2]};
                    radioStationLogoResponse.radioStationData = new RadioStationData[]{radioStationDataArray[i2]};
                    radioStationLogoResponse.totalItemCount = 1;
                    return;
                }
            }
            if (null != (string = radioStationDataRequest.getLongName()) && string.length() > 0) {
                string = this.getLettersAndDigitsFromString(string);
                for (int i3 = 0; i3 < radioStationDataArray.length; ++i3) {
                    String string4;
                    if (null == resourceLocatorArray[i3] || null == radioStationDataArray[i3] || null == (string4 = radioStationDataArray[i3].longName) || string4.length() <= 0) continue;
                    string4 = this.getLettersAndDigitsFromString(string4);
                    if (n == 1 || n == 4) {
                        if (string4.indexOf(string) <= -1) continue;
                        radioStationLogoResponse.resourceLocators = new ResourceLocator[]{resourceLocatorArray[i3]};
                        radioStationLogoResponse.radioStationData = new RadioStationData[]{radioStationDataArray[i3]};
                        radioStationLogoResponse.totalItemCount = 1;
                        return;
                    }
                    if (!string4.equalsIgnoreCase(string)) continue;
                    radioStationLogoResponse.resourceLocators = new ResourceLocator[]{resourceLocatorArray[i3]};
                    radioStationLogoResponse.radioStationData = new RadioStationData[]{radioStationDataArray[i3]};
                    radioStationLogoResponse.totalItemCount = 1;
                    return;
                }
            }
        }
    }

    private void resolveRadioFmPresetStationLogoResponse(RadioStationLogoResponse[] radioStationLogoResponseArray, int n, RadioStationDataRequest[] radioStationDataRequestArray) {
        if (n != 1 || radioStationLogoResponseArray.length < 2) {
            return;
        }
        int n2 = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
        int n3 = -1;
        for (int i2 = 0; i2 < radioStationLogoResponseArray.length; ++i2) {
            if (null == radioStationLogoResponseArray[i2] || null == radioStationDataRequestArray[i2]) continue;
            n3 = radioStationDataRequestArray[i2].linkedPiSid;
            if (radioStationLogoResponseArray.length > 2 && n3 == 2) {
                radioStationLogoResponseArray = new RadioStationLogoResponse[]{};
                return;
            }
            ResourceLocator[] resourceLocatorArray = radioStationLogoResponseArray[i2].getResourceLocators();
            RadioStationData[] radioStationDataArray = radioStationLogoResponseArray[i2].getRadioStationData();
            int n4 = radioStationLogoResponseArray[i2].getTotalItemCount();
            RadioStationDataRequest radioStationDataRequest = radioStationDataRequestArray[i2];
            if (null == resourceLocatorArray || null == radioStationDataArray || radioStationDataArray.length <= 0 || resourceLocatorArray.length <= 0 || null == radioStationDataArray[0] || null == resourceLocatorArray[0] || n2 != radioStationDataArray[0].getCountry()) continue;
            for (int i3 = 0; i3 < radioStationLogoResponseArray.length && i3 < radioStationDataRequestArray.length; ++i3) {
                radioStationLogoResponseArray[i3] = null;
                radioStationDataRequestArray[i3] = null;
            }
            radioStationLogoResponseArray[0] = new RadioStationLogoResponse();
            radioStationLogoResponseArray[0].resourceLocators = resourceLocatorArray;
            radioStationLogoResponseArray[0].radioStationData = radioStationDataArray;
            radioStationLogoResponseArray[0].totalItemCount = n4;
            radioStationDataRequestArray[0] = radioStationDataRequest;
            return;
        }
    }

    public void requestGenericStationLogo() {
        if (!StationLogoBuffer.requestedRadioAmGenericStationLogo && null == RadioDataSessionManager.getInstance().stationLogoBuffer.getGenericAmLogoResourceLocator()) {
            StationLogoBuffer.requestedRadioAmGenericStationLogo = true;
            RadioDataApi.requestGenericRadioAmStationLogo();
        }
        if (!StationLogoBuffer.requestedRadioFmGenericStationLogo && null == RadioDataSessionManager.getInstance().stationLogoBuffer.getGenericFmLogoResourceLocator()) {
            StationLogoBuffer.requestedRadioFmGenericStationLogo = true;
            RadioDataApi.requestGenericRadioFmStationLogo();
        }
        if (!StationLogoBuffer.requestedRadioDabGenericStationLogo && null == RadioDataSessionManager.getInstance().stationLogoBuffer.getGenericDabLogoResourceLocator()) {
            StationLogoBuffer.requestedRadioDabGenericStationLogo = true;
            RadioDataApi.requestGenericRadioDabStationLogo();
        }
    }

    public void setStationLogoFromDatabaseSouthSide(RadioStationLogoResponse radioStationLogoResponse, int n, RadioStationDataRequest radioStationDataRequest, int n2) {
        if (null == radioStationLogoResponse) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setStationLogoFromDatabaseSouthSide(): stationLogoResponse == null").log();
            }
            return;
        }
        ResourceLocator[] resourceLocatorArray = radioStationLogoResponse.getResourceLocators();
        if (n == 6) {
            if (null != resourceLocatorArray && resourceLocatorArray.length == 1 && null != resourceLocatorArray[0]) {
                this.radioDataSessionManager.stationLogoBuffer.setDabStationLogo(resourceLocatorArray[0], radioStationDataRequest, radioStationLogoResponse);
                this.setDabStationLogoForCurrentStationFromDatabaseSouthSide(resourceLocatorArray[0], radioStationDataRequest);
                if (RadioCodingAdapter.isRadioTileFeatureActivated()) {
                    if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                        RadioServiceManager.getServiceManager().getTileStationList().setDabDatabaseData(1170613248);
                    }
                    if (RadioServiceManager.getServiceManager().getTileStationList().isTileLVisible()) {
                        RadioServiceManager.getServiceManager().getTileStationList().setDabDatabaseData(1153836032);
                    }
                }
            }
        } else if (null != resourceLocatorArray && resourceLocatorArray.length > 1 && null != resourceLocatorArray[0]) {
            if (n == 3 || n == 4 || n == 5 || radioStationDataRequest.frequency == 1L) {
                return;
            }
            if (n == 19 || n == 20) {
                int n3 = this.calculateLogoType(radioStationDataRequest);
                this.setDatabaseDataForPreset(radioStationLogoResponse, n, radioStationDataRequest, n3, true, true);
                return;
            }
            this.prepareLogoSelectionAndOpenPopup(radioStationLogoResponse, n, radioStationDataRequest);
        } else {
            int n4 = this.calculateLogoType(radioStationDataRequest);
            this.setDatabaseDataForPreset(radioStationLogoResponse, n, radioStationDataRequest, n4, true, false);
        }
    }

    public void setStationLogoFromDatabaseSouthSide(RadioStationLogoResponse[] radioStationLogoResponseArray, int n, RadioStationDataRequest[] radioStationDataRequestArray, int n2) {
        if (null == radioStationLogoResponseArray) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setStationLogoFromDatabaseSouthSide(): stationLogoResponse[] == null").log();
            }
            return;
        }
        if (radioStationLogoResponseArray.length < 1) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setStationLogoFromDatabaseSouthSide(): stationLogoResponse.length < 1").log();
            }
            return;
        }
        if (null == radioStationDataRequestArray) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setStationLogoFromDatabaseSouthSide(): stationDataSessionInfo[] == null").log();
            }
            return;
        }
        if (radioStationDataRequestArray.length < 1) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setStationLogoFromDatabaseSouthSide(): stationDataSessionInfo.length < 1").log();
            }
            return;
        }
        if (null == radioStationDataRequestArray[0]) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setStationLogoFromDatabase(): stationDataSessionInfo[0] == null").log();
            }
            return;
        }
        switch (n) {
            case 1: {
                Object object;
                Object[] objectArray;
                ArrayList arrayList = new ArrayList(0);
                ArrayList arrayList2 = new ArrayList(0);
                for (int i2 = 0; i2 < radioStationLogoResponseArray.length; ++i2) {
                    if (null == radioStationLogoResponseArray[i2]) continue;
                    objectArray = radioStationLogoResponseArray[i2].getResourceLocators();
                    object = radioStationLogoResponseArray[i2].getRadioStationData();
                    if (null == objectArray || null == object || objectArray.length != ((RadioStationData[])object).length) continue;
                    for (int i3 = 0; i3 < objectArray.length; ++i3) {
                        if (null == objectArray[i3] || null == object[i3]) continue;
                        arrayList.add(objectArray[i3]);
                        arrayList2.add(object[i3]);
                    }
                }
                ResourceLocator[] resourceLocatorArray = (ResourceLocator[])arrayList.toArray(new ResourceLocator[arrayList.size()]);
                objectArray = (RadioStationData[])arrayList2.toArray(new RadioStationData[arrayList2.size()]);
                if (null == resourceLocatorArray || null == objectArray || resourceLocatorArray.length <= 0) break;
                object = new RadioStationLogoResponse();
                object.resourceLocators = resourceLocatorArray;
                object.radioStationData = objectArray;
                object.totalItemCount = resourceLocatorArray.length;
                RadioStationLogoResponse radioStationLogoResponse = this.filterDuplicates((RadioStationLogoResponse)object);
                if (null == radioStationLogoResponse) {
                    return;
                }
                if (null != radioStationLogoResponse.resourceLocators && radioStationLogoResponse.resourceLocators.length > 1 && null != radioStationLogoResponse.resourceLocators[0]) {
                    if (n == 3 || n == 4 || n == 5 || radioStationDataRequestArray[0].frequency == 1L) {
                        return;
                    }
                    this.prepareLogoSelectionAndOpenPopup(radioStationLogoResponse, n, radioStationDataRequestArray[0]);
                    break;
                }
                int n3 = this.calculateLogoType(radioStationDataRequestArray[0]);
                this.setDatabaseDataForPreset(radioStationLogoResponse, n, radioStationDataRequestArray[0], n3, true, false);
                break;
            }
            case 4: {
                block6: for (int i4 = 0; i4 < radioStationDataRequestArray.length; ++i4) {
                    if (null == radioStationDataRequestArray[i4]) continue;
                    for (int i5 = 0; i5 < radioStationLogoResponseArray.length; ++i5) {
                        if (null == radioStationLogoResponseArray[i5]) continue;
                        ResourceLocator[] resourceLocatorArray = radioStationLogoResponseArray[i5].getResourceLocators();
                        RadioStationData[] radioStationDataArray = radioStationLogoResponseArray[i5].getRadioStationData();
                        if (null == resourceLocatorArray || null == radioStationDataArray || resourceLocatorArray.length != radioStationDataArray.length || resourceLocatorArray.length != 1 || null == resourceLocatorArray[0] || null == radioStationDataArray[0] || radioStationDataArray[0].frequency != radioStationDataRequestArray[i4].frequency) continue;
                        int n4 = this.calculateLogoType(radioStationDataRequestArray[i4]);
                        this.setDatabaseDataForPreset(radioStationLogoResponseArray[i5], n, radioStationDataRequestArray[i4], n4, true, false);
                        this.removeSessionInfoItems(radioStationDataRequestArray, radioStationDataRequestArray[i4].frequency);
                        continue block6;
                    }
                }
                break;
            }
        }
    }

    private void removeSessionInfoItems(RadioStationDataRequest[] radioStationDataRequestArray, long l) {
        for (int i2 = 0; i2 < radioStationDataRequestArray.length; ++i2) {
            if (null == radioStationDataRequestArray[i2] || radioStationDataRequestArray[i2].frequency != l) continue;
            radioStationDataRequestArray[i2] = null;
        }
    }

    public void setUserSelectedStationLogoSouthSide(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            ResourceLocator[] resourceLocatorArray = this.getResourceLocatorsLogoSelection();
            RadioDataSessionInfo radioDataSessionInfo = this.getRadioDataSessionInfoLogoSelection();
            if (null != radioDataSessionInfo) {
                int n2 = radioDataSessionInfo.getRequestType();
                RadioStationDataRequest[] radioStationDataRequestArray = radioDataSessionInfo.getRadioStationDataRequest();
                if (null != resourceLocatorArray && null != radioStationDataRequestArray && radioStationDataRequestArray.length > 0 && n >= 0 && n < resourceLocatorArray.length) {
                    this.setPresetStationLogoSouthSide(resourceLocatorArray[n], n2, radioStationDataRequestArray[0], 2, true, false);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public int calculateLogoType(RadioStationDataRequest radioStationDataRequest) {
        int n = 0;
        int n2 = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
        if (null != radioStationDataRequest) {
            n = radioStationDataRequest.country == n2 && n2 > 0 ? 3 : 4;
            if (radioStationDataRequest.frequency == 1L) {
                n = 5;
            }
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("StationLogoProcessResponse - calculateLogoType : ").append(n).log();
        }
        return n;
    }

    public void setDatabaseDataForPreset(RadioStationLogoResponse radioStationLogoResponse, int n, RadioStationDataRequest radioStationDataRequest, int n2, boolean bl, boolean bl2) {
        try {
            if (null == radioStationLogoResponse) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setDatabaseDataForPreset: stationLogoResponse == null").log();
                }
                return;
            }
            if (null == radioStationDataRequest) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setDatabaseDataForPreset: stationDataSessionInfo == null").log();
                }
                return;
            }
            ResourceLocator[] resourceLocatorArray = radioStationLogoResponse.getResourceLocators();
            ResourceLocator resourceLocator = null;
            if (null != resourceLocatorArray && resourceLocatorArray.length > 0) {
                resourceLocator = resourceLocatorArray[0];
            }
            switch (n) {
                case 0: 
                case 3: {
                    if (radioStationDataRequest.frequency == 1L) {
                        RadioDataSessionManager.getInstance().stationLogoBuffer.setGenericAmLogoResourceLocator(resourceLocator);
                        n2 = 5;
                    }
                    if (bl && radioStationDataRequest.frequency != 1L) {
                        this.radioDataSessionManager.stationLogoBuffer.setAmStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse);
                    }
                    AmFmPresetApi.setDatabaseDataForAmPreset(radioStationLogoResponse, radioStationDataRequest, n2);
                    RadioDataApi.requestPersistStationLogosInSouthSideDb();
                    break;
                }
                case 1: 
                case 4: {
                    if (radioStationDataRequest.frequency == 1L) {
                        RadioDataSessionManager.getInstance().stationLogoBuffer.setGenericFmLogoResourceLocator(resourceLocator);
                        n2 = 5;
                    }
                    if (bl && radioStationDataRequest.frequency != 1L) {
                        this.radioDataSessionManager.stationLogoBuffer.setFmStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse, bl2);
                    }
                    AmFmPresetApi.setDatabaseDataForFmPreset(radioStationLogoResponse, radioStationDataRequest, n2);
                    RadioDataApi.requestPersistStationLogosInSouthSideDb();
                    break;
                }
                case 19: 
                case 20: {
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated()) break;
                    this.radioDataSessionManager.stationLogoBuffer.setFmStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse, bl2);
                    break;
                }
                case 2: 
                case 5: {
                    n2 = 0;
                    if (radioStationDataRequest.frequency == 1L) {
                        RadioDataSessionManager.getInstance().stationLogoBuffer.setGenericDabLogoResourceLocator(resourceLocator);
                        n2 = 5;
                    }
                    if (bl && radioStationDataRequest.frequency != 1L) {
                        this.radioDataSessionManager.stationLogoBuffer.setDabStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse);
                    }
                    if (null == resourceLocator) {
                        resourceLocator = RadioDataApi.getGenericDabLogoFromHmiLogoBuffer();
                        n2 = 5;
                    }
                    if (null == resourceLocator) break;
                    DabPresetApi.setDatabaseDataForDabPreset(radioStationLogoResponse, radioStationDataRequest, n2);
                    RadioDataApi.requestPersistStationLogosInSouthSideDb();
                    break;
                }
                case 8: {
                    break;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setPresetStationLogoSouthSide(ResourceLocator resourceLocator, int n, RadioStationDataRequest radioStationDataRequest, int n2, boolean bl, boolean bl2) {
        try {
            if (null == radioStationDataRequest) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("StationLogoProcessResponse - setStationLogoSouthSide: stationDataSessionInfo == null").log();
                }
                return;
            }
            switch (n) {
                case 0: 
                case 3: {
                    if (radioStationDataRequest.frequency == 1L) {
                        RadioDataSessionManager.getInstance().stationLogoBuffer.setGenericAmLogoResourceLocator(resourceLocator);
                        n2 = 5;
                    }
                    if (bl && radioStationDataRequest.frequency != 1L) {
                        RadioStationLogoResponse radioStationLogoResponse = new RadioStationLogoResponse();
                        radioStationLogoResponse.resourceLocators = new ResourceLocator[]{resourceLocator};
                        this.radioDataSessionManager.stationLogoBuffer.setAmStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse);
                    }
                    if (null == resourceLocator) {
                        resourceLocator = RadioDataApi.getGenericAmLogoFromHmiLogoBuffer();
                        n2 = 5;
                    }
                    if (null == resourceLocator) break;
                    AmFmPresetApi.setAmStationLogoFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n2);
                    RadioDataApi.requestPersistStationLogosInSouthSideDb();
                    break;
                }
                case 1: 
                case 4: {
                    if (radioStationDataRequest.frequency == 1L) {
                        RadioDataSessionManager.getInstance().stationLogoBuffer.setGenericFmLogoResourceLocator(resourceLocator);
                        n2 = 5;
                    }
                    if (bl && radioStationDataRequest.frequency != 1L) {
                        RadioStationLogoResponse radioStationLogoResponse = new RadioStationLogoResponse();
                        radioStationLogoResponse.resourceLocators = new ResourceLocator[]{resourceLocator};
                        this.radioDataSessionManager.stationLogoBuffer.setFmStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse, bl2);
                    }
                    if (null == resourceLocator) {
                        resourceLocator = RadioDataApi.getGenericFmLogoFromHmiLogoBuffer();
                        n2 = 5;
                    }
                    if (null == resourceLocator) break;
                    AmFmPresetApi.setFmStationLogoFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n2);
                    RadioDataApi.requestPersistStationLogosInSouthSideDb();
                    break;
                }
                case 2: 
                case 5: {
                    n2 = 0;
                    if (radioStationDataRequest.frequency == 1L) {
                        RadioDataSessionManager.getInstance().stationLogoBuffer.setGenericDabLogoResourceLocator(resourceLocator);
                        n2 = 5;
                    }
                    if (bl && radioStationDataRequest.frequency != 1L) {
                        RadioStationLogoResponse radioStationLogoResponse = new RadioStationLogoResponse();
                        radioStationLogoResponse.resourceLocators = new ResourceLocator[]{resourceLocator};
                        this.radioDataSessionManager.stationLogoBuffer.setDabStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse);
                    }
                    if (null == resourceLocator) {
                        resourceLocator = RadioDataApi.getGenericDabLogoFromHmiLogoBuffer();
                        n2 = 5;
                    }
                    if (null == resourceLocator) break;
                    DabPresetApi.setDabStationLogoFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n2);
                    RadioDataApi.requestPersistStationLogosInSouthSideDb();
                    break;
                }
                case 8: {
                    break;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void prepareLogoSelectionAndOpenPopup(RadioStationLogoResponse radioStationLogoResponse, int n, RadioStationDataRequest radioStationDataRequest) {
        try {
            if (null == radioStationLogoResponse) {
                return;
            }
            ResourceLocator[] resourceLocatorArray = radioStationLogoResponse.getResourceLocators();
            RadioStationData[] radioStationDataArray = radioStationLogoResponse.getRadioStationData();
            if (null != resourceLocatorArray && resourceLocatorArray.length > 1 && null != radioStationDataArray && radioStationDataArray.length == resourceLocatorArray.length) {
                this.resourceLocatorsLogoSelection = new ResourceLocator[resourceLocatorArray.length];
                System.arraycopy((Object)resourceLocatorArray, 0, (Object)this.resourceLocatorsLogoSelection, 0, resourceLocatorArray.length);
                this.radioDataSessionInfoLogoSelection = new RadioDataSessionInfo(n, radioStationDataRequest);
                ArrayList arrayList = new ArrayList(0);
                for (int i2 = 0; i2 < resourceLocatorArray.length; ++i2) {
                    if (null == radioStationDataArray[i2] || null == resourceLocatorArray[i2]) continue;
                    RadioStationLogoSelectionCollector radioStationLogoSelectionCollector = new RadioStationLogoSelectionCollector();
                    radioStationLogoSelectionCollector.logoResourceLocator = resourceLocatorArray[i2];
                    radioStationLogoSelectionCollector.logoAutoSelected = true;
                    radioStationLogoSelectionCollector.stationName = "";
                    radioStationLogoSelectionCollector.stationFrequency = -1;
                    if (null != radioStationDataArray[i2].shortName) {
                        radioStationLogoSelectionCollector.stationName = radioStationDataArray[i2].shortName;
                    }
                    radioStationLogoSelectionCollector.stationFrequency = (int)radioStationDataArray[i2].frequency;
                    arrayList.add(radioStationLogoSelectionCollector);
                }
                if (null != arrayList && arrayList.size() > 0) {
                    Object[] objectArray = (RadioStationLogoSelectionCollector[])arrayList.toArray(new RadioStationLogoSelectionCollector[arrayList.size()]);
                    ListManager.getGenericASLList(4058).updateList(objectArray);
                    AmFmFactory.getAslAmfmModelController().openSelectPresetLogoPopup();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public RadioStationLogoResponse filterDuplicates(RadioStationLogoResponse radioStationLogoResponse) {
        int n;
        int n2;
        if (null == radioStationLogoResponse) {
            return null;
        }
        ResourceLocator[] resourceLocatorArray = radioStationLogoResponse.getResourceLocators();
        RadioStationData[] radioStationDataArray = radioStationLogoResponse.getRadioStationData();
        if (null == resourceLocatorArray || null == radioStationDataArray || resourceLocatorArray.length < 2 || resourceLocatorArray.length != radioStationDataArray.length) {
            return radioStationLogoResponse;
        }
        for (n2 = 0; n2 < resourceLocatorArray.length; ++n2) {
            for (n = n2 + 1; n < resourceLocatorArray.length; ++n) {
                if (null == radioStationDataArray[n2] || null == resourceLocatorArray[n2] || null == radioStationDataArray[n] || null == resourceLocatorArray[n]) continue;
                if (null == radioStationDataArray[n2].shortName) {
                    radioStationDataArray[n2].shortName = "";
                }
                if (radioStationDataArray[n2].piSid != radioStationDataArray[n].piSid || radioStationDataArray[n2].frequency != radioStationDataArray[n].frequency || !radioStationDataArray[n2].shortName.equalsIgnoreCase(radioStationDataArray[n].shortName) || !RadioUtil.equals(resourceLocatorArray[n2], resourceLocatorArray[n])) continue;
                resourceLocatorArray[n] = null;
                radioStationDataArray[n] = null;
            }
        }
        n2 = 0;
        for (n = 0; n < resourceLocatorArray.length; ++n) {
            if (null == radioStationDataArray[n] || null == resourceLocatorArray[n]) continue;
            ++n2;
        }
        ResourceLocator[] resourceLocatorArray2 = new ResourceLocator[n2];
        RadioStationData[] radioStationDataArray2 = new RadioStationData[n2];
        int n3 = 0;
        for (int i2 = 0; i2 < resourceLocatorArray.length && n3 < n2; ++i2) {
            if (null == radioStationDataArray[i2] || null == resourceLocatorArray[i2]) continue;
            resourceLocatorArray2[n3] = resourceLocatorArray[i2];
            radioStationDataArray2[n3] = radioStationDataArray[i2];
            ++n3;
        }
        RadioStationLogoResponse radioStationLogoResponse2 = new RadioStationLogoResponse(n2, resourceLocatorArray2, radioStationDataArray2);
        return radioStationLogoResponse2;
    }

    public ResourceLocator[] getResourceLocatorsLogoSelection() {
        return this.resourceLocatorsLogoSelection;
    }

    public RadioDataSessionInfo getRadioDataSessionInfoLogoSelection() {
        return this.radioDataSessionInfoLogoSelection;
    }

    public void setDabStationLogoForCurrentStationFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("StationLogoProcessResponse - setDabStationLogoForCurrentStationFromDatabaseSouthSide() ++start++").log();
            }
            if (null != radioStationDataRequest && null != resourceLocator) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append(new StringBuffer().append("resourceLocator: ").append(resourceLocator).append(" radioStationDataRequest: ").append(radioStationDataRequest).toString()).log();
                }
                DabRadioSlsApi.notifyNewLogoAvailable();
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("StationLogoProcessResponse - setDabStationLogoForCurrentStationFromDatabaseSouthSide() ++end++").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private String getLettersAndDigitsFromString(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        string = string.toLowerCase();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (!Character.isLetterOrDigit(c2) && c2 != '|') continue;
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }

    public void updateStationLogosFromDatabase(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n) {
        if (null == radioStationDataArray) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - updateStationLogosFromDatabase() - null == radioStationData").log();
            return;
        }
        if (null == resourceLocatorArray) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - updateStationLogosFromDatabase() - null == resourceLocator").log();
            return;
        }
        if (radioStationDataArray.length < 1) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - updateStationLogosFromDatabase: radioStationData.length < 1").log();
            return;
        }
        if (radioStationDataArray.length != resourceLocatorArray.length) {
            ServiceManager.logger.error(128).append("StationLogoProcessResponse - updateStationLogosFromDatabase() - radioStationData.length != resourceLocator.length").log();
            return;
        }
        for (int i2 = 0; i2 < radioStationDataArray.length; ++i2) {
            if (null == radioStationDataArray[i2]) continue;
            if ("AM" == radioStationDataArray[i2].stationType) {
                AmFmPresetApi.updateStationLogoFromDatabase(radioStationDataArray[i2], resourceLocatorArray[i2], 0);
                continue;
            }
            if ("FM" == radioStationDataArray[i2].stationType) {
                AmFmPresetApi.updateStationLogoFromDatabase(radioStationDataArray[i2], resourceLocatorArray[i2], 1);
                continue;
            }
            if ("DAB" != radioStationDataArray[i2].stationType) continue;
            RadioData.getDabDatabase().dabPresetList.updateStationLogoFromDatabase(radioStationDataArray[i2], resourceLocatorArray[i2]);
        }
        AmFmPresetApi.toPersistence(0);
        AmFmPresetApi.toPersistence(1);
        AmFmPresetApi.updateGuiList(0);
        AmFmPresetApi.updateGuiList(1);
        RadioData.getDabDatabase().mPersistable.toPersistence();
        RadioData.getDabDatabase().dabPresetList.notifyHmi();
    }
}

