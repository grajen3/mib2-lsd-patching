/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving;

public class TADVehicleInfo {
    public boolean roofLoad;
    public boolean trailer;

    public boolean isRoofLoad() {
        return this.roofLoad;
    }

    public void setRoofLoad(boolean bl) {
        this.roofLoad = bl;
    }

    public boolean isTrailer() {
        return this.trailer;
    }

    public void setTrailer(boolean bl) {
        this.trailer = bl;
    }

    public TADVehicleInfo() {
    }

    public TADVehicleInfo(boolean bl, boolean bl2) {
        this.roofLoad = bl;
        this.trailer = bl2;
    }

    public String toString() {
        return new StringBuffer("TADVehicleInfo{").append("roofLoad=").append(this.roofLoad).append(", trailer=").append(this.trailer).append("}").toString();
    }
}

