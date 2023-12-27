/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng;

import de.vw.mib.lsctng.LscListener;

public interface LscController {
    default public void addHighPrioListener(LscListener lscListener, int n, String string, int n2, int n3) {
    }

    default public void addListener(LscListener lscListener, int n, String string, int n2, int n3) {
    }

    default public void addAslListener(int n, int n2, String string, int n3, int n4) {
    }

    default public void removeListener(LscListener lscListener) {
    }

    default public void removeAslListener(int n) {
    }

    default public void initialChangeTo(String string, int n, int n2) {
    }

    default public void changeTo(String string, int n, int n2) {
    }
}

