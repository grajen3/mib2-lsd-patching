/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.DataInput;

public interface ObjectInput
extends DataInput {
    default public int available() {
    }

    default public void close() {
    }

    default public int read() {
    }

    default public int read(byte[] byArray) {
    }

    default public int read(byte[] byArray, int n, int n2) {
    }

    default public Object readObject() {
    }

    default public long skip(long l) {
    }
}

