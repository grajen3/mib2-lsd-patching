/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carstopwatch;

import org.dsi.ifc.global.CarViewOption;

public class StopWatchViewOptions {
    public CarViewOption state;
    public CarViewOption control;
    public CarViewOption currentLapNumber;
    public CarViewOption totalTime;
    public CarViewOption lastSplitTime;
    public CarViewOption currentLapTime;
    public CarViewOption lastLapTime;
    public CarViewOption fastestLapTime;
    public CarViewOption lapRating;
    public CarViewOption lapProgress;
    public CarViewOption lapGPSTrigger;
    public CarViewOption slowestLapTime;

    public StopWatchViewOptions() {
        this.state = null;
        this.control = null;
        this.currentLapNumber = null;
        this.totalTime = null;
        this.lastSplitTime = null;
        this.currentLapTime = null;
        this.lastLapTime = null;
        this.fastestLapTime = null;
        this.lapRating = null;
        this.lapProgress = null;
        this.lapGPSTrigger = null;
        this.slowestLapTime = null;
    }

    public StopWatchViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12) {
        this.state = carViewOption;
        this.control = carViewOption2;
        this.currentLapNumber = carViewOption3;
        this.totalTime = carViewOption4;
        this.lastSplitTime = carViewOption5;
        this.currentLapTime = carViewOption6;
        this.lastLapTime = carViewOption7;
        this.fastestLapTime = carViewOption8;
        this.lapRating = carViewOption9;
        this.lapProgress = carViewOption10;
        this.lapGPSTrigger = carViewOption11;
        this.slowestLapTime = carViewOption12;
    }

    public CarViewOption getState() {
        return this.state;
    }

    public CarViewOption getControl() {
        return this.control;
    }

    public CarViewOption getCurrentLapNumber() {
        return this.currentLapNumber;
    }

    public CarViewOption getTotalTime() {
        return this.totalTime;
    }

    public CarViewOption getLastSplitTime() {
        return this.lastSplitTime;
    }

    public CarViewOption getCurrentLapTime() {
        return this.currentLapTime;
    }

    public CarViewOption getLastLapTime() {
        return this.lastLapTime;
    }

    public CarViewOption getFastestLapTime() {
        return this.fastestLapTime;
    }

    public CarViewOption getLapRating() {
        return this.lapRating;
    }

    public CarViewOption getLapProgress() {
        return this.lapProgress;
    }

    public CarViewOption getLapGPSTrigger() {
        return this.lapGPSTrigger;
    }

    public CarViewOption getSlowestLapTime() {
        return this.slowestLapTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(12400);
        stringBuffer.append("StopWatchViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("control");
        stringBuffer.append('=');
        stringBuffer.append(this.control);
        stringBuffer.append(',');
        stringBuffer.append("currentLapNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.currentLapNumber);
        stringBuffer.append(',');
        stringBuffer.append("totalTime");
        stringBuffer.append('=');
        stringBuffer.append(this.totalTime);
        stringBuffer.append(',');
        stringBuffer.append("lastSplitTime");
        stringBuffer.append('=');
        stringBuffer.append(this.lastSplitTime);
        stringBuffer.append(',');
        stringBuffer.append("currentLapTime");
        stringBuffer.append('=');
        stringBuffer.append(this.currentLapTime);
        stringBuffer.append(',');
        stringBuffer.append("lastLapTime");
        stringBuffer.append('=');
        stringBuffer.append(this.lastLapTime);
        stringBuffer.append(',');
        stringBuffer.append("fastestLapTime");
        stringBuffer.append('=');
        stringBuffer.append(this.fastestLapTime);
        stringBuffer.append(',');
        stringBuffer.append("lapRating");
        stringBuffer.append('=');
        stringBuffer.append(this.lapRating);
        stringBuffer.append(',');
        stringBuffer.append("lapProgress");
        stringBuffer.append('=');
        stringBuffer.append(this.lapProgress);
        stringBuffer.append(',');
        stringBuffer.append("lapGPSTrigger");
        stringBuffer.append('=');
        stringBuffer.append(this.lapGPSTrigger);
        stringBuffer.append(',');
        stringBuffer.append("slowestLapTime");
        stringBuffer.append('=');
        stringBuffer.append(this.slowestLapTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

