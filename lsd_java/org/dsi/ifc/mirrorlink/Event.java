/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

public class Event {
    public int xPosition;
    public int yPosition;
    public int eventID;
    public int pressureValue;

    public Event() {
        this.xPosition = 0;
        this.yPosition = 0;
        this.eventID = 0;
        this.pressureValue = 0;
    }

    public Event(int n, int n2, int n3, int n4) {
        this.xPosition = n;
        this.yPosition = n2;
        this.eventID = n3;
        this.pressureValue = n4;
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public int getEventID() {
        return this.eventID;
    }

    public int getPressureValue() {
        return this.pressureValue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("Event");
        stringBuffer.append('(');
        stringBuffer.append("xPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.xPosition);
        stringBuffer.append(',');
        stringBuffer.append("yPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.yPosition);
        stringBuffer.append(',');
        stringBuffer.append("eventID");
        stringBuffer.append('=');
        stringBuffer.append(this.eventID);
        stringBuffer.append(',');
        stringBuffer.append("pressureValue");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureValue);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

