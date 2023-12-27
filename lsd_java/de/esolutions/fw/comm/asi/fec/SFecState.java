/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

public class SFecState {
    public long fsid;
    public long index;
    public int fecState;

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

    public int getFecState() {
        return this.fecState;
    }

    public void setFecState(int n) {
        this.fecState = n;
    }

    public SFecState() {
    }

    public SFecState(long l, long l2, int n) {
        this.fsid = l;
        this.index = l2;
        this.fecState = n;
    }

    public String toString() {
        return new StringBuffer("SFecState{").append("fsid=").append(this.fsid).append(", index=").append(this.index).append(", fecState=").append(this.fecState).append("}").toString();
    }
}

