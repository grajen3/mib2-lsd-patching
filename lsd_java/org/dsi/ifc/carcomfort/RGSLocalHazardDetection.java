/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class RGSLocalHazardDetection {
    public short eventClass;
    public int eventTransaction;
    public int eventQuality;
    public int eventCourse;
    public float eventPositionLatitude;
    public float eventPositionLongitude;

    public RGSLocalHazardDetection() {
        this.eventClass = 0;
        this.eventTransaction = 0;
        this.eventQuality = 0;
        this.eventCourse = 0;
        this.eventPositionLatitude = 0.0f;
        this.eventPositionLongitude = 0.0f;
    }

    public RGSLocalHazardDetection(short s, int n, int n2, int n3, float f2, float f3) {
        this.eventClass = s;
        this.eventTransaction = n;
        this.eventQuality = n2;
        this.eventCourse = n3;
        this.eventPositionLatitude = f2;
        this.eventPositionLongitude = f3;
    }

    public short getEventClass() {
        return this.eventClass;
    }

    public int getEventTransaction() {
        return this.eventTransaction;
    }

    public int getEventQuality() {
        return this.eventQuality;
    }

    public int getEventCourse() {
        return this.eventCourse;
    }

    public float getEventPositionLatitude() {
        return this.eventPositionLatitude;
    }

    public float getEventPositionLongitude() {
        return this.eventPositionLongitude;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("RGSLocalHazardDetection");
        stringBuffer.append('(');
        stringBuffer.append("eventClass");
        stringBuffer.append('=');
        stringBuffer.append(this.eventClass);
        stringBuffer.append(',');
        stringBuffer.append("eventTransaction");
        stringBuffer.append('=');
        stringBuffer.append(this.eventTransaction);
        stringBuffer.append(',');
        stringBuffer.append("eventQuality");
        stringBuffer.append('=');
        stringBuffer.append(this.eventQuality);
        stringBuffer.append(',');
        stringBuffer.append("eventCourse");
        stringBuffer.append('=');
        stringBuffer.append(this.eventCourse);
        stringBuffer.append(',');
        stringBuffer.append("eventPositionLatitude");
        stringBuffer.append('=');
        stringBuffer.append(this.eventPositionLatitude);
        stringBuffer.append(',');
        stringBuffer.append("eventPositionLongitude");
        stringBuffer.append('=');
        stringBuffer.append(this.eventPositionLongitude);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

