/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

public class sSimState {
    public long msg_id;
    public int activeSimLocation;
    public short availableSimCards;
    public String simID;
    public String simIMSI;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getActiveSimLocation() {
        return this.activeSimLocation;
    }

    public void setActiveSimLocation(int n) {
        this.activeSimLocation = n;
    }

    public short getAvailableSimCards() {
        return this.availableSimCards;
    }

    public void setAvailableSimCards(short s) {
        this.availableSimCards = s;
    }

    public String getSimID() {
        return this.simID;
    }

    public void setSimID(String string) {
        this.simID = string;
    }

    public String getSimIMSI() {
        return this.simIMSI;
    }

    public void setSimIMSI(String string) {
        this.simIMSI = string;
    }

    public sSimState() {
    }

    public sSimState(long l, int n, short s, String string, String string2) {
        this.msg_id = l;
        this.activeSimLocation = n;
        this.availableSimCards = s;
        this.simID = string;
        this.simIMSI = string2;
    }

    public String toString() {
        return new StringBuffer("sSimState{").append("msg_id=").append(this.msg_id).append(", activeSimLocation=").append(this.activeSimLocation).append(", availableSimCards=").append(this.availableSimCards).append(", simID=").append(this.simID).append(", simIMSI=").append(this.simIMSI).append("}").toString();
    }
}

