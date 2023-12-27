/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlClimateMode {
    public boolean climating;
    public boolean autoDefrost;
    public boolean heating;
    public boolean cooling;
    public boolean ventilation;
    public boolean fuelBasedHeating;

    public BatteryControlClimateMode() {
        this.climating = false;
        this.autoDefrost = false;
        this.heating = false;
        this.cooling = false;
        this.ventilation = false;
        this.fuelBasedHeating = false;
    }

    public BatteryControlClimateMode(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.climating = bl;
        this.autoDefrost = bl2;
        this.heating = bl3;
        this.cooling = bl4;
        this.ventilation = bl5;
        this.fuelBasedHeating = bl6;
    }

    public boolean isClimating() {
        return this.climating;
    }

    public boolean isAutoDefrost() {
        return this.autoDefrost;
    }

    public boolean isHeating() {
        return this.heating;
    }

    public boolean isCooling() {
        return this.cooling;
    }

    public boolean isVentilation() {
        return this.ventilation;
    }

    public boolean isFuelBasedHeating() {
        return this.fuelBasedHeating;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("BatteryControlClimateMode");
        stringBuffer.append('(');
        stringBuffer.append("climating");
        stringBuffer.append('=');
        stringBuffer.append(this.climating);
        stringBuffer.append(',');
        stringBuffer.append("autoDefrost");
        stringBuffer.append('=');
        stringBuffer.append(this.autoDefrost);
        stringBuffer.append(',');
        stringBuffer.append("heating");
        stringBuffer.append('=');
        stringBuffer.append(this.heating);
        stringBuffer.append(',');
        stringBuffer.append("cooling");
        stringBuffer.append('=');
        stringBuffer.append(this.cooling);
        stringBuffer.append(',');
        stringBuffer.append("ventilation");
        stringBuffer.append('=');
        stringBuffer.append(this.ventilation);
        stringBuffer.append(',');
        stringBuffer.append("fuelBasedHeating");
        stringBuffer.append('=');
        stringBuffer.append(this.fuelBasedHeating);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

