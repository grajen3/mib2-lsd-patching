/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.albumbrowser;

public class AlbumEntryInfo {
    public long albumIdx;
    public long artistID;
    public String artist;
    public long albumID;
    public String album;
    public int flags;

    public AlbumEntryInfo() {
        this.albumIdx = 0L;
        this.artistID = 0L;
        this.artist = null;
        this.albumID = 0L;
        this.album = null;
        this.flags = 0;
    }

    public AlbumEntryInfo(long l, long l2, String string, long l3, String string2, int n) {
        this.albumIdx = l;
        this.artistID = l2;
        this.artist = string;
        this.albumID = l3;
        this.album = string2;
        this.flags = n;
    }

    public long getAlbumIdx() {
        return this.albumIdx;
    }

    public long getArtistID() {
        return this.artistID;
    }

    public String getArtist() {
        return this.artist;
    }

    public long getAlbumID() {
        return this.albumID;
    }

    public String getAlbum() {
        return this.album;
    }

    public int getFlags() {
        return this.flags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("AlbumEntryInfo");
        stringBuffer.append('(');
        stringBuffer.append("albumIdx");
        stringBuffer.append('=');
        stringBuffer.append(this.albumIdx);
        stringBuffer.append(',');
        stringBuffer.append("artistID");
        stringBuffer.append('=');
        stringBuffer.append(this.artistID);
        stringBuffer.append(',');
        stringBuffer.append("artist");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.artist);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("albumID");
        stringBuffer.append('=');
        stringBuffer.append(this.albumID);
        stringBuffer.append(',');
        stringBuffer.append("album");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.album);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("flags");
        stringBuffer.append('=');
        stringBuffer.append(this.flags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

