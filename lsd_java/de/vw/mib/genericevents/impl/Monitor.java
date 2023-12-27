/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

final class Monitor {
    final int observedId;
    final int observerTargetId;
    final int observerRouterId;

    Monitor(int n, int n2, int n3) {
        this.observedId = n;
        this.observerTargetId = n3;
        this.observerRouterId = n2;
    }

    boolean match(int n, int n2, int n3) {
        return this.observedId == n && this.observerRouterId == n2 && this.observerTargetId == n3;
    }
}

