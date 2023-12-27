/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

public class sBoundingBox {
    public float minLat;
    public float minLong;
    public float maxLat;
    public float maxLong;

    public float getMinLat() {
        return this.minLat;
    }

    public void setMinLat(float f2) {
        this.minLat = f2;
    }

    public float getMinLong() {
        return this.minLong;
    }

    public void setMinLong(float f2) {
        this.minLong = f2;
    }

    public float getMaxLat() {
        return this.maxLat;
    }

    public void setMaxLat(float f2) {
        this.maxLat = f2;
    }

    public float getMaxLong() {
        return this.maxLong;
    }

    public void setMaxLong(float f2) {
        this.maxLong = f2;
    }

    public sBoundingBox() {
    }

    public sBoundingBox(float f2, float f3, float f4, float f5) {
        this.minLat = f2;
        this.minLong = f3;
        this.maxLat = f4;
        this.maxLong = f5;
    }

    public String toString() {
        return new StringBuffer("sBoundingBox{").append("minLat=").append(this.minLat).append(", minLong=").append(this.minLong).append(", maxLat=").append(this.maxLat).append(", maxLong=").append(this.maxLong).append("}").toString();
    }
}

