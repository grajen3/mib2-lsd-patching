/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.DataOutput;

public interface ObjectOutput
extends DataOutput {
    default public void close() {
    }

    default public void flush() {
    }

    @Override
    default public void write(byte[] byArray) {
    }

    @Override
    default public void write(byte[] byArray, int n, int n2) {
    }

    @Override
    default public void write(int n) {
    }

    default public void writeObject(Object object) {
    }
}

