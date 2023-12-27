/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

public class CurrentStation {
    public long id;
    public String name;
    public String fullName;
    public String artist;
    public int artistType;
    public String title;
    public int titleType;
    public String image;
    public int audioStatus;
    public int layer;
    public String album;
    public String radioText;
    public String extension;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String string) {
        this.fullName = string;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String string) {
        this.artist = string;
    }

    public int getArtistType() {
        return this.artistType;
    }

    public void setArtistType(int n) {
        this.artistType = n;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public int getTitleType() {
        return this.titleType;
    }

    public void setTitleType(int n) {
        this.titleType = n;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String string) {
        this.image = string;
    }

    public int getAudioStatus() {
        return this.audioStatus;
    }

    public void setAudioStatus(int n) {
        this.audioStatus = n;
    }

    public int getLayer() {
        return this.layer;
    }

    public void setLayer(int n) {
        this.layer = n;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String string) {
        this.album = string;
    }

    public String getRadioText() {
        return this.radioText;
    }

    public void setRadioText(String string) {
        this.radioText = string;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String string) {
        this.extension = string;
    }

    public CurrentStation() {
    }

    public CurrentStation(long l, String string, String string2, String string3, int n, String string4, int n2, String string5, int n3, int n4, String string6, String string7, String string8) {
        this.id = l;
        this.name = string;
        this.fullName = string2;
        this.artist = string3;
        this.artistType = n;
        this.title = string4;
        this.titleType = n2;
        this.image = string5;
        this.audioStatus = n3;
        this.layer = n4;
        this.album = string6;
        this.radioText = string7;
        this.extension = string8;
    }

    public String toString() {
        return new StringBuffer("CurrentStation{").append("id=").append(this.id).append(", name=").append(this.name).append(", fullName=").append(this.fullName).append(", artist=").append(this.artist).append(", artistType=").append(this.artistType).append(", title=").append(this.title).append(", titleType=").append(this.titleType).append(", image=").append(this.image).append(", audioStatus=").append(this.audioStatus).append(", layer=").append(this.layer).append(", album=").append(this.album).append(", radioText=").append(this.radioText).append(", extension=").append(this.extension).append("}").toString();
    }
}

