/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

public interface PersistenceInputStream {
    default public void matchVersion(short s) {
    }

    default public String readString() {
    }

    default public int read(byte[] byArray, int n, int n2) {
    }

    default public int read(byte[] byArray) {
    }

    default public boolean readBoolean() {
    }

    default public byte readByte() {
    }

    default public char readChar() {
    }

    default public double readDouble() {
    }

    default public float readFloat() {
    }

    default public void readFully(byte[] byArray, int n, int n2) {
    }

    default public void readFully(byte[] byArray) {
    }

    default public int readInt() {
    }

    default public long readLong() {
    }

    default public short readShort() {
    }

    default public int readUnsignedByte() {
    }

    default public int readUnsignedShort() {
    }

    default public void close() {
    }

    default public int available() {
    }

    default public boolean isValid() {
    }
}

