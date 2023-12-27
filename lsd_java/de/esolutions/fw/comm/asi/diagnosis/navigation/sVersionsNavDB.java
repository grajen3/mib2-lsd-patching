/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

public class sVersionsNavDB {
    public long msg_id;
    public String sd1;
    public String sd2;
    public String opticalDrive;
    public String hdd;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public String getSd1() {
        return this.sd1;
    }

    public void setSd1(String string) {
        this.sd1 = string;
    }

    public String getSd2() {
        return this.sd2;
    }

    public void setSd2(String string) {
        this.sd2 = string;
    }

    public String getOpticalDrive() {
        return this.opticalDrive;
    }

    public void setOpticalDrive(String string) {
        this.opticalDrive = string;
    }

    public String getHdd() {
        return this.hdd;
    }

    public void setHdd(String string) {
        this.hdd = string;
    }

    public sVersionsNavDB() {
    }

    public sVersionsNavDB(long l, String string, String string2, String string3, String string4) {
        this.msg_id = l;
        this.sd1 = string;
        this.sd2 = string2;
        this.opticalDrive = string3;
        this.hdd = string4;
    }

    public String toString() {
        return new StringBuffer("sVersionsNavDB{").append("msg_id=").append(this.msg_id).append(", sd1=").append(this.sd1).append(", sd2=").append(this.sd2).append(", opticalDrive=").append(this.opticalDrive).append(", hdd=").append(this.hdd).append("}").toString();
    }
}

