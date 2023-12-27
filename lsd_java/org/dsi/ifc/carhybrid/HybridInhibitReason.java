/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class HybridInhibitReason {
    public boolean batteryCapacity;
    public boolean batteryTemperatureLow;
    public boolean batteryTemperatureHigh;
    public boolean iceTemperatureLow;
    public boolean powerEE;
    public boolean speed;
    public boolean fuelQuality;
    public boolean engineProtection;
    public boolean malfunctionLow;
    public boolean malfunctionCritical;
    public boolean leavingConcept;
    public boolean diagnosis;

    public HybridInhibitReason() {
        this.batteryCapacity = false;
        this.batteryTemperatureLow = false;
        this.batteryTemperatureHigh = false;
        this.iceTemperatureLow = false;
        this.powerEE = false;
        this.speed = false;
        this.fuelQuality = false;
        this.engineProtection = false;
        this.malfunctionLow = false;
        this.malfunctionCritical = false;
        this.leavingConcept = false;
        this.diagnosis = false;
    }

    public HybridInhibitReason(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12) {
        this.batteryCapacity = bl;
        this.batteryTemperatureLow = bl2;
        this.batteryTemperatureHigh = bl3;
        this.iceTemperatureLow = bl4;
        this.powerEE = bl5;
        this.speed = bl6;
        this.fuelQuality = bl7;
        this.engineProtection = bl8;
        this.malfunctionLow = bl9;
        this.malfunctionCritical = bl10;
        this.leavingConcept = bl11;
        this.diagnosis = bl12;
    }

    public boolean isBatteryCapacity() {
        return this.batteryCapacity;
    }

    public boolean isBatteryTemperatureLow() {
        return this.batteryTemperatureLow;
    }

    public boolean isBatteryTemperatureHigh() {
        return this.batteryTemperatureHigh;
    }

    public boolean isIceTemperatureLow() {
        return this.iceTemperatureLow;
    }

    public boolean isPowerEE() {
        return this.powerEE;
    }

    public boolean isSpeed() {
        return this.speed;
    }

    public boolean isFuelQuality() {
        return this.fuelQuality;
    }

    public boolean isEngineProtection() {
        return this.engineProtection;
    }

    public boolean isMalfunctionLow() {
        return this.malfunctionLow;
    }

    public boolean isMalfunctionCritical() {
        return this.malfunctionCritical;
    }

    public boolean isLeavingConcept() {
        return this.leavingConcept;
    }

    public boolean isDiagnosis() {
        return this.diagnosis;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("HybridInhibitReason");
        stringBuffer.append('(');
        stringBuffer.append("batteryCapacity");
        stringBuffer.append('=');
        stringBuffer.append(this.batteryCapacity);
        stringBuffer.append(',');
        stringBuffer.append("batteryTemperatureLow");
        stringBuffer.append('=');
        stringBuffer.append(this.batteryTemperatureLow);
        stringBuffer.append(',');
        stringBuffer.append("batteryTemperatureHigh");
        stringBuffer.append('=');
        stringBuffer.append(this.batteryTemperatureHigh);
        stringBuffer.append(',');
        stringBuffer.append("iceTemperatureLow");
        stringBuffer.append('=');
        stringBuffer.append(this.iceTemperatureLow);
        stringBuffer.append(',');
        stringBuffer.append("powerEE");
        stringBuffer.append('=');
        stringBuffer.append(this.powerEE);
        stringBuffer.append(',');
        stringBuffer.append("speed");
        stringBuffer.append('=');
        stringBuffer.append(this.speed);
        stringBuffer.append(',');
        stringBuffer.append("fuelQuality");
        stringBuffer.append('=');
        stringBuffer.append(this.fuelQuality);
        stringBuffer.append(',');
        stringBuffer.append("engineProtection");
        stringBuffer.append('=');
        stringBuffer.append(this.engineProtection);
        stringBuffer.append(',');
        stringBuffer.append("malfunctionLow");
        stringBuffer.append('=');
        stringBuffer.append(this.malfunctionLow);
        stringBuffer.append(',');
        stringBuffer.append("malfunctionCritical");
        stringBuffer.append('=');
        stringBuffer.append(this.malfunctionCritical);
        stringBuffer.append(',');
        stringBuffer.append("leavingConcept");
        stringBuffer.append('=');
        stringBuffer.append(this.leavingConcept);
        stringBuffer.append(',');
        stringBuffer.append("diagnosis");
        stringBuffer.append('=');
        stringBuffer.append(this.diagnosis);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

