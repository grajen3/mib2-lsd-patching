/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

public class CarPosition {
    public double longitude;
    public double latitude;
    public int angle;
    public int speed;
    public int height;

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public int getAngle() {
        return this.angle;
    }

    public void setAngle(int n) {
        this.angle = n;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int n) {
        this.speed = n;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public CarPosition() {
    }

    public CarPosition(double d2, double d3, int n, int n2, int n3) {
        this.longitude = d2;
        this.latitude = d3;
        this.angle = n;
        this.speed = n2;
        this.height = n3;
    }

    public String toString() {
        return new StringBuffer("CarPosition{").append("longitude=").append(this.longitude).append(", latitude=").append(this.latitude).append(", angle=").append(this.angle).append(", speed=").append(this.speed).append(", height=").append(this.height).append("}").toString();
    }
}

