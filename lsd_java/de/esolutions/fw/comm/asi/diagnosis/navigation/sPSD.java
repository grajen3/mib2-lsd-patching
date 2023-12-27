/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

public class sPSD {
    public long msg_id;
    public int customerExperience;
    public short psdNavInfo;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getCustomerExperience() {
        return this.customerExperience;
    }

    public void setCustomerExperience(int n) {
        this.customerExperience = n;
    }

    public short getPsdNavInfo() {
        return this.psdNavInfo;
    }

    public void setPsdNavInfo(short s) {
        this.psdNavInfo = s;
    }

    public sPSD() {
    }

    public sPSD(long l, int n, short s) {
        this.msg_id = l;
        this.customerExperience = n;
        this.psdNavInfo = s;
    }

    public String toString() {
        return new StringBuffer("sPSD{").append("msg_id=").append(this.msg_id).append(", customerExperience=").append(this.customerExperience).append(", psdNavInfo=").append(this.psdNavInfo).append("}").toString();
    }
}

