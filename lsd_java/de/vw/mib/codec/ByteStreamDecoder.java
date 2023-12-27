/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.codec;

import java.io.DataInput;

public interface ByteStreamDecoder {
    default public void finish() {
    }

    default public void read(boolean bl) {
    }

    default public void read(char c2) {
    }

    default public void read(double d2) {
    }

    default public void read(float f2) {
    }

    default public void read(int n) {
    }

    default public void read(long l) {
    }

    default public void read(String string) {
    }

    default public void readHeader(DataInput dataInput) {
    }

    default public void readInvocationContext(DataInput dataInput) {
    }

    default public void readNull() {
    }

    default public void readObject(DataInput dataInput) {
    }

    default public void readStackTrace(String string) {
    }
}

