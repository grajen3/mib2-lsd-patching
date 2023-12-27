/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

import java.util.Arrays;

public class sConnectedBtDevices {
    public long msg_id;
    public short numberConnectedDevices;
    public long[] btProfiles;
    public String[] deviceName;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getNumberConnectedDevices() {
        return this.numberConnectedDevices;
    }

    public void setNumberConnectedDevices(short s) {
        this.numberConnectedDevices = s;
    }

    public long[] getBtProfiles() {
        return this.btProfiles;
    }

    public void setBtProfiles(long[] lArray) {
        this.btProfiles = lArray;
    }

    public String[] getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String[] stringArray) {
        this.deviceName = stringArray;
    }

    public sConnectedBtDevices() {
    }

    public sConnectedBtDevices(long l, short s, long[] lArray, String[] stringArray) {
        this.msg_id = l;
        this.numberConnectedDevices = s;
        this.btProfiles = lArray;
        this.deviceName = stringArray;
    }

    public String toString() {
        return new StringBuffer("sConnectedBtDevices{").append("msg_id=").append(this.msg_id).append(", numberConnectedDevices=").append(this.numberConnectedDevices).append(", btProfiles=").append("[").append(this.btProfiles == null ? "null" : new StringBuffer().append("size=").append(this.btProfiles.length).toString()).append("]").append(", deviceName=").append("[").append(this.deviceName == null ? "null" : Arrays.asList(this.deviceName).toString()).append("]").append("}").toString();
    }
}

