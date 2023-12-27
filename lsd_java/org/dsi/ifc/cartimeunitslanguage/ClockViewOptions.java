/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

import org.dsi.ifc.cartimeunitslanguage.ClockConfig;
import org.dsi.ifc.global.CarViewOption;

public class ClockViewOptions {
    public CarViewOption time;
    public CarViewOption date;
    public CarViewOption timeZone;
    public CarViewOption dayLightSaving;
    public CarViewOption dayLightSavingData;
    public CarViewOption clockSource;
    public CarViewOption gpsSyncData;
    public ClockConfig clockConfig;

    public ClockViewOptions() {
        this.time = null;
        this.date = null;
        this.timeZone = null;
        this.dayLightSaving = null;
        this.dayLightSavingData = null;
        this.clockSource = null;
        this.gpsSyncData = null;
        this.clockConfig = null;
    }

    public ClockViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, ClockConfig clockConfig) {
        this.time = carViewOption;
        this.date = carViewOption2;
        this.timeZone = carViewOption3;
        this.dayLightSaving = carViewOption4;
        this.dayLightSavingData = carViewOption5;
        this.clockSource = carViewOption6;
        this.gpsSyncData = carViewOption7;
        this.clockConfig = clockConfig;
    }

    public CarViewOption getTime() {
        return this.time;
    }

    public CarViewOption getDate() {
        return this.date;
    }

    public CarViewOption getTimeZone() {
        return this.timeZone;
    }

    public CarViewOption getDayLightSaving() {
        return this.dayLightSaving;
    }

    public CarViewOption getDayLightSavingData() {
        return this.dayLightSavingData;
    }

    public CarViewOption getClockSource() {
        return this.clockSource;
    }

    public CarViewOption getGpsSyncData() {
        return this.gpsSyncData;
    }

    public ClockConfig getClockConfig() {
        return this.clockConfig;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(8250);
        stringBuffer.append("ClockViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("time");
        stringBuffer.append('=');
        stringBuffer.append(this.time);
        stringBuffer.append(',');
        stringBuffer.append("date");
        stringBuffer.append('=');
        stringBuffer.append(this.date);
        stringBuffer.append(',');
        stringBuffer.append("timeZone");
        stringBuffer.append('=');
        stringBuffer.append(this.timeZone);
        stringBuffer.append(',');
        stringBuffer.append("dayLightSaving");
        stringBuffer.append('=');
        stringBuffer.append(this.dayLightSaving);
        stringBuffer.append(',');
        stringBuffer.append("dayLightSavingData");
        stringBuffer.append('=');
        stringBuffer.append(this.dayLightSavingData);
        stringBuffer.append(',');
        stringBuffer.append("clockSource");
        stringBuffer.append('=');
        stringBuffer.append(this.clockSource);
        stringBuffer.append(',');
        stringBuffer.append("gpsSyncData");
        stringBuffer.append('=');
        stringBuffer.append(this.gpsSyncData);
        stringBuffer.append(',');
        stringBuffer.append("clockConfig");
        stringBuffer.append('=');
        stringBuffer.append(this.clockConfig);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

