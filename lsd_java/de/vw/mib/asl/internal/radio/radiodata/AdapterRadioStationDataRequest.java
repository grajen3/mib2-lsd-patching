/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import org.dsi.ifc.radiodata.RadioStationDataRequest;

public final class AdapterRadioStationDataRequest {
    public static void setStationId(RadioStationDataRequest radioStationDataRequest, int n) {
        if (n > -1) {
            radioStationDataRequest.stationId = n;
            radioStationDataRequest.useStationId = true;
        }
    }

    public static void setStationType(RadioStationDataRequest radioStationDataRequest, String string) {
        if (null != string && string.length() > 0) {
            radioStationDataRequest.stationType = string;
            radioStationDataRequest.useStationType = true;
        }
    }

    public static void setCountry(RadioStationDataRequest radioStationDataRequest, int n) {
        if (n > -1) {
            radioStationDataRequest.country = n;
            radioStationDataRequest.useCountry = true;
        }
    }

    public static void setFrequency(RadioStationDataRequest radioStationDataRequest, long l) {
        if (-1L != l) {
            radioStationDataRequest.frequency = l;
            radioStationDataRequest.useFrequency = true;
        }
    }

    public static void setPiSid(RadioStationDataRequest radioStationDataRequest, long l) {
        radioStationDataRequest.piSid = (int)l;
        radioStationDataRequest.usePiSid = true;
    }

    public static void setEnsembleId(RadioStationDataRequest radioStationDataRequest, int n) {
        if (-1 != n) {
            radioStationDataRequest.ensembleId = n;
            radioStationDataRequest.useEnsembleId = true;
        }
    }

    public static void setScidi(RadioStationDataRequest radioStationDataRequest, int n) {
        if (-1 != n) {
            radioStationDataRequest.scidi = n;
            radioStationDataRequest.useScidi = true;
        }
    }

    public static void setExtendedCountryCode(RadioStationDataRequest radioStationDataRequest, int n) {
        if (-1 != n) {
            radioStationDataRequest.extendedCountryCode = n;
            radioStationDataRequest.useExtendedCountryCode = true;
        }
    }

    public static void setSubChannelId(RadioStationDataRequest radioStationDataRequest, int n) {
        if (-1 != n) {
            radioStationDataRequest.subChannelId = n;
            radioStationDataRequest.useSubChannelId = true;
        }
    }

    public static void setShortName(RadioStationDataRequest radioStationDataRequest, String string) {
        if (null != string && string.length() > 0) {
            radioStationDataRequest.shortName = string.trim();
            radioStationDataRequest.useShortName = true;
        }
    }
}

