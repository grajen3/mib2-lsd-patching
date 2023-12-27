/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

public class sNavCorrectedDirection {
    public long msg_id;
    public int directionCorrected;
    public boolean statusOK;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getDirectionCorrected() {
        return this.directionCorrected;
    }

    public void setDirectionCorrected(int n) {
        this.directionCorrected = n;
    }

    public boolean isStatusOK() {
        return this.statusOK;
    }

    public void setStatusOK(boolean bl) {
        this.statusOK = bl;
    }

    public sNavCorrectedDirection() {
    }

    public sNavCorrectedDirection(long l, int n, boolean bl) {
        this.msg_id = l;
        this.directionCorrected = n;
        this.statusOK = bl;
    }

    public String toString() {
        return new StringBuffer("sNavCorrectedDirection{").append("msg_id=").append(this.msg_id).append(", directionCorrected=").append(this.directionCorrected).append(", statusOK=").append(this.statusOK).append("}").toString();
    }
}

