/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

public class RadioStationDataRequest {
    public int maxItemCount;
    public int stationId;
    public boolean useStationId;
    public int country;
    public boolean useCountry;
    public int extendedCountryCode;
    public boolean useExtendedCountryCode;
    public int piSid;
    public boolean usePiSid;
    public int linkedPiSid;
    public boolean useLinkedPiSid;
    public int ensembleId;
    public boolean useEnsembleId;
    public int scidi;
    public boolean useScidi;
    public String longName;
    public boolean useLongName;
    public String shortName;
    public boolean useShortName;
    public long frequency;
    public boolean useFrequency;
    public int subChannelId;
    public boolean useSubChannelId;
    public String stationType;
    public boolean useStationType;
    public int logoId;
    public boolean useLogoId;

    public RadioStationDataRequest() {
        this.maxItemCount = 0;
        this.stationId = -1;
        this.useStationId = false;
        this.country = -1;
        this.useCountry = false;
        this.extendedCountryCode = -1;
        this.useExtendedCountryCode = false;
        this.piSid = -1;
        this.usePiSid = false;
        this.linkedPiSid = -1;
        this.useLinkedPiSid = false;
        this.ensembleId = -1;
        this.useEnsembleId = false;
        this.scidi = -1;
        this.useScidi = false;
        this.longName = null;
        this.useLongName = false;
        this.shortName = null;
        this.useShortName = false;
        this.frequency = -1L;
        this.useFrequency = false;
        this.subChannelId = -1;
        this.useSubChannelId = false;
        this.stationType = null;
        this.useStationType = false;
        this.logoId = -1;
        this.useLogoId = false;
    }

    public RadioStationDataRequest(int n, int n2, boolean bl, int n3, boolean bl2, int n4, boolean bl3, int n5, boolean bl4, int n6, boolean bl5, int n7, boolean bl6, int n8, boolean bl7, String string, boolean bl8, String string2, boolean bl9, long l, boolean bl10, int n9, boolean bl11, String string3, boolean bl12, int n10, boolean bl13) {
        this.maxItemCount = n;
        this.stationId = n2;
        this.useStationId = bl;
        this.country = n3;
        this.useCountry = bl2;
        this.extendedCountryCode = n4;
        this.useExtendedCountryCode = bl3;
        this.piSid = n5;
        this.usePiSid = bl4;
        this.linkedPiSid = n6;
        this.useLinkedPiSid = bl5;
        this.ensembleId = n7;
        this.useEnsembleId = bl6;
        this.scidi = n8;
        this.useScidi = bl7;
        this.longName = string;
        this.useLongName = bl8;
        this.shortName = string2;
        this.useShortName = bl9;
        this.frequency = l;
        this.useFrequency = bl10;
        this.subChannelId = n9;
        this.useSubChannelId = bl11;
        this.stationType = string3;
        this.useStationType = bl12;
        this.logoId = n10;
        this.useLogoId = bl13;
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }

    public int getStationId() {
        return this.stationId;
    }

    public boolean isUseStationId() {
        return this.useStationId;
    }

    public int getCountry() {
        return this.country;
    }

    public boolean isUseCountry() {
        return this.useCountry;
    }

    public int getExtendedCountryCode() {
        return this.extendedCountryCode;
    }

    public boolean isUseExtendedCountryCode() {
        return this.useExtendedCountryCode;
    }

    public int getPiSid() {
        return this.piSid;
    }

    public boolean isUsePiSid() {
        return this.usePiSid;
    }

    public int getLinkedPiSid() {
        return this.linkedPiSid;
    }

    public boolean isUseLinkedPiSid() {
        return this.useLinkedPiSid;
    }

    public int getEnsembleId() {
        return this.ensembleId;
    }

    public boolean isUseEnsembleId() {
        return this.useEnsembleId;
    }

    public int getScidi() {
        return this.scidi;
    }

    public boolean isUseScidi() {
        return this.useScidi;
    }

    public String getLongName() {
        return this.longName;
    }

    public boolean isUseLongName() {
        return this.useLongName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public boolean isUseShortName() {
        return this.useShortName;
    }

    public long getFrequency() {
        return this.frequency;
    }

    public boolean isUseFrequency() {
        return this.useFrequency;
    }

    public int getSubChannelId() {
        return this.subChannelId;
    }

    public boolean isUseSubChannelId() {
        return this.useSubChannelId;
    }

    public String getStationType() {
        return this.stationType;
    }

    public boolean isUseStationType() {
        return this.useStationType;
    }

    public int getLogoId() {
        return this.logoId;
    }

    public boolean isUseLogoId() {
        return this.useLogoId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("RadioStationDataRequest");
        stringBuffer.append('(');
        stringBuffer.append("maxItemCount");
        stringBuffer.append('=');
        stringBuffer.append(this.maxItemCount);
        stringBuffer.append(',');
        stringBuffer.append("stationId");
        stringBuffer.append('=');
        stringBuffer.append(this.stationId);
        stringBuffer.append(',');
        stringBuffer.append("useStationId");
        stringBuffer.append('=');
        stringBuffer.append(this.useStationId);
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append(this.country);
        stringBuffer.append(',');
        stringBuffer.append("useCountry");
        stringBuffer.append('=');
        stringBuffer.append(this.useCountry);
        stringBuffer.append(',');
        stringBuffer.append("extendedCountryCode");
        stringBuffer.append('=');
        stringBuffer.append(this.extendedCountryCode);
        stringBuffer.append(',');
        stringBuffer.append("useExtendedCountryCode");
        stringBuffer.append('=');
        stringBuffer.append(this.useExtendedCountryCode);
        stringBuffer.append(',');
        stringBuffer.append("piSid");
        stringBuffer.append('=');
        stringBuffer.append(this.piSid);
        stringBuffer.append(',');
        stringBuffer.append("usePiSid");
        stringBuffer.append('=');
        stringBuffer.append(this.usePiSid);
        stringBuffer.append(',');
        stringBuffer.append("linkedPiSid");
        stringBuffer.append('=');
        stringBuffer.append(this.linkedPiSid);
        stringBuffer.append(',');
        stringBuffer.append("useLinkedPiSid");
        stringBuffer.append('=');
        stringBuffer.append(this.useLinkedPiSid);
        stringBuffer.append(',');
        stringBuffer.append("ensembleId");
        stringBuffer.append('=');
        stringBuffer.append(this.ensembleId);
        stringBuffer.append(',');
        stringBuffer.append("useEnsembleId");
        stringBuffer.append('=');
        stringBuffer.append(this.useEnsembleId);
        stringBuffer.append(',');
        stringBuffer.append("scidi");
        stringBuffer.append('=');
        stringBuffer.append(this.scidi);
        stringBuffer.append(',');
        stringBuffer.append("useScidi");
        stringBuffer.append('=');
        stringBuffer.append(this.useScidi);
        stringBuffer.append(',');
        stringBuffer.append("longName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.longName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("useLongName");
        stringBuffer.append('=');
        stringBuffer.append(this.useLongName);
        stringBuffer.append(',');
        stringBuffer.append("shortName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("useShortName");
        stringBuffer.append('=');
        stringBuffer.append(this.useShortName);
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(',');
        stringBuffer.append("useFrequency");
        stringBuffer.append('=');
        stringBuffer.append(this.useFrequency);
        stringBuffer.append(',');
        stringBuffer.append("subChannelId");
        stringBuffer.append('=');
        stringBuffer.append(this.subChannelId);
        stringBuffer.append(',');
        stringBuffer.append("useSubChannelId");
        stringBuffer.append('=');
        stringBuffer.append(this.useSubChannelId);
        stringBuffer.append(',');
        stringBuffer.append("stationType");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stationType);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("useStationType");
        stringBuffer.append('=');
        stringBuffer.append(this.useStationType);
        stringBuffer.append(',');
        stringBuffer.append("logoId");
        stringBuffer.append('=');
        stringBuffer.append(this.logoId);
        stringBuffer.append(',');
        stringBuffer.append("useLogoId");
        stringBuffer.append('=');
        stringBuffer.append(this.useLogoId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

