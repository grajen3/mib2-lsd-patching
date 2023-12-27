/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.internal.sinks;

public interface DebugSPI_Sink {
    default public void close() {
    }

    default public void write(int n, short s, byte[] byArray, int n2) {
    }

    default public void writeBinaryLogMessages(long[] lArray, byte[][] byArray, int[] nArray, int[] nArray2, int n, int n2) {
    }

    default public void writeTextLogMessages(long[] lArray, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, byte[][] byArray, int[] nArray5, int n, int n2) {
    }
}

