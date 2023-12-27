/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

public class ClockTime {
    public byte hours;
    public byte minutes;
    public byte seconds;
    public float timeZone;
    public boolean summerTime;

    public ClockTime() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.timeZone = 0.0f;
        this.summerTime = false;
    }

    public ClockTime(byte by, byte by2, byte by3, float f2, boolean bl) {
        this.hours = by;
        this.minutes = by2;
        this.seconds = by3;
        this.timeZone = f2;
        this.summerTime = bl;
    }

    public byte getHours() {
        return this.hours;
    }

    public byte getMinutes() {
        return this.minutes;
    }

    public byte getSeconds() {
        return this.seconds;
    }

    public float getTimeZone() {
        return this.timeZone;
    }

    public boolean isSummerTime() {
        return this.summerTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ClockTime");
        stringBuffer.append('(');
        stringBuffer.append("hours");
        stringBuffer.append('=');
        stringBuffer.append(this.hours);
        stringBuffer.append(',');
        stringBuffer.append("minutes");
        stringBuffer.append('=');
        stringBuffer.append(this.minutes);
        stringBuffer.append(',');
        stringBuffer.append("seconds");
        stringBuffer.append('=');
        stringBuffer.append(this.seconds);
        stringBuffer.append(',');
        stringBuffer.append("timeZone");
        stringBuffer.append('=');
        stringBuffer.append(this.timeZone);
        stringBuffer.append(',');
        stringBuffer.append("summerTime");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

