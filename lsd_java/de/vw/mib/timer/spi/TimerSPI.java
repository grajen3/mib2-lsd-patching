/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.spi;

public interface TimerSPI {
    default public long getSystemTime() {
    }

    default public long getSystemTimeFrequency() {
    }
}

