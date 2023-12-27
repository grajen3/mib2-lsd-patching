/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.debugmanager.performance.PerformanceIndicatorService;
import de.vw.mib.debugmanager.performance.PerformanceTracingService;

final class PerformanceServices
implements PerformanceIndicatorService,
PerformanceTracingService {
    private final DebugSPI debugSpi;

    PerformanceServices(DebugSPI debugSPI) {
        this.debugSpi = debugSPI;
    }

    @Override
    public synchronized void OSLogEvent(int n, byte[] byArray) {
        this.debugSpi.OSLogEvent(n, byArray);
    }

    @Override
    public synchronized void OSLogEvent(int n, byte[] byArray, int n2) {
        this.debugSpi.OSLogEvent(n, byArray, n2);
    }

    @Override
    public synchronized void OSLogEvent(int n, String string) {
        this.debugSpi.OSLogEvent(n, string);
    }

    @Override
    public synchronized void J9MAUserEvent(int n) {
        this.debugSpi.J9MAUserEvent(n);
    }

    @Override
    public synchronized int getPerformanceIndicatorCount() {
        return this.debugSpi.getPerformanceIndicatorCount();
    }

    @Override
    public synchronized void getPerformanceIndicatorDescription(String[] stringArray, int[] nArray, long[] lArray) {
        this.debugSpi.getPerformanceIndicatorDescription(stringArray, nArray, lArray);
    }

    @Override
    public synchronized void getPerformanceIndicatorValues(long[] lArray) {
        this.debugSpi.getPerformanceIndicatorValues(lArray);
    }
}

