/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

public interface IReadable {
    default public int size() {
    }

    default public byte[] getData() {
    }

    default public byte[] getData(int n, int n2) {
    }

    default public byte[] getDirectData() {
    }

    default public int getDirectOffset() {
    }

    default public IReadable createSubBuffer(int n, int n2) {
    }

    default public void setDebugTag(Object object) {
    }

    default public Object getDebugTag() {
    }
}

