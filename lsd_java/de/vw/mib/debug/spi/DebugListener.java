/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi;

public interface DebugListener {
    default public void updateLogConfig(byte[] byArray) {
    }

    default public void logSinkStateChange(int n, boolean bl) {
    }

    default public void logLevelChange(int n, int[] nArray, int[] nArray2) {
    }

    default public void readBinaryMessage(long l, byte[] byArray) {
    }

    default public void performanceIndicatorsChange() {
    }
}

