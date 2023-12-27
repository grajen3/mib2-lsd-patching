/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car;

public class IntBaseType {
    public int value;
    public int unit;
    public int status;

    public int getValue() {
        return this.value;
    }

    public void setValue(int n) {
        this.value = n;
    }

    public int getUnit() {
        return this.unit;
    }

    public void setUnit(int n) {
        this.unit = n;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int n) {
        this.status = n;
    }

    public IntBaseType() {
    }

    public IntBaseType(int n, int n2, int n3) {
        this.value = n;
        this.unit = n2;
        this.status = n3;
    }

    public String toString() {
        return new StringBuffer("IntBaseType{").append("value=").append(this.value).append(", unit=").append(this.unit).append(", status=").append(this.status).append("}").toString();
    }
}

