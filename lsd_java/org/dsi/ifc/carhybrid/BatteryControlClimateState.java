/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlClimateMode;
import org.dsi.ifc.carhybrid.BatteryControlSeatheaterActivity;
import org.dsi.ifc.carhybrid.BatteryControlWindowheaterActivity;

public class BatteryControlClimateState {
    public BatteryControlClimateMode climateMode;
    public float currentTemperature;
    public int temperatureUnit;
    public int climatingTime;
    public int climateState;
    public int seatheaterWindowState;
    public BatteryControlSeatheaterActivity seatheaterMode;
    public BatteryControlWindowheaterActivity windowheaterMode;

    public BatteryControlClimateState() {
        this.climateMode = null;
        this.currentTemperature = 0.0f;
        this.temperatureUnit = 0;
        this.climatingTime = 0;
        this.climateState = 0;
        this.seatheaterWindowState = 0;
        this.seatheaterMode = null;
        this.windowheaterMode = null;
    }

    public BatteryControlClimateState(BatteryControlClimateMode batteryControlClimateMode, float f2, int n, int n2, int n3, int n4, BatteryControlSeatheaterActivity batteryControlSeatheaterActivity, BatteryControlWindowheaterActivity batteryControlWindowheaterActivity) {
        this.climateMode = batteryControlClimateMode;
        this.currentTemperature = f2;
        this.temperatureUnit = n;
        this.climatingTime = n2;
        this.climateState = n3;
        this.seatheaterWindowState = n4;
        this.seatheaterMode = batteryControlSeatheaterActivity;
        this.windowheaterMode = batteryControlWindowheaterActivity;
    }

    public BatteryControlClimateMode getClimateMode() {
        return this.climateMode;
    }

    public float getCurrentTemperature() {
        return this.currentTemperature;
    }

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public int getClimatingTime() {
        return this.climatingTime;
    }

    public int getClimateState() {
        return this.climateState;
    }

    public int getSeatheaterWindowState() {
        return this.seatheaterWindowState;
    }

    public BatteryControlSeatheaterActivity getSeatheaterMode() {
        return this.seatheaterMode;
    }

    public BatteryControlWindowheaterActivity getWindowheaterMode() {
        return this.windowheaterMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3450);
        stringBuffer.append("BatteryControlClimateState");
        stringBuffer.append('(');
        stringBuffer.append("climateMode");
        stringBuffer.append('=');
        stringBuffer.append(this.climateMode);
        stringBuffer.append(',');
        stringBuffer.append("currentTemperature");
        stringBuffer.append('=');
        stringBuffer.append(this.currentTemperature);
        stringBuffer.append(',');
        stringBuffer.append("temperatureUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.temperatureUnit);
        stringBuffer.append(',');
        stringBuffer.append("climatingTime");
        stringBuffer.append('=');
        stringBuffer.append(this.climatingTime);
        stringBuffer.append(',');
        stringBuffer.append("climateState");
        stringBuffer.append('=');
        stringBuffer.append(this.climateState);
        stringBuffer.append(',');
        stringBuffer.append("seatheaterWindowState");
        stringBuffer.append('=');
        stringBuffer.append(this.seatheaterWindowState);
        stringBuffer.append(',');
        stringBuffer.append("seatheaterMode");
        stringBuffer.append('=');
        stringBuffer.append(this.seatheaterMode);
        stringBuffer.append(',');
        stringBuffer.append("windowheaterMode");
        stringBuffer.append('=');
        stringBuffer.append(this.windowheaterMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

