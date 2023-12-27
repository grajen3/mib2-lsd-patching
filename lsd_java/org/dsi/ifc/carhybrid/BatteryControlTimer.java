/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public class BatteryControlTimer {
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public BatteryControlWeekdays weekdays;
    public int chargeSchedule;
    public int climateSchedule;
    public int refID;

    public BatteryControlTimer() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.weekdays = null;
        this.chargeSchedule = 0;
        this.climateSchedule = 0;
        this.refID = 0;
    }

    public BatteryControlTimer(int n, int n2, int n3, int n4, int n5, BatteryControlWeekdays batteryControlWeekdays, int n6, int n7, int n8) {
        this.year = n;
        this.month = n2;
        this.day = n3;
        this.hour = n4;
        this.minute = n5;
        this.weekdays = batteryControlWeekdays;
        this.chargeSchedule = n6;
        this.climateSchedule = n7;
        this.refID = n8;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getChargeSchedule() {
        return this.chargeSchedule;
    }

    public BatteryControlWeekdays getWeekdays() {
        return this.weekdays;
    }

    public int getClimateSchedule() {
        return this.climateSchedule;
    }

    public int getRefID() {
        return this.refID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("BatteryControlTimer");
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
        stringBuffer.append(',');
        stringBuffer.append("hour");
        stringBuffer.append('=');
        stringBuffer.append(this.hour);
        stringBuffer.append(',');
        stringBuffer.append("minute");
        stringBuffer.append('=');
        stringBuffer.append(this.minute);
        stringBuffer.append(',');
        stringBuffer.append("weekdays");
        stringBuffer.append('=');
        stringBuffer.append(this.weekdays);
        stringBuffer.append(',');
        stringBuffer.append("chargeSchedule");
        stringBuffer.append('=');
        stringBuffer.append(this.chargeSchedule);
        stringBuffer.append(',');
        stringBuffer.append("climateSchedule");
        stringBuffer.append('=');
        stringBuffer.append(this.climateSchedule);
        stringBuffer.append(',');
        stringBuffer.append("refID");
        stringBuffer.append('=');
        stringBuffer.append(this.refID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

