/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carstopwatch;

public class StopWatchTime {
    public byte hours;
    public byte minutes;
    public byte seconds;
    public byte hundredthSeconds;

    public StopWatchTime() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.hundredthSeconds = 0;
    }

    public StopWatchTime(byte by, byte by2, byte by3, byte by4) {
        this.hours = by;
        this.minutes = by2;
        this.seconds = by3;
        this.hundredthSeconds = by4;
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

    public byte getHundredthSeconds() {
        return this.hundredthSeconds;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("StopWatchTime");
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
        stringBuffer.append("hundredthSeconds");
        stringBuffer.append('=');
        stringBuffer.append(this.hundredthSeconds);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

