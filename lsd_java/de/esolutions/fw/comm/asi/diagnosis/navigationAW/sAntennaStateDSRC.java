/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW;

public class sAntennaStateDSRC {
    public long msg_id;
    public int antennaState;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getAntennaState() {
        return this.antennaState;
    }

    public void setAntennaState(int n) {
        this.antennaState = n;
    }

    public sAntennaStateDSRC() {
    }

    public sAntennaStateDSRC(long l, int n) {
        this.msg_id = l;
        this.antennaState = n;
    }

    public String toString() {
        return new StringBuffer("sAntennaStateDSRC{").append("msg_id=").append(this.msg_id).append(", antennaState=").append(this.antennaState).append("}").toString();
    }
}

