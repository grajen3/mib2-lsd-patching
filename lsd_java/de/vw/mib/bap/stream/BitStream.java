/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.stream;

public interface BitStream {
    public static final int INT_BITS_SIZE;
    public static final int SHORT_BITS_SIZE;
    public static final int BYTE_BITS_SIZE;
    public static final int BOOLEAN_BITS_SIZE;

    default public void pushBoolean(boolean bl) {
    }

    default public void pushByte(byte by) {
    }

    default public void pushShort(short s) {
    }

    default public void pushInt(int n) {
    }

    default public void pushBits(int n, int n2) {
    }

    default public void pushBytes(byte[] byArray) {
    }

    default public void resetBits(int n) {
    }

    default public boolean popFrontBoolean() {
    }

    default public int popFrontByte() {
    }

    default public int popFrontShort() {
    }

    default public int popFrontInt() {
    }

    default public byte[] popFrontBytes(int n) {
    }

    default public int popFrontBits(int n) {
    }

    default public void discardBits(int n) {
    }

    default public int bitSize() {
    }
}

