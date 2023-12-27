/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlChargeState {
    public int chargeMode;
    public int chargeState;
    public int currentChargeLevel;
    public int remainingChargeTime;
    public int currentChargeRange;
    public int unitRange;
    public int current;
    public int startReason;
    public int batteryClimateState;
    public int targetSOC;

    public BatteryControlChargeState() {
        this.chargeMode = 0;
        this.chargeState = 0;
        this.currentChargeLevel = 0;
        this.remainingChargeTime = 0;
        this.currentChargeRange = 0;
        this.unitRange = 0;
        this.current = 0;
        this.startReason = 0;
        this.batteryClimateState = 0;
        this.targetSOC = 0;
    }

    public BatteryControlChargeState(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.chargeMode = n;
        this.chargeState = n2;
        this.currentChargeLevel = n3;
        this.remainingChargeTime = n4;
        this.currentChargeRange = n5;
        this.unitRange = n6;
        this.current = n7;
        this.startReason = n8;
        this.batteryClimateState = n9;
        this.targetSOC = n10;
    }

    public int getChargeMode() {
        return this.chargeMode;
    }

    public int getChargeState() {
        return this.chargeState;
    }

    public int getCurrentChargeLevel() {
        return this.currentChargeLevel;
    }

    public int getRemainingChargeTime() {
        return this.remainingChargeTime;
    }

    public int getCurrentChargeRange() {
        return this.currentChargeRange;
    }

    public int getUnitRange() {
        return this.unitRange;
    }

    public int getTargetSOC() {
        return this.targetSOC;
    }

    public int getCurrent() {
        return this.current;
    }

    public int getStartReason() {
        return this.startReason;
    }

    public int getBatteryClimateState() {
        return this.batteryClimateState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("BatteryControlChargeState");
        stringBuffer.append('(');
        stringBuffer.append("chargeMode");
        stringBuffer.append('=');
        stringBuffer.append(this.chargeMode);
        stringBuffer.append(',');
        stringBuffer.append("chargeState");
        stringBuffer.append('=');
        stringBuffer.append(this.chargeState);
        stringBuffer.append(',');
        stringBuffer.append("currentChargeLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.currentChargeLevel);
        stringBuffer.append(',');
        stringBuffer.append("remainingChargeTime");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingChargeTime);
        stringBuffer.append(',');
        stringBuffer.append("currentChargeRange");
        stringBuffer.append('=');
        stringBuffer.append(this.currentChargeRange);
        stringBuffer.append(',');
        stringBuffer.append("unitRange");
        stringBuffer.append('=');
        stringBuffer.append(this.unitRange);
        stringBuffer.append(',');
        stringBuffer.append("current");
        stringBuffer.append('=');
        stringBuffer.append(this.current);
        stringBuffer.append(',');
        stringBuffer.append("startReason");
        stringBuffer.append('=');
        stringBuffer.append(this.startReason);
        stringBuffer.append(',');
        stringBuffer.append("batteryClimateState");
        stringBuffer.append('=');
        stringBuffer.append(this.batteryClimateState);
        stringBuffer.append(',');
        stringBuffer.append("targetSOC");
        stringBuffer.append('=');
        stringBuffer.append(this.targetSOC);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

