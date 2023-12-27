/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.performance;

public interface PerformanceTracingService {
    default public void OSLogEvent(int n, byte[] byArray) {
    }

    default public void OSLogEvent(int n, byte[] byArray, int n2) {
    }

    default public void OSLogEvent(int n, String string) {
    }

    default public void J9MAUserEvent(int n) {
    }
}

