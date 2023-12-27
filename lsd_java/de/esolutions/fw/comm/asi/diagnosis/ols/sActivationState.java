/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.ols;

public class sActivationState {
    public long msg_id;
    public short serviceCounter;
    public short[] serviceID;
    public int[] statusCode;
    public short[] activationYear;
    public short[] activationMonth;
    public short[] activationDay;
    public short[] activationHour;
    public short[] activationMinute;
    public int[] activationState;
    public short[] exptLicenceYear;
    public short[] exptLicenceMonth;
    public short[] exptLicenceDay;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getServiceCounter() {
        return this.serviceCounter;
    }

    public void setServiceCounter(short s) {
        this.serviceCounter = s;
    }

    public short[] getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(short[] sArray) {
        this.serviceID = sArray;
    }

    public int[] getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int[] nArray) {
        this.statusCode = nArray;
    }

    public short[] getActivationYear() {
        return this.activationYear;
    }

    public void setActivationYear(short[] sArray) {
        this.activationYear = sArray;
    }

    public short[] getActivationMonth() {
        return this.activationMonth;
    }

    public void setActivationMonth(short[] sArray) {
        this.activationMonth = sArray;
    }

    public short[] getActivationDay() {
        return this.activationDay;
    }

    public void setActivationDay(short[] sArray) {
        this.activationDay = sArray;
    }

    public short[] getActivationHour() {
        return this.activationHour;
    }

    public void setActivationHour(short[] sArray) {
        this.activationHour = sArray;
    }

    public short[] getActivationMinute() {
        return this.activationMinute;
    }

    public void setActivationMinute(short[] sArray) {
        this.activationMinute = sArray;
    }

    public int[] getActivationState() {
        return this.activationState;
    }

    public void setActivationState(int[] nArray) {
        this.activationState = nArray;
    }

    public short[] getExptLicenceYear() {
        return this.exptLicenceYear;
    }

    public void setExptLicenceYear(short[] sArray) {
        this.exptLicenceYear = sArray;
    }

    public short[] getExptLicenceMonth() {
        return this.exptLicenceMonth;
    }

    public void setExptLicenceMonth(short[] sArray) {
        this.exptLicenceMonth = sArray;
    }

    public short[] getExptLicenceDay() {
        return this.exptLicenceDay;
    }

    public void setExptLicenceDay(short[] sArray) {
        this.exptLicenceDay = sArray;
    }

    public sActivationState() {
    }

    public sActivationState(long l, short s, short[] sArray, int[] nArray, short[] sArray2, short[] sArray3, short[] sArray4, short[] sArray5, short[] sArray6, int[] nArray2, short[] sArray7, short[] sArray8, short[] sArray9) {
        this.msg_id = l;
        this.serviceCounter = s;
        this.serviceID = sArray;
        this.statusCode = nArray;
        this.activationYear = sArray2;
        this.activationMonth = sArray3;
        this.activationDay = sArray4;
        this.activationHour = sArray5;
        this.activationMinute = sArray6;
        this.activationState = nArray2;
        this.exptLicenceYear = sArray7;
        this.exptLicenceMonth = sArray8;
        this.exptLicenceDay = sArray9;
    }

    public String toString() {
        return new StringBuffer("sActivationState{").append("msg_id=").append(this.msg_id).append(", serviceCounter=").append(this.serviceCounter).append(", serviceID=").append("[").append(this.serviceID == null ? "null" : new StringBuffer().append("size=").append(this.serviceID.length).toString()).append("]").append(", statusCode=").append("[").append(this.statusCode == null ? "null" : new StringBuffer().append("size=").append(this.statusCode.length).toString()).append("]").append(", activationYear=").append("[").append(this.activationYear == null ? "null" : new StringBuffer().append("size=").append(this.activationYear.length).toString()).append("]").append(", activationMonth=").append("[").append(this.activationMonth == null ? "null" : new StringBuffer().append("size=").append(this.activationMonth.length).toString()).append("]").append(", activationDay=").append("[").append(this.activationDay == null ? "null" : new StringBuffer().append("size=").append(this.activationDay.length).toString()).append("]").append(", activationHour=").append("[").append(this.activationHour == null ? "null" : new StringBuffer().append("size=").append(this.activationHour.length).toString()).append("]").append(", activationMinute=").append("[").append(this.activationMinute == null ? "null" : new StringBuffer().append("size=").append(this.activationMinute.length).toString()).append("]").append(", activationState=").append("[").append(this.activationState == null ? "null" : new StringBuffer().append("size=").append(this.activationState.length).toString()).append("]").append(", exptLicenceYear=").append("[").append(this.exptLicenceYear == null ? "null" : new StringBuffer().append("size=").append(this.exptLicenceYear.length).toString()).append("]").append(", exptLicenceMonth=").append("[").append(this.exptLicenceMonth == null ? "null" : new StringBuffer().append("size=").append(this.exptLicenceMonth.length).toString()).append("]").append(", exptLicenceDay=").append("[").append(this.exptLicenceDay == null ? "null" : new StringBuffer().append("size=").append(this.exptLicenceDay.length).toString()).append("]").append("}").toString();
    }
}

