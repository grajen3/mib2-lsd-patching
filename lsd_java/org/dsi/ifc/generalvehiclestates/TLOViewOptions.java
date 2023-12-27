/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.generalvehiclestates;

import org.dsi.ifc.global.CarViewOption;

public class TLOViewOptions {
    public CarViewOption hmiState;
    public CarViewOption startStopInfo;
    public CarViewOption infoList;

    public TLOViewOptions() {
        this.hmiState = null;
        this.startStopInfo = null;
        this.infoList = null;
    }

    public TLOViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3) {
        this.hmiState = carViewOption;
        this.startStopInfo = carViewOption2;
        this.infoList = carViewOption3;
    }

    public CarViewOption getHmiState() {
        return this.hmiState;
    }

    public CarViewOption getStartStopInfo() {
        return this.startStopInfo;
    }

    public CarViewOption getInfoList() {
        return this.infoList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3100);
        stringBuffer.append("TLOViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("hmiState");
        stringBuffer.append('=');
        stringBuffer.append(this.hmiState);
        stringBuffer.append(',');
        stringBuffer.append("startStopInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.startStopInfo);
        stringBuffer.append(',');
        stringBuffer.append("infoList");
        stringBuffer.append('=');
        stringBuffer.append(this.infoList);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

