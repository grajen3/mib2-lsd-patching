/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class BatteryControlViewOptions {
    public CarViewOption plug;
    public CarViewOption chargeState;
    public CarViewOption climateState;
    public CarViewOption timerState;
    public CarViewOption immediately;
    public CarViewOption timer1;
    public CarViewOption timer2;
    public CarViewOption timer3;
    public CarViewOption timer4;
    public CarViewOption profileList;
    public CarViewOption powerProviderList;
    public CarViewOption setFactoryDefault;
    public BatteryControlConfiguration configuration;
    public CarViewOption pastErrorReason;
    public CarViewOption plugDisplayState;
    public CarViewOption remainingChargeTime;
    public CarViewOption lowestMaxCurrent;

    public BatteryControlViewOptions() {
        this.plug = null;
        this.chargeState = null;
        this.climateState = null;
        this.timerState = null;
        this.immediately = null;
        this.timer1 = null;
        this.timer2 = null;
        this.timer3 = null;
        this.timer4 = null;
        this.profileList = null;
        this.powerProviderList = null;
        this.setFactoryDefault = null;
        this.configuration = null;
        this.pastErrorReason = null;
        this.plugDisplayState = null;
        this.remainingChargeTime = null;
        this.lowestMaxCurrent = null;
    }

    public BatteryControlViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, BatteryControlConfiguration batteryControlConfiguration, CarViewOption carViewOption13, CarViewOption carViewOption14, CarViewOption carViewOption15, CarViewOption carViewOption16) {
        this.plug = carViewOption;
        this.chargeState = carViewOption2;
        this.climateState = carViewOption3;
        this.timerState = carViewOption4;
        this.immediately = carViewOption5;
        this.timer1 = carViewOption6;
        this.timer2 = carViewOption7;
        this.timer3 = carViewOption8;
        this.timer4 = carViewOption9;
        this.profileList = carViewOption10;
        this.powerProviderList = carViewOption11;
        this.setFactoryDefault = carViewOption12;
        this.configuration = batteryControlConfiguration;
        this.pastErrorReason = carViewOption13;
        this.plugDisplayState = carViewOption14;
        this.remainingChargeTime = carViewOption15;
        this.lowestMaxCurrent = carViewOption16;
    }

    public CarViewOption getPlug() {
        return this.plug;
    }

    public CarViewOption getChargeState() {
        return this.chargeState;
    }

    public CarViewOption getClimateState() {
        return this.climateState;
    }

    public CarViewOption getTimerState() {
        return this.timerState;
    }

    public CarViewOption getImmediately() {
        return this.immediately;
    }

    public CarViewOption getTimer1() {
        return this.timer1;
    }

    public CarViewOption getTimer2() {
        return this.timer2;
    }

    public CarViewOption getTimer3() {
        return this.timer3;
    }

    public CarViewOption getTimer4() {
        return this.timer4;
    }

    public CarViewOption getProfileList() {
        return this.profileList;
    }

    public CarViewOption getPowerProviderList() {
        return this.powerProviderList;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public CarViewOption getPastErrorReason() {
        return this.pastErrorReason;
    }

    public CarViewOption getPlugDisplayState() {
        return this.plugDisplayState;
    }

    public CarViewOption getRemainingChargeTime() {
        return this.remainingChargeTime;
    }

    public CarViewOption getLowestMaxCurrent() {
        return this.lowestMaxCurrent;
    }

    public BatteryControlConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(17600);
        stringBuffer.append("BatteryControlViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("plug");
        stringBuffer.append('=');
        stringBuffer.append(this.plug);
        stringBuffer.append(',');
        stringBuffer.append("chargeState");
        stringBuffer.append('=');
        stringBuffer.append(this.chargeState);
        stringBuffer.append(',');
        stringBuffer.append("climateState");
        stringBuffer.append('=');
        stringBuffer.append(this.climateState);
        stringBuffer.append(',');
        stringBuffer.append("timerState");
        stringBuffer.append('=');
        stringBuffer.append(this.timerState);
        stringBuffer.append(',');
        stringBuffer.append("immediately");
        stringBuffer.append('=');
        stringBuffer.append(this.immediately);
        stringBuffer.append(',');
        stringBuffer.append("timer1");
        stringBuffer.append('=');
        stringBuffer.append(this.timer1);
        stringBuffer.append(',');
        stringBuffer.append("timer2");
        stringBuffer.append('=');
        stringBuffer.append(this.timer2);
        stringBuffer.append(',');
        stringBuffer.append("timer3");
        stringBuffer.append('=');
        stringBuffer.append(this.timer3);
        stringBuffer.append(',');
        stringBuffer.append("timer4");
        stringBuffer.append('=');
        stringBuffer.append(this.timer4);
        stringBuffer.append(',');
        stringBuffer.append("profileList");
        stringBuffer.append('=');
        stringBuffer.append(this.profileList);
        stringBuffer.append(',');
        stringBuffer.append("powerProviderList");
        stringBuffer.append('=');
        stringBuffer.append(this.powerProviderList);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(',');
        stringBuffer.append("pastErrorReason");
        stringBuffer.append('=');
        stringBuffer.append(this.pastErrorReason);
        stringBuffer.append(',');
        stringBuffer.append("plugDisplayState");
        stringBuffer.append('=');
        stringBuffer.append(this.plugDisplayState);
        stringBuffer.append(',');
        stringBuffer.append("remainingChargeTime");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingChargeTime);
        stringBuffer.append(',');
        stringBuffer.append("lowestMaxCurrent");
        stringBuffer.append('=');
        stringBuffer.append(this.lowestMaxCurrent);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

