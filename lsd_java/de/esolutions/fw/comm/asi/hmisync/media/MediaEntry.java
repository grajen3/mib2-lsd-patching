/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaI18NString;

public class MediaEntry {
    public long id;
    public int type;
    public MediaI18NString title;
    public MediaI18NString artist;
    public long artistID;
    public MediaI18NString album;
    public long albumID;
    public long genreID;
    public String coverUrl;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    public MediaI18NString getTitle() {
        return this.title;
    }

    public void setTitle(MediaI18NString mediaI18NString) {
        this.title = mediaI18NString;
    }

    public MediaI18NString getArtist() {
        return this.artist;
    }

    public void setArtist(MediaI18NString mediaI18NString) {
        this.artist = mediaI18NString;
    }

    public long getArtistID() {
        return this.artistID;
    }

    public void setArtistID(long l) {
        this.artistID = l;
    }

    public MediaI18NString getAlbum() {
        return this.album;
    }

    public void setAlbum(MediaI18NString mediaI18NString) {
        this.album = mediaI18NString;
    }

    public long getAlbumID() {
        return this.albumID;
    }

    public void setAlbumID(long l) {
        this.albumID = l;
    }

    public long getGenreID() {
        return this.genreID;
    }

    public void setGenreID(long l) {
        this.genreID = l;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public void setCoverUrl(String string) {
        this.coverUrl = string;
    }

    public MediaEntry() {
        this.title = null;
        this.artist = null;
        this.album = null;
    }

    public MediaEntry(long l, int n, MediaI18NString mediaI18NString, MediaI18NString mediaI18NString2, long l2, MediaI18NString mediaI18NString3, long l3, long l4, String string) {
        this.id = l;
        this.type = n;
        this.title = mediaI18NString;
        this.artist = mediaI18NString2;
        this.artistID = l2;
        this.album = mediaI18NString3;
        this.albumID = l3;
        this.genreID = l4;
        this.coverUrl = string;
    }

    public String toString() {
        return new StringBuffer("MediaEntry{").append("id=").append(this.id).append(", type=").append(this.type).append(", title=").append(this.title).append(", artist=").append(this.artist).append(", artistID=").append(this.artistID).append(", album=").append(this.album).append(", albumID=").append(this.albumID).append(", genreID=").append(this.genreID).append(", coverUrl=").append(this.coverUrl).append("}").toString();
    }
}

