/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class TADVehicleInfo {
    public boolean roofLoad;
    public boolean trailer;

    public TADVehicleInfo() {
        this.roofLoad = false;
        this.trailer = false;
    }

    public TADVehicleInfo(boolean bl, boolean bl2) {
        this.roofLoad = bl;
        this.trailer = bl2;
    }

    public boolean isRoofLoad() {
        return this.roofLoad;
    }

    public boolean isTrailer() {
        return this.trailer;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("TADVehicleInfo");
        stringBuffer.append('(');
        stringBuffer.append("roofLoad");
        stringBuffer.append('=');
        stringBuffer.append(this.roofLoad);
        stringBuffer.append(',');
        stringBuffer.append("trailer");
        stringBuffer.append('=');
        stringBuffer.append(this.trailer);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

