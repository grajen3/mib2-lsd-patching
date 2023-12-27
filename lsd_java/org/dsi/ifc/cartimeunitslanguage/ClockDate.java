/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

public class ClockDate {
    public short year;
    public byte month;
    public byte day;

    public ClockDate() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }

    public ClockDate(short s, byte by, byte by2) {
        this.year = s;
        this.month = by;
        this.day = by2;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ClockDate");
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

