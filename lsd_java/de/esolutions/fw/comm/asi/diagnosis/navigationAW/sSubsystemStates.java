/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW;

public class sSubsystemStates {
    public long msg_id;
    public int stateNavDB;
    public int stateVICS;
    public int stateDSRC;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getStateNavDB() {
        return this.stateNavDB;
    }

    public void setStateNavDB(int n) {
        this.stateNavDB = n;
    }

    public int getStateVICS() {
        return this.stateVICS;
    }

    public void setStateVICS(int n) {
        this.stateVICS = n;
    }

    public int getStateDSRC() {
        return this.stateDSRC;
    }

    public void setStateDSRC(int n) {
        this.stateDSRC = n;
    }

    public sSubsystemStates() {
    }

    public sSubsystemStates(long l, int n, int n2, int n3) {
        this.msg_id = l;
        this.stateNavDB = n;
        this.stateVICS = n2;
        this.stateDSRC = n3;
    }

    public String toString() {
        return new StringBuffer("sSubsystemStates{").append("msg_id=").append(this.msg_id).append(", stateNavDB=").append(this.stateNavDB).append(", stateVICS=").append(this.stateVICS).append(", stateDSRC=").append(this.stateDSRC).append("}").toString();
    }
}

