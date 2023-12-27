/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

public interface BinaryMessage {
    default public BinaryMessage append(boolean bl) {
    }

    default public BinaryMessage append(byte by) {
    }

    default public BinaryMessage append(byte[] byArray) {
    }

    default public BinaryMessage append(char c2) {
    }

    default public BinaryMessage append(double d2) {
    }

    default public BinaryMessage append(float f2) {
    }

    default public BinaryMessage append(int n) {
    }

    default public BinaryMessage append(long l) {
    }

    default public BinaryMessage append(short s) {
    }

    default public BinaryMessage append(String string) {
    }

    default public BinaryMessage appendData(byte[] byArray) {
    }

    default public int beginElement() {
    }

    default public void endElement(int n) {
    }

    default public void mark() {
    }

    default public void rollback() {
    }

    default public void send() {
    }
}

