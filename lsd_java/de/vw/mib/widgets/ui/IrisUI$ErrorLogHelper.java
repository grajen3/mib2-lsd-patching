/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

final class IrisUI$ErrorLogHelper {
    private final boolean[] alreadyLogged;

    IrisUI$ErrorLogHelper(int n) {
        this.alreadyLogged = new boolean[n];
    }

    boolean isAlreadyLogged(int n) {
        return this.alreadyLogged[n];
    }

    void markAlreadyLogged(int n) {
        this.alreadyLogged[n] = true;
    }
}

