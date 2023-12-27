/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto2;

public class TrackData {
    public String title;
    public int duration;
    public String album;
    public String artist;
    public String genre;
    public String composer;

    public TrackData() {
        this.title = "";
        this.duration = 0;
        this.album = "";
        this.artist = "";
        this.genre = "";
        this.composer = "";
    }

    public TrackData(String string, int n, String string2, String string3, String string4, String string5) {
        this.title = string;
        this.duration = n;
        this.album = string2;
        this.artist = string3;
        this.genre = string4;
        this.composer = string5;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getComposer() {
        return this.composer;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("TrackData");
        stringBuffer.append('(');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("duration");
        stringBuffer.append('=');
        stringBuffer.append(this.duration);
        stringBuffer.append(',');
        stringBuffer.append("album");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.album);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("artist");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.artist);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("genre");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.genre);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("composer");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.composer);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

