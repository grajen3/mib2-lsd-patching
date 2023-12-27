/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm;

public interface StatemachineDiagnose {
    default public int getStatemachineCount() {
    }

    default public int getCurrentMainId(int n) {
    }

    default public int getCurrentSubSmIdForTopSmId(int n) {
    }

    default public int getCurrentStateIdForTopSmId(int n) {
    }

    default public int[] getCurrentlyActiveMainStatemachineIDs() {
    }
}

