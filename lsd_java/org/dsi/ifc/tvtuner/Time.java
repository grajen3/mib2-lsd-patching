/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

public class Time {
    public int hour;
    public int minute;
    public int second;

    public Time() {
        this.hour = 153;
        this.minute = 153;
        this.second = 153;
    }

    public Time(int n, int n2, int n3) {
        this.hour = n;
        this.minute = n2;
        this.second = n3;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("Time");
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

