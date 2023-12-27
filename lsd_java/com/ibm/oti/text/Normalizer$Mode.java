/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text;

public final class Normalizer$Mode {
    final int mode;

    Normalizer$Mode(int n) {
        this.mode = n;
    }

    final boolean compat() {
        return (this.mode & 1) != 0;
    }

    final boolean compose() {
        return (this.mode & 4) != 0;
    }

    final boolean decomp() {
        return (this.mode & 2) != 0;
    }
}

