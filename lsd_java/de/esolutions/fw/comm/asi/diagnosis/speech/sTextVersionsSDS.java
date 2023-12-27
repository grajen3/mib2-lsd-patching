/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.speech;

public class sTextVersionsSDS {
    public long msg_id;
    public long version_1;
    public long version_2;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public long getVersion_1() {
        return this.version_1;
    }

    public void setVersion_1(long l) {
        this.version_1 = l;
    }

    public long getVersion_2() {
        return this.version_2;
    }

    public void setVersion_2(long l) {
        this.version_2 = l;
    }

    public sTextVersionsSDS() {
    }

    public sTextVersionsSDS(long l, long l2, long l3) {
        this.msg_id = l;
        this.version_1 = l2;
        this.version_2 = l3;
    }

    public String toString() {
        return new StringBuffer("sTextVersionsSDS{").append("msg_id=").append(this.msg_id).append(", version_1=").append(this.version_1).append(", version_2=").append(this.version_2).append("}").toString();
    }
}

