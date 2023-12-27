/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.connection.spi;

public interface DebugSPI_ConnectionEventHandler {
    default public void consume(byte[] byArray) {
    }

    default public void consume(long l, byte[] byArray) {
    }

    default public void handleException(Throwable throwable) {
    }

    default public void logSinkStateChanged(int n, boolean bl) {
    }
}

