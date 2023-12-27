/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class FCDPosition {
    public long timestamp;
    public double lon;
    public double lat;
    public int formOfWay;
    public int functionalRoadClass;
    public String roadNumber;
    public int heading;
    public int speed;
    public int temperature;
    public int rain;
    public long validBitArray;

    public FCDPosition() {
        this.timestamp = 0L;
        this.lon = 0.0;
        this.lat = 0.0;
        this.formOfWay = 0;
        this.functionalRoadClass = 0;
        this.roadNumber = null;
        this.heading = 0;
        this.speed = 0;
        this.temperature = 0;
        this.rain = 0;
        this.validBitArray = 0L;
    }

    public FCDPosition(long l, double d2, double d3, int n, int n2, String string, int n3, int n4, int n5, int n6, long l2) {
        this.timestamp = l;
        this.lon = d2;
        this.lat = d3;
        this.formOfWay = n;
        this.functionalRoadClass = n2;
        this.roadNumber = string;
        this.heading = n3;
        this.speed = n4;
        this.temperature = n5;
        this.rain = n6;
        this.validBitArray = l2;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public double getLon() {
        return this.lon;
    }

    public double getLat() {
        return this.lat;
    }

    public int getFormOfWay() {
        return this.formOfWay;
    }

    public int getFunctionalRoadClass() {
        return this.functionalRoadClass;
    }

    public String getRoadNumber() {
        return this.roadNumber;
    }

    public int getHeading() {
        return this.heading;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getRain() {
        return this.rain;
    }

    public long getValidBitArray() {
        return this.validBitArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("FCDPosition");
        stringBuffer.append('(');
        stringBuffer.append("timestamp");
        stringBuffer.append('=');
        stringBuffer.append(this.timestamp);
        stringBuffer.append(',');
        stringBuffer.append("lon");
        stringBuffer.append('=');
        stringBuffer.append(this.lon);
        stringBuffer.append(',');
        stringBuffer.append("lat");
        stringBuffer.append('=');
        stringBuffer.append(this.lat);
        stringBuffer.append(',');
        stringBuffer.append("formOfWay");
        stringBuffer.append('=');
        stringBuffer.append(this.formOfWay);
        stringBuffer.append(',');
        stringBuffer.append("functionalRoadClass");
        stringBuffer.append('=');
        stringBuffer.append(this.functionalRoadClass);
        stringBuffer.append(',');
        stringBuffer.append("roadNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("heading");
        stringBuffer.append('=');
        stringBuffer.append(this.heading);
        stringBuffer.append(',');
        stringBuffer.append("speed");
        stringBuffer.append('=');
        stringBuffer.append(this.speed);
        stringBuffer.append(',');
        stringBuffer.append("temperature");
        stringBuffer.append('=');
        stringBuffer.append(this.temperature);
        stringBuffer.append(',');
        stringBuffer.append("rain");
        stringBuffer.append('=');
        stringBuffer.append(this.rain);
        stringBuffer.append(',');
        stringBuffer.append("validBitArray");
        stringBuffer.append('=');
        stringBuffer.append(this.validBitArray);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

