/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

public class SCHeader {
    public int uid;
    public int numOfRecords;
    public byte[] header;

    public int getUid() {
        return this.uid;
    }

    public void setUid(int n) {
        this.uid = n;
    }

    public int getNumOfRecords() {
        return this.numOfRecords;
    }

    public void setNumOfRecords(int n) {
        this.numOfRecords = n;
    }

    public byte[] getHeader() {
        return this.header;
    }

    public void setHeader(byte[] byArray) {
        this.header = byArray;
    }

    public SCHeader() {
    }

    public SCHeader(int n, int n2, byte[] byArray) {
        this.uid = n;
        this.numOfRecords = n2;
        this.header = byArray;
    }

    public String toString() {
        return new StringBuffer("SCHeader{").append("uid=").append(this.uid).append(", numOfRecords=").append(this.numOfRecords).append(", header=").append("[").append(this.header == null ? "null" : new StringBuffer().append("size=").append(this.header.length).toString()).append("]").append("}").toString();
    }
}

