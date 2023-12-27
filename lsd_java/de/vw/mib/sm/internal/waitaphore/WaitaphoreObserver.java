/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.waitaphore;

public interface WaitaphoreObserver {
    default public void response() {
    }

    default public void waitTimeout() {
    }

    default public void errorTimeout() {
    }
}

