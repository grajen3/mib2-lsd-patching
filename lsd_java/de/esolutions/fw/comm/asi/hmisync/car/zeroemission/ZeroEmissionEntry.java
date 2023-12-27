/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission;

public class ZeroEmissionEntry {
    public short[] values;
    public byte state;

    public short[] getValues() {
        return this.values;
    }

    public void setValues(short[] sArray) {
        this.values = sArray;
    }

    public byte getState() {
        return this.state;
    }

    public void setState(byte by) {
        this.state = by;
    }

    public ZeroEmissionEntry() {
    }

    public ZeroEmissionEntry(short[] sArray, byte by) {
        this.values = sArray;
        this.state = by;
    }

    public String toString() {
        return new StringBuffer("ZeroEmissionEntry{").append("values=").append("[").append(this.values == null ? "null" : new StringBuffer().append("size=").append(this.values.length).toString()).append("]").append(", state=").append(this.state).append("}").toString();
    }
}

