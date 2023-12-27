/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlRemainingChargeTime {
    public byte mode;
    public short targetSOC;
    public int chargeTime;

    public BatteryControlRemainingChargeTime() {
        this.mode = 0;
        this.targetSOC = 0;
        this.chargeTime = 0;
    }

    public BatteryControlRemainingChargeTime(byte by, short s, int n) {
        this.mode = by;
        this.targetSOC = s;
        this.chargeTime = n;
    }

    public byte getMode() {
        return this.mode;
    }

    public short getTargetSOC() {
        return this.targetSOC;
    }

    public int getChargeTime() {
        return this.chargeTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BatteryControlRemainingChargeTime");
        stringBuffer.append('(');
        stringBuffer.append("mode");
        stringBuffer.append('=');
        stringBuffer.append(this.mode);
        stringBuffer.append(',');
        stringBuffer.append("targetSOC");
        stringBuffer.append('=');
        stringBuffer.append(this.targetSOC);
        stringBuffer.append(',');
        stringBuffer.append("chargeTime");
        stringBuffer.append('=');
        stringBuffer.append(this.chargeTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

