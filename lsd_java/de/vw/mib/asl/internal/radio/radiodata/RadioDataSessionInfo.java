/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import org.dsi.ifc.radiodata.RadioStationDataRequest;

public final class RadioDataSessionInfo {
    public static final int REQUEST_TYPE_RADIO_AM_PRESET_STATION_LOGOS;
    public static final int REQUEST_TYPE_RADIO_FM_PRESET_STATION_LOGOS;
    public static final int REQUEST_TYPE_RADIO_DAB_PRESET_STATION_LOGOS;
    public static final int REQUEST_TYPE_RADIO_AM_PRESET_STATION_LOGOS_FOR_INITIAL_AUTO_STORE;
    public static final int REQUEST_TYPE_RADIO_FM_PRESET_STATION_LOGOS_FOR_INITIAL_AUTO_STORE;
    public static final int REQUEST_TYPE_RADIO_DAB_PRESET_STATION_LOGOS_FOR_INITIAL_AUTO_STORE;
    public static final int REQUEST_TYPE_RADIO_DAB_CURRENT_STATION_LOGOS;
    public static final int REQUEST_TYPE_RADIO_DAB_SERVICE_LIST_LOGOS;
    public static final int REQUEST_TYPE_RADIO_HD_PRESET_STATION_LOGOS;
    public static final int REQUEST_TYPE_RADIO_STATION_DATA_FM;
    public static final int REQUEST_TYPE_RADIO_STATION_DATA_DAB;
    public static final int REQUEST_TYPE_RADIO_STATION_DATA_FOR_TUNING_FM;
    public static final int REQUEST_TYPE_RADIO_STATION_DATA_FOR_TUNING_DAB_SERVICE;
    public static final int REQUEST_TYPE_RADIO_PERSIST_STATION_LOGOS;
    public static final int REQUEST_TYPE_RADIO_COUNTRY_LIST_UPDATE;
    public static final int REQUEST_TYPE_RADIO_ENSEMBLE_DATA_DAB;
    public static final int REQUEST_TYPE_RADIO_STATION_DATA_FOR_TUNING_DAB_ENSEMBLE;
    public static final int REQUEST_TYPE_RADIO_COUNTRY_REGION_TRANSLATION_DATA_NATIVE;
    public static final int REQUEST_TYPE_RADIO_COUNTRY_REGION_TRANSLATION_DATA_ENGLISH;
    public static final int REQUEST_TYPE_RADIO_FM_STATION_LIST_LOGOS;
    public static final int REQUEST_TYPE_RADIO_FM_CURRENT_STATION_LOGOS;
    private int requestType = -1;
    private RadioStationDataRequest[] radioStationDataRequest = null;

    public RadioDataSessionInfo() {
    }

    public RadioDataSessionInfo(int n, RadioStationDataRequest radioStationDataRequest) {
        if (null != radioStationDataRequest) {
            this.requestType = n;
            RadioStationDataRequest[] radioStationDataRequestArray = new RadioStationDataRequest[]{radioStationDataRequest};
            this.setRadioStationDataRequest(radioStationDataRequestArray);
        }
    }

    public int getRequestType() {
        return this.requestType;
    }

    public void setRequestType(int n) {
        this.requestType = n;
    }

    public RadioStationDataRequest[] getRadioStationDataRequest() {
        return this.radioStationDataRequest;
    }

    public void setRadioStationDataRequest(RadioStationDataRequest[] radioStationDataRequestArray) {
        if (null != radioStationDataRequestArray) {
            this.radioStationDataRequest = new RadioStationDataRequest[radioStationDataRequestArray.length];
            for (int i2 = 0; i2 < radioStationDataRequestArray.length; ++i2) {
                this.radioStationDataRequest[i2] = new RadioStationDataRequest();
                this.radioStationDataRequest[i2].maxItemCount = radioStationDataRequestArray[i2].maxItemCount;
                this.radioStationDataRequest[i2].stationId = radioStationDataRequestArray[i2].stationId;
                this.radioStationDataRequest[i2].useStationId = radioStationDataRequestArray[i2].useStationId;
                this.radioStationDataRequest[i2].country = radioStationDataRequestArray[i2].country;
                this.radioStationDataRequest[i2].useCountry = radioStationDataRequestArray[i2].useCountry;
                this.radioStationDataRequest[i2].extendedCountryCode = radioStationDataRequestArray[i2].extendedCountryCode;
                this.radioStationDataRequest[i2].useExtendedCountryCode = radioStationDataRequestArray[i2].useExtendedCountryCode;
                this.radioStationDataRequest[i2].piSid = radioStationDataRequestArray[i2].piSid;
                this.radioStationDataRequest[i2].usePiSid = radioStationDataRequestArray[i2].usePiSid;
                this.radioStationDataRequest[i2].linkedPiSid = radioStationDataRequestArray[i2].linkedPiSid;
                this.radioStationDataRequest[i2].useLinkedPiSid = radioStationDataRequestArray[i2].useLinkedPiSid;
                this.radioStationDataRequest[i2].ensembleId = radioStationDataRequestArray[i2].ensembleId;
                this.radioStationDataRequest[i2].useEnsembleId = radioStationDataRequestArray[i2].useEnsembleId;
                this.radioStationDataRequest[i2].scidi = radioStationDataRequestArray[i2].scidi;
                this.radioStationDataRequest[i2].useScidi = radioStationDataRequestArray[i2].useScidi;
                this.radioStationDataRequest[i2].longName = radioStationDataRequestArray[i2].longName;
                this.radioStationDataRequest[i2].useLongName = radioStationDataRequestArray[i2].useLongName;
                this.radioStationDataRequest[i2].shortName = radioStationDataRequestArray[i2].shortName;
                this.radioStationDataRequest[i2].useShortName = radioStationDataRequestArray[i2].useShortName;
                this.radioStationDataRequest[i2].frequency = radioStationDataRequestArray[i2].frequency;
                this.radioStationDataRequest[i2].useFrequency = radioStationDataRequestArray[i2].useFrequency;
                this.radioStationDataRequest[i2].subChannelId = radioStationDataRequestArray[i2].subChannelId;
                this.radioStationDataRequest[i2].useSubChannelId = radioStationDataRequestArray[i2].useSubChannelId;
                this.radioStationDataRequest[i2].stationType = radioStationDataRequestArray[i2].stationType;
                this.radioStationDataRequest[i2].useStationType = radioStationDataRequestArray[i2].useStationType;
                this.radioStationDataRequest[i2].logoId = radioStationDataRequestArray[i2].logoId;
                this.radioStationDataRequest[i2].useLogoId = radioStationDataRequestArray[i2].useLogoId;
            }
        }
    }
}

