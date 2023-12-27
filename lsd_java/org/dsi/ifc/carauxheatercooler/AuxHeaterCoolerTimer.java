/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carauxheatercooler;

public class AuxHeaterCoolerTimer {
    public short hour;
    public short minute;
    public short second;
    public short year;
    public short month;
    public short day;
    public short dateMode;

    public AuxHeaterCoolerTimer() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.dateMode = 0;
    }

    public AuxHeaterCoolerTimer(short s, short s2, short s3, short s4, short s5, short s6, short s7) {
        this.hour = s;
        this.minute = s2;
        this.second = s3;
        this.year = s4;
        this.month = s5;
        this.day = s6;
        this.dateMode = s7;
    }

    public short getHour() {
        return this.hour;
    }

    public short getMinute() {
        return this.minute;
    }

    public short getSecond() {
        return this.second;
    }

    public short getYear() {
        return this.year;
    }

    public short getMonth() {
        return this.month;
    }

    public short getDay() {
        return this.day;
    }

    public short getDateMode() {
        return this.dateMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("AuxHeaterCoolerTimer");
        stringBuffer.append('(');
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
        stringBuffer.append(',');
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
        stringBuffer.append("dateMode");
        stringBuffer.append('=');
        stringBuffer.append(this.dateMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

