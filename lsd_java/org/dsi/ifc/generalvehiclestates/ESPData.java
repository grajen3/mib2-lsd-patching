/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.generalvehiclestates;

public class ESPData {
    public int velocity;
    public boolean standstill;

    public ESPData() {
        this.velocity = 0;
        this.standstill = false;
    }

    public ESPData(int n, boolean bl) {
        this.velocity = n;
        this.standstill = bl;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public boolean isStandstill() {
        return this.standstill;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ESPData");
        stringBuffer.append('(');
        stringBuffer.append("velocity");
        stringBuffer.append('=');
        stringBuffer.append(this.velocity);
        stringBuffer.append(',');
        stringBuffer.append("standstill");
        stringBuffer.append('=');
        stringBuffer.append(this.standstill);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

