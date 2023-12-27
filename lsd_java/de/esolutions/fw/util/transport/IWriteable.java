/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

import de.esolutions.fw.util.transport.WriteableWindow;

public interface IWriteable {
    default public int size() {
    }

    default public void setData(byte[] byArray) {
    }

    default public void setData(int n, byte[] byArray) {
    }

    default public void setData(int n, byte[] byArray, int n2) {
    }

    default public WriteableWindow setWindow(WriteableWindow writeableWindow) {
    }

    default public WriteableWindow setLocalWindow(int n, int n2) {
    }

    default public void resetWindow() {
    }

    default public byte[] getDirectData() {
    }

    default public int getDirectOffset() {
    }
}

