/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit;

public class ClockDate {
    public short year;
    public byte month;
    public byte day;

    public short getYear() {
        return this.year;
    }

    public void setYear(short s) {
        this.year = s;
    }

    public byte getMonth() {
        return this.month;
    }

    public void setMonth(byte by) {
        this.month = by;
    }

    public byte getDay() {
        return this.day;
    }

    public void setDay(byte by) {
        this.day = by;
    }

    public ClockDate() {
    }

    public ClockDate(short s, byte by, byte by2) {
        this.year = s;
        this.month = by;
        this.day = by2;
    }

    public String toString() {
        return new StringBuffer("ClockDate{").append("year=").append(this.year).append(", month=").append(this.month).append(", day=").append(this.day).append("}").toString();
    }
}

