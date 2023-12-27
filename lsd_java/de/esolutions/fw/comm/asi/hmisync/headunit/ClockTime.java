/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit;

public class ClockTime {
    public byte hours;
    public byte minutes;
    public byte seconds;
    public float timeZone;
    public boolean summerTime;

    public byte getHours() {
        return this.hours;
    }

    public void setHours(byte by) {
        this.hours = by;
    }

    public byte getMinutes() {
        return this.minutes;
    }

    public void setMinutes(byte by) {
        this.minutes = by;
    }

    public byte getSeconds() {
        return this.seconds;
    }

    public void setSeconds(byte by) {
        this.seconds = by;
    }

    public float getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(float f2) {
        this.timeZone = f2;
    }

    public boolean isSummerTime() {
        return this.summerTime;
    }

    public void setSummerTime(boolean bl) {
        this.summerTime = bl;
    }

    public ClockTime() {
    }

    public ClockTime(byte by, byte by2, byte by3, float f2, boolean bl) {
        this.hours = by;
        this.minutes = by2;
        this.seconds = by3;
        this.timeZone = f2;
        this.summerTime = bl;
    }

    public String toString() {
        return new StringBuffer("ClockTime{").append("hours=").append(this.hours).append(", minutes=").append(this.minutes).append(", seconds=").append(this.seconds).append(", timeZone=").append(this.timeZone).append(", summerTime=").append(this.summerTime).append("}").toString();
    }
}

