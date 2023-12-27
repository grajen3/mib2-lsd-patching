/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.radiodata.AdapterRadioStationDataRequest;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import java.util.LinkedList;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;

public final class RadioDataManager {
    public RadioStationDataRequest[] createRequestFmStationList(Station[] stationArray) {
        int n = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
        int n2 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(n);
        if (-1 == n2) {
            n2 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(RadioDataSessionManager.getInstance().countryList.getRootNodeMacroRegionId());
        }
        if (-1 != n2) {
            if (2 == n2) {
                return this.createRequestFmStationListViaPi(stationArray);
            }
            return this.createRequestFmStationListViaFrequency(stationArray);
        }
        return null;
    }

    public RadioStationDataRequest[] createRequestFmStationListViaPi(Station[] stationArray) {
        try {
            if (null != stationArray && stationArray.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < stationArray.length; ++i2) {
                    RadioStationData radioStationData;
                    if (null == stationArray[i2] || !stationArray[i2].rds || stationArray[i2].waveband != 1 || !ProgramIdentification.isValidPI(stationArray[i2].getPi()) || null != (radioStationData = RadioDataSessionManager.getInstance().stationDataBuffer.getRadioStationDataViaPi(stationArray[i2]))) continue;
                    RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
                    AdapterRadioStationDataRequest.setStationType(radioStationDataRequest, "FM");
                    AdapterRadioStationDataRequest.setPiSid(radioStationDataRequest, stationArray[i2].pi);
                    radioStationDataRequest.shortName = stationArray[i2].name;
                    radioStationDataRequest.frequency = stationArray[i2].frequency;
                    radioStationDataRequest.maxItemCount = 3;
                    linkedList.add(radioStationDataRequest);
                }
                Object[] objectArray = new RadioStationDataRequest[linkedList.size()];
                objectArray = (RadioStationDataRequest[])linkedList.toArray(objectArray);
                return objectArray;
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public RadioStationDataRequest[] createRequestFmStationListViaFrequency(Station[] stationArray) {
        try {
            if (null != stationArray && stationArray.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < stationArray.length; ++i2) {
                    RadioStationData radioStationData;
                    if (null == stationArray[i2] || stationArray[i2].waveband != 1 || null != (radioStationData = RadioDataSessionManager.getInstance().stationDataBuffer.getRadioStationDataViaFrequency(stationArray[i2]))) continue;
                    RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
                    AdapterRadioStationDataRequest.setStationType(radioStationDataRequest, "FM");
                    AdapterRadioStationDataRequest.setFrequency(radioStationDataRequest, stationArray[i2].frequency);
                    AdapterRadioStationDataRequest.setCountry(radioStationDataRequest, RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry());
                    radioStationDataRequest.maxItemCount = 3;
                    linkedList.add(radioStationDataRequest);
                }
                Object[] objectArray = new RadioStationDataRequest[linkedList.size()];
                objectArray = (RadioStationDataRequest[])linkedList.toArray(objectArray);
                return objectArray;
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public RadioStationDataRequest[] createRequestDabStationList(ServiceInfo[] serviceInfoArray) {
        try {
            if (null != serviceInfoArray && serviceInfoArray.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                    RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
                    AdapterRadioStationDataRequest.setStationType(radioStationDataRequest, "DAB");
                    AdapterRadioStationDataRequest.setExtendedCountryCode(radioStationDataRequest, serviceInfoArray[i2].getEnsECC());
                    AdapterRadioStationDataRequest.setPiSid(radioStationDataRequest, serviceInfoArray[i2].getSID());
                    radioStationDataRequest.maxItemCount = 3;
                    linkedList.add(radioStationDataRequest);
                }
                Object[] objectArray = new RadioStationDataRequest[linkedList.size()];
                objectArray = (RadioStationDataRequest[])linkedList.toArray(objectArray);
                return objectArray;
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public RadioStationDataRequest[] createRequestDabEnsembleData(EnsembleInfo[] ensembleInfoArray) {
        try {
            if (null != ensembleInfoArray && ensembleInfoArray.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
                    RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
                    AdapterRadioStationDataRequest.setStationType(radioStationDataRequest, "DAB_ENS");
                    AdapterRadioStationDataRequest.setExtendedCountryCode(radioStationDataRequest, ensembleInfoArray[i2].getEnsECC());
                    AdapterRadioStationDataRequest.setEnsembleId(radioStationDataRequest, ensembleInfoArray[i2].getEnsID());
                    radioStationDataRequest.maxItemCount = 3;
                    linkedList.add(radioStationDataRequest);
                    RadioStationDataRequest radioStationDataRequest2 = new RadioStationDataRequest();
                    AdapterRadioStationDataRequest.setStationType(radioStationDataRequest2, "DAB_ENS");
                    AdapterRadioStationDataRequest.setEnsembleId(radioStationDataRequest2, ensembleInfoArray[i2].getEnsID());
                    radioStationDataRequest2.maxItemCount = 3;
                    linkedList.add(radioStationDataRequest2);
                }
                Object[] objectArray = new RadioStationDataRequest[linkedList.size()];
                objectArray = (RadioStationDataRequest[])linkedList.toArray(objectArray);
                return objectArray;
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }
}

