/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

public class sBluetoothMAC {
    public long msg_id;
    public long mac;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public long getMac() {
        return this.mac;
    }

    public void setMac(long l) {
        this.mac = l;
    }

    public sBluetoothMAC() {
    }

    public sBluetoothMAC(long l, long l2) {
        this.msg_id = l;
        this.mac = l2;
    }

    public String toString() {
        return new StringBuffer("sBluetoothMAC{").append("msg_id=").append(this.msg_id).append(", mac=").append(this.mac).append("}").toString();
    }
}

