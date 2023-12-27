/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.displaymanager;

public class sVideoInputState {
    public long msg_id;
    public int activeSource;
    public int sourceState;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getActiveSource() {
        return this.activeSource;
    }

    public void setActiveSource(int n) {
        this.activeSource = n;
    }

    public int getSourceState() {
        return this.sourceState;
    }

    public void setSourceState(int n) {
        this.sourceState = n;
    }

    public sVideoInputState() {
    }

    public sVideoInputState(long l, int n, int n2) {
        this.msg_id = l;
        this.activeSource = n;
        this.sourceState = n2;
    }

    public String toString() {
        return new StringBuffer("sVideoInputState{").append("msg_id=").append(this.msg_id).append(", activeSource=").append(this.activeSource).append(", sourceState=").append(this.sourceState).append("}").toString();
    }
}

