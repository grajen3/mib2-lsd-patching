/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

public class SFecImportStatus {
    public long fsid;
    public int state;
    public int supplementalInfo;

    public long getFsid() {
        return this.fsid;
    }

    public void setFsid(long l) {
        this.fsid = l;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public int getSupplementalInfo() {
        return this.supplementalInfo;
    }

    public void setSupplementalInfo(int n) {
        this.supplementalInfo = n;
    }

    public SFecImportStatus() {
    }

    public SFecImportStatus(long l, int n, int n2) {
        this.fsid = l;
        this.state = n;
        this.supplementalInfo = n2;
    }

    public String toString() {
        return new StringBuffer("SFecImportStatus{").append("fsid=").append(this.fsid).append(", state=").append(this.state).append(", supplementalInfo=").append(this.supplementalInfo).append("}").toString();
    }
}

