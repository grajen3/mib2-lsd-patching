/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

public class sSparePartNumber {
    public long msg_id;
    public String number;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String string) {
        this.number = string;
    }

    public sSparePartNumber() {
    }

    public sSparePartNumber(long l, String string) {
        this.msg_id = l;
        this.number = string;
    }

    public String toString() {
        return new StringBuffer("sSparePartNumber{").append("msg_id=").append(this.msg_id).append(", number=").append(this.number).append("}").toString();
    }
}

