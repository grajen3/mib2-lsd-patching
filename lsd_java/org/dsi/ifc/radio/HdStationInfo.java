/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.global.ResourceLocator;

public class HdStationInfo {
    public String artistName;
    public String albumTitle;
    public String songTitle;
    public String genre;
    public ResourceLocator stationArt;
    public ResourceLocator coverArt;
    public String language;
    public String shortDescription;
    public String contentField;
    public String price;
    public String validUntil;
    public String contactURL;
    public short receivedAs;
    public String nameOfSeller;
    public String comrDescription;
    public String mimeType;
    public byte[] binaryData;
    public String affiliateID;
    public String iTunesID;
    public int iTunesFrontID;
    public int podcastFeedURL;
    public String unknownData;
    public int frequency;
    public int pi;
    public int serviceId;
    public String stationURL;

    public HdStationInfo() {
        this.frequency = 0;
        this.pi = 0;
        this.serviceId = 0;
        this.artistName = "";
        this.albumTitle = "";
        this.songTitle = "";
        this.genre = "";
        this.stationArt = null;
        this.coverArt = null;
        this.language = null;
        this.shortDescription = "";
        this.contentField = "";
        this.price = "";
        this.validUntil = "";
        this.contactURL = "";
        this.receivedAs = 0;
        this.nameOfSeller = "";
        this.comrDescription = "";
        this.mimeType = "";
        this.binaryData = null;
        this.affiliateID = "";
        this.iTunesID = "";
        this.iTunesFrontID = 0;
        this.podcastFeedURL = 0;
        this.unknownData = "";
        this.stationURL = "";
    }

    public HdStationInfo(String string, String string2, String string3, String string4, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, String string5, String string6, String string7, String string8, String string9, String string10, short s, String string11, String string12, String string13, byte[] byArray, String string14, String string15, int n, int n2, String string16, int n3, int n4, int n5, String string17) {
        this.frequency = n3;
        this.pi = n4;
        this.serviceId = n5;
        this.artistName = string;
        this.albumTitle = string2;
        this.songTitle = string3;
        this.genre = string4;
        this.stationArt = resourceLocator;
        this.coverArt = resourceLocator2;
        this.language = string5;
        this.shortDescription = string6;
        this.contentField = string7;
        this.price = string8;
        this.validUntil = string9;
        this.contactURL = string10;
        this.receivedAs = s;
        this.nameOfSeller = string11;
        this.comrDescription = string12;
        this.mimeType = string13;
        this.binaryData = byArray;
        this.affiliateID = string14;
        this.iTunesID = string15;
        this.iTunesFrontID = n;
        this.podcastFeedURL = n2;
        this.unknownData = string16;
        this.stationURL = string17;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getPi() {
        return this.pi;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public String getAlbumTitle() {
        return this.albumTitle;
    }

    public String getSongTitle() {
        return this.songTitle;
    }

    public String getGenre() {
        return this.genre;
    }

    public ResourceLocator getStationArt() {
        return this.stationArt;
    }

    public ResourceLocator getCoverArt() {
        return this.coverArt;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public String getContentField() {
        return this.contentField;
    }

    public String getPrice() {
        return this.price;
    }

    public String getValidUntil() {
        return this.validUntil;
    }

    public String getContactURL() {
        return this.contactURL;
    }

    public short getReceivedAs() {
        return this.receivedAs;
    }

    public String getNameOfSeller() {
        return this.nameOfSeller;
    }

    public String getComrDescription() {
        return this.comrDescription;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public byte[] getBinaryData() {
        return this.binaryData;
    }

    public String getAffiliateID() {
        return this.affiliateID;
    }

    public String getITunesID() {
        return this.iTunesID;
    }

    public int getITunesFrontID() {
        return this.iTunesFrontID;
    }

    public int getPodcastFeedURL() {
        return this.podcastFeedURL;
    }

    public String getUnknownData() {
        return this.unknownData;
    }

    public String getStationURL() {
        return this.stationURL;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3800);
        stringBuffer.append("HdStationInfo");
        stringBuffer.append('(');
        stringBuffer.append("artistName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.artistName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("albumTitle");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.albumTitle);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("songTitle");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.songTitle);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("genre");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.genre);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("stationArt");
        stringBuffer.append('=');
        stringBuffer.append(this.stationArt);
        stringBuffer.append(',');
        stringBuffer.append("coverArt");
        stringBuffer.append('=');
        stringBuffer.append(this.coverArt);
        stringBuffer.append(',');
        stringBuffer.append("language");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.language);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("shortDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("contentField");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.contentField);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("price");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.price);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("validUntil");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.validUntil);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("contactURL");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.contactURL);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("receivedAs");
        stringBuffer.append('=');
        stringBuffer.append(this.receivedAs);
        stringBuffer.append(',');
        stringBuffer.append("nameOfSeller");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.nameOfSeller);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("comrDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.comrDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("mimeType");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mimeType);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("binaryData");
        stringBuffer.append('[');
        if (this.binaryData != null) {
            stringBuffer.append(this.binaryData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.binaryData != null) {
            int n = this.binaryData.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.binaryData[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.binaryData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("affiliateID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.affiliateID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("iTunesID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.iTunesID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("iTunesFrontID");
        stringBuffer.append('=');
        stringBuffer.append(this.iTunesFrontID);
        stringBuffer.append(',');
        stringBuffer.append("podcastFeedURL");
        stringBuffer.append('=');
        stringBuffer.append(this.podcastFeedURL);
        stringBuffer.append(',');
        stringBuffer.append("unknownData");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.unknownData);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(',');
        stringBuffer.append("pi");
        stringBuffer.append('=');
        stringBuffer.append(this.pi);
        stringBuffer.append(',');
        stringBuffer.append("serviceId");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceId);
        stringBuffer.append(',');
        stringBuffer.append("stationURL");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stationURL);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

