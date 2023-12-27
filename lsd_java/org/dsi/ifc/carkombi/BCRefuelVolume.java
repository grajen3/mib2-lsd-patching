/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCRefuelVolume {
    public int state;
    public int refuelVolumeValue;
    public int refuelVolumeUnit;

    public BCRefuelVolume() {
        this.state = 0;
        this.refuelVolumeValue = 0;
        this.refuelVolumeUnit = 0;
    }

    public BCRefuelVolume(int n, int n2, int n3) {
        this.state = n;
        this.refuelVolumeValue = n2;
        this.refuelVolumeUnit = n3;
    }

    public int getState() {
        return this.state;
    }

    public int getRefuelVolumeValue() {
        return this.refuelVolumeValue;
    }

    public int getRefuelVolumeUnit() {
        return this.refuelVolumeUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("BCRefuelVolume");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("refuelVolumeValue");
        stringBuffer.append('=');
        stringBuffer.append(this.refuelVolumeValue);
        stringBuffer.append(',');
        stringBuffer.append("refuelVolumeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.refuelVolumeUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

