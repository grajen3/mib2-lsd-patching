/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

public class LocalHazardInformation {
    public int eventID;
    public int eventType;
    public int eventQuality;
    public long distance;

    public LocalHazardInformation() {
        this.eventID = 0;
        this.eventType = 0;
        this.eventQuality = 0;
        this.distance = 0L;
    }

    public LocalHazardInformation(int n, int n2, int n3, long l) {
        this.eventID = n;
        this.eventType = n2;
        this.eventQuality = n3;
        this.distance = l;
    }

    public int getEventID() {
        return this.eventID;
    }

    public int getEventType() {
        return this.eventType;
    }

    public int getEventQuality() {
        return this.eventQuality;
    }

    public long getDistance() {
        return this.distance;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("LocalHazardInformation");
        stringBuffer.append('(');
        stringBuffer.append("eventID");
        stringBuffer.append('=');
        stringBuffer.append(this.eventID);
        stringBuffer.append(',');
        stringBuffer.append("eventType");
        stringBuffer.append('=');
        stringBuffer.append(this.eventType);
        stringBuffer.append(',');
        stringBuffer.append("eventQuality");
        stringBuffer.append('=');
        stringBuffer.append(this.eventQuality);
        stringBuffer.append(',');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

