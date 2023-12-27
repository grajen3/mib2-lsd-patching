/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.pool;

public interface ObjectPoolMonitor {
    default public void addObjectToPool() {
    }

    default public void clearObjectPool() {
    }

    default public void createNewObject() {
    }

    default public void dropObject() {
    }

    default public void init(int n) {
    }

    default public void removeObjectFromPool() {
    }
}

