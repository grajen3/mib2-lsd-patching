/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travellink;

public class TravelLinkDate {
    public short year;
    public byte day;
    public byte month;
    public byte hour;
    public byte minute;
    public byte second;

    public TravelLinkDate() {
        this.year = 0;
        this.day = 0;
        this.month = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public TravelLinkDate(short s, byte by, byte by2, byte by3, byte by4, byte by5) {
        this.year = s;
        this.day = by;
        this.month = by2;
        this.hour = by3;
        this.minute = by4;
        this.second = by5;
    }

    public short getYear() {
        return this.year;
    }

    public byte getDay() {
        return this.day;
    }

    public byte getMonth() {
        return this.month;
    }

    public byte getHour() {
        return this.hour;
    }

    public byte getMinute() {
        return this.minute;
    }

    public byte getSecond() {
        return this.second;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("TravelLinkDate");
        stringBuffer.append('(');
        stringBuffer.append("year");
        stringBuffer.append('=');
        stringBuffer.append(this.year);
        stringBuffer.append(',');
        stringBuffer.append("day");
        stringBuffer.append('=');
        stringBuffer.append(this.day);
        stringBuffer.append(',');
        stringBuffer.append("month");
        stringBuffer.append('=');
        stringBuffer.append(this.month);
        stringBuffer.append(',');
        stringBuffer.append("hour");
        stringBuffer.append('=');
        stringBuffer.append(this.hour);
        stringBuffer.append(',');
        stringBuffer.append("minute");
        stringBuffer.append('=');
        stringBuffer.append(this.minute);
        stringBuffer.append(',');
        stringBuffer.append("second");
        stringBuffer.append('=');
        stringBuffer.append(this.second);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

