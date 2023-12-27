/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

public class sConnectedBtHandset {
    public long msg_id;
    public int handsetNumber;
    public short fieldStrengthRSSI;
    public String deviceName;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getHandsetNumber() {
        return this.handsetNumber;
    }

    public void setHandsetNumber(int n) {
        this.handsetNumber = n;
    }

    public short getFieldStrengthRSSI() {
        return this.fieldStrengthRSSI;
    }

    public void setFieldStrengthRSSI(short s) {
        this.fieldStrengthRSSI = s;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String string) {
        this.deviceName = string;
    }

    public sConnectedBtHandset() {
    }

    public sConnectedBtHandset(long l, int n, short s, String string) {
        this.msg_id = l;
        this.handsetNumber = n;
        this.fieldStrengthRSSI = s;
        this.deviceName = string;
    }

    public String toString() {
        return new StringBuffer("sConnectedBtHandset{").append("msg_id=").append(this.msg_id).append(", handsetNumber=").append(this.handsetNumber).append(", fieldStrengthRSSI=").append(this.fieldStrengthRSSI).append(", deviceName=").append(this.deviceName).append("}").toString();
    }
}

