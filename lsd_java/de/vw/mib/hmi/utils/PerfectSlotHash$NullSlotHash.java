/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.PerfectSlotHash;

final class PerfectSlotHash$NullSlotHash
extends PerfectSlotHash {
    PerfectSlotHash$NullSlotHash() {
    }

    @Override
    public int getSlot(int n) {
        return -1;
    }
}

