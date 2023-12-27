/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class CoverartInfo {
    public String artist;
    public String album;
    public String title;

    public CoverartInfo() {
        this.artist = null;
        this.album = null;
        this.title = null;
    }

    public CoverartInfo(String string, String string2, String string3) {
        this.artist = string;
        this.album = string2;
        this.title = string3;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("CoverartInfo");
        stringBuffer.append('(');
        stringBuffer.append("artist");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.artist);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("album");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.album);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

