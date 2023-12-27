/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.HybridSinkState;

public class HybridEnergyFlowState {
    public int motionState;
    public int iCEState;
    public int batteryState;
    public int torqueState;
    public int powerSupplyState;
    public int ee1State;
    public int ee2State;
    public HybridSinkState sinkState;

    public HybridEnergyFlowState() {
        this.motionState = 0;
        this.iCEState = 0;
        this.batteryState = 0;
        this.torqueState = 0;
        this.powerSupplyState = 0;
        this.ee1State = 0;
        this.ee2State = 0;
        this.sinkState = null;
    }

    public HybridEnergyFlowState(int n, int n2, int n3, int n4, int n5, int n6, int n7, HybridSinkState hybridSinkState) {
        this.motionState = n;
        this.iCEState = n2;
        this.batteryState = n3;
        this.torqueState = n4;
        this.powerSupplyState = n5;
        this.ee1State = n6;
        this.ee2State = n7;
        this.sinkState = hybridSinkState;
    }

    public int getMotionState() {
        return this.motionState;
    }

    public int getICEState() {
        return this.iCEState;
    }

    public int getBatteryState() {
        return this.batteryState;
    }

    public int getTorqueState() {
        return this.torqueState;
    }

    public int getPowerSupplyState() {
        return this.powerSupplyState;
    }

    public int getEe1State() {
        return this.ee1State;
    }

    public int getEe2State() {
        return this.ee2State;
    }

    public HybridSinkState getSinkState() {
        return this.sinkState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("HybridEnergyFlowState");
        stringBuffer.append('(');
        stringBuffer.append("motionState");
        stringBuffer.append('=');
        stringBuffer.append(this.motionState);
        stringBuffer.append(',');
        stringBuffer.append("iCEState");
        stringBuffer.append('=');
        stringBuffer.append(this.iCEState);
        stringBuffer.append(',');
        stringBuffer.append("batteryState");
        stringBuffer.append('=');
        stringBuffer.append(this.batteryState);
        stringBuffer.append(',');
        stringBuffer.append("torqueState");
        stringBuffer.append('=');
        stringBuffer.append(this.torqueState);
        stringBuffer.append(',');
        stringBuffer.append("powerSupplyState");
        stringBuffer.append('=');
        stringBuffer.append(this.powerSupplyState);
        stringBuffer.append(',');
        stringBuffer.append("ee1State");
        stringBuffer.append('=');
        stringBuffer.append(this.ee1State);
        stringBuffer.append(',');
        stringBuffer.append("ee2State");
        stringBuffer.append('=');
        stringBuffer.append(this.ee2State);
        stringBuffer.append(',');
        stringBuffer.append("sinkState");
        stringBuffer.append('=');
        stringBuffer.append(this.sinkState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

