/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.connectedradio.RadioStationLogo;
import org.dsi.ifc.connectedradio.RadioStationStream;
import org.dsi.ifc.global.ResourceLocator;

public class RadioStation {
    public int id;
    public String shortName;
    public String mediumName;
    public String longName;
    public String title;
    public String description;
    public String[] genres;
    public int pi;
    public int frequency;
    public int eid;
    public int sid;
    public int scids;
    public String isoCountryCode;
    public int ecc;
    public String gcc;
    public String country;
    public String broadcastCountryCode;
    public int radioVISPort;
    public String radioVISUrl;
    public String radioVISText;
    public ResourceLocator radioVISCurrentImage;
    public RadioStationStream[] streams;
    public RadioStationLogo[] logos;

    public RadioStation() {
        this.id = 0;
        this.shortName = null;
        this.mediumName = null;
        this.longName = null;
        this.title = null;
        this.description = null;
        this.genres = null;
        this.pi = 0;
        this.frequency = 0;
        this.eid = 0;
        this.sid = 0;
        this.scids = 0;
        this.isoCountryCode = null;
        this.ecc = 0;
        this.gcc = null;
        this.country = null;
        this.broadcastCountryCode = null;
        this.radioVISPort = 0;
        this.radioVISUrl = null;
        this.radioVISText = null;
        this.radioVISCurrentImage = null;
        this.streams = null;
        this.logos = null;
    }

    public RadioStation(int n, String string, String string2, String string3, String string4, String string5, String[] stringArray, int n2, int n3, int n4, int n5, int n6, String string6, int n7, String string7, String string8, String string9, int n8, String string10, String string11, ResourceLocator resourceLocator, RadioStationStream[] radioStationStreamArray, RadioStationLogo[] radioStationLogoArray) {
        this.id = n;
        this.shortName = string;
        this.mediumName = string2;
        this.longName = string3;
        this.title = string4;
        this.description = string5;
        this.genres = stringArray;
        this.pi = n2;
        this.frequency = n3;
        this.eid = n4;
        this.sid = n5;
        this.scids = n6;
        this.isoCountryCode = string6;
        this.ecc = n7;
        this.gcc = string7;
        this.country = string8;
        this.broadcastCountryCode = string9;
        this.radioVISPort = n8;
        this.radioVISUrl = string10;
        this.radioVISText = string11;
        this.radioVISCurrentImage = resourceLocator;
        this.streams = radioStationStreamArray;
        this.logos = radioStationLogoArray;
    }

    public String[] getGenreList() {
        return this.genres;
    }

    public int getId() {
        return this.id;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getMediumName() {
        return this.mediumName;
    }

    public String getLongName() {
        return this.longName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getGenres() {
        return this.genres;
    }

    public int getPi() {
        return this.pi;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getEid() {
        return this.eid;
    }

    public int getSid() {
        return this.sid;
    }

    public int getScids() {
        return this.scids;
    }

    public String getIsoCountryCode() {
        return this.isoCountryCode;
    }

    public int getEcc() {
        return this.ecc;
    }

    public String getGcc() {
        return this.gcc;
    }

    public String getCountry() {
        return this.country;
    }

    public String getBroadcastCountryCode() {
        return this.broadcastCountryCode;
    }

    public int getRadioVISPort() {
        return this.radioVISPort;
    }

    public String getRadioVISUrl() {
        return this.radioVISUrl;
    }

    public String getRadioVISText() {
        return this.radioVISText;
    }

    public ResourceLocator getRadioVISCurrentImage() {
        return this.radioVISCurrentImage;
    }

    public RadioStationStream[] getStreams() {
        return this.streams;
    }

    public RadioStationLogo[] getLogos() {
        return this.logos;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(2400);
        stringBuffer.append("RadioStation");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("shortName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("mediumName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mediumName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("longName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.longName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("genres");
        stringBuffer.append('[');
        if (this.genres != null) {
            stringBuffer.append(this.genres.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.genres != null) {
            n3 = this.genres.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.genres[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.genres);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("pi");
        stringBuffer.append('=');
        stringBuffer.append(this.pi);
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(',');
        stringBuffer.append("eid");
        stringBuffer.append('=');
        stringBuffer.append(this.eid);
        stringBuffer.append(',');
        stringBuffer.append("sid");
        stringBuffer.append('=');
        stringBuffer.append(this.sid);
        stringBuffer.append(',');
        stringBuffer.append("scids");
        stringBuffer.append('=');
        stringBuffer.append(this.scids);
        stringBuffer.append(',');
        stringBuffer.append("isoCountryCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.isoCountryCode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("ecc");
        stringBuffer.append('=');
        stringBuffer.append(this.ecc);
        stringBuffer.append(',');
        stringBuffer.append("gcc");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.gcc);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.country);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("broadcastCountryCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.broadcastCountryCode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("radioVISPort");
        stringBuffer.append('=');
        stringBuffer.append(this.radioVISPort);
        stringBuffer.append(',');
        stringBuffer.append("radioVISUrl");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.radioVISUrl);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("radioVISText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.radioVISText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("radioVISCurrentImage");
        stringBuffer.append('=');
        stringBuffer.append(this.radioVISCurrentImage);
        stringBuffer.append(',');
        stringBuffer.append("streams");
        stringBuffer.append('[');
        if (this.streams != null) {
            stringBuffer.append(this.streams.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.streams != null) {
            n3 = this.streams.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.streams[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.streams);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("logos");
        stringBuffer.append('[');
        if (this.logos != null) {
            stringBuffer.append(this.logos.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.logos != null) {
            n3 = this.logos.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.logos[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.logos);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

