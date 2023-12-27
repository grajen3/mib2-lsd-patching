/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.PerfectSlotHash;

class PerfectSlotHash$BinaryShortHash
extends PerfectSlotHash {
    private final short[] keys;

    public PerfectSlotHash$BinaryShortHash(short[] sArray) {
        this.keys = sArray;
    }

    @Override
    public int getSlot(int n) {
        int n2 = 0;
        int n3 = this.keys.length - 1;
        while (n2 <= n3) {
            int n4 = n2 + n3 >> 1;
            if (n > this.keys[n4]) {
                n2 = n4 + 1;
                continue;
            }
            if (n == this.keys[n4]) {
                return n4;
            }
            n3 = n4 - 1;
        }
        return -1;
    }
}

