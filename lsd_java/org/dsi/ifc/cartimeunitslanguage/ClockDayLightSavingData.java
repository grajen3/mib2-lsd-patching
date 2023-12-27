/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

public class ClockDayLightSavingData {
    public int state;
    public byte month;
    public byte day;
    public byte hour;
    public byte minute;
    public byte second;

    public ClockDayLightSavingData() {
        this.state = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public ClockDayLightSavingData(int n, byte by, byte by2, byte by3, byte by4, byte by5) {
        this.state = n;
        this.month = by;
        this.day = by2;
        this.hour = by3;
        this.minute = by4;
        this.second = by5;
    }

    public int getState() {
        return this.state;
    }

    public byte getMonth() {
        return this.month;
    }

    public byte getDay() {
        return this.day;
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
        stringBuffer.append("ClockDayLightSavingData");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("month");
        stringBuffer.append('=');
        stringBuffer.append(this.month);
        stringBuffer.append(',');
        stringBuffer.append("day");
        stringBuffer.append('=');
        stringBuffer.append(this.day);
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

