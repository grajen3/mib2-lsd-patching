/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

public class sClientResponseError {
    public long msg_id;
    public int client;
    public int err_type;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getClient() {
        return this.client;
    }

    public void setClient(int n) {
        this.client = n;
    }

    public int getErr_type() {
        return this.err_type;
    }

    public void setErr_type(int n) {
        this.err_type = n;
    }

    public sClientResponseError() {
    }

    public sClientResponseError(long l, int n, int n2) {
        this.msg_id = l;
        this.client = n;
        this.err_type = n2;
    }

    public String toString() {
        return new StringBuffer("sClientResponseError{").append("msg_id=").append(this.msg_id).append(", client=").append(this.client).append(", err_type=").append(this.err_type).append("}").toString();
    }
}

