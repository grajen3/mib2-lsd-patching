/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

public class RadioStationData {
    public int stationId;
    public int country;
    public int extendedCountryCode;
    public int piSid;
    public int linkedPiSid;
    public int ensembleId;
    public int scidi;
    public String longName;
    public String shortName;
    public long frequency;
    public int subChannelId;
    public String stationType;
    public long radioSdsId;
    public int logoId;

    public RadioStationData() {
        this.stationId = -1;
        this.country = -1;
        this.extendedCountryCode = -1;
        this.piSid = -1;
        this.linkedPiSid = -1;
        this.ensembleId = -1;
        this.scidi = -1;
        this.longName = null;
        this.shortName = null;
        this.frequency = -1L;
        this.subChannelId = -1;
        this.stationType = null;
        this.radioSdsId = -1L;
        this.logoId = -1;
    }

    public RadioStationData(int n, int n2, int n3, int n4, int n5, int n6, int n7, String string, String string2, long l, int n8, String string3, long l2, int n9) {
        this.stationId = n;
        this.country = n2;
        this.extendedCountryCode = n3;
        this.piSid = n4;
        this.linkedPiSid = n5;
        this.ensembleId = n6;
        this.scidi = n7;
        this.longName = string;
        this.shortName = string2;
        this.frequency = l;
        this.subChannelId = n8;
        this.stationType = string3;
        this.radioSdsId = l2;
        this.logoId = n9;
    }

    public int getStationId() {
        return this.stationId;
    }

    public int getCountry() {
        return this.country;
    }

    public int getExtendedCountryCode() {
        return this.extendedCountryCode;
    }

    public int getPiSid() {
        return this.piSid;
    }

    public int getLinkedPiSid() {
        return this.linkedPiSid;
    }

    public int getEnsembleId() {
        return this.ensembleId;
    }

    public int getScidi() {
        return this.scidi;
    }

    public String getLongName() {
        return this.longName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public long getFrequency() {
        return this.frequency;
    }

    public int getSubChannelId() {
        return this.subChannelId;
    }

    public String getStationType() {
        return this.stationType;
    }

    public long getRadioSdsId() {
        return this.radioSdsId;
    }

    public int getLogoId() {
        return this.logoId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(850);
        stringBuffer.append("RadioStationData");
        stringBuffer.append('(');
        stringBuffer.append("stationId");
        stringBuffer.append('=');
        stringBuffer.append(this.stationId);
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append(this.country);
        stringBuffer.append(',');
        stringBuffer.append("extendedCountryCode");
        stringBuffer.append('=');
        stringBuffer.append(this.extendedCountryCode);
        stringBuffer.append(',');
        stringBuffer.append("piSid");
        stringBuffer.append('=');
        stringBuffer.append(this.piSid);
        stringBuffer.append(',');
        stringBuffer.append("linkedPiSid");
        stringBuffer.append('=');
        stringBuffer.append(this.linkedPiSid);
        stringBuffer.append(',');
        stringBuffer.append("ensembleId");
        stringBuffer.append('=');
        stringBuffer.append(this.ensembleId);
        stringBuffer.append(',');
        stringBuffer.append("scidi");
        stringBuffer.append('=');
        stringBuffer.append(this.scidi);
        stringBuffer.append(',');
        stringBuffer.append("longName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.longName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("shortName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(',');
        stringBuffer.append("subChannelId");
        stringBuffer.append('=');
        stringBuffer.append(this.subChannelId);
        stringBuffer.append(',');
        stringBuffer.append("stationType");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stationType);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("radioSdsId");
        stringBuffer.append('=');
        stringBuffer.append(this.radioSdsId);
        stringBuffer.append(',');
        stringBuffer.append("logoId");
        stringBuffer.append('=');
        stringBuffer.append(this.logoId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

