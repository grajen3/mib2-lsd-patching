/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

final class IdGenerator {
    private final int maxId;
    private int mNextId = 0;

    public IdGenerator(int n, int n2) {
        this.maxId = n2;
        this.mNextId = n;
    }

    public synchronized int next() {
        if (this.mNextId == this.maxId) {
            throw new IllegalStateException("Set of IDs is exhausted.");
        }
        return this.mNextId++;
    }
}

