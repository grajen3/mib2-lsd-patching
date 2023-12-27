/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class RadioText {
    public short sID;
    public String shortArtistName;
    public String longArtistName;
    public String artistID;
    public String shortProgramTitle;
    public String longProgramTitle;
    public String programID;
    public String composer;
    public int iTunesID;

    public RadioText() {
        this.sID = 0;
        this.shortArtistName = null;
        this.longArtistName = null;
        this.artistID = null;
        this.shortProgramTitle = null;
        this.longProgramTitle = null;
        this.programID = null;
        this.composer = null;
        this.iTunesID = 0;
    }

    public RadioText(short s, String string, String string2, String string3, String string4, String string5, String string6, String string7, int n) {
        this.sID = s;
        this.shortArtistName = string;
        this.longArtistName = string2;
        this.artistID = string3;
        this.shortProgramTitle = string4;
        this.longProgramTitle = string5;
        this.programID = string6;
        this.composer = string7;
        this.iTunesID = n;
    }

    public short getSID() {
        return this.sID;
    }

    public String getShortArtistName() {
        return this.shortArtistName;
    }

    public String getLongArtistName() {
        return this.longArtistName;
    }

    public String getArtistID() {
        return this.artistID;
    }

    public String getShortProgramTitle() {
        return this.shortProgramTitle;
    }

    public String getLongProgramTitle() {
        return this.longProgramTitle;
    }

    public String getProgramID() {
        return this.programID;
    }

    public String getComposer() {
        return this.composer;
    }

    public int getITunesID() {
        return this.iTunesID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(700);
        stringBuffer.append("RadioText");
        stringBuffer.append('(');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("shortArtistName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortArtistName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("longArtistName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.longArtistName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("artistID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.artistID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("shortProgramTitle");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortProgramTitle);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("longProgramTitle");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.longProgramTitle);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("programID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.programID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("composer");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.composer);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("iTunesID");
        stringBuffer.append('=');
        stringBuffer.append(this.iTunesID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

