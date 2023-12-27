/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.backend;

public interface MessageWriter {
    default public void writeBinaryMessage(long l, short s, byte[] byArray, int n) {
    }

    default public void writeTextLogMessage(long l, int n, int n2, int n3, int n4, byte[] byArray) {
    }
}

