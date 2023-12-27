/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

public class sSubsystemState {
    public long msg_id;
    public int state;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public sSubsystemState() {
    }

    public sSubsystemState(long l, int n) {
        this.msg_id = l;
        this.state = n;
    }

    public String toString() {
        return new StringBuffer("sSubsystemState{").append("msg_id=").append(this.msg_id).append(", state=").append(this.state).append("}").toString();
    }
}

