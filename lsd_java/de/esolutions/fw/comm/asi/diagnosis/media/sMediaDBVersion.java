/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

public class sMediaDBVersion {
    public long msg_id;
    public int version;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int n) {
        this.version = n;
    }

    public sMediaDBVersion() {
    }

    public sMediaDBVersion(long l, int n) {
        this.msg_id = l;
        this.version = n;
    }

    public String toString() {
        return new StringBuffer("sMediaDBVersion{").append("msg_id=").append(this.msg_id).append(", version=").append(this.version).append("}").toString();
    }
}

