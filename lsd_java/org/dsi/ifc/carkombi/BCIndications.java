/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCIndications {
    public boolean washingWater;
    public boolean oilLevel;
    public boolean tyrePressure;
    public boolean tankLevel;

    public BCIndications() {
        this.washingWater = false;
        this.oilLevel = false;
        this.tyrePressure = false;
        this.tankLevel = false;
    }

    public BCIndications(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.washingWater = bl;
        this.oilLevel = bl2;
        this.tyrePressure = bl3;
        this.tankLevel = bl4;
    }

    public boolean isWashingWater() {
        return this.washingWater;
    }

    public boolean isOilLevel() {
        return this.oilLevel;
    }

    public boolean isTyrePressure() {
        return this.tyrePressure;
    }

    public boolean isTankLevel() {
        return this.tankLevel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("BCIndications");
        stringBuffer.append('(');
        stringBuffer.append("washingWater");
        stringBuffer.append('=');
        stringBuffer.append(this.washingWater);
        stringBuffer.append(',');
        stringBuffer.append("oilLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.oilLevel);
        stringBuffer.append(',');
        stringBuffer.append("tyrePressure");
        stringBuffer.append('=');
        stringBuffer.append(this.tyrePressure);
        stringBuffer.append(',');
        stringBuffer.append("tankLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.tankLevel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

