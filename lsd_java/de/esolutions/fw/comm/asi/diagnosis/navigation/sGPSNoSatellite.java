/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

public class sGPSNoSatellite {
    public long msg_id;
    public short year;
    public short month;
    public short day;
    public short hour;
    public short minute;
    public short seconds;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getYear() {
        return this.year;
    }

    public void setYear(short s) {
        this.year = s;
    }

    public short getMonth() {
        return this.month;
    }

    public void setMonth(short s) {
        this.month = s;
    }

    public short getDay() {
        return this.day;
    }

    public void setDay(short s) {
        this.day = s;
    }

    public short getHour() {
        return this.hour;
    }

    public void setHour(short s) {
        this.hour = s;
    }

    public short getMinute() {
        return this.minute;
    }

    public void setMinute(short s) {
        this.minute = s;
    }

    public short getSeconds() {
        return this.seconds;
    }

    public void setSeconds(short s) {
        this.seconds = s;
    }

    public sGPSNoSatellite() {
    }

    public sGPSNoSatellite(long l, short s, short s2, short s3, short s4, short s5, short s6) {
        this.msg_id = l;
        this.year = s;
        this.month = s2;
        this.day = s3;
        this.hour = s4;
        this.minute = s5;
        this.seconds = s6;
    }

    public String toString() {
        return new StringBuffer("sGPSNoSatellite{").append("msg_id=").append(this.msg_id).append(", year=").append(this.year).append(", month=").append(this.month).append(", day=").append(this.day).append(", hour=").append(this.hour).append(", minute=").append(this.minute).append(", seconds=").append(this.seconds).append("}").toString();
    }
}

