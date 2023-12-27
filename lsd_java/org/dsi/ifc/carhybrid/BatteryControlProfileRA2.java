/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;

public class BatteryControlProfileRA2 {
    public int pos;
    public BatteryControlProfileOperation profileOperation;
    public int maxCurrent;
    public int targetChargeLevel;

    public BatteryControlProfileRA2() {
        this.pos = 0;
        this.profileOperation = null;
        this.maxCurrent = 0;
        this.targetChargeLevel = 0;
    }

    public BatteryControlProfileRA2(int n, BatteryControlProfileOperation batteryControlProfileOperation, int n2, int n3) {
        this.pos = n;
        this.profileOperation = batteryControlProfileOperation;
        this.maxCurrent = n2;
        this.targetChargeLevel = n3;
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

    public int getTargetChargeLevel() {
        return this.targetChargeLevel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("BatteryControlProfileRA2");
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
        stringBuffer.append("targetChargeLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.targetChargeLevel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

