/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.media.ChapterInfo;

public class EntryInfo {
    public long entryID;
    public String filename;
    public int contentType;
    public String title;
    public long trackNo;
    public long numTracks;
    public long albumID;
    public long artistID;
    public long genreID;
    public String album;
    public String artist;
    public String genre;
    public String year;
    public String comments;
    public long avgBitrate;
    public long samplingrate;
    public int rating;
    public int flags;
    public ChapterInfo chapterInfo;

    public EntryInfo() {
        this.entryID = 0L;
        this.filename = null;
        this.contentType = 0;
        this.title = null;
        this.trackNo = 0L;
        this.numTracks = 0L;
        this.albumID = 0L;
        this.artistID = 0L;
        this.genreID = 0L;
        this.album = null;
        this.artist = null;
        this.genre = null;
        this.year = null;
        this.comments = null;
        this.avgBitrate = 0L;
        this.samplingrate = 0L;
        this.rating = 0;
        this.flags = 0;
        this.chapterInfo = null;
    }

    public EntryInfo(long l, String string, int n, String string2, long l2, long l3, long l4, long l5, long l6, String string3, String string4, String string5, String string6, String string7, long l7, long l8, int n2, int n3, ChapterInfo chapterInfo) {
        this.entryID = l;
        this.filename = string;
        this.contentType = n;
        this.title = string2;
        this.trackNo = l2;
        this.numTracks = l3;
        this.albumID = l4;
        this.artistID = l5;
        this.genreID = l6;
        this.album = string3;
        this.artist = string4;
        this.genre = string5;
        this.year = string6;
        this.comments = string7;
        this.avgBitrate = l7;
        this.samplingrate = l8;
        this.rating = n2;
        this.flags = n3;
        this.chapterInfo = chapterInfo;
    }

    public long getEntryID() {
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

    public long getAlbumID() {
        return this.albumID;
    }

    public long getArtistID() {
        return this.artistID;
    }

    public long getGenreID() {
        return this.genreID;
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

    public ChapterInfo getChapterInfo() {
        return this.chapterInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2250);
        stringBuffer.append("EntryInfo");
        stringBuffer.append('(');
        stringBuffer.append("entryID");
        stringBuffer.append('=');
        stringBuffer.append(this.entryID);
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
        stringBuffer.append("albumID");
        stringBuffer.append('=');
        stringBuffer.append(this.albumID);
        stringBuffer.append(',');
        stringBuffer.append("artistID");
        stringBuffer.append('=');
        stringBuffer.append(this.artistID);
        stringBuffer.append(',');
        stringBuffer.append("genreID");
        stringBuffer.append('=');
        stringBuffer.append(this.genreID);
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
        stringBuffer.append(',');
        stringBuffer.append("chapterInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.chapterInfo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

