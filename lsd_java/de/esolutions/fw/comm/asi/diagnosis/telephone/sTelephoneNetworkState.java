/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

public class sTelephoneNetworkState {
    public long msg_id;
    public int lockstate;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getLockstate() {
        return this.lockstate;
    }

    public void setLockstate(int n) {
        this.lockstate = n;
    }

    public sTelephoneNetworkState() {
    }

    public sTelephoneNetworkState(long l, int n) {
        this.msg_id = l;
        this.lockstate = n;
    }

    public String toString() {
        return new StringBuffer("sTelephoneNetworkState{").append("msg_id=").append(this.msg_id).append(", lockstate=").append(this.lockstate).append("}").toString();
    }
}

