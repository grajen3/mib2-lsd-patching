/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi;

import de.vw.mib.debug.spi.DebugListener;

public interface DebugSPI {
    public static final int LOGSINK_TCP;
    public static final int LOGSINK_FILE;
    public static final int LOGSINK_SERIAL;
    public static final int TEXT_ENCODING_UTF8;
    public static final int TEXT_ENCODING_UTF16;
    public static final int TEXT_ENCODING_UTF32;
    public static final int PERFORMANCE_INDICATOR_TYPE_COUNT;
    public static final int PERFORMANCE_INDICATOR_TYPE_PERCENTAGE;
    public static final int PERFORMANCE_INDICATOR_TYPE_BYTES;
    public static final int PERFORMANCE_INDICATOR_TYPE_BYTES_PER_SECOND;
    public static final int PERFORMANCE_INDICATOR_TYPE_MILLISECONDS;

    default public void writeLogEntry(short s, byte[] byArray) {
    }

    default public void writeLogEntry(short s, byte[] byArray, int n) {
    }

    default public void writeBinaryMessages(long[] lArray, byte[][] byArray, int[] nArray, int[] nArray2, int n, int n2) {
    }

    default public void writeTextLogMessages(long[] lArray, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, byte[][] byArray, int[] nArray5, int n, int n2) {
    }

    default public void activateLogSink(int n) {
    }

    default public void deactivateLogSink(int n) {
    }

    default public void addDebugListener(DebugListener debugListener) {
    }

    default public void removeDebugListener(DebugListener debugListener) {
    }

    default public void OSLogEvent(int n, byte[] byArray) {
    }

    default public void OSLogEvent(int n, byte[] byArray, int n2) {
    }

    default public void OSLogEvent(int n, String string) {
    }

    default public void J9MAUserEvent(int n) {
    }

    default public void dumpAllThreadStacks() {
    }

    default public int getPerformanceIndicatorCount() {
    }

    default public void getPerformanceIndicatorDescription(String[] stringArray, int[] nArray, long[] lArray) {
    }

    default public void getPerformanceIndicatorValues(long[] lArray) {
    }
}

