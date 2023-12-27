/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconAirVolume {
    public int airVolume;
    public int airVolumeRegulated;
    public int airVolumeAuto;

    public AirconAirVolume() {
        this.airVolume = 0;
        this.airVolumeRegulated = 0;
        this.airVolumeAuto = 0;
    }

    public AirconAirVolume(int n, int n2, int n3) {
        this.airVolume = n;
        this.airVolumeRegulated = n2;
        this.airVolumeAuto = n3;
    }

    public int getAirVolume() {
        return this.airVolume;
    }

    public int getAirVolumeAuto() {
        return this.airVolumeAuto;
    }

    public int getAirVolumeRegulated() {
        return this.airVolumeRegulated;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("AirconAirVolume");
        stringBuffer.append('(');
        stringBuffer.append("airVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.airVolume);
        stringBuffer.append(',');
        stringBuffer.append("airVolumeRegulated");
        stringBuffer.append('=');
        stringBuffer.append(this.airVolumeRegulated);
        stringBuffer.append(',');
        stringBuffer.append("airVolumeAuto");
        stringBuffer.append('=');
        stringBuffer.append(this.airVolumeAuto);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

