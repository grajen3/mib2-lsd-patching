/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.clock;

public class Time {
    byte hours;
    byte minutes;
    byte seconds;

    public Time(byte by, byte by2, byte by3) {
        this.hours = by;
        this.minutes = by2;
        this.seconds = by3;
    }

    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
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
}

