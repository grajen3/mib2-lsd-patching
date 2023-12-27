/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlife;

public class TrackData {
    public String source;
    public String title;
    public int duration;
    public String album;
    public String artist;
    public String playlistNum;
    public String songid;

    public TrackData() {
        this.source = "";
        this.title = "";
        this.duration = 0;
        this.album = "";
        this.artist = "";
        this.playlistNum = "";
        this.songid = "";
    }

    public TrackData(String string, String string2, int n, String string3, String string4, String string5, String string6) {
        this.source = string;
        this.title = string2;
        this.duration = n;
        this.album = string3;
        this.artist = string4;
        this.playlistNum = string5;
        this.songid = string6;
    }

    public String getSource() {
        return this.source;
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

    public String getPlaylistNum() {
        return this.playlistNum;
    }

    public String getSongid() {
        return this.songid;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("TrackData");
        stringBuffer.append('(');
        stringBuffer.append("source");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.source);
        stringBuffer.append('\"');
        stringBuffer.append(',');
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
        stringBuffer.append("playlistNum");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.playlistNum);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("songid");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.songid);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

