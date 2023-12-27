/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.PerfectSlotHash;

class PerfectSlotHash$PerfectIntShortHash
extends PerfectSlotHash {
    private final int[] keys;
    private final short[] data;
    private final int size;

    public PerfectSlotHash$PerfectIntShortHash(int[] nArray, short[] sArray) {
        this.keys = nArray;
        this.data = sArray;
        this.size = nArray.length;
    }

    @Override
    public int getSlot(int n) {
        short s = this.data[PerfectSlotHash$PerfectIntShortHash.H0(n) % this.size];
        int n2 = s < 0 ? s + this.size : PerfectSlotHash$PerfectIntShortHash.H1(s, n) % this.size;
        return this.keys[n2] == n ? n2 : -1;
    }
}

