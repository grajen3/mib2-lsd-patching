/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

public class SIAServiceData {
    public int distanceStatus;
    public int distance;
    public int distanceUnit;
    public int timeStatus;
    public int time;

    public int getDistanceStatus() {
        return this.distanceStatus;
    }

    public void setDistanceStatus(int n) {
        this.distanceStatus = n;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int n) {
        this.distance = n;
    }

    public int getDistanceUnit() {
        return this.distanceUnit;
    }

    public void setDistanceUnit(int n) {
        this.distanceUnit = n;
    }

    public int getTimeStatus() {
        return this.timeStatus;
    }

    public void setTimeStatus(int n) {
        this.timeStatus = n;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int n) {
        this.time = n;
    }

    public SIAServiceData() {
    }

    public SIAServiceData(int n, int n2, int n3, int n4, int n5) {
        this.distanceStatus = n;
        this.distance = n2;
        this.distanceUnit = n3;
        this.timeStatus = n4;
        this.time = n5;
    }

    public String toString() {
        return new StringBuffer("SIAServiceData{").append("distanceStatus=").append(this.distanceStatus).append(", distance=").append(this.distance).append(", distanceUnit=").append(this.distanceUnit).append(", timeStatus=").append(this.timeStatus).append(", time=").append(this.time).append("}").toString();
    }
}

