/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.speech;

public class sCommandSDS {
    public long msg_id;
    public short confidence_level;
    public short signal_quality;
    public String last_command;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getConfidence_level() {
        return this.confidence_level;
    }

    public void setConfidence_level(short s) {
        this.confidence_level = s;
    }

    public short getSignal_quality() {
        return this.signal_quality;
    }

    public void setSignal_quality(short s) {
        this.signal_quality = s;
    }

    public String getLast_command() {
        return this.last_command;
    }

    public void setLast_command(String string) {
        this.last_command = string;
    }

    public sCommandSDS() {
    }

    public sCommandSDS(long l, short s, short s2, String string) {
        this.msg_id = l;
        this.confidence_level = s;
        this.signal_quality = s2;
        this.last_command = string;
    }

    public String toString() {
        return new StringBuffer("sCommandSDS{").append("msg_id=").append(this.msg_id).append(", confidence_level=").append(this.confidence_level).append(", signal_quality=").append(this.signal_quality).append(", last_command=").append(this.last_command).append("}").toString();
    }
}

