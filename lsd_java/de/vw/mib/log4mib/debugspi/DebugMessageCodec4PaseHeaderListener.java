/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.debugspi;

public interface DebugMessageCodec4PaseHeaderListener {
    default public void corruptedDataReceived(short s, String string) {
    }

    default public void readCompleteDebugMessage(short s, byte[] byArray, int n, int n2) {
    }

    default public void writeLogEntryToDebugSPI(short s, byte[] byArray, int n) {
    }
}

