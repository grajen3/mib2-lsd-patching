/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlExpiredTimer;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;

public class BatteryControlTimerState {
    public BatteryControlProgrammedTimer programmedTimer;
    public BatteryControlExpiredTimer expiredTimer;

    public BatteryControlTimerState() {
        this.programmedTimer = null;
        this.expiredTimer = null;
    }

    public BatteryControlTimerState(BatteryControlProgrammedTimer batteryControlProgrammedTimer, BatteryControlExpiredTimer batteryControlExpiredTimer) {
        this.programmedTimer = batteryControlProgrammedTimer;
        this.expiredTimer = batteryControlExpiredTimer;
    }

    public BatteryControlProgrammedTimer getProgrammedTimer() {
        return this.programmedTimer;
    }

    public BatteryControlExpiredTimer getExpiredTimer() {
        return this.expiredTimer;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2100);
        stringBuffer.append("BatteryControlTimerState");
        stringBuffer.append('(');
        stringBuffer.append("programmedTimer");
        stringBuffer.append('=');
        stringBuffer.append(this.programmedTimer);
        stringBuffer.append(',');
        stringBuffer.append("expiredTimer");
        stringBuffer.append('=');
        stringBuffer.append(this.expiredTimer);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

