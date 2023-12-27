/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class PosPosition {
    public int state;
    public double vdop;
    public double hdop;
    public double pdop;
    public int longitude;
    public int latitude;
    public int directionSymbolic;
    public int directionAngle;
    public int speed;
    public int reliability;
    public int height;
    public short visibleSatellites;
    public short usedSatellites;
    public int roadClass;

    public PosPosition() {
        this.state = 0;
        this.vdop = 0.0;
        this.hdop = 0.0;
        this.pdop = 0.0;
        this.longitude = 0;
        this.latitude = 0;
        this.directionSymbolic = 0;
        this.directionAngle = 0;
        this.speed = 0;
        this.reliability = 0;
        this.height = 0;
        this.visibleSatellites = 0;
        this.usedSatellites = 0;
        this.roadClass = 0;
    }

    public PosPosition(int n, double d2, double d3, double d4, int n2, int n3, int n4, int n5, int n6, int n7, int n8, short s, short s2, int n9) {
        this.state = n;
        this.vdop = d2;
        this.hdop = d3;
        this.pdop = d4;
        this.longitude = n2;
        this.latitude = n3;
        this.directionSymbolic = n4;
        this.directionAngle = n5;
        this.speed = n6;
        this.reliability = n7;
        this.height = n8;
        this.visibleSatellites = s;
        this.usedSatellites = s2;
        this.roadClass = n9;
    }

    public int getState() {
        return this.state;
    }

    public double getVdop() {
        return this.vdop;
    }

    public double getHdop() {
        return this.hdop;
    }

    public double getPdop() {
        return this.pdop;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getDirectionSymbolic() {
        return this.directionSymbolic;
    }

    public int getDirectionAngle() {
        return this.directionAngle;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getReliability() {
        return this.reliability;
    }

    public final boolean isCalibrated() {
        return (this.reliability & 0x200) > 0;
    }

    public final boolean isMatchedToDigitalMap() {
        return (this.reliability & 0x400) > 0;
    }

    public final boolean isInsideDigitizedArea() {
        return (this.reliability & 0x1000) > 0;
    }

    public int getHeight() {
        return this.height;
    }

    public short getVisibleSatellites() {
        return this.visibleSatellites;
    }

    public short getUsedSatellites() {
        return this.usedSatellites;
    }

    public int getRoadClass() {
        return this.roadClass;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(650);
        stringBuffer.append("PosPosition");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("vdop");
        stringBuffer.append('=');
        stringBuffer.append(this.vdop);
        stringBuffer.append(',');
        stringBuffer.append("hdop");
        stringBuffer.append('=');
        stringBuffer.append(this.hdop);
        stringBuffer.append(',');
        stringBuffer.append("pdop");
        stringBuffer.append('=');
        stringBuffer.append(this.pdop);
        stringBuffer.append(',');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("directionSymbolic");
        stringBuffer.append('=');
        stringBuffer.append(this.directionSymbolic);
        stringBuffer.append(',');
        stringBuffer.append("directionAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.directionAngle);
        stringBuffer.append(',');
        stringBuffer.append("speed");
        stringBuffer.append('=');
        stringBuffer.append(this.speed);
        stringBuffer.append(',');
        stringBuffer.append("reliability");
        stringBuffer.append('=');
        stringBuffer.append(this.reliability);
        stringBuffer.append(',');
        stringBuffer.append("height");
        stringBuffer.append('=');
        stringBuffer.append(this.height);
        stringBuffer.append(',');
        stringBuffer.append("visibleSatellites");
        stringBuffer.append('=');
        stringBuffer.append(this.visibleSatellites);
        stringBuffer.append(',');
        stringBuffer.append("usedSatellites");
        stringBuffer.append('=');
        stringBuffer.append(this.usedSatellites);
        stringBuffer.append(',');
        stringBuffer.append("roadClass");
        stringBuffer.append('=');
        stringBuffer.append(this.roadClass);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

