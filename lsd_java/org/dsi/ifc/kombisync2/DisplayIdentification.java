/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

public class DisplayIdentification {
    public int day;
    public int month;
    public int year;
    public int hour;
    public int minute;
    public int seconds;
    public int versionMain;
    public int versionSub;

    public DisplayIdentification() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.hour = 0;
        this.minute = 0;
        this.seconds = 0;
        this.versionMain = 0;
        this.versionSub = 0;
    }

    public DisplayIdentification(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.day = n;
        this.month = n2;
        this.year = n3;
        this.hour = n4;
        this.minute = n5;
        this.seconds = n6;
        this.versionMain = n7;
        this.versionSub = n8;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public int getVersionMain() {
        return this.versionMain;
    }

    public int getVersionSub() {
        return this.versionSub;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("DisplayIdentification");
        stringBuffer.append('(');
        stringBuffer.append("day");
        stringBuffer.append('=');
        stringBuffer.append(this.day);
        stringBuffer.append(',');
        stringBuffer.append("month");
        stringBuffer.append('=');
        stringBuffer.append(this.month);
        stringBuffer.append(',');
        stringBuffer.append("year");
        stringBuffer.append('=');
        stringBuffer.append(this.year);
        stringBuffer.append(',');
        stringBuffer.append("hour");
        stringBuffer.append('=');
        stringBuffer.append(this.hour);
        stringBuffer.append(',');
        stringBuffer.append("minute");
        stringBuffer.append('=');
        stringBuffer.append(this.minute);
        stringBuffer.append(',');
        stringBuffer.append("seconds");
        stringBuffer.append('=');
        stringBuffer.append(this.seconds);
        stringBuffer.append(',');
        stringBuffer.append("versionMain");
        stringBuffer.append('=');
        stringBuffer.append(this.versionMain);
        stringBuffer.append(',');
        stringBuffer.append("versionSub");
        stringBuffer.append('=');
        stringBuffer.append(this.versionSub);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

