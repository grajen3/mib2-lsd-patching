/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.global.CarBCDistance;

public class RGSLocalHazardInformation {
    public short eventID;
    public int eventType;
    public int eventQuality;
    public CarBCDistance approach;

    public RGSLocalHazardInformation() {
        this.eventID = 0;
        this.eventType = 0;
        this.eventQuality = 0;
        this.approach = null;
    }

    public RGSLocalHazardInformation(short s, int n, int n2, CarBCDistance carBCDistance) {
        this.eventID = s;
        this.eventType = n;
        this.eventQuality = n2;
        this.approach = carBCDistance;
    }

    public short getEventID() {
        return this.eventID;
    }

    public int getEventType() {
        return this.eventType;
    }

    public int getEventQuality() {
        return this.eventQuality;
    }

    public CarBCDistance getApproach() {
        return this.approach;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("RGSLocalHazardInformation");
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
        stringBuffer.append("approach");
        stringBuffer.append('=');
        stringBuffer.append(this.approach);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

