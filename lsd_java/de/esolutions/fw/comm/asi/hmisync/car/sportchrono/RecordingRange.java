/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

public class RecordingRange {
    public long remainingRange;
    public short remainingLaps;

    public long getRemainingRange() {
        return this.remainingRange;
    }

    public void setRemainingRange(long l) {
        this.remainingRange = l;
    }

    public short getRemainingLaps() {
        return this.remainingLaps;
    }

    public void setRemainingLaps(short s) {
        this.remainingLaps = s;
    }

    public RecordingRange() {
    }

    public RecordingRange(long l, short s) {
        this.remainingRange = l;
        this.remainingLaps = s;
    }

    public String toString() {
        return new StringBuffer("RecordingRange{").append("remainingRange=").append(this.remainingRange).append(", remainingLaps=").append(this.remainingLaps).append("}").toString();
    }
}

