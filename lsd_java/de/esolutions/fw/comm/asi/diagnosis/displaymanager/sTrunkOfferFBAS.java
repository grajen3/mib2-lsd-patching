/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.displaymanager;

public class sTrunkOfferFBAS {
    public long msg_id;
    public boolean successful;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public boolean isSuccessful() {
        return this.successful;
    }

    public void setSuccessful(boolean bl) {
        this.successful = bl;
    }

    public sTrunkOfferFBAS() {
    }

    public sTrunkOfferFBAS(long l, boolean bl) {
        this.msg_id = l;
        this.successful = bl;
    }

    public String toString() {
        return new StringBuffer("sTrunkOfferFBAS{").append("msg_id=").append(this.msg_id).append(", successful=").append(this.successful).append("}").toString();
    }
}

