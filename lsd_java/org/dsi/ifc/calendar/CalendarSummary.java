/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.global.DateTime;

public class CalendarSummary {
    public DateTime start;
    public DateTime end;
    public String location;
    public String summary;
    public long eventID;

    public CalendarSummary() {
    }

    public CalendarSummary(DateTime dateTime, DateTime dateTime2, String string, String string2, long l) {
        this.start = dateTime;
        this.end = dateTime2;
        this.location = string;
        this.summary = string2;
        this.eventID = l;
    }

    public DateTime getStart() {
        return this.start;
    }

    public void setStart(DateTime dateTime) {
        this.start = dateTime;
    }

    public DateTime getEnd() {
        return this.end;
    }

    public void setEnd(DateTime dateTime) {
        this.end = dateTime;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String string) {
        this.location = string;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String string) {
        this.summary = string;
    }

    public long getEventID() {
        return this.eventID;
    }

    public void setEventID(long l) {
        this.eventID = l;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2300);
        stringBuffer.append("CalendarSummary");
        stringBuffer.append('(');
        stringBuffer.append("start");
        stringBuffer.append('=');
        stringBuffer.append(this.start);
        stringBuffer.append(',');
        stringBuffer.append("end");
        stringBuffer.append('=');
        stringBuffer.append(this.end);
        stringBuffer.append(',');
        stringBuffer.append("location");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.location);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("summary");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.summary);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("eventID");
        stringBuffer.append('=');
        stringBuffer.append(this.eventID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

