/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

public class SFecDetails {
    public long fsid;
    public long index;
    public int state;
    public short version;
    public String vin;
    public String vcrn;
    public String date;

    public long getFsid() {
        return this.fsid;
    }

    public void setFsid(long l) {
        this.fsid = l;
    }

    public long getIndex() {
        return this.index;
    }

    public void setIndex(long l) {
        this.index = l;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public short getVersion() {
        return this.version;
    }

    public void setVersion(short s) {
        this.version = s;
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String string) {
        this.vin = string;
    }

    public String getVcrn() {
        return this.vcrn;
    }

    public void setVcrn(String string) {
        this.vcrn = string;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String string) {
        this.date = string;
    }

    public SFecDetails() {
    }

    public SFecDetails(long l, long l2, int n, short s, String string, String string2, String string3) {
        this.fsid = l;
        this.index = l2;
        this.state = n;
        this.version = s;
        this.vin = string;
        this.vcrn = string2;
        this.date = string3;
    }

    public String toString() {
        return new StringBuffer("SFecDetails{").append("fsid=").append(this.fsid).append(", index=").append(this.index).append(", state=").append(this.state).append(", version=").append(this.version).append(", vin=").append(this.vin).append(", vcrn=").append(this.vcrn).append(", date=").append(this.date).append("}").toString();
    }
}

