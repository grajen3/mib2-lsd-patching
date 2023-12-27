/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionInfo;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationDataResponse;

public class StationDataBuffer {
    private RadioStationData[] dataBuffer = null;
    public final int INVALID_RESPONSE;

    public StationDataBuffer() {
        this.INVALID_RESPONSE = 1088553216;
        this.createStationDataArray();
    }

    public void createStationDataArray() {
        this.dataBuffer = new RadioStationData[300];
    }

    public void setRadioStationData(RadioStationDataResponse[] radioStationDataResponseArray, RadioDataSessionInfo radioDataSessionInfo) {
        try {
            if (null != radioStationDataResponseArray && null != radioDataSessionInfo) {
                RadioStationDataRequest[] radioStationDataRequestArray = radioDataSessionInfo.getRadioStationDataRequest();
                if (null == radioStationDataRequestArray) {
                    ServiceManager.logger.error(128).append("StationDataBuffer - setRadioStationData() - null == stationDataSessionInfo").log();
                    return;
                }
                if (radioStationDataResponseArray.length != radioStationDataRequestArray.length) {
                    ServiceManager.logger.error(128).append("StationDataBuffer - setRadioStationData() - radioStationDataResponse.length != stationDataSessionInfo.length").log();
                    return;
                }
                for (int i2 = 0; i2 < radioStationDataResponseArray.length; ++i2) {
                    this.setRadioStationData(radioStationDataResponseArray[i2], radioStationDataRequestArray[i2]);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void setRadioStationData(RadioStationDataResponse radioStationDataResponse, RadioStationDataRequest radioStationDataRequest) {
        RadioStationData[] radioStationDataArray;
        if (null != radioStationDataResponse && null != radioStationDataRequest && null != (radioStationDataArray = radioStationDataResponse.getRadioStationData()) && radioStationDataArray.length > 0 && null != radioStationDataArray[0]) {
            if (radioStationDataArray.length > 1) {
                radioStationDataArray[0].subChannelId = 1088553216;
            }
            this.setRadioStationData(radioStationDataArray[0], radioStationDataRequest);
        }
    }

    private void setRadioStationData(RadioStationData radioStationData, RadioStationDataRequest radioStationDataRequest) {
        int n = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
        int n2 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(n);
        if (-1 == n2) {
            n2 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(RadioDataSessionManager.getInstance().countryList.getRootNodeMacroRegionId());
        }
        if (2 == n2 || -1 == n2) {
            this.setRadioStationDataViaPi(radioStationData, radioStationDataRequest);
        } else {
            this.setRadioStationDataViaFrequency(radioStationData, radioStationDataRequest);
        }
    }

    private void setRadioStationDataViaPi(RadioStationData radioStationData, RadioStationDataRequest radioStationDataRequest) {
        if (null != radioStationData && ProgramIdentification.isValidPI(radioStationData.piSid)) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationDataBuffer - setRadioStationDataViaPi() - ").append(radioStationData.toString()).log();
            }
            for (int i2 = 0; i2 < this.dataBuffer.length; ++i2) {
                if (null == this.dataBuffer[i2]) {
                    this.dataBuffer[i2] = new RadioStationData(radioStationData.stationId, radioStationData.country, radioStationData.extendedCountryCode, radioStationData.piSid, radioStationData.linkedPiSid, radioStationData.ensembleId, radioStationData.scidi, radioStationData.longName, radioStationData.shortName, radioStationDataRequest.frequency, radioStationData.subChannelId, radioStationData.stationType, radioStationData.radioSdsId, radioStationData.logoId);
                    return;
                }
                if (this.dataBuffer[i2].piSid != radioStationData.piSid) continue;
                this.dataBuffer[i2] = new RadioStationData(radioStationData.stationId, radioStationData.country, radioStationData.extendedCountryCode, radioStationData.piSid, radioStationData.linkedPiSid, radioStationData.ensembleId, radioStationData.scidi, radioStationData.longName, radioStationData.shortName, radioStationDataRequest.frequency, radioStationData.subChannelId, radioStationData.stationType, radioStationData.radioSdsId, radioStationData.logoId);
                return;
            }
        }
    }

    private void setRadioStationDataViaFrequency(RadioStationData radioStationData, RadioStationDataRequest radioStationDataRequest) {
        if (null != radioStationData) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("StationDataBuffer - setRadioStationDataViaFrequency() - ").append(radioStationData.toString()).log();
            }
            for (int i2 = 0; i2 < this.dataBuffer.length; ++i2) {
                if (null == this.dataBuffer[i2]) {
                    this.dataBuffer[i2] = new RadioStationData(radioStationData.stationId, radioStationData.country, radioStationData.extendedCountryCode, radioStationData.piSid, radioStationData.linkedPiSid, radioStationData.ensembleId, radioStationData.scidi, radioStationData.longName, radioStationData.shortName, radioStationDataRequest.frequency, radioStationData.subChannelId, radioStationData.stationType, radioStationData.radioSdsId, radioStationData.logoId);
                    return;
                }
                if (this.dataBuffer[i2].frequency != radioStationData.getFrequency()) continue;
                this.dataBuffer[i2] = new RadioStationData(radioStationData.stationId, radioStationData.country, radioStationData.extendedCountryCode, radioStationData.piSid, radioStationData.linkedPiSid, radioStationData.ensembleId, radioStationData.scidi, radioStationData.longName, radioStationData.shortName, radioStationDataRequest.frequency, radioStationData.subChannelId, radioStationData.stationType, radioStationData.radioSdsId, radioStationData.logoId);
                return;
            }
        }
    }

    public RadioStationData getRadioStationData(AmFmStation amFmStation) {
        int n = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
        int n2 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(n);
        if (-1 == n2) {
            n2 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(RadioDataSessionManager.getInstance().countryList.getRootNodeMacroRegionId());
        }
        if (2 == n2 || -1 == n2) {
            return this.getRadioStationDataViaPi(amFmStation.getAsDSIStation());
        }
        return this.getRadioStationDataViaFrequency(amFmStation.getAsDSIStation());
    }

    public String getRadioStationName(AmFmStation amFmStation) {
        int n = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
        int n2 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(n);
        if (-1 == n2) {
            n2 = RadioDataSessionManager.getInstance().countryList.getRequestStrategy(RadioDataSessionManager.getInstance().countryList.getRootNodeMacroRegionId());
        }
        if (2 == n2 || -1 == n2) {
            return this.getRadioStationNameViaPi(amFmStation);
        }
        return this.getRadioStationNameViaFrequency(amFmStation, n);
    }

    public String getRadioStationNameViaPi(AmFmStation amFmStation) {
        if (null != this.dataBuffer && null != amFmStation && ProgramIdentification.isValidPI(amFmStation.getPi())) {
            for (int i2 = 0; i2 < this.dataBuffer.length; ++i2) {
                if (null == this.dataBuffer[i2] || this.dataBuffer[i2].piSid != amFmStation.getPi() || this.dataBuffer[i2].subChannelId == 1088553216) continue;
                String string = this.dataBuffer[i2].getShortName();
                if (null != string) {
                    return string;
                }
                return "";
            }
            return "";
        }
        return "";
    }

    public String getRadioStationNameViaFrequency(AmFmStation amFmStation, int n) {
        if (null != this.dataBuffer && null != amFmStation) {
            for (int i2 = 0; i2 < this.dataBuffer.length; ++i2) {
                if (null == this.dataBuffer[i2] || this.dataBuffer[i2].frequency != (long)amFmStation.getFrequency() || this.dataBuffer[i2].subChannelId == 1088553216 || this.dataBuffer[i2].getCountry() != n) continue;
                String string = this.dataBuffer[i2].getShortName();
                if (null != string) {
                    return string;
                }
                return "";
            }
            return "";
        }
        return "";
    }

    public RadioStationData getRadioStationDataViaPi(Station station) {
        if (null != this.dataBuffer && null != station && ProgramIdentification.isValidPI(station.getPi())) {
            for (int i2 = 0; i2 < this.dataBuffer.length; ++i2) {
                if (null == this.dataBuffer[i2] || this.dataBuffer[i2].piSid != station.getPi()) continue;
                return this.dataBuffer[i2];
            }
            return null;
        }
        return null;
    }

    public RadioStationData getRadioStationDataViaFrequency(Station station) {
        int n = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
        if (null != this.dataBuffer && null != station) {
            for (int i2 = 0; i2 < this.dataBuffer.length; ++i2) {
                if (null == this.dataBuffer[i2] || this.dataBuffer[i2].frequency != station.getFrequency() || this.dataBuffer[i2].country != n) continue;
                return this.dataBuffer[i2];
            }
            return null;
        }
        return null;
    }

    public RadioStationData getUniqueRadioStationData(Station station) {
        if (null != this.dataBuffer && null != station && ProgramIdentification.isValidPI(station.getPi())) {
            for (int i2 = 0; i2 < this.dataBuffer.length; ++i2) {
                if (null == this.dataBuffer[i2] || this.dataBuffer[i2].piSid != station.getPi() || this.dataBuffer[i2].subChannelId == 1088553216) continue;
                return this.dataBuffer[i2];
            }
            return null;
        }
        return null;
    }

    public AmFmStation getRadioStationData(int n) {
        if (null != this.dataBuffer) {
            for (int i2 = 0; i2 < this.dataBuffer.length; ++i2) {
                if (null == this.dataBuffer[i2] || this.dataBuffer[i2].stationId != n) continue;
                AmFmStation amFmStation = new AmFmStation();
                amFmStation.setWaveband(1);
                amFmStation.setFrequency((int)this.dataBuffer[i2].getFrequency());
                amFmStation.setPI(this.dataBuffer[i2].getPiSid());
                amFmStation.setName(this.dataBuffer[i2].getShortName());
                return amFmStation;
            }
            return null;
        }
        return null;
    }
}

