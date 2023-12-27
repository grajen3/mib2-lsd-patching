/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

public class SFecHistory {
    public long fsid;
    public String timestamp;
    public String activity;

    public long getFsid() {
        return this.fsid;
    }

    public void setFsid(long l) {
        this.fsid = l;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String string) {
        this.timestamp = string;
    }

    public String getActivity() {
        return this.activity;
    }

    public void setActivity(String string) {
        this.activity = string;
    }

    public SFecHistory() {
    }

    public SFecHistory(long l, String string, String string2) {
        this.fsid = l;
        this.timestamp = string;
        this.activity = string2;
    }

    public String toString() {
        return new StringBuffer("SFecHistory{").append("fsid=").append(this.fsid).append(", timestamp=").append(this.timestamp).append(", activity=").append(this.activity).append("}").toString();
    }
}

