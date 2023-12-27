/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

public class sBluetoothState {
    public long msg_id;
    public int btAccessMode;
    public int btOnOff;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getBtAccessMode() {
        return this.btAccessMode;
    }

    public void setBtAccessMode(int n) {
        this.btAccessMode = n;
    }

    public int getBtOnOff() {
        return this.btOnOff;
    }

    public void setBtOnOff(int n) {
        this.btOnOff = n;
    }

    public sBluetoothState() {
    }

    public sBluetoothState(long l, int n, int n2) {
        this.msg_id = l;
        this.btAccessMode = n;
        this.btOnOff = n2;
    }

    public String toString() {
        return new StringBuffer("sBluetoothState{").append("msg_id=").append(this.msg_id).append(", btAccessMode=").append(this.btAccessMode).append(", btOnOff=").append(this.btOnOff).append("}").toString();
    }
}

