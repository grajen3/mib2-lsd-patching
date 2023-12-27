/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.global.ResourceLocator;

public class SearchListEntryExt {
    public long searchID;
    public long entryID;
    public String description;
    public int tagType;
    public long artistID;
    public String artist;
    public long albumID;
    public String album;
    public int flags;
    public ResourceLocator coverArtResource;

    public SearchListEntryExt() {
        this.searchID = 0L;
        this.entryID = 0L;
        this.description = null;
        this.tagType = 0;
        this.artistID = 0L;
        this.artist = null;
        this.albumID = 0L;
        this.album = null;
        this.flags = 0;
        this.coverArtResource = null;
    }

    public SearchListEntryExt(long l, long l2, String string, int n, long l3, String string2, long l4, String string3, int n2, ResourceLocator resourceLocator) {
        this.searchID = l;
        this.entryID = l2;
        this.description = string;
        this.tagType = n;
        this.artistID = l3;
        this.artist = string2;
        this.albumID = l4;
        this.album = string3;
        this.flags = n2;
        this.coverArtResource = resourceLocator;
    }

    public long getSearchID() {
        return this.searchID;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public String getDescription() {
        return this.description;
    }

    public int getTagType() {
        return this.tagType;
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

    public ResourceLocator getCoverArtResource() {
        return this.coverArtResource;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1650);
        stringBuffer.append("SearchListEntryExt");
        stringBuffer.append('(');
        stringBuffer.append("searchID");
        stringBuffer.append('=');
        stringBuffer.append(this.searchID);
        stringBuffer.append(',');
        stringBuffer.append("entryID");
        stringBuffer.append('=');
        stringBuffer.append(this.entryID);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("tagType");
        stringBuffer.append('=');
        stringBuffer.append(this.tagType);
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
        stringBuffer.append(',');
        stringBuffer.append("coverArtResource");
        stringBuffer.append('=');
        stringBuffer.append(this.coverArtResource);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

