/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car;

public class FloatBaseType {
    public float value;
    public int unit;
    public int status;

    public float getValue() {
        return this.value;
    }

    public void setValue(float f2) {
        this.value = f2;
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

    public FloatBaseType() {
    }

    public FloatBaseType(float f2, int n, int n2) {
        this.value = f2;
        this.unit = n;
        this.status = n2;
    }

    public String toString() {
        return new StringBuffer("FloatBaseType{").append("value=").append(this.value).append(", unit=").append(this.unit).append(", status=").append(this.status).append("}").toString();
    }
}

