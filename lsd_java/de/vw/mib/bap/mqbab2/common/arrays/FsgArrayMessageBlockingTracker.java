/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;

public interface FsgArrayMessageBlockingTracker {
    default public void reset() {
    }

    default public boolean requestGetArray(BAPGetArray bAPGetArray) {
    }

    default public void reportChangedArray(BAPChangedArray bAPChangedArray) {
    }

    default public void reportStatusArray(BAPStatusArray bAPStatusArray) {
    }

    default public void requestAcknowledge() {
    }

    default public void indicationError(int n) {
    }
}

