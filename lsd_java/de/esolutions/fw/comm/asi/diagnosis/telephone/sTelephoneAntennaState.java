/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

public class sTelephoneAntennaState {
    public long msg_id;
    public int antenna;
    public int connectionState;
    public short antennaCurrent;
    public byte receptionLevel;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getAntenna() {
        return this.antenna;
    }

    public void setAntenna(int n) {
        this.antenna = n;
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public void setConnectionState(int n) {
        this.connectionState = n;
    }

    public short getAntennaCurrent() {
        return this.antennaCurrent;
    }

    public void setAntennaCurrent(short s) {
        this.antennaCurrent = s;
    }

    public byte getReceptionLevel() {
        return this.receptionLevel;
    }

    public void setReceptionLevel(byte by) {
        this.receptionLevel = by;
    }

    public sTelephoneAntennaState() {
    }

    public sTelephoneAntennaState(long l, int n, int n2, short s, byte by) {
        this.msg_id = l;
        this.antenna = n;
        this.connectionState = n2;
        this.antennaCurrent = s;
        this.receptionLevel = by;
    }

    public String toString() {
        return new StringBuffer("sTelephoneAntennaState{").append("msg_id=").append(this.msg_id).append(", antenna=").append(this.antenna).append(", connectionState=").append(this.connectionState).append(", antennaCurrent=").append(this.antennaCurrent).append(", receptionLevel=").append(this.receptionLevel).append("}").toString();
    }
}

