/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface BAPArrayListIDGenerator {
    default public int createBAPPosID(BAPArrayElement bAPArrayElement, long l) {
    }

    default public boolean isBAPPosIDValid(int n, long l) {
    }

    default public boolean isLongID() {
    }
}

