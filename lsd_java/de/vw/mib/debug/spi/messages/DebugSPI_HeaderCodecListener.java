/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages;

public interface DebugSPI_HeaderCodecListener {
    default public void messageDecoded(long l, byte[] byArray) {
    }

    default public void messageDecoded(int n, short s, byte[] byArray) {
    }
}

