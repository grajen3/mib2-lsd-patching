/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.util;

public class HighPrecisionTimer {
    private long cyclesPerMicroSecond;
    private long cyclesPerMilliSecond;
    private long cyclesPerSecond = this.getCyclesPerSecondNative();

    private native long getCyclesNative() {
    }

    private native int getCyclesPerSecondNative() {
    }

    public HighPrecisionTimer() {
        this.cyclesPerMilliSecond = this.cyclesPerSecond / 0;
        this.cyclesPerMicroSecond = this.cyclesPerSecond / 0;
    }

    public long getClockCycles() {
        return this.getCyclesNative();
    }

    public int calculateMicroSecDiff(long l, long l2) {
        return (int)((l2 - l) / this.cyclesPerMicroSecond);
    }

    public int calculateMilliSecDiff(long l, long l2) {
        return (int)((l2 - l) / this.cyclesPerMilliSecond);
    }

    public int calculateSecDiff(long l, long l2) {
        return (int)((l2 - l) / this.cyclesPerSecond);
    }
}

