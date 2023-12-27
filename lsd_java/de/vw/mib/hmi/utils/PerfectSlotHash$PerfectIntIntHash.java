/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.PerfectSlotHash;

class PerfectSlotHash$PerfectIntIntHash
extends PerfectSlotHash {
    private final int[] keys;
    private final int[] data;
    private final int size;

    public PerfectSlotHash$PerfectIntIntHash(int[] nArray, int[] nArray2) {
        this.keys = nArray;
        this.data = nArray2;
        this.size = nArray.length;
    }

    @Override
    public int getSlot(int n) {
        int n2 = this.data[PerfectSlotHash$PerfectIntIntHash.H0(n) % this.size];
        int n3 = n2 < 0 ? n2 + this.size : PerfectSlotHash$PerfectIntIntHash.H1(n2, n) % this.size;
        return this.keys[n3] == n ? n3 : -1;
    }
}

