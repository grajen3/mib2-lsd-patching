/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;

public class BatteryControlProfileRA4 {
    public int pos;
    public BatteryControlProfileOperation profileOperation;
    public int maxCurrent;
    public int minChargeLevel;
    public int temperature;
    public int temperatureUnit;
    public int leadTime;
    public int holdingTimePlug;

    public BatteryControlProfileRA4() {
        this.pos = 0;
        this.profileOperation = null;
        this.maxCurrent = 0;
        this.minChargeLevel = 0;
        this.temperature = 0;
        this.temperatureUnit = 0;
        this.leadTime = 0;
        this.holdingTimePlug = 0;
    }

    public BatteryControlProfileRA4(int n, BatteryControlProfileOperation batteryControlProfileOperation, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.pos = n;
        this.profileOperation = batteryControlProfileOperation;
        this.maxCurrent = n2;
        this.minChargeLevel = n3;
        this.temperature = n4;
        this.temperatureUnit = n5;
        this.leadTime = n6;
        this.holdingTimePlug = n7;
    }

    public int getPos() {
        return this.pos;
    }

    public BatteryControlProfileOperation getProfileOperation() {
        return this.profileOperation;
    }

    public int getMaxCurrent() {
        return this.maxCurrent;
    }

    public int getMinChargeLevel() {
        return this.minChargeLevel;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public int getLeadTime() {
        return this.leadTime;
    }

    public int getHoldingTimePlug() {
        return this.holdingTimePlug;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("BatteryControlProfileRA4");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("profileOperation");
        stringBuffer.append('=');
        stringBuffer.append(this.profileOperation);
        stringBuffer.append(',');
        stringBuffer.append("maxCurrent");
        stringBuffer.append('=');
        stringBuffer.append(this.maxCurrent);
        stringBuffer.append(',');
        stringBuffer.append("minChargeLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.minChargeLevel);
        stringBuffer.append(',');
        stringBuffer.append("temperature");
        stringBuffer.append('=');
        stringBuffer.append(this.temperature);
        stringBuffer.append(',');
        stringBuffer.append("temperatureUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.temperatureUnit);
        stringBuffer.append(',');
        stringBuffer.append("leadTime");
        stringBuffer.append('=');
        stringBuffer.append(this.leadTime);
        stringBuffer.append(',');
        stringBuffer.append("holdingTimePlug");
        stringBuffer.append('=');
        stringBuffer.append(this.holdingTimePlug);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

