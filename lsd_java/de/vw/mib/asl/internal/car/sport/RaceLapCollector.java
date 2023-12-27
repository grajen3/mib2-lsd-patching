/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.sport;

public class RaceLapCollector {
    int lapNo;
    int lapTime;
    int deviationTime;

    public String toString() {
        return new StringBuffer().append(" [lapNo=").append(this.lapNo).append(", lapTime=").append(this.lapTime).append(", deviationTime=").append(this.deviationTime).append("]").toString();
    }

    public int getLapNo() {
        return this.lapNo;
    }

    public void setLapNo(int n) {
        this.lapNo = n;
    }

    public int getLapTime() {
        return this.lapTime;
    }

    public void setLapTime(int n) {
        this.lapTime = n;
    }

    public int getDeviationTime() {
        return this.deviationTime;
    }

    public void setDeviationTime(int n) {
        this.deviationTime = n;
    }
}

