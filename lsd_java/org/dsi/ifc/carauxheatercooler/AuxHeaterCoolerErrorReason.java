/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carauxheatercooler;

public class AuxHeaterCoolerErrorReason {
    public boolean batteryLow;
    public boolean fuelLow;
    public boolean heaterDefect;
    public boolean maxOperationTime;

    public AuxHeaterCoolerErrorReason() {
        this.batteryLow = false;
        this.fuelLow = false;
        this.heaterDefect = false;
        this.maxOperationTime = false;
    }

    public AuxHeaterCoolerErrorReason(boolean bl, boolean bl2, boolean bl3) {
        this.batteryLow = bl;
        this.fuelLow = bl2;
        this.heaterDefect = bl3;
        this.maxOperationTime = false;
    }

    public AuxHeaterCoolerErrorReason(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.batteryLow = bl;
        this.fuelLow = bl2;
        this.heaterDefect = bl3;
        this.maxOperationTime = bl4;
    }

    public boolean isBatteryLow() {
        return this.batteryLow;
    }

    public boolean isFuelLow() {
        return this.fuelLow;
    }

    public boolean isHeaterDefect() {
        return this.heaterDefect;
    }

    public boolean isMaxOperationTime() {
        return this.maxOperationTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("AuxHeaterCoolerErrorReason");
        stringBuffer.append('(');
        stringBuffer.append("batteryLow");
        stringBuffer.append('=');
        stringBuffer.append(this.batteryLow);
        stringBuffer.append(',');
        stringBuffer.append("fuelLow");
        stringBuffer.append('=');
        stringBuffer.append(this.fuelLow);
        stringBuffer.append(',');
        stringBuffer.append("heaterDefect");
        stringBuffer.append('=');
        stringBuffer.append(this.heaterDefect);
        stringBuffer.append(',');
        stringBuffer.append("maxOperationTime");
        stringBuffer.append('=');
        stringBuffer.append(this.maxOperationTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

