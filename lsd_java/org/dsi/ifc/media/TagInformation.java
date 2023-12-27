/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.global.DateTime;

public class TagInformation {
    public boolean ambiguousTag;
    public boolean buttonPressed;
    public String title;
    public String artist;
    public String songID;
    public String stationFrequency;
    public String stationCallLetters;
    public String stationURL;
    public DateTime timeStamp;
    public String affiliateID;
    public String album;
    public int iTunesFrontID;
    public int podcastFeedURL;
    public String genre;
    public String unknownData;
    public int programNumber;

    public TagInformation() {
        this.ambiguousTag = false;
        this.buttonPressed = false;
        this.title = null;
        this.artist = null;
        this.songID = null;
        this.stationFrequency = null;
        this.stationCallLetters = null;
        this.stationURL = null;
        this.timeStamp = null;
        this.affiliateID = null;
        this.album = null;
        this.iTunesFrontID = 0;
        this.podcastFeedURL = 0;
        this.genre = null;
        this.unknownData = null;
        this.programNumber = 0;
    }

    public TagInformation(boolean bl, boolean bl2, String string, String string2, String string3, String string4, String string5, String string6, DateTime dateTime, String string7, String string8, int n, int n2, String string9, String string10, int n3) {
        this.ambiguousTag = bl;
        this.buttonPressed = bl2;
        this.title = string;
        this.artist = string2;
        this.songID = string3;
        this.stationFrequency = string4;
        this.stationCallLetters = string5;
        this.stationURL = string6;
        this.timeStamp = dateTime;
        this.affiliateID = string7;
        this.album = string8;
        this.iTunesFrontID = n;
        this.podcastFeedURL = n2;
        this.genre = string9;
        this.unknownData = string10;
        this.programNumber = n3;
    }

    public boolean isAmbiguousTag() {
        return this.ambiguousTag;
    }

    public boolean isButtonPressed() {
        return this.buttonPressed;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getSongID() {
        return this.songID;
    }

    public String getStationFrequency() {
        return this.stationFrequency;
    }

    public String getStationCallLetters() {
        return this.stationCallLetters;
    }

    public String getStationURL() {
        return this.stationURL;
    }

    public DateTime getTimeStamp() {
        return this.timeStamp;
    }

    public String getAffiliateID() {
        return this.affiliateID;
    }

    public String getAlbum() {
        return this.album;
    }

    public int getITunesFrontID() {
        return this.iTunesFrontID;
    }

    public int getPodcastFeedURL() {
        return this.podcastFeedURL;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getUnknownData() {
        return this.unknownData;
    }

    public int getProgramNumber() {
        return this.programNumber;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2100);
        stringBuffer.append("TagInformation");
        stringBuffer.append('(');
        stringBuffer.append("ambiguousTag");
        stringBuffer.append('=');
        stringBuffer.append(this.ambiguousTag);
        stringBuffer.append(',');
        stringBuffer.append("buttonPressed");
        stringBuffer.append('=');
        stringBuffer.append(this.buttonPressed);
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("artist");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.artist);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("songID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.songID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("stationFrequency");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stationFrequency);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("stationCallLetters");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stationCallLetters);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("stationURL");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stationURL);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("timeStamp");
        stringBuffer.append('=');
        stringBuffer.append(this.timeStamp);
        stringBuffer.append(',');
        stringBuffer.append("affiliateID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.affiliateID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("album");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.album);
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
        stringBuffer.append("genre");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.genre);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("unknownData");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.unknownData);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("programNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.programNumber);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

