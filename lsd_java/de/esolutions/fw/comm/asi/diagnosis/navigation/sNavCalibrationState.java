/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

public class sNavCalibrationState {
    public long msg_id;
    public int calibrationState;
    public int mileageCalibrationValue;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getCalibrationState() {
        return this.calibrationState;
    }

    public void setCalibrationState(int n) {
        this.calibrationState = n;
    }

    public int getMileageCalibrationValue() {
        return this.mileageCalibrationValue;
    }

    public void setMileageCalibrationValue(int n) {
        this.mileageCalibrationValue = n;
    }

    public sNavCalibrationState() {
    }

    public sNavCalibrationState(long l, int n, int n2) {
        this.msg_id = l;
        this.calibrationState = n;
        this.mileageCalibrationValue = n2;
    }

    public String toString() {
        return new StringBuffer("sNavCalibrationState{").append("msg_id=").append(this.msg_id).append(", calibrationState=").append(this.calibrationState).append(", mileageCalibrationValue=").append(this.mileageCalibrationValue).append("}").toString();
    }
}

