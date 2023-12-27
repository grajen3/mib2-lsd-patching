/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.ols;

public class sConnectionState {
    public long msg_id;
    public short serviceCounter;
    public short[] stepID;
    public int[] serverHttpStatusCode;
    public short[] lastConnYear;
    public short[] lastConnMonth;
    public short[] lastConnDay;
    public short[] lastConnHour;
    public short[] lastConnMinute;

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

    public short[] getStepID() {
        return this.stepID;
    }

    public void setStepID(short[] sArray) {
        this.stepID = sArray;
    }

    public int[] getServerHttpStatusCode() {
        return this.serverHttpStatusCode;
    }

    public void setServerHttpStatusCode(int[] nArray) {
        this.serverHttpStatusCode = nArray;
    }

    public short[] getLastConnYear() {
        return this.lastConnYear;
    }

    public void setLastConnYear(short[] sArray) {
        this.lastConnYear = sArray;
    }

    public short[] getLastConnMonth() {
        return this.lastConnMonth;
    }

    public void setLastConnMonth(short[] sArray) {
        this.lastConnMonth = sArray;
    }

    public short[] getLastConnDay() {
        return this.lastConnDay;
    }

    public void setLastConnDay(short[] sArray) {
        this.lastConnDay = sArray;
    }

    public short[] getLastConnHour() {
        return this.lastConnHour;
    }

    public void setLastConnHour(short[] sArray) {
        this.lastConnHour = sArray;
    }

    public short[] getLastConnMinute() {
        return this.lastConnMinute;
    }

    public void setLastConnMinute(short[] sArray) {
        this.lastConnMinute = sArray;
    }

    public sConnectionState() {
    }

    public sConnectionState(long l, short s, short[] sArray, int[] nArray, short[] sArray2, short[] sArray3, short[] sArray4, short[] sArray5, short[] sArray6) {
        this.msg_id = l;
        this.serviceCounter = s;
        this.stepID = sArray;
        this.serverHttpStatusCode = nArray;
        this.lastConnYear = sArray2;
        this.lastConnMonth = sArray3;
        this.lastConnDay = sArray4;
        this.lastConnHour = sArray5;
        this.lastConnMinute = sArray6;
    }

    public String toString() {
        return new StringBuffer("sConnectionState{").append("msg_id=").append(this.msg_id).append(", serviceCounter=").append(this.serviceCounter).append(", stepID=").append("[").append(this.stepID == null ? "null" : new StringBuffer().append("size=").append(this.stepID.length).toString()).append("]").append(", serverHttpStatusCode=").append("[").append(this.serverHttpStatusCode == null ? "null" : new StringBuffer().append("size=").append(this.serverHttpStatusCode.length).toString()).append("]").append(", lastConnYear=").append("[").append(this.lastConnYear == null ? "null" : new StringBuffer().append("size=").append(this.lastConnYear.length).toString()).append("]").append(", lastConnMonth=").append("[").append(this.lastConnMonth == null ? "null" : new StringBuffer().append("size=").append(this.lastConnMonth.length).toString()).append("]").append(", lastConnDay=").append("[").append(this.lastConnDay == null ? "null" : new StringBuffer().append("size=").append(this.lastConnDay.length).toString()).append("]").append(", lastConnHour=").append("[").append(this.lastConnHour == null ? "null" : new StringBuffer().append("size=").append(this.lastConnHour.length).toString()).append("]").append(", lastConnMinute=").append("[").append(this.lastConnMinute == null ? "null" : new StringBuffer().append("size=").append(this.lastConnMinute.length).toString()).append("]").append("}").toString();
    }
}

