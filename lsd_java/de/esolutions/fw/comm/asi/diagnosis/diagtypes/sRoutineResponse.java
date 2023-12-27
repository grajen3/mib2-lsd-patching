/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

public class sRoutineResponse {
    public long msg_id;
    public int action;
    public int status;
    public int results;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int n) {
        this.action = n;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int n) {
        this.status = n;
    }

    public int getResults() {
        return this.results;
    }

    public void setResults(int n) {
        this.results = n;
    }

    public sRoutineResponse() {
    }

    public sRoutineResponse(long l, int n, int n2, int n3) {
        this.msg_id = l;
        this.action = n;
        this.status = n2;
        this.results = n3;
    }

    public String toString() {
        return new StringBuffer("sRoutineResponse{").append("msg_id=").append(this.msg_id).append(", action=").append(this.action).append(", status=").append(this.status).append(", results=").append(this.results).append("}").toString();
    }
}

