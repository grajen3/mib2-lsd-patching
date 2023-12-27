/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconBCMeasuresConfiguration {
    public boolean swh;
    public boolean seatHeater;
    public boolean seatVentilation;
    public boolean surfaceHeater;
    public boolean neckHeater;

    public AirconBCMeasuresConfiguration() {
        this.swh = false;
        this.seatHeater = false;
        this.seatVentilation = false;
        this.surfaceHeater = false;
        this.neckHeater = false;
    }

    public AirconBCMeasuresConfiguration(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.swh = bl;
        this.seatHeater = bl2;
        this.seatVentilation = bl3;
        this.surfaceHeater = bl4;
        this.neckHeater = bl5;
    }

    public boolean isSwh() {
        return this.swh;
    }

    public boolean isSeatHeater() {
        return this.seatHeater;
    }

    public boolean isSeatVentilation() {
        return this.seatVentilation;
    }

    public boolean isSurfaceHeater() {
        return this.surfaceHeater;
    }

    public boolean isNeckHeater() {
        return this.neckHeater;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("AirconBCMeasuresConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("swh");
        stringBuffer.append('=');
        stringBuffer.append(this.swh);
        stringBuffer.append(',');
        stringBuffer.append("seatHeater");
        stringBuffer.append('=');
        stringBuffer.append(this.seatHeater);
        stringBuffer.append(',');
        stringBuffer.append("seatVentilation");
        stringBuffer.append('=');
        stringBuffer.append(this.seatVentilation);
        stringBuffer.append(',');
        stringBuffer.append("surfaceHeater");
        stringBuffer.append('=');
        stringBuffer.append(this.surfaceHeater);
        stringBuffer.append(',');
        stringBuffer.append("neckHeater");
        stringBuffer.append('=');
        stringBuffer.append(this.neckHeater);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

