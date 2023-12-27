/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class RDKSpeedLimitAvailability {
    public boolean speedLimit1;
    public boolean speedLimit2;
    public boolean speedLimit3;

    public RDKSpeedLimitAvailability() {
        this.speedLimit1 = false;
        this.speedLimit2 = false;
        this.speedLimit3 = false;
    }

    public RDKSpeedLimitAvailability(boolean bl, boolean bl2, boolean bl3) {
        this.speedLimit1 = bl;
        this.speedLimit2 = bl2;
        this.speedLimit3 = bl3;
    }

    public boolean isSpeedLimit1() {
        return this.speedLimit1;
    }

    public boolean isSpeedLimit2() {
        return this.speedLimit2;
    }

    public boolean isSpeedLimit3() {
        return this.speedLimit3;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("RDKSpeedLimitAvailability");
        stringBuffer.append('(');
        stringBuffer.append("speedLimit1");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimit1);
        stringBuffer.append(',');
        stringBuffer.append("speedLimit2");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimit2);
        stringBuffer.append(',');
        stringBuffer.append("speedLimit3");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimit3);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

