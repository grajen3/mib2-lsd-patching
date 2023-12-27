/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

import org.dsi.ifc.carseat.SeatPneumaticConfig;
import org.dsi.ifc.global.CarViewOption;

public class SeatPneumaticViewOptions {
    public CarViewOption seatPneumaticCoDriverSettingsFromDriver;
    public CarViewOption seatPneumaticSetFactoryDefault;
    public SeatPneumaticConfig seatPneumaticConfig;

    public SeatPneumaticViewOptions() {
        this.seatPneumaticCoDriverSettingsFromDriver = null;
        this.seatPneumaticSetFactoryDefault = null;
        this.seatPneumaticConfig = null;
    }

    public SeatPneumaticViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, SeatPneumaticConfig seatPneumaticConfig) {
        this.seatPneumaticCoDriverSettingsFromDriver = carViewOption;
        this.seatPneumaticSetFactoryDefault = carViewOption2;
        this.seatPneumaticConfig = seatPneumaticConfig;
    }

    public CarViewOption getSeatPneumaticCoDriverSettingsFromDriver() {
        return this.seatPneumaticCoDriverSettingsFromDriver;
    }

    public CarViewOption getSeatPneumaticSetFactoryDefault() {
        return this.seatPneumaticSetFactoryDefault;
    }

    public SeatPneumaticConfig getSeatPneumaticConfig() {
        return this.seatPneumaticConfig;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3250);
        stringBuffer.append("SeatPneumaticViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("seatPneumaticCoDriverSettingsFromDriver");
        stringBuffer.append('=');
        stringBuffer.append(this.seatPneumaticCoDriverSettingsFromDriver);
        stringBuffer.append(',');
        stringBuffer.append("seatPneumaticSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.seatPneumaticSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("seatPneumaticConfig");
        stringBuffer.append('=');
        stringBuffer.append(this.seatPneumaticConfig);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

