/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

import org.dsi.ifc.global.CarViewOption;

public class StartStopViewOptions {
    public CarViewOption state;
    public CarViewOption startStopProhibitReasonList;
    public CarViewOption startStopRestartReasonList;
    public CarViewOption startStopRestartProhibitReasonList;
    public CarViewOption collectedReasons;

    public StartStopViewOptions() {
        this.state = null;
        this.startStopProhibitReasonList = null;
        this.startStopRestartReasonList = null;
        this.startStopRestartProhibitReasonList = null;
        this.collectedReasons = null;
    }

    public StartStopViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4) {
        this.state = carViewOption;
        this.startStopProhibitReasonList = carViewOption2;
        this.startStopRestartReasonList = carViewOption3;
        this.startStopRestartProhibitReasonList = carViewOption4;
        this.collectedReasons = null;
    }

    public StartStopViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5) {
        this.state = carViewOption;
        this.startStopProhibitReasonList = carViewOption2;
        this.startStopRestartReasonList = carViewOption3;
        this.startStopRestartProhibitReasonList = carViewOption4;
        this.collectedReasons = carViewOption5;
    }

    public CarViewOption getState() {
        return this.state;
    }

    public CarViewOption getStartStopProhibitReasonList() {
        return this.startStopProhibitReasonList;
    }

    public CarViewOption getStartStopRestartReasonList() {
        return this.startStopRestartReasonList;
    }

    public CarViewOption getStartStopRestartProhibitReasonList() {
        return this.startStopRestartProhibitReasonList;
    }

    public CarViewOption getCollectedReasons() {
        return this.collectedReasons;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(5300);
        stringBuffer.append("StartStopViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("startStopProhibitReasonList");
        stringBuffer.append('=');
        stringBuffer.append(this.startStopProhibitReasonList);
        stringBuffer.append(',');
        stringBuffer.append("startStopRestartReasonList");
        stringBuffer.append('=');
        stringBuffer.append(this.startStopRestartReasonList);
        stringBuffer.append(',');
        stringBuffer.append("startStopRestartProhibitReasonList");
        stringBuffer.append('=');
        stringBuffer.append(this.startStopRestartProhibitReasonList);
        stringBuffer.append(',');
        stringBuffer.append("collectedReasons");
        stringBuffer.append('=');
        stringBuffer.append(this.collectedReasons);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

