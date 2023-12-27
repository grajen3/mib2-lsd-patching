/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

public class Result {
    public int result;
    public int httpStatus;

    public int getResult() {
        return this.result;
    }

    public void setResult(int n) {
        this.result = n;
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }

    public void setHttpStatus(int n) {
        this.httpStatus = n;
    }

    public Result() {
    }

    public Result(int n, int n2) {
        this.result = n;
        this.httpStatus = n2;
    }

    public String toString() {
        return new StringBuffer("Result{").append("result=").append(this.result).append(", httpStatus=").append(this.httpStatus).append("}").toString();
    }
}

