/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

public class sTelephoneTemperature {
    public long msg_id;
    public short current;
    public short min;
    public short max;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getCurrent() {
        return this.current;
    }

    public void setCurrent(short s) {
        this.current = s;
    }

    public short getMin() {
        return this.min;
    }

    public void setMin(short s) {
        this.min = s;
    }

    public short getMax() {
        return this.max;
    }

    public void setMax(short s) {
        this.max = s;
    }

    public sTelephoneTemperature() {
    }

    public sTelephoneTemperature(long l, short s, short s2, short s3) {
        this.msg_id = l;
        this.current = s;
        this.min = s2;
        this.max = s3;
    }

    public String toString() {
        return new StringBuffer("sTelephoneTemperature{").append("msg_id=").append(this.msg_id).append(", current=").append(this.current).append(", min=").append(this.min).append(", max=").append(this.max).append("}").toString();
    }
}

