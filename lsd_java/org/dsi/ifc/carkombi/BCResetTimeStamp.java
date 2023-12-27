/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCResetTimeStamp {
    public short year;
    public byte month;
    public byte day;
    public byte hours;
    public byte minutes;

    public BCResetTimeStamp() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hours = 0;
        this.minutes = 0;
    }

    public BCResetTimeStamp(short s, byte by, byte by2, byte by3, byte by4) {
        this.year = s;
        this.month = by;
        this.day = by2;
        this.hours = by3;
        this.minutes = by4;
    }

    public short getYear() {
        return this.year;
    }

    public byte getMonth() {
        return this.month;
    }

    public byte getDay() {
        return this.day;
    }

    public byte getHours() {
        return this.hours;
    }

    public byte getMinutes() {
        return this.minutes;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BCResetTimeStamp");
        stringBuffer.append('(');
        stringBuffer.append("year");
        stringBuffer.append('=');
        stringBuffer.append(this.year);
        stringBuffer.append(',');
        stringBuffer.append("month");
        stringBuffer.append('=');
        stringBuffer.append(this.month);
        stringBuffer.append(',');
        stringBuffer.append("day");
        stringBuffer.append('=');
        stringBuffer.append(this.day);
        stringBuffer.append(',');
        stringBuffer.append("hours");
        stringBuffer.append('=');
        stringBuffer.append(this.hours);
        stringBuffer.append(',');
        stringBuffer.append("minutes");
        stringBuffer.append('=');
        stringBuffer.append(this.minutes);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

