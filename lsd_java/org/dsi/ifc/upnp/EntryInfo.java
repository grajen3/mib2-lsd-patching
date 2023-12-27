/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.upnp;

public class EntryInfo {
    public String entryID;
    public String filename;
    public int contentType;
    public String title;
    public long trackNo;
    public long numTracks;
    public String album;
    public String artist;
    public String genre;
    public String year;
    public String comments;
    public long avgBitrate;
    public long samplingrate;
    public int rating;
    public int flags;

    public EntryInfo() {
        this.entryID = null;
        this.filename = null;
        this.contentType = 0;
        this.title = null;
        this.trackNo = 0L;
        this.numTracks = 0L;
        this.album = null;
        this.artist = null;
        this.genre = null;
        this.year = null;
        this.comments = null;
        this.avgBitrate = 0L;
        this.samplingrate = 0L;
        this.rating = 0;
        this.flags = 0;
    }

    public EntryInfo(String string, String string2, int n, String string3, long l, long l2, String string4, String string5, String string6, String string7, String string8, long l3, long l4, int n2, int n3) {
        this.entryID = string;
        this.filename = string2;
        this.contentType = n;
        this.title = string3;
        this.trackNo = l;
        this.numTracks = l2;
        this.album = string4;
        this.artist = string5;
        this.genre = string6;
        this.year = string7;
        this.comments = string8;
        this.avgBitrate = l3;
        this.samplingrate = l4;
        this.rating = n2;
        this.flags = n3;
    }

    public String getEntryID() {
        return this.entryID;
    }

    public String getFilename() {
        return this.filename;
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTrackNo() {
        return this.trackNo;
    }

    public long getNumTracks() {
        return this.numTracks;
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

    public String getYear() {
        return this.year;
    }

    public String getComments() {
        return this.comments;
    }

    public long getAvgBitrate() {
        return this.avgBitrate;
    }

    public long getSamplingrate() {
        return this.samplingrate;
    }

    public int getRating() {
        return this.rating;
    }

    public int getFlags() {
        return this.flags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.append("EntryInfo");
        stringBuffer.append('(');
        stringBuffer.append("entryID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.entryID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("filename");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.filename);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("contentType");
        stringBuffer.append('=');
        stringBuffer.append(this.contentType);
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("trackNo");
        stringBuffer.append('=');
        stringBuffer.append(this.trackNo);
        stringBuffer.append(',');
        stringBuffer.append("numTracks");
        stringBuffer.append('=');
        stringBuffer.append(this.numTracks);
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
        stringBuffer.append("year");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.year);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("comments");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.comments);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("avgBitrate");
        stringBuffer.append('=');
        stringBuffer.append(this.avgBitrate);
        stringBuffer.append(',');
        stringBuffer.append("samplingrate");
        stringBuffer.append('=');
        stringBuffer.append(this.samplingrate);
        stringBuffer.append(',');
        stringBuffer.append("rating");
        stringBuffer.append('=');
        stringBuffer.append(this.rating);
        stringBuffer.append(',');
        stringBuffer.append("flags");
        stringBuffer.append('=');
        stringBuffer.append(this.flags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

