/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.has.SystemHasBridge;

public class UnitSetter {
    SystemHasBridge systemHasBridge;

    public UnitSetter(SystemHasBridge systemHasBridge) {
        this.systemHasBridge = systemHasBridge;
    }

    public void setDistanceUnit(int n) {
        this.systemHasBridge.setPropertyDistanceUnit(n);
    }

    public void setTemperatureUnit(int n) {
        this.systemHasBridge.setPropertyTemperatureUnit(n);
    }

    public void setPetrolConsumptionUnit(int n) {
        this.systemHasBridge.setPropertyLiquidConsumptionUnit(n);
    }

    public void setPressureUnit(int n) {
        this.systemHasBridge.setPropertyPressureUnit(n);
    }

    public void setSpeedUnit(int n) {
        this.systemHasBridge.setPropertySpeedUnit(n);
    }
}

