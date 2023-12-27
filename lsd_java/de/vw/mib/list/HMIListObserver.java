/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

public interface HMIListObserver {
    default public void focusChanged(int n) {
    }

    default public void itemsChanged(int n, int n2) {
    }

    default public void sizeChanged(int n) {
    }

    default public void stateChanged(int n) {
    }

    default public void stringIndexChanged() {
    }
}

