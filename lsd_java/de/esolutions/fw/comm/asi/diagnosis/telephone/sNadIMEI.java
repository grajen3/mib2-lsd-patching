/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

public class sNadIMEI {
    public long msg_id;
    public String nadIMEI;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public String getNadIMEI() {
        return this.nadIMEI;
    }

    public void setNadIMEI(String string) {
        this.nadIMEI = string;
    }

    public sNadIMEI() {
    }

    public sNadIMEI(long l, String string) {
        this.msg_id = l;
        this.nadIMEI = string;
    }

    public String toString() {
        return new StringBuffer("sNadIMEI{").append("msg_id=").append(this.msg_id).append(", nadIMEI=").append(this.nadIMEI).append("}").toString();
    }
}

