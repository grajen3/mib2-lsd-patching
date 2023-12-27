/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

public class StationInfo {
    public long id;
    public String name;
    public String fullName;
    public int audioStatus;
    public int layer;
    public String stationLogo;
    public int frequency;
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

    public String getStationLogo() {
        return this.stationLogo;
    }

    public void setStationLogo(String string) {
        this.stationLogo = string;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int n) {
        this.frequency = n;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String string) {
        this.extension = string;
    }

    public StationInfo() {
    }

    public StationInfo(long l, String string, String string2, int n, int n2, String string3, int n3, String string4) {
        this.id = l;
        this.name = string;
        this.fullName = string2;
        this.audioStatus = n;
        this.layer = n2;
        this.stationLogo = string3;
        this.frequency = n3;
        this.extension = string4;
    }

    public String toString() {
        return new StringBuffer("StationInfo{").append("id=").append(this.id).append(", name=").append(this.name).append(", fullName=").append(this.fullName).append(", audioStatus=").append(this.audioStatus).append(", layer=").append(this.layer).append(", stationLogo=").append(this.stationLogo).append(", frequency=").append(this.frequency).append(", extension=").append(this.extension).append("}").toString();
    }
}

