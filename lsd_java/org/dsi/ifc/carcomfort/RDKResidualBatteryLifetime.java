/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.RDKBatteryState;

public class RDKResidualBatteryLifetime {
    public int lifetimeUnit;
    public int lifetimeFrontLeft;
    public int lifetimeFrontRight;
    public int lifetimeRearLeft;
    public int lifetimeRearRight;
    public int lifetimeSpareWheel;
    public RDKBatteryState batteryState;

    public RDKResidualBatteryLifetime() {
        this.lifetimeUnit = 0;
        this.lifetimeFrontLeft = 0;
        this.lifetimeFrontRight = 0;
        this.lifetimeRearLeft = 0;
        this.lifetimeRearRight = 0;
        this.lifetimeSpareWheel = 0;
        this.batteryState = null;
    }

    public RDKResidualBatteryLifetime(int n, int n2, int n3, int n4, int n5, int n6, RDKBatteryState rDKBatteryState) {
        this.lifetimeUnit = n;
        this.lifetimeFrontLeft = n2;
        this.lifetimeFrontRight = n3;
        this.lifetimeRearLeft = n4;
        this.lifetimeRearRight = n5;
        this.lifetimeSpareWheel = n6;
        this.batteryState = rDKBatteryState;
    }

    public int getLifetimeUnit() {
        return this.lifetimeUnit;
    }

    public int getLifetimeFrontLeft() {
        return this.lifetimeFrontLeft;
    }

    public int getLifetimeFrontRight() {
        return this.lifetimeFrontRight;
    }

    public int getLifetimeRearLeft() {
        return this.lifetimeRearLeft;
    }

    public int getLifetimeRearRight() {
        return this.lifetimeRearRight;
    }

    public int getLifetimeSpareWheel() {
        return this.lifetimeSpareWheel;
    }

    public RDKBatteryState getBatteryState() {
        return this.batteryState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("RDKResidualBatteryLifetime");
        stringBuffer.append('(');
        stringBuffer.append("lifetimeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.lifetimeUnit);
        stringBuffer.append(',');
        stringBuffer.append("lifetimeFrontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.lifetimeFrontLeft);
        stringBuffer.append(',');
        stringBuffer.append("lifetimeFrontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.lifetimeFrontRight);
        stringBuffer.append(',');
        stringBuffer.append("lifetimeRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.lifetimeRearLeft);
        stringBuffer.append(',');
        stringBuffer.append("lifetimeRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.lifetimeRearRight);
        stringBuffer.append(',');
        stringBuffer.append("lifetimeSpareWheel");
        stringBuffer.append('=');
        stringBuffer.append(this.lifetimeSpareWheel);
        stringBuffer.append(',');
        stringBuffer.append("batteryState");
        stringBuffer.append('=');
        stringBuffer.append(this.batteryState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

