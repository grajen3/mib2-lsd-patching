/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.radiodata.AdapterRadioStationDataRequest;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.radiodata.StationLogoData;
import java.util.ArrayList;
import java.util.ListIterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class StationLogoProcessRequest {
    public static final int REQUEST_STRATEGY_INVALID;
    public static final int REQUEST_STRATEGY_1;
    public static final int REQUEST_STRATEGY_2;
    public static final int REQUEST_STRATEGY_3;
    public static final int REQUEST_STRATEGY_4;
    public static final int REQUEST_STRATEGY_5;
    RadioDataSessionManager radioDataSessionManager = null;
    public static final String STATION_TYPE_AM;
    public static final String STATION_TYPE_FM;
    public static final String STATION_TYPE_IBOC;
    public static final String STATION_TYPE_DAB;
    public static final String STATION_TYPE_DAB_ENS;
    public static final String STATION_TYPE_SDARS;

    public StationLogoProcessRequest(RadioDataSessionManager radioDataSessionManager) {
        this.radioDataSessionManager = radioDataSessionManager;
    }

    public void requestRadioAmStationLogos(AmFmStation[] amFmStationArray, int n) {
        try {
            if (null != amFmStationArray && amFmStationArray.length > 0 && amFmStationArray[0] != null) {
                ArrayList arrayList = new ArrayList(0);
                int n2 = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
                for (int i2 = 0; i2 < amFmStationArray.length; ++i2) {
                    if (null == amFmStationArray[i2]) continue;
                    RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
                    AdapterRadioStationDataRequest.setStationType(radioStationDataRequest, "AM");
                    AdapterRadioStationDataRequest.setCountry(radioStationDataRequest, n2);
                    AdapterRadioStationDataRequest.setFrequency(radioStationDataRequest, amFmStationArray[i2].getFrequency());
                    radioStationDataRequest.linkedPiSid = 2;
                    radioStationDataRequest.maxItemCount = 10;
                    ResourceLocator resourceLocator = null;
                    RadioStationLogoResponse radioStationLogoResponse = null;
                    StationLogoData stationLogoData = this.radioDataSessionManager.stationLogoBuffer.getAmStationLogo(radioStationDataRequest);
                    if (null != stationLogoData) {
                        resourceLocator = stationLogoData.getResourceLocator();
                        radioStationLogoResponse = stationLogoData.getStationLogoResponse();
                    } else {
                        arrayList.add(radioStationDataRequest);
                    }
                    if (null == resourceLocator) continue;
                    this.radioDataSessionManager.stationLogoResponse.setDatabaseDataForPreset(radioStationLogoResponse, n, radioStationDataRequest, this.radioDataSessionManager.stationLogoResponse.calculateLogoType(radioStationDataRequest), false, false);
                }
                RadioStationDataRequest[] radioStationDataRequestArray = (RadioStationDataRequest[])arrayList.toArray(new RadioStationDataRequest[arrayList.size()]);
                this.radioDataSessionManager.adapterDsiRadioData.requestRadioStationLogos(radioStationDataRequestArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestGenericRadioAmStationLogo() {
        try {
            RadioStationDataRequest[] radioStationDataRequestArray = new RadioStationDataRequest[]{new RadioStationDataRequest()};
            AdapterRadioStationDataRequest.setStationType(radioStationDataRequestArray[0], "AM");
            AdapterRadioStationDataRequest.setFrequency(radioStationDataRequestArray[0], 1L);
            radioStationDataRequestArray[0].linkedPiSid = 2;
            radioStationDataRequestArray[0].maxItemCount = 10;
            this.radioDataSessionManager.adapterDsiRadioData.requestRadioStationLogos(radioStationDataRequestArray, 0);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRadioFmStationLogos(AmFmStation[] amFmStationArray, int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessRequest - requestRadioFmStationLogos() - requestType = ").append(n).log();
            }
            if (null != amFmStationArray && amFmStationArray.length > 0 && amFmStationArray[0] != null) {
                ArrayList arrayList = new ArrayList(0);
                int n2 = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
                for (int i2 = 0; i2 < amFmStationArray.length; ++i2) {
                    int n3;
                    RadioStationDataRequest radioStationDataRequest;
                    boolean bl;
                    if (null == amFmStationArray[i2] || (bl = this.checkIfLogoIsInHmiBuffer(arrayList, radioStationDataRequest = this.generateFmStationDataRequest(amFmStationArray[i2], n2, 2, true), amFmStationArray[i2], n)) || !amFmStationArray[i2].isRds() || !RadioCodingAdapter.isPiActivated() || !ProgramIdentification.isValidPI(amFmStationArray[i2].getPi()) || n2 == (n3 = RadioDataSessionManager.getInstance().homeCountryCalc.getNeighboringCountry(n2, amFmStationArray[i2].getPi())) || n3 <= 1 || n2 <= 1) continue;
                    RadioStationDataRequest radioStationDataRequest2 = this.generateFmStationDataRequest(amFmStationArray[i2], n3, 2, true);
                    this.checkIfLogoIsInHmiBuffer(arrayList, radioStationDataRequest2, amFmStationArray[i2], n);
                }
                RadioStationDataRequest[] radioStationDataRequestArray = (RadioStationDataRequest[])arrayList.toArray(new RadioStationDataRequest[arrayList.size()]);
                this.radioDataSessionManager.adapterDsiRadioData.requestRadioStationLogos(radioStationDataRequestArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRadioFmStationLogosForAllNeighboringCountries(AmFmStation[] amFmStationArray, int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessRequest - requestRadioFmStationLogosForAllNeighboringCountries() - requestType = ").append(n).log();
            }
            if (null != amFmStationArray && amFmStationArray.length > 0 && amFmStationArray[0] != null) {
                int n2;
                ArrayList arrayList = new ArrayList(0);
                ArrayList arrayList2 = new ArrayList(0);
                int n3 = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
                int[] nArray = RadioDataSessionManager.getInstance().homeCountryCalc.getAllNeighboringCountries(n3);
                int[] nArray2 = null;
                int n4 = -1;
                if (null == nArray) {
                    nArray2 = new int[]{n3};
                } else {
                    nArray2 = new int[nArray.length + 1];
                    nArray2[0] = n3;
                    for (n2 = 0; n2 < nArray.length; ++n2) {
                        nArray2[n2 + 1] = nArray[n2];
                    }
                }
                n2 = 0;
                for (int i2 = 0; i2 < amFmStationArray.length; ++i2) {
                    ListIterator listIterator;
                    if (null == amFmStationArray[i2]) continue;
                    arrayList.clear();
                    for (int i3 = 0; i3 < nArray2.length; ++i3) {
                        if (nArray2[i3] <= 1) continue;
                        n4 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(nArray2[i3]);
                        switch (n4) {
                            case 1: {
                                RadioStationDataRequest radioStationDataRequest = this.generateFmStationDataRequest(amFmStationArray[i2], nArray2[i3], n4, false);
                                n2 = this.checkIfLogoIsInHmiBuffer(arrayList, radioStationDataRequest, amFmStationArray[i2], n) ? 1 : 0;
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                RadioStationDataRequest radioStationDataRequest = this.generateFmStationDataRequest(amFmStationArray[i2], nArray2[i3], n4, true);
                                n2 = this.checkIfLogoIsInHmiBuffer(arrayList, radioStationDataRequest, amFmStationArray[i2], n) ? 1 : 0;
                                break;
                            }
                            case 4: {
                                RadioStationDataRequest radioStationDataRequest = this.generateFmStationDataRequest(amFmStationArray[i2], nArray2[i3], n4, false);
                                n2 = this.checkIfLogoIsInHmiBuffer(arrayList, radioStationDataRequest, amFmStationArray[i2], n) ? 1 : 0;
                                if (n2 != 0) break;
                                RadioStationDataRequest radioStationDataRequest2 = this.generateFmStationDataRequest(amFmStationArray[i2], nArray2[i3], n4, true);
                                n2 = this.checkIfLogoIsInHmiBuffer(arrayList, radioStationDataRequest2, amFmStationArray[i2], n) ? 1 : 0;
                                break;
                            }
                            case 5: {
                                RadioStationDataRequest radioStationDataRequest;
                                if (ProgramIdentification.isValidPI(amFmStationArray[i2].getPi())) {
                                    radioStationDataRequest = this.generateFmStationDataRequest(amFmStationArray[i2], nArray2[i3], n4, true);
                                    n2 = this.checkIfLogoIsInHmiBuffer(arrayList, radioStationDataRequest, amFmStationArray[i2], n) ? 1 : 0;
                                } else {
                                    n2 = 0;
                                }
                                if (n2 != 0) break;
                                radioStationDataRequest = this.generateFmStationDataRequest(amFmStationArray[i2], nArray2[i3], n4, false);
                                n2 = this.checkIfLogoIsInHmiBuffer(arrayList, radioStationDataRequest, amFmStationArray[i2], n) ? 1 : 0;
                                break;
                            }
                        }
                        if (n2 == 0) continue;
                        arrayList.clear();
                        break;
                    }
                    if (null == (listIterator = arrayList.listIterator())) continue;
                    while (listIterator.hasNext()) {
                        arrayList2.add(listIterator.next());
                    }
                }
                RadioStationDataRequest[] radioStationDataRequestArray = (RadioStationDataRequest[])arrayList2.toArray(new RadioStationDataRequest[arrayList2.size()]);
                this.radioDataSessionManager.adapterDsiRadioData.requestRadioStationLogos(radioStationDataRequestArray, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public boolean checkIfLogoIsInHmiBuffer(ArrayList arrayList, RadioStationDataRequest radioStationDataRequest, AmFmStation amFmStation, int n) {
        ResourceLocator resourceLocator = null;
        StationLogoData stationLogoData = null;
        boolean bl = false;
        if (null != arrayList && null != radioStationDataRequest && null != amFmStation) {
            RadioStationLogoResponse radioStationLogoResponse = null;
            stationLogoData = this.radioDataSessionManager.stationLogoBuffer.getFmStationLogo(radioStationDataRequest, amFmStation);
            if (null != stationLogoData) {
                resourceLocator = stationLogoData.getResourceLocator();
                radioStationLogoResponse = stationLogoData.getStationLogoResponse();
            }
            if (null != stationLogoData && null != resourceLocator && n != 19 && n != 20 && !stationLogoData.isResponseContainedMoreThanOneLogo()) {
                this.radioDataSessionManager.stationLogoResponse.setDatabaseDataForPreset(radioStationLogoResponse, 1, radioStationDataRequest, this.radioDataSessionManager.stationLogoResponse.calculateLogoType(radioStationDataRequest), false, false);
            }
        }
        if (n == 19 || n == 20 || n == 4) {
            bl = null != stationLogoData;
        } else {
            boolean bl2 = bl = null != stationLogoData && null != resourceLocator && !stationLogoData.isResponseContainedMoreThanOneLogo();
        }
        if (null != arrayList && !bl) {
            arrayList.add(radioStationDataRequest);
        }
        return bl;
    }

    public RadioStationDataRequest generateFmStationDataRequest(AmFmStation amFmStation, int n, int n2, boolean bl) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationLogoProcessRequest - generateFmStationDataRequest() - fmStation = ").append(amFmStation.toString()).append(", country = ").append(n).append(", requestStrategy = ").append(n2).append(", usePi = ").append(bl).log();
            }
            if (null != amFmStation) {
                RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
                AdapterRadioStationDataRequest.setStationType(radioStationDataRequest, "FM");
                AdapterRadioStationDataRequest.setCountry(radioStationDataRequest, n);
                radioStationDataRequest.linkedPiSid = n2;
                String string = amFmStation.getName();
                if (!amFmStation.isScrollingPS() && null != string && string.length() > 0) {
                    radioStationDataRequest.longName = string;
                    radioStationDataRequest.shortName = string;
                }
                switch (n2) {
                    case 1: {
                        AdapterRadioStationDataRequest.setFrequency(radioStationDataRequest, amFmStation.getFrequency());
                        break;
                    }
                    case 2: {
                        if (amFmStation.isRds() && RadioCodingAdapter.isPiActivated()) {
                            AdapterRadioStationDataRequest.setPiSid(radioStationDataRequest, amFmStation.getPi());
                            break;
                        }
                        AdapterRadioStationDataRequest.setPiSid(radioStationDataRequest, -1L);
                        AdapterRadioStationDataRequest.setFrequency(radioStationDataRequest, amFmStation.getFrequency());
                        break;
                    }
                    case 3: {
                        AdapterRadioStationDataRequest.setPiSid(radioStationDataRequest, amFmStation.getPi());
                        AdapterRadioStationDataRequest.setFrequency(radioStationDataRequest, amFmStation.getFrequency());
                        break;
                    }
                    case 4: 
                    case 5: {
                        if (bl) {
                            AdapterRadioStationDataRequest.setPiSid(radioStationDataRequest, amFmStation.getPi());
                            break;
                        }
                        AdapterRadioStationDataRequest.setFrequency(radioStationDataRequest, amFmStation.getFrequency());
                        break;
                    }
                }
                radioStationDataRequest.maxItemCount = 10;
                return radioStationDataRequest;
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void requestGenericRadioFmStationLogo() {
        try {
            RadioStationDataRequest[] radioStationDataRequestArray = new RadioStationDataRequest[1];
            RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
            AdapterRadioStationDataRequest.setStationType(radioStationDataRequest, "FM");
            AdapterRadioStationDataRequest.setFrequency(radioStationDataRequest, 1L);
            radioStationDataRequest.linkedPiSid = 2;
            radioStationDataRequest.maxItemCount = 10;
            radioStationDataRequestArray[0] = radioStationDataRequest;
            this.radioDataSessionManager.adapterDsiRadioData.requestRadioStationLogos(radioStationDataRequestArray, 1);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestGenericRadioDabStationLogo() {
        try {
            RadioStationDataRequest[] radioStationDataRequestArray = new RadioStationDataRequest[1];
            RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
            AdapterRadioStationDataRequest.setStationType(radioStationDataRequest, "DAB");
            AdapterRadioStationDataRequest.setFrequency(radioStationDataRequest, 1L);
            radioStationDataRequest.linkedPiSid = 2;
            radioStationDataRequest.maxItemCount = 10;
            radioStationDataRequestArray[0] = radioStationDataRequest;
            this.radioDataSessionManager.adapterDsiRadioData.requestRadioStationLogos(radioStationDataRequestArray, 2);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRadioDabStationLogos(ServiceInfo[] serviceInfoArray, int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("StationLogoProcessRequest - requestRadioDabStationLogos() ++start++, requestType = ").append(n).log();
            }
            if (null != serviceInfoArray && serviceInfoArray.length > 0 && serviceInfoArray[0] != null) {
                ArrayList arrayList = new ArrayList(0);
                for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                    if (null == serviceInfoArray[i2]) continue;
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append(new StringBuffer().append("requestRadioDabStationLogos(), serviceInfo[").append(i2).append("] = ").append(serviceInfoArray[i2].toString()).toString()).log();
                    }
                    RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
                    AdapterRadioStationDataRequest.setStationType(radioStationDataRequest, "DAB");
                    AdapterRadioStationDataRequest.setExtendedCountryCode(radioStationDataRequest, serviceInfoArray[i2].getEnsECC());
                    AdapterRadioStationDataRequest.setPiSid(radioStationDataRequest, serviceInfoArray[i2].getSID());
                    radioStationDataRequest.longName = serviceInfoArray[i2].getFullName();
                    radioStationDataRequest.shortName = serviceInfoArray[i2].getShortName();
                    radioStationDataRequest.ensembleId = serviceInfoArray[i2].getEnsID();
                    radioStationDataRequest.linkedPiSid = 2;
                    radioStationDataRequest.maxItemCount = 10;
                    ResourceLocator resourceLocator = null;
                    RadioStationLogoResponse radioStationLogoResponse = null;
                    StationLogoData stationLogoData = this.radioDataSessionManager.stationLogoBuffer.getDabStationLogo(serviceInfoArray[i2]);
                    if (null != stationLogoData) {
                        resourceLocator = stationLogoData.getResourceLocator();
                        radioStationLogoResponse = stationLogoData.getStationLogoResponse();
                    } else {
                        arrayList.add(radioStationDataRequest);
                    }
                    if (null == resourceLocator) continue;
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("StationLogoProcessRequest - requestRadioDabStationLogos() - Logo is in HMI buffer: ").append(resourceLocator).log();
                    }
                    if (n == 7) continue;
                    if (n == 6) {
                        this.radioDataSessionManager.stationLogoResponse.setDabStationLogoForCurrentStationFromDatabaseSouthSide(resourceLocator, radioStationDataRequest);
                        continue;
                    }
                    this.radioDataSessionManager.stationLogoResponse.setDatabaseDataForPreset(radioStationLogoResponse, n, radioStationDataRequest, this.radioDataSessionManager.stationLogoResponse.calculateLogoType(radioStationDataRequest), false, false);
                }
                RadioStationDataRequest[] radioStationDataRequestArray = (RadioStationDataRequest[])arrayList.toArray(new RadioStationDataRequest[arrayList.size()]);
                this.radioDataSessionManager.adapterDsiRadioData.requestRadioStationLogos(radioStationDataRequestArray, n);
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("StationLogoProcessRequest - requestRadioDabStationLogos() ++end++, requestType = ").append(n).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRadioHdStationLogos(int n, long l, int n2, String string) {
        try {
            RadioStationDataRequest[] radioStationDataRequestArray = new RadioStationDataRequest[]{new RadioStationDataRequest()};
            AdapterRadioStationDataRequest.setStationType(radioStationDataRequestArray[0], "IBOC");
            AdapterRadioStationDataRequest.setCountry(radioStationDataRequestArray[0], n);
            AdapterRadioStationDataRequest.setFrequency(radioStationDataRequestArray[0], l);
            AdapterRadioStationDataRequest.setSubChannelId(radioStationDataRequestArray[0], n2);
            AdapterRadioStationDataRequest.setShortName(radioStationDataRequestArray[0], string);
            radioStationDataRequestArray[0].linkedPiSid = 2;
            radioStationDataRequestArray[0].maxItemCount = 10;
            this.radioDataSessionManager.adapterDsiRadioData.requestRadioStationLogos(radioStationDataRequestArray, 8);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

