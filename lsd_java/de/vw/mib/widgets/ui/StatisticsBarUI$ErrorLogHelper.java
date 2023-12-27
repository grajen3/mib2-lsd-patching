/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

final class StatisticsBarUI$ErrorLogHelper {
    private final boolean[] alreadyLogged;

    StatisticsBarUI$ErrorLogHelper(int n) {
        this.alreadyLogged = new boolean[n];
    }

    void clear() {
        for (int i2 = this.alreadyLogged.length - 1; i2 >= 0; --i2) {
            this.alreadyLogged[i2] = false;
        }
    }

    boolean isAlreadyLogged(int n) {
        return this.alreadyLogged[n];
    }

    void markAlreadyLogged(int n) {
        this.alreadyLogged[n] = true;
    }
}

