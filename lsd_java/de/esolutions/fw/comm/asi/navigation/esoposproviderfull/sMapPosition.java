/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sPosition;

public class sMapPosition {
    public sPosition position;
    public float horzStdDev;
    public float headingStdDev;
    public float altitude;
    public float velocity;
    public float velocityStdDev;
    public long odometer;
    public int isOnMap;
    public int isOnRoad;
    public int isInTunnel;
    public String streetName;
    public short numSatInView;
    public short numSatInUse;

    public sPosition getPosition() {
        return this.position;
    }

    public void setPosition(sPosition sPosition2) {
        this.position = sPosition2;
    }

    public float getHorzStdDev() {
        return this.horzStdDev;
    }

    public void setHorzStdDev(float f2) {
        this.horzStdDev = f2;
    }

    public float getHeadingStdDev() {
        return this.headingStdDev;
    }

    public void setHeadingStdDev(float f2) {
        this.headingStdDev = f2;
    }

    public float getAltitude() {
        return this.altitude;
    }

    public void setAltitude(float f2) {
        this.altitude = f2;
    }

    public float getVelocity() {
        return this.velocity;
    }

    public void setVelocity(float f2) {
        this.velocity = f2;
    }

    public float getVelocityStdDev() {
        return this.velocityStdDev;
    }

    public void setVelocityStdDev(float f2) {
        this.velocityStdDev = f2;
    }

    public long getOdometer() {
        return this.odometer;
    }

    public void setOdometer(long l) {
        this.odometer = l;
    }

    public int getIsOnMap() {
        return this.isOnMap;
    }

    public void setIsOnMap(int n) {
        this.isOnMap = n;
    }

    public int getIsOnRoad() {
        return this.isOnRoad;
    }

    public void setIsOnRoad(int n) {
        this.isOnRoad = n;
    }

    public int getIsInTunnel() {
        return this.isInTunnel;
    }

    public void setIsInTunnel(int n) {
        this.isInTunnel = n;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String string) {
        this.streetName = string;
    }

    public short getNumSatInView() {
        return this.numSatInView;
    }

    public void setNumSatInView(short s) {
        this.numSatInView = s;
    }

    public short getNumSatInUse() {
        return this.numSatInUse;
    }

    public void setNumSatInUse(short s) {
        this.numSatInUse = s;
    }

    public sMapPosition() {
        this.position = null;
    }

    public sMapPosition(sPosition sPosition2, float f2, float f3, float f4, float f5, float f6, long l, int n, int n2, int n3, String string, short s, short s2) {
        this.position = sPosition2;
        this.horzStdDev = f2;
        this.headingStdDev = f3;
        this.altitude = f4;
        this.velocity = f5;
        this.velocityStdDev = f6;
        this.odometer = l;
        this.isOnMap = n;
        this.isOnRoad = n2;
        this.isInTunnel = n3;
        this.streetName = string;
        this.numSatInView = s;
        this.numSatInUse = s2;
    }

    public String toString() {
        return new StringBuffer("sMapPosition{").append("position=").append(this.position).append(", horzStdDev=").append(this.horzStdDev).append(", headingStdDev=").append(this.headingStdDev).append(", altitude=").append(this.altitude).append(", velocity=").append(this.velocity).append(", velocityStdDev=").append(this.velocityStdDev).append(", odometer=").append(this.odometer).append(", isOnMap=").append(this.isOnMap).append(", isOnRoad=").append(this.isOnRoad).append(", isInTunnel=").append(this.isInTunnel).append(", streetName=").append(this.streetName).append(", numSatInView=").append(this.numSatInView).append(", numSatInUse=").append(this.numSatInUse).append("}").toString();
    }
}

