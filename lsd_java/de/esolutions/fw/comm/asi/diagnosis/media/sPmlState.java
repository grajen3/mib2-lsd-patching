/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

public class sPmlState {
    public long msg_id;
    public short levelSystem;
    public short levelMedium;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getLevelSystem() {
        return this.levelSystem;
    }

    public void setLevelSystem(short s) {
        this.levelSystem = s;
    }

    public short getLevelMedium() {
        return this.levelMedium;
    }

    public void setLevelMedium(short s) {
        this.levelMedium = s;
    }

    public sPmlState() {
    }

    public sPmlState(long l, short s, short s2) {
        this.msg_id = l;
        this.levelSystem = s;
        this.levelMedium = s2;
    }

    public String toString() {
        return new StringBuffer("sPmlState{").append("msg_id=").append(this.msg_id).append(", levelSystem=").append(this.levelSystem).append(", levelMedium=").append(this.levelMedium).append("}").toString();
    }
}

