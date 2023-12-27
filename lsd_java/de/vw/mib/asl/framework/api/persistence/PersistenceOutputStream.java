/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

public interface PersistenceOutputStream {
    default public void writeString(String string) {
    }

    default public byte[] toByteArray() {
    }

    default public void write(byte[] byArray, int n, int n2) {
    }

    default public void write(byte[] byArray) {
    }

    default public void write(int n) {
    }

    default public void writeBoolean(boolean bl) {
    }

    default public void writeByte(int n) {
    }

    default public void writeBytes(String string) {
    }

    default public void writeChar(int n) {
    }

    default public void writeChars(String string) {
    }

    default public void writeDouble(double d2) {
    }

    default public void writeFloat(float f2) {
    }

    default public void writeInt(int n) {
    }

    default public void writeLong(long l) {
    }

    default public void writeShort(int n) {
    }
}

