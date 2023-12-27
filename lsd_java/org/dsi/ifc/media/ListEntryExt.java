/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.global.ResourceLocator;

public class ListEntryExt {
    public String album;
    public long albumID;
    public String artist;
    public long artistID;
    public ResourceLocator coverArtResource;
    public long titleID;
    public int fileCount;
    public int folderCount;
    public int playlistCount;

    public ListEntryExt() {
        this.album = null;
        this.albumID = 0L;
        this.artist = null;
        this.artistID = 0L;
        this.coverArtResource = null;
        this.titleID = 0L;
        this.fileCount = 0;
        this.folderCount = 0;
        this.playlistCount = 0;
    }

    public ListEntryExt(String string, long l, String string2, long l2, ResourceLocator resourceLocator, long l3, int n, int n2, int n3) {
        this.album = string;
        this.albumID = l;
        this.artist = string2;
        this.artistID = l2;
        this.coverArtResource = resourceLocator;
        this.titleID = l3;
        this.fileCount = n;
        this.folderCount = n2;
        this.playlistCount = n3;
    }

    public long getArtistID() {
        return this.artistID;
    }

    public long getAlbumID() {
        return this.albumID;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getAlbum() {
        return this.album;
    }

    public ResourceLocator getCoverArtResource() {
        return this.coverArtResource;
    }

    public long getTitleID() {
        return this.titleID;
    }

    public int getFileCount() {
        return this.fileCount;
    }

    public int getFolderCount() {
        return this.folderCount;
    }

    public int getPlaylistCount() {
        return this.playlistCount;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1550);
        stringBuffer.append("ListEntryExt");
        stringBuffer.append('(');
        stringBuffer.append("album");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.album);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("albumID");
        stringBuffer.append('=');
        stringBuffer.append(this.albumID);
        stringBuffer.append(',');
        stringBuffer.append("artist");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.artist);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("artistID");
        stringBuffer.append('=');
        stringBuffer.append(this.artistID);
        stringBuffer.append(',');
        stringBuffer.append("coverArtResource");
        stringBuffer.append('=');
        stringBuffer.append(this.coverArtResource);
        stringBuffer.append(',');
        stringBuffer.append("titleID");
        stringBuffer.append('=');
        stringBuffer.append(this.titleID);
        stringBuffer.append(',');
        stringBuffer.append("fileCount");
        stringBuffer.append('=');
        stringBuffer.append(this.fileCount);
        stringBuffer.append(',');
        stringBuffer.append("folderCount");
        stringBuffer.append('=');
        stringBuffer.append(this.folderCount);
        stringBuffer.append(',');
        stringBuffer.append("playlistCount");
        stringBuffer.append('=');
        stringBuffer.append(this.playlistCount);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

