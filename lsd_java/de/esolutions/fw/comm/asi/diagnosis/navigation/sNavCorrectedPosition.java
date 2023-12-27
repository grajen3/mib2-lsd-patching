/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

public class sNavCorrectedPosition {
    public long msg_id;
    public boolean valuesOK;
    public double longitude;
    public double latitude;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public boolean isValuesOK() {
        return this.valuesOK;
    }

    public void setValuesOK(boolean bl) {
        this.valuesOK = bl;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public sNavCorrectedPosition() {
    }

    public sNavCorrectedPosition(long l, boolean bl, double d2, double d3) {
        this.msg_id = l;
        this.valuesOK = bl;
        this.longitude = d2;
        this.latitude = d3;
    }

    public String toString() {
        return new StringBuffer("sNavCorrectedPosition{").append("msg_id=").append(this.msg_id).append(", valuesOK=").append(this.valuesOK).append(", longitude=").append(this.longitude).append(", latitude=").append(this.latitude).append("}").toString();
    }
}

