/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages;

public interface DebugSPI_MessageConsumer {
    default public void consumeMessage(int n, short s, byte[] byArray) {
    }

    default public void handleException(Throwable throwable) {
    }
}

