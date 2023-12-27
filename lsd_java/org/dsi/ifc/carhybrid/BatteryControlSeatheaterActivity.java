/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlSeatheaterActivity {
    public boolean frontLeft;
    public boolean frontRight;
    public boolean rearLeft;
    public boolean rearRight;

    public BatteryControlSeatheaterActivity() {
        this.frontLeft = false;
        this.frontRight = false;
        this.rearLeft = false;
        this.rearRight = false;
    }

    public BatteryControlSeatheaterActivity(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.frontLeft = bl;
        this.frontRight = bl2;
        this.rearLeft = bl3;
        this.rearRight = bl4;
    }

    public boolean isFrontLeft() {
        return this.frontLeft;
    }

    public boolean isFrontRight() {
        return this.frontRight;
    }

    public boolean isRearLeft() {
        return this.rearLeft;
    }

    public boolean isRearRight() {
        return this.rearRight;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("BatteryControlSeatheaterActivity");
        stringBuffer.append('(');
        stringBuffer.append("frontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.frontLeft);
        stringBuffer.append(',');
        stringBuffer.append("frontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.frontRight);
        stringBuffer.append(',');
        stringBuffer.append("rearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.rearLeft);
        stringBuffer.append(',');
        stringBuffer.append("rearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.rearRight);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

