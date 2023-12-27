/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

public class sLastPairedBtDevices {
    public long msg_id;
    public short whichLastPaired;
    public long deviceAdress;
    public String deviceName;
    public String btSupplierName;
    public String btModel;
    public String btSoftwareVersion;
    public int[] btProfilesVersion;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getWhichLastPaired() {
        return this.whichLastPaired;
    }

    public void setWhichLastPaired(short s) {
        this.whichLastPaired = s;
    }

    public long getDeviceAdress() {
        return this.deviceAdress;
    }

    public void setDeviceAdress(long l) {
        this.deviceAdress = l;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String string) {
        this.deviceName = string;
    }

    public String getBtSupplierName() {
        return this.btSupplierName;
    }

    public void setBtSupplierName(String string) {
        this.btSupplierName = string;
    }

    public String getBtModel() {
        return this.btModel;
    }

    public void setBtModel(String string) {
        this.btModel = string;
    }

    public String getBtSoftwareVersion() {
        return this.btSoftwareVersion;
    }

    public void setBtSoftwareVersion(String string) {
        this.btSoftwareVersion = string;
    }

    public int[] getBtProfilesVersion() {
        return this.btProfilesVersion;
    }

    public void setBtProfilesVersion(int[] nArray) {
        this.btProfilesVersion = nArray;
    }

    public sLastPairedBtDevices() {
    }

    public sLastPairedBtDevices(long l, short s, long l2, String string, String string2, String string3, String string4, int[] nArray) {
        this.msg_id = l;
        this.whichLastPaired = s;
        this.deviceAdress = l2;
        this.deviceName = string;
        this.btSupplierName = string2;
        this.btModel = string3;
        this.btSoftwareVersion = string4;
        this.btProfilesVersion = nArray;
    }

    public String toString() {
        return new StringBuffer("sLastPairedBtDevices{").append("msg_id=").append(this.msg_id).append(", whichLastPaired=").append(this.whichLastPaired).append(", deviceAdress=").append(this.deviceAdress).append(", deviceName=").append(this.deviceName).append(", btSupplierName=").append(this.btSupplierName).append(", btModel=").append(this.btModel).append(", btSoftwareVersion=").append(this.btSoftwareVersion).append(", btProfilesVersion=").append("[").append(this.btProfilesVersion == null ? "null" : new StringBuffer().append("size=").append(this.btProfilesVersion.length).toString()).append("]").append("}").toString();
    }
}

