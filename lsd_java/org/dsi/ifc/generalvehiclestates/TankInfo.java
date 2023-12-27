/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.generalvehiclestates;

public class TankInfo {
    public boolean fuelWarning;
    public boolean fuelLevelState;
    public boolean fuelWarningSecondary;

    public TankInfo() {
        this.fuelWarning = false;
        this.fuelLevelState = false;
        this.fuelWarningSecondary = false;
    }

    public TankInfo(boolean bl, boolean bl2, boolean bl3) {
        this.fuelWarning = bl;
        this.fuelLevelState = bl2;
        this.fuelWarningSecondary = bl3;
    }

    public boolean isFuelWarning() {
        return this.fuelWarning;
    }

    public boolean isFuelLevelState() {
        return this.fuelLevelState;
    }

    public boolean isFuelWarningSecondary() {
        return this.fuelWarningSecondary;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("TankInfo");
        stringBuffer.append('(');
        stringBuffer.append("fuelWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.fuelWarning);
        stringBuffer.append(',');
        stringBuffer.append("fuelLevelState");
        stringBuffer.append('=');
        stringBuffer.append(this.fuelLevelState);
        stringBuffer.append(',');
        stringBuffer.append("fuelWarningSecondary");
        stringBuffer.append('=');
        stringBuffer.append(this.fuelWarningSecondary);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

