/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

public class AdBlueInfo {
    public int range;
    public int rangeUnit;
    public int level;
    public int tankVolume;
    public int state;
    public int volumeUnit;
    public int minRefill;
    public int maxRefill;

    public int getRange() {
        return this.range;
    }

    public void setRange(int n) {
        this.range = n;
    }

    public int getRangeUnit() {
        return this.rangeUnit;
    }

    public void setRangeUnit(int n) {
        this.rangeUnit = n;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int n) {
        this.level = n;
    }

    public int getTankVolume() {
        return this.tankVolume;
    }

    public void setTankVolume(int n) {
        this.tankVolume = n;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public int getVolumeUnit() {
        return this.volumeUnit;
    }

    public void setVolumeUnit(int n) {
        this.volumeUnit = n;
    }

    public int getMinRefill() {
        return this.minRefill;
    }

    public void setMinRefill(int n) {
        this.minRefill = n;
    }

    public int getMaxRefill() {
        return this.maxRefill;
    }

    public void setMaxRefill(int n) {
        this.maxRefill = n;
    }

    public AdBlueInfo() {
    }

    public AdBlueInfo(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.range = n;
        this.rangeUnit = n2;
        this.level = n3;
        this.tankVolume = n4;
        this.state = n5;
        this.volumeUnit = n6;
        this.minRefill = n7;
        this.maxRefill = n8;
    }

    public String toString() {
        return new StringBuffer("AdBlueInfo{").append("range=").append(this.range).append(", rangeUnit=").append(this.rangeUnit).append(", level=").append(this.level).append(", tankVolume=").append(this.tankVolume).append(", state=").append(this.state).append(", volumeUnit=").append(this.volumeUnit).append(", minRefill=").append(this.minRefill).append(", maxRefill=").append(this.maxRefill).append("}").toString();
    }
}

