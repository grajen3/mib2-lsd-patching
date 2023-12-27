/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull;

public class sConfig {
    public int updatePeriod;
    public byte predLength;
    public int predDuration;
    public int coordinateSystem;
    public int deadrecEnabled;
    public int mapMatchingEnabled;
    public int nmeaPosEnabled;
    public int structPosEnabled;

    public int getUpdatePeriod() {
        return this.updatePeriod;
    }

    public void setUpdatePeriod(int n) {
        this.updatePeriod = n;
    }

    public byte getPredLength() {
        return this.predLength;
    }

    public void setPredLength(byte by) {
        this.predLength = by;
    }

    public int getPredDuration() {
        return this.predDuration;
    }

    public void setPredDuration(int n) {
        this.predDuration = n;
    }

    public int getCoordinateSystem() {
        return this.coordinateSystem;
    }

    public void setCoordinateSystem(int n) {
        this.coordinateSystem = n;
    }

    public int getDeadrecEnabled() {
        return this.deadrecEnabled;
    }

    public void setDeadrecEnabled(int n) {
        this.deadrecEnabled = n;
    }

    public int getMapMatchingEnabled() {
        return this.mapMatchingEnabled;
    }

    public void setMapMatchingEnabled(int n) {
        this.mapMatchingEnabled = n;
    }

    public int getNmeaPosEnabled() {
        return this.nmeaPosEnabled;
    }

    public void setNmeaPosEnabled(int n) {
        this.nmeaPosEnabled = n;
    }

    public int getStructPosEnabled() {
        return this.structPosEnabled;
    }

    public void setStructPosEnabled(int n) {
        this.structPosEnabled = n;
    }

    public sConfig() {
    }

    public sConfig(int n, byte by, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.updatePeriod = n;
        this.predLength = by;
        this.predDuration = n2;
        this.coordinateSystem = n3;
        this.deadrecEnabled = n4;
        this.mapMatchingEnabled = n5;
        this.nmeaPosEnabled = n6;
        this.structPosEnabled = n7;
    }

    public String toString() {
        return new StringBuffer("sConfig{").append("updatePeriod=").append(this.updatePeriod).append(", predLength=").append(this.predLength).append(", predDuration=").append(this.predDuration).append(", coordinateSystem=").append(this.coordinateSystem).append(", deadrecEnabled=").append(this.deadrecEnabled).append(", mapMatchingEnabled=").append(this.mapMatchingEnabled).append(", nmeaPosEnabled=").append(this.nmeaPosEnabled).append(", structPosEnabled=").append(this.structPosEnabled).append("}").toString();
    }
}

