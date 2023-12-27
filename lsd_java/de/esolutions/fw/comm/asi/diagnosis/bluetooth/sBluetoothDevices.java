/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

public class sBluetoothDevices {
    public long msg_id;
    public short scannedDevices;
    public short pairedDevices;
    public short connectedDevices;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getScannedDevices() {
        return this.scannedDevices;
    }

    public void setScannedDevices(short s) {
        this.scannedDevices = s;
    }

    public short getPairedDevices() {
        return this.pairedDevices;
    }

    public void setPairedDevices(short s) {
        this.pairedDevices = s;
    }

    public short getConnectedDevices() {
        return this.connectedDevices;
    }

    public void setConnectedDevices(short s) {
        this.connectedDevices = s;
    }

    public sBluetoothDevices() {
    }

    public sBluetoothDevices(long l, short s, short s2, short s3) {
        this.msg_id = l;
        this.scannedDevices = s;
        this.pairedDevices = s2;
        this.connectedDevices = s3;
    }

    public String toString() {
        return new StringBuffer("sBluetoothDevices{").append("msg_id=").append(this.msg_id).append(", scannedDevices=").append(this.scannedDevices).append(", pairedDevices=").append(this.pairedDevices).append(", connectedDevices=").append(this.connectedDevices).append("}").toString();
    }
}

