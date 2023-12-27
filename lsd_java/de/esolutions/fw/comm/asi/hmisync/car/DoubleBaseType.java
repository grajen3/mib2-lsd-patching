/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car;

public class DoubleBaseType {
    public double value;
    public int unit;
    public int status;

    public double getValue() {
        return this.value;
    }

    public void setValue(double d2) {
        this.value = d2;
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

    public DoubleBaseType() {
    }

    public DoubleBaseType(double d2, int n, int n2) {
        this.value = d2;
        this.unit = n;
        this.status = n2;
    }

    public String toString() {
        return new StringBuffer("DoubleBaseType{").append("value=").append(this.value).append(", unit=").append(this.unit).append(", status=").append(this.status).append("}").toString();
    }
}

