/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

public class sMediaTypeOpticalDrive {
    public long msg_id;
    public int type;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    public sMediaTypeOpticalDrive() {
    }

    public sMediaTypeOpticalDrive(long l, int n) {
        this.msg_id = l;
        this.type = n;
    }

    public String toString() {
        return new StringBuffer("sMediaTypeOpticalDrive{").append("msg_id=").append(this.msg_id).append(", type=").append(this.type).append("}").toString();
    }
}

