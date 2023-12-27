/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

public class DynamicVehicleInfoSCR {
    public int range;
    public int rangeUnit;
    public byte level;
    public float refillLevelMin;
    public float refillLevelMax;
    public float tankVolume;
    public int volumeUnit;
    public int status;

    public DynamicVehicleInfoSCR() {
        this.range = 0;
        this.rangeUnit = 0;
        this.level = 0;
        this.refillLevelMin = 0.0f;
        this.refillLevelMax = 0.0f;
        this.tankVolume = 0.0f;
        this.volumeUnit = 0;
        this.status = 0;
    }

    public DynamicVehicleInfoSCR(int n, int n2, byte by, float f2, float f3, float f4, int n3, int n4) {
        this.range = n;
        this.rangeUnit = n2;
        this.level = by;
        this.refillLevelMin = f2;
        this.refillLevelMax = f3;
        this.tankVolume = f4;
        this.volumeUnit = n3;
        this.status = n4;
    }

    public int getRange() {
        return this.range;
    }

    public int getRangeUnit() {
        return this.rangeUnit;
    }

    public byte getLevel() {
        return this.level;
    }

    public float getRefillLevelMin() {
        return this.refillLevelMin;
    }

    public float getRefillLevelMax() {
        return this.refillLevelMax;
    }

    public float getTankVolume() {
        return this.tankVolume;
    }

    public int getVolumeUnit() {
        return this.volumeUnit;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("DynamicVehicleInfoSCR");
        stringBuffer.append('(');
        stringBuffer.append("range");
        stringBuffer.append('=');
        stringBuffer.append(this.range);
        stringBuffer.append(',');
        stringBuffer.append("rangeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeUnit);
        stringBuffer.append(',');
        stringBuffer.append("level");
        stringBuffer.append('=');
        stringBuffer.append(this.level);
        stringBuffer.append(',');
        stringBuffer.append("refillLevelMin");
        stringBuffer.append('=');
        stringBuffer.append(this.refillLevelMin);
        stringBuffer.append(',');
        stringBuffer.append("refillLevelMax");
        stringBuffer.append('=');
        stringBuffer.append(this.refillLevelMax);
        stringBuffer.append(',');
        stringBuffer.append("tankVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.tankVolume);
        stringBuffer.append(',');
        stringBuffer.append("volumeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.volumeUnit);
        stringBuffer.append(',');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

