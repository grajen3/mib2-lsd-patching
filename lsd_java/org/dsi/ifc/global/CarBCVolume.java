/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class CarBCVolume {
    public int state;
    public int volumeValue;
    public int volumeUnit;

    public CarBCVolume() {
        this.state = 0;
        this.volumeValue = 0;
        this.volumeUnit = 0;
    }

    public CarBCVolume(int n, int n2, int n3) {
        this.state = n;
        this.volumeValue = n2;
        this.volumeUnit = n3;
    }

    public int getState() {
        return this.state;
    }

    public int getVolumeValue() {
        return this.volumeValue;
    }

    public int getVolumeUnit() {
        return this.volumeUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CarBCVolume");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("volumeValue");
        stringBuffer.append('=');
        stringBuffer.append(this.volumeValue);
        stringBuffer.append(',');
        stringBuffer.append("volumeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.volumeUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

